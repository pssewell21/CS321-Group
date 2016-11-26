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
 * The controller that handles interaction between the view and library.
 *
 * @author Patrick Sewell
 */
public class AccountPersonMapEditViewController extends EditViewControllerBase {

    // <editor-fold defaultstate="collapsed" desc="Member Variables"> 
    /**
     * The object to be created or edited.
     */
    public AccountPersonMap model;

    /**
     * The list of Accounts to be selected from in the view
     */
    public DefaultComboBoxModel<Account> accountListModel;

    /**
     * The list of Persons to be selected from in the view
     */
    public DefaultComboBoxModel<Person> personListModel;

    private final AccountPersonMapFactory accountPersonMapFactory;
    private final PersonFactory personFactory;
    private final AccountFactory accountFactory;
    private AccountPersonMapEditView view;
    private DefaultListModel<AccountPersonMap> listModel;

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Constructors"> 
    /**
     * Initializes the controller.
     */
    public AccountPersonMapEditViewController() {
        accountPersonMapFactory = new AccountPersonMapFactory();
        accountFactory = new AccountFactory();
        personFactory = new PersonFactory();
    }

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Methods"> 
    /**
     * Sets the model, and listModels, and opens the view.
     *
     * @param model The object to be edited
     * @param listModel The list of objects from the list view
     * @param personId The ID of the Person object the record will be for
     */
    public void load(AccountPersonMap model, DefaultListModel<AccountPersonMap> listModel, Long personId) {
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

    @Override
    public void executeSave() {
        doSave();
        view.dispose();
    }

    @Override
    public void executeApply() {
        doSave();
    }

    @Override
    public void executeCancel() {
        view.dispose();
    }

    @Override
    public void executeDelete() {
        //TODO: Add confirmation prompt
        boolean successful = accountPersonMapFactory.executeDelete(model.toHashMap());

        if (successful) {
            listModel.removeElement(model);
            view.dispose();
        }
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

    private void doSave() {
        if (isNew) {
            boolean successful = accountPersonMapFactory.executeInsert(model.toHashMap());

            if (successful) {
                listModel.addElement(model);
                isNew = false;
                view.setDeleteEnabled(true);
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
