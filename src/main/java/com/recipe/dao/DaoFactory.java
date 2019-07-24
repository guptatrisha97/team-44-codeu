package com.recipe.dao;

import org.apache.geronimo.mail.handlers.MessageHandler;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class DaoFactory {

    private static Properties properties=null;

    static
    {
        // try loading the properties
        try {
            Properties prop = new Properties();
            String fileName = "dao.properties";
            InputStream in = MessageHandler.class.getClassLoader().getResourceAsStream(fileName);

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
    // return a UserDao class
    public static UserDao getUserDao() {
        /*
         * retrieve class name, create instance
         */

        try{
            Class clazz = Class.forName(properties.getProperty("dao.UserDao"));
            return (UserDao) clazz.newInstance();
        }catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}

