package it.unicam.cs.ids2021.project.storage;

import it.unicam.cs.ids2021.project.enums.Categoria;
import it.unicam.cs.ids2021.project.service.MD5;

import java.util.Objects;

public class Prodotto {

    private final String nome;
    private final String marca;
    private final Categoria categoria;
    private final int disponibilita;
    private final double prezzo;
    private final Magazzino magazzino;
    private String descrizione = "[NULL]";
    private final String hashID;

    public Prodotto(String nome, String marca, Categoria categoria, int disponibilita, double prezzo, Magazzino magazzino, String descrizione) {
        if(nome.equals("") || marca.equals("") || categoria == null || disponibilita == 0 || prezzo == 0.0 || magazzino == null)
            throw new NullPointerException("Valori prodotto nulli!");
        this.nome = nome;
        this.marca = marca;
        this.categoria = categoria;
        this.disponibilita = disponibilita;
        this.prezzo = prezzo;
        this.magazzino = magazzino;
        if (!descrizione.equals("")) this.descrizione = descrizione;
        this.hashID = MD5.getHash2(nome, marca, magazzino.getHashID());
    }

    public String getNome() {
        return nome;
    }

    public String getMarca() {
        return marca;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public int getDisponibilita() {
        return disponibilita;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public String getHashID() {
        return hashID;
    }

    public Magazzino getMagazzino() {
        return magazzino;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public String toString() {
        return this.hashID + " - "
                + this.nome + " - "
                + this.marca + " - "
                + this.categoria + " - "
                + this.disponibilita + " - "
                + this.prezzo + " - "
                + this.magazzino.getHashID() + " - "
                + this.descrizione;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prodotto prodotto = (Prodotto) o;
        return hashID.equals(prodotto.hashID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hashID);
    }
}
