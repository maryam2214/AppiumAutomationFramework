package dev.mobile.framework.support.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Properties;

public class ConfigReader {
    Properties envConfig;
    Logger log = LoggerFactory.getLogger(ConfigReader.class);

    public ConfigReader() {
        File src = new File (System.getProperty("user.dir")+ "//src//test//resources//Config.properties");
        try {
            InputStream configFile = new FileInputStream(src);
            envConfig = new Properties();
            envConfig.load(configFile);
        }
        catch (FileNotFoundException e)
        {
            log.error("Exception is " + e.getMessage());

        } catch (IOException e) {
            log.error("Exception is " + e.getMessage());
            e.printStackTrace();
        }
    }

    public String getBaseUrl() { return envConfig.getProperty("baseUrl"); }

    public String getWebUserName() { return envConfig.getProperty("web_username"); }

    public String getWebPassword() { return envConfig.getProperty("web_password"); }

    public String getUserName() { return envConfig.getProperty("username"); }

    public String getPassword() { return envConfig.getProperty("password"); }

    public String getDevice() { return envConfig.getProperty("device");}

    public String getBrowserPath() { return envConfig.getProperty("browserPath");}
}
