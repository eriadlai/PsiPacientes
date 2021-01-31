/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PDF;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import psipacientes.motor;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class GeneratePDF {
    //Nombre del fichero <strong>PDF</strong> Resultante de la ejecucion

    public static final String RESULT = "test.pdf";
//Textos
    public static final String SEPARADOR = "———————————————————————————————————————-";

//===============================================================================================
  
    public GeneratePDF() {

    }

    public void setMotor(motor m) {
        this.m = m;
    }
   
//===========================================================================================
    public void createPDF(int id, File pdfNewFile) {
        try {
            Document document = new Document(PageSize.A4, 50, 50, 50, 50);
         
            try {

                document.addAuthor("Adlai CG");
                document.addTitle("REPORTE DE SESION");

                PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(RESULT));
                writer.setInitialLeading(16);
                Rectangle rct = new Rectangle(36, 54, 559, 788);
                writer.setBoxSize("art", rct);
                document.open();
                //==============================================
               Image imagen = Image.getInstance("headImage.png");
                imagen.scalePercent(60f);//esto es opcional para definir el tamaño de la imagen.
                imagen.setAlignment(Element.ALIGN_CENTER);
                document.add(imagen);
        //====================================================
                Chunk titulo = new Chunk("REPORTE DE SESION", FontFactory.getFont(FontFactory.COURIER, 20, BaseColor.BLACK));

                document.add(titulo);
                document.add(Chunk.NEWLINE);
                Chunk chunkSeparador = new Chunk(SEPARADOR);
                Chunk chunkNormal = new Chunk("HISTORIA CLINICA ADULTOS");
                document.add(chunkNormal);
                document.add(Chunk.NEWLINE);
                document.add(Chunk.NEWLINE);
                //==================================================================================================================
                Chunk nombre = new Chunk(" NOMBRE: ", FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLDITALIC));
                document.add(nombre);
                Chunk infoNombre = new Chunk(" " + m.getNombre(id) + " " + m.getApellido(id), FontFactory.getFont(FontFactory.COURIER, 12, Font.ITALIC));
                document.add(infoNombre);
                document.add(Chunk.NEWLINE);
                //==================================================================================================================
                Chunk edad = new Chunk(" EDAD: ", FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLDITALIC));
                document.add(edad);
                Chunk infoEdad = new Chunk("" + m.getEdad(id), FontFactory.getFont(FontFactory.COURIER, 12, Font.ITALIC));
                document.add(infoEdad);
                document.add(Chunk.NEWLINE);
                //==================================================================================================================
                Chunk nacimiento = new Chunk(" FECHA DE NACIMIENTO: ", FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLDITALIC));
                document.add(nacimiento);
                Chunk infoNacimiento = new Chunk(m.getNacimiento(id), FontFactory.getFont(FontFactory.COURIER, 12, Font.ITALIC));
                document.add(infoNacimiento);
                document.add(Chunk.NEWLINE);
                //==================================================================================================================
                Chunk lvl = new Chunk(" ESCOLARIDAD: ", FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLDITALIC));
                document.add(lvl);
                Chunk infoLvl = new Chunk(m.getLvl(id), FontFactory.getFont(FontFactory.COURIER, 12, Font.ITALIC));
                document.add(infoLvl);
                document.add(Chunk.NEWLINE);
                //==================================================================================================================
                Chunk religion = new Chunk(" RELIGION : ", FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLDITALIC));
                document.add(religion);
                Chunk infoReligion = new Chunk(m.getReligion(id), FontFactory.getFont(FontFactory.COURIER, 12, Font.ITALIC));
                document.add(infoReligion);
                document.add(Chunk.NEWLINE);
                //==================================================================================================================
                Chunk ocupacion = new Chunk(" OCUPACION : ", FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLDITALIC));
                document.add(ocupacion);
                Chunk infoOcupacion = new Chunk(m.getOcupacion(id), FontFactory.getFont(FontFactory.COURIER, 12, Font.ITALIC));
                document.add(infoOcupacion);
                document.add(Chunk.NEWLINE);
                //==================================================================================================================
                Chunk act = new Chunk(" OTRA ACTIVIDAD: ", FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLDITALIC));
                document.add(act);
                Chunk infoAct = new Chunk(m.getAct(id), FontFactory.getFont(FontFactory.COURIER, 12, Font.ITALIC));
                document.add(infoAct);
                document.add(Chunk.NEWLINE);
                //==================================================================================================================
                Chunk direccion = new Chunk(" DOMICILIO: ", FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLDITALIC));
                document.add(direccion);
                Chunk infoDireccion = new Chunk(m.getDireccion(id), FontFactory.getFont(FontFactory.COURIER, 12, Font.ITALIC));
                document.add(infoDireccion);
                document.add(Chunk.NEWLINE);
                //==================================================================================================================
                Chunk telefono = new Chunk(" TEL: ", FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLDITALIC));
                document.add(telefono);
                Chunk infoTelefono = new Chunk(m.getTelefono(id), FontFactory.getFont(FontFactory.COURIER, 12, Font.ITALIC));
                document.add(infoTelefono);
                document.add(Chunk.NEWLINE);
                //==================================================================================================================
                Chunk servicio = new Chunk(" ¿Cómo se enteró de éste servicio?: ", FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLDITALIC));
                document.add(servicio);
                Chunk infoServicio = new Chunk(m.getServicio(id), FontFactory.getFont(FontFactory.COURIER, 12, Font.ITALIC));
                document.add(infoServicio);
                document.add(Chunk.NEWLINE);
                //==================================================================================================================
                Chunk asunto = new Chunk(" MOTIVO DE CONSULTA: ", FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLDITALIC));
                document.add(asunto);
                Chunk infoAsunto = new Chunk(m.getAsunto(id), FontFactory.getFont(FontFactory.COURIER, 12, Font.ITALIC));
                document.add(infoAsunto);
                document.add(Chunk.NEWLINE);
                //==================================================================================================================
                Chunk objetivo = new Chunk(" OBJETIVO TERAPEUTICO: ", FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLDITALIC));
                document.add(objetivo);
                Chunk infoObjetivo = new Chunk(m.getObjetivo(id), FontFactory.getFont(FontFactory.COURIER, 12, Font.ITALIC));
                document.add(infoObjetivo);
                //==================================================================================================================
                document.add(Chunk.NEWLINE);
                document.add(Chunk.NEWLINE);
                document.add(chunkSeparador);
