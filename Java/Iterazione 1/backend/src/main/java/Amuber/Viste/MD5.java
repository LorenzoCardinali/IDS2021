package Amuber.Viste;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public interface MD5 {
    static String setCodice(String... strings) {

        // Lettere maiuscole -> minuscole
        for (int i = 0; i < strings.length; i++) {
            strings[i] = strings[i].toLowerCase();
        }

        // Riordino alfabetico array
        Arrays.sort(strings);

        // Unisco stringhe
        StringBuilder toReturn = new StringBuilder();
        for (String string : strings) {
            toReturn.append(string.replaceAll("\\s+", ""));
        }

        try {
            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // digest() method is called to calculate message digest
            // of an input digest() return array of byte
            byte[] messageDigest = md.digest(toReturn.toString().getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            StringBuilder hashtext = new StringBuilder(no.toString(16));
            while (hashtext.length() < 32) {
                hashtext.insert(0, "0");
            }
            return hashtext.toString();
        }

        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        //return Objects.hash(email, cognome);
    }
}
