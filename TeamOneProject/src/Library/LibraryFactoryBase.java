/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;

import Common.ExceptionHandler;
import Common.Utility;
import DataAccess.DataAccessJavaDb;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Owner
 */
public abstract class LibraryFactoryBase implements ISqlGenerator {

    // <editor-fold defaultstate="collapsed" desc="Member Variables"> 
    
    protected final String SCHEMA;
    protected final String TABLE_NAME;
    
    // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc="Constructors"> 
    
    protected LibraryFactoryBase(String schema, String tableName) {
        SCHEMA = schema;
        TABLE_NAME = tableName;
    }
    
    // </editor-fold> 
    
    // <editor-fold defaultstate="collapsed" desc="Methods"> 
    
    /**
     *
     * @param hashMap
     * @return
     */
    public abstract List<? extends LibraryBase> executeSelect(HashMap<String, String> hashMap);   

    public boolean executeInsert(HashMap<String, String> criteria) {
        boolean successful = true;
        
        DataAccessJavaDb.openConnection();

        try {
            String command = generateInsertCommand(criteria);

            if (hasValue(command)) {
                successful = DataAccessJavaDb.executeInsert(command);
                System.out.println("Insert command being executed:\n" + command);
            } else {
                System.out.println("No insert command was run from the provided criteria");
                successful = false;
            }
        } catch (Exception e) {
            handleException(e);
            successful = false;
        } finally {
            DataAccessJavaDb.closeConnection();
        }
        
        return successful;
    }

    /**
     *
     * @param criteria
     * @return
     */
    public boolean executeUpdate(HashMap<String, String> criteria) {
        boolean successful = true;
        
        DataAccessJavaDb.openConnection();

        try {
            String command = generateUpdateCommand(criteria);

            if (hasValue(command)) {
                DataAccessJavaDb.executeUpdate(command);
                System.out.println("Update command being executed:\n" + command);
            } else {
                System.out.println("No update command was run from the provided criteria");
                successful = false;
            }
        } catch (Exception e) {
            handleException(e);
            successful = false;
        } finally {
            DataAccessJavaDb.closeConnection();
        }
        
        return successful;
    }

    /**
     *
     * @param criteria
     * @return
     */
    public boolean executeDelete(HashMap<String, String> criteria) {
        boolean successful = true;
        
        DataAccessJavaDb.openConnection();

        try {
            String command = generateDeleteCommand(criteria);

            if (hasValue(command)) {
                DataAccessJavaDb.executeDelete(command);
                System.out.println("Delete command being executed:\n" + command);
            } else {
                System.out.println("No delete command was run from the provided criteria");
                successful = false;
            }
        } catch (Exception e) {
            handleException(e);
            successful = false;
        } finally {
            DataAccessJavaDb.closeConnection();
        }
        
        return successful;
    }

    /**
     *
     * @param string
     * @return
     */
    protected boolean hasValue(String string) {
        return Utility.hasValue(string);
    }

    /**
     *
     * @param e
     */
    protected void handleException(Exception e) {
        ExceptionHandler.handleException(e);
    }
    
    // </editor-fold> 
    
    // <editor-fold defaultstate="collapsed" desc="Implementation of ISqlGenerator Methods"> 
    
    @Override
    public abstract String generateSelectCommand(HashMap<String, String> criteria);
            
    @Override
    public abstract String generateInsertCommand(HashMap<String, String> criteria);
    
    @Override
    public abstract String generateUpdateCommand(HashMap<String, String> criteria);
    
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
