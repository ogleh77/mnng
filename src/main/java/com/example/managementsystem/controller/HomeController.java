package com.example.managementsystem.controller;

import com.example.managementsystem.data.Model;
import com.example.managementsystem.data.Student;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    @FXML
    private TextField inputText;
    private final Model model = new Model();
    private Stage thisStage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Platform.runLater(() -> {
            thisStage = (Stage) inputText.getScene().getWindow();
        });
    }


    @FXML
    void insertHandler() throws SQLException {
        double randomGrade = Math.random() * 100;
        Student student = new Student(inputText.getText(), randomGrade);
        System.out.println(student);
        model.insert(student);
    }

    @FXML
    void openHandler() throws SQLException, IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/managementsystem/next.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(loader.load());
        NextController controller = loader.getController();
        controller.setStudents(model.getStudents());
        stage.setScene(scene);
        stage.show();
        thisStage.close();
    }
}
