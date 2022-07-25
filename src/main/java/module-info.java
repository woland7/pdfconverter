module it.pdfconverter {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires itextpdf;
    requires org.apache.commons.io;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens it.pdfconverter to javafx.fxml;
    exports it.pdfconverter;
    exports it.pdfconverter.controller;
    opens it.pdfconverter.controller to javafx.fxml;

    exports it.pdfconverter.engine;
}