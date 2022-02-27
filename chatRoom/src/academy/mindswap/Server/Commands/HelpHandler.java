package academy.mindswap.Server.Commands;

import academy.mindswap.Server.*;

public class HelpHandler implements CommandHandler {

    @Override
    public void execute(Server server, Server.ClientConnectionHandler clientConnectionHandler) {
        clientConnectionHandler.send(academy.mindswap.Server.Messages.COMMANDS_LIST);
    }


}