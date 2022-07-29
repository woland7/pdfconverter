module it.pdfconverter {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires itextpdf;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens it.pdfconverter.controller to javafx.fxml;
    exports it.pdfconverter;
}