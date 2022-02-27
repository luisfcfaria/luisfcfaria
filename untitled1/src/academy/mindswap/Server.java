package academy.mindswap;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8081);


        while (true) {

        Socket clientSocket = serverSocket.accept();

        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));


            while (!clientSocket.isClosed()) {
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String line = in.readLine();

            if( line.equals("exit")) {
                clientSocket.close();
                break;
            }
                System.out.println("Client sent: ".concat(line));

                String sMessage = in.readLine();
                out.write(sMessage);
                out.flush();


            }
        }

    }

}
