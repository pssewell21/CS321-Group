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
public final class DataAccessJavaDb {

    // <editor-fold defaultstate="collapsed" desc="Member Variables"> 
    
    private static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String JDBC_URL = "jdbc:derby://localhost:1527/atmdb";

    private static Connection _connection;
    private static Statement _statement;
    
    // </editor-fold> 
    
    // <editor-fold defaultstate="collapsed" desc="Constructors"> 

    private DataAccessJavaDb() {
    }
    
    // </editor-fold> 
    
    // <editor-fold defaultstate="collapsed" desc="Connection Management Methods"> 

    /**
     *
     */
    public static void openConnection() {
        try {
            Class.forName(DRIVER).newInstance();
            _connection = DriverManager.getConnection(JDBC_URL);
            _statement = _connection.createStatement();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
            ExceptionHandler.handleException(e);
        }
    }

    /**
     *
     */
    public static void closeConnection() {
        try {
            if (_statement != null) {
                _statement.close();
            }
            if (_connection != null) {
                _connection.close();
            }
        } catch (Exception e) {
            ExceptionHandler.handleException(e);
        }
    }
    
    // </editor-fold> 
    
    // <editor-fold defaultstate="collapsed" desc="SQL Execution Methods"> 

    /**
     *
     * @param command
     * @return
     */
    public static ResultSet executeSelect(String command) {
        ResultSet resultSet = null;

        try {
            if (_statement != null) {
                resultSet = _statement.executeQuery(command);
            } else {
                System.out.println("Select failed.  Make sure a connection to the database exists.");
            }
        } catch (Exception e) {
            ExceptionHandler.handleException(e);
        }

        return resultSet;
    }

    /**
     *
     * @param command
     * @return 
     */
    public static boolean executeInsert(String command) {
        boolean successful = true;
        
        try {
            if (_statement != null) {
                _statement.execute(command);
            } else {
                System.out.println("Insert failed.  Make sure a connection to the database exists.");
                successful = false;
            }
        } catch (Exception e) {
            ExceptionHandler.handleException(e);
            successful = false;
        }
        
        return successful;
    }

    /**
     *
     * @param command
     */
    public static void executeUpdate(String command) {
        try {
            _statement.executeUpdate(command);
        } catch (Exception e) {
            ExceptionHandler.handleException(e);
        }
    }

    /**
     *
     * @param command
     */
    public static void executeDelete(String command) {
        try {
            _statement.executeUpdate(command);
        } catch (Exception e) {
            ExceptionHandler.handleException(e);
        }
    }

    /**
     *
     * @param batchCommand
     */
    public static void execute(String batchCommand) {
        String[] commands = batchCommand.split(";\n");

        try {
            for (String command : commands) {
                _statement.addBatch(command);
            }
            
            _statement.executeBatch();
        } catch (Exception e) {
            ExceptionHandler.handleException(e);
        }
    }
    
    // </editor-fold> 
}
