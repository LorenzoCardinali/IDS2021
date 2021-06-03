package it.unicam.cs.ids2021.project.core;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class Amuber extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            String javaVersion = System.getProperty("java.version");
            String javafxVersion = System.getProperty("javafx.version");
            primaryStage.setTitle("Amuber [Java " + javaVersion + "] - [JavaFx " + javafxVersion + "]");
            Scene scene = new Scene(FXMLLoader.load(new File("src/main/resources/it/unicam/cs/ids2021/project/core/amuber.fxml").toURI().toURL()));
            scene.getStylesheets().add(new File("src/main/resources/it/unicam/cs/ids2021/project/core/style.css").toURI().toURL().toString());
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
