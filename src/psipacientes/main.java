/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psipacientes;

import BD.querysDB;
import PDF.GeneratePDF;
import Views.LoginView;
import Views.addPacienteView;
import Views.menuView;
import Views.pacientesView;
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
        //========================
        motor m = new motor();
        //==========================
        querysDB querys = new querysDB();
        LoginView login = new LoginView();
        menuView menuv = new menuView();
        addPacienteView addPaciente = new addPacienteView();
        pacientesView pacientesv = new pacientesView();
        principalView principal = new principalView();
        GeneratePDF pdf = new GeneratePDF();
        
        
        m.setMenuView(menuv);
        m.setQuerysDB(querys);
        m.setLoginView(login);
        m.setAddPacienteView(addPaciente);
        m.setPacientesView(pacientesv);
        m.setPrincipalView(principal);
        m.setPDF(pdf);
        pdf.setMotor(m);
        principal.setMotor(m);
        pacientesv.setMotor(m);
        addPaciente.SetMotor(m);
        querys.setMotor(m);
        menuv.setMotor(m);
        login.setMotor(m);
        
       m.openLogin();
        
        
    }
    
}
