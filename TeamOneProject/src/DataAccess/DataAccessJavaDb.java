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
 *
 * @author Patrick Sewell
 */
public final class DataAccessJavaDb {

    // <editor-fold defaultstate="collapsed" desc="Member Variables"> 
    private static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    //private static final String JDBC_URL = "jdbc:derby://localhost:1527/atmdb";

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
     *
     */
    public static void openConnection() {
        infile = new File(System.getProperty("user.home") + File.separator
                + "JavaProjProp" + File.separator + "databases" + File.separator + "atmdb");

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
                    + "JavaProjProp" + File.separator + "databases");
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
     *
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
     *
     */
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
     *
     * @param command
     * @return
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
     *
     * @param command
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
     *
     * @param command
     * @return 
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
     *
     * @param batchCommand
     */
    public static void execute(String batchCommand) {
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
