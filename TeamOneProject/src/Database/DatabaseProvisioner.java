/*
 * Copyright 2016 AUTHORS. Patrick S Sewell, Paul M Dyer, Taehyeok Lee, 
 * Benjamin C Ferguson, Hyunki J KIm Permission is granted to copy, distribute 
 * and/or modify this document under the terms of the GNU Free Documentation 
 * License, Version 1.3, (3 November 2008) or any later version published by 
 * the Free Software Foundation; with no Invariant Sections, with no 
 * Front-Cover Texts, and with no Back-Cover Texts. A copy of the license 
 * can be found at http://www.gnu.org/copyleft/fdl.html
 */
package Database;

import DataAccess.DataAccessJavaDb;
import Common.ExceptionHandler;
import java.sql.SQLException;

/**
 * Used to create and delete the database for the application.
 *
 * @author Patrick Sewell
 */
public final class DatabaseProvisioner {

    // <editor-fold defaultstate="collapsed" desc="SQL Scripts"> 
    private static final String DROP_TABLES_SCRIPT = "DROP TABLE APP.ACCOUNT_PERSON_MAP;\n"
            + "DROP TABLE APP.ACCOUNT_TRANSACTION;\n"
            + "DROP TABLE APP.ACCOUNT;\n"
            + "DROP TABLE APP.ATM_USER;\n"
            + "DROP TABLE APP.PERSON;\n"
            + "DROP TABLE APP.TEST_DATA";

    private static final String ADD_PERSON_TABLE_SCRIPT = "CREATE TABLE PERSON\n"
            + "(\n"
            + "    ID                      BIGINT          NOT NULL,\n"
            + "    NAME                    VARCHAR(100)    NOT NULL,\n"
            + "    DATE_OF_BIRTH           DATE            NOT NULL,\n"
            + "    ADDRESS                 VARCHAR(200)    NOT NULL,\n"
            + "    PHONE_NUMBER            VARCHAR(20),\n"
            + "    SOCIAL_SECURITY_NUMBER  VARCHAR(50)     NOT NULL,\n"
            + "    CONSTRAINT PERSON_PK PRIMARY KEY (ID),\n"
            + "    CONSTRAINT SOCIAL_SECURITY_NUMBER_UC UNIQUE (SOCIAL_SECURITY_NUMBER)\n"
            + ")";

    private static final String ADD_ATM_USER_TABLE_SCRIPT = "CREATE TABLE ATM_USER\n"
            + "(\n"
            + "    ID                      BIGINT          NOT NULL,\n"
            + "    PERSON_ID               BIGINT          NOT NULL,\n"
            + "    USER_NAME               VARCHAR(100)    NOT NULL,\n"
            + "    PASSWORD                VARCHAR(100)    NOT NULL,\n"
            + "    SECURITY_QUESTION_1     VARCHAR(200)    NOT NULL,\n"
            + "    SECURITY_ANSWER_1       VARCHAR(100)    NOT NULL,\n"
            + "    SECURITY_QUESTION_2     VARCHAR(200)    NOT NULL,\n"
            + "    SECURITY_ANSWER_2       VARCHAR(100)    NOT NULL,\n"
            + "    IS_ADMINISTRATOR        BOOLEAN         NOT NULL,\n"
            + "    IS_ACCOUNT_LOCKED       BOOLEAN         NOT NULL,\n"
            + "    SELECTED_THEME          VARCHAR(25)     NOT NULL,\n"
            + "    CONSTRAINT ATM_USER_PK PRIMARY KEY (ID),\n"
            + "    CONSTRAINT ATM_USER_PERSON_ID_FK FOREIGN KEY (PERSON_ID) REFERENCES PERSON (ID),\n"
            + "    CONSTRAINT ATM_USER_PERSON_ID_UC UNIQUE (PERSON_ID),\n"
            + "    CONSTRAINT ATM_USER_USER_NAME_UC UNIQUE (USER_NAME)\n"
            + ")";

    private static final String ADD_ACCOUNT_TABLE_SCRIPT = "CREATE TABLE ACCOUNT\n"
            + "(\n"
            + "    ID                      BIGINT          NOT NULL,\n"
            + "    ACCOUNT_NUMBER          BIGINT          NOT NULL,\n"
            + "    ACCOUNT_TYPE            VARCHAR(100)    NOT NULL,\n"
            + "    DESCRIPTION             VARCHAR(300),\n"
            + "    BALANCE                 NUMERIC(14,2)   NOT NULL,\n"
            + "    INTEREST_RATE           NUMERIC(4,2),\n"
            + "    CONSTRAINT ACCOUNT_PK PRIMARY KEY (ID),\n"
            + "    CONSTRAINT ACCOUNT_ACCOUNT_NUMBER_UC UNIQUE (ACCOUNT_NUMBER)\n"
            + ")";

