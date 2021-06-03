package it.unicam.cs.ids2021.project.service;

import it.unicam.cs.ids2021.project.users.Commerciante;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MD5Test {
    @Test
    void getHash2() {

        /**
         * corretto
         * mario.rossi@gmail.com -> e152bebdada49257c309f26518099257
         * antonio.corradi@gmail.com -> af60bcd80b2ff878a09c67ed2b4ee885
         */
        //Il sistema recupera le informazioni riguardo Mario Rossi
        Commerciante comm1 = new Commerciante("Mario", "Rossi", "mario.rossi@gmail.com", "3225552431");

        //Il commerciante seleziona l'attività "Pencil Hub" tra le sue attività
        //Magazzino mag1 = new Magazzino("Pencil Hub", "Via San Mario 34", comm1);

        //Il sistema recupera le informazioni riguardo Antonio Corradi
        Commerciante comm2 = new Commerciante("Antonio", "Corradi", "antonio.corradi@gmail.com", "3246452343");

        //Il commerciante seleziona l'attività "Pencil Hub" tra le sue attività
        //Magazzino mag2 = new Magazzino("Coop", "Via San Mario 5", comm2);
        //Magazzino mag3 = new Magazzino("Coal", "Via San Mario 7", comm2);

        assertEquals("e152bebdada49257c309f26518099257", comm1.getHashID());
        assertEquals("af60bcd80b2ff878a09c67ed2b4ee885", comm2.getHashID());
    }
}