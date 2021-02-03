/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import java.awt.Image;
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
          ImageIcon background = new ImageIcon(getClass().getClassLoader().getResource("resources/imagenes/CEPAC_Logo.png"));

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
  try {
        Image i = ImageIO.read(new FileInputStream("imagenes/CEPAC_Logo.png"));
        
            setIconImage(i);
        } catch (IOException ex) {
            Logger.getLogger(LoginView.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        socialText = new javax.swing.JTextArea();
        jScrollPane7 = new javax.swing.JScrollPane();
        laboralText = new javax.swing.JTextArea();
        jScrollPane8 = new javax.swing.JScrollPane();
        viviendaText = new javax.swing.JTextArea();
        editarSociales = new javax.swing.JButton();
        volverSocial = new javax.swing.JButton();
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
        setResizable(false);

        jTabbedPane1.setBackground(new java.awt.Color(247, 220, 111));
        jTabbedPane1.setForeground(new java.awt.Color(0, 0, 0));
        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

        jPanel4.setBackground(new java.awt.Color(193, 145, 42));

        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Entorno Social");

        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Entorno Laboral");

        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("Entorno de Vivienda");

        socialText.setColumns(20);
        socialText.setRows(5);
        jScrollPane6.setViewportView(socialText);

        laboralText.setColumns(20);
        laboralText.setRows(5);
        jScrollPane7.setViewportView(laboralText);

        viviendaText.setColumns(20);
        viviendaText.setRows(5);
        jScrollPane8.setViewportView(viviendaText);

        editarSociales.setBackground(new java.awt.Color(247, 220, 111));
        editarSociales.setText("Guardar Datos");
        editarSociales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarSocialesActionPerformed(evt);
            }
        });

        volverSocial.setBackground(new java.awt.Color(247, 220, 111));
        volverSocial.setText("Volver");
        volverSocial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverSocialActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(editarSociales)
                    .addComponent(jLabel19)
                    .addComponent(jLabel18)
                    .addComponent(jLabel17)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 1045, Short.MAX_VALUE)
                    .addComponent(jScrollPane7)
                    .addComponent(jScrollPane8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 230, Short.MAX_VALUE)
                .addComponent(volverSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17)
                    .addComponent(volverSocial))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel18)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel19)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(editarSociales)
                .addContainerGap(230, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Exploracion de redes sociales", jPanel4);

        jPanel5.setBackground(new java.awt.Color(193, 145, 42));

        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("Antecedentes de abuso sexual");

        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setText("Embarazos");

        jLabel22.setForeground(new java.awt.Color(0, 0, 0));
        jLabel22.setText("¿A qué edad?");

        jLabel23.setForeground(new java.awt.Color(0, 0, 0));
        jLabel23.setText("Preferencia Sexual");

        jLabel24.setForeground(new java.awt.Color(0, 0, 0));
        jLabel24.setText("Exposicion a eventos traumaticos en esta area");

        siEmbarazo.setBackground(new java.awt.Color(193, 145, 42));
        siEmbarazo.setForeground(new java.awt.Color(0, 0, 0));
        siEmbarazo.setText("Si");
        siEmbarazo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siEmbarazoActionPerformed(evt);
            }
        });

        noEmbarazo.setBackground(new java.awt.Color(193, 145, 42));
        noEmbarazo.setForeground(new java.awt.Color(0, 0, 0));
        noEmbarazo.setText("No");
        noEmbarazo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noEmbarazoActionPerformed(evt);
            }
        });

        siTrauma.setBackground(new java.awt.Color(193, 145, 42));
        siTrauma.setForeground(new java.awt.Color(0, 0, 0));
        siTrauma.setText("Si");
        siTrauma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siTraumaActionPerformed(evt);
            }
        });

        noTrauma.setBackground(new java.awt.Color(193, 145, 42));
        noTrauma.setForeground(new java.awt.Color(0, 0, 0));
        noTrauma.setText("No");
        noTrauma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noTraumaActionPerformed(evt);
            }
        });

        jLabel26.setForeground(new java.awt.Color(0, 0, 0));
        jLabel26.setText("¿Cuáles?");

        infoTraumaText.setColumns(20);
        infoTraumaText.setRows(5);
        jScrollPane9.setViewportView(infoTraumaText);

        antSexualText.setColumns(20);
        antSexualText.setRows(5);
        jScrollPane27.setViewportView(antSexualText);

        editarSexual.setBackground(new java.awt.Color(247, 220, 111));
        editarSexual.setText("Guardar Datos");
        editarSexual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarSexualActionPerformed(evt);
            }
        });

        volverSexual.setBackground(new java.awt.Color(247, 220, 111));
        volverSexual.setText("Volver");
        volverSexual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverSexualActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel24)
                        .addGap(401, 401, 401)
                        .addComponent(volverSexual, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(siEmbarazo)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(embarazoEdad, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(preferenciaText, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane27, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel22)
                                    .addComponent(noEmbarazo))
                                .addGap(50, 50, 50)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(editarSexual)
                                    .addComponent(noTrauma)
                                    .addComponent(siTrauma)
                                    .addComponent(jLabel26)
                                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 225, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(volverSexual)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(siTrauma)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(noTrauma)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel26)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(siEmbarazo)
                        .addGap(18, 18, 18)
                        .addComponent(noEmbarazo)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel22)
                        .addGap(18, 18, 18)
                        .addComponent(embarazoEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel23)
                        .addGap(18, 18, 18)
                        .addComponent(preferenciaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editarSexual)))
                .addContainerGap(298, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Historia sexual", jPanel5);

        jPanel6.setBackground(new java.awt.Color(193, 145, 42));

        jLabel25.setForeground(new java.awt.Color(0, 0, 0));
        jLabel25.setText("Hábitos de sueño");

        jLabel27.setForeground(new java.awt.Color(0, 0, 0));
        jLabel27.setText("Hábitos alimenticios");

        jLabel28.setForeground(new java.awt.Color(0, 0, 0));
        jLabel28.setText("Antecedentes psicológicos paciente");

        dreamText.setColumns(20);
        dreamText.setRows(5);
        jScrollPane10.setViewportView(dreamText);

        alimentoText.setColumns(20);
        alimentoText.setRows(5);
        jScrollPane11.setViewportView(alimentoText);

        antPsiText.setColumns(20);
        antPsiText.setRows(5);
        jScrollPane12.setViewportView(antPsiText);

        editarHabitos.setBackground(new java.awt.Color(247, 220, 111));
        editarHabitos.setText("Guardar Datos");
        editarHabitos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarHabitosActionPerformed(evt);
            }
        });

        volverHabito.setBackground(new java.awt.Color(247, 220, 111));
        volverHabito.setText("Volver");
        volverHabito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverHabitoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(editarHabitos)
                    .addComponent(jLabel28)
                    .addComponent(jLabel27)
                    .addComponent(jLabel25)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 1244, Short.MAX_VALUE)
                    .addComponent(jScrollPane11)
                    .addComponent(jScrollPane10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(volverHabito, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel25)
                    .addComponent(volverHabito))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel27)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(jLabel28)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(editarHabitos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Habitos", jPanel6);

        jPanel8.setBackground(new java.awt.Color(193, 145, 42));

        jLabel34.setForeground(new java.awt.Color(0, 0, 0));
        jLabel34.setText("Área psicológica");

        antFamPsiText.setColumns(20);
        antFamPsiText.setRows(5);
        jScrollPane18.setViewportView(antFamPsiText);

        jLabel35.setForeground(new java.awt.Color(0, 0, 0));
        jLabel35.setText("Área psiquiátrica");

        antFamPsiqText.setColumns(20);
        antFamPsiqText.setRows(5);
        jScrollPane19.setViewportView(antFamPsiqText);

        jLabel36.setForeground(new java.awt.Color(0, 0, 0));
        jLabel36.setText("Otras patologías");

        antFamPatText.setColumns(20);
        antFamPatText.setRows(5);
        jScrollPane20.setViewportView(antFamPatText);

        editarAntFam.setBackground(new java.awt.Color(247, 220, 111));
        editarAntFam.setText("Guardar  Datos");
        editarAntFam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarAntFamActionPerformed(evt);
            }
        });

        VolverAntFam.setBackground(new java.awt.Color(247, 220, 111));
        VolverAntFam.setText("Volver");
        VolverAntFam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverAntFamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel36)
                    .addComponent(jLabel35)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1214, Short.MAX_VALUE)
                        .addComponent(VolverAntFam, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(editarAntFam, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1254, Short.MAX_VALUE)
                        .addComponent(jScrollPane19, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane18, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(VolverAntFam))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel35)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel36)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(editarAntFam)
                .addContainerGap(228, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Antecedentes familiares", jPanel8);

        jPanel3.setBackground(new java.awt.Color(193, 145, 42));

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

        volverFam.setBackground(new java.awt.Color(247, 220, 111));
        volverFam.setText("Volver");
        volverFam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverFamActionPerformed(evt);
            }
        });

        ingresarFamiliar.setBackground(new java.awt.Color(247, 220, 111));
        ingresarFamiliar.setText("Ingresar Datos");
        ingresarFamiliar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresarFamiliarActionPerformed(evt);
            }
        });

        borrar.setBackground(new java.awt.Color(247, 220, 111));
        borrar.setText("Borrar Datos");
        borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarActionPerformed(evt);
            }
        });

        jLabel43.setForeground(new java.awt.Color(0, 0, 0));
        jLabel43.setText("Nombre");

        famNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                famNombreActionPerformed(evt);
            }
        });

        jLabel44.setForeground(new java.awt.Color(0, 0, 0));
        jLabel44.setText("Parentesco");

        jLabel45.setForeground(new java.awt.Color(0, 0, 0));
        jLabel45.setText("Edad");

        jLabel46.setForeground(new java.awt.Color(0, 0, 0));
        jLabel46.setText("Ocupacion");

        jLabel47.setForeground(new java.awt.Color(0, 0, 0));
        jLabel47.setText("Apellido");

        famApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                famApellidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 1047, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(borrar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel43)
                            .addComponent(jLabel44)
                            .addComponent(jLabel45)
                            .addComponent(jLabel46)
                            .addComponent(famEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(famNombre)
                            .addComponent(famParentesco)
                            .addComponent(famOcupacion, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                            .addComponent(ingresarFamiliar)
                            .addComponent(jLabel47)
                            .addComponent(famApellido))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                        .addComponent(volverFam, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel43)
                    .addComponent(volverFam))
                .addGap(18, 18, 18)
                .addComponent(famNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel47)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(famApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel44)
                .addGap(18, 18, 18)
                .addComponent(famParentesco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel45)
                .addGap(18, 18, 18)
                .addComponent(famEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel46)
                .addGap(18, 18, 18)
                .addComponent(famOcupacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ingresarFamiliar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(borrar)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Estructura y funcionalidad familiar", jPanel3);

        jPanel12.setBackground(new java.awt.Color(193, 145, 42));

        jLabel41.setForeground(new java.awt.Color(0, 0, 0));
        jLabel41.setText("IMPRESIÓN DIAGNÓSTICA");

        diagnosticoText.setColumns(20);
        diagnosticoText.setRows(5);
        jScrollPane25.setViewportView(diagnosticoText);

        jLabel42.setForeground(new java.awt.Color(0, 0, 0));
        jLabel42.setText("OBSERVACIONES GENERALES");

        observacionText.setColumns(20);
        observacionText.setRows(5);
        jScrollPane26.setViewportView(observacionText);

        editarReporte.setBackground(new java.awt.Color(247, 220, 111));
        editarReporte.setText("Guardar Datos");
        editarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarReporteActionPerformed(evt);
            }
        });

        volverReporte.setBackground(new java.awt.Color(247, 220, 111));
        volverReporte.setText("Volver");
        volverReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverReporteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane26, javax.swing.GroupLayout.DEFAULT_SIZE, 1063, Short.MAX_VALUE)
                    .addComponent(jLabel42)
                    .addComponent(jLabel41)
                    .addComponent(jScrollPane25))
                .addGap(29, 29, 29)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(volverReporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(editarReporte, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
                .addContainerGap(175, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel41)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane25, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(editarReporte)
                        .addGap(24, 24, 24)
                        .addComponent(volverReporte)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel42)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane26, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane28.setViewportView(jPanel12);

        jTabbedPane1.addTab("Reporte de sesion", jScrollPane28);

        jPanel11.setBackground(new java.awt.Color(193, 145, 42));

        jLabel37.setForeground(new java.awt.Color(0, 0, 0));
        jLabel37.setText("PERCEPCION Y LENGUAJE");

        lenguajeText.setColumns(20);
        lenguajeText.setRows(5);
        jScrollPane21.setViewportView(lenguajeText);

        jLabel38.setForeground(new java.awt.Color(0, 0, 0));
        jLabel38.setText("ESTADO EMOCIONAL");

        emocionalText.setColumns(20);
        emocionalText.setRows(5);
        jScrollPane22.setViewportView(emocionalText);

        jLabel39.setForeground(new java.awt.Color(0, 0, 0));
        jLabel39.setText("CONTACTO CON LA REALIDAD");

        realidadText.setColumns(20);
        realidadText.setRows(5);
        jScrollPane23.setViewportView(realidadText);

        jLabel40.setForeground(new java.awt.Color(0, 0, 0));
        jLabel40.setText("HIGIENE Y APARIENCIA PERSONAL");

        higieneText.setColumns(20);
        higieneText.setRows(5);
        jScrollPane24.setViewportView(higieneText);

        editarMental.setBackground(new java.awt.Color(247, 220, 111));
        editarMental.setText("Guardar Datos");
        editarMental.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarMentalActionPerformed(evt);
            }
        });

        volverMental.setBackground(new java.awt.Color(247, 220, 111));
        volverMental.setText("Volver");
        volverMental.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverMentalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(editarMental, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel40, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel39, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel38, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane23, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1269, Short.MAX_VALUE)
                            .addComponent(jScrollPane22, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane21, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane24, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(volverMental, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(volverMental))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(editarMental)
                .addContainerGap(174, Short.MAX_VALUE))
        );

        jScrollPane29.setViewportView(jPanel11);

        jTabbedPane1.addTab("Analisis del estado mental", jScrollPane29);

        jPanel13.setBackground(new java.awt.Color(193, 145, 42));

        jLabel29.setForeground(new java.awt.Color(0, 0, 0));
        jLabel29.setText("¿Ha tenido alguna enfermedad grave?");

        enfermedadText.setColumns(20);
        enfermedadText.setRows(5);
        jScrollPane13.setViewportView(enfermedadText);

        jLabel30.setForeground(new java.awt.Color(0, 0, 0));
        jLabel30.setText("Accidentes/lesiones");

        accidenteText.setColumns(20);
        accidenteText.setRows(5);
        jScrollPane14.setViewportView(accidenteText);

        jLabel31.setForeground(new java.awt.Color(0, 0, 0));
        jLabel31.setText("¿Utiliza algún medicamento?");

        medicamentoText.setColumns(20);
        medicamentoText.setRows(5);
        jScrollPane15.setViewportView(medicamentoText);

        jLabel32.setForeground(new java.awt.Color(0, 0, 0));
        jLabel32.setText("Intervención quirúrgica");

        intervencionText.setColumns(20);
        intervencionText.setRows(5);
        jScrollPane16.setViewportView(intervencionText);

        jLabel33.setForeground(new java.awt.Color(0, 0, 0));
        jLabel33.setText("Utiliza lentes u otro dispositivo auxiliar");

        auxText.setColumns(20);
        auxText.setRows(5);
        jScrollPane17.setViewportView(auxText);

        volverClinico.setBackground(new java.awt.Color(247, 220, 111));
        volverClinico.setText("Volver");
        volverClinico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverClinicoActionPerformed(evt);
            }
        });

        editarClinico.setBackground(new java.awt.Color(247, 220, 111));
        editarClinico.setText("Guardar Datos");
        editarClinico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarClinicoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(editarClinico, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30)
                            .addComponent(jLabel31)
                            .addComponent(jLabel32)
                            .addComponent(jLabel33)
                            .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 1081, Short.MAX_VALUE)
                            .addComponent(jScrollPane15)
                            .addComponent(jScrollPane13)
                            .addComponent(jScrollPane14)
                            .addComponent(jScrollPane17))
                        .addContainerGap(371, Short.MAX_VALUE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(volverClinico, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(volverClinico))
                .addGap(2, 2, 2)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editarClinico)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        jScrollPane30.setViewportView(jPanel13);

        jTabbedPane1.addTab("Antecedentes Clinicos", jScrollPane30);

        jPanel14.setBackground(new java.awt.Color(193, 145, 42));

        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Evolucion");

        evolucionText.setColumns(20);
        evolucionText.setRows(5);
        jScrollPane1.setViewportView(evolucionText);

        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Causas");

        causasText.setColumns(20);
        causasText.setRows(5);
        jScrollPane3.setViewportView(causasText);

        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Acciones realizadas en busca de solucion");

        accionesText.setColumns(20);
        accionesText.setRows(5);
        jScrollPane2.setViewportView(accionesText);

        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Implicaciones (a nivel familiar, social, academico, etc.)");

        implicacionesText.setColumns(20);
        implicacionesText.setRows(5);
        jScrollPane4.setViewportView(implicacionesText);

        EditarProblema.setBackground(new java.awt.Color(247, 220, 111));
        EditarProblema.setText("Editar Datos");
        EditarProblema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarProblemaActionPerformed(evt);
            }
        });

        VolverProblema.setBackground(new java.awt.Color(247, 220, 111));
        VolverProblema.setText("Volver");
        VolverProblema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverProblemaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1194, Short.MAX_VALUE)
                            .addComponent(jScrollPane3)
                            .addComponent(jScrollPane2)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane4))
                        .addGap(79, 79, 79)
                        .addComponent(VolverProblema, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel14)
                            .addComponent(jLabel16)
                            .addComponent(EditarProblema, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(VolverProblema))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EditarProblema)
                .addContainerGap(209, Short.MAX_VALUE))
        );

        jScrollPane31.setViewportView(jPanel14);

        jTabbedPane1.addTab("Definicion del Problema", jScrollPane31);

        jPanel1.setBackground(new java.awt.Color(193, 145, 42));

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Apellido");

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Edad");

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Nacimiento");

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Escolaridad");

        lvlText.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ninguno", "Primaria", "Secundaria", "Bachillerato", "Profesional", "Licenciatura", "Posgrado", "Doctorado" }));

        religionText.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cristiano", "Catolico", "Judio", "Otro" }));

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Religion");

        editar.setBackground(new java.awt.Color(247, 220, 111));
        editar.setText("Editar Datos");
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Nombre");

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Ocupacion");

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Actividad Extra");

        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Direccion");

        direccionText.setToolTipText("");

        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Telefono");

        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Asunto o Motivo de la consulta");

        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Objetivo Terapeutico");

        jLabel48.setForeground(new java.awt.Color(0, 0, 0));
        jLabel48.setText("Fecha de ingreso");

        volver.setBackground(new java.awt.Color(247, 220, 111));
        volver.setText("Volver");
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(editar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dateText, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1)
                            .addComponent(jLabel8)
                            .addComponent(nameText, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                            .addComponent(actText))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(jLabel9)
                            .addComponent(jLabel5)
                            .addComponent(apellidoText)
                            .addComponent(direccionText)
                            .addComponent(lvlText, 0, 176, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(religionText, javax.swing.GroupLayout.Alignment.LEADING, 0, 213, Short.MAX_VALUE)
                                .addComponent(ocupacionText, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(telefonoText, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel6))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(edadText, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(166, 166, 166)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel48)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 287, Short.MAX_VALUE)
                                        .addComponent(volver, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(fechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(asuntoText, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(objText, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7)
                    .addComponent(jLabel3)
                    .addComponent(jLabel48)
                    .addComponent(volver))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(apellidoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ocupacionText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edadText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(actText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(direccionText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(telefonoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(asuntoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel12))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(religionText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(objText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(495, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lvlText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editar)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("Informacion General", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverReporteActionPerformed
        // TODO add your handling code here:
        m.openPacientes();
        m.closePrincipal();
    }//GEN-LAST:event_volverReporteActionPerformed

    private void editarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarReporteActionPerformed
        // TODO add your handling code here:
        m.updateReporte(id, diagnosticoText.getText(), observacionText.getText());
    }//GEN-LAST:event_editarReporteActionPerformed

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        // TODO add your handling code here:
        m.openPacientes();
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
        m.openPacientes();
        m.closePrincipal();
    }//GEN-LAST:event_volverFamActionPerformed

    private void familiaTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_familiaTableMouseClicked
        // TODO add your handling code here:
        famID = (int) familiaTable.getValueAt(familiaTable.getSelectedRow(), 0);
    }//GEN-LAST:event_familiaTableMouseClicked

    private void volverMentalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverMentalActionPerformed
        // TODO add your handling code here:
        m.openPacientes();
        m.closePrincipal();
    }//GEN-LAST:event_volverMentalActionPerformed

    private void editarMentalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarMentalActionPerformed
        // TODO add your handling code here:
        m.updateMental(id, lenguajeText.getText(), emocionalText.getText(), realidadText.getText(), higieneText.getText());
    }//GEN-LAST:event_editarMentalActionPerformed

    private void VolverAntFamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverAntFamActionPerformed
        // TODO add your handling code here:
        m.openPacientes();
        m.closePrincipal();
    }//GEN-LAST:event_VolverAntFamActionPerformed

    private void editarAntFamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarAntFamActionPerformed
        // TODO add your handling code here:
        m.updateFamiliares(id, antFamPsiText.getText(), antFamPsiqText.getText(), antFamPatText.getText());
    }//GEN-LAST:event_editarAntFamActionPerformed

    private void volverClinicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverClinicoActionPerformed
        // TODO add your handling code here:
        m.openPacientes();
        m.closePrincipal();
    }//GEN-LAST:event_volverClinicoActionPerformed

    private void editarClinicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarClinicoActionPerformed
        // TODO add your handling code here:
        m.updateClinicos(id, enfermedadText.getText(), accidenteText.getText(), medicamentoText.getText(), intervencionText.getText(), auxText.getText());
    }//GEN-LAST:event_editarClinicoActionPerformed

    private void volverHabitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverHabitoActionPerformed
        // TODO add your handling code here:
        m.openPacientes();
        m.closePrincipal();
    }//GEN-LAST:event_volverHabitoActionPerformed

    private void editarHabitosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarHabitosActionPerformed
        // TODO add your handling code here:
        m.updateHabitos(id, dreamText.getText(), alimentoText.getText(), antPsiText.getText());
    }//GEN-LAST:event_editarHabitosActionPerformed

    private void volverSexualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverSexualActionPerformed
        // TODO add your handling code here:
        m.openPacientes();
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
                m.updateSexual(id, antSexualText.getText(), embarazo, (int) embarazoEdad.getValue(), preferenciaText.getText(), traumas, infoTraumaText.getText());
            } else {
                traumas = "No";
                m.updateSexual(id, antSexualText.getText(), embarazo, (int) embarazoEdad.getValue(), preferenciaText.getText(), traumas, "");
            }
        } else {
            embarazo = "No";
            if (siTrauma.isSelected()) {
                traumas = "Si";
                m.updateSexual(id, antSexualText.getText(), embarazo, 0, preferenciaText.getText(), traumas, infoTraumaText.getText());
            } else {
                traumas = "No";
                m.updateSexual(id, antSexualText.getText(), embarazo, 0, preferenciaText.getText(), traumas, "");
            }
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
        m.openPacientes();
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
        m.openPacientes();
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
