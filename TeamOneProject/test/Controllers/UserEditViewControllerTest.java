/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Library.User;
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
public class UserEditViewControllerTest {
    
    public UserEditViewControllerTest() {
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
     * Test of load method, of class UserEditViewController.
     */
    @Test
    public void testLoad() {
        System.out.println("load");
        User model = null;
        DefaultListModel<User> listModel = null;
        UserEditViewController instance = new UserEditViewController();
        instance.load(model, listModel);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of executeSave method, of class UserEditViewController.
     */
    @Test
    public void testExecuteSave() {
        System.out.println("executeSave");
        UserEditViewController instance = new UserEditViewController();
        instance.executeSave();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of executeApply method, of class UserEditViewController.
     */
    @Test
    public void testExecuteApply() {
        System.out.println("executeApply");
        UserEditViewController instance = new UserEditViewController();
        instance.executeApply();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of executeCancel method, of class UserEditViewController.
     */
    @Test
    public void testExecuteCancel() {
        System.out.println("executeCancel");
        UserEditViewController instance = new UserEditViewController();
        instance.executeCancel();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of executeDelete method, of class UserEditViewController.
     */
    @Test
    public void testExecuteDelete() {
        System.out.println("executeDelete");
        UserEditViewController instance = new UserEditViewController();
        instance.executeDelete();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
