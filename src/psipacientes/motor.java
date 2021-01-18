/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package psipacientes;

import BD.conexionBD;
import Views.LoginView;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class motor {

    public motor()
    {

    }
    //==========SET CONEXIONES CON CLASES VIEW=============
    public void setConexionDB(conexionBD conexion)
    {
        this.conexion=conexion;
    }
    public void setLoginView(LoginView loginView)
    {
        this.loginView=loginView;
    }
    //=======================GET VISTA DE CLASES VIEW==============
    public void showConexionBD()
    {
        this.conexion.show();
    }
    public void showLoginView()
    {
        this.loginView.show();
    }
    
    //=================================
    private conexionBD conexion;
    private LoginView loginView;
}
