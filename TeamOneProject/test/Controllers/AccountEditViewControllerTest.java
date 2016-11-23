/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Library.Account;
import javax.swing.DefaultListModel;
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
public class AccountEditViewControllerTest {
    
    public AccountEditViewControllerTest() {
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
     * Test of load method, of class AccountEditViewController.
     */
    @Test
    public void testLoad() {
        System.out.println("load");
        Account model = null;
        DefaultListModel<Account> listModel = null;
        AccountEditViewController instance = new AccountEditViewController();
        instance.load(model, listModel);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of executeSave method, of class AccountEditViewController.
     */
    @Test
    public void testExecuteSave() {
        System.out.println("executeSave");
        AccountEditViewController instance = new AccountEditViewController();
        instance.executeSave();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of executeApply method, of class AccountEditViewController.
     */
    @Test
    public void testExecuteApply() {
        System.out.println("executeApply");
        AccountEditViewController instance = new AccountEditViewController();
        instance.executeApply();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of executeCancel method, of class AccountEditViewController.
     */
    @Test
    public void testExecuteCancel() {
        System.out.println("executeCancel");
        AccountEditViewController instance = new AccountEditViewController();
        instance.executeCancel();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of executeDelete method, of class AccountEditViewController.
     */
    @Test
    public void testExecuteDelete() {
        System.out.println("executeDelete");
        AccountEditViewController instance = new AccountEditViewController();
        instance.executeDelete();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
