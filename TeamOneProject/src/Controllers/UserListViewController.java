/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Library.User;
import Library.UserFactory;
import Views.UserListView;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import javax.swing.DefaultListModel;

/**
 *
 * @author Owner
 */
public class UserListViewController extends ListViewControllerBase {
    
    // <editor-fold defaultstate="collapsed" desc="Member Variables"> 

    /**
     *
     */
    public UserListView view;
    
    /**
     *
     */
    public DefaultListModel<User> listModel;
    
    /**
     *
     */
    public UserFactory factory;
    
    // </editor-fold> 
    
    // <editor-fold defaultstate="collapsed" desc="Constructors"> 
    
    public UserListViewController() {
        factory = new UserFactory();
    }
    
    // </editor-fold> 
    
    // <editor-fold defaultstate="collapsed" desc="Methods"> 

    public void load() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        loadModel();
        
        view = new UserListView(this);
    }
    
    private void loadModel() {
        HashMap<String, String> criteria = new HashMap<>();
        
        List<User> result = factory.executeSelect(criteria);

        listModel = new DefaultListModel<>();
        for (Object item : result) {
            listModel.addElement((User) item);
        }
    }
    
    public void executeAdd() {
        UserEditViewController controller = new UserEditViewController();
        controller.load(null, listModel);
    }

    public void executeEdit(User item) {
        UserEditViewController controller = new UserEditViewController();
        controller.load(item, listModel);
    }
    
    // </editor-fold>
}
