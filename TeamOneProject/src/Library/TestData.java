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
    public String lookupKey;

    /**
     *
     */
    public String value;

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
     *
     * @param id
     * @param lookupKey
     * @param value
     */
    public TestData(Long id,
            String lookupKey,
            String value) {
        super(id);
        this.lookupKey = lookupKey;
        this.value = value;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Methods"> 
    @Override
    public String toString() {
        return super.toString() + ", "
                + DalFields.LOOKUP_KEY + ": " + lookupKey + ", "
                + DalFields.VALUE + ": " + value;
    }

    /**
     *
     * @return
     */
    @Override
    public HashMap<String, String> toHashMap() {
        HashMap<String, String> map = new HashMap<>();

        map.put(DalFields.ID, id.toString());
        map.put(DalFields.LOOKUP_KEY, lookupKey);
        map.put(DalFields.VALUE, value);

        return map;
    }

    // </editor-fold>
}
