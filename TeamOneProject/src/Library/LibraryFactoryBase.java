/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;

import UI.ExceptionHandler;
import UI.Utility;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Owner
 */
public abstract class LibraryFactoryBase implements ISqlGenerator {

    public String SCHEMA;
    public String TABLE_NAME;

    protected LibraryFactoryBase(String schema, String tableName) {
        SCHEMA = schema;
        TABLE_NAME = tableName;
    }

    public abstract List<? extends LibraryBase> executeSelect(HashMap<String, String> hashMap);

    public abstract void executeInsert(HashMap<String, String> hashMap);

    public abstract void executeUpdate(HashMap<String, String> hashMap);

    public abstract void executeDelete(HashMap<String, String> hashMap);

    protected boolean hasValue(String string) {
        return Utility.hasValue(string);
    }

    protected void handleException(Exception e) {
        ExceptionHandler.handleException(e);
    }
}
