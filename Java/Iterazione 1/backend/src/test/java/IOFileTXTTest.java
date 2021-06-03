import Amuber.Enums.Categoria;
import Amuber.Magazzino;
import Amuber.Prodotto;
import Amuber.Users.Commerciante;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.*;

class IOFileTXTTest {

    @Test
    void testwriteProdotto() throws IOException {

        //preparo magazzino
        HashMap<Categoria, Set<Prodotto>> listaProdotti = new HashMap<>();

        //aggiungo categorie alla mappa
        for (Categoria categoria : EnumSet.allOf(Categoria.class)) {
            listaProdotti.put(categoria, new HashSet<>());
        }

        //creo commerciante e magazzino affiliato
        Commerciante comm1 = new Commerciante("mario.rossi@gmail.com", "Mario", "Rossi", "3225552431");
        Magazzino mag1 = new Magazzino("Pencil Hub", comm1, "Via San Mario 34");
        //Commerciante comm1 = new Commerciante("antonio.corradi@gmail.com", "Antonio", "Corradi", "3246452343");
        //Magazzino mag1 = new Magazzino("Coop", comm1, "Via San Mario 5");

        //creo prodotti e li carico nella mappa
        Prodotto pro1 = new Prodotto("Matita", "Staedtler", 10, 2.50, "Matita HB per disegno", Categoria.Cancelleria, mag1);
        Prodotto pro2 = new Prodotto("Colla", "Print", 12, 5.99, "Colla comune", Categoria.Cancelleria, mag1);
        Prodotto pro3 = new Prodotto("TOP Shirt", "Cottonwave", 5, 10.99, "Maglia con logo ufficiale Twenty One Pilots", Categoria.Abbigliamento, mag1);
        Prodotto pro4 = new Prodotto("Mouse Rival 600", "Steelseries", 8, 78.56, "Mouse da gaming", Categoria.Elettronica, mag1);
        Prodotto pro5 = new Prodotto("Pollo a fette", "Feleni", 27, 4.32, "Petto di pollo tagliato a fette sottili", Categoria.Alimentare, mag1);
        listaProdotti.get(pro1.getCategoria()).add(pro1);
        listaProdotti.get(pro2.getCategoria()).add(pro2);
        listaProdotti.get(pro3.getCategoria()).add(pro3);
        listaProdotti.get(pro4.getCategoria()).add(pro4);
        listaProdotti.get(pro5.getCategoria()).add(pro5);

        //creo sub-path
        String pathMagazzino = "src/test/Amuber/Users/Commerciante/" + comm1.getHashID() + "/" + mag1.getHashID();

        //salvo i prodotti nel magazzino ciclando le categorie della mappa
        for (Categoria cat : listaProdotti.keySet()) {
            //entro nel path della categoria
            try {
                File file = new File(pathMagazzino + "/" + cat + "/prodotti.txt");

                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, false));

                //inserisco tutti i prodotti appartenenti a quella categoria
                for (Prodotto prodotto : listaProdotti.get(cat)) {
                    bufferedWriter.append(prodotto.toFile(false));
                }
                //chiudo il file
                bufferedWriter.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            } catch (IOException e) {
                System.out.println("Error initializing stream");
            }
        }
    }

    @Test
    void testreadProdotto() throws IOException {
        //creo commerciante e magazzino affiliato
        Commerciante comm1 = new Commerciante("mario.rossi@gmail.com", "Mario", "Rossi", "3225552431");
        Magazzino mag1 = new Magazzino("Pencil Hub", comm1, "Via San Mario 34");
        //Commerciante comm1 = new Commerciante("antonio.corradi@gmail.com", "Antonio", "Corradi", "3246452343");
        //Magazzino mag1 = new Magazzino("Coop", comm1, "Via San Mario 5");

        //creo sub-path
        String pathMagazzino = "src/test/Amuber/Users/Commerciante/" + comm1.getHashID() + "/" + mag1.getHashID();

        //preparo magazzino
        HashMap<Categoria, Set<Prodotto>> listaProdotti = new HashMap<>();

        //leggo i prodotti dal magazzino ciclando le categorie della mappa
        for (Categoria categoria : EnumSet.allOf(Categoria.class)) {
            //creo mappa
            listaProdotti.put(categoria, new HashSet<>());
            try {
                //inizializzo scanner
                Scanner scanner = new Scanner(new File(pathMagazzino + "/" + categoria + "/prodotti.txt"));

                //fino a quanto lo scanner ha una riga da leggere
                while (scanner.hasNextLine()) {
                    //leggo una riga e la "splitto" usando il carattere ";"
                    String tokens[] = scanner.nextLine().split(";");

                    //aggiungo il prodotto nella mappa
                    listaProdotti.get(categoria).add(new Prodotto(tokens[1], tokens[2], Integer.parseInt(tokens[3]), Double.parseDouble(tokens[4]), tokens[5], categoria, mag1));
                }
                //chiudo scanner
                scanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("Commerciante / Magazzino errati");
                break;
            }
        }

        //stampo mappa
        for (Categoria cat : listaProdotti.keySet()) {
            System.out.println(cat + ": ");
            if (listaProdotti.get(cat).isEmpty()) System.out.println("[Empty]");
            else
                for (Prodotto pro : listaProdotti.get(cat)) {
                    System.out.print(pro);
                }

            System.out.println();
        }
    }
}