/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetester;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.ResultSetMetaData;

/**
 *
 * @author Owner
 */
public class DatabaseTester {

    public static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    public static final String JDBC_URL = "jdbc:derby://localhost:1527/database";
    
    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        Class.forName(DRIVER).newInstance();
        Connection connection = DriverManager.getConnection(JDBC_URL);
        connection.createStatement().execute("INSERT INTO TESTDATA VALUES (4, 'key4', 'value4')");
        System.out.println("test data inserted");
        
        ResultSet data = connection.createStatement().executeQuery("SELECT * FROM TESTDATA");
        ResultSetMetaData metaData = data.getMetaData();
        for (int i = 1; i <= metaData.getColumnCount(); i++)
        {
            System.out.printf("%-10s\t", metaData.getColumnName(i));
        }
        
        System.out.println();
        
        while (data.next())
        {
            for (int i = 1; i <= metaData.getColumnCount(); i++)
            {
                System.out.printf("%-10s\t", data.getObject(i));
            }
            
            System.out.println();
        }
    }
    
}
