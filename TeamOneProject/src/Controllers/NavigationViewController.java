/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Common.ExceptionHandler;
import Views.NavigationView;
import java.sql.SQLException;

/**
 *
 * @author Owner
 */
public class NavigationViewController {
    // <editor-fold defaultstate="collapsed" desc="Member Variables"> 
    
    public NavigationView view;
    
    // </editor-fold> 
    
    // <editor-fold defaultstate="collapsed" desc="Constructors"> 
    
    public NavigationViewController() {
    }
    
    // </editor-fold> 
       
    // <editor-fold defaultstate="collapsed" desc="Methods"> 

    public void load() {        
        view = new NavigationView(this);
    }
    
    public void executeNavigateTestDataList() {
        try {
            TestDataListViewController t = new TestDataListViewController();
            t.load();
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            ExceptionHandler.handleException(e);
        }
    }
    
    // </editor-fold> 
}