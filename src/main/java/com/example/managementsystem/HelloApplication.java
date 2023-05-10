package com.example.managementsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        URL icon = HelloApplication.class.getResource("/com/example/managementsystem/app-icon.jpeg");
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/managementsystem/views.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.getIcons().add(new Image(String.valueOf(icon)));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}