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

import Library.AccountPersonMap;
import Library.AccountPersonMapFactory;
import Library.DalFields;
import Library.Person;
import Library.PersonFactory;
import Views.AccountPersonMapListView;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

/**
 * The controller that handles interaction between the view and library.
 *
 * @author Patrick Sewell
 */
public class AccountPersonMapListViewController extends ListViewControllerBase {

    // <editor-fold defaultstate="collapsed" desc="Member Variables"> 
    /**
     * The listModel that holds objects displayed in the listView.
     */
    public DefaultListModel<AccountPersonMap> accountPersonMapListModel;

    /**
     * The list of Persons to be selected from in the view.
     */
    public DefaultComboBoxModel<Person> personListModel;

    private final AccountPersonMapFactory accountPersonMapFactory;
    private final PersonFactory personFactory;
    private AccountPersonMapListView view;

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Constructors"> 
    /**
     * Initializes the controller.
     */
    public AccountPersonMapListViewController() {
        accountPersonMapFactory = new AccountPersonMapFactory();
        personFactory = new PersonFactory();
    }

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Methods"> 
    /**
     * Sets the listModel, and opens the view.
     *
     * @throws SQLException If an SQL error occurs
     * @throws ClassNotFoundException If a Class cannot be found
     * @throws InstantiationException If an object cannot be instantiated
     * @throws IllegalAccessException If access cannot be given
     */
    public void load() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        loadPersonList();
        initializeAccountList();

        view = new AccountPersonMapListView(this);
    }

    private void loadPersonList() {
        HashMap<String, String> criteria = new HashMap<>();

        List<Person> result = personFactory.executeSelect(criteria);

        personListModel = new DefaultComboBoxModel<>();
        for (Object item : result) {
            personListModel.addElement((Person) item);
        }
    }

    /**
     * Loads the list of Account objects link to a Person.
     *
     * @param personId The ID of the Person the accounts are linked to
     */
    public void loadAccountList(Long personId) {
        HashMap<String, String> criteria = new HashMap<>();
        criteria.put(DalFields.PERSON_ID, personId.toString());

        List<AccountPersonMap> result = accountPersonMapFactory.executeSelect(criteria);

        accountPersonMapListModel = new DefaultListModel<>();
        for (Object item : result) {
            accountPersonMapListModel.addElement((AccountPersonMap) item);
        }
    }

    /**
     * Creates an empty listModel which AccountPeronMap objects will be added
     * to.
     */
    public void initializeAccountList() {
        accountPersonMapListModel = new DefaultListModel<>();
    }

    /**
     * Opens the edit view to create a new object.
     *
     * @param personId The ID of the Person
     */
    public void executeAdd(Long personId) {
        AccountPersonMapEditViewController controller = new AccountPersonMapEditViewController();
        controller.load(null, accountPersonMapListModel, personId);
    }

    /**
     * Opens the edit view to modify an existing object.
     *
     * @param item The object to be modified
     * @param personId The ID of the Person to link to Accounts
     */
    public void executeEdit(AccountPersonMap item, Long personId) {
        AccountPersonMapEditViewController controller = new AccountPersonMapEditViewController();
        controller.load(item, accountPersonMapListModel, personId);
    }

    // </editor-fold>
}
