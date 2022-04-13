package ml.express_016.DBJ;

import ml.express_016.DBJ.events.SlashCommandInteraction;
import ml.express_016.DBJ.handler.CommandsList;
import ml.express_016.DBJ.handler.Config;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;


public class Bot {
    public static void main(String[] arguments) throws Exception {
        Config config = new Config();
        JDA api = JDABuilder.createDefault(config.get("TOKEN")).build();
        api.awaitReady();
        CommandsList.registerCommands(api, config.get("GUILD_ID"));
        api.addEventListener(new SlashCommandInteraction());
    }
}