/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;

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
    // <editor-fold defaultstate="collapsed" desc="Methods"> 
    //TODO: May not be necessary since we are selecting a real object in the list view, it may be better to not select a real object though in which case this method would be useful
//    public TestData getById(long id) {
//        HashMap<String, String> criteria = new HashMap<>();
//
//        criteria.put(DalFields.ID, Long.toString(id));
//
//        List<TestData> result = executeSelect(criteria);
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
                        + DalFields.ID + " = " + ID.newId() + ", "
                        + DalFields.LOOKUP_KEY + " = '" + key + "' ";

                if (hasValue(value)) {
                    command += DalFields.VALUE + " = '" + value + "'"
                            + ")";
                } else {
                    command += DalFields.VALUE + " = NULL"
                            + ")";
                }
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

            if (hasValue(id) && (hasValue(key) || hasValue(value))) {
                command += "UPDATE " + SCHEMA + "." + TABLE_NAME + " SET "
                        + DalFields.LOOKUP_KEY + " = '" + key + "' ";

                if (hasValue(value)) {
                    command += comma + DalFields.VALUE + " = '" + value + "' ";
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
