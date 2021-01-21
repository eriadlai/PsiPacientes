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
import Views.principalView;
import java.sql.ResultSet;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class motor {

    public motor() {

    }

    //================QUERYS==========================
    public void setQuerysDB(querysDB querys) {
        this.querys = querys;
    }

    public void setConexion() {
        querys.conector();
    }

    //=======USUARIO========
    public void logeo(String usuario, String Password) {
        querys.logeo(usuario, Password);
    }

    public boolean insertPaciente(String nombre, String apellido, int edad, String nacimiento, String escolaridad,
            String religion, String ocupacion, String actExtra, String direccion, String telefono, String servicio, String asunto, String objetivo) {
        if (querys.insertPaciente(nombre, apellido, edad, nacimiento, escolaridad, religion, ocupacion, actExtra, direccion, telefono, servicio, asunto, objetivo)) {

            return true;
        } else {
            return false;
        }

    }

    public void deletePaciente(int id) {
        querys.deletePaciente(id);
    }

    public void updatePaciente(int id, String nombre, String apellido, int edad, String asunto) {
        querys.updatePaciente(id, nombre, apellido, edad, asunto);
    }

    public int buscarId(String nombre, String apellido) {
        return querys.buscarId(nombre, apellido);
    }

    public ResultSet searchPacientes() {

        return querys.searchPacientes();
    }

    public ResultSet searchPacientesNombre(String nombre) {
        return querys.searchPacientesNombre(nombre);
    }

    public ResultSet searchPacientesApellido(String apellido) {
        return querys.searchPacientesApellido(apellido);
    }

    public ResultSet searchPacientesEdad(int edad) {
        return querys.searchEdad(edad);
    }
    //==========SET CONEXIONES CON CLASES VIEW=============

    public void setLoginView(LoginView loginView) {
        this.loginView = loginView;
    }

    public void setMenuView(menuView menuv) {
        this.menuv = menuv;
    }

    public void setAddPacienteView(addPacienteView addPaciente) {
        this.addPaciente = addPaciente;
    }

    public void setPacientesView(pacientesView pacientesv) {
        this.pacientesv = pacientesv;
    }

    public void setPrincipalView(principalView principal) {
        this.principal = principal;
    }

    //=============ABRIR Y CERRAR VENTANAS====================
    public void openMenu() {
        menuv.show();
    }

    public void openLogin() {
        loginView.show();
    }

    public void openAddPaciente() {
        addPaciente.show();
    }

    public void openPacientes() {
        pacientesv.show();
    }

    public void openPrincipal() {
        principal.show();
    }

    public void closePrincipal() {
        principal.hide();
    }

    public void closePacientes() {
        pacientesv.hide();
    }

    public void closeAddPaciente() {
        addPaciente.hide();
    }

    public void closeMenu() {
        menuv.hide();
    }

    public void closeLogin() {
        loginView.hide();
    }

    //===========================================================================================
    public String getFecha(String d, String m, String y) {

        String fecha = (d + "/" + m + "/" + y);
        return fecha;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    //===========================================================================================
    public String getNombre(int id) {
        return querys.getNombre(id);
    }

    public String getApellido(int id) {
        return querys.getApellido(id);
    }

    public int getEdad(int id) {
        return querys.getEdad(id);
    }

    public String getNacimiento(int id) {
        return querys.getDate(id);
    }

    public String getLvl(int id) {
        return querys.getLvl(id);
    }

    public String getReligion(int id) {
        return querys.getReligion(id);
    }

    public String getOcupacion(int id) {
        return querys.getOcupacion(id);
    }

    public String getAct(int id) {
        return querys.getAct(id);
    }

    public String getDireccion(int id) {
        return querys.getDireccion(id);
    }

    public String getTelefono(int id) {
        return querys.getTelefono(id);
    }

    public String getServicio(int id) {
        return querys.getServicio(id);
    }

    public String getAsunto(int id) {
        return querys.getAsunto(id);
    }

    public String getObjetivo(int id) {
        return querys.getObjetivo(id);
    }

    //===========================================================================================
    public String getEvolucion(int id) {
        return querys.getEvolucion(id);
    }

    public String getCausas(int id) {
        return querys.getCausas(id);
    }

    public String getAcciones(int id) {
        return querys.getAcciones(id);
    }

    public String getImplicaciones(int id) {
        return querys.getImplicaciones(id);
    }

    public String getSocial(int id) {
        return querys.getSocial(id);
    }

    public String getLaboral(int id) {
        return querys.getLaboral(id);
    }

    public String getVivienda(int id) {
        return querys.getVivienda(id);
    }
    //===========================================================================================
    private LoginView loginView;
    private querysDB querys;
    private menuView menuv;
    private addPacienteView addPaciente;
    private pacientesView pacientesv;
    private principalView principal;
    //===========================================================================================
    private int id;
}
