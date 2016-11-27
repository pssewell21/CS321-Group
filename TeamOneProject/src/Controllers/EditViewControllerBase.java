/*
 * Copyright 2016 AUTHORS. Patrick S Sewell, Paul M Dyer, Taehyeok Lee, 
 * Benjamin C Ferguson, Hyunki J KIm Permission is granted to copy, distribute 
 * and/or modify this document under the terms of the GNU Free Documentation 
 * License, Version 1.3, (3 November 2008) or any later version published by 
 * the Free Software Foundation; with no Invariant Sections, with no 
 * Front-Cover Texts, and with no Back-Cover Texts. A copy of the license 
 * can be found at http://www.gnu.org/copyleft/fdl.html
 */
package Controllers;

/**
 * The class that defines the contract to be fulfilled by edit view controllers.
 *
 * @author Patrick Sewell
 */
public abstract class EditViewControllerBase {

    // <editor-fold defaultstate="collapsed" desc="Member Variables"> 
    /**
     * The value that describes if the record is new.
     */
    protected boolean isNew;

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Methods"> 
    /**
     * Saves the object and closes the view.
     */
    public abstract void executeSave();

    /**
     * Saves changes to the object and does not close the view.
     */
    public abstract void executeApply();

    /**
     * Closes the view without saving any changes.
     */
    public abstract void executeCancel();

    /**
     * Deletes the object.
     */
    public abstract void executeDelete();

    // </editor-fold> 
}
