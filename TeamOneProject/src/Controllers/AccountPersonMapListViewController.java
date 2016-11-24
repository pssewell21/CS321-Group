/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 * @author pssew
 */
public class AccountPersonMapListViewController extends ListViewControllerBase {
    
    // <editor-fold defaultstate="collapsed" desc="Member Variables"> 

    /**
     *
     */
    public AccountPersonMapListView view;
    
    /**
     *
     */
    public DefaultListModel<AccountPersonMap> accountPersonMapListModel;
    
    /**
     *
     */
    public AccountPersonMapFactory accountPersonMapFactory;
    
    /**
     *
     */
    public DefaultComboBoxModel<Person> personListModel;
    
    /**
     *
     */
    public PersonFactory personFactory;
    
    // </editor-fold> 
    
    // <editor-fold defaultstate="collapsed" desc="Constructors"> 
    
    public AccountPersonMapListViewController() {
        accountPersonMapFactory = new AccountPersonMapFactory();
        personFactory = new PersonFactory();
    }
    
    // </editor-fold> 
    
    // <editor-fold defaultstate="collapsed" desc="Methods"> 

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
    
    public void loadAccountList(Long personId) {
        HashMap<String, String> criteria = new HashMap<>();
        criteria.put(DalFields.PERSON_ID, personId.toString());
        
        List<AccountPersonMap> result = accountPersonMapFactory.executeSelect(criteria);

        accountPersonMapListModel = new DefaultListModel<>();
        for (Object item : result) {
            accountPersonMapListModel.addElement((AccountPersonMap) item);
        } 
    }
    
    public void initializeAccountList() {
        accountPersonMapListModel = new DefaultListModel<>();
    }
    
    public void executeAdd(Long personId) {
        AccountPersonMapEditViewController controller = new AccountPersonMapEditViewController();
        controller.load(null, accountPersonMapListModel, personId);
    }

    public void executeEdit(AccountPersonMap item, Long personId) {
        AccountPersonMapEditViewController controller = new AccountPersonMapEditViewController();
        controller.load(item, accountPersonMapListModel, personId);
    }      
    
    // </editor-fold>
}