    private static final String ADD_ACCOUNT_TRANSACTION_TABLE_SCRIPT = "CREATE TABLE ACCOUNT_TRANSACTION\n"
            + "(\n"
            + "    ID                      BIGINT          NOT NULL,\n"
            + "    ACCOUNT_ID              BIGINT          NOT NULL,\n"
            + "    PERSON_ID               BIGINT          NOT NULL,\n"
            + "    TRANSACTION_TIMESTAMP   TIMESTAMP       NOT NULL,\n"
            + "    AMOUNT                  NUMERIC(12,2)   NOT NULL,\n"
            + "    CONSTRAINT ACCOUNT_TRANSACTION_PK PRIMARY KEY (ID),\n"
            + "    CONSTRAINT ACCOUNT_TRANSACTION_ACCOUNT_ID_FK FOREIGN KEY (ACCOUNT_ID) REFERENCES ACCOUNT (ID),\n"
            + "    CONSTRAINT ACCOUNT_TRANSACTION_PERSON_ID_FK FOREIGN KEY (PERSON_ID) REFERENCES PERSON (ID)\n"
            + ")";

    private static final String ADD_ACCOUNT_PERSON_MAP_TABLE_SCRIPT = "CREATE TABLE ACCOUNT_PERSON_MAP\n"
            + "(\n"
            + "    ID                      BIGINT          NOT NULL,\n"
            + "    ACCOUNT_ID              BIGINT          NOT NULL,\n"
            + "    PERSON_ID               BIGINT          NOT NULL,\n"
            + "    CONSTRAINT ACCOUNT_PERSON_MAP_PK PRIMARY KEY (ID),\n"
            + "    CONSTRAINT ACCOUNT_PERSON_MAP_ACCOUNT_ID_FK FOREIGN KEY (ACCOUNT_ID) REFERENCES ACCOUNT (ID),\n"
            + "    CONSTRAINT ACCOUNT_PERSON_MAP_PERSON_ID_FK FOREIGN KEY (PERSON_ID) REFERENCES PERSON (ID)\n"
            + ")";

    private static final String ADD_TEST_DATA_TABLE_SCRIPT = "CREATE TABLE TEST_DATA\n"
            + "(\n"
            + "    ID                      BIGINT          NOT NULL,\n"
            + "    LOOKUP_KEY              VARCHAR(100)    NOT NULL,\n"
            + "    VALUE                   VARCHAR(100),\n"
            + "    CONSTRAINT TEST_DATA_PK PRIMARY KEY (ID),\n"
            + "    CONSTRAINT TEST_DATA_LOOKUP_KEY_UC UNIQUE (LOOKUP_KEY)\n"
            + ")";

    private static final String INSERT_ADMIN_PERSON_SCRIPT = "INSERT INTO APP.PERSON VALUES \n"
            + "(\n"
            + "    112233445566778899, \n"
            + "    'Admin User', \n"
            + "    '01/01/1900', \n"
            + "    '1 Infinite Loop, Cupertino, CA 95014', \n"
            + "    NULL, \n"
            + "    'DDB716023F2844326ADA0381BDE3E770'\n"
            + ")";

    private static final String INSERT_STANDARD_PERSON_SCRIPT = "INSERT INTO APP.PERSON VALUES \n"
            + "(\n"
            + "    223344556677889911, \n"
            + "    'Standard User', \n"
            + "    '01/01/1900', \n"
            + "    '1 Infinite Loop, Cupertino, CA 95014', \n"
            + "    NULL, \n"
            + "    'F2D1A66BAC2979D1B576BCA34B1A1EE3'\n"
            + ")";

    private static final String INSERT_ADMIN_ATM_USER_SCRIPT = "INSERT INTO APP.ATM_USER VALUES \n"
            + "(\n"
            + "    998877665544332211, \n"
            + "    112233445566778899, \n"
            + "    'admin', \n"
            + "    'F39B058A5D557E4AE60345E1EFA2D501', \n"
            + "    '170E2F293E945DC39A127062DD47DEE9', \n"
            + "    '65545E62FB414BA11841A87E04D71D02', \n"
            + "    'DF537BF09CCA2BADD5AD82F2EA4A884D', \n"
            + "    '65545E62FB414BA11841A87E04D71D02', \n"
            + "    true, \n"
            + "    false, \n"
            + "    'Dark Theme' \n"
            + ")";

