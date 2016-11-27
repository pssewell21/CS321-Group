/*
 * Copyright 2016 AUTHORS. Patrick S Sewell, Paul M Dyer, Taehyeok Lee, 
 * Benjamin C Ferguson, Hyunki J KIm Permission is granted to copy, distribute 
 * and/or modify this document under the terms of the GNU Free Documentation 
 * License, Version 1.3, (3 November 2008) or any later version published by 
 * the Free Software Foundation; with no Invariant Sections, with no 
 * Front-Cover Texts, and with no Back-Cover Texts. A copy of the license 
 * can be found at http://www.gnu.org/copyleft/fdl.html
 */
package Views;

import Common.UserSettings;
import Common.Utility;
import Common.ImageIconScaler;
import Controllers.AtmViewController;
import Library.Account;
import Library.AccountTransaction;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * The ATM view.
 * @author Patrick Sewell
 */
public final class AtmView extends JFrame {
    // <editor-fold defaultstate="collapsed" desc="Member Variables"> 

    private static final long serialVersionUID = 1L;
    private JTabbedPane tabbedPane;
    private JPanel contentPane;
    private JPanel landingPanel;
    private JPanel depositPanel;
    private JPanel withdrawalPanel;
    private JPanel balanceCheckPanel;
    private JPanel transactionHistoryPanel;
    private JLabel logoLabel;
    private JLabel accountLabel;
    private JLabel selectedThemeLabel;
    private JComboBox<Account> accountSelectionComboBox;
    private JComboBox<String> selectedThemeComboBox;
    private JButton exitButton;
    private JLabel depositAccountNumberLabel;
    private JLabel depositAmountLabel;
    private JLabel depositAccountNumberField;
    private JTextField depositAmountField;
    private JButton depositButton;
    private JLabel withdrawalAccountNumberLabel;
    private JLabel withdrawalAmountLabel;
    private JLabel withdrawalAccountNumberField;
    private JTextField withdrawalAmountField;
    private JButton withdrawButton;
    private JLabel balanceCheckAccountNumberLabel;
    private JLabel balanceCheckBalanceLabel;
    private JLabel balanceCheckAccountNumberField;
    private JLabel balanceCheckCurrentBalance;
    private JButton balanceCheckButton;
    private JLabel transactionHistoryAccountNumberLabel;
    private JLabel transactionHistoryAccountNumberField;
    private JRadioButton lastDayRadioButton;
    private JRadioButton lastMonthRadioButton;
    private JRadioButton lastYearRadioButton;
    private JRadioButton customDateRangeRadioButton;
    private JLabel periodLabel;
    private JTextField transactionHistoryStartDateField;
    private JTextField transactionHistoryEndDateField;
    private JLabel startDateLabel;
    private JLabel endDateLabel;
    private JLabel dateFormatLabel;
    private JScrollPane transactionHistoryScrollPanel;
    private JList<AccountTransaction> transactionHistoryList;
    private JButton getTransactionHistoryButton;
    private ButtonGroup transactionHistoryRadioButtonGroup;
    private final AtmViewController controller;
    
    private boolean startDateIsValid;
    private boolean endDateIsValid;

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Constructors"> 
    /**
     * Creates new form AtmView.
     *
     * @param controller The AtmViewController for the view
     */
    public AtmView(AtmViewController controller) {
        this.controller = controller;

        load();
    }

    // </editor-fold> 
    /**
     * This method initializes the AtmView
     *
     */
    public void load() {
        setContentPane(getJContentPane());
        setTitle("ATM Demo");

        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/Resources/icon.png")).getImage());

        setBounds(new Rectangle(0, 0, 606, 429));

        setResizable(false);
        setVisible(true);
    }

    private JPanel getJContentPane() {
        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        contentPane.setPreferredSize(new Dimension(600, 400));
        contentPane.setName("ATM_Demo");
        contentPane.setBackground(UserSettings.selectedTheme.getBackgroundColor());
        contentPane.add(getTabbedPane(), BorderLayout.CENTER);

        return contentPane;
    }

    private JTabbedPane getTabbedPane() {
        tabbedPane = new JTabbedPane();
        tabbedPane.setPreferredSize(new Dimension(9000, 380));
        tabbedPane.addTab("Landing", null, getLandingPanel(), null);

        return tabbedPane;
    }

    private void addTabbedPaneTabs() {
        if (tabbedPane != null) {
            tabbedPane.addTab("Deposit", null, getDepositPanel(), null);
            tabbedPane.addTab("Withdrawal", null, getWithdrawalPanel(), null);
            tabbedPane.addTab("Check Balance", null, getBalanceCheckPanel(), null);
            tabbedPane.addTab("Transaction History", null, getTransactionHistoryPanel(), null);
        }

        pack();
    }

