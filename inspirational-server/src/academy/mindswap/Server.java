package academy.mindswap;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


public class Server {

    public static void main(String[] args) throws IOException {

        int portNumber = 8080;
        String hostName = "localhost";
        DatagramSocket socket = new DatagramSocket(portNumber);
        byte[] rcvBuffer = new byte[1024];


        while (socket.isBound()) {

            DatagramPacket receivedPacket = new DatagramPacket(rcvBuffer, rcvBuffer.length);
            System.out.println();
            socket.receive(receivedPacket);

            String receivedString = new String(receivedPacket.getData(),0,receivedPacket.getLength());
            System.out.println("Received: " + receivedString);


            InetAddress adress = receivedPacket.getAddress();
            int port = receivedPacket.getPort();

            if(receivedString.equals("exit")){
                String response = "Bye bye!";
                byte[] responseBytes = response.getBytes();
                DatagramPacket datagramPacket = new DatagramPacket(responseBytes, responseBytes.length, adress, port);
                socket.send(datagramPacket);
            }

            if(!receivedString.equals("HIT ME")){

                String response = "Unsupported operation";
                byte[] responseBytes = response.getBytes();
                DatagramPacket responsePacket = new DatagramPacket(responseBytes, responseBytes.length, adress, port);
                socket.send(responsePacket);
                continue;
            }

            String response = Server.getMessage();
            byte[] responseBytes = response.getBytes();
            DatagramPacket responsePacket = new DatagramPacket(responseBytes, responseBytes.length, adress, port);
            socket.send(responsePacket);

        }


    }

    private static String getMessage() throws IOException {

        List<String> messages = Files.readAllLines(Path.of("src/academy/mindswap/Responses.txt"));
        int randomNumber = (int) (Math.random() * messages.size()-1) ;

        return messages.get(randomNumber);
        }

    }

