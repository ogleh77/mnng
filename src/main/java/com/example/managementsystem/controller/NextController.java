package com.example.managementsystem.controller;

import com.example.managementsystem.data.Student;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NextController implements Initializable {
    @FXML
    private ListView<Student> listView;
    private ObservableList<Student> students;
    private Stage thisStage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Platform.runLater(() -> {
            thisStage = (Stage) listView.getScene().getWindow();
        });
    }

    @FXML
    void backToHomeHandler() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/managementsystem/views.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.show();
        thisStage.close();
    }

    public void setStudents(ObservableList<Student> students) {
        this.students = students;
        listView.setItems(students);
    }
}
