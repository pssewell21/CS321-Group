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

import Library.AccountPersonMap;
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
public class AccountPersonMapListViewControllerTest {
    
    public AccountPersonMapListViewControllerTest() {
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
     * Test of load method, of class AccountPersonMapListViewController.
     */
    @Test
    public void testLoad() throws Exception {
        System.out.println("load");
        AccountPersonMapListViewController instance = new AccountPersonMapListViewController();
        instance.load();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadAccountList method, of class AccountPersonMapListViewController.
     */
    @Test
    public void testLoadAccountList() {
        System.out.println("loadAccountList");
        Long personId = null;
        AccountPersonMapListViewController instance = new AccountPersonMapListViewController();
        instance.loadAccountList(personId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of initializeAccountList method, of class AccountPersonMapListViewController.
     */
    @Test
    public void testInitializeAccountList() {
        System.out.println("initializeAccountList");
        AccountPersonMapListViewController instance = new AccountPersonMapListViewController();
        instance.initializeAccountList();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of executeAdd method, of class AccountPersonMapListViewController.
     */
    @Test
    public void testExecuteAdd() {
        System.out.println("executeAdd");
        Long personId = null;
        AccountPersonMapListViewController instance = new AccountPersonMapListViewController();
        instance.executeAdd(personId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of executeEdit method, of class AccountPersonMapListViewController.
     */
    @Test
    public void testExecuteEdit() {
        System.out.println("executeEdit");
        AccountPersonMap item = null;
        Long personId = null;
        AccountPersonMapListViewController instance = new AccountPersonMapListViewController();
        instance.executeEdit(item, personId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
