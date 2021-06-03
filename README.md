# IDS-C3
Centro Commerciale in Centro (.gitignore aggiunto per cardif)

Centro Commerciale in Centro (C3)


Il progetto si rivolge ai centri abitati medi della provincia italiana dove le attività commerciali del centro soffrono la concorrenza di grossi centri commerciali situati nelle periferie. L’idea di fondo è considerare il trasporto della merce una volta acquistata.
Una delle scomodità principali degli acquisti in centro oltre alla più difficile collocazione dei punti vendita in relazione a specifiche categorie merceologiche. 
Il progetto si pone dunque come obiettivo quello di fornire un supporto per rendere l’esperienza degli acquisti in centro più facile e interessante. 
Si identificano in particolare i seguenti chiari attori con alcuni possibili scenari di utilizzo della piattaforma: 

Commerciante: vende la merce e definisce il punto di ritiro della stessa comunicando contestualmente al cliente la merce acquistata e i codici per il ritiro della stessa. Si registra sulla piattaforma e effettua i pagamenti e la gestione del suo account. Può avere delle statistiche sul numero di persone che sono in questo momento nell’area(???:Poco chiaro). Può lanciare vendite promozionali sui prodotti. Può consorziarsi con altri punti vendita per definire vendite combinate... In sostanza può usare la piattaforma per promuovere la propria attività al fine di poter vendere la sua merce 

Cliente: ritira la merce dai punti di prelievo. Può ricercare i punti vendita sulla base di specifiche categorie merceologiche. vuole essere allertato e magari filtrare le promozioni. Riceve alert se il sistema riconosce uno spostamento verso(???)

Corriere: si registra sulla piattaforma e si rende disponibile a effettuare trasporto della merce. Preleva la merce dai punti vendita. Rilascia la merce presso i punti di prelievo (che ne caso per i residenti in centro può essere la propria abitazione). ...   

*************************************************************************************************************************************************

# ***Iterazione 1***

### **Primo colloquio:**

Definizione Attori Principali:

COMMERCIANTE----(assegna pacco)---->CORRIERE----(consegna pacco)---->CLIENTE(paga Piattaforma)

La vista dell'app varia in base alla tipologia di utente registrato (tipo UBER)

