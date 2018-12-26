package com.github.wz2cool.javaRedisLearning.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyManager {
    private static PropertyManager instance = new PropertyManager();

    public static PropertyManager getInstance() {
        return instance;
    }

    private final Properties properties;

    private PropertyManager() {
        properties = loadProperties();
    }

    private Properties loadProperties() {
        Properties propertiesFromFile = new Properties();
        try (InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties")) {
            propertiesFromFile.load(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return propertiesFromFile;
    }

    public String getRedisHost() {
        return this.properties.getProperty("redis.host");
    }

    public String getRedisPort() {
        return this.properties.getProperty("redis.port");
    }

}
