/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Library.Constants.DalFields;
import Library.TestData.TestData;
import Library.TestData.TestDataFactory;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 *
 * @author pssew
 */
public class TestDataController 
{        
    public void Run() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException 
    {
        Random rand = new Random();
        //DataAccessJavaDb.executeInsert("INSERT INTO APP.TESTDATA\nVALUES (" + rand.nextInt() + ", 'key!', 'value!')");
        
        //DataAccessJavaDb.executeUpdate("UPDATE APP.TESTDATA\nSET VALUE = 'UpdatedValue!!!'\nWHERE ID = 1500395088");
        
        //DataAccessJavaDb.executeDelete("DELETE FROM APP.TESTDATA WHERE ID = 1739863343");
        
        TestDataFactory factory = new TestDataFactory(); 
        
        HashMap criteria = new HashMap<>();
        List testDataList = factory.executeSelect(criteria);
        displayResults(testDataList);
        
        criteria = new HashMap<>();
        criteria.put(DalFields.LOOKUPKEY, "testKeyNew");
        criteria.put(DalFields.VALUE, "valNew");
        
        factory.executeInsert(criteria);
        
        criteria = new HashMap<>();
        testDataList = factory.executeSelect(criteria);
        displayResults(testDataList);
        
        criteria = new HashMap<>();
        criteria.put(DalFields.ID, "7530223542991451589");
        criteria.put(DalFields.LOOKUPKEY, "testKeyNewFromUpdate!");
        criteria.put(DalFields.VALUE, "valNewFromUpdate!");
        
        factory.executeUpdate(criteria);
        
        criteria = new HashMap<>();
        testDataList = factory.executeSelect(criteria);
        displayResults(testDataList);
        
        criteria = new HashMap<>();
        criteria.put(DalFields.ID, "4");
        
        factory.executeDelete(criteria);
        
        criteria = new HashMap<>();
        testDataList = factory.executeSelect(criteria);
        displayResults(testDataList);
        
    }
    
    private void displayResults(List<TestData> testDataList)
    {
        if (!testDataList.isEmpty())
        {
            for (TestData testData : testDataList)
            {
                System.out.println(testData.toString());
            }
        }
        else
        {
            System.out.println("No results returned");
        }
    }
}
