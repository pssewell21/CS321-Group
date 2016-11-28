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

import java.io.File;
import java.sql.Timestamp;
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
public class UtilityTest {
    
    public UtilityTest() {
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
     * Test of hasValue method, of class Utility.
     */
    @Test
    public void testHasValue() {
        System.out.println("hasValue");
        String string = null;
        boolean expResult = false;
        boolean result = Utility.hasValue(string);
        assertEquals(expResult, result);
        
        string = "";
        expResult = false;
        result = Utility.hasValue(string);
        assertEquals(expResult, result);
        
        string = "Value";
        expResult = true;
        result = Utility.hasValue(string);
        assertEquals(expResult, result);
    }

    /**
     * Test of isNumeric method, of class Utility.
     */
    @Test
    public void testIsNumeric() {
        System.out.println("isNumeric");
        String string = null;
        boolean expResult = false;
        boolean result = Utility.isNumeric(string);
        assertEquals(expResult, result);
        
        string = "";
        expResult = false;
        result = Utility.isNumeric(string);
        assertEquals(expResult, result);
        
        string = "AlphabetCharacters";
        expResult = false;
        result = Utility.isNumeric(string);
        assertEquals(expResult, result);
        
        string = "Alphabet Characters With Space";
        expResult = false;
        result = Utility.isNumeric(string);
        assertEquals(expResult, result);
        
        string = "M1x3d numb3rs and letters";
        expResult = false;
        result = Utility.isNumeric(string);
        assertEquals(expResult, result);
        
        string = "333 33";
        expResult = false;
        result = Utility.isNumeric(string);
        assertEquals(expResult, result);
        
        string = "333.33.33";
        expResult = false;
        result = Utility.isNumeric(string);
        assertEquals(expResult, result);
        
        string = "333.33";
        expResult = true;
        result = Utility.isNumeric(string);
        assertEquals(expResult, result);
        
        string = "333";
        expResult = true;
        result = Utility.isNumeric(string);
        assertEquals(expResult, result);
        
        string = "-333.33";
        expResult = true;
        result = Utility.isNumeric(string);
        assertEquals(expResult, result);
        
        string = "-333";
        expResult = true;
        result = Utility.isNumeric(string);
        assertEquals(expResult, result);
    }

    /**
     * Test of isPositiveInteger method, of class Utility.
     */
    @Test
    public void testIsPositiveInteger() {
        System.out.println("isPositiveInteger");
        String string = "";
        boolean expResult = false;
        boolean result = Utility.isPositiveInteger(string);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isValidDate method, of class Utility.
     */
    @Test
    public void testIsValidDate() {
        System.out.println("isValidDate");
        String dateString = "";
        boolean expResult = false;
        boolean result = Utility.isValidDate(dateString);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isValidSocialSecurityNumber method, of class Utility.
     */
    @Test
    public void testIsValidSocialSecurityNumber() {
        System.out.println("isValidSocialSecurityNumber");
        String ssnString = "";
        boolean expResult = false;
        boolean result = Utility.isValidSocialSecurityNumber(ssnString);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentTime method, of class Utility.
     */
    @Test
    public void testGetCurrentTime() {
        System.out.println("getCurrentTime");
        Timestamp expResult = new Timestamp(System.currentTimeMillis());
        Timestamp result = Utility.getCurrentTime();
        
        // Pass if the difference between the results is less than 100 ms
        assertTrue(result.getTime() - expResult.getTime() < 100);
    }

    /**
     * Test of deleteFile method, of class Utility.
     */
    @Test
    public void testDeleteFile() {
        System.out.println("deleteFile");
        File element = null;
        boolean expResult = false;
        boolean result = Utility.deleteFile(element);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
