/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    
    public LogOnViewControllerTest() {
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
    
}
