package it.pdfconverter.controller;

import it.pdfconverter.engine.JPEGConverter;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.List;

public class Controller {
    private List<File> files;

    @FXML
    private Label files_names;

    @FXML
    protected void onApriButtonClick() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Scegli file");
        files = fileChooser.showOpenMultipleDialog(null);
        StringBuilder sb = new StringBuilder();
        for(File f: files){
            sb.append(f.getName());
            sb.append("\n");
            files_names.setText(sb.toString());
        }
    }

    @FXML
    protected void onUnisciButtonClick(){

    }

    @FXML
    protected void onConvertiButtonClick(){
        for (File f: files){
            String outputFilename = f.getAbsolutePath().replace("jpeg", "pdf");
            File outputFile = new File(outputFilename);
            System.out.println(outputFile.exists());
            if (outputFile.exists()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                alert.getDialogPane().setMinWidth(Region.USE_PREF_SIZE);
                alert.setHeaderText("Convertitore PDF");
                alert.setTitle("Errore");
                alert.setContentText("File già esiste");
                alert.showAndWait();
            }
            else {
                JPEGConverter.convertToPdf(f, outputFile);
            }
        }
    }

    @FXML
    private void handleAbout(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("Convertitore PDF");
        alert.setContentText("Un regalo per la Queen");
        alert.showAndWait();
    }
}