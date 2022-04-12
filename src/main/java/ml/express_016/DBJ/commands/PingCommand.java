package ml.express_016.DBJ.commands;

import ml.express_016.DBJ.handler.CommandBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import org.jetbrains.annotations.NotNull;

public class PingCommand extends CommandBuilder {
    public PingCommand() {
        setCommandData(Commands.slash("ping", "pong"));
    }

    @Override
    public void executeCommand(@NotNull SlashCommandInteractionEvent event) {
        // get the ping of the bot
        long ping = event.getJDA().getGatewayPing();
        // send the ping to the channel
        event.reply("Pong! " + ping + "ms").queue();
    }
}