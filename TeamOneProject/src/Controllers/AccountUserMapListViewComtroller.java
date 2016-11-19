/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Library.AccountUserMap;
import Library.AccountUserMapFactory;
import Views.AccountUserMapListView;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import javax.swing.DefaultListModel;

/**
 *
 * @author pssew
 */
public class AccountUserMapListViewComtroller extends ListViewControllerBase {
//    
//    // <editor-fold defaultstate="collapsed" desc="Member Variables"> 
//
//    /**
//     *
//     */
//    public AccountUserMapListView view;
//    
//    /**
//     *
//     */
//    public DefaultListModel<AccountPersonMap> listModel;
//    
//    /**
//     *
//     */
//    public AccountUserMapFactory factory;
//    
//    // </editor-fold> 
//    
//    // <editor-fold defaultstate="collapsed" desc="Constructors"> 
//    
//    public AccountUserMapListViewComtroller() {
//        factory = new AccountUserMapFactory();
//    }
//    
//    // </editor-fold> 
//    
//    // <editor-fold defaultstate="collapsed" desc="Methods"> 
//
//    public void load() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
//        loadModel();
//        
//        view = new AccountUserMapListView(this);
//    }
//    
//    private void loadModel() {
//        HashMap<String, String> criteria = new HashMap<>();
//        
//        List<AccountPersonMap> result = factory.executeSelect(criteria);
//
//        listModel = new DefaultListModel<>();
//        for (Object item : result) {
//            listModel.addElement((AccountUserMap) item);
//        }
//    }
//    
//    public void executeAdd() {
//        PersonEditViewController controller = new PersonEditViewController();
//        controller.load(null, listModel);
//    }
//
//    public void executeEdit(AccountUserMap item) {
//        PersonEditViewController controller = new PersonEditViewController();
//        controller.load(item, listModel);
//    }
//    
//    // </editor-fold>
}
