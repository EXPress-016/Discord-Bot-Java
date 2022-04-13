package ml.express_016.DBJ.handler;

import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.utils.data.DataObject;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileInputStream;

public class Config {
    File configFile;

    public String get(@NotNull String key) throws Exception {
        // Env
        if (System.getenv(key.toUpperCase()) != null) {
            return System.getenv(key.toUpperCase());
        }
        // Dotenv
        configFile = new File(".env");
        if (configFile.exists()) {
            Dotenv config = Dotenv.load();
            return config.get(key.toUpperCase());
        }
        // Json
        configFile = new File("config.json");
        if (configFile.exists()) {
            DataObject config = DataObject.fromJson(new FileInputStream(configFile));
            return config.get(key.toUpperCase()).toString();
        }
        throw new Exception("No config file or value found");
    }
}
