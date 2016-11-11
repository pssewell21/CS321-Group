/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

/**
 *
 * @author Owner
 */
public abstract class EditViewControllerBase {
    
    // <editor-fold defaultstate="collapsed" desc="Member Variables"> 
    
    public boolean isNew;
    
    // </editor-fold> 
    
    // <editor-fold defaultstate="collapsed" desc="Methods"> 

    public abstract void executeSave();

    public abstract void executeApply();

    public abstract void executeCancel();

    public abstract void executeDelete();
    
    // </editor-fold> 
}
