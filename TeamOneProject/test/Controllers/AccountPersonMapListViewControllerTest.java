/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
     * Test of executeAdd method, of class AccountPersonMapListViewController.
     */
    @Test
    public void testExecuteAdd() {
        System.out.println("executeAdd");
        AccountPersonMapListViewController instance = new AccountPersonMapListViewController();
        instance.executeAdd();
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
        AccountPersonMapListViewController instance = new AccountPersonMapListViewController();
        instance.executeEdit(item);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
