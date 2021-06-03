import Amuber.Magazzino;
import Amuber.Users.Commerciante;
import org.junit.jupiter.api.Test;

class MD5Test {

    @Test
    void test() {
        //Il sistema recupera le informazioni riguardo Mario Rossi
        Commerciante comm1 = new Commerciante("mario.rossi@gmail.com", "Mario", "Rossi", "3225552431");

        //Il commerciante seleziona l'attività "Pencil Hub" tra le sue attività
        Magazzino mag1 = new Magazzino("Pencil Hub", comm1, "Via San Mario 34");

        //Il sistema recupera le informazioni riguardo Antonio Corradi
        Commerciante comm2 = new Commerciante("antonio.corradi@gmail.com", "Antonio", "Corradi", "3246452343");

        //Il commerciante seleziona l'attività "Pencil Hub" tra le sue attività
        Magazzino mag2 = new Magazzino("Coop", comm2, "Via San Mario 5");
        Magazzino mag3 = new Magazzino("Coal", comm2, "Via San Mario 7");


        System.out.println("\n" + comm1.getEmail() + " -> " + comm1.getHashID());
        System.out.println("\n" + comm2.getEmail() + " -> " + comm2.getHashID());
    }
}