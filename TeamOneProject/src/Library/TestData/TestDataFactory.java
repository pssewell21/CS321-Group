/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library.TestData;

import Library.Constants.DalFields;
import Library.LibraryFactoryBase;
import java.util.HashMap;

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
    
    public String generateSelect(HashMap<String, String> criteria)
    {
        String command = "SELECT * FROM " + SCHEMA + "." + TABLE_NAME;
        
        if (!criteria.isEmpty())
        {
            String id = criteria.get(DalFields.ID);
            String key = criteria.get(DalFields.KEY); 
            String value = criteria.get(DalFields.VALUE);
            
            if (!(isNullOrEmpty(id) && isNullOrEmpty(key) && isNullOrEmpty(value)))
            {
                command += "\nWHERE ";
                
                if (!id.isEmpty())
                {
                    command += DalFields.ID + " = " + id + " "; 
                }
                
                if (!key.isEmpty())
                {
                    command += DalFields.KEY + " = '" + key + "' "; 
                }
                
                if (!value.isEmpty())
                {
                    command += DalFields.VALUE + " = '" + value + "' "; 
                }
            }
        }
        
        return command;
    }
    
    public String generateInsert(HashMap<String, String> criteria)
    {
        return "";
    }
    
    public String generateUpdate(HashMap<String, String> criteria)
    {
        return "";
    }
    
    public String generateDelete(HashMap<String, String> criteria)
    {
        return "";
    }
}