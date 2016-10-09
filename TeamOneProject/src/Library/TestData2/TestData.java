/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library.TestData2;

import Library.LibraryBase;

/**
 *
 * @author Owner
 */
public class TestData extends LibraryBase
{
    public Long Id;
    public String Key;
    public String Value;
    
    public TestData()
    {
        super();
    }
        
    public TestData(String key)
    {
        this();
        Key = key;
    }
    
    public TestData(String key, String value)
    {
        this(key);
        Value = value;
    }
    
    public TestData(Long id, String key, String value)
    {
        Id = id;
        Key = key;
        Value = value;
    }
    
    public void setValue(String value)
    {
        Value = value;
    }
    
    @Override
    public String toString()
    {
        return "ID: " + Id.toString() + ", Key: " + Key + ", Value: " + Value;
    }
}
