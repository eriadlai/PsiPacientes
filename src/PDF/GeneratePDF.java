/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PDF;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
public class GeneratePDF {
    //Nombre del fichero <strong>PDF</strong> Resultante de la ejecucion

    public static final String RESULT = "test.pdf";
//Titulos
    public static final String CHUNK = "CHUNK";
    public static final String PHRASE = "PHRASE";
    public static final String PARAGRAPH = "PARAGRAPH";
    public static final String TABLE = "TABLE";
    public static final String IMAGE = "IMAGE";
//Textos
    public static final String SEPARADOR = "———————————————————————————————————————-";
    public static final String CHUNK1 = "This is the smallest significant part of text that can be added to a document.";
    public static final String CHUNK2 = "Most elements can be divided in one or more Chunks. A chunk is a String with "
            + "a certain Font. All other layout parameters should be defined in the object to which this chunk of text is added.";
    public static final String PHRASE1 = "A Phrase is a series of Chunks.";
    public static final String CHUNKPHRASE21 = "A Phrase has a main Font,";
    public static final String CHUNKPHRASE22 = " but some chunks within the phrase can have a Font that differs from the main Font.";
    public static final String CHUNKPHRASE23 = " All the Chunks in a Phrase  have the same leading.";
    public static final String PARAGRAPH1 = "A Paragraph is a series of Chunks and/or Phrases.";
    public static final String PARAGRAPH2 = "A Paragraph has the same qualities of a Phrase, but also some additional layout-parameters: The indentation AND The alignment of the text";

//===============================================================================================
    private static final String iTextExampleImage = "headImage.png";

    public GeneratePDF() {

    }

    public void setMotor(motor m) {
        this.m = m;
    }