    private static final String INSERT_STANDARD_ATM_USER_SCRIPT = "INSERT INTO APP.ATM_USER VALUES \n"
            + "(\n"
            + "    887766554433221199, \n"
            + "    223344556677889911, \n"
            + "    'standard', \n"
            + "    'F39B058A5D557E4AE60345E1EFA2D501', \n"
            + "    '170E2F293E945DC39A127062DD47DEE9', \n"
            + "    '65545E62FB414BA11841A87E04D71D02', \n"
            + "    'DF537BF09CCA2BADD5AD82F2EA4A884D', \n"
            + "    '65545E62FB414BA11841A87E04D71D02', \n"
            + "    false, \n"
            + "    false, \n"
            + "    'Dark Theme' \n"
            + ")";

    private static final String INSERT_STANDARD_USER_CHECKING_ACCOUNT_SCRIPT = "INSERT INTO APP.ACCOUNT VALUES \n"
            + "(\n"
            + "    555555555555555555, \n"
            + "    10000001, \n"
            + "    'CHECKING', \n"
            + "    NULL, \n"
            + "    0, \n"
            + "    NULL \n"
            + ")";

    private static final String INSERT_STANDARD_USER_SAVING_ACCOUNT_SCRIPT = "INSERT INTO APP.ACCOUNT VALUES \n"
            + "(\n"
            + "    666666666666666666, \n"
            + "    10000002, \n"
            + "    'SAVING', \n"
            + "    NULL, \n"
            + "    0, \n"
            + "    2.25 \n"
            + ")";

    private static final String INSERT_STANDARD_USER_CHECKING_ACCOUNT_LINK_SCRIPT = "INSERT INTO APP.ACCOUNT_PERSON_MAP VALUES \n"
            + "(\n"
            + "    221122112211221122, \n"
            + "    555555555555555555, \n"
            + "    223344556677889911 \n"
            + ")";

    private static final String INSERT_STANDARD_USER_SAVING_ACCOUNT_LINK_SCRIPT = "INSERT INTO APP.ACCOUNT_PERSON_MAP VALUES \n"
            + "(\n"
            + "    112211221122112211, \n"
            + "    666666666666666666, \n"
            + "    223344556677889911 \n"
            + ")";

    private static final String INSERT_STANDARD_USER_CHECKING_ACCOUNT_TRANSACTION_SCRIPT = "INSERT INTO APP.ACCOUNT_TRANSACTION VALUES \n"
            + "(\n"
            + "    332233223322332233, \n"
            + "    555555555555555555, \n"
            + "    223344556677889911, \n"
            + "    '1960-01-01 08:00:00', \n"
            + "    1000.00 \n"
            + ")";

    private static final String UPDATE_STANDARD_USER_CHECKING_ACCOUNT_BALANCE_SCRIPT = "UPDATE APP.ACCOUNT SET \n"
            + "    BALANCE = 1000.00 \n"
            + "    WHERE ID = 555555555555555555";

    private static final String INSERT_STANDARD_USER_SAVING_ACCOUNT_TRANSACTION_SCRIPT = "INSERT INTO APP.ACCOUNT_TRANSACTION VALUES \n"
            + "(\n"
            + "    443344334433443344, \n"
            + "    666666666666666666, \n"
            + "    223344556677889911, \n"
            + "    '1960-01-01 08:00:00', \n"
            + "    5000.00 \n"
            + ")";

