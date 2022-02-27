package academy.mindswap.Server.Commands;

import academy.mindswap.Server.Server;

public interface CommandHandler {


        void execute(Server server, Server.ClientConnectionHandler clientConnectionHandler);
}
