/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Common.ExceptionHandler;
import Common.Utility;
import java.io.File;
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
    //private static final String JDBC_URL = "jdbc:derby://localhost:1527/atmdb";

    private static Connection _connection;
    private static Statement _statement;
    private static File infile;

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
        infile = new File(System.getProperty("user.home") + File.separator
                + "JavaProjProp" + File.separator + "databases" + File.separator + "atmdb");

        boolean dbExists = infile.exists();

        System.out.println("the file " + infile.toString() + " is " + dbExists);

        if (dbExists) {
            try {
                Class.forName(DRIVER).newInstance();
                String connString = "jdbc:derby:" + infile.toString();
                System.out.println("the connection string where dbExists is true is " + connString);
                _connection = DriverManager.getConnection(connString);
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
                ExceptionHandler.handleException(e);
            }
        } else {
            // now do the creation work if the db directory does not exist. 
            // the assumption is that if the directory does not exist the db cannot
            // exist. The assumption will always be true when that directory is the
            // well-known location of the db.
            // get the abstract representation of the path to the directory for the databases
            infile = new File(System.getProperty("user.home") + File.separator
                    + "JavaProjProp" + File.separator + "databases");
            System.out.println("the file directory to be made when dbExists is false is " + infile.toString());
            // save the value of the success of making the directories
            boolean dirMade = infile.mkdirs();
            System.out.println("the directory is made? value is " + dirMade);
            // if the directories down to the 'databass' directory have been made
            // get the driver and create the database through the connection string
            if (dirMade) {
                try {
                    //This driver will load automatically when your application asks for
                    // its first connection.
                    Class.forName(DRIVER).newInstance();
                    //Get the connection to the database and create the specified database
                    String connString = "jdbc:derby:" + infile.toString() + "/atmdb;create =true";
                    System.out.println("the connection string where dbExists is false and dirMade is true is " + connString);
                    _connection = DriverManager.getConnection(connString);
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
                    ExceptionHandler.handleException(e);
                }
            }
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
    
    public static void deleteDatabase() {
        infile = new File(System.getProperty("user.home") + File.separator
                + "JavaProjProp");
        
        Utility.deleteFile(infile);
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
            _statement = _connection.createStatement();
        
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
            _statement = _connection.createStatement();
            
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
            _statement = _connection.createStatement();
            
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
            _statement = _connection.createStatement();
            
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
            _statement = _connection.createStatement();
            
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