    private static final String UPDATE_STANDARD_USER_SAVING_ACCOUNT_BALANCE_SCRIPT = "UPDATE APP.ACCOUNT SET \n"
            + "    BALANCE = 5000.00 \n"
            + "    WHERE ID = 666666666666666666";

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Constructors"> 
    private DatabaseProvisioner() {
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Methods"> 
    /**
     * Provisions the database be destroying and recreating the table structures
     * and inserting minimum data.
     */
    public static void provisionDatabase() {
        DataAccessJavaDb.openConnection();

        try {
            dropDatabaseTables();
            addDatabaseTables();

            addDefaultData();
        } catch (Exception e) {
            ExceptionHandler.handleException(e);
        } finally {
            DataAccessJavaDb.closeConnection();
        }
    }

    /**
     * Deletes the database files from the file system.
     */
    public static void deleteDatabase() {
        DataAccessJavaDb.deleteDatabase();
    }

    //This method must be called after the database connection has been opened
    private static void dropDatabaseTables() throws SQLException {
        System.out.println("Update command being executed:");

        System.out.println(DROP_TABLES_SCRIPT);
        DataAccessJavaDb.executeBatch(DROP_TABLES_SCRIPT);
    }

    //This method must be called after the database connection has been opened
    private static void addDatabaseTables() {
        System.out.println("Update commands being executed:");

        System.out.println(ADD_PERSON_TABLE_SCRIPT);
        DataAccessJavaDb.executeUpdate(ADD_PERSON_TABLE_SCRIPT);

        System.out.println(ADD_ATM_USER_TABLE_SCRIPT);
        DataAccessJavaDb.executeUpdate(ADD_ATM_USER_TABLE_SCRIPT);

        System.out.println(ADD_ACCOUNT_TABLE_SCRIPT);
        DataAccessJavaDb.executeUpdate(ADD_ACCOUNT_TABLE_SCRIPT);

        System.out.println(ADD_ACCOUNT_TRANSACTION_TABLE_SCRIPT);
        DataAccessJavaDb.executeUpdate(ADD_ACCOUNT_TRANSACTION_TABLE_SCRIPT);

        System.out.println(ADD_ACCOUNT_PERSON_MAP_TABLE_SCRIPT);
        DataAccessJavaDb.executeUpdate(ADD_ACCOUNT_PERSON_MAP_TABLE_SCRIPT);

        System.out.println(ADD_TEST_DATA_TABLE_SCRIPT);
        DataAccessJavaDb.executeUpdate(ADD_TEST_DATA_TABLE_SCRIPT);
    }

    //This method must be called after the database connection has been opened and tables have been created
    private static void addDefaultData() {
        System.out.println("Insert and Update commands being executed:");

        System.out.println(INSERT_ADMIN_PERSON_SCRIPT);
        DataAccessJavaDb.executeInsert(INSERT_ADMIN_PERSON_SCRIPT);

        System.out.println(INSERT_STANDARD_PERSON_SCRIPT);
        DataAccessJavaDb.executeInsert(INSERT_STANDARD_PERSON_SCRIPT);

        System.out.println(INSERT_ADMIN_ATM_USER_SCRIPT);
        DataAccessJavaDb.executeInsert(INSERT_ADMIN_ATM_USER_SCRIPT);

        System.out.println(INSERT_STANDARD_ATM_USER_SCRIPT);
        DataAccessJavaDb.executeInsert(INSERT_STANDARD_ATM_USER_SCRIPT);

        System.out.println(INSERT_STANDARD_USER_CHECKING_ACCOUNT_SCRIPT);
        DataAccessJavaDb.executeInsert(INSERT_STANDARD_USER_CHECKING_ACCOUNT_SCRIPT);

        System.out.println(INSERT_STANDARD_USER_SAVING_ACCOUNT_SCRIPT);
        DataAccessJavaDb.executeInsert(INSERT_STANDARD_USER_SAVING_ACCOUNT_SCRIPT);

        System.out.println(INSERT_STANDARD_USER_CHECKING_ACCOUNT_LINK_SCRIPT);
        DataAccessJavaDb.executeInsert(INSERT_STANDARD_USER_CHECKING_ACCOUNT_LINK_SCRIPT);

        System.out.println(INSERT_STANDARD_USER_SAVING_ACCOUNT_LINK_SCRIPT);
        DataAccessJavaDb.executeInsert(INSERT_STANDARD_USER_SAVING_ACCOUNT_LINK_SCRIPT);

        System.out.println(INSERT_STANDARD_USER_CHECKING_ACCOUNT_TRANSACTION_SCRIPT);
        DataAccessJavaDb.executeInsert(INSERT_STANDARD_USER_CHECKING_ACCOUNT_TRANSACTION_SCRIPT);

        System.out.println(UPDATE_STANDARD_USER_CHECKING_ACCOUNT_BALANCE_SCRIPT);
        DataAccessJavaDb.executeUpdate(UPDATE_STANDARD_USER_CHECKING_ACCOUNT_BALANCE_SCRIPT);

        System.out.println(INSERT_STANDARD_USER_SAVING_ACCOUNT_TRANSACTION_SCRIPT);
        DataAccessJavaDb.executeInsert(INSERT_STANDARD_USER_SAVING_ACCOUNT_TRANSACTION_SCRIPT);

        System.out.println(UPDATE_STANDARD_USER_SAVING_ACCOUNT_BALANCE_SCRIPT);
        DataAccessJavaDb.executeUpdate(UPDATE_STANDARD_USER_SAVING_ACCOUNT_BALANCE_SCRIPT);
    }

    // </editor-fold>
}
