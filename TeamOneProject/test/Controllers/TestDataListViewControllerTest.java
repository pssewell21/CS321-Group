/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Library.TestData;
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
public class TestDataListViewControllerTest {
    
    public TestDataListViewControllerTest() {
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
     * Test of load method, of class TestDataListViewController.
     */
    @Test
    public void testLoad() throws Exception {
        System.out.println("load");
        TestDataListViewController instance = new TestDataListViewController();
        instance.load();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of executeAdd method, of class TestDataListViewController.
     */
    @Test
    public void testExecuteAdd() {
        System.out.println("executeAdd");
        TestDataListViewController instance = new TestDataListViewController();
        instance.executeAdd();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of executeEdit method, of class TestDataListViewController.
     */
    @Test
    public void testExecuteEdit() {
        System.out.println("executeEdit");
        TestData item = null;
        TestDataListViewController instance = new TestDataListViewController();
        instance.executeEdit(item);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
