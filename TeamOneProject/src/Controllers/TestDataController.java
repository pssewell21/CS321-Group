/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DataAccess.JavaDB;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
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
        JavaDB.executeInsert("INSERT INTO APP.TESTDATA\nVALUES (" + rand.nextInt() + ", 'key!', 'value!')");
        
        JavaDB.executeUpdate("UPDATE APP.TESTDATA\nSET VALUE = 'UpdatedValue!!!'\nWHERE ID = 1500395088");
        
        JavaDB.executeDelete("DELETE FROM APP.TESTDATA WHERE ID = 1739863343");
        
        ResultSet resultSet = JavaDB.executeSelect("SELECT * FROM TESTDATA");
        
        try
        {
            displayResults(resultSet);
        }
        catch(Exception e)
        {
            System.out.println("No TestData results to display");
        }
    }
    
    private void displayResults(ResultSet resultSet) throws SQLException
    {
        ResultSetMetaData metaData = resultSet.getMetaData();
        
        for (int i = 1; i <= metaData.getColumnCount(); i++)
        {
            System.out.printf("%-10s\t", metaData.getColumnName(i));
        }
            
        System.out.println();
           
        while (resultSet.next())
        {
            for (int i = 1; i <= metaData.getColumnCount(); i++)
            {
                System.out.printf("%-10s\t", resultSet.getObject(i));
            }
                
            System.out.println();
        }
    }
}
