module com.example.managementsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires com.jfoenix;
    requires AnimateFX;
    requires org.apache.poi.poi;
    requires org.apache.poi.ooxml;
    requires org.xerial.sqlitejdbc;


    opens com.example.managementsystem to javafx.fxml;
    exports com.example.managementsystem;
    exports com.example.managementsystem.controller;
    opens com.example.managementsystem.controller to javafx.fxml;
    exports com;
    opens com to javafx.fxml;
}