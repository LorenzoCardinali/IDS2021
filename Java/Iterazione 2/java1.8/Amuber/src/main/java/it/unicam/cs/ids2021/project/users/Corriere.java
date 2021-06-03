package it.unicam.cs.ids2021.project.users;

import it.unicam.cs.ids2021.project.enums.Status;
import it.unicam.cs.ids2021.project.enums.Veicolo;

public class Corriere extends User {

    private Veicolo veicolo;
    private Status stato;

    public Corriere(String nome, String cognome, String email, String recapito) {
        super(nome, cognome, email, recapito);
        this.stato = Status.Inactive;
        this.veicolo = Veicolo.Null;
    }

    public Status getStato() {
        return stato;
    }

    public void setStato(Status stato) {
        this.stato = stato;
    }

    public Veicolo getVeicolo() {
        return veicolo;
    }

    public void setVeicolo(Veicolo veicolo) {
        this.veicolo = veicolo;
    }
}
