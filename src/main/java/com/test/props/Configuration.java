package com.test.props;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by sreejith on 3/20/2018.
 */
public class Configuration {
    
    private static Configuration config;
    private Properties props;

    public static Configuration getInstance() {
        if (config == null) {
            synchronized (DatabaseConfiguration.class) {
                if (config == null) {
                    config = new Configuration();
                    config.initialize();
                }
            }
        }
        return config;
    }

    private void initialize() {
        try {
            props = new Properties();
            String propFileName = "config.properties";
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
            if (inputStream != null) {
                props.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

        } catch (Exception ex) {
            System.out.println("Exception" + ex);
        }

    }

    public String getSystemValue(String key) {
        return props.getProperty(key);
    }
}
