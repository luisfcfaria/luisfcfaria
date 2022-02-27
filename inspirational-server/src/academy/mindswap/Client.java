package academy.mindswap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Client {


    public static void main(String[] args) throws IOException {


        int portNumber = 8080;
        String hostName = "localhost";
        DatagramSocket socket = new DatagramSocket();


        byte[] message = "Hello World".getBytes();
        String input = "";

        while (!input.equals("exit")) {

//            if(!input.equals("HIT ME")){
//                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//                System.out.println("Unsupported operation!");
//
//            }

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter a message to send to server: ");
            input = br.readLine();
            message = input.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(message, message.length, InetAddress.getByName(hostName), portNumber);
            socket.send(sendPacket);
            System.out.println( "Message sent to the server: " + input);


            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(receivePacket);
            String modifiedSentence = new String(receivePacket.getData());
            System.out.println(modifiedSentence);



        }
    }
}
