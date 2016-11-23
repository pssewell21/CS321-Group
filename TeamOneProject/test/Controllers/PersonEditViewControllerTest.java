/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Library.Person;
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
public class PersonEditViewControllerTest {
    
    public PersonEditViewControllerTest() {
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
     * Test of load method, of class PersonEditViewController.
     */
    @Test
    public void testLoad() {
        System.out.println("load");
        Person model = null;
        DefaultListModel<Person> listModel = null;
        PersonEditViewController instance = new PersonEditViewController();
        instance.load(model, listModel);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of executeSave method, of class PersonEditViewController.
     */
    @Test
    public void testExecuteSave() {
        System.out.println("executeSave");
        PersonEditViewController instance = new PersonEditViewController();
        instance.executeSave();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of executeApply method, of class PersonEditViewController.
     */
    @Test
    public void testExecuteApply() {
        System.out.println("executeApply");
        PersonEditViewController instance = new PersonEditViewController();
        instance.executeApply();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of executeCancel method, of class PersonEditViewController.
     */
    @Test
    public void testExecuteCancel() {
        System.out.println("executeCancel");
        PersonEditViewController instance = new PersonEditViewController();
        instance.executeCancel();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of executeDelete method, of class PersonEditViewController.
     */
    @Test
    public void testExecuteDelete() {
        System.out.println("executeDelete");
        PersonEditViewController instance = new PersonEditViewController();
        instance.executeDelete();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
