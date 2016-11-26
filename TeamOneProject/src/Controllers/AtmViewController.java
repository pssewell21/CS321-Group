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
 *
 * @author Patrick Sewell
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

    /**
     *
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
     *
     */
    public AtmViewController() {
        this.accountFactory = new AccountFactory();
        this.accountTransactionFactory = new AccountTransactionFactory();
        this.userFactory = new UserFactory();
    }

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Methods"> 

    /**
     *
     * @param user
     */
    public void load(User user) {
        currentUser = user;

        List<Account> result = accountFactory.getByUserId(currentUser.id);
        Account[] accountArray = result.toArray(new Account[]{});
        accountModel = new DefaultComboBoxModel<>(accountArray);

        view = new AtmView(this);
    }

    /**
     *
     */
    public void executeQuit() {
        System.exit(0);
    }

    /**
     *
     * @return
     */
    public BigDecimal executeCheckBalance() {
        selectedAccount = accountFactory.getById(selectedAccount.id);

        return selectedAccount.balance;
    }

    /**
     *
     * @param amount
     */
    public void executeDeposit(BigDecimal amount) {
        accountTransactionFactory.addDeposit(currentUser.personId, selectedAccount.id, amount);
    }

    /**
     *
     * @param amount
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
     *
     * @param startTime
     * @param endTime
     */
    public void executeGetTransactionHistory(Timestamp startTime, Timestamp endTime) {
        List<AccountTransaction> result = accountTransactionFactory.getByAccoundIdAndTimestampRange(selectedAccount.id, startTime, endTime);

        transactionListModel = new DefaultListModel<>();
        for (Object item : result) {
            transactionListModel.addElement((AccountTransaction) item);
        }
    }

    /**
     *
     * @param selectedTheme
     */
    public void executeSelectTheme(String selectedTheme) {
        currentUser.selectedTheme = selectedTheme;
        userFactory.executeUpdate(currentUser.toHashMap());

        UserSettings.setSelectedTheme(selectedTheme);
    }

    /**
     *
     * @return
     */
    public String getSelectedTheme() {
        return currentUser.selectedTheme;
    }

    // </editor-fold> 
}
