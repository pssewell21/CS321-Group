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
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * The factory used to allow interaction between the library and the database.
 * @author Patrick Sewell
 */
public class AccountFactory extends LibraryFactoryBase {
    // <editor-fold defaultstate="collapsed" desc="Constructors"> 

    /**
     * Initializes the factory object.
     */
    public AccountFactory() {
        super("APP", "ACCOUNT");
    }

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Methods"> 
    /**
     * Gets an Account object by the value ID field.
     * @param id The ID of the Account record to get
     * @return The single Account record or nothing
     */
    public Account getById(Long id) {
        HashMap<String, String> criteria = new HashMap<>(0);
        criteria.put(DalFields.ID, id.toString());

        //Returns a list containing 0 or 1 items
        List<Account> result = executeSelect(criteria);
        if (!result.isEmpty()) {
            return result.get(0);
        }

        return null;
    }

    /**
     * Gets an list of Account objects by the User ID linked to them.
     * @param userId The ID of the User to get Account records by
     * @return The single account or nothing
     */
    public List<Account> getByUserId(Long userId) {
        List<Account> list = new ArrayList<>();

        DataAccessJavaDb.openConnection();

        try {
            String command = generateSelectByUserIdCommand(userId);

            if (hasValue(command)) {
                ResultSet resultSet = DataAccessJavaDb.executeSelect(command);
                System.out.println("Select command being executed:\n" + command);

                while (resultSet != null && resultSet.next()) {
                    Long id = resultSet.getLong(DalFields.ID);
                    Long accountNumber = resultSet.getLong(DalFields.ACCOUNT_NUMBER);
                    String accountType = resultSet.getString(DalFields.ACCOUNT_TYPE);
                    String description = resultSet.getString(DalFields.DESCRIPTION);
                    BigDecimal balance = resultSet.getBigDecimal(DalFields.BALANCE);
                    BigDecimal interestRate = resultSet.getBigDecimal(DalFields.INTEREST_RATE);

                    list.add(new Account(id, accountNumber, accountType, description,
                            balance, interestRate));
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

    private String generateSelectByUserIdCommand(Long userId) {
        String command = "SELECT a.* FROM ATM_USER u\n"
                + "INNER JOIN ACCOUNT_PERSON_MAP apm\n"
                + "    ON apm.PERSON_ID = u.PERSON_ID\n"
                + "INNER JOIN ACCOUNT a\n"
                + "    ON a.ID = apm.ACCOUNT_ID\n"
                + "WHERE u.ID = " + userId.toString();

        return command;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Implementation of LibraryFactoryBase Methods"> 
    @Override
    public List<Account> executeSelect(HashMap<String, String> criteria) {
        List<Account> list = new ArrayList<>();

        DataAccessJavaDb.openConnection();

        try {
            String command = generateSelectCommand(criteria);

            if (hasValue(command)) {
                ResultSet resultSet = DataAccessJavaDb.executeSelect(command);
                System.out.println("Select command being executed:\n" + command);

                while (resultSet != null && resultSet.next()) {
                    Long id = resultSet.getLong(DalFields.ID);
                    Long accountNumber = resultSet.getLong(DalFields.ACCOUNT_NUMBER);
                    String accountType = resultSet.getString(DalFields.ACCOUNT_TYPE);
                    String description = resultSet.getString(DalFields.DESCRIPTION);
                    BigDecimal balance = resultSet.getBigDecimal(DalFields.BALANCE);
                    BigDecimal interestRate = resultSet.getBigDecimal(DalFields.INTEREST_RATE);

                    list.add(new Account(id, accountNumber, accountType, description,
                            balance, interestRate));
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
        //TODOL: Update this comment to be accurate
        // Can filter by ID, ACCOUNT_NUMBER, or ACCOUNT_TYPE
        String command = "SELECT * FROM " + SCHEMA + "." + TABLE_NAME;

        if (criteria != null && !criteria.isEmpty()) {
            String and = "AND ";
            boolean insertAnd = false;

            String id = criteria.get(DalFields.ID);
            String accountNumber = criteria.get(DalFields.ACCOUNT_NUMBER);
            String accountType = criteria.get(DalFields.ACCOUNT_TYPE);
            //String description = criteria.get(DalFields.DESCRIPTION);
            //String balance = criteria.get(DalFields.BALANCE);
            //String interestRate = criteria.get(DalFields.INTEREST_RATE);

            if (hasValue(id) || hasValue(accountNumber) || hasValue(accountType)) {
                command += "\nWHERE ";

                if (hasValue(id)) {
                    command += DalFields.ID + " = " + id + " ";
                    insertAnd = true;
                }

                if (hasValue(accountNumber)) {
                    if (insertAnd) {
                        command += and;
                    }

                    command += DalFields.ACCOUNT_NUMBER + " = " + accountNumber + " ";
                    insertAnd = true;
                }

                if (hasValue(accountType)) {
                    if (insertAnd) {
                        command += and;
                    }

                    command += DalFields.ACCOUNT_TYPE + " = '" + accountType + "' ";
                }
            }
        }

        return command;
    }

    @Override
    public String generateInsertCommand(HashMap<String, String> criteria) {
        String command = "";

        if (!criteria.isEmpty()) {
            String accountNumber = criteria.get(DalFields.ACCOUNT_NUMBER);
            String accountType = criteria.get(DalFields.ACCOUNT_TYPE);
            String description = criteria.get(DalFields.DESCRIPTION);
            String balance = criteria.get(DalFields.BALANCE);
            String interestRate = criteria.get(DalFields.INTEREST_RATE);

            if (hasValue(accountNumber)
                    && hasValue(accountType)
                    && hasValue(balance)) {
                command += "INSERT INTO " + SCHEMA + "." + TABLE_NAME + " VALUES ("
                        + ID.newId() + ", "
                        + "" + accountNumber + ", "
                        + "'" + accountType + "', ";

                if (hasValue(description)) {
                    command += "'" + description + "', ";
                } else {
                    command += "NULL, ";
                }

                command += "" + balance + ", ";

                if (hasValue(interestRate)) {
                    command += "" + interestRate + "";
                } else {
                    command += "NULL";
                }

                command += ")";
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
            String accountNumber = criteria.get(DalFields.ACCOUNT_NUMBER);
            String accountType = criteria.get(DalFields.ACCOUNT_TYPE);
            String description = criteria.get(DalFields.DESCRIPTION);
            String balance = criteria.get(DalFields.BALANCE);
            String interestRate = criteria.get(DalFields.INTEREST_RATE);

            if (hasValue(id)
                    && hasValue(accountNumber)
                    && hasValue(accountType)
                    && hasValue(balance)) {
                command += "UPDATE " + SCHEMA + "." + TABLE_NAME + " SET "
                        + DalFields.ACCOUNT_NUMBER + " = " + accountNumber + ", "
                        + DalFields.ACCOUNT_TYPE + " = '" + accountType + "', ";

                if (hasValue(description)) {
                    command += DalFields.DESCRIPTION + " = '" + description + "', ";
                } else {
                    command += DalFields.DESCRIPTION + " = NULL, ";
                }

                command += DalFields.BALANCE + " = " + balance + ", ";

                if (hasValue(interestRate)) {
                    command += DalFields.INTEREST_RATE + " = " + interestRate + " ";
                } else {
                    command += DalFields.INTEREST_RATE + " = NULL ";
                }

                command += "WHERE " + DalFields.ID + " = " + id;
            }
        } else {
            System.out.println("No criteria have been set.  Update failed.");
        }

        return command;
    }

    // </editor-fold>
}
