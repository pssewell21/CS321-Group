/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

/**
 * This code was originally taken from
 * http://www.quickprogrammingtips.com/java/how-to-encrypt-and-decrypt-data-in-java-using-aes-algorithm.html
 * and adapted for use in this application
 *
 * @author Owner
 */
public class AesEncryption {

    /**
     * 1. Generate a plain text for encryption 2. Get a secret key (printed in
     * hexadecimal form). In actual use this must by encrypted and kept safe.
     * The same key is required for decryption. 3.
     * @throws java.lang.Exception
     */
    public void run() throws Exception {
        String plainText = "Hello World";
        SecretKey secKey = getSecretEncryptionKey();
        String excryptedText = encryptText(plainText);
        String decryptedText = decryptText(DatatypeConverter.parseHexBinary(excryptedText));

        System.out.println("Original Text:" + plainText);
        System.out.println("AES Key (Hex Form):" + bytesToHex(secKey.getEncoded()));
        System.out.println("Encrypted Text (Hex Form):" + excryptedText);
        System.out.println("Decrypted Text:" + decryptedText);
    }

    /**
     * Encrypts plainText in AES using the secret key
     *
     * @param plainText
     * @return
     * @throws Exception
     */
    public static final String encryptText(String plainText) throws Exception {   
        // AES defaults to AES/ECB/PKCS5Padding in Java 7
        Cipher aesCipher = Cipher.getInstance("AES");
        aesCipher.init(Cipher.ENCRYPT_MODE, getSecretEncryptionKey());
        byte[] byteCipherText = aesCipher.doFinal(plainText.getBytes());
        return bytesToHex(byteCipherText);
    }

    /**
     * Decrypts encrypted byte array using the key used for encryption.
     *
     * @param byteCipherText
     * @return
     * @throws Exception
     */
    public static final String decryptText(byte[] byteCipherText) throws Exception {
        // AES defaults to AES/ECB/PKCS5Padding in Java 7
        Cipher aesCipher = Cipher.getInstance("AES");
        aesCipher.init(Cipher.DECRYPT_MODE, getSecretEncryptionKey());
        byte[] bytePlainText = aesCipher.doFinal(byteCipherText);
        return new String(bytePlainText);
    }
    
    /**
     * gets the AES encryption key. In your actual programs, this should be
     * safely stored.
     *
     * @return
     * @throws Exception
     */
    private static SecretKey getSecretEncryptionKey() throws Exception {
        byte[] raw = DatatypeConverter.parseHexBinary("1918CE2C428773705B9B43688E4B4FB2");
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");

        return skeySpec;
    }

    /**
     * Convert a binary byte array into readable hex form
     *
     * @param hash
     * @return
     */
    private static String bytesToHex(byte[] hash) {
        return DatatypeConverter.printHexBinary(hash);
    }
}
