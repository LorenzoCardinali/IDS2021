package Amuber.Users;

import Amuber.Viste.MD5;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Classe astratta (non istanziabile) che contiene tutte le informazioni che un utente registrato deve avere per poter utilizzare la piattaforma
 * in modo corretto
 * <p>
 * nomeUtente
 * email, forse o qualcosa del genere
 * recapito ---->il num di telefono sarà String
 * etc.
 */
public abstract class User {
    //private String nomeUtente;
    private final String nome;
    private final String cognome;
    private final String email;
    private final String recapito;
    private final String hashID;

    //un user a livello concettuale è composto da....:
    public User(String email, String nome, String cognome, String recapito) {
        if (email == null || nome == null || cognome == null || recapito == null) throw new NullPointerException();
        this.email = email;
        this.nome = nome;
        this.cognome = cognome;
        this.recapito = recapito;
        this.hashID = MD5.setCodice(email, cognome);
        //più tutti gli altri parametri specifici per tipologia di utente
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getRecapito() {
        return recapito;
    }

    public String getEmail() {
        return email;
    }

    public String getHashID() {
        return hashID;
    }

    public String toString() {
        return this.nome + " " + this.cognome + " " + this.email;
    }

/*
    public String toFile() {
        return email + ';' + nome + ';' + cognome + ';' + recapito + "\n";
    }
*/

    public void checkFiles() {

        String path = "src/test/Amuber/Users/" + getClass().getSimpleName() + "/" + this.getHashID();

        File directory = new File(path);
        if (!directory.exists()) {
            try {
                Files.createDirectories(Paths.get(path));
                System.out.println("Directory is created for " + this.getEmail() + " !");
            } catch (IOException e) {
                System.err.println("Failed to create directory for " + this.getEmail() + " ! -> " + e.getMessage());
            }
        } else System.out.println("Directory exist for " + this.getEmail() + " !");

    }
}
