/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psipacientes;

import BD.querysDB;
import Views.LoginView;
import Views.menuView;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //========================
        motor m = new motor();
        //==========================
        querysDB querys = new querysDB();
        LoginView login = new LoginView();
        menuView menuv = new menuView();
        
        m.setMenuView(menuv);
        m.setQuerysDB(querys);
        m.setLoginView(login);
        querys.setMotor(m);
        menuv.setMotor(m);
        login.setMotor(m);
        
       m.openLogin();
        
        
    }
    
}
