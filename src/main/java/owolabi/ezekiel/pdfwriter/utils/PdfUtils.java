package owolabi.ezekiel.pdfwriter.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.itextpdf.barcodes.BarcodeQRCode;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.xobject.PdfFormXObject;
import com.itextpdf.kernel.pdf.xobject.PdfXObject;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.Paragraph;
import owolabi.ezekiel.pdfwriter.models.UserInfo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

public class PdfUtils {
  public static Document addParagraph(Document document, Paragraph paragraph){
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

  public static Document addBarcode(PdfDocument pdfDocument, Document document, String barcodeInfo) throws IOException, WriterException {
    BarcodeQRCode qrCode = new BarcodeQRCode(barcodeInfo);
    PdfFormXObject barcodeObject = qrCode.createFormXObject(ColorConstants.RED, pdfDocument);
    Image barcodeImage = new Image(barcodeObject).setWidth(500f).setHeight(500f);
    document.add(barcodeImage);
    return document;
  }

  public static void generateHaceyPdfForUser(UserInfo userInfo){
    String path = System.getProperty("user.home") + "//Desktop//" + userInfo.id + ".pdf";
  }


}
