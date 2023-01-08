package com.bankapp.Bloc.Wrapper;


import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * Class Constant
 *
 * Constant Class to store constant values as It can be modified only by admin/programmers
 *
 */
public final class Constants {


    public static Properties properties;

    static {
        try {
            properties = loadProperties();
            printer.print("Properties Onboarded");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Properties loadProperties() throws Exception {
        InputStream input = new FileInputStream("src/config.properties");
        Properties prop = new Properties();

        // load a properties file
        prop.load(input);

        return prop;

    }


    public static final Double MIN_BALANCE = Double.parseDouble(getProperty("app.MIN_BALANCE"));

    public static final Double MAX_BALANCE = Double.parseDouble(getProperty("app.MAX_BALANCE"));

    public static final Double MIN_DEPOSITS = Double.parseDouble(getProperty("app.MIN_DEPOSITS"));
    public static final Double MAX_DEPOSITS = Double.parseDouble(getProperty("app.MAX_DEPOSITS"));

    public static final Double MIN_WITHDRAWAL = Double.parseDouble(getProperty("app.MIN_WITHDRAWAL"));
    public static final Double MAX_WITHDRAWAL = Double.parseDouble(getProperty("app.MAX_WITHDRAWAL"));


    public static Integer MAX_DEPOSITS_LIMIT = Integer.parseInt(getProperty("app.MAX_DEPOSITS_LIMIT"));
    public static Integer MAX_WITHDRAW_LIMIT = Integer.parseInt(getProperty("app.MAX_WITHDRAW_LIMIT"));


    public static Integer FIXED_ACCOUNT_TENURE = Integer.parseInt(getProperty("app.FIXED_ACCOUNT_TENURE"));
    public static Double FIXED_ACCOUNT_RI = Double.parseDouble(getProperty("app.FIXED_ACCOUNT_RI"));





    private static String getProperty(String key){
        return (properties.getProperty(key));
    }






}
