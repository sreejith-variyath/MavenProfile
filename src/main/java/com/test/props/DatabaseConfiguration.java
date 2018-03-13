package com.test.props;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created  on 3/13/2018.
 */
public class DatabaseConfiguration {
    private String hostname;
    private String port;
    private String username;
    private String password;
    private String schema;

    private static DatabaseConfiguration instance;

    public String getSchema() {
        return schema;
    }


    public String getHostname() {
        return hostname;
    }


    public String getPort() {
        return port;
    }


    public String getUsername() {
        return username;
    }


    public String getPassword() {
        return password;
    }

    public static DatabaseConfiguration getInstance() {
        if (instance == null) {
            synchronized (DatabaseConfiguration.class) {
                if (instance == null) {
                    instance = new DatabaseConfiguration();
                    instance.initialize();
                }
            }
        }
        return instance;
    }

    private void initialize() {
        try {
            Properties prop = new Properties();
            String propFileName = "config.properties";
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
            hostname = prop.getProperty("hostname");
            port = prop.getProperty("port");
            username = prop.getProperty("username");
            password = prop.getProperty("password");
            schema = prop.getProperty("schema");
        } catch (Exception ex) {

        }


    }
}
