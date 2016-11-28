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

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Owner
 */
public class AesEncryptionTest {
    
    public AesEncryptionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of encryptText method, of class AesEncryption.
     * @throws java.lang.Exception If Encryption fails
     */
    @Test
    public void testEncryptText() throws Exception {
        System.out.println("encryptText");
        String plainText = "Encrypt this text.";
        String expResult = "9F9940D90D968F1EE7CD5AF06395CF71F5C435EAB2D6BE2FBCDFE5B8DA99FEFD";
        String result = AesEncryption.encryptText(plainText);
        System.out.println(expResult +  " = " + result);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of decryptText method, of class AesEncryption.
     * @throws java.lang.Exception If Decryption fails
     */
    @Test
    public void testDecryptText() throws Exception {
        System.out.println("decryptText");
        String encryptedText = "5086D5E0231C9EA311828F6F489683FAF5C435EAB2D6BE2FBCDFE5B8DA99FEFD";
        String expResult = "Decrypt this text.";
        String result = AesEncryption.decryptText(encryptedText);
        System.out.println(expResult + " = " + result);
        assertEquals(expResult, result);
    }
    
}
