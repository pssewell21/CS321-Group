/*
 * Copyright 2016 AUTHORS. Patrick S Sewell, Paul M Dyer, Taehyeok Lee, 
 * Benjamin C Ferguson, Hyunki J KIm Permission is granted to copy, distribute 
 * and/or modify this document under the terms of the GNU Free Documentation 
 * License, Version 1.3, (3 November 2008) or any later version published by 
 * the Free Software Foundation; with no Invariant Sections, with no 
 * Front-Cover Texts, and with no Back-Cover Texts. A copy of the license 
 * can be found at http://www.gnu.org/copyleft/fdl.html
 */
package Library;

import Common.ID;
import java.util.HashMap;

/**
 * The class that defines the contract for Library objects.
 * @author Patrick Sewell
 */
public abstract class LibraryBase {

    // <editor-fold defaultstate="collapsed" desc="Member Variables"> 
    /**
     * The ID of the object.
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
     * Creates a HashMap that contains all of the fields on an object.
     * @return The HashMap describing the object
     */
    public abstract HashMap<String, String> toHashMap();

    @Override
    public String toString() {
        return "ID: " + id.toString();
    }

    // </editor-fold> 
}
