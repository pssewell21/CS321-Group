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
 *
 * @author Patrick Sewell
 */
public class AccountPersonMapListViewController extends ListViewControllerBase {

    // <editor-fold defaultstate="collapsed" desc="Member Variables"> 
    /**
     *
     */
    /**
     *
     */
    public DefaultListModel<AccountPersonMap> accountPersonMapListModel;

    /**
     *
     */
    public DefaultComboBoxModel<Person> personListModel;

    private final AccountPersonMapFactory accountPersonMapFactory;
    private final PersonFactory personFactory;
    private AccountPersonMapListView view;

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Constructors"> 

    /**
     *
     */
    public AccountPersonMapListViewController() {
        accountPersonMapFactory = new AccountPersonMapFactory();
        personFactory = new PersonFactory();
    }

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Methods"> 

    /**
     *
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
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
     *
     * @param personId
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
     *
     */
    public void initializeAccountList() {
        accountPersonMapListModel = new DefaultListModel<>();
    }

    /**
     *
     * @param personId
     */
    public void executeAdd(Long personId) {
        AccountPersonMapEditViewController controller = new AccountPersonMapEditViewController();
        controller.load(null, accountPersonMapListModel, personId);
    }

    /**
     *
     * @param item
     * @param personId
     */
    public void executeEdit(AccountPersonMap item, Long personId) {
        AccountPersonMapEditViewController controller = new AccountPersonMapEditViewController();
        controller.load(item, accountPersonMapListModel, personId);
    }

    // </editor-fold>
}
