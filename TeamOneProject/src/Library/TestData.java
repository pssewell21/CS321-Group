/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;

import java.util.HashMap;

/**
 *
 * @author Owner
 */
public class TestData extends LibraryBase
{
    public String LookupKey;
    public String Value;
    
    public TestData()
    {
        super();
    }
        
    public TestData(String lookupKey)
    {
        this();
        LookupKey = lookupKey;
    }
    
    public TestData(String lookupKey, String value)
    {
        this(lookupKey);
        Value = value;
    }
    
    public TestData(Long id, String lookupKey, String value)
    {
        Id = id;
        LookupKey = lookupKey;
        Value = value;
    }
    
    public void setValue(String value)
    {
        Value = value;
    }
    
    @Override
    public String toString()
    {
        return "ID: " + Id.toString() + ", LookupKey: " + LookupKey + ", Value: " + Value;
    }
    
    public HashMap<String, String> toHashMap()
    {
        HashMap<String, String> map = new HashMap<>();
        map.put(DalFields.ID, Id.toString());
        map.put(DalFields.LOOKUPKEY, LookupKey);
        map.put(DalFields.VALUE, Value);
        
        return map;
    }
}
