/*
 * Copyright 2016 AUTHORS. Patrick S Sewell, Paul M Dyer, Taehyeok Lee, 
 * Benjamin C Ferguson, Hyunki J KIm Permission is granted to copy, distribute 
 * and/or modify this document under the terms of the GNU Free Documentation 
 * License, Version 1.3, (3 November 2008) or any later version published by 
 * the Free Software Foundation; with no Invariant Sections, with no 
 * Front-Cover Texts, and with no Back-Cover Texts. A copy of the license 
 * can be found at http://www.gnu.org/copyleft/fdl.html
 */
package Controllers;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author afro2
 */
public class LogOnViewControllerTest {
    
    /**
     *
     */
    public LogOnViewControllerTest() {
    }
    
    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
    }
    
    /**
     *
     */
    @AfterClass
    public static void tearDownClass() {
    }
    
    /**
     *
     */
    @Before
    public void setUp() {
    }
    
    /**
     *
     */
    @After
    public void tearDown() {
    }

    /**
     * Test of load method, of class LogOnViewController.
     */
    @Test
    public void testLoad() {
        System.out.println("load");
        LogOnViewController instance = new LogOnViewController();
        instance.load();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of executeLogOn method, of class LogOnViewController.
     */
    @Test
    public void testExecuteLogOn() {
        System.out.println("executeLogOn");
        String userName = "";
        String password = "";
        LogOnViewController instance = new LogOnViewController();
        boolean expResult = false;
        boolean result = instance.executeLogOn(userName, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of executeProvisionDatabase method, of class LogOnViewController.
     */
    @Test
    public void testExecuteProvisionDatabase() {
        System.out.println("executeProvisionDatabase");
        LogOnViewController instance = new LogOnViewController();
        instance.executeProvisionDatabase();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of executeDeleteDatabase method, of class LogOnViewController.
     */
    @Test
    public void testExecuteDeleteDatabase() {
        System.out.println("executeDeleteDatabase");
        LogOnViewController instance = new LogOnViewController();
        instance.executeDeleteDatabase();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
