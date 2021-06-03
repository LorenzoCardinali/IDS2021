package Amuber;

import Amuber.Enums.Categoria;
import Amuber.Viste.MD5;

/**
 * Classe che contiene l'istanziazione di un oggetto di tipo prodotto, il prodotto verrà creato al momento dell'aggiunta da parte
 * di un comemrciante al magazzino (che sono quindi disponibili per la vendita), che è una lista ed eventualmente salvato.
 */
public class Prodotto implements Comparable<Prodotto> {

    final private String codice;
    private String nome;
    private String marca;
    private int disponibilita;
    private double prezzo;
    private String descrizione;
    private Categoria categoria;
    private final Magazzino magazzino;

    public Prodotto(String nome, String marca, int disponibilita, double prezzo, String descrizione, Categoria categoria, Magazzino magazzino) {
        if (nome == null || descrizione == null || categoria == null) throw new NullPointerException();
        if (disponibilita <= 0 || prezzo <= 0)
            throw new IllegalArgumentException("Non è possibile inserire valori non accettati");
        this.nome = nome;
        this.marca = marca;
        this.disponibilita = disponibilita;
        this.prezzo = prezzo;
        this.descrizione = descrizione;
        this.categoria = categoria;
        this.magazzino = magazzino;
        this.codice = MD5.setCodice(categoria.toString(), nome, marca);
    }

    //getters and setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodice() {
        return codice;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getDisponibilita() {
        return disponibilita;
    }

    public void setDisponibilita(int disponibilita) {
        this.disponibilita = disponibilita;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Magazzino getMagazzino() {
        return magazzino;
    }

    public String toFile(boolean withMagazzino) {
        /** codice nome marca disponibilita prezzo descrizione **/
        String tofile = new String(codice + ';' + nome + ';' + marca + ';' + disponibilita + ';' + prezzo + ';' + descrizione);
        return withMagazzino ? tofile + ";" + magazzino.getHashID() + "\n" : tofile + "\n";
    }

    @Override
    public String toString() {
        return "{nome=" + nome +
                ", codice=" + codice +
                ", disponibilita=" + disponibilita +
                ", prezzo=" + prezzo +
                ", descrizione=" + descrizione +
                ", categoria=" + categoria +
                "}\n";
    }

    @Override
    public int compareTo(Prodotto o) {
        if (this.getCodice().equals(o.getCodice())) return 0;
        else return 1;
    }
}
