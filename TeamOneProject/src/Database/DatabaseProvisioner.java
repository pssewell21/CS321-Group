/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import DataAccess.DataAccessJavaDb;
import Common.ExceptionHandler;
import java.sql.SQLException;

/**
 *
 * @author Owner
 */
public final class DatabaseProvisioner {

    // <editor-fold defaultstate="collapsed" desc="SQL Scripts"> 
    private static final String DROP_TABLES_SCRIPT = "DROP TABLE APP.ACCOUNT_ACCOUNT_MAP;\n"
            + "DROP TABLE APP.ACCOUNT_PERSON_MAP;\n"
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
            + "    SOCIAL_SECURITY_NUMBER  VARCHAR(9)      NOT NULL,\n"
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
            + "    BALANCE                 NUMERIC(12,2)   NOT NULL,\n"
            + "    INTEREST_RATE           NUMERIC(2,2),\n"
            + "    CONSTRAINT ACCOUNT_PK PRIMARY KEY (ID),\n"
            + "    CONSTRAINT ACCOUNT_ACCOUNT_NUMBER_UC UNIQUE (ACCOUNT_NUMBER)\n"
            + ")";

    private static final String ADD_ACCOUNT_TRANSACTION_TABLE_SCRIPT = "CREATE TABLE ACCOUNT_TRANSACTION\n"
            + "(\n"
            + "    ID                      BIGINT          NOT NULL,\n"
            + "    ACCOUNT_ID              BIGINT          NOT NULL,\n"
            + "    PERSON_ID               BIGINT          NOT NULL,\n"
            + "    TRANSACTION_TIMESTAMP   TIMESTAMP       NOT NULL,\n"
            + "    DESCRIPTION             VARCHAR(300),\n"
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

    private static final String INSERT_DEFAULT_PERSON_SCRIPT = "INSERT INTO APP.PERSON VALUES \n"
            + "(\n"
            + "    112233445566778899, \n"
            + "    'Default User', \n"
            + "    '01/01/1900', \n"
            + "    NULL, \n"
            + "    NULL, \n"
            + "    '000000000'\n"
            + ")";

    private static final String INSERT_DEFAULT_ATM_USER_SCRIPT = "INSERT INTO APP.ATM_USER VALUES \n"
            + "(\n"
            + "    998877665544332211, \n"
            + "    112233445566778899, \n"
            + "    'default', \n"
            + "    'password', \n"
            + "    'question1?', \n"
            + "    'answer', \n"
            + "    'question2?', \n"
            + "    'answer', \n"
            + "    true, \n"
            + "    false, \n"
            + "    'default' \n"
            + ")";

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructors"> 
    private DatabaseProvisioner() {
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Methods"> 
    /**
     *
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

    //This method must be called after the database connection has been opened
    private static void dropDatabaseTables() throws SQLException {
        System.out.println("Update command being executed:");
        
        System.out.println(DROP_TABLES_SCRIPT);
        DataAccessJavaDb.execute(DROP_TABLES_SCRIPT);
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

    private static void addDefaultData() {
        System.out.println("Insert commands being executed:");

        System.out.println(INSERT_DEFAULT_PERSON_SCRIPT);
        DataAccessJavaDb.executeInsert(INSERT_DEFAULT_PERSON_SCRIPT);

        System.out.println(INSERT_DEFAULT_ATM_USER_SCRIPT);
        DataAccessJavaDb.executeInsert(INSERT_DEFAULT_ATM_USER_SCRIPT);
    }

    // </editor-fold>
}
