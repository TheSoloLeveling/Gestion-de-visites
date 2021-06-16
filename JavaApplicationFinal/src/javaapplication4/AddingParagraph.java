/*package javaapplication4;


import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.color.DeviceRgb;
import com.itextpdf.kernel.pdf.PdfDocument; 
import com.itextpdf.kernel.pdf.PdfWriter; 
import com.itextpdf.layout.Document; 
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;  
import com.itextpdf.layout.element.Table;
import java.io.File;
import java.io.FileOutputStream;
import com.itextpdf.layout.border.Border ; 
import com.itextpdf.layout.border.Border ; 


public class AddingParagraph {    
   public static void creteaPDF(String nom , String prenom , String begindate , String user , String entreprise) throws Exception {
      
        String path = "C:\\Users\\hp\\Downloads\\test.pdf";
        PdfWriter writer = new PdfWriter(path);
        PdfDocument pdfDocument = new PdfDocument(writer);
        
       try (Document document = new Document(pdfDocument)) {
           float colomnWidth[] = {112, 112, 112, 112, 112};
           
           Table table = new Table(colomnWidth);
           table.setMarginTop(50);
           
          
         table.addCell(new Cell(1,2).add(new Paragraph("International University of Rabat").setFontSize(20f).setBold().setFontColor(new DeviceRgb(13, 20, 145))).setBorder(Border.NO_BORDER));

        // Row2
      
        table.addCell(new Cell().add(new Paragraph("+212 (0)5 30 10 30 00\n"+
                "contact@uir.ac.ma")).setBorder(Border.NO_BORDER));
    document.add(table);
    
    Table table5 = new Table(colomnWidth);
           table5.setMarginTop(100);
           
      table5.addCell(new Cell(1,2).add(new Paragraph(nom+" Demands : ").setFontSize(20f).setBold().setFontColor(new DeviceRgb(13, 20, 145))).setBorder(Border.NO_BORDER));
    
    
     document.add(table5);
    
    
  Table table1 = new Table(colomnWidth);
           table1.setMarginTop(150);
     

          
         table1.addCell(new Cell().add(new Paragraph("nom") )).setFontColor(Color.WHITE).setBackgroundColor(new DeviceRgb(13, 20, 145)) ;
table1.addCell(new Cell().add(new Paragraph("prenom") )).setFontColor(Color.WHITE).setBackgroundColor(new DeviceRgb(13, 20, 145))  ; 
table1.addCell(new Cell().add(new Paragraph("begin date") )).setFontColor(Color.WHITE).setBackgroundColor(new DeviceRgb(13, 20, 145))  ;  
table1.addCell(new Cell().add(new Paragraph("user entreprise") )).setFontColor(Color.WHITE).setBackgroundColor(new DeviceRgb(13, 20, 145))  ; 
table1.addCell(new Cell().add(new Paragraph("entreprise") )).setFontColor(Color.WHITE).setBackgroundColor(new DeviceRgb(13, 20, 145))  ;
          document.add(table1);
 Table table7 = new Table(colomnWidth);
         table7.addCell(new Cell().add(new Paragraph(nom) )) ;
table7.addCell(new Cell().add(new Paragraph(prenom) ))  ; 
table7.addCell(new Cell().add(new Paragraph(begindate) ))  ;  
table7.addCell(new Cell().add(new Paragraph(user) ))  ; 
table7.addCell(new Cell().add(new Paragraph(entreprise) ))  ; 

document.add(table7);



        Paragraph para = new Paragraph("TERMS\n"+
                "Copyright 2021 UIR.\n"+
                " Tous droits réservés.");

        para.setMarginTop(150);

        document.add(para);
           
          
       }
   } 
} */