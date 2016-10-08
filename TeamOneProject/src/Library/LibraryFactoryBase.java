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
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
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
            ResultSet resultSet = DataAccessJavaDb.executeSelect(generateSelect(hashMap));
            ResultSetMetaData metaData = resultSet.getMetaData();
        
            resultSet.            
            for (int i = 1; i <= metaData.getColumnCount(); i++)
            {
                System.out.printf("%-10s\t", metaData.getColumnName(i));
            }
            
            System.out.println();
           
            while (resultSet.next())
            {
                for (int i = 1; i <= metaData.getColumnCount(); i++)
                {
                    System.out.printf("%-10s\t", resultSet.getObject(i));
                }
                
                System.out.println();
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
    
    protected boolean isNullOrEmpty(String string)
    {
        return Utility.isNullOrEmpty(string);
    }
    
    protected void handleException(Exception e)
    {
        ExceptionHandler.handleException(e);
    }
}
