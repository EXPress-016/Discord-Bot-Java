package ml.express_016.DBJ.handler;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class CommandBuilder {
    private SlashCommandData commandData;
    private final List<Permission> userRequiredPermissions = new ArrayList<>();

    public void setCommandData(SlashCommandData commandData) {
        this.commandData = commandData;
    }

    public String getName() {
        return commandData.getName();
    }

    public String getDescription() {
        return commandData.getDescription();
    }

    public void setUserRequiredPermissions(Permission... permissions) {
        userRequiredPermissions.addAll(Arrays.asList(permissions));
    }

    public List<Permission> getRequiredUserPermissions() {
        return userRequiredPermissions;
    }

    public SlashCommandData getCommandData() {
        return commandData;
    }

    public abstract void executeCommand(SlashCommandInteractionEvent event);
}
