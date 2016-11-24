/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Common.UserSettings;
import Common.Utility;
import Controllers.AtmViewController;
import Library.Account;
import Library.AccountTransaction;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.UIDefaults;

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
    private JComboBox<Account> accountSelectionComboBox;
    private JButton selectAccountButton;
    private JButton exitButton;
    private JLabel depositAccountNumberLabel;
    private JLabel depositAmountLabel;
    private JTextField depositAccountNumberField;
    private JTextField depositAmountField;
    private JButton depositButton;
    private JLabel withdrawalAccountNumberLabel;
    private JLabel withdrawalAmountLabel;
    private JTextField withdrawalAccountNumberField;
    private JTextField withdrawalAmountField;
    private JButton withdrawButton;
    private JLabel balanceCheckAccountNumberLabel;
    private JTextField balanceCheckAccountNumber;
    private JLabel balanceCheckCurrentBalance;
    private JButton balanceCheckButton;
    private JLabel transactionHistoryAccountNumberLabel;
    private JTextField transactionHistoryAccountNumberField;
    private JRadioButton lastDayRadioButton;
    private JRadioButton lastMonthRadioButton;
    private JRadioButton lastYearRadioButton;
    private JRadioButton customDateRangeRadioButton;
    private JLabel periodLabel;
    private JTextField transactionHistoryStartDateField;
    private JTextField transactionHistoryEndDateField;
    private JLabel startDateLabel;
    private JLabel endDateLabel;
    private JList<AccountTransaction> transactionHistoryList;
    private JButton getTransactionHistoryButton;
    private ButtonGroup transactionHistoryRadioButtonGroup;
    private final AtmViewController controller;

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Constructors"> 
    /**
     * This is the default constructor
     * @param controller
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

        setBounds(new Rectangle(0, 0, 520, 300));
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                controller.executeQuit();
            }
        });
        
        setThemeColors();

        setVisible(true);
    }
    
    private void setThemeColors() {
//        private JTabbedPane tabbedPane;
//        private JComboBox<Account> accountSelectionComboBox;
//        private JButton selectAccountButton;
//        private JButton exitButton;
//        private JTextField depositAccountNumberField;
//        private JTextField depositAmountField;
//        private JButton depositButton;
//        private JTextField withdrawalAccountNumberField;
//        private JTextField withdrawalAmountField;
//        private JButton withdrawButton;
//        private JTextField balanceCheckAccountNumber;
//        private JButton balanceCheckButton;
//        private JTextField transactionHistoryAccountNumberField;
//        private JRadioButton lastDayRadioButton;
//        private JRadioButton lastMonthRadioButton;
//        private JRadioButton lastYearRadioButton;
//        private JRadioButton customDateRangeRadioButton;
//        private JTextField transactionHistoryStartDateField;
//        private JTextField transactionHistoryEndDateField;
//        private JButton getTransactionHistoryButton;
                
//        AddressField.setBackground(UserSettings.theme.getTextFieldBackgroundColor());
//        DateOfBirthField.setBackground(UserSettings.theme.getTextFieldBackgroundColor());
//        NameField.setBackground(UserSettings.theme.getTextFieldBackgroundColor());
//        PhoneNumberField.setBackground(UserSettings.theme.getTextFieldBackgroundColor());
//        SocialSecurityNumberField.setBackground(UserSettings.theme.getTextFieldBackgroundColor());
//        applyButton.setBackground(UserSettings.theme.getTextFieldBackgroundColor());
//        saveButton.setBackground(UserSettings.theme.getTextFieldBackgroundColor());
//        cancelButton.setBackground(UserSettings.theme.getTextFieldBackgroundColor());
//        deleteButton.setBackground(UserSettings.theme.getTextFieldBackgroundColor());
//        
//        AddressField.setForeground(UserSettings.theme.getTextColor());
//        DateOfBirthField.setForeground(UserSettings.theme.getTextColor());
//        NameField.setForeground(UserSettings.theme.getTextColor());
//        PhoneNumberField.setForeground(UserSettings.theme.getTextColor());
//        SocialSecurityNumberField.setForeground(UserSettings.theme.getTextColor());
//        applyButton.setForeground(UserSettings.theme.getTextColor());
//        saveButton.setForeground(UserSettings.theme.getTextColor());
//        cancelButton.setForeground(UserSettings.theme.getTextColor());
//        deleteButton.setForeground(UserSettings.theme.getTextColor());
//        jLabel2.setForeground(UserSettings.theme.getTextColor());
//        jLabel3.setForeground(UserSettings.theme.getTextColor());
//        jLabel4.setForeground(UserSettings.theme.getTextColor());
//        jLabel5.setForeground(UserSettings.theme.getTextColor());
//        jLabel6.setForeground(UserSettings.theme.getTextColor());
    }
    
    /**
     * This method initializes contentPane
     *
     * @return javax.swing.JPanel
     */
    private JPanel getJContentPane() {
        if (contentPane == null) {
            contentPane = new JPanel();
            contentPane.setLayout(new BorderLayout());
            contentPane.setPreferredSize(new Dimension(600, 400));
            contentPane.setName("ATM_Demo");
            contentPane.setBackground(UserSettings.theme.getBackgroundColor());
            contentPane.add(getTabbedPane(), BorderLayout.CENTER);
        }

        return contentPane;
    }

    /**
     * This method initializes tabbedPane
     *
     * @return javax.swing.JTabbedPane
     */
    private JTabbedPane getTabbedPane() {
        if (tabbedPane == null) {
            tabbedPane = new JTabbedPane();
            tabbedPane.setPreferredSize(new Dimension(9000, 380));
            tabbedPane.addTab("Landing", null, getLandingPanel(), null);
        }

        return tabbedPane;
    }

    /**
     * This method adds additional tabs to the tabbedPane after selecting an
     * account
     *
     * @return javax.swing.JTabbedPane
     */
    private void addTabbedPaneTabs() {
        if (tabbedPane != null) {
            tabbedPane.addTab("Deposit", null, getDepositPanel(), null);
            tabbedPane.addTab("Withdrawal", null, getWithdrawalPanel(), null);
            tabbedPane.addTab("Check Balance", null, getBalanceCheckPanel(), null);
            tabbedPane.addTab("Transaction History", null, getTransactionHistoryPanel(), null);
        }
        
        pack();
    }

    /**
     * This method initializes LandingPanel
     *
     * @return javax.swing.JPanel
     */
    private JPanel getLandingPanel() {
        if (landingPanel == null) {
            GridBagConstraints gridBagConstraints410 = new GridBagConstraints();
            gridBagConstraints410.gridx = 1;
            gridBagConstraints410.gridy = 2;
            GridBagConstraints gridBagConstraints110 = new GridBagConstraints();
            gridBagConstraints110.gridx = 0;
            gridBagConstraints110.gridy = 1;
            GridBagConstraints gridBagConstraints111 = new GridBagConstraints();
            gridBagConstraints111.gridx = 1;
            gridBagConstraints111.gridy = 0;
            GridBagConstraints gridBagConstraints112 = new GridBagConstraints();
            gridBagConstraints112.gridx = 1;
            gridBagConstraints112.gridy = 1;
            logoLabel = new JLabel();
            logoLabel.setText("Insert ATM Logo");
            logoLabel.setPreferredSize(new Dimension(100, 30));
            logoLabel.setForeground(UserSettings.theme.getTextColor());
            landingPanel = new JPanel();
            landingPanel.setLayout(new GridBagLayout());
            landingPanel.setBackground(UserSettings.theme.getBackgroundColor());
            landingPanel.add(logoLabel, gridBagConstraints110);
            landingPanel.add(getAccountSelectionComboBox(), gridBagConstraints111);
            landingPanel.add(getSelectAccountButton(), gridBagConstraints112);
            landingPanel.add(getExitButton(), gridBagConstraints410);
        }

        return landingPanel;
    }

    /**
     * This method initializes depositPanel
     *
     * @return javax.swing.JPanel
     */
    private JPanel getDepositPanel() {
        if (depositPanel == null) {
            GridBagConstraints gridBagConstraints22 = new GridBagConstraints();
            gridBagConstraints22.gridx = 1;
            gridBagConstraints22.gridy = 2;
            GridBagConstraints gridBagConstraints21 = new GridBagConstraints();
            gridBagConstraints21.gridx = 0;
            gridBagConstraints21.gridy = 1;
            depositAmountLabel = new JLabel();
            depositAmountLabel.setText("Amount: ");
            depositAmountLabel.setPreferredSize(new Dimension(100, 25));
            depositAmountLabel.setForeground(UserSettings.theme.getTextColor());
            GridBagConstraints gridBagConstraints20 = new GridBagConstraints();
            gridBagConstraints20.fill = GridBagConstraints.VERTICAL;
            gridBagConstraints20.gridy = 1;
            gridBagConstraints20.weightx = 1.0;
            gridBagConstraints20.gridx = 1;
            GridBagConstraints gridBagConstraints19 = new GridBagConstraints();
            gridBagConstraints19.fill = GridBagConstraints.VERTICAL;
            gridBagConstraints19.gridy = 0;
            gridBagConstraints19.weightx = 1.0;
            gridBagConstraints19.gridx = 1;
            GridBagConstraints gridBagConstraints18 = new GridBagConstraints();
            gridBagConstraints18.gridx = 0;
            gridBagConstraints18.gridy = 0;
            depositAccountNumberLabel = new JLabel();
            depositAccountNumberLabel.setText("Account Number: ");
            depositAccountNumberLabel.setPreferredSize(new Dimension(100, 25));
            depositAccountNumberLabel.setForeground(UserSettings.theme.getTextColor());
            depositPanel = new JPanel();
            depositPanel.setLayout(new GridBagLayout());
            depositPanel.setBackground(UserSettings.theme.getBackgroundColor());
            depositPanel.add(depositAccountNumberLabel, gridBagConstraints18);
            depositPanel.add(getDepositAccountNumberField(), gridBagConstraints19);
            depositPanel.add(getDepositAmountField(), gridBagConstraints20);
            depositPanel.add(depositAmountLabel, gridBagConstraints21);
            depositPanel.add(getDepositButton(), gridBagConstraints22);
        }

        return depositPanel;
    }

    /**
     * This method initializes withdrawalPanel
     *
     * @return javax.swing.JPanel
     */
    private JPanel getWithdrawalPanel() {
        if (withdrawalPanel == null) {
            GridBagConstraints gridBagConstraints27 = new GridBagConstraints();
            gridBagConstraints27.gridx = 1;
            gridBagConstraints27.gridy = 2;
            GridBagConstraints gridBagConstraints26 = new GridBagConstraints();
            gridBagConstraints26.fill = GridBagConstraints.VERTICAL;
            gridBagConstraints26.gridy = 1;
            gridBagConstraints26.weightx = 1.0;
            gridBagConstraints26.gridx = 1;
            GridBagConstraints gridBagConstraints25 = new GridBagConstraints();
            gridBagConstraints25.gridx = 0;
            gridBagConstraints25.gridy = 1;
            withdrawalAmountLabel = new JLabel();
            withdrawalAmountLabel.setText("Amount: ");
            withdrawalAmountLabel.setPreferredSize(new Dimension(100, 25));
            withdrawalAmountLabel.setForeground(UserSettings.theme.getTextColor());
            GridBagConstraints gridBagConstraints24 = new GridBagConstraints();
            gridBagConstraints24.fill = GridBagConstraints.VERTICAL;
            gridBagConstraints24.gridy = 0;
            gridBagConstraints24.weightx = 1.0;
            gridBagConstraints24.gridx = 1;
            GridBagConstraints gridBagConstraints23 = new GridBagConstraints();
            gridBagConstraints23.gridx = 0;
            gridBagConstraints23.gridy = 0;
            withdrawalAccountNumberLabel = new JLabel();
            withdrawalAccountNumberLabel.setText("Account Number: ");
            withdrawalAccountNumberLabel.setPreferredSize(new Dimension(100, 25));
            withdrawalAccountNumberLabel.setForeground(UserSettings.theme.getTextColor());
            withdrawalPanel = new JPanel();
            withdrawalPanel.setLayout(new GridBagLayout());
            withdrawalPanel.setBackground(UserSettings.theme.getBackgroundColor());
            withdrawalPanel.add(withdrawalAccountNumberLabel, gridBagConstraints23);
            withdrawalPanel.add(getWithdrawalAccountNumberField(), gridBagConstraints24);
            withdrawalPanel.add(withdrawalAmountLabel, gridBagConstraints25);
            withdrawalPanel.add(getWithdrawalAmountField(), gridBagConstraints26);
            withdrawalPanel.add(getWithdrawButton(), gridBagConstraints27);
        }

        return withdrawalPanel;
    }

    /**
     * This method initializes balanceCheckPanel
     *
     * @return javax.swing.JPanel
     */
    private JPanel getBalanceCheckPanel() {
        if (balanceCheckPanel == null) {
            GridBagConstraints gridBagConstraints32 = new GridBagConstraints();
            gridBagConstraints32.gridx = 1;
            gridBagConstraints32.gridy = 2;
            GridBagConstraints gridBagConstraints31 = new GridBagConstraints();
            gridBagConstraints31.gridx = 1;
            gridBagConstraints31.gridy = 1;
            balanceCheckCurrentBalance = new JLabel();
            balanceCheckCurrentBalance.setText("");
            balanceCheckCurrentBalance.setPreferredSize(new Dimension(150, 25));
            balanceCheckCurrentBalance.setForeground(UserSettings.theme.getTextColor());
            GridBagConstraints gridBagConstraints29 = new GridBagConstraints();
            gridBagConstraints29.fill = GridBagConstraints.VERTICAL;
            gridBagConstraints29.gridy = 0;
            gridBagConstraints29.weightx = 1.0;
            gridBagConstraints29.gridx = 1;
            GridBagConstraints gridBagConstraints28 = new GridBagConstraints();
            gridBagConstraints28.gridx = 0;
            gridBagConstraints28.gridy = 0;
            balanceCheckAccountNumberLabel = new JLabel();
            balanceCheckAccountNumberLabel.setText("Account Number: ");
            balanceCheckAccountNumberLabel.setPreferredSize(new Dimension(100, 25));
            balanceCheckAccountNumberLabel.setForeground(UserSettings.theme.getTextColor());
            balanceCheckPanel = new JPanel();
            balanceCheckPanel.setLayout(new GridBagLayout());
            balanceCheckPanel.setBackground(UserSettings.theme.getBackgroundColor());
            balanceCheckPanel.add(balanceCheckAccountNumberLabel, gridBagConstraints28);
            balanceCheckPanel.add(getBalanceCheckAccountNumber(), gridBagConstraints29);
            balanceCheckPanel.add(balanceCheckCurrentBalance, gridBagConstraints31);
            balanceCheckPanel.add(getBalanceCheckButton(), gridBagConstraints32);
        }

        return balanceCheckPanel;
    }

    /**
     * This method initializes transactionHistoryPanel
     *
     * @return javax.swing.JPanel
     */
    private JPanel getTransactionHistoryPanel() {
        if (transactionHistoryPanel == null) {
            GridBagConstraints gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = 4;
            gridBagConstraints.gridy = 1;
            GridBagConstraints gridBagConstraints49 = new GridBagConstraints();
            gridBagConstraints49.gridx = 4;
            gridBagConstraints49.gridy = 3;
            GridBagConstraints gridBagConstraints48 = new GridBagConstraints();
            gridBagConstraints48.fill = GridBagConstraints.BOTH;
            gridBagConstraints48.gridy = 4;
            gridBagConstraints48.weightx = 1.0;
            gridBagConstraints48.weighty = 1.0;
            gridBagConstraints48.gridwidth = 8;
            gridBagConstraints48.anchor = GridBagConstraints.SOUTHWEST;
            gridBagConstraints48.ipadx = 0;
            gridBagConstraints48.insets = new Insets(0, 0, 0, 0);
            gridBagConstraints48.gridx = 0;
            GridBagConstraints gridBagConstraints47 = new GridBagConstraints();
            gridBagConstraints47.gridx = 0;
            gridBagConstraints47.gridy = 3;
            endDateLabel = new JLabel();
            endDateLabel.setText("End Date: ");
            endDateLabel.setPreferredSize(new Dimension(100, 20));
            endDateLabel.setForeground(UserSettings.theme.getTextColor());
            GridBagConstraints gridBagConstraints46 = new GridBagConstraints();
            gridBagConstraints46.gridx = 0;
            gridBagConstraints46.gridy = 2;
            startDateLabel = new JLabel();
            startDateLabel.setText("Start Date: ");
            startDateLabel.setPreferredSize(new Dimension(100, 20));
            startDateLabel.setForeground(UserSettings.theme.getTextColor());
            GridBagConstraints gridBagConstraints43 = new GridBagConstraints();
            gridBagConstraints43.fill = GridBagConstraints.BOTH;
            gridBagConstraints43.gridy = 3;
            gridBagConstraints43.weightx = 1.0;
            gridBagConstraints43.gridx = 1;
            GridBagConstraints gridBagConstraints40 = new GridBagConstraints();
            gridBagConstraints40.fill = GridBagConstraints.BOTH;
            gridBagConstraints40.gridy = 2;
            gridBagConstraints40.weightx = 1.0;
            gridBagConstraints40.gridx = 1;
            GridBagConstraints gridBagConstraints38 = new GridBagConstraints();
            gridBagConstraints38.gridx = 0;
            gridBagConstraints38.gridy = 1;
            periodLabel = new JLabel();
            periodLabel.setText("Period: ");
            periodLabel.setPreferredSize(new Dimension(100, 25));
            periodLabel.setForeground(UserSettings.theme.getTextColor());
            GridBagConstraints gridBagConstraints37 = new GridBagConstraints();
            gridBagConstraints37.gridx = 2;
            gridBagConstraints37.gridy = 1;
            GridBagConstraints gridBagConstraints36 = new GridBagConstraints();
            gridBagConstraints36.gridx = 3;
            gridBagConstraints36.gridy = 1;
            GridBagConstraints gridBagConstraints35 = new GridBagConstraints();
            gridBagConstraints35.gridx = 1;
            gridBagConstraints35.gridy = 1;
            GridBagConstraints gridBagConstraints34 = new GridBagConstraints();
            gridBagConstraints34.fill = GridBagConstraints.BOTH;
            gridBagConstraints34.gridy = 0;
            gridBagConstraints34.weightx = 1.0;
            gridBagConstraints34.gridx = 4;
            GridBagConstraints gridBagConstraints33 = new GridBagConstraints();
            gridBagConstraints33.gridx = 0;
            gridBagConstraints33.gridy = 0;
            transactionHistoryAccountNumberLabel = new JLabel();
            transactionHistoryAccountNumberLabel.setText("Account Number: ");
            transactionHistoryAccountNumberLabel.setPreferredSize(new Dimension(100, 25));
            transactionHistoryAccountNumberLabel.setForeground(UserSettings.theme.getTextColor());
            transactionHistoryPanel = new JPanel();
            transactionHistoryPanel.setLayout(new GridBagLayout());
            transactionHistoryPanel.setPreferredSize(new Dimension(500, 91));
            transactionHistoryPanel.setName("systems");
            transactionHistoryPanel.setBackground(UserSettings.theme.getBackgroundColor());
            transactionHistoryPanel.add(transactionHistoryAccountNumberLabel, gridBagConstraints33);
            transactionHistoryPanel.add(getTransactionHistoryAccountNumberField(), gridBagConstraints34);
            transactionHistoryRadioButtonGroup = new ButtonGroup();
            transactionHistoryPanel.add(getLastDayRadioButton(), gridBagConstraints35);
            transactionHistoryPanel.add(getLastYearRadioButton(), gridBagConstraints36);
            transactionHistoryPanel.add(getLastMonthRadioButton(), gridBagConstraints37);
            transactionHistoryPanel.add(periodLabel, gridBagConstraints38);
            transactionHistoryPanel.add(getTransactionHistoryStartDateField(), gridBagConstraints40);
            transactionHistoryPanel.add(getTransactionHistoryEndDateField(), gridBagConstraints43);
            transactionHistoryPanel.add(startDateLabel, gridBagConstraints46);
            transactionHistoryPanel.add(endDateLabel, gridBagConstraints47);
            transactionHistoryPanel.add(getTransactionHistoryList(), gridBagConstraints48);
            transactionHistoryPanel.add(getTransactionHistoryButton(), gridBagConstraints49);
            transactionHistoryPanel.add(getCustomDateRangeRadioButton(), gridBagConstraints);
        }

        return transactionHistoryPanel;
    }

    /**
     * This method initializes depositAccountNumberField
     *
     * @return javax.swing.JTextField
     */
    private JTextField getDepositAccountNumberField() {
        if (depositAccountNumberField == null) {
            depositAccountNumberField = new JTextField();
            depositAccountNumberField.setPreferredSize(new Dimension(150, 25));
            depositAccountNumberField.setBackground(UserSettings.theme.getTextFieldBackgroundColor());
            depositAccountNumberField.setDisabledTextColor(UserSettings.theme.getTextColor());
            depositAccountNumberField.setForeground(UserSettings.theme.getTextColor());
            depositAccountNumberField.setEnabled(false);
        }

        depositAccountNumberField.setText(controller.selectedAccount.AccountNumber.toString());

        return depositAccountNumberField;
    }

    /**
     * This method initializes depositAmountField
     *
     * @return javax.swing.JTextField
     */
    private JTextField getDepositAmountField() {
        if (depositAmountField == null) {
            depositAmountField = new JTextField();
            depositAmountField.setPreferredSize(new Dimension(150, 25));
            depositAmountField.setBackground(UserSettings.theme.getTextFieldBackgroundColor());
            depositAmountField.setForeground(UserSettings.theme.getTextColor());
        }

        return depositAmountField;
    }

    /**
     * This method initializes depositButton
     *
     * @return javax.swing.JButton
     */
    private JButton getDepositButton() {
        if (depositButton == null) {
            depositButton = new JButton();
            depositButton.setText("Deposit");
            depositButton.setPreferredSize(new Dimension(120, 30));
            depositButton.addActionListener((java.awt.event.ActionEvent e) -> {
                BigDecimal amount = new BigDecimal(depositAmountField.getText());
                
                controller.executeDeposit(amount);
            });
        }

        return depositButton;
    }

    /**
     * This method initializes withdrawalAccountNumberField
     *
     * @return javax.swing.JTextField
     */
    private JTextField getWithdrawalAccountNumberField() {
        if (withdrawalAccountNumberField == null) {
            withdrawalAccountNumberField = new JTextField();
            withdrawalAccountNumberField.setPreferredSize(new Dimension(150, 25));
            withdrawalAccountNumberField.setEnabled(false);
            withdrawalAccountNumberField.setBackground(UserSettings.theme.getTextFieldBackgroundColor());
            withdrawalAccountNumberField.setDisabledTextColor(UserSettings.theme.getTextColor());
            withdrawalAccountNumberField.setForeground(UserSettings.theme.getTextColor());
        }

        withdrawalAccountNumberField.setText(controller.selectedAccount.AccountNumber.toString());

        return withdrawalAccountNumberField;
    }

    /**
     * This method initializes withdrawalAmountField
     *
     * @return javax.swing.JTextField
     */
    private JTextField getWithdrawalAmountField() {
        if (withdrawalAmountField == null) {
            withdrawalAmountField = new JTextField();
            withdrawalAmountField.setPreferredSize(new Dimension(150, 25));
            withdrawalAmountField.setBackground(UserSettings.theme.getTextFieldBackgroundColor());
            withdrawalAmountField.setForeground(UserSettings.theme.getTextColor());
        }

        return withdrawalAmountField;
    }

    /**
     * This method initializes jdrawingButton
     *
     * @return javax.swing.JButton
     */
    private JButton getWithdrawButton() {
        if (withdrawButton == null) {
            withdrawButton = new JButton();
            withdrawButton.setText("Withdraw");
            withdrawButton.setPreferredSize(new Dimension(120, 30));
            withdrawButton.addActionListener((java.awt.event.ActionEvent e) -> {
                BigDecimal amount = new BigDecimal(withdrawalAmountField.getText());
                
                controller.executeWithdrawal(amount);
            });
        }

        return withdrawButton;
    }

    /**
     * This method initializes balanceCheckAccountNumber
     *
     * @return javax.swing.JTextField
     */
    private JTextField getBalanceCheckAccountNumber() {
        if (balanceCheckAccountNumber == null) {
            balanceCheckAccountNumber = new JTextField();
            balanceCheckAccountNumber.setPreferredSize(new Dimension(150, 25));
            balanceCheckAccountNumber.setEnabled(false);
            
            UIDefaults overrides = new UIDefaults();
            overrides.put("TextField.background", new ColorUIResource(Color.RED));
            
            balanceCheckAccountNumber.setBackground(UserSettings.theme.getTextFieldBackgroundColor());
            balanceCheckAccountNumber.setDisabledTextColor(UserSettings.theme.getTextColor());
            balanceCheckAccountNumber.setForeground(UserSettings.theme.getTextColor());
        }

        balanceCheckAccountNumber.setText(controller.selectedAccount.AccountNumber.toString());

        return balanceCheckAccountNumber;
    }

    /**
     * This method initializes balanceCheckButton
     *
     * @return javax.swing.JButton
     */
    private JButton getBalanceCheckButton() {
        if (balanceCheckButton == null) {
            balanceCheckButton = new JButton();
            balanceCheckButton.setText("Check Balance");
            balanceCheckButton.setPreferredSize(new Dimension(120, 30));
            balanceCheckButton.addActionListener((java.awt.event.ActionEvent e) -> {
                BigDecimal balance = controller.executeCheckBalance();

                balanceCheckCurrentBalance.setText(String.valueOf(balance));
            });
        }

        return balanceCheckButton;
    }

    /**
     * This method initializes transactionHistoryAccountNumberField
     *
     * @return javax.swing.JTextField
     */
    private JTextField getTransactionHistoryAccountNumberField() {
        if (transactionHistoryAccountNumberField == null) {
            transactionHistoryAccountNumberField = new JTextField();
            transactionHistoryAccountNumberField.setPreferredSize(new Dimension(150, 25));
            transactionHistoryAccountNumberField.setEnabled(false);
            transactionHistoryAccountNumberField.setBackground(UserSettings.theme.getTextFieldBackgroundColor());
            transactionHistoryAccountNumberField.setDisabledTextColor(UserSettings.theme.getTextColor());
            transactionHistoryAccountNumberField.setForeground(UserSettings.theme.getTextColor());
        }

        transactionHistoryAccountNumberField.setText(controller.selectedAccount.AccountNumber.toString());

        return transactionHistoryAccountNumberField;
    }

    /**
     * This method initializes lastDayRadioButton
     *
     * @return javax.swing.JRadioButton
     */
    private JRadioButton getLastDayRadioButton() {
        if (lastDayRadioButton == null) {
            lastDayRadioButton = new JRadioButton();
            lastDayRadioButton.setText("Last Day");
            lastDayRadioButton.setActionCommand("Last Day");
            lastDayRadioButton.setSelected(true);
            transactionHistoryRadioButtonGroup.add(lastDayRadioButton);
        }

        return lastDayRadioButton;
    }

    /**
     * This method initializes lastMonthRadioButton
     *
     * @return javax.swing.JRadioButton
     */
    private JRadioButton getLastMonthRadioButton() {
        if (lastMonthRadioButton == null) {
            lastMonthRadioButton = new JRadioButton();
            lastMonthRadioButton.setText("Last Month");
            lastMonthRadioButton.setActionCommand("Last Month");
            transactionHistoryRadioButtonGroup.add(lastMonthRadioButton);
        }

        return lastMonthRadioButton;
    }

    /**
     * This method initializes lastYearRadioButton
     *
     * @return javax.swing.JRadioButton
     */
    private JRadioButton getLastYearRadioButton() {
        if (lastYearRadioButton == null) {
            lastYearRadioButton = new JRadioButton();
            lastYearRadioButton.setText("Last Year");
            lastYearRadioButton.setActionCommand("Last Year");
            transactionHistoryRadioButtonGroup.add(lastYearRadioButton);
        }

        return lastYearRadioButton;
    }
    
    /**
     * This method initializes transactionHistoryStartDateField
     *
     * @return javax.swing.JTextField
     */
    private JTextField getTransactionHistoryStartDateField() {
        if (transactionHistoryStartDateField == null) {
            transactionHistoryStartDateField = new JTextField();
            transactionHistoryStartDateField.setPreferredSize(new Dimension(150, 25));
            transactionHistoryStartDateField.setBackground(UserSettings.theme.getTextFieldBackgroundColor());
            transactionHistoryStartDateField.setForeground(UserSettings.theme.getTextColor());
        }

        return transactionHistoryStartDateField;
    }
    
    /**
     * This method initializes transactionHistoryEndDateField
     *
     * @return javax.swing.JTextField
     */
    private JTextField getTransactionHistoryEndDateField() {
        if (transactionHistoryEndDateField == null) {
            transactionHistoryEndDateField = new JTextField();
            transactionHistoryEndDateField.setPreferredSize(new Dimension(950, 25));
            transactionHistoryEndDateField.setBackground(UserSettings.theme.getTextFieldBackgroundColor());
            transactionHistoryEndDateField.setForeground(UserSettings.theme.getTextColor());
        }

        return transactionHistoryEndDateField;
    }

    /**
     * This method initializes transactionHistoryList
     *
     * @return javax.swing.JList
     */
    private JList getTransactionHistoryList() {
        if (transactionHistoryList == null) {
            transactionHistoryList = new JList<>();
            transactionHistoryList.setBackground(UserSettings.theme.getListBackgroundColor());
            transactionHistoryList.setForeground(UserSettings.theme.getTextColor());
        }

        return transactionHistoryList;
    }

    /**
     * This method initializes getTransactionHistoryButton
     *
     * @return javax.swing.JButton
     */
    private JButton getTransactionHistoryButton() {
        if (getTransactionHistoryButton == null) {
            getTransactionHistoryButton = new JButton();
            getTransactionHistoryButton.setPreferredSize(new Dimension(200, 20));
            getTransactionHistoryButton.setText("Get Transaction History");
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
                            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                            
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
        }

        return getTransactionHistoryButton;
    }

    /**
     * This method initializes accountSelectionComboBox
     *
     * @return javax.swing.JComboBox
     */
    private JComboBox getAccountSelectionComboBox() {
        if (accountSelectionComboBox == null) {
            accountSelectionComboBox = new JComboBox<>();
            accountSelectionComboBox.setModel(controller.accountModel);
            accountSelectionComboBox.setPreferredSize(new Dimension(120, 25));
            accountSelectionComboBox.setToolTipText("Accounts");
            accountSelectionComboBox.setName("Accounts");
        }

        return accountSelectionComboBox;
    }

    /**
     * This method initializes selectAccountButton
     *
     * @return javax.swing.JButton
     */
    private JButton getSelectAccountButton() {
        if (selectAccountButton == null) {
            selectAccountButton = new JButton();
            selectAccountButton.setText("Select Account");
            selectAccountButton.setPreferredSize(new Dimension(120, 30));
            selectAccountButton.addActionListener((java.awt.event.ActionEvent e) -> {
                controller.selectedAccount = (Account) accountSelectionComboBox.getSelectedItem();

                tabbedPane.remove(depositPanel);
                tabbedPane.remove(withdrawalPanel);
                tabbedPane.remove(balanceCheckPanel);
                tabbedPane.remove(transactionHistoryPanel);

                depositPanel = null;
                withdrawalPanel = null;
                balanceCheckPanel = null;
                transactionHistoryPanel = null;

                addTabbedPaneTabs();
            });
        }

        return selectAccountButton;
    }

    /**
     * This method initializes exitButton
     *
     * @return javax.swing.JButton
     */
    private JButton getExitButton() {
        if (exitButton == null) {
            exitButton = new JButton();
            exitButton.setText("Quit ATM");
            exitButton.setPreferredSize(new Dimension(120, 30));
            exitButton.addActionListener((java.awt.event.ActionEvent e) -> {
                int n = JOptionPane.showConfirmDialog(landingPanel,
                        "Quit ATM?", "Confirm Exit",
                        JOptionPane.OK_CANCEL_OPTION);
                if (n == JOptionPane.YES_OPTION) {
                    controller.executeQuit();
                }
            });
        }

        return exitButton;
    }

    private JRadioButton getCustomDateRangeRadioButton() {
        if (customDateRangeRadioButton == null) {
            customDateRangeRadioButton = new JRadioButton();
            customDateRangeRadioButton.setPreferredSize(new Dimension(150, 20));
            customDateRangeRadioButton.setText("Custom Date Range");
            customDateRangeRadioButton.setActionCommand("Custom Date Range");
            transactionHistoryRadioButtonGroup.add(customDateRangeRadioButton);
        }

        return customDateRangeRadioButton;
    }
}
