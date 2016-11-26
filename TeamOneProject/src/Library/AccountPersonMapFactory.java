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
 *
 * @author Owner
 */
public class AccountPersonMapFactory extends LibraryFactoryBase {

    // <editor-fold defaultstate="collapsed" desc="Constructors"> 
    /**
     *
     */
    public AccountPersonMapFactory() {
        super("APP", "ACCOUNT_PERSON_MAP");
    }

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Implementation of LibraryFactoryBase Methods"> 
    @Override
    public List<AccountPersonMap> executeSelect(HashMap<String, String> criteria) {
        List<AccountPersonMap> list = new ArrayList<>();

        DataAccessJavaDb.openConnection();

        try {
            String command = generateSelectCommand(criteria);

            if (hasValue(command)) {
                ResultSet resultSet = DataAccessJavaDb.executeSelect(command);
                System.out.println("Select command being executed:\n" + command);

                while (resultSet != null && resultSet.next()) {
                    Long id = resultSet.getLong(DalFields.ID);
                    Long accountId = resultSet.getLong(DalFields.ACCOUNT_ID);
                    Long personId = resultSet.getLong(DalFields.PERSON_ID);

                    list.add(new AccountPersonMap(id, accountId, personId));
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
        // Can filter by ID, ACCOUNT_ID, or PERSON_ID
        String command = "SELECT * FROM " + SCHEMA + "." + TABLE_NAME;

        if (criteria != null && !criteria.isEmpty()) {
            String and = "AND ";
            boolean insertAnd = false;

            String id = criteria.get(DalFields.ID);
            String accountId = criteria.get(DalFields.ACCOUNT_ID);
            String personId = criteria.get(DalFields.PERSON_ID);

            if (hasValue(id) || hasValue(accountId) || hasValue(personId)) {
                command += "\nWHERE ";

                if (hasValue(id)) {
                    command += DalFields.ID + " = " + id + " ";
                    insertAnd = true;
                }

                if (hasValue(accountId)) {
                    if (insertAnd) {
                        command += and;
                    }

                    command += DalFields.ACCOUNT_ID + " = " + accountId + " ";
                    insertAnd = true;
                }

                if (hasValue(personId)) {
                    if (insertAnd) {
                        command += and;
                    }

                    command += DalFields.PERSON_ID + " = " + personId + " ";
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
            String accountId = criteria.get(DalFields.ACCOUNT_ID);
            String personId = criteria.get(DalFields.PERSON_ID);

            if (hasValue(accountId)
                    && hasValue(personId)) {
                command += "INSERT INTO " + SCHEMA + "." + TABLE_NAME + " VALUES ("
                        + ID.newId() + ", "
                        + "" + accountId + ", "
                        + "" + personId + ""
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
            String accountId = criteria.get(DalFields.ACCOUNT_ID);
            String personId = criteria.get(DalFields.PERSON_ID);

            if (hasValue(id)
                    && hasValue(accountId)
                    && hasValue(personId)) {
                command += "UPDATE " + SCHEMA + "." + TABLE_NAME + " SET "
                        + DalFields.ACCOUNT_ID + " = " + accountId + ", "
                        + DalFields.PERSON_ID + " = " + personId + " ";

                command += "WHERE " + DalFields.ID + " = " + id;
            }
        } else {
            System.out.println("No criteria have been set.  Update failed.");
        }

        return command;
    }

    // </editor-fold>
}
