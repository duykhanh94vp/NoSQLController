package com.popeye.kvdb.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private static Config ourInstance = new Config();
    private Properties properties;

    public static Config getInstance() {
        return ourInstance;
    }

    private Config() {
        properties = new Properties();
        System.out.println(System.getProperty("user.dir"));
        try {
            InputStream inputStream = new FileInputStream("config/config.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String get(String key){
        return properties.getProperty(key, "");
    }
}
