package owolabi.ezekiel.pdfwriter.utils;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.Paragraph;

import java.net.MalformedURLException;

public class PdfUtils {
  public static Document addParagraph(Document document){
    String paragraphString = "Lorem Ipsum";
    Paragraph paragraph = new Paragraph(paragraphString);
    document.add(paragraph);
    return document;
  }


  public static Document addImage(Document document, String imagePath) throws MalformedURLException {
    ImageData imageData = ImageDataFactory.create(imagePath);
    Image image = new Image(imageData);
    document.add(image);
    return document;
  }

  public static Document addList(Document document){
    List list = new List();
    list.add("Samuel Peter");
    list.add("Tobi Owolabi");
    list.add("Bolu David");
    document.add(list);
    return document;
  }


}
