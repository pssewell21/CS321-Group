/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Library.AccountPersonMap;
import Library.AccountPersonMapFactory;
import Views.AccountPersonMapEditView;
import javax.swing.DefaultListModel;

/**
 *
 * @author pssew
 */
public class AccountPersonMapEditViewController extends EditViewControllerBase {
   
    // <editor-fold defaultstate="collapsed" desc="Member Variables"> 

    /**
     *
     */    
    public AccountPersonMap model;

    /**
     *
     */
    public AccountPersonMapEditView view;

    /**
     *
     */
    public AccountPersonMapFactory factory;
    
    private DefaultListModel<AccountPersonMap> listModel;
    
    // </editor-fold> 
    
    // <editor-fold defaultstate="collapsed" desc="Constructors"> 

    /**
     *
     */

    public AccountPersonMapEditViewController() {
        factory = new AccountPersonMapFactory();
    }
    
    // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc="Methods"> 

    /**
     *
     * @param model
     * @param listModel
     */
    
    public void load (AccountPersonMap model, DefaultListModel<AccountPersonMap> listModel) {
        if (model != null) {
            this.model = model;
            isNew = false;
        } else {
            this.model = new AccountPersonMap();
            isNew = true;
        }
        
        this.listModel = listModel;

        view = new AccountPersonMapEditView(this);

        view.setDeleteEnabled(!isNew);
    }

    /**
     *
     */
    @Override
    public void executeSave() {
        doSave();
        view.dispose();
    }

    /**
     *
     */
    @Override
    public void executeApply() {
        doSave();
        isNew = false;
        view.setDeleteEnabled(true);
    }

    /**
     *
     */
    @Override
    public void executeCancel() {
        view.dispose();
    }

    /**
     *
     */
    @Override
    public void executeDelete() {
        //TODO: Add confirmation prompt
        boolean successful = factory.executeDelete(model.toHashMap());
        
        if (successful) {
            listModel.removeElement(model);
            view.dispose();
        }
    }

    private void doSave() {
        if (isNew) {
            boolean successful = factory.executeInsert(model.toHashMap());
            
            if (successful) {
                listModel.addElement(model);
            }
        } else {
            boolean successful = factory.executeUpdate(model.toHashMap());
            
            if (!successful) {
                //TODO: rollback changes in some way
            }
        }      
    }
    
    // </editor-fold>
}
