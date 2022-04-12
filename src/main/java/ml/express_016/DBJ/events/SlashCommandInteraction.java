package ml.express_016.DBJ.events;

import ml.express_016.DBJ.handler.CommandBuilder;
import ml.express_016.DBJ.handler.CommandsList;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class SlashCommandInteraction extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        CommandBuilder command = CommandsList.getCommands().get(event.getName());
        if (command != null) {
            command.executeCommand(event);
        } else {
            event.reply("Command not found").queue();
        }
    }
}
