/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bankapp;

import com.bankapp.Bloc.Reader.ConsoleReader;
import com.bankapp.Bloc.Reader.IReader;
import com.bankapp.Bloc.Reader.TextReader;

import java.io.File;

/**
 * @author Mohammed Hashim
 */
public class BankApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        IReader reader = null;
        try {
//            reader = new TextReader(new File("src/input.txt"));
            reader = new ConsoleReader();


            Application application = Application.getApplication();

            application.execute(reader);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
