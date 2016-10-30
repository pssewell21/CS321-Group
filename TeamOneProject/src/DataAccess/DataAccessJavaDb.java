/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import UI.ExceptionHandler;
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

    private static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String JDBC_URL = "jdbc:derby://localhost:1527/database";

    private static Connection _connection;
    private static Statement _statement;

    private DataAccessJavaDb() {
    }

    public static void openConnection() {
        try {
            Class.forName(DRIVER).newInstance();
            _connection = DriverManager.getConnection(JDBC_URL);
            _statement = _connection.createStatement();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
            ExceptionHandler.handleException(e);
        }
    }

    public static void closeConnection() {
        try {
            _statement.close();
            _connection.close();
        } catch (Exception e) {
            ExceptionHandler.handleException(e);
        }
    }

    public static ResultSet executeSelect(String command) {
        ResultSet resultSet = null;

        try {
            resultSet = _statement.executeQuery(command);
        } catch (Exception e) {
            ExceptionHandler.handleException(e);
        }

        return resultSet;
    }

    public static void executeInsert(String command) {
        try {
            _statement.execute(command);
        } catch (Exception e) {
            ExceptionHandler.handleException(e);
        }
    }

    public static void executeUpdate(String command) {
        try {
            _statement.executeUpdate(command);
        } catch (Exception e) {
            ExceptionHandler.handleException(e);
        }
    }

    public static void executeDelete(String command) {
        try {
            _statement.executeUpdate(command);
        } catch (Exception e) {
            ExceptionHandler.handleException(e);
        }
    }
}
