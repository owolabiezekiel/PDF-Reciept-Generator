package owolabi.ezekiel.pdfwriter;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import owolabi.ezekiel.pdfwriter.utils.PdfUtils;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

public class Main {
  public static final String abrushow = "fonts//Abrushow.ttf";
  public static final String reallyFree = "fonts//ReallyFree.ttf";
  public static void main(String[] args) throws IOException {
    String path = System.getProperty("user.home") + "//Desktop//FirsrPDF.pdf";
    String imagePath = "/Users/tobilobaowolabi/Desktop/Professional Documents/clear signature copy.jpg";
    PdfWriter pdfWriter = new PdfWriter(path);

    PdfDocument pdfDocument = new PdfDocument(pdfWriter);
    pdfDocument.addNewPage();

    Document document = new Document(pdfDocument);

    PdfFont tnrFont = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);
    PdfFont boldFont = PdfFontFactory.createFont(FontConstants.TIMES_BOLD);
    PdfFont abrushowFont = PdfFontFactory.createFont(abrushow, true);
    PdfFont reallyFreeFont = PdfFontFactory.createFont(reallyFree, true);

    Text text1 = new Text("Times New Roman(Normal)\n").setFont(tnrFont);
    Text text2 = new Text("Times New Roman(Bold)\n").setFont(boldFont);
    Text text3 = new Text("Abrushow Font(Normal)\n").setFont(abrushowFont);
    Text text4 = new Text("ReallyFree Font(Normal)\n").setFont(reallyFreeFont);

    Paragraph paragraph = new Paragraph().add(text1).add(text2).add(text3).add(text4);


    document = PdfUtils.addParagraph(document, paragraph);
    document = PdfUtils.addImage(document, imagePath);
    document = PdfUtils.addList(document);
    document.close();

    System.out.println("Pdf generated");
  }
}
