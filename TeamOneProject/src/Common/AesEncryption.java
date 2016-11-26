/*
 * Copyright 2016 AUTHORS. Patrick S Sewell, Paul M Dyer, Taehyeok Lee, 
 * Benjamin C Ferguson, Hyunki J KIm Permission is granted to copy, distribute 
 * and/or modify this document under the terms of the GNU Free Documentation 
 * License, Version 1.3, (3 November 2008) or any later version published by 
 * the Free Software Foundation; with no Invariant Sections, with no 
 * Front-Cover Texts, and with no Back-Cover Texts. A copy of the license 
 * can be found at http://www.gnu.org/copyleft/fdl.html
 */
package Common;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

/**
 * Used to encrypt and decrypt data using an AES encryption algorithm.
 *
 * This code was originally taken from
 * http://www.quickprogrammingtips.com/java/how-to-encrypt-and-decrypt-data-in-java-using-aes-algorithm.html
 * and adapted for use in this application.
 *
 * @author Patrick Sewell
 */
public class AesEncryption {

    /**
     * Encrypts plainText in AES using the secret key.
     *
     * @param plainText
     * @return Encrypted string or nothing
     * @throws Exception If the encryption operation fails
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
     * Decrypts encrypted string using the key used for encryption.
     *
     * @param encryptedText A string of encrypted text
     * @return A string containing the decrypted text
     * @throws Exception If the decryption operation fails
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

    private static SecretKey getSecretEncryptionKey() throws Exception {
        byte[] raw = DatatypeConverter.parseHexBinary("1918CE2C428773705B9B43688E4B4FB2");
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");

        return skeySpec;
    }

    private static String bytesToHex(byte[] hash) {
        return DatatypeConverter.printHexBinary(hash);
    }
}
