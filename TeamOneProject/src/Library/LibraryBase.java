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

    // <editor-fold defaultstate="collapsed" desc="Member Variables"> 
    
    /**
     *
     */
    public Long Id;
    
    // </editor-fold> 
    
    // <editor-fold defaultstate="collapsed" desc="Constructors"> 

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
    
    // </editor-fold> 
    
    // <editor-fold defaultstate="collapsed" desc="Methods"> 
    
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
    
    // </editor-fold> 
}
