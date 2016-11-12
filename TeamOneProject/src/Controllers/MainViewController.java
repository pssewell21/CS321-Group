/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Database.DatabaseProvisioner;
import Library.DalFields;
import Library.TestData;
import Library.User;
import Library.UserFactory;
import Views.MainView;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Owner
 */
public class MainViewController {
    
    // <editor-fold defaultstate="collapsed" desc="Member Variables"> 
    
    public MainView view;
    
    /**
     *
     */
    public UserFactory factory;
    
    // </editor-fold> 
    
    // <editor-fold defaultstate="collapsed" desc="Constructors"> 
    
    public MainViewController() {
        factory = new UserFactory();
    }
    
    // </editor-fold> 
       
    // <editor-fold defaultstate="collapsed" desc="Methods"> 

    public void load() {        
        view = new MainView(this);
    }
    
    /**
     *
     * @param userName
     * @param password
     * @return
     */
    public boolean executeLogOn(String userName, String password) {
        HashMap<String, String> criteria = new HashMap<>();
        criteria.put(DalFields.USER_NAME, userName);
        
        // Will return a list of 0 or 1 items
        List<User> result = factory.executeSelect(criteria);
        
        if (result.isEmpty())
        {
            return false;
        }
        
        User user = result.get(0);
        
        return user.Password.equals(password);
    }
    
    public void executeProvisionDatabase() {
        //TODO: Add confirmation box with warning
        DatabaseProvisioner.provisionDatabase();
    }
    
    // </editor-fold> 
}
