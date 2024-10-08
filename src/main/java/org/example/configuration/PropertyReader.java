package org.example.configuration;

import org.example.utilities.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    private static PropertyReader propertyReader = null;
    private static final Properties properties;
    private static final String FILE_PATH = System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"+File.separator+"java"+File.separator+"test"+File.separator+"data"+File.separator+Utils.getEnvironment()+File.separator+"configuration.properties";

    private PropertyReader() {

    }

    static {

        File file = new File(FILE_PATH);
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            properties = new Properties();
            properties.load(fileInputStream);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static PropertyReader getInstance() {

        if(propertyReader == null) {
            propertyReader = new PropertyReader();
        }
        return propertyReader;
    }

    /**
     * This method use to get the value from property file by passing parameter
     * @param  key
     * @return - the value if value presents in the properties file.
     */
    public String getValue(String key) {

        String value = null;
        try {
            value =  properties.getProperty(key);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return value;
    }

}
