/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import Views.LoginView;
import Views.menuView;
import Views.pacientesView;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
            String religion, String ocupacion, String actExtra, String direccion, String telefono, String servicio, String asunto) {

        String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        
        if (nombre.equals("") || apellido.equals("") || edad < 0 || nacimiento.equals("") || escolaridad.equals("")
                || religion.equals("") || ocupacion.equals("") || actExtra.equals("") || direccion.equals("") || telefono.equals("")
                || servicio.equals("") || asunto.equals("")) {
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
                } else {
                    String sql = "INSERT INTO cliente"
                            + "(nombre, apellido,edad,nacimiento,escolaridad,religion,ocupacion,actExtra,direccion,telefono,servicio,asunto,objetivo,fecha)"
                            + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
                    pst.setString(13, "");
                    pst.setString(14, date);
                    pst.executeUpdate();
                    setDatosPaciente(buscarId(nombre, apellido));
                    JOptionPane.showMessageDialog(null, "inserted successfully");
                    return true;
                }

            } catch (SQLException | HeadlessException ex) {
                JOptionPane.showMessageDialog(null, ex);
                return false;
            }
        }

    }
public boolean insertFamiliar(int id,String nombre,String apellido, String parentesco, int edad, String ocupacion)
    {
        if (nombre.equals("") || apellido.equals("")||parentesco.equals("") || edad == 0 || ocupacion.equals("")) {
            JOptionPane.showMessageDialog(null, "NO DEJAR NINGUN CAMPO VACIO!");
            return false;
        } else {
            try {
                String sql2 = "SELECT * FROM funcfamiliar WHERE nombre=? AND apellido=? AND clienteID=?";
                pst = con.prepareStatement(sql2);
                pst.setString(1, nombre);
                pst.setString(2, apellido);
                pst.setInt(3, id);
                rs = pst.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "ERROR AL AGREGAR, EL FAMILIAR YA EXISTE.");

                    return false;
                } else {
                    String sql = "INSERT INTO funcfamiliar"
                            + "(clienteID,nombre,apellido,parentesco,edad,ocupacion)"
                            + "VALUES (?,?,?,?,?,?)";
                    pst = con.prepareStatement(sql);

                    pst.setInt(1, id);
                    pst.setString(2, nombre);
                    pst.setString(3, apellido);
                    pst.setString(4, parentesco);
                    pst.setInt(5, edad);
                    pst.setString(6, ocupacion);
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
    public int buscarId(String nombre, String apellido) {
        try {
            String sql2 = "SELECT id FROM cliente WHERE nombre=? AND apellido=?";
            pst = con.prepareStatement(sql2);
            pst.setString(1, nombre);
            pst.setString(2, apellido);
            rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex);

        }
        return 0;
    }

    public void setDatosPaciente(int id) {
        try {
            String sql = "INSERT INTO problema"
                    + "(evolucion,causas,acciones,implicaciones,clienteID)"
                    + "VALUES (?,?,?,?,?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, "");
            pst.setString(2, "");
            pst.setString(3, "");
            pst.setString(4, "");
            pst.setInt(5, id);
            pst.executeUpdate();
            String sql2 = "INSERT INTO funcfamiliar"
                    + "(clienteID,nombre,parentesco,edad,ocupacion,apellido)"
                    + "VALUES (?,?,?,?,?,?)";
            pst = con.prepareStatement(sql2);
            pst.setString(5, "");
            pst.setString(2, "");
            pst.setInt(4, 0);
            pst.setString(3, "");
            pst.setInt(1, id);
            pst.setString(6, "");
            pst.executeUpdate();
            String sql3 = "INSERT INTO redsociales"
                    + "(clienteID,social,laboral,vivienda)"
                    + "VALUES (?,?,?,?)";
            pst = con.prepareStatement(sql3);
            pst.setString(2, "");
            pst.setString(3, "");
            pst.setString(4, "");
            pst.setInt(1, id);
            pst.executeUpdate();
            String sql4 = "INSERT INTO historiasexual"
                    + "(clienteID,abusoSexual,embarazo,edad,prefSexual,traumas,infoTraumas)"
                    + "VALUES (?,?,?,?,?,?,?)";
            pst = con.prepareStatement(sql4);
            pst.setString(2, "");
            pst.setString(3, "");
            pst.setInt(4, 0);
            pst.setString(5, "");
            pst.setString(6, "");
            pst.setString(7, "");
            pst.setInt(1, id);
            pst.executeUpdate();
            String sql5 = "INSERT INTO habitos"
                    + "(clienteID,dream,alimenticio,antPsicologicos)"
                    + "VALUES (?,?,?,?)";
            pst = con.prepareStatement(sql5);
            pst.setString(2, "");
            pst.setString(3, "");
            pst.setString(4, "");
            pst.setInt(1, id);
            pst.executeUpdate();
            String sql6 = "INSERT INTO antecedentesclinicos"
                    + "(clienteID,enfermedadGrave,accidentes,medicamento,intQuirurgica,dispAuxiliar)"
                    + "VALUES (?,?,?,?,?,?)";
            pst = con.prepareStatement(sql6);
            pst.setString(2, "");
            pst.setString(3, "");
            pst.setString(4, "");
            pst.setString(5, "");
            pst.setString(6, "");
            pst.setInt(1, id);
            pst.executeUpdate();
            String sql7 = "INSERT INTO antecedentesfamiliares"
                    + "(clienteID,psicologia,psiquiatra,patologia)"
                    + "VALUES (?,?,?,?)";
            pst = con.prepareStatement(sql7);
            pst.setString(2, "");
            pst.setString(3, "");
            pst.setString(4, "");
            pst.setInt(1, id);
            pst.executeUpdate();
            String sql8 = "INSERT INTO estadomental"
                    + "(clienteID,percepcionLenguaje,estadoEmocional,contactoRealidad,higienePersonal)"
                    + "VALUES (?,?,?,?,?)";
            pst = con.prepareStatement(sql8);
            pst.setString(2, "");
            pst.setString(3, "");
            pst.setString(4, "");
            pst.setString(5, "");
            pst.setInt(1, id);
            pst.executeUpdate();
            String sql9 = "INSERT INTO reportesesion"
                    + "(clienteID,diagnostico,observaciones)"
                    + "VALUES (?,?,?)";
            pst = con.prepareStatement(sql9);
            pst.setString(2, "");
            pst.setString(3, "");
            pst.setInt(1, id);
            pst.executeUpdate();

        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void deletePaciente(int id) {
        String nombre = getNombre(id);
        String apellido = getApellido(id);
        int reply = JOptionPane.showConfirmDialog(null, "SEGURO DE ELIMINAR LOS DATOS DEL PACIENTE: " + "" + nombre + " " + apellido, "Confirmacion", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            try {
                String sql2 = "DELETE FROM problema WHERE clienteID=?";
                pst = con.prepareStatement(sql2);
                pst.setInt(1, id);
                pst.executeUpdate();
                String sql3 = "DELETE FROM funcfamiliar WHERE clienteID=?";
                pst = con.prepareStatement(sql3);
                pst.setInt(1, id);
                pst.executeUpdate();
                String sql4 = "DELETE FROM redsociales WHERE clienteID=?";
                pst = con.prepareStatement(sql4);
                pst.setInt(1, id);
                pst.executeUpdate();
                String sql5 = "DELETE FROM historiasexual WHERE clienteID=?";
                pst = con.prepareStatement(sql5);
                pst.setInt(1, id);
                pst.executeUpdate();
                String sql6 = "DELETE FROM habitos WHERE clienteID=?";
                pst = con.prepareStatement(sql6);
                pst.setInt(1, id);
                pst.executeUpdate();
                String sql7 = "DELETE FROM antecedentesclinicos WHERE clienteID=?";
                pst = con.prepareStatement(sql7);
                pst.setInt(1, id);
                pst.executeUpdate();
                String sql8 = "DELETE FROM antecedentesfamiliares WHERE clienteID=?";
                pst = con.prepareStatement(sql8);
                pst.setInt(1, id);
                pst.executeUpdate();
                String sql9 = "DELETE FROM estadomental WHERE clienteID=?";
                pst = con.prepareStatement(sql9);
                pst.setInt(1, id);
                pst.executeUpdate();
                String sql10 = "DELETE FROM reportesesion WHERE clienteID=?";
                pst = con.prepareStatement(sql10);
                pst.setInt(1, id);
                pst.executeUpdate();
                String sql = "DELETE FROM cliente WHERE id=?";
                pst = con.prepareStatement(sql);
                pst.setInt(1, id);
                pst.executeUpdate();

                JOptionPane.showMessageDialog(null, "PACIENTE ELIMINADO CON EXITO!");
            } catch (SQLException | HeadlessException ex) {
                JOptionPane.showMessageDialog(null, "PACIENTE INEXISTENTE, NO SE COMPLETO LA ELIMINACION");
            }
        } else {
            JOptionPane.showMessageDialog(null, "CANCELANDO ELIMINACION");
        }

    }

    public void deleteFamiliar(int id) {
        String nombre = getNombreFamiliar(id);
        String apellido = getApellidoFamiliar(id);
        int reply = JOptionPane.showConfirmDialog(null, "SEGURO DE ELIMINAR LOS DATOS DEL PACIENTE: " + "" + nombre + " " + apellido, "Confirmacion", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            try {

                String sql3 = "DELETE FROM funcfamiliar WHERE id=?";
                pst = con.prepareStatement(sql3);
                pst.setInt(1, id);
                pst.executeUpdate();

                JOptionPane.showMessageDialog(null, "FAMILIAR ELIMINADO CON EXITO!");
            } catch (SQLException | HeadlessException ex) {
                JOptionPane.showMessageDialog(null, "FAMILIAR INEXISTENTE, NO SE COMPLETO LA ELIMINACION");
            }
        } else {
            JOptionPane.showMessageDialog(null, "CANCELANDO ELIMINACION");
        }

    }
    public void updatePaciente(int id, String nombre, String apellido, int edad, String nacimiento, String escolaridad,
            String religion, String ocupacion, String actExtra, String direccion, String telefono, String asunto, String objetivo) {

        if (nombre.equals("") || apellido.equals("") || edad < 0 || nacimiento.equals("") || escolaridad.equals("")
                || religion.equals("") || ocupacion.equals("") || actExtra.equals("") || direccion.equals("") || telefono.equals("")
                || asunto.equals("") || objetivo.equals("")) {
            JOptionPane.showMessageDialog(null, "NO DEJAR NINGUN CAMPO VACIO!");
        } else {
            try {
                String sql2 = "SELECT * FROM cliente WHERE nombre=? AND apellido=? AND id<>?";
                pst = con.prepareStatement(sql2);
                pst.setString(1, nombre);
                pst.setString(2, apellido);
                pst.setInt(3, id);
                rs = pst.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "CANCELANDO EDICION, YA EXISTE UN PACIENTE CON LOS DATOS INGRESADOS.");
                } else {
                    String sql = "UPDATE cliente SET nombre=?,apellido=?,edad=?,nacimiento=?,escolaridad=?,religion=?,ocupacion=?,actExtra=?,direccion=?,telefono=?,asunto=?,objetivo=? WHERE id=?";
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
                    pst.setString(11, asunto);
                    pst.setString(12, objetivo);
                    pst.setInt(13, id);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "DATOS DEL PACIENTE EDITADOS CON EXITO.");
                }

            } catch (SQLException | HeadlessException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }

    }

    public void updateProblema(int id, String evolucion, String causas, String acciones, String implicaciones) {
        try {
            String sql = "UPDATE problema SET evolucion=?,causas=?,acciones=?,implicaciones=? WHERE clienteID=?";
            pst = con.prepareStatement(sql);
            pst.setString(1, evolucion);
            pst.setString(2, causas);
            pst.setString(3, acciones);
            pst.setString(4, implicaciones);
            pst.setInt(5, id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "updated successfully");

        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    public void updateSociales(int id, String social, String laboral, String vivienda)
    {
          try {
            String sql = "UPDATE redsociales SET social=?,laboral=?,vivienda=? WHERE clienteID=?";
            pst = con.prepareStatement(sql);
         pst.setString(1, social);
         pst.setString(2, laboral);
         pst.setString(3, vivienda);
            pst.setInt(4, id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "updated successfully");

        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
      public void updateSexual(int id, String abuso, String embarazo, int edad, String preferencia, String traumas, String infoTraumas)
    {
        try {
            String sql = "UPDATE historiasexual SET abusoSexual=?,embarazo=?,edad=?,prefSexual=?,traumas=?,infoTraumas=? WHERE clienteID=?";
            pst = con.prepareStatement(sql);
           pst.setString(1, abuso);
           pst.setString(2, embarazo);
           pst.setInt(3, edad);
            pst.setString(4, preferencia);
            pst.setString(5, traumas);
            pst.setString(6, infoTraumas);
            pst.setInt(7, id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "updated successfully");

        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
      public void updateHabitos(int id, String dream, String alimenticio, String psicologicos)
      {
          try {
            String sql = "UPDATE habitos SET dream=?,alimenticio=?,antPsicologicos=? WHERE clienteID=?";
            pst = con.prepareStatement(sql);
            pst.setString(1, dream);
            pst.setString(2, alimenticio);
            pst.setString(3, psicologicos);
            pst.setInt(4, id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "updated successfully");

        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
      }
      public void updateClinicos(int id, String grave, String accidentes, String medicamento, String quirurgica, String auxiliar)
      {
          try {
            String sql = "UPDATE antecedentesclinicos SET enfermedadGrave=?,accidentes=?,medicamento=?,intQuirurgica=?,dispAuxiliar=? WHERE clienteID=?";
            pst = con.prepareStatement(sql);
            pst.setString(1, grave);
            pst.setString(2,accidentes);
            pst.setString(3, medicamento);
            pst.setString(4, quirurgica);
            pst.setString(5, auxiliar);
            pst.setInt(6, id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "updated successfully");

        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
      }
      public void updateFamiliares(int id, String psicologia, String psiquiatra, String patologia)
      {
           try {
            String sql = "UPDATE antecedentesfamiliares SET psicologia=?,psiquiatra=?,patologia=? WHERE clienteID=?";
            pst = con.prepareStatement(sql);
            pst.setString(1, psicologia);
            pst.setString(2,psiquiatra);
            pst.setString(3, patologia);
            pst.setInt(4, id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "updated successfully");

        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
      }
      public void updateMental(int id, String lenguaje, String emocional, String realidad, String higiene)
      {
       try {
            String sql = "UPDATE estadomental SET percepcionLenguaje=?,estadoEmocional=?,contactoRealidad=?,higienePersonal=? WHERE clienteID=?";
            pst = con.prepareStatement(sql);
            pst.setString(1,lenguaje);
            pst.setString(2, emocional);
            pst.setString(3, realidad);
            pst.setString(4, higiene);
            pst.setInt(5, id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "updated successfully");

        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
      }
      public void updateReporte(int id, String diagnostico, String observaciones)
      {
           try {
            String sql = "UPDATE reportesesion SET diagnostico=?,observaciones=? WHERE clienteID=?";
            pst = con.prepareStatement(sql);
            pst.setString(1, diagnostico);
            pst.setString(2, observaciones);
            pst.setInt(3, id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "updated successfully");

        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
      }
    //======================================================================================
    public String getNombre(int id) {
        String nombre = "";
        try {
            String sql2 = "SELECT nombre FROM cliente WHERE id=?";
            pst = con.prepareStatement(sql2);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                nombre = rs.getString("nombre");
            }

        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        return nombre;
    }

    public String getApellido(int id) {
        String apellido = "";
        try {
            String sql2 = "SELECT apellido FROM cliente WHERE id=?";
            pst = con.prepareStatement(sql2);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                apellido = rs.getString("apellido");
            }

        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return apellido;
    }
    public String getIngreso(int id)
    {
         String apellido = "";
        try {
            String sql2 = "SELECT fecha FROM cliente WHERE id=?";
            pst = con.prepareStatement(sql2);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                apellido = rs.getString("fecha");
            }

        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return apellido;
    }

    public String getNombreFamiliar(int id)
    {
         String apellido = "";
        try {
            String sql2 = "SELECT nombre FROM funcfamiliar WHERE id=?";
            pst = con.prepareStatement(sql2);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                apellido = rs.getString("nombre");
            }

        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return apellido;
    }
     public String getApellidoFamiliar(int id)
    {
         String apellido = "";
        try {
            String sql2 = "SELECT apellido FROM funcfamiliar WHERE id=?";
            pst = con.prepareStatement(sql2);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                apellido = rs.getString("apellido");
            }

        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return apellido;
    }
    public int getEdad(int id) {
        int edad = 0;
        try {
            String sql2 = "SELECT edad FROM cliente WHERE id=?";
            pst = con.prepareStatement(sql2);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                edad = rs.getInt("edad");
            }

        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return edad;
    }

    public String getDate(int id) {
        String date = "";
        try {
            String sql2 = "SELECT nacimiento FROM cliente WHERE id=?";
            pst = con.prepareStatement(sql2);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                date = rs.getString("nacimiento");
            }

        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return date;
    }

    public String getLvl(int id) {
        String escolaridad = "";
        try {
            String sql2 = "SELECT escolaridad FROM cliente WHERE id=?";
            pst = con.prepareStatement(sql2);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                escolaridad = rs.getString("escolaridad");
            }

        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return escolaridad;
    }

    public String getReligion(int id) {
        String religion = "";
        try {
            String sql2 = "SELECT religion FROM cliente WHERE id=?";
            pst = con.prepareStatement(sql2);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                religion = rs.getString("religion");
            }

        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return religion;
    }

    public String getOcupacion(int id) {
        String ocupacion = "";
        try {
            String sql2 = "SELECT ocupacion FROM cliente WHERE id=?";
            pst = con.prepareStatement(sql2);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                ocupacion = rs.getString("ocupacion");
            }

        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return ocupacion;
    }

    public String getAct(int id) {
        String act = "";
        try {
            String sql2 = "SELECT actExtra FROM cliente WHERE id=?";
            pst = con.prepareStatement(sql2);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                act = rs.getString("actExtra");
            }

        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return act;
    }

    public String getDireccion(int id) {
        String direccion = "";
        try {
            String sql2 = "SELECT direccion FROM cliente WHERE id=?";
            pst = con.prepareStatement(sql2);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                direccion = rs.getString("direccion");
            }

        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return direccion;
    }

    public String getTelefono(int id) {
        String telefono = "";
        try {
            String sql2 = "SELECT telefono FROM cliente WHERE id=?";
            pst = con.prepareStatement(sql2);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                telefono = rs.getString("telefono");
            }

        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return telefono;
    }

    public String getServicio(int id) {
        String servicio = "";
        try {
            String sql2 = "SELECT servicio FROM cliente WHERE id=?";
            pst = con.prepareStatement(sql2);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                servicio = rs.getString("servicio");
            }

        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return servicio;
    }

    public String getAsunto(int id) {
        String asunto = "";
        try {
            String sql2 = "SELECT asunto FROM cliente WHERE id=?";
            pst = con.prepareStatement(sql2);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                asunto = rs.getString("asunto");
            }

        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return asunto;
    }

    public String getObjetivo(int id) {
        String objetivo = "";
        try {
            String sql2 = "SELECT objetivo FROM cliente WHERE id=?";
            pst = con.prepareStatement(sql2);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                objetivo = rs.getString("objetivo");
            }

        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return objetivo;
    }

    //==================================================================
    public String getEvolucion(int id) {
        String dato = "";
        try {
            String sql2 = "SELECT evolucion FROM problema WHERE clienteID=?";
            pst = con.prepareStatement(sql2);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                dato = rs.getString("evolucion");
            }

        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return dato;
    }

    public String getCausas(int id) {
        String dato = "";
        try {
            String sql2 = "SELECT causas FROM problema WHERE clienteID=?";
            pst = con.prepareStatement(sql2);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                dato = rs.getString("causas");
            }

        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return dato;
    }

    public String getAcciones(int id) {
        String dato = "";
        try {
            String sql2 = "SELECT acciones FROM problema WHERE clienteID=?";
            pst = con.prepareStatement(sql2);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                dato = rs.getString("acciones");
            }

        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return dato;
    }

    public String getImplicaciones(int id) {
        String dato = "";
        try {
            String sql2 = "SELECT implicaciones FROM problema WHERE clienteID=?";
            pst = con.prepareStatement(sql2);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                dato = rs.getString("implicaciones");
            }

        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return dato;
    }

    public String getSocial(int id) {
        String dato = "";
        try {
            String sql2 = "SELECT social FROM redsociales WHERE clienteID=?";
            pst = con.prepareStatement(sql2);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                dato = rs.getString("social");
            }

        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return dato;
    }

    public String getLaboral(int id) {
        String dato = "";
        try {
            String sql2 = "SELECT laboral FROM redsociales WHERE clienteID=?";
            pst = con.prepareStatement(sql2);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                dato = rs.getString("laboral");
            }

        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return dato;
    }

    public String getVivienda(int id) {
        String dato = "";
        try {
            String sql2 = "SELECT vivienda FROM redsociales WHERE clienteID=?";
            pst = con.prepareStatement(sql2);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                dato = rs.getString("vivienda");
            }

        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return dato;
    }
    //=========================================================================================

    public String getAbuso(int id) {
        String dato = "";
        try {
            String sql2 = "SELECT abusoSexual FROM historiasexual WHERE clienteID=?";
            pst = con.prepareStatement(sql2);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                dato = rs.getString("abusoSexual");
            }

        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return dato;
    }

    public String getEmbarazo(int id) {
        String dato = "";
        try {
            String sql2 = "SELECT embarazo FROM historiasexual WHERE clienteID=?";
            pst = con.prepareStatement(sql2);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                dato = rs.getString("embarazo");
            }

        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return dato;
    }

    public int getEdadSexual(int id) {
        int dato = 0;
        try {
            String sql2 = "SELECT edad FROM historiasexual WHERE clienteID=?";
            pst = con.prepareStatement(sql2);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                dato = rs.getInt("edad");
            }

        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return dato;
    }

    public String getPref(int id) {
        String dato = "";
        try {
            String sql2 = "SELECT prefSexual FROM historiasexual WHERE clienteID=?";
            pst = con.prepareStatement(sql2);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                dato = rs.getString("prefSexual");
            }

        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return dato;
    }

    public String getTraumas(int id) {
        String dato = "";
        try {
            String sql2 = "SELECT traumas FROM historiasexual WHERE clienteID=?";
            pst = con.prepareStatement(sql2);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                dato = rs.getString("traumas");
            }

        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return dato;
    }

    public String getInfoTraumas(int id) {
        String dato = "";
        try {
            String sql2 = "SELECT infoTraumas FROM historiasexual WHERE clienteID=?";
            pst = con.prepareStatement(sql2);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                dato = rs.getString("infoTraumas");
            }

        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return dato;
    }

    //=========================================================================================
    public String getDream(int id) {
        String dato = "";
        try {
            String sql2 = "SELECT dream FROM habitos WHERE clienteID=?";
            pst = con.prepareStatement(sql2);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                dato = rs.getString("dream");
            }

        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return dato;
    }

    public String getAlimenticio(int id) {
        String dato = "";
        try {
            String sql2 = "SELECT alimenticio FROM habitos WHERE clienteID=?";
            pst = con.prepareStatement(sql2);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                dato = rs.getString("alimenticio");
            }

        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return dato;
    }

    public String getAntPsicologicos(int id) {
        String dato = "";
        try {
            String sql2 = "SELECT antPsicologicos FROM habitos WHERE clienteID=?";
            pst = con.prepareStatement(sql2);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                dato = rs.getString("antPsicologicos");
            }

        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return dato;
    }

    //===========================================================================================
    public String getGrave(int id) {
        String dato = "";
        try {
            String sql2 = "SELECT enfermedadGrave FROM antecedentesclinicos WHERE clienteID=?";
            pst = con.prepareStatement(sql2);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                dato = rs.getString("enfermedadGrave");
            }

        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return dato;
    }

    public String getAccidentes(int id) {
        String dato = "";
        try {
            String sql2 = "SELECT accidentes FROM antecedentesclinicos WHERE clienteID=?";
            pst = con.prepareStatement(sql2);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                dato = rs.getString("accidentes");
            }

        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return dato;
    }

    public String getMedicamento(int id) {
        String dato = "";
        try {
            String sql2 = "SELECT medicamento FROM antecedentesclinicos WHERE clienteID=?";
            pst = con.prepareStatement(sql2);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                dato = rs.getString("medicamento");
            }

        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return dato;
    }

    public String getQuirurgica(int id) {
        String dato = "";
        try {
            String sql2 = "SELECT intQuirurgica FROM antecedentesclinicos WHERE clienteID=?";
            pst = con.prepareStatement(sql2);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                dato = rs.getString("intQuirurgica");
            }

        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return dato;
    }

    public String getAuxiliar(int id) {
        String dato = "";
        try {
            String sql2 = "SELECT dispAuxiliar FROM antecedentesclinicos WHERE clienteID=?";
            pst = con.prepareStatement(sql2);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                dato = rs.getString("dispAuxiliar");
            }

        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return dato;
    }

    //============================================================================================
    public String getPsicologia(int id) {
        String dato = "";
        try {
            String sql2 = "SELECT psicologia FROM antecedentesfamiliares WHERE clienteID=?";
            pst = con.prepareStatement(sql2);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                dato = rs.getString("psicologia");
            }

        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return dato;
    }

    public String getPsiquiatra(int id) {
        String dato = "";
        try {
            String sql2 = "SELECT psiquiatra FROM antecedentesfamiliares WHERE clienteID=?";
            pst = con.prepareStatement(sql2);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                dato = rs.getString("psiquiatra");
            }

        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return dato;
    }

    public String getPatologia(int id) {
        String dato = "";
        try {
            String sql2 = "SELECT patologia FROM antecedentesfamiliares WHERE clienteID=?";
            pst = con.prepareStatement(sql2);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                dato = rs.getString("patologia");
            }

        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return dato;
    }

    //===========================================================================================
    public String getLenguaje(int id) {
        String dato = "";
        try {
            String sql2 = "SELECT percepcionLenguaje FROM estadomental WHERE clienteID=?";
            pst = con.prepareStatement(sql2);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                dato = rs.getString("percepcionLenguaje");
            }

        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return dato;
    }

    public String getEmocional(int id) {
        String dato = "";
        try {
            String sql2 = "SELECT estadoEmocional FROM estadomental WHERE clienteID=?";
            pst = con.prepareStatement(sql2);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                dato = rs.getString("estadoEmocional");
            }

        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return dato;
    }

    public String getRealidad(int id) {
        String dato = "";
        try {
            String sql2 = "SELECT contactoRealidad FROM estadomental WHERE clienteID=?";
            pst = con.prepareStatement(sql2);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                dato = rs.getString("contactoRealidad");
            }

        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return dato;
    }

    public String getHigiene(int id) {
        String dato = "";
        try {
            String sql2 = "SELECT higienePersonal FROM estadomental WHERE clienteID=?";
            pst = con.prepareStatement(sql2);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                dato = rs.getString("higienePersonal");
            }

        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return dato;
    }

    //===========================================================================================
    public String getDiagnostico(int id) {
        String dato = "";
        try {
            String sql2 = "SELECT diagnostico FROM reportesesion WHERE clienteID=?";
            pst = con.prepareStatement(sql2);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                dato = rs.getString("diagnostico");
            }

        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return dato;
    }

    public String getObservaciones(int id) {
        String dato = "";
        try {
            String sql2 = "SELECT observaciones FROM reportesesion WHERE clienteID=?";
            pst = con.prepareStatement(sql2);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                dato = rs.getString("observaciones");
            }

        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return dato;
    }

    //===========================================================================================
    public ResultSet getFamiliares(int id) {
        try {
            String sql = "SELECT id,nombre,parentesco,edad,ocupacion FROM funcfamiliar WHERE clienteID=?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);

        }
        return rs;
    }

    //===========================================================================================
    public ResultSet searchPacientes() {
        try {
            String sql = "SELECT id,nombre,apellido,edad,asunto FROM cliente";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);

        }
        return rs;
    }

    public ResultSet searchPacientesNombre(String nombre) {
        try {
            String sql = "SELECT id,nombre,apellido,edad,asunto FROM cliente WHERE nombre LIKE '%" + nombre + "%'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);

        }
        return rs;
    }

    public ResultSet searchPacientesApellido(String apellido) {
        try {
            String sql = "SELECT id,nombre,apellido,edad,asunto FROM cliente WHERE apellido LIKE '%" + apellido + "%'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);

        }
        return rs;
    }

    public ResultSet searchEdad(int edad) {
        if (edad < 0) {
            JOptionPane.showMessageDialog(null, "DATO INVALIDO");
        } else {
            try {
                String sql = "SELECT id,nombre,apellido,edad,asunto FROM cliente WHERE edad LIKE '%" + edad + "%'";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);

            }
        }

        return rs;
    }
    //==============================================================

    //========================================================================================
    private motor m;
    private LoginView login;
    private menuView menuv;
    private pacientesView pacientesv;
}
