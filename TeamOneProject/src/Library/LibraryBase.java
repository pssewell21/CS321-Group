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
public abstract class LibraryBase {

    /**
     *
     */
    public Long Id;

    /**
     *
     */
    protected LibraryBase() {
        Id = ID.newId();
    }
    
    /**
     *
     * @param id
     */
    protected LibraryBase(Long id){
        Id = id;
    }
    
    /**
     *
     * @return
     */
    public abstract HashMap<String, String> toHashMap();
    
    @Override
    public String toString()
    {
        return "ID: " + Id.toString();
    }
}
