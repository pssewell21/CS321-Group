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

import Common.ExceptionHandler;
import Common.Utility;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Handles opening and closing connections, and performing operations on the
 * embedded JavaDB database.
 *
 * @author Patrick Sewell
 */
public final class DataAccessJavaDb {

    // <editor-fold defaultstate="collapsed" desc="Member Variables"> 
    private static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";

    private static Connection connection;
    private static Statement statement;
    private static File infile;

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Constructors"> 
    private DataAccessJavaDb() {
    }

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Connection Management Methods"> 
    /**
     * Opens the connection to an existing database or creates one.
     *
     * Adapted for use from example code by Dr. Dan Rochowiak found in class
     * materials.
     */
    public static void openConnection() {
        infile = new File(System.getProperty("user.home") + File.separator
                + "Java Projects" + File.separator + "databases" + File.separator + "atmdb");

        boolean dbExists = infile.exists();

        if (dbExists) {
            try {
                Class.forName(DRIVER).newInstance();
                String connString = "jdbc:derby:" + infile.toString();
                connection = DriverManager.getConnection(connString);
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
                ExceptionHandler.handleException(e);
            }
        } else {
            infile = new File(System.getProperty("user.home") + File.separator
                    + "Java Projects" + File.separator + "databases");
            boolean dirMade = infile.mkdirs();
            if (dirMade) {
                try {
                    Class.forName(DRIVER).newInstance();
                    String connString = "jdbc:derby:" + infile.toString() + "/atmdb;create =true";
                    connection = DriverManager.getConnection(connString);
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
                    ExceptionHandler.handleException(e);
                }
            }
        }
    }

    /**
     * Closes the connection to a database.
     */
    public static void closeConnection() {
        try {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            ExceptionHandler.handleException(e);
        }
    }

    /**
     * Deletes the database files stored in a well known location.
     */
    public static void deleteDatabase() {
        infile = new File(System.getProperty("user.home") + File.separator
                + "Java Projects");

        Utility.deleteFile(infile);
    }

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="SQL Execution Methods"> 
    /**
     * Executes SELECT SQL commands on the database.
     *
     * @param command The SQL command to be executed
     * @return The ResultSet returned by the SQL command
     */
    public static ResultSet executeSelect(String command) {
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();

            if (statement != null) {
                resultSet = statement.executeQuery(command);
            } else {
                System.out.println("Select failed.  Make sure a connection to the database exists.");
            }
        } catch (Exception e) {
            ExceptionHandler.handleException(e);
        }

        return resultSet;
    }

    /**
     * Executes INSERT SQL commands on the database.
     *
     * @param command The SQL command to be executed
     * @return A value indicating if the operation was successful
     */
    public static boolean executeInsert(String command) {
        boolean successful = true;

        try {
            statement = connection.createStatement();

            if (statement != null) {
                statement.execute(command);
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
     * Executes UPDATE SQL commands on the database.
     *
     * @param command The SQL command to be executed
     */
    public static void executeUpdate(String command) {
        try {
            statement = connection.createStatement();

            statement.executeUpdate(command);
        } catch (Exception e) {
            ExceptionHandler.handleException(e);
        }
    }

    /**
     * Executes DELETE SQL commands on the database.
     *
     * @param command The SQL command to be executed
     * @return A value indicating if the operation was successful
     */
    public static boolean executeDelete(String command) {
        try {
            statement = connection.createStatement();

            statement.executeUpdate(command);
        } catch (Exception e) {
            ExceptionHandler.handleException(e);
            return false;
        }

        return true;
    }

    /**
     * Executes SQL batch commands on the database.
     *
     * @param batchCommand The SQL command to be executed
     */
    public static void executeBatch(String batchCommand) {
        String[] commands = batchCommand.split(";\n");

        try {
            statement = connection.createStatement();

            for (String command : commands) {
                statement.addBatch(command);
            }

            statement.executeBatch();
        } catch (Exception e) {
            ExceptionHandler.handleException(e);
        }
    }

    // </editor-fold> 
}
