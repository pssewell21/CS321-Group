/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;

import Common.ID;
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
    public Long id;

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Constructors"> 
    /**
     *
     */
    protected LibraryBase() {
        id = ID.newId();
    }

    /**
     *
     * @param id
     */
    protected LibraryBase(Long id) {
        this.id = id;
    }

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Methods"> 
    /**
     *
     * @return
     */
    public abstract HashMap<String, String> toHashMap();

    @Override
    public String toString() {
        return "ID: " + id.toString();
    }

    // </editor-fold> 
}
