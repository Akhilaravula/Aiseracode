package main.java.utilis;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

public class ConfigReader {
    private static Properties properties;

    static
    {
        try (FileInputStream input = new FileInputStream("src/test/resource/config.properties")) {
            properties = new Properties();
            properties.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

        public static String getProperty(String key)
        {
            return properties.getProperty(key);
        }

}
