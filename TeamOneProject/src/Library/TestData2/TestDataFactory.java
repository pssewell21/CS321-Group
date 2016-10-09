/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library.TestData2;

import DataAccess.DataAccessJavaDb;
import Library.Constants.DalFields;
import Library.ID;
import Library.LibraryBase;
import Library.LibraryFactoryBase;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Owner
 */
public class TestDataFactory extends LibraryFactoryBase
{
    public TestDataFactory()
    {
        super("APP", "TESTDATA");
    }
    
    @Override
    public List<LibraryBase> executeSelect(HashMap<String, String> criteria)
    {
        List<LibraryBase> list = new ArrayList<>();
        
        DataAccessJavaDb.openConnection();
        
        try
        {
            String command = generateSelectCommand(criteria);
            if (!isNullOrEmpty(command))
            {
                ResultSet resultSet = DataAccessJavaDb.executeSelect(command);
                System.out.println("Select command being executed:\n" + command);
                
                while (resultSet.next())
                {
                    Long id = resultSet.getLong(DalFields.ID);
                    String key = resultSet.getString(DalFields.LOOKUPKEY);
                    String value = resultSet.getString(DalFields.VALUE);
                    
                    list.add(new TestData(id, key, value));
                }
            }
            else
            {
                System.out.println("No select command was run from the provided criteria");
            }
                   
        }
        catch (Exception e)
        {
            handleException(e);
        }
        finally
        {
            DataAccessJavaDb.closeConnection();
        }
        
        return list;
    }
    
    @Override
    public void executeInsert(HashMap<String, String> criteria)
    {    
        DataAccessJavaDb.openConnection();
        
        try
        {
            String command = generateInsertCommand(criteria);
            
            if (!isNullOrEmpty(command))
            {
                DataAccessJavaDb.executeInsert(command);
                System.out.println("Insert command being executed:\n" + command);
            }
            else
            {
                System.out.println("No insert command was run from the provided criteria");
            }
        }
        catch (Exception e)
        {
            handleException(e);
        }
        finally
        {
            DataAccessJavaDb.closeConnection();
        }
    }
    
    @Override
    public void executeUpdate(HashMap<String, String> criteria)
    {
    }
    
    @Override
    public void executeDelete(HashMap<String, String> criteria)
    {
    }
    
    @Override
    public String generateSelectCommand(HashMap<String, String> criteria)
    {
        String command = "SELECT * FROM " + SCHEMA + "." + TABLE_NAME;
        
        if (criteria != null && !criteria.isEmpty())
        {
            String and = "AND ";
            boolean insertAnd = false;
            
            String id = criteria.get(DalFields.ID);
            String key = criteria.get(DalFields.LOOKUPKEY); 
            String value = criteria.get(DalFields.VALUE);
            
            if (!(isNullOrEmpty(id) && isNullOrEmpty(key) && isNullOrEmpty(value)))
            {
                command += "\nWHERE ";
                
                if (!isNullOrEmpty(id))
                {
                    command += DalFields.ID + " = " + id + " "; 
                    insertAnd = true;
                }
                
                if (!isNullOrEmpty(key))
                {
                    if (insertAnd)
                    {
                        command += and;
                    }
                    
                    command += DalFields.LOOKUPKEY + " = '" + key + "' "; 
                    insertAnd = true;
                }
                
                if (!isNullOrEmpty(value))
                {
                    if (insertAnd)
                    {
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
    public String generateInsertCommand(HashMap<String, String> criteria)
    {
        String command = "";
        
        if (!criteria.isEmpty())
        {
            String key = criteria.get(DalFields.LOOKUPKEY); 
            String value = criteria.get(DalFields.VALUE);
            
            if (!isNullOrEmpty(key))
            {                
                command += "INSERT INTO " + SCHEMA + "." + TABLE_NAME + " VALUES (" + ID.newId() + ", '" + key + "', ";
                
                if (!isNullOrEmpty(value))
                {
                    command += "'" + DalFields.VALUE + "')"; 
                }
                else
                {
                    command += "NULL)";
                }
            }
            else
            {
                System.out.println("Required field LOOKUPKEY not set.  Insert  failed.");
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
    public String generateUpdateCommand(HashMap<String, String> criteria)
    {
        return "";
    }
    
    /**
     *
     * @param criteria
     * @return
     */
    @Override
    public String generateDeleteCommand(HashMap<String, String> criteria)
    {
        return "";
    }
}