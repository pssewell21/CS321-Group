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

import Library.User;
import java.math.BigDecimal;
import java.sql.Timestamp;
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
public class AtmViewControllerTest {
    
    public AtmViewControllerTest() {
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
     * Test of load method, of class AtmViewController.
     */
    @Test
    public void testLoad() {
        System.out.println("load");
        User user = null;
        AtmViewController instance = new AtmViewController();
        instance.load(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of executeQuit method, of class AtmViewController.
     */
    @Test
    public void testExecuteQuit() {
        System.out.println("executeQuit");
        AtmViewController instance = new AtmViewController();
        instance.executeQuit();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of executeCheckBalance method, of class AtmViewController.
     */
    @Test
    public void testExecuteCheckBalance() {
        System.out.println("executeCheckBalance");
        AtmViewController instance = new AtmViewController();
        BigDecimal expResult = null;
        BigDecimal result = instance.executeCheckBalance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of executeDeposit method, of class AtmViewController.
     */
    @Test
    public void testExecuteDeposit() {
        System.out.println("executeDeposit");
        BigDecimal amount = null;
        AtmViewController instance = new AtmViewController();
        instance.executeDeposit(amount);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of executeWithdrawal method, of class AtmViewController.
     */
    @Test
    public void testExecuteWithdrawal() {
        System.out.println("executeWithdrawal");
        BigDecimal amount = null;
        AtmViewController instance = new AtmViewController();
        instance.executeWithdrawal(amount);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of executeGetTransactionHistory method, of class AtmViewController.
     */
    @Test
    public void testExecuteGetTransactionHistory() {
        System.out.println("executeGetTransactionHistory");
        Timestamp startTime = null;
        Timestamp endTime = null;
        AtmViewController instance = new AtmViewController();
        instance.executeGetTransactionHistory(startTime, endTime);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
