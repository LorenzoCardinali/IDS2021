import Amuber.Carrello;
import Amuber.Enums.Categoria;
import Amuber.Magazzino;
import Amuber.Prodotto;
import Amuber.Users.Commerciante;
import org.junit.jupiter.api.Test;

class CarrelloTest {

    @Test
    void test() {
        Carrello test = new Carrello();
        Commerciante com1 = new Commerciante("mario.rossi@gmail.com", "Mario", "Rossi", "3225552431");
        Magazzino mag1 = new Magazzino("Pencil Hub", com1, "Via San Mario 34");
        Prodotto pro1 = new Prodotto("acqua", "dabeve", 1, 2.50, "dissetante e senza olio di palma", Categoria.Alimentare, mag1);
        Prodotto pro2 = new Prodotto("acqua", "disseta", 1, 3.50, "dissetante e senza olio di palma", Categoria.Alimentare, mag1);
        Prodotto pro3 = new Prodotto("acqua", "maronn", 1, 1, "dissetante e senza olio di palma", Categoria.Alimentare, mag1);

        test.addProdotto(com1, pro1);
        System.out.println(test.getSubtotale());
        test.addProdotto(com1, pro2);
        System.out.println(test.getSubtotale());
        test.addProdotto(com1, pro3);
        System.out.println(test.getSubtotale());
    }
}