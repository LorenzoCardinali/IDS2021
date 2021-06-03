package Amuber;

import Amuber.Enums.Categoria;
import Amuber.Viste.IOFileTXT;
import Amuber.Viste.MD5;
import Amuber.Users.Commerciante;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Set;

/**
 * lista di Prodotti, getters and setters
 * Il Amuber.Magazzino è concepito per essere "personale" per ogni commerciante/negozio.
 * In pratica è un OGGETTO che oltre a contenere la lista dei prodotti messi in vendita, conterrà le informazioni
 * del commerciante a cui appartiene
 */
public class Magazzino {

    /**
     * HashMap<K,V>
     * K -> Amuber.Enums.Categoria
     * V -> Set<Amuber.Prodotto> = new HashSet<>()
     **/
    private HashMap<Categoria, Set<Prodotto>> listaProdotti;//è una mappa
    private Set<Prodotto> prodotti; //(hashset)

    public String nome;
    public String indirizzo;
    public Commerciante proprietario;
    private final String hashID;

    public Magazzino(String nome, Commerciante commerciante, String indirizzo) {
        this.nome = nome;
        this.proprietario = commerciante;
        this.indirizzo = indirizzo;
        this.hashID = MD5.setCodice(nome, proprietario.getHashID());

        String path = "src/test/Amuber/Users/Commerciante/" + proprietario.getHashID() + "/" + this.hashID;
        File directory = new File(path);
        if (!directory.exists()) {
            try {
                Files.createDirectories(Paths.get(path));
                for (Categoria categoria : EnumSet.allOf(Categoria.class)) {
                    Files.createDirectories(Paths.get(path + "/" + categoria));
                    Files.createFile(Paths.get(path + "/" + categoria + "/prodotti.txt"));
                }
                System.out.println("Directory are created for " + this.nome + " !");
            } catch (IOException e) {
                System.err.println("Failed to create directory for " + this.nome + " ! -> " + e.getMessage());
            }
        } else System.out.println("Directory exist for " + this.nome + " !");
    }

    public String getHashID() {
        return hashID;
    }

    public String getNome() {
        return nome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public Commerciante getProprietario() {
        return proprietario;
    }

    /**
     * in main:
     * try{
     * magazzino.addProdotto(prodotto);
     * }
     * catch(IllegalArgumentException)
     * {
     * richiama modificaProdotto();
     * }
     */

    public boolean aggiuntaProdotto(Prodotto p) throws IOException {
        this.getListaProdotti(p.getCategoria());

        boolean modifica = false;

        for (Prodotto tmp : prodotti) {
            if (tmp.compareTo(p) == 0) {
                increaseQuantity(p);
                modifica = true;
            }
        }

        if (!modifica) prodotti.add(p);

        IOFileTXT.updaterByCategoria(prodotti, this, p.getCategoria());

        return modifica;
    }

    public void getListaProdotti(Categoria c) {
        prodotti = IOFileTXT.readProdottiByCategoria(c, this);
    }

    @Override
    public String toString() {
        return "Magazzino{\n" +
                "\tlistaProdotti=" + listaProdotti.toString() +
                "\n\tproprietario=" + proprietario.getCognome() +
                "}\n";
    }


    public void increaseQuantity(Prodotto p) {
        for (Prodotto tmp : prodotti) {
            if (tmp.compareTo(p) == 0) {
                tmp.setDisponibilita(tmp.getDisponibilita() + p.getDisponibilita());
                return;
            }
        }
    }


}
