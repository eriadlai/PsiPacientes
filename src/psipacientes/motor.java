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

    public void updatePaciente(int id, String nombre, String apellido, int edad, String nacimiento, String escolaridad,
            String religion, String ocupacion, String actExtra, String direccion, String telefono, String asunto, String objetivo) {
        querys.updatePaciente(id, nombre, apellido, edad, nacimiento, escolaridad, religion, ocupacion, actExtra, direccion, telefono, asunto, objetivo);
    }

    public void updateProblema(int id, String evolucion, String causas, String acciones, String implicaciones) {
        querys.updateProblema(id, evolucion, causas, acciones, implicaciones);
    }
    public void updateSociales(int id, String social, String laboral, String vivienda)
    {
        querys.updateSociales(id, social, laboral, vivienda);
    }
    public void updateSexual(int id, String abuso, String embarazo, int edad, String preferencia, String traumas, String infoTraumas)
    {
        querys.updateSexual(id, abuso, embarazo, edad, preferencia, traumas, infoTraumas);
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
    public String getAbuso(int id) {
        return querys.getAbuso(id);
    }

    public String getEmbarazo(int id) {
        return querys.getEmbarazo(id);
    }

    public int getEdadSexual(int id) {
        return querys.getEdadSexual(id);
    }

    public String getPref(int id) {
        return querys.getPref(id);
    }

    public String getTraumas(int id) {
        return querys.getTraumas(id);
    }

    public String getInfoTraumas(int id) {
        return querys.getInfoTraumas(id);
    }

    //============================================================================================
    public String getDream(int id) {
        return querys.getDream(id);
    }

    public String getAlimenticio(int id) {
        return querys.getAlimenticio(id);
    }

    public String getAntPsicologicos(int id) {
        return querys.getAntPsicologicos(id);
    }
    //===========================================================================================

    public String getGrave(int id) {
        return querys.getGrave(id);
    }

    public String getAccidentes(int id) {
        return querys.getAccidentes(id);
    }

    public String getMedicamento(int id) {
        return querys.getMedicamento(id);
    }

    public String getQuirurgica(int id) {
        return querys.getQuirurgica(id);
    }

    public String getAuxiliar(int id) {
        return querys.getAuxiliar(id);
    }

    //===========================================================================================
    public String getPsicologia(int id) {
        return querys.getPsicologia(id);
    }

    public String getPsiquiatra(int id) {
        return querys.getPsiquiatra(id);
    }

    public String getPatologia(int id) {
        return querys.getPatologia(id);
    }
    //=========================================================================================

    public String getLenguaje(int id) {
        return querys.getLenguaje(id);
    }

    public String getEmocional(int id) {
        return querys.getEmocional(id);
    }

    public String getRealidad(int id) {
        return querys.getRealidad(id);
    }

    public String getHigiene(int id) {
        return querys.getHigiene(id);
    }

    //===========================================================================================
    public String getDiagnostico(int id) {
        return querys.getDiagnostico(id);
    }

    public String getObservaciones(int id) {
        return querys.getObservaciones(id);
    }
    //==========================================================================================

    public ResultSet getFamiliaress(int id) {

        return querys.getFamiliares(id);
    }
    //=========================================================================================

    public void inicio() {
        pacientesv = new pacientesView(searchPacientes());
        pacientesv.setMotor(this);
        this.setPacientesView(pacientesv);
    }

    public void inicioPrincipal() {
        principal = new principalView();
        principal.setMotor(this);
        this.setPrincipalView(principal);
        principal.setDatos();
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
