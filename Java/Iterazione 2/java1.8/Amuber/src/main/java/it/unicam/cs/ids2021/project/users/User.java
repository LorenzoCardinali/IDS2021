package it.unicam.cs.ids2021.project.users;

import it.unicam.cs.ids2021.project.service.MD5;

import java.util.Objects;

public abstract class User {

    private final String nome;
    private final String cognome;
    private final String email;
    private final String recapito;
    private final String hashID;

    public User(String nome, String cognome, String email, String recapito) {
        if (nome == null || cognome == null || email == null || recapito == null)
            throw new NullPointerException("Errore dati inseriti.");
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.recapito = recapito;
        this.hashID = MD5.getHash2(email, cognome);
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
        return this.email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return hashID.equals(user.hashID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hashID);
    }
}