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

import Library.Account;
import Library.AccountFactory;
import Library.Person;
import Library.PersonFactory;
import Views.AccountEditView;
import java.util.HashMap;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

/**
 *
 * @author Owner
 */
public class AccountEditViewController extends EditViewControllerBase {
   
    // <editor-fold defaultstate="collapsed" desc="Member Variables"> 

    /**
     *
     */    
    public Account model;

    /**
     *
     */
    public DefaultComboBoxModel<Person> personModel;
        
    private final AccountFactory accountFactory;
    private final PersonFactory personFactory;
    private AccountEditView view;
    private DefaultListModel<Account> listModel;
    
    // </editor-fold> 
    
    // <editor-fold defaultstate="collapsed" desc="Constructors"> 

    /**
     *
     */

    public AccountEditViewController() {
        accountFactory = new AccountFactory();
        personFactory = new PersonFactory();
    }
    
    // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc="Methods"> 

    /**
     *
     * @param model
     * @param listModel
     */
    
    public void load (Account model, DefaultListModel<Account> listModel) {
        if (model != null) {
            this.model = model;
            isNew = false;
        } else {
            this.model = new Account();
            isNew = true;
        }
        
        this.listModel = listModel;
        
        HashMap<String, String> criteria = new HashMap<>();
        List<Person> result = personFactory.executeSelect(criteria);
        Person[] personArray = result.toArray(new Person[]{});
        personModel = new DefaultComboBoxModel<>(personArray);

        view = new AccountEditView(this);

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
        boolean successful = accountFactory.executeDelete(model.toHashMap());
        
        if (successful) {
            listModel.removeElement(model);
            view.dispose();
        }
    }

    private void doSave() {
        if (isNew) {
            boolean successful = accountFactory.executeInsert(model.toHashMap());
            
            if (successful) {
                listModel.addElement(model);
                isNew = false;
                view.setDeleteEnabled(true);
            }
        } else {
            boolean successful = accountFactory.executeUpdate(model.toHashMap());
            
            if (!successful) {
                //TODO: rollback changes in some way
            }
        }      
    }
    
    // </editor-fold>  
}
