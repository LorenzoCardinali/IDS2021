package it.unicam.cs.ids2021.storage;

import it.unicam.cs.ids2021.enums.StatoOrdine;
import it.unicam.cs.ids2021.service.MD5;
import it.unicam.cs.ids2021.users.Cliente;
import it.unicam.cs.ids2021.users.Corriere;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;

public class Ordine {

    private final Cliente cliente;
    private final Magazzino magazzino;
    private Corriere corriere;
    private final HashMap<String, Integer> prodotti = new HashMap<>();
    private final Double totale;
    private StatoOrdine stato;
    private final String hashID;

    public Ordine(Cliente cliente, Magazzino magazzino, HashMap<Prodotto, Integer> prodotti, Double totale) {
        this.cliente = cliente;
        this.magazzino = magazzino;
        this.corriere = null;
        prodotti.keySet().forEach(prodotto ->
                this.prodotti.put(prodotto.getHashID(), prodotti.get(prodotto)));
        this.totale = totale;
        this.stato = StatoOrdine.DaPagare;
        this.hashID = MD5.getHash2(cliente.getHashID(), magazzino.getHashID(), LocalDateTime.now().toString());
    }

    public void cambiaStato(StatoOrdine stato) {
        this.stato = stato;
    }

    @Override
    public String toString() {
        return hashID + " - " + cliente.getHashID() + " - " + totale + " - " + stato;
    }

    public String getHashID() {
        return hashID;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Magazzino getMagazzino() {
        return magazzino;
    }

    public Double getTotale() {
        return totale;
    }

    public StatoOrdine getStato() {
        return stato;
    }

    public HashMap<String, Integer> getProdotti() {
        return prodotti;
    }
}
