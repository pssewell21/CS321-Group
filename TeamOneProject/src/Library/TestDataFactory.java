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
    
    public TestDataFactory() {
        super("APP", "TESTDATA");
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
                    String key = resultSet.getString(DalFields.LOOKUPKEY);
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

    @Override
    public void executeInsert(HashMap<String, String> criteria) {
        DataAccessJavaDb.openConnection();

        try {
            String command = generateInsertCommand(criteria);

            if (hasValue(command)) {
                DataAccessJavaDb.executeInsert(command);
                System.out.println("Insert command being executed:\n" + command);
            } else {
                System.out.println("No insert command was run from the provided criteria");
            }
        } catch (Exception e) {
            handleException(e);
        } finally {
            DataAccessJavaDb.closeConnection();
        }
    }

    @Override
    public void executeUpdate(HashMap<String, String> criteria) {
        DataAccessJavaDb.openConnection();

        try {
            String command = generateUpdateCommand(criteria);

            if (hasValue(command)) {
                DataAccessJavaDb.executeUpdate(command);
                System.out.println("Update command being executed:\n" + command);
            } else {
                System.out.println("No update command was run from the provided criteria");
            }
        } catch (Exception e) {
            handleException(e);
        } finally {
            DataAccessJavaDb.closeConnection();
        }
    }

    @Override
    public void executeDelete(HashMap<String, String> criteria) {
        DataAccessJavaDb.openConnection();

        try {
            String command = generateDeleteCommand(criteria);

            if (hasValue(command)) {
                DataAccessJavaDb.executeDelete(command);
                System.out.println("Delete command being executed:\n" + command);
            } else {
                System.out.println("No delete command was run from the provided criteria");
            }
        } catch (Exception e) {
            handleException(e);
        } finally {
            DataAccessJavaDb.closeConnection();
        }
    }
    
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Implementation of ISqlGenerator Methods"> 

    @Override
    public String generateSelectCommand(HashMap<String, String> criteria) {
        String command = "SELECT * FROM " + SCHEMA + "." + TABLE_NAME;

        if (criteria != null && !criteria.isEmpty()) {
            String and = "AND ";
            boolean insertAnd = false;

            String id = criteria.get(DalFields.ID);
            String key = criteria.get(DalFields.LOOKUPKEY);
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

                    command += DalFields.LOOKUPKEY + " = '" + key + "' ";
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
            String key = criteria.get(DalFields.LOOKUPKEY);
            String value = criteria.get(DalFields.VALUE);

            if (hasValue(key)) {
                command += "INSERT INTO " + SCHEMA + "." + TABLE_NAME + " VALUES (" + ID.newId() + ", '" + key + "', ";

                if (hasValue(value)) {
                    command += "'" + value + "')";
                } else {
                    command += "NULL)";
                }
            } else {
                System.out.println("Required field LOOKUPKEY not set.  Insert failed.");
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
            boolean insertComma = false;
            String comma = ", ";

            String id = criteria.get(DalFields.ID);
            String key = criteria.get(DalFields.LOOKUPKEY);
            String value = criteria.get(DalFields.VALUE);

            if (hasValue(id) && (hasValue(key) || hasValue(value))) {
                command += "UPDATE " + SCHEMA + "." + TABLE_NAME + " SET ";

                if (hasValue(key)) {
                    command += DalFields.LOOKUPKEY + " = '" + key + "' ";
                    insertComma = true;
                }

                if (hasValue(value)) {
                    if (insertComma) {
                        command += comma;
                    }

                    command += DalFields.VALUE + " = '" + value + "' ";
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

    /**
     *
     * @param criteria
     * @return
     */
    @Override
    public String generateDeleteCommand(HashMap<String, String> criteria) {
        String command = "";

        if (!criteria.isEmpty()) {
            String id = criteria.get(DalFields.ID);

            if (hasValue(id)) {
                command += "DELETE FROM " + SCHEMA + "." + TABLE_NAME + " WHERE ID = " + id;
            } else {
                System.out.println("Required field ID not set.  Delete failed.");
            }
        } else {
            System.out.println("No criteria have been set.  Delete failed.");
        }


        return command;
    }
    
    // </editor-fold>
}
