/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package psipacientes;

import BD.querysDB;
import Views.LoginView;
import Views.menuView;
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
    public void insertUsuario(String usuario, String password)
    {
        querys.insertUsuario(usuario, password);
    }
    public void deleteUsuario(String usuario,String password)
    {
        querys.deleteUsuario(usuario, password);
    }
    public void updateUsuario(String usuario, String password,String newUsuario,String newPassword)
    {
        querys.updateUsuario(usuario, password,newUsuario,newPassword);
    }
  public ResultSet searchUser()
  {
      return querys.searchUsuario();
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
    //=======================GET VISTA DE CLASES VIEW==============
    
    public void showLoginView()
    {
        this.loginView.show();
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
    public void closeMenu()
    {
        menuv.hide();
    }
    public void closeLogin()
    {
        loginView.hide();
    }
    //===========================================================================================
    private LoginView loginView;
    private querysDB querys;
    private menuView menuv;
}
