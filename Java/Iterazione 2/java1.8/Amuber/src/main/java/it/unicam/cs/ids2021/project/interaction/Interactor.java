package it.unicam.cs.ids2021.project.interaction;

import it.unicam.cs.ids2021.project.service.DBManager;
import it.unicam.cs.ids2021.project.storage.Magazzino;
import it.unicam.cs.ids2021.project.users.Commerciante;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.GridPane;

public class Interactor {

    private final ICliente iCliente = new ICliente();
    private final ICommerciante iCommerciante = new ICommerciante();
    private final ICorriere iCorriere = new ICorriere();
    private final DBManager manager = DBManager.getIstance();

    public ComboBox<Commerciante> lista_commercianti;
    public Button select_commerciante;
    public Button reset_commerciante;
    public Label comm_id;
    public Label comm_nome;
    public Label comm_cognome;
    public Label comm_recapito;
    public GridPane table_magazzino;
    public ComboBox<Magazzino> lista_magazzini;
    public Button select_magazzino;
    public Button reset_magazzino;
    public Label mag_id;
    public Label mag_indirizzo;
    public Tab tab_funzioni;

    public void initialize() {
        lista_commercianti.getItems().addAll(manager.getCommercianti());
    }

    public void commercianteSelected() {
        iCommerciante.setCommerciante(lista_commercianti.getValue());
        lista_commercianti.setDisable(true);
        select_commerciante.setDisable(true);
        reset_commerciante.setDisable(false);
        comm_id.setText(iCommerciante.getCommerciante().getHashID());
        comm_nome.setText(iCommerciante.getCommerciante().getNome());
        comm_cognome.setText(iCommerciante.getCommerciante().getCognome());
        comm_recapito.setText(iCommerciante.getCommerciante().getRecapito());
        table_magazzino.setVisible(true);
        lista_magazzini.getItems().clear();
        lista_magazzini.getItems().addAll(manager.getMagazzini(iCommerciante.getCommerciante()));
        lista_magazzini.setDisable(false);
        select_magazzino.setDisable(false);
    }

    public void commercianteResetted() {
        iCommerciante.setCommerciante(null);
        lista_commercianti.setValue(null);
        lista_commercianti.setDisable(false);
        select_commerciante.setDisable(false);
        reset_commerciante.setDisable(true);
        comm_id.setText("");
        comm_nome.setText("");
        comm_cognome.setText("");
        comm_recapito.setText("");
        table_magazzino.setVisible(false);
        this.lista_magazzini.getItems().clear();
        lista_magazzini.setDisable(true);
        select_magazzino.setDisable(true);
        reset_magazzino.setDisable(true);
        mag_id.setText("");
        mag_indirizzo.setText("");
        tab_funzioni.setDisable(true);
    }

    public void magazzinoSelected() {
        iCommerciante.setMagazzino(lista_magazzini.getValue());
        lista_magazzini.setDisable(true);
        select_magazzino.setDisable(true);
        reset_magazzino.setDisable(false);
        mag_id.setText(iCommerciante.getMagazzino().getHashID());
        mag_indirizzo.setText(iCommerciante.getMagazzino().getIndirizzo());
        tab_funzioni.setDisable(false);
    }

    public void magazzinoResetted() {
        iCommerciante.setMagazzino(null);
        lista_magazzini.setValue(null);
        lista_magazzini.setDisable(false);
        select_magazzino.setDisable(false);
        reset_magazzino.setDisable(true);
        mag_id.setText("");
        mag_indirizzo.setText("");
        tab_funzioni.setDisable(true);
    }
}
