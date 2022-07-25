package it.pdfconverter.engine;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.scene.control.Alert;
import javafx.scene.layout.Region;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class JPEGConverter {
    public static void convertToPdf(File inputFile, File outputFile){

        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(outputFile));
            document.open();
            document.newPage();
            Image image = Image.getInstance(inputFile.getAbsolutePath());
            image.setAbsolutePosition(0, 0);
            image.setBorderWidth(0);
            image.scaleAbsolute(PageSize.A4);
            document.add(image);
            document.close();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.getDialogPane().setMinWidth(Region.USE_PREF_SIZE);
            alert.setHeaderText("Convertitore PDF");
            alert.setTitle("Info");
            alert.setContentText("File convertito");
            alert.showAndWait();
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }


    }
}
