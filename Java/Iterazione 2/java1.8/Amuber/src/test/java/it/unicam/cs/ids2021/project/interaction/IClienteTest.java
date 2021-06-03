package it.unicam.cs.ids2021.project.interaction;

import it.unicam.cs.ids2021.project.enums.Categoria;
import it.unicam.cs.ids2021.project.storage.Magazzino;
import it.unicam.cs.ids2021.project.storage.Prodotto;
import it.unicam.cs.ids2021.project.users.Cliente;
import it.unicam.cs.ids2021.project.users.Commerciante;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class IClienteTest {

    ICliente iCliente = new ICliente();

    @Test
    void addCliente() {
        Cliente cli = new Cliente("Sandra", "Mirti", "sandra.mirti@gmail.com", "3563428964", "Via vittorio emanuele 2");
        Cliente cli2 = new Cliente("Luca", "Pallino", "luca.pallino@gmail.com", "3488231485", "Via dante 20");

        assertTrue(iCliente.addCliente(cli2));
    }

    @Test
    void aggiungiProdotto() {
        Commerciante comm1 = new Commerciante("Giovanna", "Lombardini", "federica.lombardini@gmail.com", "3452377694");
        Magazzino mag1 = new Magazzino("Pencil Hub", "Via San Mario 34", comm1);
        Prodotto pro1 = new Prodotto("Matita", "Staedtler", Categoria.Cancelleria, 10, 2.50, mag1, "Matita HB per disegno");

        Cliente cli = new Cliente("Sandra", "Mirti", "sandra.mirti@gmail.com", "3563428964", "Via vittorio emanuele 2");
        iCliente.setCliente(cli);

        assertTrue(iCliente.aggiungiProdotto(pro1, 4));
        assertFalse(iCliente.aggiungiProdotto(pro1, 20));
    }

    @Test
    void getCarrello() {
        Cliente cli = new Cliente("Sandra", "Mirti", "sandra.mirti@gmail.com", "3563428964", "Via vittorio emanuele 2");
        iCliente.setCliente(cli);
        assertFalse(iCliente.getCarrello().isEmpty());

        Cliente cli2 = new Cliente("Luca", "Pallino", "luca.pallino@gmail.com", "3488231485", "Via dante 20");
        iCliente.setCliente(cli2);
        assertTrue(iCliente.getCarrello().isEmpty());
    }

    @Test
    void creaOrdine() {
        Cliente cli = new Cliente("Sandra", "Mirti", "sandra.mirti@gmail.com", "3563428964", "Via vittorio emanuele 2");
        iCliente.setCliente(cli);

        assertTrue(iCliente.creaOrdine());
    }

    @Test
    void ricercaProdotto() {
    }

}