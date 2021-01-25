/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PDF;

import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import psipacientes.motor;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class GeneratePDF {

    public GeneratePDF()
    {
        
    }
    public void setMotor(motor m)
    {
        this.m=m;
    }
        public void createPDF(int id) 
        {
        
    try{
        
        String fileName = "PdfWithtext.pdf"; // name of our file
        
        PDDocument doc = new PDDocument();
        PDPage page = new PDPage();
        PDImageXObject pdImage = PDImageXObject.createFromFile("headImage.png", doc);
        doc.addPage(page);

        PDPageContentStream content = new PDPageContentStream(doc, page);
        
        content.drawImage(pdImage, 0, 670);
        
        content.beginText();
        content.setFont(PDType1Font.HELVETICA_BOLD, 14);
        content.moveTextPositionByAmount(200, 650);
        content.drawString("HISTORIA CLÍNICA ADULTOS");
        content.endText();
        
         content.beginText();
        content.setFont(PDType1Font.HELVETICA_BOLD, 11);
        content.moveTextPositionByAmount(490,625);
        content.drawString("FECHA: " +""+m.getNacimiento(id));
        content.endText();
        
        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 11);
        content.moveTextPositionByAmount(80, 600);
        content.drawString("PACIENTE: "+m.getNombre(id)+" "+m.getApellido(id));
        content.endText();
        
        
        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 11);
        content.moveTextPositionByAmount(80,575);
        content.drawString("EDAD : " +""+m.getEdad(id)+" "+"FECHA DE NACIMIENTO: " +""+m.getNacimiento(id));
        content.endText();
        
        
        
        content.beginText();
        content.moveTextPositionByAmount(80,550);
        content.drawString("ESCOLARIDAD: " +""+m.getLvl(id)+" "+"RELIGION: " +""+m.getReligion(id));
        content.endText();
        
    
        
          content.beginText();
        content.moveTextPositionByAmount(80,525);
        content.drawString("OCUPACION: " +""+m.getOcupacion(id)+" "+"ACTIVIDAD EXTRA: " +""+m.getAct(id));
        content.endText();
        
      
        
          content.beginText();
        content.moveTextPositionByAmount(80,500);
        content.drawString("DIRECCION: " +""+m.getDireccion(id));
        content.endText();
        
          content.beginText();
        content.moveTextPositionByAmount(80,475);
        content.drawString("TELEFONO: " +""+m.getTelefono(id));
        content.endText();
        
          content.beginText();
        content.moveTextPositionByAmount(80,450);
        content.drawString("MEDIO POR EL CUAL SE ENTERO DE ESTE SERVICIO: ");
        content.endText();
        
         content.beginText();
        content.moveTextPositionByAmount(80,425);
        content.drawString(m.getServicio(id));
        content.endText();
        
          content.beginText();
        content.moveTextPositionByAmount(80,400);
        content.drawString("ASUNTO O MOTIVO DE LA CONSULTA: " +""+m.getAsunto(id));
        content.endText();
        
          content.beginText();
        content.moveTextPositionByAmount(80,375);
        content.drawString("OBJETIVO CLINICO: " +""+m.getObjetivo(id));
        content.endText();
        
        content.close();
        doc.save(fileName);
        doc.close();
        
        System.out.println("your file created in : "+ System.getProperty("user.dir"));

        }
        catch(IOException e){
        
        System.out.println(e.getMessage());
        
        }
//      
               
        }
        
        //==========================================================================================
        public motor m;
}
