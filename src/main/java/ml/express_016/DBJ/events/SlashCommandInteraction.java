package ml.express_016.DBJ.events;

import ml.express_016.DBJ.handler.CommandBuilder;
import ml.express_016.DBJ.handler.CommandsList;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class SlashCommandInteraction extends ListenerAdapter {

    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        CommandBuilder command = CommandsList.getCommands().get(event.getName());
        if (command == null) {
            event.reply("Command not found").queue();
            return;
        }

        if (!Objects.requireNonNull(event.getMember()).hasPermission(command.getRequiredUserPermissions())) {
            String[] permissionArray = command.getRequiredUserPermissions().stream().map(Permission::getName).toArray(String[]::new);
            event.reply("You don't have permission to use this command. Required Permissions: `" + String.join(", ", permissionArray) + "`").setEphemeral(true).queue();
            return;
        }
        command.executeCommand(event);
    }
}
