package ml.express_016.DBJ;

import io.github.cdimascio.dotenv.Dotenv;
import ml.express_016.DBJ.events.SlashCommandInteraction;
import ml.express_016.DBJ.handler.CommandsList;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;


public class Bot {
    public static void main(String[] arguments) throws Exception {
        Dotenv dotenv = Dotenv.load();
        JDA api = JDABuilder.createDefault(dotenv.get("TOKEN")).build();
        api.awaitReady();
        CommandsList.registerCommands(api, dotenv.get("GUILD_ID"));
        api.addEventListener(new SlashCommandInteraction());
    }
}