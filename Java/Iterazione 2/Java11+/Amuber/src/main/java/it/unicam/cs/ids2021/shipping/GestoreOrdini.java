package it.unicam.cs.ids2021.shipping;

import it.unicam.cs.ids2021.storage.Carrello;
import it.unicam.cs.ids2021.storage.Ordine;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class GestoreOrdini {

    private HashMap<String, Integer> prodotti = new HashMap<>();

/*    public Set<Ordine> generateOrdini(Carrello carrello) {
        if (carrello == null) throw new NullPointerException("Carrello non valido");
        //carrello vuoto
        if (carrello.getProdotti().isEmpty()) throw new EmptyStackException();
        else {
            carrello.getProdotti().keySet().forEach(commerciante -> {
                carrello.getProdotti().get(commerciante).keySet().forEach(prodotto ->
                        prodotti.put(prodotto.getHashID(), carrello.getProdotti().get(commerciante).get(prodotto))
                );
            });
        }

        Set<Ordine> ordini = new HashSet<>();

        return ordini;
    }*/
}