/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psipacientes;

import BD.querysDB;
import PDF.GeneratePDF;
import Views.LoginView;
import Views.menuView;
import Views.principalView;

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
        //========INICIAR MOTOR LOGICA================
        motor m = new motor();
        //========INICIAR QUERYS LOGICA==================
        querysDB querys = new querysDB();
        //===========INICIAR VIEWS====================
        LoginView login = new LoginView();
        menuView menuv = new menuView();
        principalView principal = new principalView();
        //==========INICIAR GENERACION DE PDF=================================
        GeneratePDF pdf = new GeneratePDF();
        //=================ESTABLECER CONEXIONES ENTRE VIEWS Y MOTOR========
        m.setMenuView(menuv);
        m.setQuerysDB(querys);
        m.setLoginView(login);
        m.setPrincipalView(principal);
        m.setPDF(pdf);
        pdf.setMotor(m);
        principal.setMotor(m);
        querys.setMotor(m);
        menuv.setMotor(m);
        login.setMotor(m);
       //===========INICIAR PROGRAMA================================================================
        m.openLogin();

    }

}
