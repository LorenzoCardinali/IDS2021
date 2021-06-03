package it.unicam.cs.ids2021.project.interaction;

import it.unicam.cs.ids2021.project.enums.Categoria;
import it.unicam.cs.ids2021.project.service.DBManager;
import it.unicam.cs.ids2021.project.storage.Carrello;
import it.unicam.cs.ids2021.project.storage.Prodotto;
import it.unicam.cs.ids2021.project.users.Cliente;

import java.util.Set;

public class ICliente {

    private Cliente cliente;
    private final DBManager manager = DBManager.getIstance();

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public boolean addCliente(Cliente cliente) {
        if (manager.getClienti().contains(cliente)) return false;
        else {
            manager.addCliente(cliente);
            return true;
        }
    }

    public Carrello getCarrello() {
        return manager.getCarrello(cliente);
    }

    public boolean aggiungiProdotto(Prodotto prodotto, int quantita) {
        if (prodotto == null || quantita <= 0 || prodotto.getDisponibilita() < quantita)
            return false;
        else {
            return manager.getCarrello(cliente).addProdotto(prodotto, quantita);
        }
    }

    public boolean creaOrdine() {
        if (this.getCarrello().isEmpty()) return false;
        else {
            this.getCarrello().generateOrdini().forEach(manager::addOrdine);
            return true;
        }
    }

/*    public Set<Prodotto> ricercaProdotto(Categoria categoria, String filtro) {
        if (categoria == null) return null;
        else {
            Set<Prodotto> prodotti = manager.ricercaProdotto(categoria, filtro);
            return prodotti;
        }
    }*/
}