    private JPanel getLandingPanel() {
        GridBagConstraints gridBagConstraintsExitButton = new GridBagConstraints();
        gridBagConstraintsExitButton.gridx = 2;
        gridBagConstraintsExitButton.gridy = 3;
        GridBagConstraints gridBagConstraintsLogoLabel = new GridBagConstraints();
        gridBagConstraintsLogoLabel.gridx = 0;
        gridBagConstraintsLogoLabel.gridy = 0;
        gridBagConstraintsLogoLabel.ipadx = 30;
        gridBagConstraintsLogoLabel.ipady = 30;
        gridBagConstraintsLogoLabel.gridheight = 5;
        gridBagConstraintsLogoLabel.fill = GridBagConstraints.VERTICAL;
        GridBagConstraints gridBagConstraintsAccountSelectionComboBox = new GridBagConstraints();
        gridBagConstraintsAccountSelectionComboBox.gridx = 2;
        gridBagConstraintsAccountSelectionComboBox.gridy = 1;
        GridBagConstraints gridBagConstraintsSelectedThemeComboBox = new GridBagConstraints();
        gridBagConstraintsSelectedThemeComboBox.gridx = 2;
        gridBagConstraintsSelectedThemeComboBox.gridy = 2;
        GridBagConstraints gridBagConstraintsSelectedThemeLabel = new GridBagConstraints();
        gridBagConstraintsSelectedThemeLabel.gridx = 1;
        gridBagConstraintsSelectedThemeLabel.gridy = 2;
        gridBagConstraintsSelectedThemeLabel.anchor = GridBagConstraints.EAST;
        GridBagConstraints gridBagConstraintsAccountLabel = new GridBagConstraints();
        gridBagConstraintsAccountLabel.gridx = 1;
        gridBagConstraintsAccountLabel.gridy = 1;
        gridBagConstraintsAccountLabel.anchor = GridBagConstraints.EAST;
        ImageIcon image = new ImageIcon(getClass().getResource("/Resources/logo.png"));
        logoLabel = new JLabel();
        logoLabel.setPreferredSize(new Dimension(150, 150));
        logoLabel.setText(null);
        logoLabel.setIcon(ImageIconScaler.getScaledImage(image, 150, 150));

        accountLabel = new JLabel();
        accountLabel.setText("Account: ");
        accountLabel.setForeground(UserSettings.selectedTheme.getTextColor());
        selectedThemeLabel = new JLabel();
        selectedThemeLabel.setText("Selected Theme: ");
        selectedThemeLabel.setForeground(UserSettings.selectedTheme.getTextColor());
        landingPanel = new JPanel();
        landingPanel.setLayout(new GridBagLayout());
        landingPanel.setBackground(UserSettings.selectedTheme.getBackgroundColor());
        landingPanel.add(logoLabel, gridBagConstraintsLogoLabel);
        landingPanel.add(accountLabel, gridBagConstraintsAccountLabel);
        landingPanel.add(getAccountSelectionComboBox(), gridBagConstraintsAccountSelectionComboBox);
        landingPanel.add(selectedThemeLabel, gridBagConstraintsSelectedThemeLabel);
        landingPanel.add(getSelectedThemeComboBox(), gridBagConstraintsSelectedThemeComboBox);
        landingPanel.add(getExitButton(), gridBagConstraintsExitButton);

        return landingPanel;
    }

    private JPanel getDepositPanel() {
        GridBagConstraints gridBagConstraintsDepositButton = new GridBagConstraints();
        gridBagConstraintsDepositButton.gridx = 1;
        gridBagConstraintsDepositButton.gridy = 2;
        GridBagConstraints gridBagConstraintsDepositAmountLabel = new GridBagConstraints();
        gridBagConstraintsDepositAmountLabel.gridx = 0;
        gridBagConstraintsDepositAmountLabel.gridy = 1;
        gridBagConstraintsDepositAmountLabel.anchor = GridBagConstraints.EAST;
        depositAmountLabel = new JLabel();
        depositAmountLabel.setText("Amount: ");
        depositAmountLabel.setForeground(UserSettings.selectedTheme.getTextColor());
        GridBagConstraints gridBagConstraintsDepositAmountField = new GridBagConstraints();
        gridBagConstraintsDepositAmountField.fill = GridBagConstraints.VERTICAL;
        gridBagConstraintsDepositAmountField.gridy = 1;
        gridBagConstraintsDepositAmountField.gridx = 1;
        GridBagConstraints gridBagConstraintsDepositAccountNumberField = new GridBagConstraints();
        gridBagConstraintsDepositAccountNumberField.gridy = 0;
        gridBagConstraintsDepositAccountNumberField.gridx = 1;
        gridBagConstraintsDepositAccountNumberField.anchor = GridBagConstraints.WEST;
        GridBagConstraints gridBagConstraintsDepositAccountNumberLabel = new GridBagConstraints();
        gridBagConstraintsDepositAccountNumberLabel.gridx = 0;
        gridBagConstraintsDepositAccountNumberLabel.gridy = 0;
        gridBagConstraintsDepositAccountNumberLabel.anchor = GridBagConstraints.EAST;
        depositAccountNumberLabel = new JLabel();
        depositAccountNumberLabel.setText("Account Number: ");
        depositAccountNumberLabel.setForeground(UserSettings.selectedTheme.getTextColor());
        depositPanel = new JPanel();
        depositPanel.setLayout(new GridBagLayout());
        depositPanel.setBackground(UserSettings.selectedTheme.getBackgroundColor());
        depositPanel.add(depositAccountNumberLabel, gridBagConstraintsDepositAccountNumberLabel);
        depositPanel.add(getDepositAccountNumberField(), gridBagConstraintsDepositAccountNumberField);
        depositPanel.add(getDepositAmountField(), gridBagConstraintsDepositAmountField);
        depositPanel.add(depositAmountLabel, gridBagConstraintsDepositAmountLabel);
        depositPanel.add(getDepositButton(), gridBagConstraintsDepositButton);

        return depositPanel;
    }

