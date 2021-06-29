package owolabi.ezekiel.pdfwriter;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import owolabi.ezekiel.pdfwriter.utils.PdfUtils;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, MalformedURLException {
      String path = System.getProperty("user.home") + "//Desktop//FirsrPDF.pdf";
      String imagePath = "/Users/tobilobaowolabi/Desktop/Professional Documents/clear signature copy.jpg";
      PdfWriter pdfWriter = new PdfWriter(path);

      PdfDocument pdfDocument = new PdfDocument(pdfWriter);
      pdfDocument.addNewPage();

      Document document = new Document(pdfDocument);
      document = PdfUtils.addParagraph(document);
      document = PdfUtils.addImage(document, imagePath);
      document = PdfUtils.addList(document);
      document.close();
  }
}
