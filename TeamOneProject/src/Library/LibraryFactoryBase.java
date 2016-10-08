/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;

import DataAccess.DataAccessJavaDb;
import UI.Common.ExceptionHandler;
import UI.Common.IdGenerator;
import UI.Common.Utility;
import java.math.BigInteger;
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
    
    protected List<LibraryBase> executeSelect(HashMap hashMap)
    {
        DataAccessJavaDb.openConnection();
        
        try
        {
            DataAccessJavaDb.executeSelect(generateSelect(hashMap));
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
    
    protected boolean isNullOrEmpty(String string)
    {
        return Utility.isNullOrEmpty(string);
    }
    
    protected void handleException(Exception e)
    {
        ExceptionHandler.handleException(e);
    }
}
