/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;

import UI.Common.ExceptionHandler;
import UI.Common.Utility;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Owner
 */
public abstract class LibraryFactoryBase implements ISqlGenerator
{
    public String SCHEMA;
    public String TABLE_NAME;
    
    protected LibraryFactoryBase(String schema, String tableName)
    {
        SCHEMA = schema;
        TABLE_NAME = tableName;
    }
    
    public abstract List<LibraryBase> executeSelect(HashMap<String, String> hashMap);
    
    public abstract void executeInsert(HashMap<String, String> hashMap);
    
    public abstract void executeUpdate(HashMap<String, String> hashMap);
    
    public abstract void executeDelete(HashMap<String, String> hashMap);
    
    protected boolean isNullOrEmpty(String string)
    {
        return Utility.isNullOrEmpty(string);
    }
    
    protected void handleException(Exception e)
    {
        ExceptionHandler.handleException(e);
    }
}
