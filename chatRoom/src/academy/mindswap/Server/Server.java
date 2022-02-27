package academy.mindswap.Server;

import academy.mindswap.Server.Commands.Commands;
import academy.mindswap.Server.Messages.*;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private ServerSocket serverSocket;
    private ExecutorService executorService;
    private final List<ClientConnectionHandler> clients;

    public Server() {
        clients = new CopyOnWriteArrayList<>();
    }

    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        executorService = Executors.newCachedThreadPool();
        int numberOfConnections = 0;

        while (true) {
            acceptConnection(numberOfConnections);
            ++numberOfConnections;
        }
    }


    public void acceptConnection(int numberOfConnections) throws IOException {
        ClientConnectionHandler clientConnectionHandler =
                new ClientConnectionHandler(serverSocket.accept(),
                        Messages.DEFAULT_NAME + numberOfConnections);


        executorService.submit(clientConnectionHandler);
    }

    private void addClient(ClientConnectionHandler clientConnectionHandler){
        clients.add(clientConnectionHandler);
        clientConnectionHandler.send(Messages.WELCOME);
        broadcast(clientConnectionHandler.getName(), Messages.CLIENT_ENTERED_CHAT);
    }


    public void broadcast(String name, String message){
        clients.stream()
                .filter(c -> !c.getName().equals(name))
                .forEach(c -> c.send(name + ": " + message));
    }

    public String listClients() {
        StringBuffer buffer = new StringBuffer();
        clients.forEach(client -> buffer.append(client.getName()).append("\n"));
        return buffer.toString();
    }

    public void removeClient(ClientConnectionHandler clientConnectionHandler) {
        clients.remove(clientConnectionHandler);

    }

    public Optional<ClientConnectionHandler> getClientByName(String name) {
        return clients.stream()
                .filter(clientConnectionHandler -> clientConnectionHandler.getName().equalsIgnoreCase(name))
                .findFirst();
    }



    public class ClientConnectionHandler implements Runnable {

        private String name;
        private Socket clientSocket;
        private BufferedWriter out;
        private String message;

        public ClientConnectionHandler(Socket clientSocket, String name) throws IOException {
            this.name = name;
            this.clientSocket = clientSocket;
            this.out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        }

        @Override
        public void run() {
            addClient(this);

            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                while (!clientSocket.isClosed()) {
                    message = in.readLine();

                    if (isCommand(message)) {
                        dealWithCommand(message);
                        continue;
                    }

                    if (message == "") {
                        return;
                    }

                    broadcast(name, message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                removeClient(this);
            }

        }

        private boolean isCommand(String message) {
            return message.startsWith("/");
        }

        private void dealWithCommand(String message) throws IOException {
            String description = message.split(" ")[0];
            Commands command = Commands.getCommandFromDescription(description);

            if (command == null) {
                out.write(Messages.NO_SUCH_COMMAND);
                out.newLine();
                out.flush();
            }

            command.getHandler().execute(Server.this, this);

        }

        public void send(String message) {
            try {
                out.write(message);
                out.newLine();
                out.flush();
            } catch (IOException e) {
                removeClient(this);
                e.printStackTrace();
            }
        }

        public void close() {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public String getName() {
            return name;
        }

        public String getMessage() {
            return message;
        }

    }
}
