/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import psipacientes.motor;

/**
 *
 * @author Adlai CG <eri_acg@hotmail.com>
 */
public class principalView extends javax.swing.JFrame {

    public void showTableData(ResultSet rs) {
          try {

            familiaTable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);

        }

    }

    public void setDatos() {
        id = m.getId();

        try {
            java.util.Date date = new SimpleDateFormat("dd/MM/yyyy").parse(m.getNacimiento(id));
            dateText.setDate(date);
        } catch (ParseException ex) {
            Logger.getLogger(principalView.class.getName()).log(Level.SEVERE, null, ex);
        }
        nameText.setText(m.getNombre(id));
        apellidoText.setText(m.getApellido(id));
        edadText.setValue(m.getEdad(id));
        lvlText.setSelectedItem(m.getLvl(id));
        religionText.setSelectedItem(m.getReligion(id));
        ocupacionText.setText(m.getOcupacion(id));
        actText.setText(m.getAct(id));
        direccionText.setText(m.getDireccion(id));
        telefonoText.setText(m.getTelefono(id));
        asuntoText.setText(m.getAsunto(id));
        objText.setText(m.getObjetivo(id));
        fechaIngreso.setText(m.getIngreso(id));
        //===========================
        evolucionText.setText(m.getEvolucion(id));
        causasText.setText(m.getCausas(id));
        accionesText.setText(m.getAcciones(id));
        implicacionesText.setText(m.getImplicaciones(id));
        //===========================================
        socialText.setText(m.getSocial(id));
        laboralText.setText(m.getLaboral(id));
        viviendaText.setText(m.getVivienda(id));
        //===========================================
        antSexualText.setText(m.getAbuso(id));
        embarazoEdad.setValue(m.getEdadSexual(id));
        preferenciaText.setText(m.getPref(id));

        if (m.getEmbarazo(id).equals("Si")) {
            siEmbarazo.setSelected(true);

        } else if (m.getEmbarazo(id).equals("No")) {
            noEmbarazo.setSelected(true);
            embarazoEdad.setEnabled(false);
        } else {
            siEmbarazo.setSelected(false);
            noEmbarazo.setSelected(false);
        }
        if (m.getTraumas(id).equals("Si")) {
            siTrauma.setSelected(true);

        } else if (m.getTraumas(id).equals("No")) {
            noTrauma.setSelected(true);
            infoTraumaText.setEnabled(false);

        } else {
            siTrauma.setSelected(false);
            noTrauma.setSelected(false);
        }
        infoTraumaText.setText(m.getInfoTraumas(id));
        //==========================================
        dreamText.setText(m.getDream(id));
        alimentoText.setText(m.getAlimenticio(id));
        antPsiText.setText(m.getAntPsicologicos(id));
        //=============================================
        enfermedadText.setText(m.getGrave(id));
        accidenteText.setText(m.getAccidentes(id));
        medicamentoText.setText(m.getMedicamento(id));
        intervencionText.setText(m.getQuirurgica(id));
        auxText.setText(m.getAuxiliar(id));
        //============================================
        antFamPsiText.setText(m.getPsicologia(id));
        antFamPsiqText.setText(m.getPsiquiatra(id));
        antFamPatText.setText(m.getPatologia(id));
        //==============================================
        lenguajeText.setText(m.getLenguaje(id));
        emocionalText.setText(m.getEmocional(id));
        realidadText.setText(m.getRealidad(id));
        higieneText.setText(m.getHigiene(id));
        //==============================================
        diagnosticoText.setText(m.getDiagnostico(id));
        observacionText.setText(m.getObservaciones(id));
        //==============================================
        showTableData(m.getFamiliaress(id));

    }

    public void setMotor(motor m) {
        this.m = m;
    }

    /**
     * Creates new form principalView
     */
    public principalView() {
        initComponents();
  setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("CEPAC_Logo.png")));
        fechaIngreso.enable(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        volverSocial = new javax.swing.JButton();
        editarSociales = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        viviendaText = new javax.swing.JTextArea();
        jScrollPane7 = new javax.swing.JScrollPane();
        laboralText = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        socialText = new javax.swing.JTextArea();
        jLabel19 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        embarazoEdad = new javax.swing.JSpinner();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        preferenciaText = new javax.swing.JTextField();
        siEmbarazo = new javax.swing.JRadioButton();
        noEmbarazo = new javax.swing.JRadioButton();
        siTrauma = new javax.swing.JRadioButton();
        noTrauma = new javax.swing.JRadioButton();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        infoTraumaText = new javax.swing.JTextArea();
        jScrollPane27 = new javax.swing.JScrollPane();
        antSexualText = new javax.swing.JTextArea();
        editarSexual = new javax.swing.JButton();
        volverSexual = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        dreamText = new javax.swing.JTextArea();
        jScrollPane11 = new javax.swing.JScrollPane();
        alimentoText = new javax.swing.JTextArea();
        jScrollPane12 = new javax.swing.JScrollPane();
        antPsiText = new javax.swing.JTextArea();
        editarHabitos = new javax.swing.JButton();
        volverHabito = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jScrollPane18 = new javax.swing.JScrollPane();
        antFamPsiText = new javax.swing.JTextArea();
        jLabel35 = new javax.swing.JLabel();
        jScrollPane19 = new javax.swing.JScrollPane();
        antFamPsiqText = new javax.swing.JTextArea();
        jLabel36 = new javax.swing.JLabel();
        jScrollPane20 = new javax.swing.JScrollPane();
        antFamPatText = new javax.swing.JTextArea();
        editarAntFam = new javax.swing.JButton();
        VolverAntFam = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        familiaTable = new javax.swing.JTable();
        volverFam = new javax.swing.JButton();
        ingresarFamiliar = new javax.swing.JButton();
        borrar = new javax.swing.JButton();
        jLabel43 = new javax.swing.JLabel();
        famNombre = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        famParentesco = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        famOcupacion = new javax.swing.JTextField();
        famEdad = new javax.swing.JSpinner();
        jLabel47 = new javax.swing.JLabel();
        famApellido = new javax.swing.JTextField();
        jScrollPane28 = new javax.swing.JScrollPane();
        jPanel12 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jScrollPane25 = new javax.swing.JScrollPane();
        diagnosticoText = new javax.swing.JTextArea();
        jLabel42 = new javax.swing.JLabel();
        jScrollPane26 = new javax.swing.JScrollPane();
        observacionText = new javax.swing.JTextArea();
        editarReporte = new javax.swing.JButton();
        volverReporte = new javax.swing.JButton();
        jScrollPane29 = new javax.swing.JScrollPane();
        jPanel11 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jScrollPane21 = new javax.swing.JScrollPane();
        lenguajeText = new javax.swing.JTextArea();
        jLabel38 = new javax.swing.JLabel();
        jScrollPane22 = new javax.swing.JScrollPane();
        emocionalText = new javax.swing.JTextArea();
        jLabel39 = new javax.swing.JLabel();
        jScrollPane23 = new javax.swing.JScrollPane();
        realidadText = new javax.swing.JTextArea();
        jLabel40 = new javax.swing.JLabel();
        jScrollPane24 = new javax.swing.JScrollPane();
        higieneText = new javax.swing.JTextArea();
        editarMental = new javax.swing.JButton();
        volverMental = new javax.swing.JButton();
        jScrollPane30 = new javax.swing.JScrollPane();
        jPanel13 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        enfermedadText = new javax.swing.JTextArea();
        jLabel30 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        accidenteText = new javax.swing.JTextArea();
        jLabel31 = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        medicamentoText = new javax.swing.JTextArea();
        jLabel32 = new javax.swing.JLabel();
        jScrollPane16 = new javax.swing.JScrollPane();
        intervencionText = new javax.swing.JTextArea();
        jLabel33 = new javax.swing.JLabel();
        jScrollPane17 = new javax.swing.JScrollPane();
        auxText = new javax.swing.JTextArea();
        volverClinico = new javax.swing.JButton();
        editarClinico = new javax.swing.JButton();
        jScrollPane31 = new javax.swing.JScrollPane();
        jPanel14 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        evolucionText = new javax.swing.JTextArea();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        causasText = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        accionesText = new javax.swing.JTextArea();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        implicacionesText = new javax.swing.JTextArea();
        EditarProblema = new javax.swing.JButton();
        VolverProblema = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        nameText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        apellidoText = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        edadText = new javax.swing.JSpinner();
        dateText = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lvlText = new javax.swing.JComboBox<>();
        religionText = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        editar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        ocupacionText = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        actText = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        direccionText = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        telefonoText = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        asuntoText = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        objText = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        fechaIngreso = new javax.swing.JTextField();
        volver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Gestion de pacientes CEPAC: Datos generales");

        jTabbedPane1.setBackground(new java.awt.Color(247, 220, 111));
        jTabbedPane1.setForeground(new java.awt.Color(0, 0, 0));
        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

        jPanel4.setBackground(new java.awt.Color(193, 145, 42));

        jPanel2.setBackground(new java.awt.Color(193, 145, 42));

        volverSocial.setBackground(new java.awt.Color(247, 220, 111));
        volverSocial.setText("Volver");
        volverSocial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverSocialActionPerformed(evt);
            }
        });

        editarSociales.setBackground(new java.awt.Color(247, 220, 111));
        editarSociales.setText("Guardar Datos");
        editarSociales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarSocialesActionPerformed(evt);
            }
        });

        viviendaText.setColumns(20);
        viviendaText.setRows(5);
        jScrollPane8.setViewportView(viviendaText);

        laboralText.setColumns(20);
        laboralText.setRows(5);
        jScrollPane7.setViewportView(laboralText);

        socialText.setColumns(20);
        socialText.setRows(5);
        jScrollPane6.setViewportView(socialText);

        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("Entorno de Vivienda");

        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Entorno Laboral");

        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Entorno Social");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(editarSociales)
                                .addGap(32, 32, 32)
                                .addComponent(volverSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane6)
                            .addComponent(jScrollPane7)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 1045, Short.MAX_VALUE))))
                .addGap(27, 27, 27))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jLabel18)
                .addGap(13, 13, 13)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel19)
                .addGap(23, 23, 23)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(volverSocial)
                    .addComponent(editarSociales))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Exploracion de redes sociales", jPanel4);

        jPanel5.setBackground(new java.awt.Color(193, 145, 42));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("Antecedentes de abuso sexual");
        jPanel5.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, -1, -1));

        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setText("Embarazos");
        jPanel5.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        jLabel22.setForeground(new java.awt.Color(0, 0, 0));
        jLabel22.setText("¿A qué edad?");
        jPanel5.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));
        jPanel5.add(embarazoEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 109, -1));

        jLabel23.setForeground(new java.awt.Color(0, 0, 0));
        jLabel23.setText("Preferencia Sexual");
        jPanel5.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 240, -1, -1));

        jLabel24.setForeground(new java.awt.Color(0, 0, 0));
        jLabel24.setText("Exposicion a eventos traumaticos en esta area");
        jPanel5.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));
        jPanel5.add(preferenciaText, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 260, 170, 30));

        siEmbarazo.setBackground(new java.awt.Color(193, 145, 42));
        siEmbarazo.setForeground(new java.awt.Color(0, 0, 0));
        siEmbarazo.setText("Si");
        siEmbarazo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siEmbarazoActionPerformed(evt);
            }
        });
        jPanel5.add(siEmbarazo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        noEmbarazo.setBackground(new java.awt.Color(193, 145, 42));
        noEmbarazo.setForeground(new java.awt.Color(0, 0, 0));
        noEmbarazo.setText("No");
        noEmbarazo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noEmbarazoActionPerformed(evt);
            }
        });
        jPanel5.add(noEmbarazo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        siTrauma.setBackground(new java.awt.Color(193, 145, 42));
        siTrauma.setForeground(new java.awt.Color(0, 0, 0));
        siTrauma.setText("Si");
        siTrauma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siTraumaActionPerformed(evt);
            }
        });
        jPanel5.add(siTrauma, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        noTrauma.setBackground(new java.awt.Color(193, 145, 42));
        noTrauma.setForeground(new java.awt.Color(0, 0, 0));
        noTrauma.setText("No");
        noTrauma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noTraumaActionPerformed(evt);
            }
        });
        jPanel5.add(noTrauma, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jLabel26.setForeground(new java.awt.Color(0, 0, 0));
        jLabel26.setText("¿Cuáles?");
        jPanel5.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, -1, -1));

        infoTraumaText.setColumns(20);
        infoTraumaText.setRows(5);
        jScrollPane9.setViewportView(infoTraumaText);

        jPanel5.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, 410, -1));

        antSexualText.setColumns(20);
        antSexualText.setRows(5);
        jScrollPane27.setViewportView(antSexualText);

        jPanel5.add(jScrollPane27, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, 410, -1));

        editarSexual.setBackground(new java.awt.Color(247, 220, 111));
        editarSexual.setText("Guardar Datos");
        editarSexual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarSexualActionPerformed(evt);
            }
        });
        jPanel5.add(editarSexual, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 260, -1, -1));

        volverSexual.setBackground(new java.awt.Color(247, 220, 111));
        volverSexual.setText("Volver");
        volverSexual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverSexualActionPerformed(evt);
            }
        });
        jPanel5.add(volverSexual, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 260, 110, -1));

        jTabbedPane1.addTab("Historia sexual", jPanel5);

        jPanel6.setBackground(new java.awt.Color(193, 145, 42));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setForeground(new java.awt.Color(0, 0, 0));
        jLabel25.setText("Hábitos de sueño");
        jPanel6.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 22, -1, -1));

        jLabel27.setForeground(new java.awt.Color(0, 0, 0));
        jLabel27.setText("Hábitos alimenticios");
        jPanel6.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 174, -1, -1));

        jLabel28.setForeground(new java.awt.Color(0, 0, 0));
        jLabel28.setText("Antecedentes psicológicos paciente");
        jPanel6.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 346, -1, -1));

        dreamText.setColumns(20);
        dreamText.setRows(5);
        jScrollPane10.setViewportView(dreamText);

        jPanel6.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 56, 640, -1));

        alimentoText.setColumns(20);
        alimentoText.setRows(5);
        jScrollPane11.setViewportView(alimentoText);

        jPanel6.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 208, 640, -1));

        antPsiText.setColumns(20);
        antPsiText.setRows(5);
        jScrollPane12.setViewportView(antPsiText);

        jPanel6.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 380, 640, -1));

        editarHabitos.setBackground(new java.awt.Color(247, 220, 111));
        editarHabitos.setText("Guardar Datos");
        editarHabitos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarHabitosActionPerformed(evt);
            }
        });
        jPanel6.add(editarHabitos, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 430, -1, -1));

        volverHabito.setBackground(new java.awt.Color(247, 220, 111));
        volverHabito.setText("Volver");
        volverHabito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverHabitoActionPerformed(evt);
            }
        });
        jPanel6.add(volverHabito, new org.netbeans.lib.awtextra.AbsoluteConstraints(1322, 6, 133, -1));

        jTabbedPane1.addTab("Habitos", jPanel6);

        jPanel8.setBackground(new java.awt.Color(193, 145, 42));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel34.setForeground(new java.awt.Color(0, 0, 0));
        jLabel34.setText("Área psicológica");
        jPanel8.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 21, -1, -1));

        antFamPsiText.setColumns(20);
        antFamPsiText.setRows(5);
        jScrollPane18.setViewportView(antFamPsiText);

        jPanel8.add(jScrollPane18, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 63, 740, -1));

        jLabel35.setForeground(new java.awt.Color(0, 0, 0));
        jLabel35.setText("Área psiquiátrica");
        jPanel8.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 164, -1, -1));

        antFamPsiqText.setColumns(20);
        antFamPsiqText.setRows(5);
        jScrollPane19.setViewportView(antFamPsiqText);

        jPanel8.add(jScrollPane19, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 198, 740, -1));

        jLabel36.setForeground(new java.awt.Color(0, 0, 0));
        jLabel36.setText("Otras patologías");
        jPanel8.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 299, -1, -1));

        antFamPatText.setColumns(20);
        antFamPatText.setRows(5);
        jScrollPane20.setViewportView(antFamPatText);

        jPanel8.add(jScrollPane20, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 333, 740, -1));

        editarAntFam.setBackground(new java.awt.Color(247, 220, 111));
        editarAntFam.setText("Guardar  Datos");
        editarAntFam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarAntFamActionPerformed(evt);
            }
        });
        jPanel8.add(editarAntFam, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 434, 144, -1));

        VolverAntFam.setBackground(new java.awt.Color(247, 220, 111));
        VolverAntFam.setText("Volver");
        VolverAntFam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverAntFamActionPerformed(evt);
            }
        });
        jPanel8.add(VolverAntFam, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 430, 129, -1));

        jTabbedPane1.addTab("Antecedentes familiares", jPanel8);

        jPanel3.setBackground(new java.awt.Color(193, 145, 42));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        familiaTable.setBackground(new java.awt.Color(193, 145, 42));
        familiaTable.setForeground(new java.awt.Color(0, 0, 0));
        familiaTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        familiaTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                familiaTableMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(familiaTable);

        jPanel3.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1047, 698));

        volverFam.setBackground(new java.awt.Color(247, 220, 111));
        volverFam.setText("Volver");
        volverFam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverFamActionPerformed(evt);
            }
        });
        jPanel3.add(volverFam, new org.netbeans.lib.awtextra.AbsoluteConstraints(1337, 6, 118, -1));

        ingresarFamiliar.setBackground(new java.awt.Color(247, 220, 111));
        ingresarFamiliar.setText("Ingresar Datos");
        ingresarFamiliar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresarFamiliarActionPerformed(evt);
            }
        });
        jPanel3.add(ingresarFamiliar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1053, 392, -1, -1));

        borrar.setBackground(new java.awt.Color(247, 220, 111));
        borrar.setText("Borrar Datos");
        borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarActionPerformed(evt);
            }
        });
        jPanel3.add(borrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1053, 660, -1, -1));

        jLabel43.setForeground(new java.awt.Color(0, 0, 0));
        jLabel43.setText("Nombre");
        jPanel3.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(1053, 22, -1, -1));

        famNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                famNombreActionPerformed(evt);
            }
        });
        jPanel3.add(famNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(1053, 56, 215, -1));

        jLabel44.setForeground(new java.awt.Color(0, 0, 0));
        jLabel44.setText("Parentesco");
        jPanel3.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(1053, 162, -1, -1));
        jPanel3.add(famParentesco, new org.netbeans.lib.awtextra.AbsoluteConstraints(1053, 196, 215, -1));

        jLabel45.setForeground(new java.awt.Color(0, 0, 0));
        jLabel45.setText("Edad");
        jPanel3.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(1053, 238, -1, -1));

        jLabel46.setForeground(new java.awt.Color(0, 0, 0));
        jLabel46.setText("Ocupacion");
        jPanel3.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(1053, 316, -1, -1));
        jPanel3.add(famOcupacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(1053, 350, 215, -1));
        jPanel3.add(famEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(1053, 272, 73, -1));

        jLabel47.setForeground(new java.awt.Color(0, 0, 0));
        jLabel47.setText("Apellido");
        jPanel3.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(1053, 98, -1, -1));

        famApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                famApellidoActionPerformed(evt);
            }
        });
        jPanel3.add(famApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(1053, 126, 215, -1));

        jTabbedPane1.addTab("Estructura y funcionalidad familiar", jPanel3);

        jPanel12.setBackground(new java.awt.Color(193, 145, 42));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel41.setForeground(new java.awt.Color(0, 0, 0));
        jLabel41.setText("IMPRESIÓN DIAGNÓSTICA");
        jPanel12.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 26, -1, -1));

        diagnosticoText.setColumns(20);
        diagnosticoText.setRows(5);
        jScrollPane25.setViewportView(diagnosticoText);

        jPanel12.add(jScrollPane25, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 48, 760, 110));

        jLabel42.setForeground(new java.awt.Color(0, 0, 0));
        jLabel42.setText("OBSERVACIONES GENERALES");
        jPanel12.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        observacionText.setColumns(20);
        observacionText.setRows(5);
        jScrollPane26.setViewportView(observacionText);

        jPanel12.add(jScrollPane26, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 760, 110));

        editarReporte.setBackground(new java.awt.Color(247, 220, 111));
        editarReporte.setText("Guardar Datos");
        editarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarReporteActionPerformed(evt);
            }
        });
        jPanel12.add(editarReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 50, 165, -1));

        volverReporte.setBackground(new java.awt.Color(247, 220, 111));
        volverReporte.setText("Volver");
        volverReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverReporteActionPerformed(evt);
            }
        });
        jPanel12.add(volverReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 100, 165, -1));

        jScrollPane28.setViewportView(jPanel12);

        jTabbedPane1.addTab("Reporte de sesion", jScrollPane28);

        jPanel11.setBackground(new java.awt.Color(193, 145, 42));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel37.setForeground(new java.awt.Color(0, 0, 0));
        jLabel37.setText("PERCEPCION Y LENGUAJE");
        jPanel11.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 18, -1, -1));

        lenguajeText.setColumns(20);
        lenguajeText.setRows(5);
        jScrollPane21.setViewportView(lenguajeText);

        jPanel11.add(jScrollPane21, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 48, 670, -1));

        jLabel38.setForeground(new java.awt.Color(0, 0, 0));
        jLabel38.setText("ESTADO EMOCIONAL");
        jPanel11.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 137, -1, -1));

        emocionalText.setColumns(20);
        emocionalText.setRows(5);
        jScrollPane22.setViewportView(emocionalText);

        jPanel11.add(jScrollPane22, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 159, 670, -1));

        jLabel39.setForeground(new java.awt.Color(0, 0, 0));
        jLabel39.setText("CONTACTO CON LA REALIDAD");
        jPanel11.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 248, -1, -1));

        realidadText.setColumns(20);
        realidadText.setRows(5);
        jScrollPane23.setViewportView(realidadText);

        jPanel11.add(jScrollPane23, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 270, 670, -1));

        jLabel40.setForeground(new java.awt.Color(0, 0, 0));
        jLabel40.setText("HIGIENE Y APARIENCIA PERSONAL");
        jPanel11.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 359, -1, 27));

        higieneText.setColumns(20);
        higieneText.setRows(5);
        jScrollPane24.setViewportView(higieneText);

        jPanel11.add(jScrollPane24, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 392, 670, -1));

        editarMental.setBackground(new java.awt.Color(247, 220, 111));
        editarMental.setText("Guardar Datos");
        editarMental.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarMentalActionPerformed(evt);
            }
        });
        jPanel11.add(editarMental, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 493, 120, -1));

        volverMental.setBackground(new java.awt.Color(247, 220, 111));
        volverMental.setText("Volver");
        volverMental.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverMentalActionPerformed(evt);
            }
        });
        jPanel11.add(volverMental, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 490, 138, -1));

        jScrollPane29.setViewportView(jPanel11);

        jTabbedPane1.addTab("Analisis del estado mental", jScrollPane29);

        jPanel13.setBackground(new java.awt.Color(193, 145, 42));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setForeground(new java.awt.Color(0, 0, 0));
        jLabel29.setText("¿Ha tenido alguna enfermedad grave?");
        jPanel13.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 22, -1, -1));

        enfermedadText.setColumns(20);
        enfermedadText.setRows(5);
        jScrollPane13.setViewportView(enfermedadText);

        jPanel13.add(jScrollPane13, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 48, 657, -1));

        jLabel30.setForeground(new java.awt.Color(0, 0, 0));
        jLabel30.setText("Accidentes/lesiones");
        jPanel13.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 143, -1, -1));

        accidenteText.setColumns(20);
        accidenteText.setRows(5);
        jScrollPane14.setViewportView(accidenteText);

        jPanel13.add(jScrollPane14, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 165, 657, -1));

        jLabel31.setForeground(new java.awt.Color(0, 0, 0));
        jLabel31.setText("¿Utiliza algún medicamento?");
        jPanel13.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 254, -1, -1));

        medicamentoText.setColumns(20);
        medicamentoText.setRows(5);
        jScrollPane15.setViewportView(medicamentoText);

        jPanel13.add(jScrollPane15, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 276, 657, -1));

        jLabel32.setForeground(new java.awt.Color(0, 0, 0));
        jLabel32.setText("Intervención quirúrgica");
        jPanel13.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 365, -1, -1));

        intervencionText.setColumns(20);
        intervencionText.setRows(5);
        jScrollPane16.setViewportView(intervencionText);

        jPanel13.add(jScrollPane16, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 387, 657, -1));

        jLabel33.setForeground(new java.awt.Color(0, 0, 0));
        jLabel33.setText("Utiliza lentes u otro dispositivo auxiliar");
        jPanel13.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 476, -1, -1));

        auxText.setColumns(20);
        auxText.setRows(5);
        jScrollPane17.setViewportView(auxText);

        jPanel13.add(jScrollPane17, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 498, 657, -1));

        volverClinico.setBackground(new java.awt.Color(247, 220, 111));
        volverClinico.setText("Volver");
        volverClinico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverClinicoActionPerformed(evt);
            }
        });
        jPanel13.add(volverClinico, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 587, 145, -1));

        editarClinico.setBackground(new java.awt.Color(247, 220, 111));
        editarClinico.setText("Guardar Datos");
        editarClinico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarClinicoActionPerformed(evt);
            }
        });
        jPanel13.add(editarClinico, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 587, 192, -1));

        jScrollPane30.setViewportView(jPanel13);

        jTabbedPane1.addTab("Antecedentes Clinicos", jScrollPane30);

        jPanel14.setBackground(new java.awt.Color(193, 145, 42));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Evolucion");
        jPanel14.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        evolucionText.setColumns(20);
        evolucionText.setRows(5);
        jScrollPane1.setViewportView(evolucionText);

        jPanel14.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 944, -1));

        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Causas");
        jPanel14.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        causasText.setColumns(20);
        causasText.setRows(5);
        jScrollPane3.setViewportView(causasText);

        jPanel14.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 944, -1));

        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Acciones realizadas en busca de solucion");
        jPanel14.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        accionesText.setColumns(20);
        accionesText.setRows(5);
        jScrollPane2.setViewportView(accionesText);

        jPanel14.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 944, -1));

        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Implicaciones (a nivel familiar, social, academico, etc.)");
        jPanel14.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, -1, -1));

        implicacionesText.setColumns(20);
        implicacionesText.setRows(5);
        jScrollPane4.setViewportView(implicacionesText);

        jPanel14.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 944, -1));

        EditarProblema.setBackground(new java.awt.Color(247, 220, 111));
        EditarProblema.setText("Editar Datos");
        EditarProblema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarProblemaActionPerformed(evt);
            }
        });
        jPanel14.add(EditarProblema, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 208, -1));

        VolverProblema.setBackground(new java.awt.Color(247, 220, 111));
        VolverProblema.setText("Volver");
        VolverProblema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverProblemaActionPerformed(evt);
            }
        });
        jPanel14.add(VolverProblema, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 460, 173, -1));

        jScrollPane31.setViewportView(jPanel14);

        jTabbedPane1.addTab("Definicion del Problema", jScrollPane31);

        jPanel1.setBackground(new java.awt.Color(193, 145, 42));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(nameText, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 40, 171, -1));

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Apellido");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 17, -1, -1));
        jPanel1.add(apellidoText, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 176, -1));

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Edad");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(649, 17, -1, -1));
        jPanel1.add(edadText, new org.netbeans.lib.awtextra.AbsoluteConstraints(649, 39, 123, -1));
        jPanel1.add(dateText, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 165, 143, -1));

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Nacimiento");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 135, -1, -1));

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Escolaridad");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 135, -1, -1));

        lvlText.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ninguno", "Primaria", "Secundaria", "Bachillerato", "Profesional", "Licenciatura", "Posgrado", "Doctorado" }));
        jPanel1.add(lvlText, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 165, 176, -1));

        religionText.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cristiano", "Catolico", "Judio", "Otro" }));
        jPanel1.add(religionText, new org.netbeans.lib.awtextra.AbsoluteConstraints(394, 168, 213, -1));

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Religion");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(394, 143, -1, -1));

        editar.setBackground(new java.awt.Color(247, 220, 111));
        editar.setText("Editar Datos");
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });
        jPanel1.add(editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 200, 143, -1));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Nombre");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 17, -1, -1));

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Ocupacion");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(394, 17, -1, -1));
        jPanel1.add(ocupacionText, new org.netbeans.lib.awtextra.AbsoluteConstraints(394, 40, 213, -1));

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Actividad Extra");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 77, -1, -1));
        jPanel1.add(actText, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 99, 171, -1));

        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Direccion");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 77, -1, -1));

        direccionText.setToolTipText("");
        jPanel1.add(direccionText, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 99, 176, -1));

        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Telefono");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(394, 77, -1, -1));
        jPanel1.add(telefonoText, new org.netbeans.lib.awtextra.AbsoluteConstraints(394, 99, 213, -1));

        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Asunto o Motivo de la consulta");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(649, 77, -1, -1));
        jPanel1.add(asuntoText, new org.netbeans.lib.awtextra.AbsoluteConstraints(649, 99, 172, -1));

        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Objetivo Terapeutico");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(649, 143, -1, -1));
        jPanel1.add(objText, new org.netbeans.lib.awtextra.AbsoluteConstraints(649, 169, 172, -1));

        jLabel48.setForeground(new java.awt.Color(0, 0, 0));
        jLabel48.setText("Fecha de ingreso");
        jPanel1.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 10, -1, -1));
        jPanel1.add(fechaIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 30, 130, -1));

        volver.setBackground(new java.awt.Color(247, 220, 111));
        volver.setText("Volver");
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });
        jPanel1.add(volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 60, 133, -1));

        jTabbedPane1.addTab("Informacion General", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1080, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 517, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverReporteActionPerformed
        // TODO add your handling code here:
        m.openMenu();
        m.closePrincipal();
    }//GEN-LAST:event_volverReporteActionPerformed

    private void editarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarReporteActionPerformed
        // TODO add your handling code here:
        m.updateReporte(id, diagnosticoText.getText(), observacionText.getText());
    }//GEN-LAST:event_editarReporteActionPerformed

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        // TODO add your handling code here:
       m.openMenu();
        m.closePrincipal();
    }//GEN-LAST:event_volverActionPerformed

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        // TODO add your handling code here:
        if (dateText.getDate() == null) {
            JOptionPane.showMessageDialog(null, "FECHA INVALIDA");
        } else {
            String d = Integer.toString(dateText.getCalendar().get(Calendar.DAY_OF_MONTH));
            String mes = Integer.toString(dateText.getCalendar().get(Calendar.MONTH) + 1);
            String y = Integer.toString(dateText.getCalendar().get(Calendar.YEAR));
            m.updatePaciente(id, nameText.getText(), apellidoText.getText(), (int) edadText.getValue(), m.getFecha(d, mes, y),
                    lvlText.getSelectedItem().toString(), religionText.getSelectedItem().toString(), ocupacionText.getText(), actText.getText(), direccionText.getText(), telefonoText.getText(),
                    asuntoText.getText(), objText.getText());
        }
    }//GEN-LAST:event_editarActionPerformed

    private void famApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_famApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_famApellidoActionPerformed

    private void famNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_famNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_famNombreActionPerformed

    private void borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarActionPerformed
        // TODO add your handling code here:
        if (famID == 0) {
            JOptionPane.showMessageDialog(null, "FAVOR DE SELECCIONAR A UN INDIVIDUO!");
        } else {
            m.deleteFamiliar(famID);
            showTableData(m.getFamiliaress(id));
        }
    }//GEN-LAST:event_borrarActionPerformed

    private void ingresarFamiliarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresarFamiliarActionPerformed
        // TODO add your handling code here:
        if (m.insertFamiliar(id, famNombre.getText(), famApellido.getText(), famParentesco.getText(), (int) famEdad.getValue(), famOcupacion.getText()) == true) {

            famNombre.setText("");
            famApellido.setText("");
            famParentesco.setText("");
            famEdad.setValue(0);
            famOcupacion.setText("");
            showTableData(m.getFamiliaress(id));
        }
    }//GEN-LAST:event_ingresarFamiliarActionPerformed

    private void volverFamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverFamActionPerformed
        // TODO add your handling code here:
      m.openMenu();
        m.closePrincipal();
    }//GEN-LAST:event_volverFamActionPerformed

    private void familiaTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_familiaTableMouseClicked
        // TODO add your handling code here:
        famID = (int) familiaTable.getValueAt(familiaTable.getSelectedRow(), 0);
    }//GEN-LAST:event_familiaTableMouseClicked

    private void volverMentalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverMentalActionPerformed
        // TODO add your handling code here:
      m.openMenu();
        m.closePrincipal();
    }//GEN-LAST:event_volverMentalActionPerformed

    private void editarMentalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarMentalActionPerformed
        // TODO add your handling code here:
        m.updateMental(id, lenguajeText.getText(), emocionalText.getText(), realidadText.getText(), higieneText.getText());
    }//GEN-LAST:event_editarMentalActionPerformed

    private void VolverAntFamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverAntFamActionPerformed
        // TODO add your handling code here:
      m.openMenu();
        m.closePrincipal();
    }//GEN-LAST:event_VolverAntFamActionPerformed

    private void editarAntFamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarAntFamActionPerformed
        // TODO add your handling code here:
        m.updateFamiliares(id, antFamPsiText.getText(), antFamPsiqText.getText(), antFamPatText.getText());
    }//GEN-LAST:event_editarAntFamActionPerformed

    private void volverClinicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverClinicoActionPerformed
        // TODO add your handling code here:
        m.openMenu();
        m.closePrincipal();
    }//GEN-LAST:event_volverClinicoActionPerformed

    private void editarClinicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarClinicoActionPerformed
        // TODO add your handling code here:
        m.updateClinicos(id, enfermedadText.getText(), accidenteText.getText(), medicamentoText.getText(), intervencionText.getText(), auxText.getText());
    }//GEN-LAST:event_editarClinicoActionPerformed

    private void volverHabitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverHabitoActionPerformed
        // TODO add your handling code here:
       m.openMenu();
        m.closePrincipal();
    }//GEN-LAST:event_volverHabitoActionPerformed

    private void editarHabitosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarHabitosActionPerformed
        // TODO add your handling code here:
        m.updateHabitos(id, dreamText.getText(), alimentoText.getText(), antPsiText.getText());
    }//GEN-LAST:event_editarHabitosActionPerformed

    private void volverSexualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverSexualActionPerformed
        // TODO add your handling code here:
       m.openMenu();
        m.closePrincipal();
    }//GEN-LAST:event_volverSexualActionPerformed

    private void editarSexualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarSexualActionPerformed
        // TODO add your handling code here:
        String embarazo = "";
        String traumas = "";
        if (siEmbarazo.isSelected()) {
            embarazo = "Si";
            if (siTrauma.isSelected()) {
                traumas = "Si";
                if ((int) embarazoEdad.getValue()<=0) {
                     JOptionPane.showMessageDialog(null, "LA EDAD NO PUEDE SER MENOR O IGUAL A 0!!");
                }
                else
                {
                     m.updateSexual(id, antSexualText.getText(), embarazo, (int) embarazoEdad.getValue(), preferenciaText.getText(), traumas, infoTraumaText.getText());
                }
               
            } else if (noTrauma.isSelected()) {
                traumas = "No";
                if ((int) embarazoEdad.getValue()<=0) {
                     JOptionPane.showMessageDialog(null, "LA EDAD NO PUEDE SER MENOR O IGUAL A 0!!");
                }else
                {
                    m.updateSexual(id, antSexualText.getText(), embarazo, (int) embarazoEdad.getValue(), preferenciaText.getText(), traumas, "");
                }
                
            } else {
                JOptionPane.showMessageDialog(null, "DATOS DE SELECCION SI/NO NO MARCADOS!");
            }
        } else if (noEmbarazo.isSelected()) {
            embarazo = "No";
            if (siTrauma.isSelected()) {
                traumas = "Si";
                m.updateSexual(id, antSexualText.getText(), embarazo, 0, preferenciaText.getText(), traumas, infoTraumaText.getText());
            } else if (noTrauma.isSelected()) {
                traumas = "No";
                m.updateSexual(id, antSexualText.getText(), embarazo, 0, preferenciaText.getText(), traumas, "");
            } else {
                JOptionPane.showMessageDialog(null, "DATOS DE SELECCION SI/NO NO MARCADOS!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "DATOS DE SELECCION SI/NO NO MARCADOS!");
        }
    }//GEN-LAST:event_editarSexualActionPerformed

    private void noTraumaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noTraumaActionPerformed
        // TODO add your handling code here:
        infoTraumaText.setEnabled(false);
        siTrauma.setSelected(false);
    }//GEN-LAST:event_noTraumaActionPerformed

    private void siTraumaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siTraumaActionPerformed
        // TODO add your handling code here:
        infoTraumaText.setEnabled(true);
        noTrauma.setSelected(false);
    }//GEN-LAST:event_siTraumaActionPerformed

    private void noEmbarazoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noEmbarazoActionPerformed
        // TODO add your handling code here:
        embarazoEdad.setEnabled(false);
        siEmbarazo.setSelected(false);
    }//GEN-LAST:event_noEmbarazoActionPerformed

    private void siEmbarazoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siEmbarazoActionPerformed
        // TODO add your handling code here:
        embarazoEdad.setEnabled(true);
        noEmbarazo.setSelected(false);
    }//GEN-LAST:event_siEmbarazoActionPerformed

    private void volverSocialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverSocialActionPerformed
        // TODO add your handling code here:
        m.openMenu();
        m.closePrincipal();
    }//GEN-LAST:event_volverSocialActionPerformed

    private void editarSocialesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarSocialesActionPerformed
        // TODO add your handling code here:
        m.updateSociales(id, socialText.getText(), laboralText.getText(), viviendaText.getText());
    }//GEN-LAST:event_editarSocialesActionPerformed

    private void EditarProblemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarProblemaActionPerformed
        // TODO add your handling code here:
        m.updateProblema(id, evolucionText.getText(), causasText.getText(), accionesText.getText(), implicacionesText.getText());
    }//GEN-LAST:event_EditarProblemaActionPerformed

    private void VolverProblemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverProblemaActionPerformed
        // TODO add your handling code here:
       m.openMenu();
        m.closePrincipal();
    }//GEN-LAST:event_VolverProblemaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(principalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(principalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(principalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(principalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new principalView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EditarProblema;
    private javax.swing.JButton VolverAntFam;
    private javax.swing.JButton VolverProblema;
    private javax.swing.JTextArea accidenteText;
    private javax.swing.JTextArea accionesText;
    private javax.swing.JTextField actText;
    private javax.swing.JTextArea alimentoText;
    private javax.swing.JTextArea antFamPatText;
    private javax.swing.JTextArea antFamPsiText;
    private javax.swing.JTextArea antFamPsiqText;
    private javax.swing.JTextArea antPsiText;
    private javax.swing.JTextArea antSexualText;
    private javax.swing.JTextField apellidoText;
    private javax.swing.JTextField asuntoText;
    private javax.swing.JTextArea auxText;
    private javax.swing.JButton borrar;
    private javax.swing.JTextArea causasText;
    private com.toedter.calendar.JDateChooser dateText;
    private javax.swing.JTextArea diagnosticoText;
    private javax.swing.JTextField direccionText;
    private javax.swing.JTextArea dreamText;
    private javax.swing.JSpinner edadText;
    private javax.swing.JButton editar;
    private javax.swing.JButton editarAntFam;
    private javax.swing.JButton editarClinico;
    private javax.swing.JButton editarHabitos;
    private javax.swing.JButton editarMental;
    private javax.swing.JButton editarReporte;
    private javax.swing.JButton editarSexual;
    private javax.swing.JButton editarSociales;
    private javax.swing.JSpinner embarazoEdad;
    private javax.swing.JTextArea emocionalText;
    private javax.swing.JTextArea enfermedadText;
    private javax.swing.JTextArea evolucionText;
    private javax.swing.JTextField famApellido;
    private javax.swing.JSpinner famEdad;
    private javax.swing.JTextField famNombre;
    private javax.swing.JTextField famOcupacion;
    private javax.swing.JTextField famParentesco;
    private javax.swing.JTable familiaTable;
    private javax.swing.JTextField fechaIngreso;
    private javax.swing.JTextArea higieneText;
    private javax.swing.JTextArea implicacionesText;
    private javax.swing.JTextArea infoTraumaText;
    private javax.swing.JButton ingresarFamiliar;
    private javax.swing.JTextArea intervencionText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane24;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane26;
    private javax.swing.JScrollPane jScrollPane27;
    private javax.swing.JScrollPane jScrollPane28;
    private javax.swing.JScrollPane jScrollPane29;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane30;
    private javax.swing.JScrollPane jScrollPane31;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea laboralText;
    private javax.swing.JTextArea lenguajeText;
    private javax.swing.JComboBox<String> lvlText;
    private javax.swing.JTextArea medicamentoText;
    private javax.swing.JTextField nameText;
    private javax.swing.JRadioButton noEmbarazo;
    private javax.swing.JRadioButton noTrauma;
    private javax.swing.JTextField objText;
    private javax.swing.JTextArea observacionText;
    private javax.swing.JTextField ocupacionText;
    private javax.swing.JTextField preferenciaText;
    private javax.swing.JTextArea realidadText;
    private javax.swing.JComboBox<String> religionText;
    private javax.swing.JRadioButton siEmbarazo;
    private javax.swing.JRadioButton siTrauma;
    private javax.swing.JTextArea socialText;
    private javax.swing.JTextField telefonoText;
    private javax.swing.JTextArea viviendaText;
    private javax.swing.JButton volver;
    private javax.swing.JButton volverClinico;
    private javax.swing.JButton volverFam;
    private javax.swing.JButton volverHabito;
    private javax.swing.JButton volverMental;
    private javax.swing.JButton volverReporte;
    private javax.swing.JButton volverSexual;
    private javax.swing.JButton volverSocial;
    // End of variables declaration//GEN-END:variables
private motor m;
    private int id;
    private int famID;
}
