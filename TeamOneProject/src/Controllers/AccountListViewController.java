/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Library.Account;
import Library.AccountFactory;
import Views.AccountListView;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import javax.swing.DefaultListModel;

/**
 *
 * @author Owner
 */
public class AccountListViewController extends ListViewControllerBase {
    
    // <editor-fold defaultstate="collapsed" desc="Member Variables"> 

    /**
     *
     */
    public AccountListView view;
    
    /**
     *
     */
    public DefaultListModel<Account> listModel;
    
    /**
     *
     */
    public AccountFactory factory;
    
    // </editor-fold> 
    
    // <editor-fold defaultstate="collapsed" desc="Constructors"> 
    
    public AccountListViewController() {
        factory = new AccountFactory();
    }
    
    // </editor-fold> 
    
    // <editor-fold defaultstate="collapsed" desc="Methods"> 

    public void load() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        loadModel();
        
        view = new AccountListView(this);
    }
    
    private void loadModel() {
        HashMap<String, String> criteria = new HashMap<>();
        
        List<Account> result = factory.executeSelect(criteria);

        listModel = new DefaultListModel<>();
        for (Object item : result) {
            listModel.addElement((Account) item);
        }
    }
    
    public void executeAdd() {
        AccountEditViewController controller = new AccountEditViewController();
        controller.load(null, listModel);
    }

    public void executeEdit(Account item) {
        AccountEditViewController controller = new AccountEditViewController();
        controller.load(item, listModel);
    }
    
    // </editor-fold>
}
