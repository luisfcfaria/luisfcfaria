package academy.mindswap;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        ServerSocket serverSocket = new ServerSocket(8085);

        while (true){
            Socket socket = serverSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String line = in.readLine();
            System.out.println(line);
            String response = "<!DOCTYPE html><body>hi from server< /body>";
            String header = " HTTP/1.1 200 OK\r\n" +
                    "Content-Type: text/html\r\n"+
                    "Content-Length: " + response.length() + """
                    Connection: close 
                    """;
            out.writeBytes(header);
            out.writeBytes(response);
            socket.close();

        }
    }
}
