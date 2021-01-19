/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package psipacientes;

import BD.querysDB;
import Views.LoginView;
import Views.addPacienteView;
import Views.menuView;
import Views.pacientesView;
import java.sql.ResultSet;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class motor {

    public motor()
    {

    }
    //================QUERYS==========================
    public void setQuerysDB(querysDB querys)
    {
        this.querys=querys;
    }
    public void setConexion()
    {
        querys.conector();
    }
    //=======USUARIO========
    public void logeo(String usuario,String Password)
    {
        querys.logeo(usuario, Password);
    }
    public boolean insertPaciente(String nombre, String apellido, int edad, String nacimiento, String escolaridad,
            String religion, String ocupacion, String actExtra, String direccion, String telefono, String servicio, String asunto, String objetivo)
    {
        if ( querys.insertPaciente(nombre, apellido, edad, nacimiento, escolaridad, religion, ocupacion, actExtra, direccion, telefono, servicio, asunto, objetivo)) {
           
            return true;
        }
        else
        {
            return false;
        }
        
    }
    public void deleteUsuario(String usuario,String password)
    {
        querys.deleteUsuario(usuario, password);
    }
    public void updateUsuario(String usuario, String password,String newUsuario,String newPassword)
    {
        querys.updateUsuario(usuario, password,newUsuario,newPassword);
    }
  public ResultSet searchPacientes()
  {
      
      return querys.searchPacientes();
  }
    //==========SET CONEXIONES CON CLASES VIEW=============
    
    public void setLoginView(LoginView loginView)
    {
        this.loginView=loginView;
    }
    public void setMenuView(menuView menuv)
    {
        this.menuv=menuv;
    }
    public void setAddPacienteView(addPacienteView addPaciente)
    {
        this.addPaciente=addPaciente;
    }
    public void setPacientesView(pacientesView pacientesv)
    {
        this.pacientesv=pacientesv;
    }
    //=============ABRIR Y CERRAR VENTANAS====================
     public void openMenu()
    {
        menuv.show();
    }
    public void openLogin()
    {
        loginView.show();
    }
    public void openAddPaciente()
    {
        addPaciente.show();
    }
    public void openPacientes()
    {
        pacientesv.show();
    }
    public void closePacientes()
    {
        pacientesv.hide();
    }
    public void closeAddPaciente()
    {
        addPaciente.hide();
    }
    public void closeMenu()
    {
        menuv.hide();
    }
    public void closeLogin()
    {
        loginView.hide();
    }
    //===========================================================================================
    public String getFecha(String d, String m, String y)
    {
        
        String fecha= (d+"/"+m+"/"+y);
        return fecha;
    }
    //===========================================================================================
    private LoginView loginView;
    private querysDB querys;
    private menuView menuv;
    private addPacienteView addPaciente;
    private pacientesView pacientesv;
}
