/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Views.MainView;
import Views.TestDataListView;
import java.sql.SQLException;

/**
 *
 * @author Owner
 */
public class MainViewController {
    
    // <editor-fold defaultstate="collapsed" desc="Member Variables"> 
    
    public MainView view;
    
    // </editor-fold> 
       
    // <editor-fold defaultstate="collapsed" desc="Methods"> 

    public void load() {        
        view = new MainView(this);
    }
    
    // </editor-fold> 
}
