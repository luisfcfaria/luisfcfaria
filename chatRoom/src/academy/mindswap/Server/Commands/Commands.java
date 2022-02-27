package academy.mindswap.Server.Commands;

public enum Commands {

        LIST("/list", new ListHandler()),
        HELP("/help", new HelpHandler()),
        WHISPER("/whisper", new WhisperHandler()),
        QUIT("/quit", new QuitHandler());
        //SHOUT("/shout", new ShoutHandler());

        private String description;
        private CommandHandler handler;

        Commands(String description, CommandHandler handler) {
            this.description = description;
            this.handler = handler;
        }

        public static Commands getCommandFromDescription(String description) {
            for (Commands command : values()) {
                if (description.equals(command.description)) {
                    return command;
                }
            }
            return null;
        }

        public CommandHandler getHandler() {
            return handler;
        }
    }
