package com.sensiblemetrics.api.alpenidos.pattern.hexagonal.mongo;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * Mongo connection properties loader
 */
public class MongoConnectionPropertiesLoader {
    private static final String DEFAULT_HOST = "localhost";
    private static final int DEFAULT_PORT = 27017;

    /**
     * Try to load connection properties from file.
     * Fall back to default connection properties.
     */
    public static void load() {
        String host = DEFAULT_HOST;
        int port = DEFAULT_PORT;
        final String path = System.getProperty("hexagonal.properties.path");
        final Properties properties = new Properties();
        if (path != null) {
            try (final FileInputStream fin = new FileInputStream(path)) {
                properties.load(fin);
                host = properties.getProperty("mongo-host");
                port = Integer.parseInt(properties.getProperty("mongo-port"));
            } catch (Exception e) {
                // error occurred, use default properties
                e.printStackTrace();
            }
        }
        System.setProperty("mongo-host", host);
        System.setProperty("mongo-port", String.format("%d", port));
    }
}
