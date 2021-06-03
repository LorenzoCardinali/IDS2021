package it.unicam.cs.ids2021.project.users;

public class Cliente extends User {

    private final String indirizzo;

    public Cliente(String nome, String cognome, String email, String recapito, String indirizzo) {
        super(nome, cognome, email, recapito);

        this.indirizzo = indirizzo;
    }

    public String getIndirizzo() {
        return indirizzo;
    }
}