    private JPanel getWithdrawalPanel() {
        GridBagConstraints gridBagConstraintsWithdrawButton = new GridBagConstraints();
        gridBagConstraintsWithdrawButton.gridx = 1;
        gridBagConstraintsWithdrawButton.gridy = 2;
        GridBagConstraints gridBagConstraintsWithdrawalAmountField = new GridBagConstraints();
        gridBagConstraintsWithdrawalAmountField.fill = GridBagConstraints.VERTICAL;
        gridBagConstraintsWithdrawalAmountField.gridy = 1;
        gridBagConstraintsWithdrawalAmountField.gridx = 1;
        gridBagConstraintsWithdrawalAmountField.anchor = GridBagConstraints.WEST;
        GridBagConstraints gridBagConstraintsWithdrawalAmountLabel = new GridBagConstraints();
        gridBagConstraintsWithdrawalAmountLabel.gridx = 0;
        gridBagConstraintsWithdrawalAmountLabel.gridy = 1;
        gridBagConstraintsWithdrawalAmountLabel.anchor = GridBagConstraints.EAST;
        withdrawalAmountLabel = new JLabel();
        withdrawalAmountLabel.setText("Amount: ");
        withdrawalAmountLabel.setForeground(UserSettings.selectedTheme.getTextColor());
        GridBagConstraints gridBagConstraintsWithdrawalAccountNumberField = new GridBagConstraints();
        gridBagConstraintsWithdrawalAccountNumberField.gridy = 0;
        gridBagConstraintsWithdrawalAccountNumberField.gridx = 1;
        gridBagConstraintsWithdrawalAccountNumberField.anchor = GridBagConstraints.WEST;
        GridBagConstraints gridBagConstraintsWithdrawalAccountNumberLabel = new GridBagConstraints();
        gridBagConstraintsWithdrawalAccountNumberLabel.gridx = 0;
        gridBagConstraintsWithdrawalAccountNumberLabel.gridy = 0;
        gridBagConstraintsWithdrawalAccountNumberLabel.anchor = GridBagConstraints.EAST;
        withdrawalAccountNumberLabel = new JLabel();
        withdrawalAccountNumberLabel.setText("Account Number: ");
        withdrawalAccountNumberLabel.setForeground(UserSettings.selectedTheme.getTextColor());
        withdrawalPanel = new JPanel();
        withdrawalPanel.setLayout(new GridBagLayout());
        withdrawalPanel.setBackground(UserSettings.selectedTheme.getBackgroundColor());
        withdrawalPanel.add(withdrawalAccountNumberLabel, gridBagConstraintsWithdrawalAccountNumberLabel);
        withdrawalPanel.add(getWithdrawalAccountNumberField(), gridBagConstraintsWithdrawalAccountNumberField);
        withdrawalPanel.add(withdrawalAmountLabel, gridBagConstraintsWithdrawalAmountLabel);
        withdrawalPanel.add(getWithdrawalAmountField(), gridBagConstraintsWithdrawalAmountField);
        withdrawalPanel.add(getWithdrawButton(), gridBagConstraintsWithdrawButton);

        return withdrawalPanel;
    }

    private JPanel getBalanceCheckPanel() {
        GridBagConstraints gridBagConstraintsBalanceCheckButton = new GridBagConstraints();
        gridBagConstraintsBalanceCheckButton.gridx = 1;
        gridBagConstraintsBalanceCheckButton.gridy = 2;
        GridBagConstraints gridBagConstraintsBalanceCheckCurrentBalance = new GridBagConstraints();
        gridBagConstraintsBalanceCheckCurrentBalance.gridx = 1;
        gridBagConstraintsBalanceCheckCurrentBalance.gridy = 1;
        gridBagConstraintsBalanceCheckCurrentBalance.anchor = GridBagConstraints.WEST;
        balanceCheckCurrentBalance = new JLabel();
        balanceCheckCurrentBalance.setText("");
        balanceCheckCurrentBalance.setForeground(UserSettings.selectedTheme.getTextColor());
        GridBagConstraints gridBagConstraintsBalanceCheckAccountNumberField = new GridBagConstraints();
        gridBagConstraintsBalanceCheckAccountNumberField.gridx = 1;
        gridBagConstraintsBalanceCheckAccountNumberField.gridy = 0;
        gridBagConstraintsBalanceCheckAccountNumberField.anchor = GridBagConstraints.WEST;
        GridBagConstraints gridBagConstraintsBalanceCheckAccountNumberLabel = new GridBagConstraints();
        gridBagConstraintsBalanceCheckAccountNumberLabel.gridx = 0;
        gridBagConstraintsBalanceCheckAccountNumberLabel.gridy = 0;
        gridBagConstraintsBalanceCheckAccountNumberLabel.anchor = GridBagConstraints.EAST;
        balanceCheckAccountNumberLabel = new JLabel();
        balanceCheckAccountNumberLabel.setText("Account Number: ");
        balanceCheckAccountNumberLabel.setForeground(UserSettings.selectedTheme.getTextColor());
        GridBagConstraints gridBagConstraintsBalanceCheckBalanceLabel = new GridBagConstraints();
        gridBagConstraintsBalanceCheckBalanceLabel.gridx = 0;
        gridBagConstraintsBalanceCheckBalanceLabel.gridy = 1;
        gridBagConstraintsBalanceCheckBalanceLabel.anchor = GridBagConstraints.EAST;
        balanceCheckBalanceLabel = new JLabel();
        balanceCheckBalanceLabel.setText("Balance: ");
        balanceCheckBalanceLabel.setForeground(UserSettings.selectedTheme.getTextColor());
        balanceCheckPanel = new JPanel();
        balanceCheckPanel.setLayout(new GridBagLayout());
        balanceCheckPanel.setBackground(UserSettings.selectedTheme.getBackgroundColor());
        balanceCheckPanel.add(balanceCheckAccountNumberLabel, gridBagConstraintsBalanceCheckAccountNumberLabel);
        balanceCheckPanel.add(balanceCheckBalanceLabel, gridBagConstraintsBalanceCheckBalanceLabel);
        balanceCheckPanel.add(getBalanceCheckAccountNumberField(), gridBagConstraintsBalanceCheckAccountNumberField);
        balanceCheckPanel.add(balanceCheckCurrentBalance, gridBagConstraintsBalanceCheckCurrentBalance);
        balanceCheckPanel.add(getBalanceCheckButton(), gridBagConstraintsBalanceCheckButton);

        return balanceCheckPanel;
    }

