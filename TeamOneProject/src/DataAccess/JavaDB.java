/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Common.ExceptionHandler;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author pssew
 */
public final class JavaDB 
{
    private static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String JDBC_URL = "jdbc:derby://localhost:1527/database";
    
    private static Connection _connection;
    private static Statement _statement;
    
    private JavaDB()
    {        
    }
    
    public static ResultSet executeSelect(String command)
    {        
        ResultSet resultSet = null;
        
        try
        {
            resultSet = _statement.executeQuery(command);
        }
        catch(Exception e)
        {
            ExceptionHandler.HandleException(e);
        }
                
        return resultSet;
    }
    
    public static void openConnection()
    {
        try
        {
            Class.forName(DRIVER).newInstance();
            _connection = DriverManager.getConnection(JDBC_URL);
            _statement = _connection.createStatement();
        }
        catch(ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e)
        {
            ExceptionHandler.HandleException(e);
        }
    }
    
    public static void closeConnection()
    {
        try
        {
            _statement.close();
            _connection.close();
        }
        catch(Exception e)
        {
            ExceptionHandler.HandleException(e);
        }
    }
}
