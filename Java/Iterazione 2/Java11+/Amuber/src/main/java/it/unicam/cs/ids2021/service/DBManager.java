package it.unicam.cs.ids2021.service;

import it.unicam.cs.ids2021.enums.Categoria;
import it.unicam.cs.ids2021.storage.Carrello;
import it.unicam.cs.ids2021.storage.Magazzino;
import it.unicam.cs.ids2021.storage.Ordine;
import it.unicam.cs.ids2021.storage.Prodotto;
import it.unicam.cs.ids2021.users.Cliente;
import it.unicam.cs.ids2021.users.Commerciante;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class DBManager {

    private static DBManager istance;
    final String url = "jdbc:mysql://crivelliserver.ddns.net:3306/amuber";
    final String user = "admin";
    final String password = "amuber99";
    private Connection connection;
    private Statement statement;

    private DBManager() {
        testDB();
    }

    public static DBManager getIstance() {
        return istance == null ? istance = new DBManager() : istance;
    }

    /**
     * Connection
     */
    private void testDB() {
        try {
            if (connection == null || connection.isClosed()) {
                connectDB();
            }
            DatabaseMetaData data = connection.getMetaData();
            System.out.println("#####################################\n"
                    + "Database connected, ready to go!\n"
                    + "User: " + data.getUserName() + "\n"
                    + "#####################################");
            disconnectDB();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void disconnectDB() {
        try {
            connection.close();
            istance = null;
            statement = null;
        } catch (SQLException e) {
            System.out.println("Problems in closing the connection to the DB");
            e.printStackTrace();
        }
    }

    private void connectDB() {
        try {
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("Problems in opening a connection to the DB");
            e.printStackTrace();
        }
    }

    /**
     * Executor
     */
    public void executeQuery(String sql) {
        connectDB();
        try {
            statement.execute(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        disconnectDB();
    }

    /**
     * String creator
     */
    public String insertInto(String tabella,  String... valori) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("INSERT INTO amuber.").append(tabella).append(" (");

        for (int i = 0; i < valori.length; i++) {

            if (i < valori.length / 2) {
                stringBuilder.append(valori[i]);
                if (i < valori.length / 2 - 1) stringBuilder.append(", ");
            } else if (i == valori.length / 2) {
                stringBuilder.append(") VALUES ('").append(valori[i]).append("', ");
            } else if (i > valori.length / 2) {
                stringBuilder.append("'").append(valori[i]).append("'");
                if (i < valori.length - 1) stringBuilder.append(", ");
            }
        }

        stringBuilder.append(");");
        return stringBuilder.toString();
    }

    /**
     * Cliente
     */
    public void addCliente( Cliente cliente) {
        this.executeQuery(this.insertInto("Cliente",
                "idCliente", "nome", "cognome", "email", "recapito", "indirizzo",
                cliente.getHashID(), cliente.getNome(), cliente.getCognome(), cliente.getEmail(), cliente.getRecapito(), cliente.getIndirizzo())
        );
    }

    //TODO
    public Cliente getCliente(String idCliente) {
        return null;
    }

    public Set<Cliente> getClienti() {
        connectDB();

        Set<Cliente> clientes = new HashSet<>();

        String sql = "SELECT * FROM amuber.Cliente";
        try {
            ResultSet res = statement.executeQuery(sql);
            while (res.next()) {
                //Cliente("Luca", "Pallino", "luca.pallino@gmail.com", "3488231485", "Via dante 20");
                clientes.add(new Cliente(
                                res.getString("nome"),
                                res.getString("cognome"),
                                res.getString("email"),
                                res.getString("recapito"),
                                res.getString("indirizzo")
                        )
                );
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        disconnectDB();
        return clientes;
    }

    /**
     * Commercinate
     */
    public void addCommerciante( Commerciante commerciante) {
        this.executeQuery(this.insertInto("Commerciante",
                "idCommerciante", "nome", "cognome", "email", "recapito",
                commerciante.getHashID(), commerciante.getNome(), commerciante.getCognome(), commerciante.getEmail(), commerciante.getRecapito())
        );
    }

    private Commerciante getCommerciante(String idCommerciante) {
        connectDB();

        String sql = "SELECT * FROM amuber.Commerciante WHERE idCommerciante = '"
                + idCommerciante + "'";

        Commerciante commerciante = null;

        try {
            ResultSet res = statement.executeQuery(sql);
            while (res.next()) {
                commerciante = new Commerciante(
                        res.getString("nome"),
                        res.getString("cognome"),
                        res.getString("email"),
                        res.getString("recapito"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        disconnectDB();
        return commerciante;
    }

    public Set<Commerciante> getCommercianti() {
        connectDB();

        Set<Commerciante> commerciantes = new HashSet<>();

        String sql = "SELECT * FROM amuber.Commerciante";
        try {
            ResultSet res = statement.executeQuery(sql);
            while (res.next()) {
                commerciantes.add(new Commerciante(
                        res.getString("nome"),
                        res.getString("cognome"),
                        res.getString("email"),
                        res.getString("recapito")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        disconnectDB();
        return commerciantes;
    }

    /**
     * Magazzino
     */
    public void addMagazzino( Magazzino magazzino) {
        this.executeQuery(this.insertInto("Magazzino",
                "idMagazzino", "nome", "indirizzo", "idCommerciante",
                magazzino.getHashID(), magazzino.getNome(), magazzino.getIndirizzo(), magazzino.getProprietario().getHashID())
        );
    }

    private Magazzino getMagazzino(String idMagazzino) {
        connectDB();

        String sql = "SELECT * FROM amuber.Magazzino WHERE idMagazzino = '"
                + idMagazzino + "'";

        Magazzino magazzino = null;

        try {
            ResultSet res = statement.executeQuery(sql);
            while (res.next()) {
                magazzino = new Magazzino(
                        res.getString("nome"),
                        res.getString("indirizzo"),
                        this.getCommerciante(res.getString("idCommerciante")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        disconnectDB();
        return magazzino;
    }

    public Set<Magazzino> getMagazzini( Commerciante commerciante) {
        connectDB();

        String sql = "SELECT * FROM amuber.Magazzino WHERE idCommerciante = '"
                + commerciante.getHashID() + "'";

        Set<Magazzino> magazzinos = new HashSet<>();

        try {
            ResultSet res = statement.executeQuery(sql);
            while (res.next()) {
                magazzinos.add(new Magazzino(
                        res.getString("nome"),
                        res.getString("indirizzo"),
                        commerciante));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        disconnectDB();
        return magazzinos;
    }

    /**
     * Prodotto
     */
    public void addProddotto( Prodotto prodotto) {
        this.executeQuery("INSERT INTO amuber.Prodotto (idProdotto, nome, marca, categoria, disponibilita, prezzo, idMagazzino, descrizione) VALUES ('"
                + prodotto.getHashID() + "', '"
                + prodotto.getNome() + "', '"
                + prodotto.getMarca() + "', '"
                + prodotto.getCategoria() + "', '"
                + prodotto.getDisponibilita() + "', '"
                + prodotto.getPrezzo() + "', '"
                + prodotto.getMagazzino().getHashID() + "', '"
                + prodotto.getDescrizione() + "') "
                + "ON DUPLICATE KEY UPDATE disponibilita = disponibilita + "
                + prodotto.getDisponibilita() + ";");
    }

    private Prodotto getProdotto(String idProdotto) {
        connectDB();
        String sql = "SELECT * FROM Prodotto WHERE idProdotto = '" +
                idProdotto + "'";

        Prodotto prodotto = null;
        try {
            ResultSet res = statement.executeQuery(sql);
            while (res.next()) {
                prodotto = new Prodotto(
                        res.getString("nome"),
                        res.getString("marca"),
                        Categoria.valueOf(res.getString("categoria")),
                        res.getInt("disponibilita"),
                        res.getDouble("prezzo"),
                        this.getMagazzino(res.getString("idMagazzino")),
                        res.getString("descrizione")
                );
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        disconnectDB();
        return prodotto;
    }

    public Set<Prodotto> getProdotti( Magazzino magazzino) {
        connectDB();

        String sql = "SELECT * FROM amuber.Prodotto WHERE idMagazzino = '"
                + magazzino.getHashID() + "';";

        Set<Prodotto> prodottos = new HashSet<>();

        try {
            ResultSet res = statement.executeQuery(sql);
            while (res.next()) {
                prodottos.add(new Prodotto(
                        res.getString("nome"),
                        res.getString("marca"),
                        Categoria.valueOf(res.getString("categoria")),
                        res.getInt("disponibilita"),
                        res.getDouble("prezzo"),
                        magazzino,
                        res.getString("descrizione")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        disconnectDB();
        return prodottos;
    }

    /**
     * Ordine
     */
    //TODO sistemare
    public void addOrdine( Ordine ordine) {
        this.executeQuery("INSERT INTO amuber.Ordine (idOrdine, idCliente, totale, statoOrdine) VALUES ('"
                + ordine.getHashID() + "', '"
                + ordine.getCliente().getHashID() + "', '"
                + ordine.getTotale() + "', '"
                + ordine.getStato() + "');");

        ordine.getProdotti().keySet().forEach(idProdotto ->
                this.executeQuery("INSERT INTO amuber.OrdineProdotto (idOrdine, idProdotto, quantita) VALUES ('"
                        + ordine.getHashID() + "', '"
                        + idProdotto + "', '"
                        + ordine.getProdotti().get(idProdotto) + "');"
                )
        );
    }

    //TODO
    public Ordine getOrdine(String idOrdine) {
        return null;
    }

    //TODO
    public Set<Ordine> getOrdini() {
        return null;
    }

    /**
     * Carrello
     */
    public Carrello getCarrello( Cliente cliente) {
        connectDB();

        String sql = "SELECT * FROM amuber.Carrello WHERE idCliente = '"
                + cliente.getHashID() + "';";

        Carrello carrello = new Carrello(cliente);

        try {
            ResultSet res = statement.executeQuery(sql);
            while (res.next()) {
                carrello.addProdotto(this.getProdotto(res.getString("idProdotto")), res.getInt("quantita"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        disconnectDB();
        return carrello;
    }

    /**
     * Altro
     */
    //TODO
    public Set<Prodotto> ricercaProdotto(Categoria categoria, String filtro) {
        return null;
    }

}

/*public static void main(String[] args) {

    try {
        //Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();

        //String addUser = "insert into Commerciante (idCommerciante, nome, cognome, email, recapito) values ();";

        String sql = "select * from amuber.Commerciante where Commerciante.idCommerciante like 'af60bcd80b2ff878a09c67ed2b4ee885'";
        //String sql = "select * from amuber.Commerciante";
        ResultSet resultSet = statement.executeQuery(sql);

        //Commerciante commerciante = new Commerciante(resultSet.getString("nome"), resultSet.getString("cognome"),resultSet.getString("email"),resultSet.getString("recapito"));

        while (resultSet.next()) {
            Commerciante commerciante = new Commerciante(resultSet.getString("nome"), resultSet.getString("cognome"),resultSet.getString("email"),resultSet.getString("recapito"));
            System.out.println(resultSet.getString(1) + " - " + resultSet.getString(2) + " - " + resultSet.getString(3) + " - " + resultSet.getString(4) + " - " + resultSet.getString(5));
            System.out.println(commerciante.getNome());
        }

    } catch (SQLException /*| ClassNotFoundException throwables) {
        throwables.printStackTrace();
    }
*/



