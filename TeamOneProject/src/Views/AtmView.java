/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

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
    private JScrollPane transactionHistoryScrollPanel;
    private JList<AccountTransaction> transactionHistoryList;
    private JButton getTransactionHistoryButton;
    private ButtonGroup transactionHistoryRadioButtonGroup;
    private final AtmViewController controller;

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Constructors"> 
    /**
     * This is the default constructor
     *
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

        setBounds(new Rectangle(0, 0, 616, 439));
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                controller.executeQuit();
            }
        });

        setResizable(false);
        setVisible(true);
    }

    /**
     * This method initializes contentPane
     *
     * @return javax.swing.JPanel
     */
    private JPanel getJContentPane() {
        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        contentPane.setPreferredSize(new Dimension(600, 400));
        contentPane.setName("ATM_Demo");
        contentPane.setBackground(UserSettings.theme.getBackgroundColor());
        contentPane.add(getTabbedPane(), BorderLayout.CENTER);

        return contentPane;
    }

    /**
     * This method initializes tabbedPane
     *
     * @return javax.swing.JTabbedPane
     */
    private JTabbedPane getTabbedPane() {
        tabbedPane = new JTabbedPane();
        tabbedPane.setPreferredSize(new Dimension(9000, 380));
        tabbedPane.addTab("Landing", null, getLandingPanel(), null);

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
        accountLabel.setForeground(UserSettings.theme.getTextColor());
        selectedThemeLabel = new JLabel();
        selectedThemeLabel.setText("Selected Theme: ");
        selectedThemeLabel.setForeground(UserSettings.theme.getTextColor());
        landingPanel = new JPanel();
        landingPanel.setLayout(new GridBagLayout());
        landingPanel.setBackground(UserSettings.theme.getBackgroundColor());
        landingPanel.add(logoLabel, gridBagConstraintsLogoLabel);
        landingPanel.add(accountLabel, gridBagConstraintsAccountLabel);
        landingPanel.add(getAccountSelectionComboBox(), gridBagConstraintsAccountSelectionComboBox);
        landingPanel.add(selectedThemeLabel, gridBagConstraintsSelectedThemeLabel);
        landingPanel.add(getSelectedThemeComboBox(), gridBagConstraintsSelectedThemeComboBox);
        landingPanel.add(getExitButton(), gridBagConstraintsExitButton);

        return landingPanel;
    }

    /**
     * This method initializes depositPanel
     *
     * @return javax.swing.JPanel
     */
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
        depositAmountLabel.setForeground(UserSettings.theme.getTextColor());
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
        depositAccountNumberLabel.setForeground(UserSettings.theme.getTextColor());
        depositPanel = new JPanel();
        depositPanel.setLayout(new GridBagLayout());
        depositPanel.setBackground(UserSettings.theme.getBackgroundColor());
        depositPanel.add(depositAccountNumberLabel, gridBagConstraintsDepositAccountNumberLabel);
        depositPanel.add(getDepositAccountNumberField(), gridBagConstraintsDepositAccountNumberField);
        depositPanel.add(getDepositAmountField(), gridBagConstraintsDepositAmountField);
        depositPanel.add(depositAmountLabel, gridBagConstraintsDepositAmountLabel);
        depositPanel.add(getDepositButton(), gridBagConstraintsDepositButton);

        return depositPanel;
    }

    /**
     * This method initializes withdrawalPanel
     *
     * @return javax.swing.JPanel
     */
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
        withdrawalAmountLabel.setForeground(UserSettings.theme.getTextColor());
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
        withdrawalAccountNumberLabel.setForeground(UserSettings.theme.getTextColor());
        withdrawalPanel = new JPanel();
        withdrawalPanel.setLayout(new GridBagLayout());
        withdrawalPanel.setBackground(UserSettings.theme.getBackgroundColor());
        withdrawalPanel.add(withdrawalAccountNumberLabel, gridBagConstraintsWithdrawalAccountNumberLabel);
        withdrawalPanel.add(getWithdrawalAccountNumberField(), gridBagConstraintsWithdrawalAccountNumberField);
        withdrawalPanel.add(withdrawalAmountLabel, gridBagConstraintsWithdrawalAmountLabel);
        withdrawalPanel.add(getWithdrawalAmountField(), gridBagConstraintsWithdrawalAmountField);
        withdrawalPanel.add(getWithdrawButton(), gridBagConstraintsWithdrawButton);

        return withdrawalPanel;
    }

    /**
     * This method initializes balanceCheckPanel
     *
     * @return javax.swing.JPanel
     */
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
        balanceCheckCurrentBalance.setForeground(UserSettings.theme.getTextColor());
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
        balanceCheckAccountNumberLabel.setForeground(UserSettings.theme.getTextColor());
        GridBagConstraints gridBagConstraintsBalanceCheckBalanceLabel = new GridBagConstraints();
        gridBagConstraintsBalanceCheckBalanceLabel.gridx = 0;
        gridBagConstraintsBalanceCheckBalanceLabel.gridy = 1;
        gridBagConstraintsBalanceCheckBalanceLabel.anchor = GridBagConstraints.EAST;
        balanceCheckBalanceLabel = new JLabel();
        balanceCheckBalanceLabel.setText("Balance: ");
        balanceCheckBalanceLabel.setForeground(UserSettings.theme.getTextColor());
        balanceCheckPanel = new JPanel();
        balanceCheckPanel.setLayout(new GridBagLayout());
        balanceCheckPanel.setBackground(UserSettings.theme.getBackgroundColor());
        balanceCheckPanel.add(balanceCheckAccountNumberLabel, gridBagConstraintsBalanceCheckAccountNumberLabel);
        balanceCheckPanel.add(balanceCheckBalanceLabel, gridBagConstraintsBalanceCheckBalanceLabel);
        balanceCheckPanel.add(getBalanceCheckAccountNumberField(), gridBagConstraintsBalanceCheckAccountNumberField);
        balanceCheckPanel.add(balanceCheckCurrentBalance, gridBagConstraintsBalanceCheckCurrentBalance);
        balanceCheckPanel.add(getBalanceCheckButton(), gridBagConstraintsBalanceCheckButton);

        return balanceCheckPanel;
    }

    /**
     * This method initializes transactionHistoryPanel
     *
     * @return javax.swing.JPanel
     */
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
        endDateLabel.setForeground(UserSettings.theme.getTextColor());
        GridBagConstraints gridBagConstraintsStartDateLabel = new GridBagConstraints();
        gridBagConstraintsStartDateLabel.gridx = 0;
        gridBagConstraintsStartDateLabel.gridy = 2;
        gridBagConstraintsStartDateLabel.anchor = GridBagConstraints.EAST;
        startDateLabel = new JLabel();
        startDateLabel.setText("Start Date: ");
        startDateLabel.setForeground(UserSettings.theme.getTextColor());
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
        periodLabel.setForeground(UserSettings.theme.getTextColor());
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
        transactionHistoryAccountNumberLabel.setForeground(UserSettings.theme.getTextColor());
        transactionHistoryPanel = new JPanel();
        transactionHistoryPanel.setLayout(new GridBagLayout());
        transactionHistoryPanel.setPreferredSize(new Dimension(500, 91));
        transactionHistoryPanel.setName("systems");
        transactionHistoryPanel.setBackground(UserSettings.theme.getBackgroundColor());
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
        transactionHistoryPanel.add(getTransactionHistoryList(), gridBagConstraintsTransactionHistoryList);
        transactionHistoryPanel.add(getTransactionHistoryButton(), gridBagConstraintsGetTransactionHistoryButton);
        transactionHistoryPanel.add(getCustomDateRangeRadioButton(), gridBagConstraintsCustomDateRangeRadioButton);

        return transactionHistoryPanel;
    }

    /**
     * This method initializes depositAccountNumberField
     *
     * @return javax.swing.JLabel
     */
    private JLabel getDepositAccountNumberField() {
        depositAccountNumberField = new JLabel();
        depositAccountNumberField.setForeground(UserSettings.theme.getTextColor());
        if (controller.selectedAccount != null && controller.selectedAccount.AccountNumber != null) {
            depositAccountNumberField.setText(controller.selectedAccount.AccountNumber.toString());
        }

        return depositAccountNumberField;
    }

    /**
     * This method initializes depositAmountField
     *
     * @return javax.swing.JTextField
     */
    private JTextField getDepositAmountField() {
        depositAmountField = new JTextField();
        depositAmountField.setPreferredSize(new Dimension(120, 25));
        depositAmountField.setBackground(UserSettings.theme.getTextFieldBackgroundColor());
        depositAmountField.setForeground(UserSettings.theme.getTextColor());

        return depositAmountField;
    }

    /**
     * This method initializes depositButton
     *
     * @return javax.swing.JButton
     */
    private JButton getDepositButton() {
        depositButton = new JButton();
        depositButton.setText("Deposit");
        depositButton.setPreferredSize(new Dimension(120, 30));
        depositButton.setBackground(UserSettings.theme.getButtonBackgroundColor());
        depositButton.setForeground(UserSettings.theme.getTextColor());
        depositButton.addActionListener((java.awt.event.ActionEvent e) -> {
            BigDecimal amount = new BigDecimal(depositAmountField.getText());

            controller.executeDeposit(amount);
        });

        return depositButton;
    }

    /**
     * This method initializes withdrawalAccountNumberField
     *
     * @return javax.swing.JLabel
     */
    private JLabel getWithdrawalAccountNumberField() {
        withdrawalAccountNumberField = new JLabel();
        withdrawalAccountNumberField.setForeground(UserSettings.theme.getTextColor());
        if (controller.selectedAccount != null && controller.selectedAccount.AccountNumber != null) {
            withdrawalAccountNumberField.setText(controller.selectedAccount.AccountNumber.toString());
        }

        return withdrawalAccountNumberField;
    }

    /**
     * This method initializes withdrawalAmountField
     *
     * @return javax.swing.JTextField
     */
    private JTextField getWithdrawalAmountField() {
        withdrawalAmountField = new JTextField();
        withdrawalAmountField.setPreferredSize(new Dimension(120, 25));
        withdrawalAmountField.setBackground(UserSettings.theme.getTextFieldBackgroundColor());
        withdrawalAmountField.setForeground(UserSettings.theme.getTextColor());

        return withdrawalAmountField;
    }

    /**
     * This method initializes jdrawingButton
     *
     * @return javax.swing.JButton
     */
    private JButton getWithdrawButton() {
        withdrawButton = new JButton();
        withdrawButton.setText("Withdraw");
        withdrawButton.setPreferredSize(new Dimension(120, 30));
        withdrawButton.setBackground(UserSettings.theme.getButtonBackgroundColor());
        withdrawButton.setForeground(UserSettings.theme.getTextColor());
        withdrawButton.addActionListener((java.awt.event.ActionEvent e) -> {
            BigDecimal amount = new BigDecimal(withdrawalAmountField.getText());

            if (!controller.executeWithdrawal(amount))
            {
                JOptionPane.showMessageDialog(withdrawalPanel, "Insufficient funds to make withdrawal.");
            }
        });

        return withdrawButton;
    }

    /**
     * This method initializes balanceCheckAccountNumberField
     *
     * @return javax.swing.JLabel
     */
    private JLabel getBalanceCheckAccountNumberField() {
        balanceCheckAccountNumberField = new JLabel();
        balanceCheckAccountNumberField.setForeground(UserSettings.theme.getTextColor());
        if (controller.selectedAccount != null && controller.selectedAccount.AccountNumber != null) {
            balanceCheckAccountNumberField.setText(controller.selectedAccount.AccountNumber.toString());
        }

        return balanceCheckAccountNumberField;
    }

    /**
     * This method initializes balanceCheckButton
     *
     * @return javax.swing.JButton
     */
    private JButton getBalanceCheckButton() {
        balanceCheckButton = new JButton();
        balanceCheckButton.setText("Check Balance");
        balanceCheckButton.setPreferredSize(new Dimension(120, 30));
        balanceCheckButton.setBackground(UserSettings.theme.getButtonBackgroundColor());
        balanceCheckButton.setForeground(UserSettings.theme.getTextColor());
        balanceCheckButton.addActionListener((java.awt.event.ActionEvent e) -> {
            BigDecimal balance = controller.executeCheckBalance();

            balanceCheckCurrentBalance.setText(String.valueOf(balance));
        });

        return balanceCheckButton;
    }

    /**
     * This method initializes transactionHistoryAccountNumberField
     *
     * @return javax.swing.JLabel
     */
    private JLabel getTransactionHistoryAccountNumberField() {
        transactionHistoryAccountNumberField = new JLabel();
        transactionHistoryAccountNumberField.setForeground(UserSettings.theme.getTextColor());
        if (controller.selectedAccount != null && controller.selectedAccount.AccountNumber != null) {
            transactionHistoryAccountNumberField.setText(controller.selectedAccount.AccountNumber.toString());
        }

        return transactionHistoryAccountNumberField;
    }

    /**
     * This method initializes lastDayRadioButton
     *
     * @return javax.swing.JRadioButton
     */
    private JRadioButton getLastDayRadioButton() {
        lastDayRadioButton = new JRadioButton();
        lastDayRadioButton.setText("Last Day");
        lastDayRadioButton.setActionCommand("Last Day");
        lastDayRadioButton.setForeground(UserSettings.theme.getTextColor());
        lastDayRadioButton.setSelected(true);
        transactionHistoryRadioButtonGroup.add(lastDayRadioButton);

        return lastDayRadioButton;
    }

    /**
     * This method initializes lastMonthRadioButton
     *
     * @return javax.swing.JRadioButton
     */
    private JRadioButton getLastMonthRadioButton() {
        lastMonthRadioButton = new JRadioButton();
        lastMonthRadioButton.setText("Last Month");
        lastMonthRadioButton.setActionCommand("Last Month");
        lastMonthRadioButton.setForeground(UserSettings.theme.getTextColor());
        transactionHistoryRadioButtonGroup.add(lastMonthRadioButton);

        return lastMonthRadioButton;
    }

    /**
     * This method initializes lastYearRadioButton
     *
     * @return javax.swing.JRadioButton
     */
    private JRadioButton getLastYearRadioButton() {
        lastYearRadioButton = new JRadioButton();
        lastYearRadioButton.setText("Last Year");
        lastYearRadioButton.setActionCommand("Last Year");
        lastYearRadioButton.setForeground(UserSettings.theme.getTextColor());
        transactionHistoryRadioButtonGroup.add(lastYearRadioButton);

        return lastYearRadioButton;
    }

    /**
     * This method initializes transactionHistoryStartDateField
     *
     * @return javax.swing.JTextField
     */
    private JTextField getTransactionHistoryStartDateField() {
        transactionHistoryStartDateField = new JTextField();
        transactionHistoryStartDateField.setBackground(UserSettings.theme.getTextFieldBackgroundColor());
        transactionHistoryStartDateField.setForeground(UserSettings.theme.getTextColor());

        return transactionHistoryStartDateField;
    }

    /**
     * This method initializes transactionHistoryEndDateField
     *
     * @return javax.swing.JTextField
     */
    private JTextField getTransactionHistoryEndDateField() {
        transactionHistoryEndDateField = new JTextField();
        transactionHistoryEndDateField.setBackground(UserSettings.theme.getTextFieldBackgroundColor());
        transactionHistoryEndDateField.setForeground(UserSettings.theme.getTextColor());

        return transactionHistoryEndDateField;
    }

    /**
     * This method initializes transactionHistoryList
     *
     * @return javax.swing.JScrollPane
     */
    private JScrollPane getTransactionHistoryList() {
        transactionHistoryScrollPanel = new JScrollPane();
        transactionHistoryList = new JList<>();
        transactionHistoryList.setBackground(UserSettings.theme.getListBackgroundColor());
        transactionHistoryList.setForeground(UserSettings.theme.getTextColor());
        transactionHistoryScrollPanel.setViewportView(transactionHistoryList);

        return transactionHistoryScrollPanel;
    }

    /**
     * This method initializes getTransactionHistoryButton
     *
     * @return javax.swing.JButton
     */
    private JButton getTransactionHistoryButton() {
        getTransactionHistoryButton = new JButton();
        getTransactionHistoryButton.setText("Get Transaction History");
        getTransactionHistoryButton.setBackground(UserSettings.theme.getButtonBackgroundColor());
        getTransactionHistoryButton.setForeground(UserSettings.theme.getTextColor());
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

        return getTransactionHistoryButton;
    }

    /**
     * This method initializes accountSelectionComboBox
     *
     * @return javax.swing.JComboBox
     */
    private JComboBox getAccountSelectionComboBox() {
        accountSelectionComboBox = new JComboBox<>();
        accountSelectionComboBox.setModel(controller.accountModel);
        accountSelectionComboBox.setPreferredSize(new Dimension(250, 25));
        accountSelectionComboBox.setToolTipText("Accounts");
        accountSelectionComboBox.setName("Accounts");
        accountSelectionComboBox.setSelectedItem(null);
        accountSelectionComboBox.setBackground(UserSettings.theme.getComboBoxBackgroundColor());
        accountSelectionComboBox.setForeground(UserSettings.theme.getTextColor());
        accountSelectionComboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public void paint(Graphics g) {
            setBackground(UserSettings.theme.getListBackgroundColor());
            setForeground(UserSettings.theme.getTextColor());
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

    /**
     * This method initializes selectedThemeComboBox
     *
     * @return javax.swing.JComboBox
     */
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
        selectedThemeComboBox.setBackground(UserSettings.theme.getComboBoxBackgroundColor());
        selectedThemeComboBox.setForeground(UserSettings.theme.getTextColor());
        selectedThemeComboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public void paint(Graphics g) {
            setBackground(UserSettings.theme.getListBackgroundColor());
            setForeground(UserSettings.theme.getTextColor());
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

    /**
     * This method initializes exitButton
     *
     * @return javax.swing.JButton
     */
    private JButton getExitButton() {
        exitButton = new JButton();
        exitButton.setText("Quit ATM");
        exitButton.setPreferredSize(new Dimension(120, 30));
        exitButton.setBackground(UserSettings.theme.getButtonBackgroundColor());
        exitButton.setForeground(UserSettings.theme.getTextColor());
        exitButton.addActionListener((java.awt.event.ActionEvent e) -> {
            int n = JOptionPane.showConfirmDialog(landingPanel,
                    "Quit ATM?", "Confirm Exit",
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
        customDateRangeRadioButton.setForeground(UserSettings.theme.getTextColor());
        transactionHistoryRadioButtonGroup.add(customDateRangeRadioButton);

        return customDateRangeRadioButton;
    }
}
