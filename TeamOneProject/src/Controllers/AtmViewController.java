/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Library.Account;
import Library.AccountFactory;
import Library.AccountTransactionFactory;
import Library.User;
import Views.AtmView;
import java.math.BigDecimal;
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
    
    private User currentUser;

    private final AccountFactory accountFactory;

    private final AccountTransactionFactory accountTransactionFactory;

    public DefaultComboBoxModel<Account> accountModel;

    public Account selectedAccount;

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Constructors"> 
    public AtmViewController() {
        this.accountFactory = new AccountFactory();
        this.accountTransactionFactory = new AccountTransactionFactory();
    }

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Methods"> 
    public void load(User user) {
        currentUser = user;
        
        List<Account> result = accountFactory.executeSelectByUserId(currentUser.Id);
        Account[] accountArray = result.toArray(new Account[]{});
        accountModel = new DefaultComboBoxModel<>(accountArray);

        view = new AtmView(this);
    }

    public void executeQuit() {
        System.exit(0);
    }

    public BigDecimal executeCheckBalance() {
        selectedAccount = accountFactory.executeSelectById(selectedAccount.Id);
        
        return selectedAccount.Balance;
    }

    public void executeDeposit(BigDecimal amount) {
        accountTransactionFactory.addDeposit(currentUser.PersonId, selectedAccount.Id, amount);
    }
    
    public void executeWithdrawal(BigDecimal amount) {
        accountTransactionFactory.addWithdrawal(currentUser.PersonId, selectedAccount.Id, amount);
    }

    // </editor-fold> 
}
