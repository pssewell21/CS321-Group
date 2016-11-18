/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import java.sql.ResultSet;
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
public class DataAccessJavaDbTest {
    
    public DataAccessJavaDbTest() {
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
     * Test of openConnection method, of class DataAccessJavaDb.
     */
    @Test
    public void testOpenConnection() {
        System.out.println("openConnection");
        DataAccessJavaDb.openConnection();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of closeConnection method, of class DataAccessJavaDb.
     */
    @Test
    public void testCloseConnection() {
        System.out.println("closeConnection");
        DataAccessJavaDb.closeConnection();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of executeSelect method, of class DataAccessJavaDb.
     */
    @Test
    public void testExecuteSelect() {
        System.out.println("executeSelect");
        String command = "";
        ResultSet expResult = null;
        ResultSet result = DataAccessJavaDb.executeSelect(command);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of executeInsert method, of class DataAccessJavaDb.
     */
    @Test
    public void testExecuteInsert() {
        System.out.println("executeInsert");
        String command = "";
        boolean expResult = false;
        boolean result = DataAccessJavaDb.executeInsert(command);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of executeUpdate method, of class DataAccessJavaDb.
     */
    @Test
    public void testExecuteUpdate() {
        System.out.println("executeUpdate");
        String command = "";
        DataAccessJavaDb.executeUpdate(command);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of executeDelete method, of class DataAccessJavaDb.
     */
    @Test
    public void testExecuteDelete() {
        System.out.println("executeDelete");
        String command = "";
        DataAccessJavaDb.executeDelete(command);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of execute method, of class DataAccessJavaDb.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        String batchCommand = "";
        DataAccessJavaDb.execute(batchCommand);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
