package academy.mindswap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.channels.SocketChannel;

public class Client {

    public static void main(String[] args) throws IOException {


        Socket clientSocket = new Socket( "localhost", 8081);


        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
        BufferedReader in = new BufferedReader( new InputStreamReader(System.in));
        BufferedReader serverMessage = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        while (!clientSocket.isClosed()) {

            String message = in.readLine();
            out.write(message);
            out.write(System.lineSeparator());
            out.flush();
            System.out.println("Waiting server response...");

            //SERVER RESPONSE

            String newMessage = serverMessage.readLine();
            out.write(newMessage);
            System.out.println("Server sent: ".concat(newMessage));


        }

        clientSocket.close();

    }

}
