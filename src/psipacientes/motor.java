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
import java.io.File;
import java.sql.ResultSet;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class motor {

    public motor() {

    }
//=====CREAR Y ASIGNAR PDF================================================

    public void createPDF(int id, File pdfNewFile) {
        pdf.createPDF(id, pdfNewFile);
    }

    public void setPDF(GeneratePDF pdf) {
        this.pdf = pdf;
    }

    //================CONEXION CON BD Y QUERYS==========================
    public void setQuerysDB(querysDB querys) {
        this.querys = querys;
    }

    public void setConexion() {
        querys.conector();
    }

    //=======USUARIO Y LOGEO========
    public void logeo(String usuario, String Password) {
        querys.logeo(usuario, Password);
    }
    
/**
 * INSERTAR DATOS REQUERIDOS PARA EL PACIENTE A REGISTRAR.
 * @param nombre
 * @param apellido
 * @param edad
 * @param nacimiento
 * @param escolaridad
 * @param religion
 * @param ocupacion
 * @param actExtra
 * @param direccion
 * @param telefono
 * @param servicio
 * @param asunto
 * @return 
 */
    public boolean insertPaciente(String nombre, String apellido, int edad, String nacimiento, String escolaridad,
            String religion, String ocupacion, String actExtra, String direccion, String telefono, String servicio, String asunto) {
        if (querys.insertPaciente(nombre, apellido, edad, nacimiento, escolaridad, religion, ocupacion, actExtra, direccion, telefono, servicio, asunto)) {

            return true;
        } else {
            return false;
        }

    }
/**
 * INGRESAR ID PARA REALIZAR BUSQUEDA Y ELIMINACION DE UN PACIENTE EXISTENTE
 * @param id 
 */
    public void deletePaciente(int id) {
        querys.deletePaciente(id);
    }
/**
 * INGRESAR ID PARA REALIZAR BUSQUEDA Y ELIMINACION DE UN FAMILIAR EXISTENTE
 * @param id 
 */
    public void deleteFamiliar(int id) {
        querys.deleteFamiliar(id);
    }
/**
 * INGRESAR DATOS REQUERIDOS PARA EL REGISTRO DE UN FAMILIAR
 * @param id
 * @param nombre
 * @param apellido
 * @param parentesco
 * @param edad
 * @param ocupacion
 * @return 
 */
    public boolean insertFamiliar(int id, String nombre, String apellido, String parentesco, int edad, String ocupacion) {
        return querys.insertFamiliar(id, nombre, apellido, parentesco, edad, ocupacion);
    }
/**
 * INGRESAR DATOS REQUERIDOS PARA REALIZAR UNA EDICION EN LOS DATOS DE UN PACIENTE EXISTENTE
 * @param id
 * @param nombre
 * @param apellido
 * @param edad
 * @param nacimiento
 * @param escolaridad
 * @param religion
 * @param ocupacion
 * @param actExtra
 * @param direccion
 * @param telefono
 * @param asunto
 * @param objetivo 
 */
    public void updatePaciente(int id, String nombre, String apellido, int edad, String nacimiento, String escolaridad,
            String religion, String ocupacion, String actExtra, String direccion, String telefono, String asunto, String objetivo) {
        querys.updatePaciente(id, nombre, apellido, edad, nacimiento, escolaridad, religion, ocupacion, actExtra, direccion, telefono, asunto, objetivo);
    }
/**
 * INGRESAR DATOS REQUERIDOS PARA REALIZAR UNA EDICION EN LOS REGISTROS DE PROBLEMAS DEL PACIENTE
 * @param id
 * @param evolucion
 * @param causas
 * @param acciones
 * @param implicaciones 
 */
    public void updateProblema(int id, String evolucion, String causas, String acciones, String implicaciones) {
        querys.updateProblema(id, evolucion, causas, acciones, implicaciones);
    }
/**
 * INGRESAR DATOS REQUERIDOS PARA REALIZAR UNA EDICION EN LOS REGISTROS DEL AREA SOCIAL DEL PACIENTE
 * @param id
 * @param social
 * @param laboral
 * @param vivienda 
 */
    public void updateSociales(int id, String social, String laboral, String vivienda) {
        querys.updateSociales(id, social, laboral, vivienda);
    }
/**
 * INGRESAR DATOS REQUERIDOS PARA REALIZAR UNA EDICION EN LOS REGISTROS DEL AREA SEXUAL DEL PACIENTE
 * @param id
 * @param abuso
 * @param embarazo
 * @param edad
 * @param preferencia
 * @param traumas
 * @param infoTraumas 
 */
    public void updateSexual(int id, String abuso, String embarazo, int edad, String preferencia, String traumas, String infoTraumas) {
        querys.updateSexual(id, abuso, embarazo, edad, preferencia, traumas, infoTraumas);
    }
/**
 * INGRESAR DATOS REQUERIDOS PARA REALIZAR UNA EDICION EN LOS REGISTROS DE LOS HABITOS DEL PACIENTE
 * @param id
 * @param dream
 * @param alimenticio
 * @param psicologicos 
 */
    public void updateHabitos(int id, String dream, String alimenticio, String psicologicos) {
        querys.updateHabitos(id, dream, alimenticio, psicologicos);
    }
/**
 * INGRESAR DATOS REQUERIDOS PARA REALIZAR UNA EDICION EN LOS REGISTROS DE LOS ANTECEDENTES CLINICOS DEL PACIENTE
 * @param id
 * @param grave
 * @param accidentes
 * @param medicamento
 * @param quirurgica
 * @param auxiliar 
 */
    public void updateClinicos(int id, String grave, String accidentes, String medicamento, String quirurgica, String auxiliar) {
        querys.updateClinicos(id, grave, accidentes, medicamento, quirurgica, auxiliar);
    }
/**
 * INGRESAR DATOS REQUERIDOS PARA REALIZAR UNA EDICION EN LOS REGISTROS DE LOS ANTECEDENTES FAMILIARES DEL PACIENTE
 * @param id
 * @param psicologia
 * @param psiquiatra
 * @param patologia 
 */
    public void updateFamiliares(int id, String psicologia, String psiquiatra, String patologia) {
        querys.updateFamiliares(id, psicologia, psiquiatra, patologia);
    }
/**
 * INGRESAR DATOS REQUERIDOS PARA REALIZAR UNA EDICION EN LOS REGISTROS DEL ESTADO MENTAL DEL PACIENTE
 * @param id
 * @param lenguaje
 * @param emocional
 * @param realidad
 * @param higiene 
 */
    public void updateMental(int id, String lenguaje, String emocional, String realidad, String higiene) {
        querys.updateMental(id, lenguaje, emocional, realidad, higiene);
    }
/**
 * INGRESAR DATOS REQUERIDOS PARA REALIZAR UNA EDICION EN LOS REGISTROS DEL REPORTE DE SESION
 * @param id
 * @param diagnostico
 * @param observaciones 
 */
    public void updateReporte(int id, String diagnostico, String observaciones) {
        querys.updateReporte(id, diagnostico, observaciones);
    }
/**
 * METODO PARA REALIZAR BUSQUEDA DEL NOMBRE Y APELLIDO DEL PACENTE POR ID
 * @param nombre
 * @param apellido
 * @return 
 */
    public int buscarId(String nombre, String apellido) {
        return querys.buscarId(nombre, apellido);
    }
/**
 * METODO PARA REALIZAR BUSQUEDA DE TODOS LOS PACIENTES REGISTRADOS
 * @return 
 */
    public ResultSet searchPacientes() {

        return querys.searchPacientes();
    }
/**
 * METODO PARA REALIZAR BUSQUEDA DE PACIENTES POR NOMBRE
 * @param nombre
 * @return 
 */
    public ResultSet searchPacientesNombre(String nombre) {
        return querys.searchPacientesNombre(nombre);
    }
/**
 * METODO PARA REALIZAR BUSQUEDA DE PACIENTES POR APELLIDO
 * @param apellido
 * @return 
 */
    public ResultSet searchPacientesApellido(String apellido) {
        return querys.searchPacientesApellido(apellido);
    }
/**
 * METODO PARA REALIZAR BUSQUEDA DE PACIENTES POR EDAD
 * @param edad
 * @return 
 */
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
        menuv.pack();
        menuv.setLocationRelativeTo(null);
        menuv.setVisible(true);
    }

    public void openLogin() {
        loginView.show();
        loginView.pack();
        loginView.setLocationRelativeTo(null);
        loginView.setVisible(true);
    }

    public void openAddPaciente() {
        addPaciente.show();
        addPaciente.pack();
        addPaciente.setLocationRelativeTo(null);
        addPaciente.setVisible(true);
    }

    public void openPacientes() {
        pacientesv.show();
        pacientesv.pack();
        pacientesv.setLocationRelativeTo(null);
        pacientesv.setVisible(true);
    }

    public void openPrincipal() {
        principal.show();
        principal.pack();
        principal.setLocationRelativeTo(null);
        principal.setVisible(true);
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

    //==========GETS DE DATOS DEL PACIENTE=================================================================================
    public String getNombre(int id) {
        return querys.getNombre(id);
    }

    public String getApellido(int id) {
        return querys.getApellido(id);
    }

    public String getIngreso(int id) {
        return querys.getIngreso(id);
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

    //================GETS DE DATOS DEL PROBLEMA===========================================================================
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

    //================GETS DE DATOS DEL HISTORIAL SEXUAL===========================================================================
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

    //=============GETS DE DATOS DE LOS HABITOS===============================================================================
    public String getDream(int id) {
        return querys.getDream(id);
    }

    public String getAlimenticio(int id) {
        return querys.getAlimenticio(id);
    }

    public String getAntPsicologicos(int id) {
        return querys.getAntPsicologicos(id);
    }
    //============GETS DE DATOS DE ANTECEDENTES CLINICOS===============================================================================

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

    //===========GETS DE DATOS DE LOS ANTECEDENTES FAMILIARES================================================================================
    public String getPsicologia(int id) {
        return querys.getPsicologia(id);
    }

    public String getPsiquiatra(int id) {
        return querys.getPsiquiatra(id);
    }

    public String getPatologia(int id) {
        return querys.getPatologia(id);
    }
    //==========GETS DE DATOS DEL ANALISIS MENTAL===============================================================================

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

    //=============GETS DE DATOS DEL REPORTE DE SESION==============================================================================
    public String getDiagnostico(int id) {
        return querys.getDiagnostico(id);
    }

    public String getObservaciones(int id) {
        return querys.getObservaciones(id);
    }
    //==========================================================================================
/**
 * METODO PARA REALIZAR BUSQUEDA DE FAMILIARES RELACIONADOS AL PACIENTE POR MEDIO DEL ID
 * @param id
 * @return 
 */
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
    private GeneratePDF pdf;
    //===========================================================================================
    private int id;
}
