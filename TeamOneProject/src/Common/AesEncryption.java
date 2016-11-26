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
 * 
 * This code was originally taken from
 * http://www.quickprogrammingtips.com/java/how-to-encrypt-and-decrypt-data-in-java-using-aes-algorithm.html
 * and adapted for use in this application
 *
 * @author Owner
 */
public class AesEncryption {

    /**
     * Encrypts plainText in AES using the secret key
     *
     * @param plainText
     * @return
     * @throws Exception
     */
    public static final String encryptText(String plainText) throws Exception {
        // AES defaults to AES/ECB/PKCS5Padding in Java 7
        if (plainText != null) {
            Cipher aesCipher = Cipher.getInstance("AES");
            aesCipher.init(Cipher.ENCRYPT_MODE, getSecretEncryptionKey());
            byte[] byteCipherText = aesCipher.doFinal(plainText.getBytes());
            return bytesToHex(byteCipherText);
        }

        return null;
    }

    /**
     * Decrypts encrypted byte array using the key used for encryption.
     *
     * @param encryptedText
     * @return
     * @throws Exception
     */
    public static final String decryptText(String encryptedText) throws Exception {
        // AES defaults to AES/ECB/PKCS5Padding in Java 7
        if (encryptedText != null) {
            Cipher aesCipher = Cipher.getInstance("AES");
            aesCipher.init(Cipher.DECRYPT_MODE, getSecretEncryptionKey());
            byte[] bytePlainText = aesCipher.doFinal(DatatypeConverter.parseHexBinary(encryptedText));
            return new String(bytePlainText);
        }

        return null;
    }

    /**
     * gets the AES encryption key.
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
