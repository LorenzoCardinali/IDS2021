package it.unicam.cs.ids2021.storage;

import it.unicam.cs.ids2021.users.Cliente;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Carrello {

    public static final double IVA = 1.24;

    private final HashMap<Magazzino, Container> prodotti;
    private final Cliente proprietario;


    public Carrello(Cliente proprietario) {
        this.proprietario = proprietario;
        this.prodotti = new HashMap<>();
    }

    public boolean addProdotto(Prodotto prodotto, int quantita) {
        //carrello contiene commerciante
        if (!prodotti.containsKey(prodotto.getMagazzino())) {
            prodotti.put(prodotto.getMagazzino(), new Container());
            prodotti.get(prodotto.getMagazzino()).addProdotto(prodotto, quantita);
        }
        return prodotti.get(prodotto.getMagazzino()).addProdotto(prodotto, quantita);
    }

    public Set<Ordine> generateOrdini() {
        Set<Ordine> ordini = new HashSet<>();
        if (prodotti.isEmpty()) throw new EmptyStackException();

        prodotti.keySet().forEach(magazzino ->
                ordini.add(new Ordine(
                        this.proprietario,
                        magazzino,
                        prodotti.get(magazzino).getProdotti(),
                        (double) Math.round(prodotti.get(magazzino).getTotale() * IVA * 100d) / 100d)
                )
        );

        return ordini;
    }

    public boolean isEmpty() {
        return this.prodotti.isEmpty();
    }

    private static class Container {

        private final HashMap<Prodotto, Integer> prodotti;
        private double totale;

        private Container() {
            this.prodotti = new HashMap<>();
            this.totale = 0;
        }

        private HashMap<Prodotto, Integer> getProdotti() {
            return this.prodotti;
        }

        private double getTotale() {
            return this.totale;
        }

        private boolean addProdotto(Prodotto prodotto, int quantita) {
            if (!prodotti.containsKey(prodotto)) {
                prodotti.put(prodotto, quantita);
                this.totale += prodotto.getPrezzo() * quantita;
                return true;
            }
            return modificaQuantita(prodotto, quantita);
        }

        private boolean modificaQuantita(Prodotto prodotto, int quantita) {
            if (this.prodotti.get(prodotto) + quantita <= prodotto.getDisponibilita()) {
                this.prodotti.replace(prodotto, this.prodotti.get(prodotto) + quantita);
                return true;
            } else return false;
        }
    }
}