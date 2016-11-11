/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;

import Common.ExceptionHandler;
import Common.Utility;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Owner
 */
public abstract class LibraryFactoryBase implements ISqlGenerator {

    protected final String SCHEMA;
    protected final String TABLE_NAME;

    protected LibraryFactoryBase(String schema, String tableName) {
        SCHEMA = schema;
        TABLE_NAME = tableName;
    }

    /**
     *
     * @param hashMap
     * @return
     */
    public abstract List<? extends LibraryBase> executeSelect(HashMap<String, String> hashMap);

    /**
     *
     * @param hashMap
     */
    public abstract void executeInsert(HashMap<String, String> hashMap);

    /**
     *
     * @param hashMap
     */
    public abstract void executeUpdate(HashMap<String, String> hashMap);

    /**
     *
     * @param hashMap
     */
    public abstract void executeDelete(HashMap<String, String> hashMap);

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
}
