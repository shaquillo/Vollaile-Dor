module VollaileDor {
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.graphics;
    requires com.jfoenix;
    requires javafx.controls;
    requires javafx.media;
    requires java.sql;
    opens model;
    opens controller;
    opens view;
    opens view.images;
    opens view.style;
}