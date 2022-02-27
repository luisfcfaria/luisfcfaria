package academy.mindswap;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Main {

    public static void main(String[] args) throws IOException {

        int portNumber = 8080;
        String hostName = "localhost";
        DatagramSocket socket = new DatagramSocket(portNumber);


	// write your code here
//CREATE DATAGRAM AND SEND IT FROM THE SOCKET
        byte[] message = "Hello World".getBytes();
        DatagramPacket sendPacket = new DatagramPacket (message, message.length, InetAddress.getByName(hostName), portNumber);
        socket.send(sendPacket);


// CREATE A DATAGRAM PACKET AND RECEIVE DATA FROM THE SOCKET
        byte[] rcvBuffer = new byte[1024];
        DatagramPacket receivedPacket = new DatagramPacket(rcvBuffer, rcvBuffer.length);
        InetAddress adress = receivedPacket.getAddress();
        socket.receive(receivedPacket);


        String receivedString = new String(receivedPacket.getData(),0, receivedPacket.getLength());
        System.out.println("Received: " + receivedString);

// CLOSE THE SOCKET
        socket.close();
    }
}
