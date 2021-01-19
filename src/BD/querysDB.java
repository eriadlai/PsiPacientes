/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import Views.LoginView;
import Views.menuView;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import psipacientes.motor;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class querysDB {

    public querysDB() {
        conector();
    }
    //====================CONEXION CON BASE DE DATOS====================================
    // Declaramos la conexion a mysql
    private static Connection con;
    private static PreparedStatement pst;
    private static ResultSet rs;
    // Declaramos los datos de conexion a la bd
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String user = "root";
    private static final String pass = "adlai1999";
    private static final String url = "jdbc:mysql://localhost:3306/pacientes?serverTimezone=America/Los_Angeles";

    public void setMotor(motor m) {
        this.m = m;
    }

    public void conector() {
        // Reseteamos a null la conexion a la bd
        con = null;
        try {
            Class.forName(driver);
            // Nos conectamos a la bd
            con = (Connection) DriverManager.getConnection(url, user, pass);
            // Si la conexion fue exitosa mostramos un mensaje de conexion exitosa
            if (con != null) {
                System.out.println("CONEXION ESTABLECIDA");
            }
        } // Si la conexion NO fue exitosa mostramos un mensaje de error
        catch (ClassNotFoundException | SQLException e) {
            System.out.println("ERROR AL CONECTAR");
        }
    }
//======================================================================================

    public void logeo(String usuario, String password) {
        try {
            String sql = "SELECT * FROM usuario WHERE user=? AND password =?";
            pst = con.prepareStatement(sql);
            pst.setString(1, usuario);
            pst.setString(2, password);
            rs = pst.executeQuery();
            if (rs.next()) {

                if (rs.getString("user").equals(usuario) && rs.getString("password").equals(password)) {
                    m.closeLogin();
                    m.openMenu();
                }

            } else {
                JOptionPane.showMessageDialog(null, "USUARIO Y/O PASSWORD INCORRECTOS");
            }

        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "USUARIO Y/O PASSWORD INCORRECTOS" + ex);
        }
    }
//======================================================================================

    public boolean insertPaciente(String nombre, String apellido, int edad, String nacimiento, String escolaridad,
            String religion, String ocupacion, String actExtra, String direccion, String telefono, String servicio, String asunto, String objetivo) {

        if (nombre.equals("") || apellido.equals("") || edad < 0 || nacimiento.equals("") || escolaridad.equals("")
                || religion.equals("") || ocupacion.equals("") || actExtra.equals("") || direccion.equals("") || telefono.equals("")
                || servicio.equals("") || asunto.equals("") || objetivo.equals("")) {
            JOptionPane.showMessageDialog(null, "NO DEJAR NINGUN CAMPO VACIO!");
            return false;
        } else {
            try {
                String sql2 = "SELECT * FROM cliente WHERE nombre=? AND apellido=?";
                pst = con.prepareStatement(sql2);
                pst.setString(1, nombre);
                pst.setString(2, apellido);
                rs = pst.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "ERROR AL AGREGAR, EL PACIENTE YA EXISTE.");
                    return false;
                }
                else{
                     String sql = "INSERT INTO cliente"
                                + "(nombre, apellido,edad,nacimiento,escolaridad,religion,ocupacion,actExtra,direccion,telefono,servicio,asunto,objetivo)"
                                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
                        pst = con.prepareStatement(sql);
                        pst.setString(1, nombre);
                        pst.setString(2, apellido);
                        pst.setInt(3, edad);
                        pst.setString(4, nacimiento);
                        pst.setString(5, escolaridad);
                        pst.setString(6, religion);
                        pst.setString(7, ocupacion);
                        pst.setString(8, actExtra);
                        pst.setString(9, direccion);
                        pst.setString(10, telefono);
                        pst.setString(11, servicio);
                        pst.setString(12, asunto);
                        pst.setString(13, objetivo);
                        pst.executeUpdate();
                        JOptionPane.showMessageDialog(null, "inserted successfully");
                        return true;
                }

            } catch (SQLException | HeadlessException ex) {
                JOptionPane.showMessageDialog(null, ex);
                return false;
            }
        }

    }

    public void deleteUsuario(String usuario, String password) {
        try {
            String sql = "DELETE FROM usuario WHERE user =? AND password=?";
            pst = con.prepareStatement(sql);
            pst.setString(1, usuario);
            pst.setString(2, password);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "delete successfully");
        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void updateUsuario(String user, String password, String newUser, String newPassword) {
        try {
            String sql = "UPDATE usuario SET user=?,password=? WHERE user=? AND password=?";
            pst = con.prepareStatement(sql);
            pst.setString(3, user);
            pst.setString(4, password);
            pst.setString(1, newUser);
            pst.setString(2, newPassword);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "updated successfully");
        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public ResultSet searchPacientes() {
        try {
            String sql = "SELECT * FROM cliente";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);

        }
        return rs;
    }
    //==============================================================

    //========================================================================================
    private motor m;
    private LoginView login;
    private menuView menuv;
}