    private JPanel getTransactionHistoryPanel() {
        GridBagConstraints gridBagConstraintsCustomDateRangeRadioButton = new GridBagConstraints();
        gridBagConstraintsCustomDateRangeRadioButton.gridx = 4;
        gridBagConstraintsCustomDateRangeRadioButton.gridy = 1;
        gridBagConstraintsCustomDateRangeRadioButton.anchor = GridBagConstraints.WEST;
        gridBagConstraintsCustomDateRangeRadioButton.ipadx = 10;
        GridBagConstraints gridBagConstraintsGetTransactionHistoryButton = new GridBagConstraints();
        gridBagConstraintsGetTransactionHistoryButton.gridx = 4;
        gridBagConstraintsGetTransactionHistoryButton.gridy = 3;
        GridBagConstraints gridBagConstraintsTransactionHistoryList = new GridBagConstraints();
        gridBagConstraintsTransactionHistoryList.gridx = 0;
        gridBagConstraintsTransactionHistoryList.gridy = 4;
        gridBagConstraintsTransactionHistoryList.gridwidth = 8;
        gridBagConstraintsTransactionHistoryList.fill = GridBagConstraints.BOTH;
        gridBagConstraintsTransactionHistoryList.anchor = GridBagConstraints.SOUTHWEST;
        gridBagConstraintsTransactionHistoryList.weightx = 1.0;
        gridBagConstraintsTransactionHistoryList.weighty = 1.0;
        GridBagConstraints gridBagConstraintsEndDateLabel = new GridBagConstraints();
        gridBagConstraintsEndDateLabel.gridx = 0;
        gridBagConstraintsEndDateLabel.gridy = 3;
        gridBagConstraintsEndDateLabel.anchor = GridBagConstraints.EAST;
        endDateLabel = new JLabel();
        endDateLabel.setText("End Date: ");
        endDateLabel.setForeground(UserSettings.selectedTheme.getTextColor());
        GridBagConstraints gridBagConstraintsStartDateLabel = new GridBagConstraints();
        gridBagConstraintsStartDateLabel.gridx = 0;
        gridBagConstraintsStartDateLabel.gridy = 2;
        gridBagConstraintsStartDateLabel.anchor = GridBagConstraints.EAST;
        startDateLabel = new JLabel();
        startDateLabel.setText("Start Date: ");
        startDateLabel.setForeground(UserSettings.selectedTheme.getTextColor());
        GridBagConstraints gridBagConstraintsDateFormatLabel = new GridBagConstraints();
        gridBagConstraintsDateFormatLabel.gridx = 2;
        gridBagConstraintsDateFormatLabel.gridy = 2;
        gridBagConstraintsDateFormatLabel.anchor = GridBagConstraints.WEST;
        dateFormatLabel = new JLabel();
        dateFormatLabel.setText("(YYYY-MM-DD)");
        dateFormatLabel.setForeground(UserSettings.selectedTheme.getTextColor());
        GridBagConstraints gridBagConstraintsTransactionHistoryEndDateField = new GridBagConstraints();
        gridBagConstraintsTransactionHistoryEndDateField.gridx = 1;
        gridBagConstraintsTransactionHistoryEndDateField.gridy = 3;
        gridBagConstraintsTransactionHistoryEndDateField.fill = GridBagConstraints.BOTH;
        GridBagConstraints gridBagConstraintsTransactionHistoryStartDateField = new GridBagConstraints();
        gridBagConstraintsTransactionHistoryStartDateField.gridx = 1;
        gridBagConstraintsTransactionHistoryStartDateField.gridy = 2;
        gridBagConstraintsTransactionHistoryStartDateField.fill = GridBagConstraints.BOTH;
        GridBagConstraints gridBagConstraintsPeriodLabel = new GridBagConstraints();
        gridBagConstraintsPeriodLabel.gridx = 0;
        gridBagConstraintsPeriodLabel.gridy = 1;
        gridBagConstraintsPeriodLabel.anchor = GridBagConstraints.EAST;
        periodLabel = new JLabel();
        periodLabel.setText("Period: ");
        periodLabel.setForeground(UserSettings.selectedTheme.getTextColor());
        GridBagConstraints gridBagConstraintsLastMonthRadioButton = new GridBagConstraints();
        gridBagConstraintsLastMonthRadioButton.gridx = 2;
        gridBagConstraintsLastMonthRadioButton.gridy = 1;
        gridBagConstraintsLastMonthRadioButton.ipadx = 10;
        GridBagConstraints gridBagConstraintsLastYearRadioButton = new GridBagConstraints();
        gridBagConstraintsLastYearRadioButton.gridx = 3;
        gridBagConstraintsLastYearRadioButton.gridy = 1;
        gridBagConstraintsLastYearRadioButton.ipadx = 10;
        GridBagConstraints gridBagConstraintsLastDayRadioButton = new GridBagConstraints();
        gridBagConstraintsLastDayRadioButton.gridx = 1;
        gridBagConstraintsLastDayRadioButton.gridy = 1;
        gridBagConstraintsLastDayRadioButton.ipadx = 10;
        GridBagConstraints gridBagConstraintsTransactionHistoryAccountNumberField = new GridBagConstraints();
        gridBagConstraintsTransactionHistoryAccountNumberField.gridx = 1;
        gridBagConstraintsTransactionHistoryAccountNumberField.gridy = 0;
        gridBagConstraintsTransactionHistoryAccountNumberField.anchor = GridBagConstraints.WEST;
        GridBagConstraints gridBagConstraintsTransactionHistoryAccountNumberLabel = new GridBagConstraints();
        gridBagConstraintsTransactionHistoryAccountNumberLabel.gridy = 0;
        gridBagConstraintsTransactionHistoryAccountNumberLabel.gridx = 0;
        gridBagConstraintsTransactionHistoryAccountNumberLabel.anchor = GridBagConstraints.EAST;
        transactionHistoryAccountNumberLabel = new JLabel();
        transactionHistoryAccountNumberLabel.setText("Account Number: ");
        transactionHistoryAccountNumberLabel.setForeground(UserSettings.selectedTheme.getTextColor());
        transactionHistoryPanel = new JPanel();
        transactionHistoryPanel.setLayout(new GridBagLayout());
        transactionHistoryPanel.setPreferredSize(new Dimension(500, 91));
        transactionHistoryPanel.setName("systems");
        transactionHistoryPanel.setBackground(UserSettings.selectedTheme.getBackgroundColor());
        transactionHistoryPanel.add(transactionHistoryAccountNumberLabel, gridBagConstraintsTransactionHistoryAccountNumberLabel);
        transactionHistoryPanel.add(getTransactionHistoryAccountNumberField(), gridBagConstraintsTransactionHistoryAccountNumberField);
        transactionHistoryRadioButtonGroup = new ButtonGroup();
        transactionHistoryPanel.add(getLastDayRadioButton(), gridBagConstraintsLastDayRadioButton);
        transactionHistoryPanel.add(getLastYearRadioButton(), gridBagConstraintsLastYearRadioButton);
        transactionHistoryPanel.add(getLastMonthRadioButton(), gridBagConstraintsLastMonthRadioButton);
        transactionHistoryPanel.add(periodLabel, gridBagConstraintsPeriodLabel);
        transactionHistoryPanel.add(getTransactionHistoryStartDateField(), gridBagConstraintsTransactionHistoryStartDateField);
        transactionHistoryPanel.add(getTransactionHistoryEndDateField(), gridBagConstraintsTransactionHistoryEndDateField);
        transactionHistoryPanel.add(startDateLabel, gridBagConstraintsStartDateLabel);
        transactionHistoryPanel.add(endDateLabel, gridBagConstraintsEndDateLabel);
        transactionHistoryPanel.add(dateFormatLabel, gridBagConstraintsDateFormatLabel);
        transactionHistoryPanel.add(getTransactionHistoryList(), gridBagConstraintsTransactionHistoryList);
        transactionHistoryPanel.add(getTransactionHistoryButton(), gridBagConstraintsGetTransactionHistoryButton);
        transactionHistoryPanel.add(getCustomDateRangeRadioButton(), gridBagConstraintsCustomDateRangeRadioButton);

        return transactionHistoryPanel;
    }