//FIN Ejemplos de CHUNKS
//**************************************************************

//                Phrase phraseConLeading = new Phrase(12, m.getEvolucion(id),FontFactory.getFont(FontFactory.COURIER, 12, Font.ITALIC);
//                document.add(phraseConLeading);
//Ejemplos de PHRASES
                titulo = new Chunk("DEFINICIÓN DEL PROBLEMA", FontFactory.getFont(FontFactory.COURIER, 20, Font.UNDERLINE, BaseColor.BLACK));
                document.add(titulo);
                //===============================================================================================
                document.add(Chunk.NEWLINE);
                Phrase evolucion = new Phrase(" EVOLUCIÓN: ", FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLDITALIC));
                document.add(evolucion);
                Chunk infoEvolucion = new Chunk(m.getEvolucion(id), FontFactory.getFont(FontFactory.COURIER, 12, Font.ITALIC));
                document.add(infoEvolucion);
                document.add(Chunk.NEWLINE);
                //===============================================================================================
                Phrase causas = new Phrase(" CAUSAS: ", FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLDITALIC));
                document.add(causas);
                Chunk infoCausas = new Chunk(m.getCausas(id), FontFactory.getFont(FontFactory.COURIER, 12, Font.ITALIC));
                document.add(infoCausas);
                document.add(Chunk.NEWLINE);
                //===============================================================================================
                Phrase acciones = new Phrase(" ACCIONES REALIZADAS EN BUSCA DE SOLUCIÓN: ", FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLDITALIC));
                document.add(acciones);
                Chunk infoAcciones = new Chunk(m.getAcciones(id), FontFactory.getFont(FontFactory.COURIER, 12, Font.ITALIC));
                document.add(infoAcciones);
                document.add(Chunk.NEWLINE);
                //===============================================================================================
                Phrase implicaciones = new Phrase(" IMPLICACIONES: (a nivel familiar, social, académico, etc.): ", FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLDITALIC));
                document.add(implicaciones);
                Chunk infoImplicaciones = new Chunk(m.getImplicaciones(id), FontFactory.getFont(FontFactory.COURIER, 12, Font.ITALIC));
                document.add(infoImplicaciones);
                document.add(Chunk.NEWLINE);
                document.add(chunkSeparador);
