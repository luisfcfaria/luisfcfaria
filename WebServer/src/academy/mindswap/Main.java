package academy.mindswap;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
	// write your code here

    }

    public void start(int port) throws IOException {
        ServerSocket socket = new ServerSocket(port);
        Socket ServerSocket = socket.accept();
    }
}
