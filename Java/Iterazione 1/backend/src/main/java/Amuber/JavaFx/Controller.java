package Amuber.JavaFx;

import Amuber.Viste.ICommerciante;
import Amuber.Magazzino;
import Amuber.Users.Commerciante;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class Controller {

    @FXML
    private Button btnCommerciante;

    @FXML
    private Button btnCorriere;

    @FXML
    private Button btnCliente;

    @FXML
    private Button sysOut;

    public void consoleMode(javafx.event.ActionEvent actionEvent) throws IOException {

        // get a handle to the stage
        Stage stage = (Stage) sysOut.getScene().getWindow();
        // do what you have to do
        stage.close();

        //Simulo login (commerciante)
        // Antonio Corradi

        //Il sistema recupera le informazioni riguardo Mario Rossi
        Commerciante comm2 = new Commerciante("antonio.corradi@gmail.com", "Antonio", "Corradi", "3246452343");

        //Il commerciante seleziona l'attività "Pencil Hub" tra le sue attività
        Magazzino mag2 = new Magazzino("Coop", comm2, "Via San Mario 5");
        Magazzino mag3 = new Magazzino("Coal", comm2, "Via San Mario 7");
        // Mario Rossi

        //Il sistema recupera le informazioni riguardo Mario Rossi
        Commerciante comm1 = new Commerciante("mario.rossi@gmail.com", "Mario", "Rossi", "3225552431");

        //Il commerciante seleziona l'attività "Pencil Hub" tra le sue attività
        Magazzino mag1 = new Magazzino("Pencil Hub", comm1, "Via San Mario 34");

        //Simulo aggiunta prodotto da parte del commerciante "Mario Rossi" nel magazzino di "Pencil Hub"

        ICommerciante iCommerciante = new ICommerciante();

        iCommerciante.aggiungiProdotto(mag1);

        //Simulo login utilizzando la mail "germano.biagi@gmail.com" (cliente)

        //Cliente cli1 = new Cliente("germano.biagi@gmail.com", "Germano", "Biagi", "3344564574");
    }

    public void pressBtnCliente(javafx.event.ActionEvent actionEvent)
    {
        System.out.println("cliente");
        //TODO Lancio interfaccia utente ICliente
    }

    /**
     * Quando verà premuto il btnCommerciante, verrà eseguito questo metodo per cambiare scena per ICommerciante
     * @param actionEvent
     */
    public void pressBtnCommerciante(javafx.event.ActionEvent actionEvent) throws IOException {
        System.out.println("commerciante");
        //TODO lancio interfaccia ICommerciante
        Parent commercianteRoot = FXMLLoader.load(new File("src/main/java/Amuber/Viste/ICommerciante.fxml").toURI().toURL());
        Scene commercianteScena = new Scene(commercianteRoot);
        //recupero le informazioni della scena
        Stage nextWindow = (Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();
        nextWindow.setScene(commercianteScena);
        nextWindow.show();

    }

    public void pressBtnCorriere(javafx.event.ActionEvent actionEvent)
    {
        //TODO Classe Corriere
        //TODO lancio interfaccia ICorriere
    }

}