//FIN Ejemplos de PHRASES
//**************************************************************

//Ejemplos de TABLE
//========================FAMILIAR=======================================================================
                titulo = new Chunk("  ESTRUCTURA Y FUNCIONALIDAD FAMILIAR: ", FontFactory.getFont(FontFactory.COURIER, 20, Font.UNDERLINE, BaseColor.BLACK));
                document.add(titulo);
//Añadir tabla 5 columnas
                PdfPTable table = new PdfPTable(5);
//Añadir CABECERA
                PdfPCell cell = new PdfPCell(new Phrase("FAMILIOGRAMA"));
                cell.setColspan(5);
                cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                table.addCell(cell);
                table.addCell("NOMBRE");
                table.addCell("APELLIDO");
                table.addCell("PARENTESCO");
                table.addCell("EDAD");
                table.addCell("OCUPACION");
//Añadir dos filas de celdas sin formato
                ResultSet rs = m.getFamiliaress(id);
                if (rs.next()) {
                    while(rs.next())
                    {
                    table.addCell(rs.getString("nombre"));
                    table.addCell(rs.getString("apellido"));
                    table.addCell(rs.getString("parentesco"));
                    table.addCell(rs.getInt("edad") + "");
                    table.addCell(rs.getString("ocupacion"));
                    }
                  
                }
                document.add(table);
                document.add(chunkSeparador);
