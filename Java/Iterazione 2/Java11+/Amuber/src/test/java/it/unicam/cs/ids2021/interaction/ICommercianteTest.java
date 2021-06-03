package it.unicam.cs.ids2021.interaction;

import it.unicam.cs.ids2021.storage.Magazzino;
import it.unicam.cs.ids2021.storage.Prodotto;
import it.unicam.cs.ids2021.service.DBManager;
import it.unicam.cs.ids2021.enums.Categoria;
import it.unicam.cs.ids2021.users.Commerciante;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ICommercianteTest {

    DBManager manager = DBManager.getIstance();
    ICommerciante iCommerciante = new ICommerciante();

    @Test
    void addCommerciante() {

        Commerciante comm1 = new Commerciante("Giovanna", "Lombardini", "federica.lombardini@gmail.com", "3452377694");

        String sql = "DELETE FROM amuber.Commerciante WHERE idCommerciante LIKE '" + comm1.getHashID() + "' ESCAPE '#' ";
        manager.executeQuery(sql);

        assertTrue(iCommerciante.addCommerciante(comm1));
        assertFalse(iCommerciante.addCommerciante(comm1));
    }

    @Test
    void addMagazzino() {
        Commerciante comm1 = new Commerciante("Giovanna", "Lombardini", "federica.lombardini@gmail.com", "3452377694");
        Commerciante comm2 = new Commerciante( "Mario", "Rossi", "mario.rossi@gmail.com", "3225552431");
        Magazzino mag1 = new Magazzino("Pencil Hub", "Via San Mario 34", comm1);
        Magazzino mag2 = new Magazzino("Coop", "Via San Mario 5", comm1);
        Magazzino mag3 = new Magazzino("Coal", "Via San Mario 7", comm2);

        //iCommerciante.addMagazzino(mag3);
    }

    //Test completato
    @Test
    void aggiungiProdotto() {
        Commerciante comm1 = new Commerciante("Giovanna", "Lombardini", "federica.lombardini@gmail.com", "3452377694");
        Magazzino mag1 = new Magazzino("Pencil Hub", "Via San Mario 34", comm1);
        Magazzino mag2 = new Magazzino("Coop", "Via San Mario 5", comm1);

        Prodotto pro1 = new Prodotto("Matita", "Staedtler", Categoria.Cancelleria, 10, 2.50, mag1, "Matita HB per disegno");
        Prodotto pro2 = new Prodotto("Colla", "Print", Categoria.Cancelleria, 12, 5.99, mag2, "Colla comune");
        Prodotto pro3 = new Prodotto("TOP Shirt", "Cottonwave", Categoria.Abbigliamento, 5, 10.99, mag1, "Maglia con logo ufficiale Twenty One Pilots");
        Prodotto pro4 = new Prodotto("Mouse Rival 600", "Steelseries", Categoria.Elettronica, 8, 78.56, mag1, "Mouse da gaming");
        Prodotto pro5 = new Prodotto("Pollo a fette", "Feleni", Categoria.Alimentare, 27, 4.32, mag2, "Petto di pollo tagliato a fette sottili");

        assertTrue(iCommerciante.aggiuntaProdotto(pro1));
        assertTrue(iCommerciante.aggiuntaProdotto(pro2));
        assertTrue(iCommerciante.aggiuntaProdotto(pro3));
        assertTrue(iCommerciante.aggiuntaProdotto(pro4));
        assertTrue(iCommerciante.aggiuntaProdotto(pro5));
    }
}