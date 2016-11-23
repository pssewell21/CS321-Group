/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Library.Account;
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
public class AccountListViewControllerTest {
    
    public AccountListViewControllerTest() {
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
     * Test of load method, of class AccountListViewController.
     */
    @Test
    public void testLoad() throws Exception {
        System.out.println("load");
        AccountListViewController instance = new AccountListViewController();
        instance.load();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of executeAdd method, of class AccountListViewController.
     */
    @Test
    public void testExecuteAdd() {
        System.out.println("executeAdd");
        AccountListViewController instance = new AccountListViewController();
        instance.executeAdd();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of executeEdit method, of class AccountListViewController.
     */
    @Test
    public void testExecuteEdit() {
        System.out.println("executeEdit");
        Account item = null;
        AccountListViewController instance = new AccountListViewController();
        instance.executeEdit(item);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
