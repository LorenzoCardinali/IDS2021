package it.unicam.cs.ids2021;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;

public class Amuber extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        primaryStage.setTitle("Amuber [Java " + javaVersion + "] - [JavaFx " + javafxVersion + "]");

        // Funziona solo avviando con Maven
        //Parent root = FXMLLoader.load(getClass().getResource("amuber.fxml"));
        //Scene scene = new Scene(root);
        //scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        Scene scene = new Scene(FXMLLoader.load(new File("src/main/resources/it/unicam/cs/ids2021/amuber.fxml").toURI().toURL()));
        scene.getStylesheets().add(new File("src/main/resources/it/unicam/cs/ids2021/styles.css").toURI().toURL().toString());
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

