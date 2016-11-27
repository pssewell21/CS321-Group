/*
 * Copyright 2016 AUTHORS. Patrick S Sewell, Paul M Dyer, Taehyeok Lee, 
 * Benjamin C Ferguson, Hyunki J KIm Permission is granted to copy, distribute 
 * and/or modify this document under the terms of the GNU Free Documentation 
 * License, Version 1.3, (3 November 2008) or any later version published by 
 * the Free Software Foundation; with no Invariant Sections, with no 
 * Front-Cover Texts, and with no Back-Cover Texts. A copy of the license 
 * can be found at http://www.gnu.org/copyleft/fdl.html
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
    
    /**
     *
     */
    public DataAccessJavaDbTest() {
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
     * Test of executeBatch method, of class DataAccessJavaDb.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        String batchCommand = "";
        DataAccessJavaDb.executeBatch(batchCommand);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
