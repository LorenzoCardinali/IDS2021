package it.unicam.cs.ids2021.project.interaction;

import it.unicam.cs.ids2021.project.service.DBManager;
import it.unicam.cs.ids2021.project.storage.Magazzino;
import it.unicam.cs.ids2021.project.storage.Ordine;
import it.unicam.cs.ids2021.project.storage.Prodotto;
import it.unicam.cs.ids2021.project.users.Commerciante;

import java.util.Set;

public class ICommerciante {

    private Commerciante commerciante = null;
    private Magazzino magazzino = null;
    private final DBManager manager = DBManager.getIstance();

    public ICommerciante() {
    }

    public Commerciante getCommerciante() {
        return commerciante;
    }

    public void setCommerciante(Commerciante commerciante) {
        this.commerciante = commerciante;
    }

    public Magazzino getMagazzino() {
        return this.magazzino;
    }

    public void setMagazzino(Magazzino magazzino) {
        this.magazzino = magazzino;
    }

    public boolean addCommerciante(Commerciante commerciante) {
        if (manager.getCommercianti().contains(commerciante)) return false;
        else {
            manager.addCommerciante(commerciante);
            return true;
        }
    }

    public boolean addMagazzino(Magazzino magazzino) {
        if (manager.getMagazzini(magazzino.getProprietario()).contains(magazzino)) return false;
        else {
            manager.addMagazzino(magazzino);
            return true;
        }
    }

    public boolean aggiuntaProdotto(Prodotto prodotto) {
        if (prodotto == null) return false;
        else {
            manager.addProddotto(prodotto);
            return true;
        }
    }

    public Set<Ordine> getOrdini() {
        //todo implementare
        return null;
    }
}