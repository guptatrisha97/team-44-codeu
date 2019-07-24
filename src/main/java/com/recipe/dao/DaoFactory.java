package com.recipe.dao;

import java.io.InputStream;
import java.util.Properties;

public class DaoFactory {

    private static Properties properties;

    static
    {
        // add to properties
        try {
            InputStream in = DaoFactory.class.getClassLoader().getResourceAsStream("dao.properties");
            properties = new Properties();
            properties.load(in);
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

