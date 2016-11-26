/*
 * Copyright 2016 AUTHORS. Patrick S Sewell, Paul M Dyer, Taehyeok Lee, 
 * Benjamin C Ferguson, Hyunki J KIm Permission is granted to copy, distribute 
 * and/or modify this document under the terms of the GNU Free Documentation 
 * License, Version 1.3, (3 November 2008) or any later version published by 
 * the Free Software Foundation; with no Invariant Sections, with no 
 * Front-Cover Texts, and with no Back-Cover Texts. A copy of the license 
 * can be found at http://www.gnu.org/copyleft/fdl.html
 */
package Library;

import Common.ID;
import DataAccess.DataAccessJavaDb;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * The factory used to allow interaction between the library and the database.
 * @author Patrick Sewell
 */
public class UserFactory extends LibraryFactoryBase {

    // <editor-fold defaultstate="collapsed" desc="Constructors"> 
    /**
     * Initializes the factory object.
     */
    public UserFactory() {
        super("APP", "ATM_USER");
    }

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Implementation of LibraryFactoryBase Methods"> 
    @Override
    public List<User> executeSelect(HashMap<String, String> criteria) {
        List<User> list = new ArrayList<>();

        DataAccessJavaDb.openConnection();

        try {
            String command = generateSelectCommand(criteria);

            if (hasValue(command)) {
                ResultSet resultSet = DataAccessJavaDb.executeSelect(command);
                System.out.println("Select command being executed:\n" + command);

                while (resultSet != null && resultSet.next()) {
                    Long id = resultSet.getLong(DalFields.ID);
                    Long personId = resultSet.getLong(DalFields.PERSON_ID);
                    String userName = resultSet.getString(DalFields.USER_NAME);
                    String password = resultSet.getString(DalFields.PASSWORD);
                    String securityQuestion1 = resultSet.getString(DalFields.SECURITY_QUESTION_1);
                    String securityAnswer1 = resultSet.getString(DalFields.SECURITY_ANSWER_1);
                    String securityQuestion2 = resultSet.getString(DalFields.SECURITY_QUESTION_2);
                    String securityAnswer2 = resultSet.getString(DalFields.SECURITY_ANSWER_2);
                    Boolean isAdministrator = resultSet.getBoolean(DalFields.IS_ADMINISTRATOR);
                    Boolean isAccountLocked = resultSet.getBoolean(DalFields.IS_ACCOUNT_LOCKED);
                    String selectedTheme = resultSet.getString(DalFields.SELECTED_THEME);

                    list.add(new User(id, personId, userName, password, securityQuestion1,
                            securityAnswer1, securityQuestion2, securityAnswer2, isAdministrator,
                            isAccountLocked, selectedTheme));
                }
            } else {
                System.out.println("No select command was run from the provided criteria");
            }

        } catch (Exception e) {
            handleException(e);
        } finally {
            DataAccessJavaDb.closeConnection();
        }

        return list;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Implementation of ISqlGenerator Methods"> 
    @Override
    public String generateSelectCommand(HashMap<String, String> criteria) {
        // Can filter by ID, PERSON_ID, or USER_NAME
        String command = "SELECT * FROM " + SCHEMA + "." + TABLE_NAME;

        if (criteria != null && !criteria.isEmpty()) {
            String and = "AND ";
            boolean insertAnd = false;

            String id = criteria.get(DalFields.ID);
            String personId = criteria.get(DalFields.PERSON_ID);
            String userName = criteria.get(DalFields.USER_NAME);
            //String password = criteria.get(DalFields.PASSWORD);
            //String securityQuestion1 = criteria.get(DalFields.SECURITY_QUESTION_1);
            //String securityAnswer1 = criteria.get(DalFields.SECURITY_ANSWER_1);
            //String securityQuestion2 = criteria.get(DalFields.SECURITY_QUESTION_2);
            //String securityAnswer2 = criteria.get(DalFields.SECURITY_ANSWER_2);
            //String isAdministrator = criteria.get(DalFields.IS_ADMINISTRATOR);
            //String isAccountLocked = criteria.get(DalFields.IS_ACCOUNT_LOCKED);
            //String selectedTheme = criteria.get(DalFields.SELECTED_THEME);

            if (hasValue(id) || hasValue(personId) || hasValue(userName)) {
                command += "\nWHERE ";

                if (hasValue(id)) {
                    command += DalFields.ID + " = " + id + " ";
                    insertAnd = true;
                }

                if (hasValue(personId)) {
                    if (insertAnd) {
                        command += and;
                    }

                    command += DalFields.PERSON_ID + " = " + personId + " ";
                    insertAnd = true;
                }

                if (hasValue(userName)) {
                    if (insertAnd) {
                        command += and;
                    }

                    command += DalFields.USER_NAME + " = '" + userName + "' ";
                }
            }
        }

        return command;
    }

    @Override
    public String generateInsertCommand(HashMap<String, String> criteria) {
        String command = "";

        if (!criteria.isEmpty()) {
            String personId = criteria.get(DalFields.PERSON_ID);
            String userName = criteria.get(DalFields.USER_NAME);
            String password = criteria.get(DalFields.PASSWORD);
            String securityQuestion1 = criteria.get(DalFields.SECURITY_QUESTION_1);
            String securityAnswer1 = criteria.get(DalFields.SECURITY_ANSWER_1);
            String securityQuestion2 = criteria.get(DalFields.SECURITY_QUESTION_2);
            String securityAnswer2 = criteria.get(DalFields.SECURITY_ANSWER_2);
            String isAdministrator = criteria.get(DalFields.IS_ADMINISTRATOR);
            String isAccountLocked = criteria.get(DalFields.IS_ACCOUNT_LOCKED);
            String selectedTheme = criteria.get(DalFields.SELECTED_THEME);

            if (hasValue(personId)
                    && hasValue(userName)
                    && hasValue(password)
                    && hasValue(securityQuestion1)
                    && hasValue(securityAnswer1)
                    && hasValue(securityQuestion2)
                    && hasValue(securityAnswer2)
                    && hasValue(isAdministrator)
                    && hasValue(isAccountLocked)
                    && hasValue(selectedTheme)) {
                command += "INSERT INTO " + SCHEMA + "." + TABLE_NAME + " VALUES ("
                        + ID.newId() + ", "
                        + "" + personId + ", "
                        + "'" + userName + "', "
                        + "'" + password + "', "
                        + "'" + securityQuestion1 + "', "
                        + "'" + securityAnswer1 + "', "
                        + "'" + securityQuestion2 + "', "
                        + "'" + securityAnswer2 + "', "
                        + "" + isAdministrator + ", "
                        + "" + isAccountLocked + ", "
                        + "'" + selectedTheme + "'"
                        + ")";
            } else {
                //TODO: Make the logic for printing this message logic better
                System.out.println("Required field ????? not set.  Insert failed.");
            }
        } else {
            System.out.println("No criteria have been set.  Insert failed.");
        }

        return command;
    }

    @Override
    public String generateUpdateCommand(HashMap<String, String> criteria) {
        String command = "";

        if (!criteria.isEmpty()) {

            String id = criteria.get(DalFields.ID);
            String personId = criteria.get(DalFields.PERSON_ID);
            String userName = criteria.get(DalFields.USER_NAME);
            String password = criteria.get(DalFields.PASSWORD);
            String securityQuestion1 = criteria.get(DalFields.SECURITY_QUESTION_1);
            String securityAnswer1 = criteria.get(DalFields.SECURITY_ANSWER_1);
            String securityQuestion2 = criteria.get(DalFields.SECURITY_QUESTION_2);
            String securityAnswer2 = criteria.get(DalFields.SECURITY_ANSWER_2);
            String isAdministrator = criteria.get(DalFields.IS_ADMINISTRATOR);
            String isAccountLocked = criteria.get(DalFields.IS_ACCOUNT_LOCKED);
            String selectedTheme = criteria.get(DalFields.SELECTED_THEME);

            if (hasValue(id)
                    && hasValue(personId)
                    && hasValue(userName)
                    && hasValue(password)
                    && hasValue(securityQuestion1)
                    && hasValue(securityAnswer1)
                    && hasValue(securityQuestion2)
                    && hasValue(securityAnswer2)
                    && hasValue(isAdministrator)
                    && hasValue(isAccountLocked)
                    && hasValue(selectedTheme)) {
                command += "UPDATE " + SCHEMA + "." + TABLE_NAME + " SET "
                        + DalFields.PERSON_ID + " = " + personId + ", "
                        + DalFields.USER_NAME + " = '" + userName + "', "
                        + DalFields.PASSWORD + " = '" + password + "', "
                        + DalFields.SECURITY_QUESTION_1 + " = '" + securityQuestion1 + "', "
                        + DalFields.SECURITY_ANSWER_1 + " = '" + securityAnswer1 + "', "
                        + DalFields.SECURITY_QUESTION_2 + " = '" + securityQuestion2 + "', "
                        + DalFields.SECURITY_ANSWER_2 + " = '" + securityAnswer2 + "', "
                        + DalFields.IS_ADMINISTRATOR + " = " + isAdministrator + ", "
                        + DalFields.IS_ACCOUNT_LOCKED + " = " + isAccountLocked + ", "
                        + DalFields.SELECTED_THEME + " = '" + selectedTheme + "' ";

                command += "WHERE " + DalFields.ID + " = " + id;
            }
        } else {
            System.out.println("No criteria have been set.  Update failed.");
        }

        return command;
    }

    // </editor-fold>
}
