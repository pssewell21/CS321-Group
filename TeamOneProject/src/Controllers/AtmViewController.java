/*
 * Copyright 2016 AUTHORS. Patrick S Sewell, Paul M Dyer, Taehyeok Lee, 
 * Benjamin C Ferguson, Hyunki J KIm Permission is granted to copy, distribute 
 * and/or modify this document under the terms of the GNU Free Documentation 
 * License, Version 1.3, (3 November 2008) or any later version published by 
 * the Free Software Foundation; with no Invariant Sections, with no 
 * Front-Cover Texts, and with no Back-Cover Texts. A copy of the license 
 * can be found at http://www.gnu.org/copyleft/fdl.html
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
 * The controller that handles interaction between the view and library.
 *
 * @author Patrick Sewell
 */
public class AtmViewController {
    // <editor-fold defaultstate="collapsed" desc="Member Variables"> 

    /**
     * The listModel that holds objects displayed in the Transaction History
     * tab.
     */
    public DefaultListModel<AccountTransaction> transactionListModel;

    /**
     * The list of Accounts to be selected from in the view.
     */
    public DefaultComboBoxModel<Account> accountModel;

    /**
     * The selected Account object.
     */
    public Account selectedAccount;

    private final AccountFactory accountFactory;
    private final AccountTransactionFactory accountTransactionFactory;
    private final UserFactory userFactory;
    private AtmView view;
    private User currentUser;

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Constructors"> 
    /**
     * Initializes the controller.
     */
    public AtmViewController() {
        this.accountFactory = new AccountFactory();
        this.accountTransactionFactory = new AccountTransactionFactory();
        this.userFactory = new UserFactory();
    }

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Methods"> 
    /**
     * Loads the AtmView.
     *
     * @param user The User that is currently logged in to the application
     */
    public void load(User user) {
        currentUser = user;

        List<Account> result = accountFactory.getByUserId(currentUser.id);
        Account[] accountArray = result.toArray(new Account[]{});
        accountModel = new DefaultComboBoxModel<>(accountArray);

        view = new AtmView(this);
    }

    /**
     * Exits the application.
     */
    public void executeQuit() {
        System.exit(0);
    }

    /**
     * Gets the current balance for the currently selected Account.
     *
     * @return The current balance for the currently selected Account
     */
    public BigDecimal executeCheckBalance() {
        selectedAccount = accountFactory.getById(selectedAccount.id);

        return selectedAccount.balance;
    }

    /**
     * Adds funds to the currently selected Account.
     *
     * @param amount The amount to add to the Account balance
     */
    public void executeDeposit(BigDecimal amount) {
        accountTransactionFactory.addDeposit(currentUser.personId, selectedAccount.id, amount);
    }

    /**
     * Withdraws funds from the currently selected Account.
     *
     * @param amount The amount to withdraw from the Account balance
     * @return
     */
    public boolean executeWithdrawal(BigDecimal amount) {
        if (selectedAccount.balance.compareTo(amount) > 0) {
            accountTransactionFactory.addWithdrawal(currentUser.personId, selectedAccount.id, amount);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Get the transaction history for the specified time period for the
     * selected Account.
     *
     * @param startTime The beginning of the time period to get records from
     * @param endTime The end of the time period to get records from
     */
    public void executeGetTransactionHistory(Timestamp startTime, Timestamp endTime) {
        List<AccountTransaction> result = accountTransactionFactory.getByAccoundIdAndTimestampRange(selectedAccount.id, startTime, endTime);

        transactionListModel = new DefaultListModel<>();
        for (Object item : result) {
            transactionListModel.addElement((AccountTransaction) item);
        }
    }

    /**
     * Changes the logged in Users selected Theme.
     *
     * @param selectedTheme The name of the new Theme to select
     */
    public void executeSelectTheme(String selectedTheme) {
        currentUser.selectedTheme = selectedTheme;
        userFactory.executeUpdate(currentUser.toHashMap());

        UserSettings.setSelectedTheme(selectedTheme);
    }

    /**
     * Gets the name of the selected Theme for the currently logged in User.
     *
     * @return The selected Theme name
     */
    public String getSelectedTheme() {
        return currentUser.selectedTheme;
    }

    // </editor-fold> 
}
