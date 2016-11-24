/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Library.Account;
import Library.AccountFactory;
import Library.AccountPersonMap;
import Library.AccountPersonMapFactory;
import Library.DalFields;
import Library.Person;
import Library.PersonFactory;
import Views.AccountPersonMapEditView;
import java.util.HashMap;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
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
    public AccountPersonMapFactory accountPersonMapFactory;
    
    /**
     *
     */
    public PersonFactory personFactory;
    
    /**
     *
     */
    public AccountFactory accountFactory;
    
    public DefaultComboBoxModel<Account> accountListModel;    
    
    public DefaultComboBoxModel<Person> personListModel;
    
    private DefaultListModel<AccountPersonMap> listModel;
    
    // </editor-fold> 
    
    // <editor-fold defaultstate="collapsed" desc="Constructors"> 

    /**
     *
     */

    public AccountPersonMapEditViewController() {
        accountPersonMapFactory = new AccountPersonMapFactory();
        accountFactory = new AccountFactory();
        personFactory = new PersonFactory();
    }
    
    // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc="Methods"> 

    /**
     *
     * @param model
     * @param listModel
     * @param personId
     */
    
    public void load (AccountPersonMap model, DefaultListModel<AccountPersonMap> listModel, Long personId) {
        if (model != null) {
            this.model = model;
            isNew = false;
        } else {
            this.model = new AccountPersonMap();
            isNew = true;
        }
                
        this.listModel = listModel;
        
        loadPersonList(personId);
        loadAccountList();

        view = new AccountPersonMapEditView(this);

        view.setDeleteEnabled(!isNew);
    }
    
    private void loadPersonList(Long personId) {
        HashMap<String, String> criteria = new HashMap<>();
        criteria.put(DalFields.ID, personId.toString());
        
        List<Person> result = personFactory.executeSelect(criteria);

        personListModel = new DefaultComboBoxModel<>();
        for (Object item : result) {
            personListModel.addElement((Person) item);
        }
    }
    
    private void loadAccountList() {
        HashMap<String, String> criteria = new HashMap<>();
        
        List<Account> result = accountFactory.executeSelect(criteria);

        accountListModel = new DefaultComboBoxModel<>();
        for (Object item : result) {
            accountListModel.addElement((Account) item);
        }
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
        boolean successful = accountPersonMapFactory.executeDelete(model.toHashMap());
        
        if (successful) {
            listModel.removeElement(model);
            view.dispose();
        }
    }

    private void doSave() {
        if (isNew) {
            boolean successful = accountPersonMapFactory.executeInsert(model.toHashMap());
            
            if (successful) {
                listModel.addElement(model);
            }
        } else {
            boolean successful = accountPersonMapFactory.executeUpdate(model.toHashMap());
            
            if (!successful) {
                //TODO: rollback changes in some way
            }
        }      
    }
    
    // </editor-fold>
}
