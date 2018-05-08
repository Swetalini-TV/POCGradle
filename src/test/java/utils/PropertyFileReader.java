package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileReader {
    private Properties properties;
    private String searchAPI = "";
    private String channelAPI = "";

    public PropertyFileReader() {
        this.properties = new Properties();
        readPropertyFile();
    }

    public void readPropertyFile() {
        File file = new File("src/apis.properties");
        try {
            properties.load(new FileInputStream(file));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getSearchAPI() {
        return searchAPI = properties.getProperty("searchAPI");
    }

    public String getChannelAPI() {
        return channelAPI = properties.getProperty("channelAPI");
    }
}
