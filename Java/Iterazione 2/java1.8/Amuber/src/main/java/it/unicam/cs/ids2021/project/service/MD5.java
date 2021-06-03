package it.unicam.cs.ids2021.project.service;

import org.jetbrains.annotations.NotNull;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public final class MD5 {
    @NotNull
    public static String getHash2(String... strings) {

        StringBuilder toReturn = new StringBuilder();

        Arrays.stream(strings)
                // Lettere maiuscole -> minuscole
                .map(String::toLowerCase)
                // Riordino alfabetico array
                .sorted()
                // Unisco stringhe
                .forEach(s -> toReturn.append(s.replaceAll("\\s+", "")));

        try {
            // digest() method is called to calculate message digest
            // of an input digest() return array of byte
            byte[] messageDigest = MessageDigest
                    // Static getInstance method is called with hashing MD5
                    .getInstance("MD5")
                    .digest(toReturn.toString().getBytes());

            // Convert message digest into hex value
            StringBuilder hashtext = new StringBuilder(
                    // Convert byte array into signum representation
                    new BigInteger(1, messageDigest).toString(16));
            while (hashtext.length() < 32) hashtext.insert(0, "0");

            return hashtext.toString();
        }

        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
