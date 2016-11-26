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
public class TestDataFactory extends LibraryFactoryBase {

    // <editor-fold defaultstate="collapsed" desc="Constructors"> 
    /**
     *
     */
    public TestDataFactory() {
        super("APP", "TEST_DATA");
    }

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Implementation of LibraryFactoryBase Methods"> 
    @Override
    public List<TestData> executeSelect(HashMap<String, String> criteria) {
        List<TestData> list = new ArrayList<>();

        DataAccessJavaDb.openConnection();

        try {
            String command = generateSelectCommand(criteria);

            if (hasValue(command)) {
                ResultSet resultSet = DataAccessJavaDb.executeSelect(command);
                System.out.println("Select command being executed:\n" + command);

                while (resultSet != null && resultSet.next()) {
                    Long id = resultSet.getLong(DalFields.ID);
                    String key = resultSet.getString(DalFields.LOOKUP_KEY);
                    String value = resultSet.getString(DalFields.VALUE);

                    list.add(new TestData(id, key, value));
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
        // Can filter by ID, LOOKUP_KEY, or VALUE
        String command = "SELECT * FROM " + SCHEMA + "." + TABLE_NAME;

        if (criteria != null && !criteria.isEmpty()) {
            String and = "AND ";
            boolean insertAnd = false;

            String id = criteria.get(DalFields.ID);
            String key = criteria.get(DalFields.LOOKUP_KEY);
            String value = criteria.get(DalFields.VALUE);

            if (hasValue(id) || hasValue(key) || hasValue(value)) {
                command += "\nWHERE ";

                if (hasValue(id)) {
                    command += DalFields.ID + " = " + id + " ";
                    insertAnd = true;
                }

                if (hasValue(key)) {
                    if (insertAnd) {
                        command += and;
                    }

                    command += DalFields.LOOKUP_KEY + " = '" + key + "' ";
                    insertAnd = true;
                }

                if (hasValue(value)) {
                    if (insertAnd) {
                        command += and;
                    }

                    command += DalFields.VALUE + " = '" + value + "' ";
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
            String key = criteria.get(DalFields.LOOKUP_KEY);
            String value = criteria.get(DalFields.VALUE);

            if (hasValue(key)) {
                command += "INSERT INTO " + SCHEMA + "." + TABLE_NAME + " VALUES ("
                        + ID.newId() + ", "
                        + "'" + key + "', ";

                if (hasValue(value)) {
                    command += "'" + value + "'";
                } else {
                    command += "NULL";
                }

                command += ")";
            } else {
                System.out.println("Required field LOOKUP_KEY not set.  Insert failed.");
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
            String comma = ", ";

            String id = criteria.get(DalFields.ID);
            String key = criteria.get(DalFields.LOOKUP_KEY);
            String value = criteria.get(DalFields.VALUE);

            if (hasValue(id)
                    && (hasValue(key))) {
                command += "UPDATE " + SCHEMA + "." + TABLE_NAME + " SET "
                        + DalFields.LOOKUP_KEY + " = '" + key + "' ";

                if (hasValue(value)) {
                    command += comma + DalFields.VALUE + " = '" + value + "' ";
                } else {
                    command += comma + DalFields.VALUE + " = NULL ";
                }

                command += "WHERE " + DalFields.ID + " = " + id;
            } else {
                System.out.println("An appropriate combination of values has not been set.  Update failed.");
            }
        } else {
            System.out.println("No criteria have been set.  Update failed.");
        }

        return command;
    }

    // </editor-fold>
}
