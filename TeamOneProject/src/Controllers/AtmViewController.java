/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Common.UserSettings;
import Library.Account;
import Library.AccountFactory;
import Library.AccountTransaction;
import Library.AccountTransactionFactory;
import Library.User;
import Library.UserFactory;
import Views.AtmView;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

/**
 *
 * @author Owner
 */
public class AtmViewController {
    // <editor-fold defaultstate="collapsed" desc="Member Variables"> 

    /**
     *
     */
    public DefaultListModel<AccountTransaction> transactionListModel;

    /**
     *
     */
    public DefaultComboBoxModel<Account> accountModel;

    public Account selectedAccount;

    private final AccountFactory accountFactory;
    private final AccountTransactionFactory accountTransactionFactory;
    private final UserFactory userFactory;
    private AtmView view;
    private User currentUser;

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Constructors"> 
    public AtmViewController() {
        this.accountFactory = new AccountFactory();
        this.accountTransactionFactory = new AccountTransactionFactory();
        this.userFactory = new UserFactory();
    }

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Methods"> 
    public void load(User user) {
        currentUser = user;

        List<Account> result = accountFactory.getByUserId(currentUser.id);
        Account[] accountArray = result.toArray(new Account[]{});
        accountModel = new DefaultComboBoxModel<>(accountArray);

        view = new AtmView(this);
    }

    public void executeQuit() {
        System.exit(0);
    }

    public BigDecimal executeCheckBalance() {
        selectedAccount = accountFactory.getById(selectedAccount.id);

        return selectedAccount.balance;
    }

    public void executeDeposit(BigDecimal amount) {
        accountTransactionFactory.addDeposit(currentUser.personId, selectedAccount.id, amount);
    }

    public boolean executeWithdrawal(BigDecimal amount) {
        if (selectedAccount.balance.compareTo(amount) > 0) {
            accountTransactionFactory.addWithdrawal(currentUser.personId, selectedAccount.id, amount);
            return true;
        } else {
            return false;
        }
    }

    public void executeGetTransactionHistory(Timestamp startTime, Timestamp endTime) {
        List<AccountTransaction> result = accountTransactionFactory.getByAccoundIdAndTimestampRange(selectedAccount.id, startTime, endTime);

        transactionListModel = new DefaultListModel<>();
        for (Object item : result) {
            transactionListModel.addElement((AccountTransaction) item);
        }
    }

    public void executeSelectTheme(String selectedTheme) {
        currentUser.selectedTheme = selectedTheme;
        userFactory.executeUpdate(currentUser.toHashMap());

        UserSettings.setSelectedTheme(selectedTheme);
    }

    public String getSelectedTheme() {
        return currentUser.selectedTheme;
    }

    // </editor-fold> 
}