    private JLabel getDepositAccountNumberField() {
        depositAccountNumberField = new JLabel();
        depositAccountNumberField.setForeground(UserSettings.selectedTheme.getTextColor());
        if (controller.selectedAccount != null && controller.selectedAccount.accountNumber != null) {
            depositAccountNumberField.setText(controller.selectedAccount.accountNumber.toString());
        }

        return depositAccountNumberField;
    }

    private JTextField getDepositAmountField() {
        depositAmountField = new JTextField();
        depositAmountField.setPreferredSize(new Dimension(120, 25));
        depositAmountField.setBackground(UserSettings.selectedTheme.getTextFieldBackgroundColor());
        depositAmountField.setForeground(UserSettings.selectedTheme.getTextColor());
        depositAmountField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                actionPerformed();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                actionPerformed();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                actionPerformed();
            }

            private void actionPerformed() {
                if (Utility.isNumeric(depositAmountField.getText())) {
                    depositButton.setEnabled(true);
                } else {
                    depositButton.setEnabled(false);
                }
            }
        });

        return depositAmountField;
    }

    private JButton getDepositButton() {
        depositButton = new JButton();
        depositButton.setText("Deposit");
        depositButton.setPreferredSize(new Dimension(120, 30));
        depositButton.setBackground(UserSettings.selectedTheme.getButtonBackgroundColor());
        depositButton.setForeground(UserSettings.selectedTheme.getTextColor());
        depositButton.setEnabled(false);
        depositButton.addActionListener((java.awt.event.ActionEvent e) -> {
            BigDecimal amount = new BigDecimal(depositAmountField.getText());

            controller.executeDeposit(amount);
        });

        return depositButton;
    }

    private JLabel getWithdrawalAccountNumberField() {
        withdrawalAccountNumberField = new JLabel();
        withdrawalAccountNumberField.setForeground(UserSettings.selectedTheme.getTextColor());
        if (controller.selectedAccount != null && controller.selectedAccount.accountNumber != null) {
            withdrawalAccountNumberField.setText(controller.selectedAccount.accountNumber.toString());
        }

        return withdrawalAccountNumberField;
    }

    private JTextField getWithdrawalAmountField() {
        withdrawalAmountField = new JTextField();
        withdrawalAmountField.setPreferredSize(new Dimension(120, 25));
        withdrawalAmountField.setBackground(UserSettings.selectedTheme.getTextFieldBackgroundColor());
        withdrawalAmountField.setForeground(UserSettings.selectedTheme.getTextColor());
        withdrawalAmountField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                actionPerformed();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                actionPerformed();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                actionPerformed();
            }

            private void actionPerformed() {
                if (Utility.isNumeric(withdrawalAmountField.getText())) {
                    withdrawButton.setEnabled(true);
                } else {
                    withdrawButton.setEnabled(false);
                }
            }
        });

        return withdrawalAmountField;
    }

    private JButton getWithdrawButton() {
        withdrawButton = new JButton();
        withdrawButton.setText("Withdraw");
        withdrawButton.setPreferredSize(new Dimension(120, 30));
        withdrawButton.setBackground(UserSettings.selectedTheme.getButtonBackgroundColor());
        withdrawButton.setForeground(UserSettings.selectedTheme.getTextColor());
        withdrawButton.setEnabled(false);
        withdrawButton.addActionListener((java.awt.event.ActionEvent e) -> {
            BigDecimal amount = new BigDecimal(withdrawalAmountField.getText());

            if (!controller.executeWithdrawal(amount)) {
                JOptionPane.showMessageDialog(withdrawalPanel, "Insufficient funds to make withdrawal.");
            }
        });

        return withdrawButton;
    }

    private JLabel getBalanceCheckAccountNumberField() {
        balanceCheckAccountNumberField = new JLabel();
        balanceCheckAccountNumberField.setForeground(UserSettings.selectedTheme.getTextColor());
        if (controller.selectedAccount != null && controller.selectedAccount.accountNumber != null) {
            balanceCheckAccountNumberField.setText(controller.selectedAccount.accountNumber.toString());
        }

        return balanceCheckAccountNumberField;
    }

    private JButton getBalanceCheckButton() {
        balanceCheckButton = new JButton();
        balanceCheckButton.setText("Check Balance");
        balanceCheckButton.setPreferredSize(new Dimension(120, 30));
        balanceCheckButton.setBackground(UserSettings.selectedTheme.getButtonBackgroundColor());
        balanceCheckButton.setForeground(UserSettings.selectedTheme.getTextColor());
        balanceCheckButton.addActionListener((java.awt.event.ActionEvent e) -> {
            BigDecimal balance = controller.executeCheckBalance();

            balanceCheckCurrentBalance.setText(String.valueOf(balance));
        });

        return balanceCheckButton;
    }

    private JLabel getTransactionHistoryAccountNumberField() {
        transactionHistoryAccountNumberField = new JLabel();
        transactionHistoryAccountNumberField.setForeground(UserSettings.selectedTheme.getTextColor());
        if (controller.selectedAccount != null && controller.selectedAccount.accountNumber != null) {
            transactionHistoryAccountNumberField.setText(controller.selectedAccount.accountNumber.toString());
        }

        return transactionHistoryAccountNumberField;
    }

    private JRadioButton getLastDayRadioButton() {
        lastDayRadioButton = new JRadioButton();
        lastDayRadioButton.setText("Last Day");
        lastDayRadioButton.setActionCommand("Last Day");
        lastDayRadioButton.setForeground(UserSettings.selectedTheme.getTextColor());
        lastDayRadioButton.setSelected(true);
        lastDayRadioButton.addActionListener((java.awt.event.ActionEvent e) -> {
            if (lastDayRadioButton.isSelected()) {
                transactionHistoryStartDateField.setEnabled(false);
                transactionHistoryEndDateField.setEnabled(false);
                getTransactionHistoryButton.setEnabled(true);
            }  
        });
        transactionHistoryRadioButtonGroup.add(lastDayRadioButton);

        return lastDayRadioButton;
    }

    private JRadioButton getLastMonthRadioButton() {
        lastMonthRadioButton = new JRadioButton();
        lastMonthRadioButton.setText("Last Month");
        lastMonthRadioButton.setActionCommand("Last Month");
        lastMonthRadioButton.setForeground(UserSettings.selectedTheme.getTextColor());
        lastMonthRadioButton.addActionListener((java.awt.event.ActionEvent e) -> {
            if (lastMonthRadioButton.isSelected()) {
                transactionHistoryStartDateField.setEnabled(false);
                transactionHistoryEndDateField.setEnabled(false);
                getTransactionHistoryButton.setEnabled(true);
            }
        });
        transactionHistoryRadioButtonGroup.add(lastMonthRadioButton);

        return lastMonthRadioButton;
    }

    private JRadioButton getLastYearRadioButton() {
        lastYearRadioButton = new JRadioButton();
        lastYearRadioButton.setText("Last Year");
        lastYearRadioButton.setActionCommand("Last Year");
        lastYearRadioButton.setForeground(UserSettings.selectedTheme.getTextColor());
        lastYearRadioButton.addActionListener((java.awt.event.ActionEvent e) -> {
            if (lastYearRadioButton.isSelected()) {
                transactionHistoryStartDateField.setEnabled(false);
                transactionHistoryEndDateField.setEnabled(false);
                getTransactionHistoryButton.setEnabled(true);
            }  
        });
        transactionHistoryRadioButtonGroup.add(lastYearRadioButton);

        return lastYearRadioButton;
    }

    private JTextField getTransactionHistoryStartDateField() {
        transactionHistoryStartDateField = new JTextField();
        transactionHistoryStartDateField.setBackground(UserSettings.selectedTheme.getTextFieldBackgroundColor());
        transactionHistoryStartDateField.setForeground(UserSettings.selectedTheme.getTextColor());
        transactionHistoryStartDateField.setEnabled(false);
        transactionHistoryStartDateField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                actionPerformed();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                actionPerformed();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                actionPerformed();
            }

            private void actionPerformed() {
                startDateIsValid = Utility.isValidDate(transactionHistoryStartDateField.getText());
                
                if (startDateIsValid && endDateIsValid) {
                    getTransactionHistoryButton.setEnabled(true);
                } else {
                    getTransactionHistoryButton.setEnabled(false);
                }
            }
        });

        return transactionHistoryStartDateField;
    }

    private JTextField getTransactionHistoryEndDateField() {
        transactionHistoryEndDateField = new JTextField();
        transactionHistoryEndDateField.setBackground(UserSettings.selectedTheme.getTextFieldBackgroundColor());
        transactionHistoryEndDateField.setForeground(UserSettings.selectedTheme.getTextColor());
        transactionHistoryEndDateField.setEnabled(false);
        transactionHistoryEndDateField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                actionPerformed();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                actionPerformed();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                actionPerformed();
            }

            private void actionPerformed() {
                endDateIsValid = Utility.isValidDate(transactionHistoryEndDateField.getText());
                
                if (startDateIsValid && endDateIsValid) {
                    getTransactionHistoryButton.setEnabled(true);
                } else {
                    getTransactionHistoryButton.setEnabled(false);
                }
            }
        });

        return transactionHistoryEndDateField;
    }

    private JScrollPane getTransactionHistoryList() {
        transactionHistoryScrollPanel = new JScrollPane();
        transactionHistoryList = new JList<>();
        transactionHistoryList.setBackground(UserSettings.selectedTheme.getListBackgroundColor());
        transactionHistoryList.setForeground(UserSettings.selectedTheme.getTextColor());
        transactionHistoryScrollPanel.setViewportView(transactionHistoryList);

        return transactionHistoryScrollPanel;
    }

    private JButton getTransactionHistoryButton() {
        getTransactionHistoryButton = new JButton();
        getTransactionHistoryButton.setText("Get Transaction History");
        getTransactionHistoryButton.setBackground(UserSettings.selectedTheme.getButtonBackgroundColor());
        getTransactionHistoryButton.setForeground(UserSettings.selectedTheme.getTextColor());
        getTransactionHistoryButton.setEnabled(true);
        getTransactionHistoryButton.addActionListener((java.awt.event.ActionEvent e) -> {
            try {
                String command = transactionHistoryRadioButtonGroup.getSelection().getActionCommand();
                Calendar startDay = Calendar.getInstance();

                Timestamp startTime;
                Timestamp endTime;

                switch (command) {
                    case "Last Day":
                        startDay.roll(Calendar.DATE, false);

                        startTime = new Timestamp(startDay.getTimeInMillis());
                        endTime = Utility.getCurrentTime();
                        break;
                    case "Last Month":
                        startDay.roll(Calendar.MONTH, false);

                        startTime = new Timestamp(startDay.getTimeInMillis());
                        endTime = Utility.getCurrentTime();
                        break;
                    case "Last Year":
                        startDay.roll(Calendar.YEAR, false);

                        startTime = new Timestamp(startDay.getTimeInMillis());
                        endTime = Utility.getCurrentTime();
                        break;
                    case "Custom Date Range":
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

                        Date parsedStartDate = dateFormat.parse(transactionHistoryStartDateField.getText());
                        Date parsedEndDate = dateFormat.parse(transactionHistoryEndDateField.getText());

                        //Additional time added to the end date to include transactions that occur on the end date until 23:59:59.999
                        long additionalTime = TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS) - 1;

                        startTime = new Timestamp(parsedStartDate.getTime());
                        endTime = new Timestamp(parsedEndDate.getTime() + additionalTime);
                        break;
                    default:
                        System.out.println("Invalid action command selected.");

                        startTime = Utility.getCurrentTime();
                        endTime = Utility.getCurrentTime();
                        break;
                }

                controller.executeGetTransactionHistory(startTime, endTime);

                transactionHistoryList.setModel(controller.transactionListModel);
            } catch (ParseException | NumberFormatException ex) {
            }
        });

        return getTransactionHistoryButton;
    }

    private JComboBox getAccountSelectionComboBox() {
        accountSelectionComboBox = new JComboBox<>();
        accountSelectionComboBox.setModel(controller.accountModel);
        accountSelectionComboBox.setPreferredSize(new Dimension(250, 25));
        accountSelectionComboBox.setToolTipText("Accounts");
        accountSelectionComboBox.setName("Accounts");
        accountSelectionComboBox.setSelectedItem(null);
        accountSelectionComboBox.setBackground(UserSettings.selectedTheme.getComboBoxBackgroundColor());
        accountSelectionComboBox.setForeground(UserSettings.selectedTheme.getTextColor());
        accountSelectionComboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public void paint(Graphics g) {
                setBackground(UserSettings.selectedTheme.getListBackgroundColor());
                setForeground(UserSettings.selectedTheme.getTextColor());
                super.paint(g);
            }
        });
        accountSelectionComboBox.addActionListener((java.awt.event.ActionEvent e) -> {
            controller.selectedAccount = (Account) accountSelectionComboBox.getSelectedItem();

            if (controller.selectedAccount != null) {
                tabbedPane.remove(depositPanel);
                tabbedPane.remove(withdrawalPanel);
                tabbedPane.remove(balanceCheckPanel);
                tabbedPane.remove(transactionHistoryPanel);

                addTabbedPaneTabs();
            }
        });

        return accountSelectionComboBox;
    }

    private JComboBox getSelectedThemeComboBox() {
        selectedThemeComboBox = new JComboBox<>();
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        model.addElement("Light Theme");
        model.addElement("Dark Theme");
        selectedThemeComboBox.setModel(model);
        selectedThemeComboBox.setPreferredSize(new Dimension(250, 25));
        selectedThemeComboBox.setToolTipText("Accounts");
        selectedThemeComboBox.setName("Accounts");
        selectedThemeComboBox.setSelectedItem(controller.getSelectedTheme());
        selectedThemeComboBox.setBackground(UserSettings.selectedTheme.getComboBoxBackgroundColor());
        selectedThemeComboBox.setForeground(UserSettings.selectedTheme.getTextColor());
        selectedThemeComboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public void paint(Graphics g) {
                setBackground(UserSettings.selectedTheme.getListBackgroundColor());
                setForeground(UserSettings.selectedTheme.getTextColor());
                super.paint(g);
            }
        });
        selectedThemeComboBox.addActionListener((java.awt.event.ActionEvent e) -> {
            controller.executeSelectTheme((String) selectedThemeComboBox.getSelectedItem());
            dispose();
            load();
        });

        return selectedThemeComboBox;
    }

    private JButton getExitButton() {
        exitButton = new JButton();
        exitButton.setText("Exit ATM");
        exitButton.setPreferredSize(new Dimension(120, 30));
        exitButton.setBackground(UserSettings.selectedTheme.getButtonBackgroundColor());
        exitButton.setForeground(UserSettings.selectedTheme.getTextColor());
        exitButton.addActionListener((java.awt.event.ActionEvent e) -> {
            int n = JOptionPane.showConfirmDialog(landingPanel,
                    "Exit ATM?", "Confirm Exit",
                    JOptionPane.OK_CANCEL_OPTION);
            if (n == JOptionPane.YES_OPTION) {
                controller.executeQuit();
            }
        });

        return exitButton;
    }

    private JRadioButton getCustomDateRangeRadioButton() {
        customDateRangeRadioButton = new JRadioButton();
        customDateRangeRadioButton.setPreferredSize(new Dimension(150, 20));
        customDateRangeRadioButton.setText("Custom Date Range");
        customDateRangeRadioButton.setActionCommand("Custom Date Range");
        customDateRangeRadioButton.setForeground(UserSettings.selectedTheme.getTextColor());
        customDateRangeRadioButton.addActionListener((java.awt.event.ActionEvent e) -> {
            if (customDateRangeRadioButton.isSelected()) {
                transactionHistoryStartDateField.setEnabled(true);
                transactionHistoryEndDateField.setEnabled(true);
                getTransactionHistoryButton.setEnabled(startDateIsValid && endDateIsValid);
            } 
        });
        transactionHistoryRadioButtonGroup.add(customDateRangeRadioButton);

        return customDateRangeRadioButton;
    }
}
