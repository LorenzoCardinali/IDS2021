package Amuber.Viste;

import Amuber.Carrello;
import Amuber.Enums.Categoria;
import Amuber.Magazzino;
import Amuber.Prodotto;
import Amuber.Users.Cliente;
import Amuber.Users.Commerciante;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class IOFileTXT {

    static void checkFiles(Class classe) {
        String path = "src/test/Amuber/Users/" + classe.getSimpleName() + "/" ;

        File directory = new File(path);
        if (!directory.exists()) {
            try {
                Files.createDirectories(Paths.get(path));
                //System.out.println("Directory is created for " + this.getEmail() + " !");
            } catch (IOException e) {
                //System.err.println("Failed to create directory for " + this.getEmail() + " ! -> " + e.getMessage());
            }
        } //else System.out.println("Directory exist for " + this.getEmail() + " !");
    }

    public static Carrello readCarrello(Cliente cliente) {
        //leggo carrello da cliente
        return null;
    }

    static HashMap<Categoria, Set<Prodotto>> readProdotti(Commerciante commerciante, Magazzino magazzino) {
        HashMap<Categoria, Set<Prodotto>> prodotti = new HashMap<>();

        String pathMagazzino = "src/test/Amuber/Users/Commerciante/" + commerciante.getHashID() + "/" + magazzino.getHashID();

        for (Categoria categoria : EnumSet.allOf(Categoria.class)) {
            //File file = new File(pathMagazzino + categoria);
            System.out.println(pathMagazzino + categoria);
        }

        return null;
    }

    public static Set<Prodotto> readProdottiByCategoria(Categoria c, Magazzino mag) {
        Set<Prodotto> setProdotti = new HashSet<>();
        try {
            //inizializzo scanner
            Scanner scanner = new Scanner(new File("src/test/Amuber/Users/Commerciante/" + mag.getProprietario().getHashID() + "/" + mag.getHashID() + "/" + c + "/prodotti.txt"));

            //fino a quanto lo scanner ha una riga da leggere
            while (scanner.hasNextLine()) {
                //leggo una riga e la "splitto" usando il carattere ";"
                String tokens[] = scanner.nextLine().split(";");

                //aggiungo il prodotto nel set
                setProdotti.add(new Prodotto(tokens[1], tokens[2], Integer.parseInt(tokens[3]), Double.parseDouble(tokens[4]), tokens[5], c, mag));
            }
            //chiudo scanner
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Commerciante / Magazzino errati");
        }

        return setProdotti;//set di prodotti di categoria c uguale
    }

    /**
     * Salva un set di prodotti di uguale categoria nel magazzino opportuno
     *
     * @param setP set di prodotti di stessa categoria
     * @param m    magazzino al quale va aggiunto
     * @param c    categoria del set
     * @throws IOException
     */
    public static void updaterByCategoria(Set<Prodotto> setP, Magazzino m, Categoria c) throws IOException {

        //creo sub-path
        String pathMagazzino = "src/test/Amuber/Users/Commerciante/" + m.proprietario.getHashID() + "/" + m.getHashID();

        //entro nel path della categoria
        try {
            File file = new File(pathMagazzino + "/" + c + "/prodotti.txt");

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, false));

            //inserisco tutti i prodotti appartenenti a quella categoria
            for (Prodotto prodotto : setP) {
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

    public static Set<Commerciante> getCommercianti() throws FileNotFoundException {
        Set<Commerciante> setCommerciante = new HashSet<>();
        String listaComm = "src/test/Amuber/Users/Commerciante/email.txt";
        try {
            Scanner scanner = new Scanner(new File(listaComm));
            //fino a quanto lo scanner ha una riga da leggere
            while (scanner.hasNextLine()) {
                //leggo una riga e la "splitto" usando il carattere ";"
                String tokens[] = scanner.nextLine().split(";");
                //aggiungo il commerciante nel set
                setCommerciante.add(new Commerciante(tokens[3], tokens[1], tokens[2], tokens[4]));
            }
            //chiudo scanner
            scanner.close();

        } catch (FileNotFoundException e) {
            System.err.println(e.toString());
        }
        return setCommerciante;
    }


/*
    //proviamo i generics?
    public static Set<? extends User> getSetUsers(User user) throws FileNotFoundException {
        Set<? extends User> setUser = new HashSet<>();
        String listaUser = "src/test/Amuber/Users/"++"/email.txt;
        try{
            Scanner scanner = new Scanner(new File(listaUser));
            //fino a quanto lo scanner ha una riga da leggere
            while (scanner.hasNextLine()) {
                //leggo una riga e la "splitto" usando il carattere ";"
                String tokens[] = scanner.nextLine().split(";");
                //aggiungo il prodotto nel set

                setUser.add(new <? extends User>(tokens[3],tokens[1],tokens[2],tokens[4]));
            }
            //chiudo scanner
            scanner.close();

        } catch (FileNotFoundException e) {
            System.err.println(e.toString());
        }
        return setUser;
    }
*/


    static Magazzino readList(String path) throws IOException {
        /*
        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);
        String test = br.readLine();
         */
        return null;
    }

    static void writeList(String path, Magazzino mag) throws IOException {

        /*
        File file = new File(path);
        FileWriter fileWriter = new FileWriter(file, false);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);


        for (Amuber.Prodotto p : mag.getListaProdotti()) {
            bufferedWriter.append(p.toFile());
        }
        bufferedWriter.close();
         */
    }

}

/*toString(?)
for (Amuber.Enums.Categoria cat : Amuber.Enums.Categoria.values()) {
    System.out.println(":" + cat + "\n" + ";");
}
*/
