package ml.express_016.DBJ.handler;

import ml.express_016.DBJ.commands.PingCommand;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;

import java.util.HashMap;

public class CommandsList {
    private static final HashMap<String, CommandBuilder> commands = new HashMap<>();

    public static void add(String name, CommandBuilder command) {
        commands.put(name, command);
    }

    public static HashMap<String, CommandBuilder> getCommands() {

        return commands;
    }

    public static void addCommandsToList() {
        CommandsList.add(new PingCommand().getName(), new PingCommand());
    }

    public static void registerCommands(JDA api, String GUILD_ID) {
        Guild mainGuild = api.getGuildById(GUILD_ID);
        assert mainGuild != null;
        addCommandsToList();
        CommandListUpdateAction ListOfCommands = mainGuild.updateCommands();
        for (CommandBuilder command : getCommands().values()) {
            ListOfCommands.addCommands(command.commandData);
        }
        ListOfCommands.queue();
    }
}
