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
public class EditViewControllerBaseTest {
    
    public EditViewControllerBaseTest() {
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
     * Test of executeSave method, of class EditViewControllerBase.
     */
    @Test
    public void testExecuteSave() {
        System.out.println("executeSave");
        EditViewControllerBase instance = new EditViewControllerBaseImpl();
        instance.executeSave();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of executeApply method, of class EditViewControllerBase.
     */
    @Test
    public void testExecuteApply() {
        System.out.println("executeApply");
        EditViewControllerBase instance = new EditViewControllerBaseImpl();
        instance.executeApply();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of executeCancel method, of class EditViewControllerBase.
     */
    @Test
    public void testExecuteCancel() {
        System.out.println("executeCancel");
        EditViewControllerBase instance = new EditViewControllerBaseImpl();
        instance.executeCancel();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of executeDelete method, of class EditViewControllerBase.
     */
    @Test
    public void testExecuteDelete() {
        System.out.println("executeDelete");
        EditViewControllerBase instance = new EditViewControllerBaseImpl();
        instance.executeDelete();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class EditViewControllerBaseImpl extends EditViewControllerBase {

        public void executeSave() {
        }

        public void executeApply() {
        }

        public void executeCancel() {
        }

        public void executeDelete() {
        }
    }
    
}
