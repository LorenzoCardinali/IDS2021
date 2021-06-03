package it.unicam.cs.ids2021.storage;

import it.unicam.cs.ids2021.service.MD5;
import it.unicam.cs.ids2021.users.Commerciante;

import java.util.Objects;

public class Magazzino {

    private final String nome;
    private final Commerciante proprietario;
    private final String indirizzo;
    private final String hashID;


    public Magazzino(String nome, String indirizzo, Commerciante commerciante) {
        this.nome = nome;
        this.proprietario = commerciante;
        this.indirizzo = indirizzo;
        this.hashID = MD5.getHash2(nome, proprietario.getHashID());
    }

    public String getNome() {
        return nome;
    }

    public Commerciante getProprietario() {
        return proprietario;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public String getHashID() {
        return hashID;
    }

    public String toString() {
        return this.nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Magazzino magazzino = (Magazzino) o;
        return hashID.equals(magazzino.hashID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hashID);
    }
}
