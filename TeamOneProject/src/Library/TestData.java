/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;

import UI.Common.IdGenerator;
import java.math.BigInteger;

/**
 *
 * @author Owner
 */
public class TestData extends LibraryBase
{
    public BigInteger Id;
    public String Key;
    public String Value;
        
    public TestData(String key)
    {
        super();
        Key = key;
    }
    
    public TestData(String key, String value)
    {
        this(key);
        Value = value;
    }
    
    public void setValue(String value)
    {
        Value = value;
    }
    
    public String toString()
    {
        return "ID: " + Id.toString() + ", Key: " + Key + ", Value: " + Value;
    }
}
