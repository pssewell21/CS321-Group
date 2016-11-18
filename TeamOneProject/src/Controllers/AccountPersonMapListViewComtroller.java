/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Library.AccountPersonMap;
import Library.AccountPersonMapFactory;
import Views.AccountPersonMapListView;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import javax.swing.DefaultListModel;

/**
 *
 * @author pssew
 */
public class AccountPersonMapListViewComtroller extends ListViewControllerBase {
//    
//    // <editor-fold defaultstate="collapsed" desc="Member Variables"> 
//
//    /**
//     *
//     */
//    public AccountPersonMapListView view;
//    
//    /**
//     *
//     */
//    public DefaultListModel<AccountPersonMap> listModel;
//    
//    /**
//     *
//     */
//    public AccountPersonMapFactory factory;
//    
//    // </editor-fold> 
//    
//    // <editor-fold defaultstate="collapsed" desc="Constructors"> 
//    
//    public AccountPersonMapListViewComtroller() {
//        factory = new AccountPersonMapFactory();
//    }
//    
//    // </editor-fold> 
//    
//    // <editor-fold defaultstate="collapsed" desc="Methods"> 
//
//    public void load() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
//        loadModel();
//        
//        view = new AccountPersonMapListView(this);
//    }
//    
//    private void loadModel() {
//        HashMap<String, String> criteria = new HashMap<>();
//        
//        List<AccountPersonMap> result = factory.executeSelect(criteria);
//
//        listModel = new DefaultListModel<>();
//        for (Object item : result) {
//            listModel.addElement((AccountPersonMap) item);
//        }
//    }
//    
//    public void executeAdd() {
//        PersonEditViewController controller = new PersonEditViewController();
//        controller.load(null, listModel);
//    }
//
//    public void executeEdit(AccountPersonMap item) {
//        PersonEditViewController controller = new PersonEditViewController();
//        controller.load(item, listModel);
//    }
//    
//    // </editor-fold>
}