COMMERCIANTE:
- Vende la merce(gestione prezzi);
- Riceve/gestisce ordini presentati dai clienti;
- Si registra sulla piattaforma come Commerciante;
- Modifica lista prodotti;
- Definisce punto di ritiro merce (assegna codice univoco);
- (Può avere statistiche di utenti locali?);
- Può creare offerte e promozioni merce;
- Può consorziarsi (mettersi d'accordo ndr) con shop di stessa categoria per definire vendite combinate;
il tutto al fine di vendere la propria merce sulla piattaforma

CLIENTE:
- Può ricercare un prodotto e ricevere come risultato i negozi che lo vendono;
- Crea un carrello inserendo degli articoli all'interno
- Crea/Elimina/modifica ordine;
- Effettua pagamenti al Commerciante;
- Riceve alert:
    - Per le promozioni (che possono essere filtrate)
    - Tracciamento pacco (arrivo al punto di ritiro)
    - Eventuali problemi di spedizione/ordine
- Viene autenticato al momento della ricezione del pacco tramite il codice emesso dal venditore

*************************************************************************************************************************************************

### **Secondo colloquio:**

Continuo definizione attori principali (sono 3 ma ne sono stati descritti 2):

CORRIERE:
- Effettua un login come corriere;
- Ha un sistema di feedback "gestito" da Clienti e Commercianti;
- Ha uno stato (se è in zona ed è libero);
- Ha una "categoria" dove specifica il veicolo che utilizza (leggero, medio, pesante, etc.);
- Consegna i pacchi nei punti di ritrovo (amazon locker);
- Può notificare cliente e/o commerciante per eventuali problemi/info;

*************************************************************************************************************************************************

### **Terzo colloquio:**

Analisi intensa e dettagliata di 3 casi d'uso.

COMMERCIANTE:
- Riceve/gestisce ordini presentati dai clienti:
	- Riceve ordine //caso d'uso a parte
	- Verifica che il pagamento sia stato effettuato (il pagamento lo gestisce il sistema)
	- Controlla se gli articoli siano presenti //può gestirla il sistema
	(se non presenti invia una data in cui l'articolo sarà di nuovo presente)
	- Cerca corriere disponibile nella zona 
	- Assegna una commissione al corriere trovato
	- Notifico avanzamento ordine

CLIENTE:
- Può ricercare un prodotto e ricevere come risultato i negozi che lo vendono:
	- Effettua una ricerca per prodotto/ categoria/ commerciante
	- Interagisce con il prodotto/ commerciante (può visualizzare dettagli degli articoli/ commercianti)
	- Crea un carrello inserendo degli articoli all'interno (può aggiungere più articoli dello stesso tipo)
	- Visualizza subtotale 	
	- Modifica carrello	
	
- Crea/Elimina/modifica ordine

*************************************************************************************************************************************************

### **Quarto colloquio:**

Discussione su come organizzarsi nei prossimi colloqui.


*************************************************************************************************************************************************

### **Quinto colloquio:**

Definizione miogliorata dei casi d'uso


COMMERCIANTE:
- Si registra sulla piattaforma come Commerciante
- Aggiunta dati personali (nome, cognome, indirizzo, recapito)
- *Aggiunta prodotti da vendere (codice univoco, nome, descrizione, quantità, prezzo)
- Contatta/notifica altri commercianti per possibili consorzi
- Rimozione prodotti
- Gestione possibili offerte (a tempo)
- Visualizzazione magazzino
- Visualizza ordini
- Notifica il sistema che l'ordine è pronto
- Contatta/notifica clienti
- Contatta/notifica corriere
- Visualizza alert (da sistema) -> 
	• arrivo nuovo ordine
	• se qualche oggetto manca o sta per finire nel magazzino
	• partenza/arrivo pacco
	• messaggi vari

- da rivedere :
	- Può avere statistiche di utenti locali
	- Definisce punto di ritiro merci (con annesso codice univoco)


CLIENTE:
- Si registra sulla piattaforma come Cliente
- Aggiunta dati personali (nome, cognome, indirizzo, recapito)
- Ricerca prodotto/categoria/commerciante
- *Aggiunta prodotti carrello
- *Creazione ordine
- Rimozione prodotti carrello
- Visualizza promozioni
- Selezione metodo di pagamento

- Effettua pagamenti
- Annullamento ordine (entro certi limiti)
- Contatta commerciante
- Contatta corriere 
- Visualizza alert (da sistema) -> 
	• promozioni
	• stato ordine
	• eventuali problemi di spedizione/ordine
	• messaggi vari
	• punto di arrivo pacco (con annesso codice identificativo)
	

CORRIERE:
- Si registra sulla piattaforma come Corriere
- Aggiunta dati personali (nome, cognome, indirizzo, recapito)
- Aggiunta tipo di veicolo utilizzato (leggero, medio, pesante, etc.)
- *Modifica stato (disponibile/non disponibile)
- *Vizualizza ordini assegnati (tipologia pacco, destinazione)
- Notifica il sistema che l'ordine è in partenza/arrivo
- Notifica il sistema che l'ordine è stato consegnato
- Contatta commerciante
- Contatta cliente
- Tracciamento (per assegnazione ordini)
- Visualizza alert (da sistema) -> 
	• ordini assegnati
	• messaggi vari


SISTEMA
- Assegnazione ordini (assegna un ordine basandosi sulla vicinanza di un corriere)**
- Gestione ordini (ordinamento in base alla priorità)
- Verifica pagamenti
- *Definisce punto di ritiro merce
- Notifica commerciante riguardo nuovi ordini
- Notifica commerciante per la carenza di un certo prodotto
- Notifica commerciante stato consegna ordine
- Notifica cliente promozioni
- Notifica cliente stato ordine
- Notifica cliente per eventuali problemi
- Notifica cliente il punto di arrivo pacco (con annesso codice identificativo)
- Notifica commerciante di eventuali ordini

ASTERISCHI -> casi d'uso principali

*************************************************************************************************************************************************

### **Sesto colloquio:**

Creazione diagramma casi d'uso in Visual Paradigm 

CLIENTE:
- visualizza promozioni
- ricerca prodotto/categoria
- aggiunta nel carrello INCLUDE rimozione dal carrello
- registraz. come cliente INCLUDE agg. dati personali ( note: nome, cognome, indirizzo, recapito)
- creazione ordine INCLUDE (annullamento ordine & seleziona metodo di pagamento) EXTENDS superamento limiti per annullamento
- effettua pagamenti EXTENDS verifica pagamenti (gestito dal sistema)
- contatta commerciante
- contatta corriere

PS: 
• si collega al caso d'uso del server "notifica cliente"
• si collega al caso d'uso che hanno in comune i 3 attori : logIN EXTENDS password errata

CORRIERE:
- modifica stato ( note: disponibile / non disponibile) (occupato se sta consegnando)
- visualizza ordini assegnati (note : tipologia pacco e destinazione) 
- aggiunta veicolo in uso ( note: leggero, medio , pesante)
- registrazione come corriere INCLUDE aggiunta dati personali ( note: nome, cognome, indirizzo , recapito)
- contatta commerciante 
- contatta cliente

PS: 
• si collega al caso d'uso del server " notifica corriere" 
• si collega al caso d'uso che hanno in comune i 3 attori : logIN EXTENDS password errata   
 
COMMERCIANTE:
- visualizza magazzino
- contatta per consorzi
- gestione offerte
- aggiunta prodotti INCLUDE rimozione prodotti
- visualizza ordine INCLUDE annulla ordine
- registrazione come commerciante INCLUDE aggiunta dati personali (note: nome, cognome, indirizzo, recapito)
- notifica sistema (note: ordine pronto)
- contatta cliente
- contatta corriere

PS: 
• si collega al caso d'uso del server " notifica commerciante" 
• si collega al caso d'uso che hanno in comune i 3 attori : logIN EXTENDS password errata 

SERVER DI SISTEMA:
- gestione lista ordini (assegna un ordine basandosi sulla vicinanza di un corriere) INCLUDE assegnazione ordine (ordini ordinati per priorità temporale)
- verifica pagamenti
- notifica commerciante EXTENDS ( arrivo nuovi ordini, mostra stato ordine, avviso prodotti mancanti)
- notifica corriere EXTENDS ( segnalazione problemi, assegnazione nuovi ordini)
- notifica cliente EXTENDS ( segnalazione problemi, mostra punto ritiro, stato ordine promozioni)

*************************************************************************************************************************************************

### **Settimo e Ottavo colloquio:**

Individuazione e sviluppo (specifico) casi d'uso principali

Casi d'uso principali:

- Aggiunta prodotti da vendere
- Aggiunta prodotti carrello
- Creazione ordine
- Modifica stato (disponibile/non disponibile)
- Vizualizza ordini assegnati (tipologia pacco, destinazione)
- Assegnazione ordini (assegna un ordine basandosi sulla vicinanza di un corriere)
- Definisce punto di ritiro merce
- Ricerca prodotto

Sviluppati:

- Aggiunta prodotti da vendere
- Creazione ordine	
- Aggiunta prodotti carrello
- Modifica stato (disponibile/non disponibile)
- Vizualizza ordini assegnati (tipologia pacco, destinazione)

(controllare)
- Assegnazione ordini (assegna un ordine basandosi sulla vicinanza di un corriere)
- Definisce punto di ritiro merce

*************************************************************************************************************************************************

### **Nono e decimo colloquio:**

Adattamento/modifica casi d'uso in VP:

- Aggiunta prodotti da vendere

Aggiunta caso d'uso in VP:

- Aggiunta prodotto INCLUDE modifica prodotto

Prima occhiata al progetto in Java


*************************************************************************************************************************************************

### **Undicesimo colloquio:**

- Diagramma di dominio (completato)

- Discussione riguardo codice Java


*************************************************************************************************************************************************

### **Dodicesimo e tredicesimo colloquio:**

- Modello di Progetto

- Diagramma di sequenza "aggiunta prodotto" (completato)


*************************************************************************************************************************************************

### **Quattordicesimo colloquio:**

- Diagramma di sequenza "aggiunta prodotto" revisionato
- Diagramma di sequenza "aggiunta nel carrello" iniziato


*************************************************************************************************************************************************

### **Quattordicesimo colloquio:**

- Classi di progetto revisionato

- Diagramma di sequenza "aggiunta nel carrello" (completato)


*************************************************************************************************************************************************

### **Quindicesimo colloquio:**

- Classi di progetto non revisionato completamente (carrello & ordine)

- Diagramma di sequenza "ricerca prodotto/categoria" (completato)
- Diagramma di sequenza "aggiunta nel carrello" da revisionare


*************************************************************************************************************************************************

### **Sedicesimo e diciassettesimo colloquio:**

- Implementazione codice per caso d'uso "aggiunta prodotto" in Java (completato)


*************************************************************************************************************************************************

### **Diciottesimo colloquio:**

- "Pulizia" codice Java (aggiunta relazione tra prodotto e magazzino)
- Diagramma di sequenza "creazione ordine" (completato)


*************************************************************************************************************************************************

# ***Iterazione 2***

### **primo colloquio:**

Obbiettivi incentrati sugli ordini

- creazione ordine (da sistemare)-> suddivisione ordini -> ordine e gestore ordini (commerciante)
- elaborazione ordine (aggiungere stato ordine) -> enum ordine
- assegnazione ordine -> visualizza ordini assegnati (corriere)
- modifica stato corriere


*************************************************************************************************************************************************

### **Secondo e terzo colloquio:**

Revisione codice e implementazione di un database


*************************************************************************************************************************************************