//FIN Ejemplos de TABLE
//================REDES SOCIALES===============================================================================
  titulo = new Chunk("Exploración de redes sociales: (amistades, compañeros de trabajo, conocidos)", FontFactory.getFont(FontFactory.COURIER, 20, Font.UNDERLINE, BaseColor.BLACK));
                document.add(titulo);
                //===============================================================================================
                document.add(Chunk.NEWLINE);
                Phrase social = new Phrase(" Entorno Social: ", FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLDITALIC));
                document.add(social);
                Chunk infoSocial = new Chunk(m.getSocial(id), FontFactory.getFont(FontFactory.COURIER, 12, Font.ITALIC));
                document.add(infoSocial);
                document.add(Chunk.NEWLINE);
                //===============================================================================================
                  document.add(Chunk.NEWLINE);
                Phrase laboral = new Phrase(" Entorno Laboral: ", FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLDITALIC));
                document.add(laboral);
                Chunk infoLaboral = new Chunk(m.getLaboral(id), FontFactory.getFont(FontFactory.COURIER, 12, Font.ITALIC));
                document.add(infoLaboral);
                document.add(Chunk.NEWLINE);
                //===============================================================================================
                  document.add(Chunk.NEWLINE);
                Phrase vivienda = new Phrase(" Entorno de vivienda: ", FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLDITALIC));
                document.add(vivienda);
                Chunk infoVivienda = new Chunk(m.getVivienda(id), FontFactory.getFont(FontFactory.COURIER, 12, Font.ITALIC));
                document.add(infoVivienda);
                document.add(Chunk.NEWLINE);
                
                //===============HISTORIA SEXUAL================================================================================
                  titulo = new Chunk("HISTORIA SEXUAL", FontFactory.getFont(FontFactory.COURIER, 20, Font.UNDERLINE, BaseColor.BLACK));
                document.add(titulo);
                //===============================================================================================
                document.add(Chunk.NEWLINE);
                Phrase antecedentes = new Phrase(" Antecedentes de abuso sexual: ", FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLDITALIC));
                document.add(antecedentes);
                Chunk infoAntecedentes = new Chunk(m.getAbuso(id), FontFactory.getFont(FontFactory.COURIER, 12, Font.ITALIC));
                document.add(infoAntecedentes);
                document.add(Chunk.NEWLINE);
                //===============================================================================================
            
                Phrase embarazos = new Phrase(" Embarazos ", FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLDITALIC));
                document.add(embarazos);
                Chunk infoEmbarazos = new Chunk(m.getEmbarazo(id), FontFactory.getFont(FontFactory.COURIER, 12, Font.ITALIC));
                document.add(infoEmbarazos);
                 //==============================================================================================
                Phrase embEdad = new Phrase(" ¿A qué edad? ", FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLDITALIC));
                document.add(embEdad);
                Chunk infoEmbEdad = new Chunk(m.getEdadSexual(id)+"", FontFactory.getFont(FontFactory.COURIER, 12, Font.ITALIC));
                document.add(infoEmbEdad);
                document.add(Chunk.NEWLINE);
                //===============================================================================================
                
                Phrase PrefSexual = new Phrase(" Preferencia Sexual: ", FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLDITALIC));
                document.add(PrefSexual);
                Chunk infoPref = new Chunk(m.getPref(id), FontFactory.getFont(FontFactory.COURIER, 12, Font.ITALIC));
                document.add(infoPref);
                document.add(Chunk.NEWLINE);
                 //==============================================================================================
                   Phrase traumas = new Phrase(" Exposición a eventos traumáticos en ésta área: ", FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLDITALIC));
                document.add(traumas);
                Chunk infoTraumas = new Chunk(m.getTraumas(id), FontFactory.getFont(FontFactory.COURIER, 12, Font.ITALIC));
                document.add(infoTraumas);
                document.add(Chunk.NEWLINE);
                 //==============================================================================================
                Phrase datoTraumas = new Phrase(" ¿Cuáles?", FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLDITALIC));
                document.add(datoTraumas);
                Chunk infoDatoTraumas = new Chunk(m.getInfoTraumas(id), FontFactory.getFont(FontFactory.COURIER, 12, Font.ITALIC));
                document.add(infoDatoTraumas);
                document.add(Chunk.NEWLINE);
                
                //=================HABITOS==========================================================================================
                titulo = new Chunk("Hábitos", FontFactory.getFont(FontFactory.COURIER, 20, Font.UNDERLINE, BaseColor.BLACK));
                document.add(titulo);
                //===============================================================================================
                document.add(Chunk.NEWLINE);
                Phrase dream = new Phrase(" Hábitos de sueño: ", FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLDITALIC));
                document.add(dream);
                Chunk infoDream = new Chunk(m.getDream(id), FontFactory.getFont(FontFactory.COURIER, 12, Font.ITALIC));
                document.add(infoDream);
                document.add(Chunk.NEWLINE);
                //===============================================================================================
                Phrase alimento = new Phrase(" Hábitos alimenticios: ", FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLDITALIC));
                document.add(alimento);
                Chunk infoAlimento = new Chunk(m.getAlimenticio(id), FontFactory.getFont(FontFactory.COURIER, 12, Font.ITALIC));
                document.add(infoAlimento);
                document.add(Chunk.NEWLINE);
                //===============================================================================================
                Phrase AntePsic = new Phrase(" Antecedentes psicológicos paciente: ", FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLDITALIC));
                document.add(AntePsic);
                Chunk infoAnte = new Chunk(m.getAntPsicologicos(id), FontFactory.getFont(FontFactory.COURIER, 12, Font.ITALIC));
                document.add(infoAnte);
                document.add(Chunk.NEWLINE);
                
                //============ANTECEDETES CLINICOS===================================================================================
                  titulo = new Chunk("Antecedentes clínicos", FontFactory.getFont(FontFactory.COURIER, 20, Font.UNDERLINE, BaseColor.BLACK));
                document.add(titulo);
                //===============================================================================================
                document.add(Chunk.NEWLINE);
                Phrase grave = new Phrase(" ¿Ha tenido alguna enfermedad grave?: ", FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLDITALIC));
                document.add(grave);
                Chunk infoGrave = new Chunk(m.getGrave(id), FontFactory.getFont(FontFactory.COURIER, 12, Font.ITALIC));
                document.add(infoGrave);
                document.add(Chunk.NEWLINE);
                //===============================================================================================
                     
                      Phrase accidentes = new Phrase(" Accidentes/Lesiones: ", FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLDITALIC));
                document.add(accidentes);
                Chunk infoAccidentes = new Chunk(m.getAccidentes(id), FontFactory.getFont(FontFactory.COURIER, 12, Font.ITALIC));
                document.add(infoAccidentes);
                document.add(Chunk.NEWLINE);
                //===============================================================================================
                  Phrase medicamento = new Phrase(" ¿Utiliza algún medicamento? ", FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLDITALIC));
                document.add(medicamento);
                Chunk infoMedicamento = new Chunk(m.getMedicamento(id), FontFactory.getFont(FontFactory.COURIER, 12, Font.ITALIC));
                document.add(infoMedicamento);
                document.add(Chunk.NEWLINE);
                //===============================================================================================
                  Phrase intervencion = new Phrase(" Intervención quirúrgica: ", FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLDITALIC));
                document.add(intervencion);
                Chunk infoIntervencion = new Chunk(m.getQuirurgica(id), FontFactory.getFont(FontFactory.COURIER, 12, Font.ITALIC));
                document.add(infoIntervencion);
                document.add(Chunk.NEWLINE);
                //===============================================================================================
                Phrase aux = new Phrase(" Utiliza lentes u otro dispositivo auxiliar: ", FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLDITALIC));
                document.add(aux);
                Chunk infoAux = new Chunk(m.getAuxiliar(id), FontFactory.getFont(FontFactory.COURIER, 12, Font.ITALIC));
                document.add(infoAux);
                document.add(Chunk.NEWLINE);
                
                //============ANTECEDETES FAMILIARES===================================================================================
                  titulo = new Chunk("Antecedentes familiares", FontFactory.getFont(FontFactory.COURIER, 20, Font.UNDERLINE, BaseColor.BLACK));
                document.add(titulo);
                //===============================================================================================
                document.add(Chunk.NEWLINE);
                Phrase areaPsic = new Phrase(" Área psicológica: ", FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLDITALIC));
                document.add(areaPsic);
                Chunk infoAreaPsic = new Chunk(m.getPsicologia(id), FontFactory.getFont(FontFactory.COURIER, 12, Font.ITALIC));
                document.add(infoAreaPsic);
                document.add(Chunk.NEWLINE);
                //===============================================================================================
                   Phrase areaPsiq = new Phrase(" Área psiquiátrica ", FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLDITALIC));
                document.add(areaPsiq);
                Chunk infoAreaPsiq = new Chunk(m.getPsiquiatra(id), FontFactory.getFont(FontFactory.COURIER, 12, Font.ITALIC));
                document.add(infoAreaPsiq);
                document.add(Chunk.NEWLINE);
                //===============================================================================================
                  Phrase areaPat = new Phrase(" Otras patologías: ", FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLDITALIC));
                document.add(areaPat);
                Chunk infoAreaPat = new Chunk(m.getPatologia(id), FontFactory.getFont(FontFactory.COURIER, 12, Font.ITALIC));
                document.add(infoAreaPat);
                document.add(Chunk.NEWLINE);
                 //============ESTADO MENTAL DEL PACIENTE===================================================================================
                  titulo = new Chunk("ANÁLISIS DEL ESTADO MENTAL DEL PACIENTE:", FontFactory.getFont(FontFactory.COURIER, 20, Font.UNDERLINE, BaseColor.BLACK));
                document.add(titulo);
                //===============================================================================================
                document.add(Chunk.NEWLINE);
                Phrase lenguaje = new Phrase(" PERCEPCION Y LENGUAJE: ", FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLDITALIC));
                document.add(lenguaje);
                Chunk infoLenguaje = new Chunk(m.getLenguaje(id), FontFactory.getFont(FontFactory.COURIER, 12, Font.ITALIC));
                document.add(infoLenguaje);
                document.add(Chunk.NEWLINE);
                //===============================================================================================
                        Phrase emocional = new Phrase(" ESTADO EMOCIONAL: ", FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLDITALIC));
                document.add(emocional);
                Chunk infoEmocional = new Chunk(m.getEmocional(id), FontFactory.getFont(FontFactory.COURIER, 12, Font.ITALIC));
                document.add(infoEmocional);
                document.add(Chunk.NEWLINE);
                //===============================================================================================
                        Phrase realidad = new Phrase(" CONTACTO CON LA REALIDAD: ", FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLDITALIC));
                document.add(realidad);
                Chunk infoRealidad = new Chunk(m.getRealidad(id), FontFactory.getFont(FontFactory.COURIER, 12, Font.ITALIC));
                document.add(infoRealidad);
                document.add(Chunk.NEWLINE);
                //===============================================================================================
                        Phrase higiene = new Phrase(" HIGIENE Y APARIENCIA PERSONAL: ", FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLDITALIC));
                document.add(higiene);
                Chunk infoHigiene = new Chunk(m.getHigiene(id), FontFactory.getFont(FontFactory.COURIER, 12, Font.ITALIC));
                document.add(infoHigiene);
                document.add(Chunk.NEWLINE);
                
                  //============ESTADO MENTAL DEL PACIENTE===================================================================================
                  titulo = new Chunk("Reporte por sesión:", FontFactory.getFont(FontFactory.COURIER, 20, Font.UNDERLINE, BaseColor.BLACK));
                document.add(titulo);
                //===============================================================================================
                document.add(Chunk.NEWLINE);
                Phrase diagnostico = new Phrase(" IMPRESIÓN DIAGNÓSTICA:  ", FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLDITALIC));
                document.add(diagnostico);
                Chunk infoDiagnostico = new Chunk(m.getDiagnostico(id), FontFactory.getFont(FontFactory.COURIER, 12, Font.ITALIC));
                document.add(infoDiagnostico);
                document.add(Chunk.NEWLINE);
                //===============================================================================================
                   Phrase observaciones = new Phrase(" OBSERVACIONES GENERALES:  ", FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLDITALIC));
                document.add(observaciones);
                Chunk infoObservaciones = new Chunk(m.getObservaciones(id), FontFactory.getFont(FontFactory.COURIER, 12, Font.ITALIC));
                document.add(infoObservaciones);
                document.add(Chunk.NEWLINE);
                //===============================================================================================
 
