module hedspi.oop.group6.graphproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.jfoenix;
    requires java.desktop;
    requires java.logging;

    opens hedspi.oop.group6.Controller to javafx.fxml;
    exports hedspi.oop.group6.graphproject;
}