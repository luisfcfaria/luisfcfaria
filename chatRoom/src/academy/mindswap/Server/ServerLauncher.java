package academy.mindswap.Server;


import academy.mindswap.Server.Server;

import java.io.IOException;

public class ServerLauncher {

    public static void main(String[] args) {
	// write your code here
        Server server = new Server();

        try {
            server.start(8080);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