// Cierre del documento
                document.close();

             
            } catch (BadElementException ex) {
                System.out.println("Image BadElementException" + ex);
                JOptionPane.showMessageDialog(null, "ERROR AL GENERAR EL ARCHIVO PDF! ERROR: "+ex);
            } catch (IOException ex) {
                System.out.println("Image IOException " + ex);
                 JOptionPane.showMessageDialog(null, "ERROR AL GENERAR EL ARCHIVO PDF! ERROR: "+ex);
            } catch (SQLException ex) {
                Logger.getLogger(GeneratePDF.class.getName()).log(Level.SEVERE, null, ex);
                 JOptionPane.showMessageDialog(null, "ERROR AL GENERAR EL ARCHIVO PDF! ERROR: "+ex);
            }

            System.out.println("Your PDF file has been generated!(Â¡Se ha generado tu hoja PDF!");
             JOptionPane.showMessageDialog(null, "ARCHIVO PDF GENERADO CON EXITO EN:" + RESULT);
        } catch (DocumentException documentException) {
            System.out.println("The file not exists (Se ha producido un error al generar un documento): " + documentException);
            JOptionPane.showMessageDialog(null, "ERROR AL GENERAR EL ARCHIVO PDF! ERROR: "+documentException);
        }
    }

    //==========================================================================================
    public motor m;
}
