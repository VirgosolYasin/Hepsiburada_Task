package com.hepsiburada.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {


    static Properties properties = new Properties();

    static {

        try{

            FileInputStream file = new FileInputStream("configuration.properties");
            properties.load(file);
            file.close();

        }catch (IOException exp){

            System.out.println("config properties problem!!!");
        }



    }


    public static String getProperty(String keyword) {

        return properties.getProperty(keyword);

    }


}
