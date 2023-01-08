package com.bankapp.Bloc.Wrapper;

import com.bankapp.Application;

import java.util.logging.Level;
import java.util.logging.Logger;

public class printer {

    private static Logger logger = Logger.getLogger(Application.class.getName());

    public static void print(Object title){
//        System.out.println(title.toString());
        logger.log(Level.INFO,title.toString());

    }

    public static void print(Object title,Object message){
//        System.out.println(String.format("%s %s", title.toString(),message.toString()));
        logger.log(Level.INFO,String.format("%s %s", title.toString(),message.toString()));
    }

    public static void warning(Object title,Object message){
//        System.out.println(String.format("%s %s", title.toString(),message.toString()));
        logger.log(Level.WARNING,String.format("%s %s", title.toString(),message.toString()));
    }

    public static void warning(Object message){
//        System.out.println(String.format("%s %s", title.toString(),message.toString()));
        logger.log(Level.WARNING,String.format("%s", message.toString()));
    }






    public static void error(Object title){
//        System.err.println(title.toString());
        logger.log(Level.SEVERE,title.toString());
    }
}
