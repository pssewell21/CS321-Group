/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;

import Common.ID;
import DataAccess.DataAccessJavaDb;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Owner
 */
public class UserFactory extends LibraryFactoryBase {

    // <editor-fold defaultstate="collapsed" desc="Constructors"> 
    /**
     *
     */
    public UserFactory() {
        super("APP", "ATM_USER");
    }

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Methods"> 
    //TODO: May not be necessary since we are selecting a real object in the list view, it may be better to not select a real object though in which case this method would be useful
//    public TestData getById(long id) {
//        HashMap<String, String> criteria = new HashMap<>();
//
//        criteria.put(DalFields.ID, Long.toString(id));
//
//        List<User> result = executeSelect(criteria);
//
//        if (result.size() > 0) {
//            return result.get(0);
//        } else {
//            return null;
//        }
//    }
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

    /**
     *
     * @param criteria
     * @return
     */
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
                        + DalFields.ID + " = " + ID.newId() + ", "
                        + DalFields.PERSON_ID + " = " + personId + ", "
                        + DalFields.USER_NAME + " = '" + userName + "', "
                        + DalFields.PASSWORD + " = '" + password + "', "
                        + DalFields.SECURITY_QUESTION_1 + " = '" + securityQuestion1 + "', "
                        + DalFields.SECURITY_ANSWER_1 + " = '" + securityAnswer1 + "', "
                        + DalFields.SECURITY_QUESTION_2 + " = '" + securityQuestion2 + "', "
                        + DalFields.SECURITY_ANSWER_2 + " = '" + securityAnswer2 + "', "
                        + DalFields.IS_ADMINISTRATOR + " = " + isAdministrator + ", "
                        + DalFields.IS_ACCOUNT_LOCKED + " = " + isAccountLocked + ", "
                        + DalFields.SELECTED_THEME + " = '" + selectedTheme + "'"
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

    /**
     *
     * @param criteria
     * @return
     */
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