    public void createPDF(int id, File pdfNewFile) {
        try {
            Document document = new Document(PageSize.A4, 50, 50, 50, 50);
            try {

//Al documento se le puede añadir cierta metaInformacion
                document.addAuthor("Adlai CG");
                document.addTitle("REPORTE DE SESION");

//A DocWriter class for PDF con Java.
//When this PdfWriter is added to a certain PdfDocument,
//the <strong>PDF</strong> representation of every Element added to this Document will be written to the outputstream.
                PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(RESULT));
//LEADING = separacion entre lineas del documento
                writer.setInitialLeading(16);
                Rectangle rct = new Rectangle(36, 54, 559, 788);
//Definimos un nombre y un tamaño para el PageBox los nombres posibles son: “crop”, “trim”, “art” and “bleed”.
                writer.setBoxSize("art", rct);

//Se crea una instancia de la clase que pinta la cabecera y el pie de pagina y se le asignan los eventos que ocurran en el <strong>PDF</strong>
//La en la clase HeaderFooter se capturarar el evento onEndPage para pintarlos
//Opens the document.
//You have to open the document before you can begin to add content to the body of the document.
                document.open();
//Ejemplos de CHUNKS
//Creamos el CHUNK definiendo su tipo de letra, tamaño…
                Chunk titulo = new Chunk("REPORTE DE SESION", FontFactory.getFont(FontFactory.COURIER, 20, Font.UNDERLINE, BaseColor.BLACK));
//Lo añadimos al documento
                document.add(titulo);
//CHUNK predefinido, es un salto de linea
                document.add(Chunk.NEWLINE);
                Chunk chunkSeparador = new Chunk(SEPARADOR);
                Chunk chunkNormal = new Chunk("HISTORIA CLINICA ADULTOS");
                document.add(chunkNormal);
                document.add(Chunk.NEWLINE);
                document.add(Chunk.NEWLINE);
                Chunk chunkTunning = new Chunk(CHUNK2, FontFactory.getFont(FontFactory.COURIER, 20, Font.ITALIC, BaseColor.GREEN));
                document.add(chunkTunning);
                document.add(Chunk.NEWLINE);
                document.add(Chunk.NEWLINE);
                Chunk chunkTunning2 = new Chunk(CHUNK2, new Font(FontFamily.HELVETICA, 6, Font.BOLD, BaseColor.WHITE));
                chunkTunning2.setBackground(BaseColor.BLACK, 10f, 10f, 10f, 10f);
                document.add(chunkTunning2);
                document.add(Chunk.NEWLINE);
                document.add(Chunk.NEWLINE);
                document.add(Chunk.NEWLINE);
                document.add(chunkSeparador);
//FIN Ejemplos de CHUNKS
//**************************************************************
//Ejemplos de PHRASES
                titulo = new Chunk(PHRASE, FontFactory.getFont(FontFactory.COURIER, 20, Font.UNDERLINE, BaseColor.BLACK));
                document.add(titulo);
                document.add(Chunk.NEWLINE);
                Phrase phraseNormal = new Phrase(PHRASE1);
                document.add(phraseNormal);
                document.add(Chunk.NEWLINE);
                document.add(Chunk.NEWLINE);
                Phrase phraseTunning = new Phrase(new Chunk(CHUNKPHRASE21));
                phraseTunning.add(new Chunk(CHUNKPHRASE22, FontFactory.getFont(FontFactory.COURIER, 5, Font.ITALIC, BaseColor.GREEN)));
                phraseTunning.add(new Chunk(CHUNKPHRASE23, FontFactory.getFont(FontFactory.TIMES_ROMAN, 15, Font.BOLD, BaseColor.ORANGE)));
                document.add(phraseTunning);
                document.add(Chunk.NEWLINE);
                document.add(Chunk.NEWLINE);
                Phrase phraseConLeading = new Phrase(30, "Todo es la misma frase LEADING de esta PHRASE=100, Todo es la misma"
                        + " frase LEADING de esta PHRASE=100, Todo es la misma frase LEADING de esta PHRASE=100");
                document.add(phraseConLeading);
                document.add(Chunk.NEWLINE);
                document.add(chunkSeparador);
//FIN Ejemplos de PHRASES
//**************************************************************
//Ejemplos de PARAGRAPH
                titulo = new Chunk(PARAGRAPH, FontFactory.getFont(FontFactory.COURIER, 20, Font.UNDERLINE, BaseColor.BLACK));
                document.add(titulo);
                document.add(Chunk.NEWLINE);
// Añadir parrafo sin formato
                document.add(new Paragraph(PARAGRAPH1));
                Paragraph par = new Paragraph(PARAGRAPH2);
                par.setIndentationLeft(200);
                document.add(par);
                par = new Paragraph(PARAGRAPH2);
                par.setIndentationRight(300);
                document.add(par);
// Añadir parrafo en Negrita
                par = new Paragraph(PARAGRAPH2);
                par.getFont().setStyle(Font.BOLD);
                par.setAlignment(Element.ALIGN_CENTER);
                document.add(par);
// Añadir parrafo en Cursiva
                par = new Paragraph(PARAGRAPH2);
                par.getFont().setStyle(Font.ITALIC);
                par.setAlignment(Element.ALIGN_RIGHT);
                document.add(par);
// Añadir parrafo tunning
                par = new Paragraph(PARAGRAPH2,
                        FontFactory.getFont("arial", // fuente
                                16, // tamaño
                                Font.ITALIC, // estilo
                                BaseColor.RED));       // color
                document.add(par);
                par.setAlignment(Element.ALIGN_LEFT);
                document.add(chunkSeparador);
                document.add(Chunk.NEWLINE);
                document.add(Chunk.NEWLINE);
//FIN Ejemplos de PARAGRAPH
//**************************************************************
//Ejemplos de TABLE
                titulo = new Chunk(TABLE, FontFactory.getFont(FontFactory.COURIER, 20, Font.UNDERLINE, BaseColor.BLACK));
                document.add(titulo);
//Añadir tabla 5 columnas
                PdfPTable table = new PdfPTable(5);
//Añadir CABECERA
                PdfPCell cell = new PdfPCell(new Phrase("CABECERA"));
                cell.setColspan(5);
                cell.setBackgroundColor(BaseColor.GREEN);
                table.addCell(cell);
//Añadir dos filas de celdas sin formato
                table.addCell("1.1");
                table.addCell("1.2");
                table.addCell("1.3");
                table.addCell("1.4");
                table.addCell("1.5");
                table.addCell("2.1");
                table.addCell("2.2");
                table.addCell("2.3");
                table.addCell("2.4");
                table.addCell("2.5");
//tunning de Celdas
                cell = new PdfPCell(new Phrase("Alto 3 celdas"));
                cell.setRowspan(2);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                table.addCell(cell);
                table.addCell("3.1");
                table.addCell("3.2");
                table.addCell("3.3");
                table.addCell("3.4");
                table.addCell("4.1");
                table.addCell("4.2");
                table.addCell("4.3");
                table.addCell("4.4");
                table.addCell("5.1");
                cell = new PdfPCell(new Phrase("Ancho 4 celdas"));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setColspan(4);
                table.addCell(cell);
                document.add(table);
                document.add(chunkSeparador);
//FIN Ejemplos de TABLE
//**************************************************************
//Ejemplos de IMAGE
                titulo = new Chunk(IMAGE, FontFactory.getFont(FontFactory.COURIER, 20, Font.UNDERLINE, BaseColor.BLACK));
                document.add(titulo);
                Image foto = Image.getInstance(iTextExampleImage);
                foto.scaleToFit(100, 100);
                foto.setAlignment(Chunk.ALIGN_MIDDLE);
                document.add(foto);
//FIN Ejemplos de IMAGE
//**************************************************************
// Cierre del documento
                document.close();

            } catch (BadElementException ex) {
                System.out.println("Image BadElementException" + ex);
            } catch (IOException ex) {
                System.out.println("Image IOException " + ex);
            }

            System.out.println("Your PDF file has been generated!(Â¡Se ha generado tu hoja PDF!");
        } catch (DocumentException documentException) {
            System.out.println("The file not exists (Se ha producido un error al generar un documento): " + documentException);
        }
    }

    //==========================================================================================
    public motor m;
}
