/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Library.Account;
import Library.AccountFactory;
import Library.DalFields;
import Library.Person;
import Library.User;
import Views.AtmView;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Owner
 */
public class AtmViewController {
    // <editor-fold defaultstate="collapsed" desc="Member Variables"> 

    /**
     *
     */
    
    public AtmView view;
    
    private final AccountFactory accountFactory;
    
    public DefaultComboBoxModel<Account> accountModel;
    
    public Account selectedAccount;
    
    // </editor-fold> 
    
    // <editor-fold defaultstate="collapsed" desc="Constructors"> 
    
    public AtmViewController() {
        this.accountFactory = new AccountFactory();
    }
    
    // </editor-fold> 
    
    // <editor-fold defaultstate="collapsed" desc="Methods"> 

    public void load(User user) {
        List<Account> result = accountFactory.executeSelectByUserId(user.Id);
        Account[] accountArray = result.toArray(new Account[]{});
        accountModel = new DefaultComboBoxModel<>(accountArray);
        
        view = new AtmView(this);
    }
    
    public void executeQuit() {
        System.exit(0);
    }
    
    public BigDecimal executeCheckBalance() {
        return selectedAccount.Balance;
    }
    
    // </editor-fold> 
}
