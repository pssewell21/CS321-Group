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
public class TestData extends LibraryBase {

    // <editor-fold defaultstate="collapsed" desc="Member Variables">   

    /**
     *
     */
    
    public String LookupKey;

    /**
     *
     */
    public String Value;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructors"> 

    /**
     * This constructor is used for creating new objects
     */
    
    public TestData() {
        super();
    }

    /**
     * This constructor is used for mapping existing objects
     * @param id
     * @param lookupKey
     * @param value
     */
    public TestData(Long id, String lookupKey, String value) {
        super(id);
        LookupKey = lookupKey;
        Value = value;
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Methods"> 

    @Override
    public String toString() {
        return super.toString() + ", " 
                + DalFields.LOOKUP_KEY + ": " + LookupKey 
                + ", " + DalFields.VALUE + ": " + Value;
    }

    /**
     *
     * @return
     */
    @Override
    public HashMap<String, String> toHashMap() {
        HashMap<String, String> map = new HashMap<>();
        
        map.put(DalFields.ID, Id.toString());
        map.put(DalFields.LOOKUP_KEY, LookupKey);
        map.put(DalFields.VALUE, Value);

        return map;
    }
    
    // </editor-fold>
}
