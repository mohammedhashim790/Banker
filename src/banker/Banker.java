/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banker;

import banker.Controller.Services.Session.Session;

/**
 *
 * @author Mohammed Hashim
 */
public class Banker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Session session = Session.getSession();

        session.execute();
//        System.out.println(sc.nextLine());
//        System.out.println(sc.nextLine());


    }
    
}
