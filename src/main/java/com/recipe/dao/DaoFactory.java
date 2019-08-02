package com.recipe.dao;

import org.apache.geronimo.mail.handlers.MessageHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class DaoFactory {

    private static Properties properties=null;

    static
    {
        // try loading the properties
        try {
            Properties prop = new Properties();
            String fileName = "dao.properties";
            InputStream in = DaoFactory.class.getClassLoader().getResourceAsStream(fileName);

            // error handeling
            if (in != null) {
                prop.load(in);
            }else{
                throw new FileNotFoundException("property file " + fileName + " not found");
            }
            // InputStream in = MessageHandler.class.getClassLoader().getResourceAsStream("dao.properties");
            // properties prop = new Properties();
            // properties.load(in);
        }catch (Exception e)
        {
            throw new RuntimeException("Error Here: " + e);
        }
    }

    public static UserDao getUserDao() {
        /*
         * create instance
         */
        try{
            String fileName = "UserDao";
            InputStream in2 = DaoFactory.class.getClassLoader().getResourceAsStream(fileName);

            if (in2 != null) {
                Class clazz = Class.forName(properties.getProperty("dao.UserDao"));
                return (UserDao) clazz.newInstance();
            }else{
                throw new FileNotFoundException(fileName + " not found !!!");
            }
        }catch (Exception e) {
            throw new RuntimeException("Cannot get user dao: " + e);
        }

    }

}
