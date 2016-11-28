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
        String string = null;
        boolean expResult = false;
        boolean result = Utility.isPositiveInteger(string);
        assertEquals(expResult, result);
        
        string = "";
        expResult = false;
        result = Utility.isPositiveInteger(string);
        assertEquals(expResult, result);
        
        string = "AlphabetCharacters";
        expResult = false;
        result = Utility.isPositiveInteger(string);
        assertEquals(expResult, result);
        
        string = "Alphabet Characters With Space";
        expResult = false;
        result = Utility.isPositiveInteger(string);
        assertEquals(expResult, result);
        
        string = "M1x3d numb3rs and letters";
        expResult = false;
        result = Utility.isPositiveInteger(string);
        assertEquals(expResult, result);
        
        string = "333 33";
        expResult = false;
        result = Utility.isPositiveInteger(string);
        assertEquals(expResult, result);
        
        string = "333.33.33";
        expResult = false;
        result = Utility.isPositiveInteger(string);
        assertEquals(expResult, result);
        
        string = "333.33";
        expResult = false;
        result = Utility.isPositiveInteger(string);
        assertEquals(expResult, result);
        
        string = "333";
        expResult = true;
        result = Utility.isPositiveInteger(string);
        assertEquals(expResult, result);
        
        string = "-333.33";
        expResult = false;
        result = Utility.isPositiveInteger(string);
        assertEquals(expResult, result);
        
        string = "-333";
        expResult = false;
        result = Utility.isPositiveInteger(string);
        assertEquals(expResult, result);
    }

    /**
     * Test of isValidDate method, of class Utility.
     */
    @Test
    public void testIsValidDate() {
        System.out.println("isValidDate");
        String dateString = null;
        boolean expResult = false;
        boolean result = Utility.isValidDate(dateString);
        assertEquals(expResult, result);
        
        dateString = "";
        expResult = false;
        result = Utility.isValidDate(dateString);
        assertEquals(expResult, result);
        
        dateString = "AlphabetCharacters";
        expResult = false;
        result = Utility.isValidDate(dateString);
        assertEquals(expResult, result);
        
        dateString = "333.33";
        expResult = false;
        result = Utility.isValidDate(dateString);
        assertEquals(expResult, result);
        
        dateString = "333";
        expResult = false;
        result = Utility.isValidDate(dateString);
        assertEquals(expResult, result);
        
        dateString = "01/01/2000";
        expResult = false;
        result = Utility.isValidDate(dateString);
        assertEquals(expResult, result);
        
        dateString = "1/1/2000";
        expResult = false;
        result = Utility.isValidDate(dateString);
        assertEquals(expResult, result);
        
        dateString = "2000-1-1";
        expResult = false;
        result = Utility.isValidDate(dateString);
        assertEquals(expResult, result);
        
        dateString = "2000-01-31";
        expResult = true;
        result = Utility.isValidDate(dateString);
        assertEquals(expResult, result);
        
        dateString = "2000-01-32";
        expResult = false;
        result = Utility.isValidDate(dateString);
        assertEquals(expResult, result);
        
        //Test non-leap-year
        dateString = "2015-02-29";
        expResult = false;
        result = Utility.isValidDate(dateString);
        assertEquals(expResult, result);
        
        //Test leap-year
        dateString = "2016-02-29";
        expResult = true;
        result = Utility.isValidDate(dateString);
        assertEquals(expResult, result);
        
        dateString = "2000-03-30";
        expResult = true;
        result = Utility.isValidDate(dateString);
        assertEquals(expResult, result);
        
        dateString = "2000-03-31";
        expResult = true;
        result = Utility.isValidDate(dateString);
        assertEquals(expResult, result);
        
        dateString = "2000-04-30";
        expResult = true;
        result = Utility.isValidDate(dateString);
        assertEquals(expResult, result);
        
        dateString = "2000-04-31";
        expResult = false;
        result = Utility.isValidDate(dateString);
        assertEquals(expResult, result);
    }

    /**
     * Test of isValidSocialSecurityNumber method, of class Utility.
     */
    @Test
    public void testIsValidSocialSecurityNumber() {
        System.out.println("isValidSocialSecurityNumber");
        String ssnString = null;
        boolean expResult = false;
        boolean result = Utility.isValidSocialSecurityNumber(ssnString);
        assertEquals(expResult, result);
        
        ssnString = "";
        expResult = false;
        result = Utility.isValidSocialSecurityNumber(ssnString);
        assertEquals(expResult, result);
        
        ssnString = "aaaaaaaaa";
        expResult = false;
        result = Utility.isValidSocialSecurityNumber(ssnString);
        assertEquals(expResult, result);
        
        ssnString = "aaa-aa-aaaa";
        expResult = false;
        result = Utility.isValidSocialSecurityNumber(ssnString);
        assertEquals(expResult, result);
        
        ssnString = "111-11-111a";
        expResult = false;
        result = Utility.isValidSocialSecurityNumber(ssnString);
        assertEquals(expResult, result);
        
        ssnString = "111111111";
        expResult = false;
        result = Utility.isValidSocialSecurityNumber(ssnString);
        assertEquals(expResult, result);
        
        ssnString = "111-11--111";
        expResult = false;
        result = Utility.isValidSocialSecurityNumber(ssnString);
        assertEquals(expResult, result);
        
        ssnString = "111-11-1111";
        expResult = true;
        result = Utility.isValidSocialSecurityNumber(ssnString);
        assertEquals(expResult, result);
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
        
        // Create file path object
        File infile = new File(System.getProperty("user.home") + File.separator
                    + "JavaProjProp" + File.separator + "Test");
        
        // Test deletion when path does not exist
        element = infile;
        expResult = false;
        result = Utility.deleteFile(element);
        assertEquals(expResult, result);
        
        // Make the file path
        infile.mkdirs();
        
        // Test deletion when path does exist
        element = infile;
        expResult = true;
        result = Utility.deleteFile(element);
        assertEquals(expResult, result);
        
        // Create subdirectory file path object
        File subInfile = new File(System.getProperty("user.home") + File.separator
                    + "JavaProjProp" + File.separator + "Test" + File.separator + "Sub");
        subInfile.mkdirs();
        
        // Test deletion when path does exist and has subdirectories
        element = infile;
        expResult = true;
        result = Utility.deleteFile(element);
        assertEquals(expResult, result);
    }
}
