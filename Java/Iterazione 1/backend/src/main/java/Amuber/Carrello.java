package Amuber;

import Amuber.Users.Commerciante;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Carrello {

    private final HashMap<Commerciante, Set<Prodotto>> prodotti;
    double subtotale;

    public Carrello() {
        this.prodotti = new HashMap<>();
        this.subtotale = 0;
    }

    public Carrello(Commerciante commerciante, Set<Prodotto> prodotti) {
        this.prodotti = new HashMap<>();
        this.prodotti.put(commerciante, prodotti);
        for (Prodotto tmp : prodotti) {
            this.subtotale += tmp.getPrezzo();
        }
    }

    public double getSubtotale() {
        return subtotale;
    }

    public void addProdotto(Commerciante commerciante, Prodotto prodotto) {
        if (!this.prodotti.containsKey(commerciante)) {
            this.prodotti.put(commerciante, new HashSet<>());
        }
        this.prodotti.get(commerciante).add(prodotto);

        this.subtotale += prodotto.getPrezzo();
    }
}
