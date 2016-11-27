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
public class AccountPersonMapEditViewControllerTest {
    
    /**
     *
     */
    public AccountPersonMapEditViewControllerTest() {
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
     * Test of load method, of class AccountPersonMapEditViewController.
     */
    @Test
    public void testLoad() {
        System.out.println("load");
        AccountPersonMap model = null;
        DefaultListModel<AccountPersonMap> listModel = null;
        Long personId = null;
        AccountPersonMapEditViewController instance = new AccountPersonMapEditViewController();
        instance.load(model, listModel, personId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of executeSave method, of class AccountPersonMapEditViewController.
     */
    @Test
    public void testExecuteSave() {
        System.out.println("executeSave");
        AccountPersonMapEditViewController instance = new AccountPersonMapEditViewController();
        instance.executeSave();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of executeApply method, of class AccountPersonMapEditViewController.
     */
    @Test
    public void testExecuteApply() {
        System.out.println("executeApply");
        AccountPersonMapEditViewController instance = new AccountPersonMapEditViewController();
        instance.executeApply();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of executeCancel method, of class AccountPersonMapEditViewController.
     */
    @Test
    public void testExecuteCancel() {
        System.out.println("executeCancel");
        AccountPersonMapEditViewController instance = new AccountPersonMapEditViewController();
        instance.executeCancel();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of executeDelete method, of class AccountPersonMapEditViewController.
     */
    @Test
    public void testExecuteDelete() {
        System.out.println("executeDelete");
        AccountPersonMapEditViewController instance = new AccountPersonMapEditViewController();
        instance.executeDelete();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
