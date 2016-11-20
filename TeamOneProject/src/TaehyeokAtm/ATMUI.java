/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TaehyeokAtm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import javax.imageio.ImageIO;

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

public class ATMUI extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;

    private JTabbedPane tabbedPane;

    private JPanel landingPanel;

    private JPanel depositPanel;

    private JPanel withdrawalPanel;

    private JPanel balanceCheckPanel;

    private JPanel transactionHistoryPanel;

    private JLabel accountNumberLabel2;

    private JTextField depositAccountNumberField;

    private JTextField depositTradeMoneyField;

    private JLabel depositLabel;

    private JButton depositButton;

    private JLabel accountNumberLabel3;

    private JTextField withdrawalAccountNumberField;

    private JLabel withdrawalLabel;

    private JTextField withdrawalAccountTradeMoneyField;

    private JButton withdrawalButton;

    private JLabel accountNumberLabel4;

    private JTextField inquiryBalanceAccountNumber;

    private JLabel inquiryBalanceBalance;

    private JButton inquiryBalanceButton;

    private JLabel accountNumberLabel;

    private JTextField inquiryTradeAccountNumberField;

    private JRadioButton lastDayRadioButton;

    private JRadioButton lastMonthRadioButton;

    private JRadioButton lastYearRadioButton;

    private JRadioButton customDateRangeRadioButton;

    private JLabel periodLabel;

    private JComboBox<String> startYearComboBox;

    private JComboBox<String> startMonthComboBox;

    private JComboBox<String> startDayComboBox;

    private JComboBox<String> endYearComboBox;

    private JComboBox<String> endMonthComboBox;

    private JComboBox<String> endDayComboBox;

    private JLabel startDateLabel;

    private JLabel endDateLabel;

    private JList<String> inquiryTradeList;

    private JButton getTransactionHistoryButton;

    private JLabel logoLabel;
    
    private JButton exitButton;

    private final Accontrol acc;

    Trade td[];

    ButtonGroup transactionHistoryRadioButtonGroup;

    /**
     * This is the default constructor
     */
    public ATMUI() {
        super();
        initialize();
        acc = new Accontrol();
    }

    /**
     * This method initializes this
     *
     * @return void
     */
    private void initialize() {
        this.setContentPane(getJContentPane());
        this.setTitle("ATM Demo");

        this.setBounds(new Rectangle(0, 0, 600, 300));
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                try {
                    acc.saveacc();
                    System.exit(0);
                } catch (Exception ex) {
                }
            }
        });
    }

    public class back extends JFrame {

        Image img = null;

        back() {
            try {
                File image = new File("/Users/taehyeoklee/Pictures/coms309.jpg");

                //배경 Panel 생성후 컨텐츠페인으로 지정      
                img = ImageIO.read(image);
            } catch (IOException e) {
                System.out.println("Exception occurred loading image");
            }
        }
    }

    public String showdetails(Trade td) {
        String type;
        if (td.getTradeType()) {
            type = "Deposit";
        } else {
            type = "Withdrawal";
        }
        String details = "Date: ";
        long times = td.getTradeDate();
        Date dt = new Date();
        dt.setTime(times);
        details = details.concat(dt.toString());
        details = details.concat("Balance: ");
        details = details.concat(String.valueOf(td.getBalance()));
        details = details.concat(type);
        details = details.concat("Amount: ");
        details = details.concat(String.valueOf(td.getTradeMoney()));

        return details;
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
            contentPane.add(getJTabbedPane(), BorderLayout.CENTER);
        }

        return contentPane;
    }

    /**
     * This method initializes tabbedPane
     *
     * @return javax.swing.JTabbedPane
     */
    private JTabbedPane getJTabbedPane() {
        if (tabbedPane == null) {
            tabbedPane = new JTabbedPane();
            tabbedPane.setPreferredSize(new Dimension(9000, 380));
            tabbedPane.addTab("Landing", null, getLandingPanel(), null);
            tabbedPane.addTab("Deposit", null, getDepositPanel(), null);
            tabbedPane.addTab("Withdrawal", null, getWithdrawalPanel(), null);
            tabbedPane.addTab("Check Balance", null, getBalanceCheckPanel(), null);
            tabbedPane.addTab("Transaction History", null, getTransactionHistoryPanel(), null);
        }

        return tabbedPane;
    }

    /**
     * This method initializes LandingPanel
     *
     * @return javax.swing.JPanel
     */
    private JPanel getLandingPanel() {
        if (landingPanel == null) {
            GridBagConstraints gridBagConstraints410 = new GridBagConstraints();
            gridBagConstraints410.gridx = 2;
            gridBagConstraints410.gridy = 2;
            GridBagConstraints gridBagConstraints110 = new GridBagConstraints();
            gridBagConstraints110.gridx = 0;
            gridBagConstraints110.gridy = 0;
            logoLabel = new JLabel();
            logoLabel.setText("Insert ATM Logo");
            logoLabel.setPreferredSize(new Dimension(100, 30));
            landingPanel = new JPanel();
            landingPanel.setLayout(new GridBagLayout());
            landingPanel.add(logoLabel, gridBagConstraints110);
            landingPanel.add(getJexitButton1(), gridBagConstraints410);
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
            depositLabel = new JLabel();
            depositLabel.setText("Deposit: ");
            depositLabel.setPreferredSize(new Dimension(100, 25));
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
            accountNumberLabel2 = new JLabel();
            accountNumberLabel2.setText("Account Number: ");
            accountNumberLabel2.setPreferredSize(new Dimension(100, 25));
            depositPanel = new JPanel();
            depositPanel.setLayout(new GridBagLayout());
            depositPanel.add(accountNumberLabel2, gridBagConstraints18);
            depositPanel.add(getJTextField_deposit_acnumber(), gridBagConstraints19);
            depositPanel.add(getJTextField_deposit_trademoney(), gridBagConstraints20);
            depositPanel.add(depositLabel, gridBagConstraints21);
            depositPanel.add(getJDepositButton(), gridBagConstraints22);
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
            withdrawalLabel = new JLabel();
            withdrawalLabel.setText("Withdrawal: ");
            withdrawalLabel.setPreferredSize(new Dimension(100, 25));
            GridBagConstraints gridBagConstraints24 = new GridBagConstraints();
            gridBagConstraints24.fill = GridBagConstraints.VERTICAL;
            gridBagConstraints24.gridy = 0;
            gridBagConstraints24.weightx = 1.0;
            gridBagConstraints24.gridx = 1;
            GridBagConstraints gridBagConstraints23 = new GridBagConstraints();
            gridBagConstraints23.gridx = 0;
            gridBagConstraints23.gridy = 0;
            accountNumberLabel3 = new JLabel();
            accountNumberLabel3.setText("Account Number: ");
            accountNumberLabel3.setPreferredSize(new Dimension(100, 25));
            withdrawalPanel = new JPanel();
            withdrawalPanel.setLayout(new GridBagLayout());
            withdrawalPanel.add(accountNumberLabel3, gridBagConstraints23);
            withdrawalPanel.add(getJTextField_drawing_acnumber(), gridBagConstraints24);
            withdrawalPanel.add(withdrawalLabel, gridBagConstraints25);
            withdrawalPanel.add(getJTextField_drawing_trademoney(), gridBagConstraints26);
            withdrawalPanel.add(getJWithdrawalButton(), gridBagConstraints27);
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
            inquiryBalanceBalance = new JLabel();
            inquiryBalanceBalance.setText("");
            inquiryBalanceBalance.setPreferredSize(new Dimension(150, 25));
            GridBagConstraints gridBagConstraints29 = new GridBagConstraints();
            gridBagConstraints29.fill = GridBagConstraints.VERTICAL;
            gridBagConstraints29.gridy = 0;
            gridBagConstraints29.weightx = 1.0;
            gridBagConstraints29.gridx = 1;
            GridBagConstraints gridBagConstraints28 = new GridBagConstraints();
            gridBagConstraints28.gridx = 0;
            gridBagConstraints28.gridy = 0;
            accountNumberLabel4 = new JLabel();
            accountNumberLabel4.setText("Account Number: ");
            accountNumberLabel4.setPreferredSize(new Dimension(100, 25));
            balanceCheckPanel = new JPanel();
            balanceCheckPanel.setLayout(new GridBagLayout());
            balanceCheckPanel.add(accountNumberLabel4, gridBagConstraints28);
            balanceCheckPanel.add(getJTextField_inquirybalance_acnumber(), gridBagConstraints29);
            balanceCheckPanel.add(inquiryBalanceBalance, gridBagConstraints31);
            balanceCheckPanel.add(getInquiryBalanceButton(), gridBagConstraints32);
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
            gridBagConstraints.gridx = 7;
            gridBagConstraints.gridy = 1;
            GridBagConstraints gridBagConstraints49 = new GridBagConstraints();
            gridBagConstraints49.gridx = 7;
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
            GridBagConstraints gridBagConstraints46 = new GridBagConstraints();
            gridBagConstraints46.gridx = 0;
            gridBagConstraints46.gridy = 2;
            startDateLabel = new JLabel();
            startDateLabel.setText("Start Date: ");
            startDateLabel.setPreferredSize(new Dimension(100, 20));
            GridBagConstraints gridBagConstraints45 = new GridBagConstraints();
            gridBagConstraints45.fill = GridBagConstraints.VERTICAL;
            gridBagConstraints45.gridy = 3;
            gridBagConstraints45.weightx = 1.0;
            gridBagConstraints45.gridx = 5;
            GridBagConstraints gridBagConstraints44 = new GridBagConstraints();
            gridBagConstraints44.fill = GridBagConstraints.VERTICAL;
            gridBagConstraints44.gridy = 3;
            gridBagConstraints44.weightx = 1.0;
            gridBagConstraints44.gridx = 4;
            GridBagConstraints gridBagConstraints43 = new GridBagConstraints();
            gridBagConstraints43.fill = GridBagConstraints.VERTICAL;
            gridBagConstraints43.gridy = 3;
            gridBagConstraints43.weightx = 1.0;
            gridBagConstraints43.gridx = 3;
            GridBagConstraints gridBagConstraints42 = new GridBagConstraints();
            gridBagConstraints42.fill = GridBagConstraints.VERTICAL;
            gridBagConstraints42.gridy = 2;
            gridBagConstraints42.weightx = 1.0;
            gridBagConstraints42.gridx = 5;
            GridBagConstraints gridBagConstraints41 = new GridBagConstraints();
            gridBagConstraints41.fill = GridBagConstraints.VERTICAL;
            gridBagConstraints41.gridy = 2;
            gridBagConstraints41.weightx = 1.0;
            gridBagConstraints41.gridx = 4;
            GridBagConstraints gridBagConstraints40 = new GridBagConstraints();
            gridBagConstraints40.fill = GridBagConstraints.VERTICAL;
            gridBagConstraints40.gridy = 2;
            gridBagConstraints40.weightx = 1.0;
            gridBagConstraints40.gridx = 3;
            GridBagConstraints gridBagConstraints38 = new GridBagConstraints();
            gridBagConstraints38.gridx = 0;
            gridBagConstraints38.gridy = 1;
            periodLabel = new JLabel();
            periodLabel.setText("Period: ");
            periodLabel.setPreferredSize(new Dimension(100, 25));
            GridBagConstraints gridBagConstraints37 = new GridBagConstraints();
            gridBagConstraints37.gridx = 5;
            gridBagConstraints37.gridy = 1;
            GridBagConstraints gridBagConstraints36 = new GridBagConstraints();
            gridBagConstraints36.gridx = 4;
            gridBagConstraints36.gridy = 1;
            GridBagConstraints gridBagConstraints35 = new GridBagConstraints();
            gridBagConstraints35.gridx = 3;
            gridBagConstraints35.gridy = 1;
            GridBagConstraints gridBagConstraints34 = new GridBagConstraints();
            gridBagConstraints34.fill = GridBagConstraints.VERTICAL;
            gridBagConstraints34.gridy = 0;
            gridBagConstraints34.weightx = 1.0;
            gridBagConstraints34.gridx = 7;
            GridBagConstraints gridBagConstraints33 = new GridBagConstraints();
            gridBagConstraints33.gridx = 0;
            gridBagConstraints33.gridy = 0;
            accountNumberLabel = new JLabel();
            accountNumberLabel.setText("Account Number: ");
            accountNumberLabel.setPreferredSize(new Dimension(100, 25));
            transactionHistoryPanel = new JPanel();
            transactionHistoryPanel.setLayout(new GridBagLayout());
            transactionHistoryPanel.setPreferredSize(new Dimension(500, 91));
            transactionHistoryPanel.setName("systems");
            transactionHistoryPanel.add(accountNumberLabel, gridBagConstraints33);
            transactionHistoryPanel.add(getJTextField_inquirytrade_acnumber(), gridBagConstraints34);
            transactionHistoryRadioButtonGroup = new ButtonGroup();
            transactionHistoryPanel.add(getLastDayRadioButton(), gridBagConstraints35);
            transactionHistoryPanel.add(getLastYearRadioButton(), gridBagConstraints36);
            transactionHistoryPanel.add(getLastMonthRadioButton(), gridBagConstraints37);
            transactionHistoryPanel.add(periodLabel, gridBagConstraints38);
            transactionHistoryPanel.add(getStartYearComboBox(), gridBagConstraints40);
            transactionHistoryPanel.add(getStartMonthComboBox(), gridBagConstraints41);
            transactionHistoryPanel.add(getStartDayComboBox(), gridBagConstraints42);
            transactionHistoryPanel.add(getEndYearComboBox(), gridBagConstraints43);
            transactionHistoryPanel.add(getEndMonthComboBox(), gridBagConstraints44);
            transactionHistoryPanel.add(getEndDayComboBox(), gridBagConstraints45);
            transactionHistoryPanel.add(startDateLabel, gridBagConstraints46);
            transactionHistoryPanel.add(endDateLabel, gridBagConstraints47);
            transactionHistoryPanel.add(getJList_inquirytrade(), gridBagConstraints48);
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
    private JTextField getJTextField_deposit_acnumber() {
        if (depositAccountNumberField == null) {
            depositAccountNumberField = new JTextField();
            depositAccountNumberField.setPreferredSize(new Dimension(150, 25));
        }

        return depositAccountNumberField;
    }

    /**
     * This method initializes depositTradeMoneyField
     *
     * @return javax.swing.JTextField
     */
    private JTextField getJTextField_deposit_trademoney() {
        if (depositTradeMoneyField == null) {
            depositTradeMoneyField = new JTextField();
            depositTradeMoneyField.setText("");
            depositTradeMoneyField.setPreferredSize(new Dimension(150, 25));
        }

        return depositTradeMoneyField;
    }

    /**
     * This method initializes depositButton
     *
     * @return javax.swing.JButton
     */
    private JButton getJDepositButton() {
        if (depositButton == null) {
            depositButton = new JButton();
            depositButton.setText("Deposit");
            depositButton.setPreferredSize(new Dimension(120, 30));
            depositButton.addActionListener((java.awt.event.ActionEvent e) -> {
                try {
                    long acnumber = Long.parseLong(depositAccountNumberField.getText());
                    long trademoney = Long.parseLong(depositTradeMoneyField.getText());
                    boolean state1 = acc.deposit(acnumber, trademoney);
                    if (state1) {
                        JOptionPane.showMessageDialog(depositPanel, "Success, current balance $" + acc.inquiryBalance(acnumber) + ".");
                    } else {
                        JOptionPane.showMessageDialog(depositPanel, "Failure, current balance $" + acc.inquiryBalance(acnumber) + ".");
                    }
                } catch (NumberFormatException | HeadlessException ex) {
                    JOptionPane.showMessageDialog(depositPanel, "Input error, try again.");
                }
            });
        }

        return depositButton;
    }

    /**
     * This method initializes withdrawalAccountNumberField
     *
     * @return javax.swing.JTextField
     */
    private JTextField getJTextField_drawing_acnumber() {
        if (withdrawalAccountNumberField == null) {
            withdrawalAccountNumberField = new JTextField();
            withdrawalAccountNumberField.setPreferredSize(new Dimension(150, 25));
        }

        return withdrawalAccountNumberField;
    }

    /**
     * This method initializes withdrawalAccountTradeMoneyField
     *
     * @return javax.swing.JTextField
     */
    private JTextField getJTextField_drawing_trademoney() {
        if (withdrawalAccountTradeMoneyField == null) {
            withdrawalAccountTradeMoneyField = new JTextField();
            withdrawalAccountTradeMoneyField.setPreferredSize(new Dimension(150, 25));
        }

        return withdrawalAccountTradeMoneyField;
    }

    /**
     * This method initializes jdrawingButton
     *
     * @return javax.swing.JButton
     */
    private JButton getJWithdrawalButton() {
        if (withdrawalButton == null) {
            withdrawalButton = new JButton();
            withdrawalButton.setText("Withdrawal");
            withdrawalButton.setPreferredSize(new Dimension(120, 30));
            withdrawalButton.addActionListener((java.awt.event.ActionEvent e) -> {
                try {
                    long acnumber = Long.parseLong(withdrawalAccountNumberField.getText());
                    long trademoney = Long.parseLong(withdrawalAccountTradeMoneyField.getText());
                    boolean state1 = acc.drawing(acnumber, trademoney);
                    if (state1) {
                        JOptionPane.showMessageDialog(withdrawalPanel, "Success, balance is $" + acc.inquiryBalance(acnumber) + ".");
                    } else {
                        JOptionPane.showMessageDialog(withdrawalPanel, "Failure, balance is $" + acc.inquiryBalance(acnumber) + ".");
                    }
                } catch (NumberFormatException | HeadlessException ex) {
                    JOptionPane.showMessageDialog(withdrawalPanel, "Input error, try again.");
                }
            });
        }

        return withdrawalButton;
    }

    /**
     * This method initializes inquiryBalanceAccountNumber
     *
     * @return javax.swing.JTextField
     */
    private JTextField getJTextField_inquirybalance_acnumber() {
        if (inquiryBalanceAccountNumber == null) {
            inquiryBalanceAccountNumber = new JTextField();
            inquiryBalanceAccountNumber.setPreferredSize(new Dimension(150, 25));
        }

        return inquiryBalanceAccountNumber;
    }

    /**
     * This method initializes inquiryBalanceButton
     *
     * @return javax.swing.JButton
     */
    private JButton getInquiryBalanceButton() {
        if (inquiryBalanceButton == null) {
            inquiryBalanceButton = new JButton();
            inquiryBalanceButton.setText("Check Balance");
            inquiryBalanceButton.setPreferredSize(new Dimension(120, 30));
            inquiryBalanceButton.addActionListener((java.awt.event.ActionEvent e) -> {
                try {
                    long acnumber = Long.parseLong(inquiryBalanceAccountNumber.getText());

                    long balance = acc.inquiryBalance(acnumber);
                    if (balance == -1) {
                        JOptionPane.showMessageDialog(depositPanel, "Failed to check balance, check account number.");
                    } else {
                        inquiryBalanceBalance.setText(String.valueOf(balance));
                    }
                } catch (NumberFormatException | HeadlessException ex) {
                    JOptionPane.showMessageDialog(transactionHistoryPanel, "Input error, check account number and enter again.");
                }
            });
        }

        return inquiryBalanceButton;
    }

    /**
     * This method initializes inquiryTradeAccountNumberField
     *
     * @return javax.swing.JTextField
     */
    private JTextField getJTextField_inquirytrade_acnumber() {
        if (inquiryTradeAccountNumberField == null) {
            inquiryTradeAccountNumberField = new JTextField();
            inquiryTradeAccountNumberField.setPreferredSize(new Dimension(120, 25));
        }

        return inquiryTradeAccountNumberField;
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
     * This method initializes startYearComboBox
     *
     * @return javax.swing.JComboBox
     */
    private JComboBox getStartYearComboBox() {
        if (startYearComboBox == null) {
            startYearComboBox = new JComboBox<>();
            for (int i = 1970; i < 2030; i++) {
                startYearComboBox.addItem(String.valueOf(i));
            }
            startYearComboBox.setPreferredSize(new Dimension(70, 20));
            startYearComboBox.setToolTipText("Start Year");
            startYearComboBox.setName("Start Year");
        }

        return startYearComboBox;
    }

    /**
     * This method initializes startMonthComboBox
     *
     * @return javax.swing.JComboBox
     */
    private JComboBox getStartMonthComboBox() {
        if (startMonthComboBox == null) {
            startMonthComboBox = new JComboBox<>();
            for (int i = 1; i < 13; i++) {
                startMonthComboBox.addItem(String.valueOf(i));
            }
            startMonthComboBox.setPreferredSize(new Dimension(40, 20));
            startMonthComboBox.setToolTipText("Start Month");
        }

        return startMonthComboBox;
    }

    /**
     * This method initializes startDayComboBox
     *
     * @return javax.swing.JComboBox
     */
    private JComboBox getStartDayComboBox() {
        if (startDayComboBox == null) {
            startDayComboBox = new JComboBox<>();
            startDayComboBox.setPreferredSize(new Dimension(40, 20));
            for (int i = 1; i < 32; i++) {
                startDayComboBox.addItem(String.valueOf(i));
            }
            startDayComboBox.setToolTipText("Start Day");
        }

        return startDayComboBox;
    }

    /**
     * This method initializes endYearComboBox
     *
     * @return javax.swing.JComboBox
     */
    private JComboBox getEndYearComboBox() {
        if (endYearComboBox == null) {
            endYearComboBox = new JComboBox<>();
            endYearComboBox.setPreferredSize(new Dimension(70, 20));
            for (int i = 1970; i < 2030; i++) {
                endYearComboBox.addItem(String.valueOf(i));
            }
            endYearComboBox.setToolTipText("End Year");
        }

        return endYearComboBox;
    }

    /**
     * This method initializes endMonthComboBox
     *
     * @return javax.swing.JComboBox
     */
    private JComboBox getEndMonthComboBox() {
        if (endMonthComboBox == null) {
            endMonthComboBox = new JComboBox<>();
            endMonthComboBox.setPreferredSize(new Dimension(40, 20));
            for (int i = 1; i < 13; i++) {
                endMonthComboBox.addItem(String.valueOf(i));
            }
            endMonthComboBox.setToolTipText("End Month");
        }

        return endMonthComboBox;
    }

    /**
     * This method initializes endDayComboBox
     *
     * @return javax.swing.JComboBox
     */
    private JComboBox getEndDayComboBox() {
        if (endDayComboBox == null) {
            endDayComboBox = new JComboBox<>();
            endDayComboBox.setPreferredSize(new Dimension(40, 20));
            for (int i = 1; i < 32; i++) {
                endDayComboBox.addItem(String.valueOf(i));
            }
            endDayComboBox.setToolTipText("End Day");
        }

        return endDayComboBox;
    }

    /**
     * This method initializes inquiryTradeList
     *
     * @return javax.swing.JList
     */
    private JList getJList_inquirytrade() {
        if (inquiryTradeList == null) {
            inquiryTradeList = new JList<>();
        }

        return inquiryTradeList;
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
                    Calendar lastday = Calendar.getInstance();
                    Calendar startday = Calendar.getInstance();
                    switch (command) {
                        case "Last Day":
                            startday.roll(Calendar.DATE, false);
                            break;
                        case "Last Year":
                            startday.roll(Calendar.DATE, -7);
                            break;
                        case "Last Month":
                            startday.roll(Calendar.MONTH, false);
                            break;
                        case "Custom Date Range":
                            startday.set(Integer.parseInt((String) startYearComboBox.getSelectedItem()), startMonthComboBox.getSelectedIndex(), startDayComboBox.getSelectedIndex() + 1);
                            lastday.set(Integer.parseInt((String) endYearComboBox.getSelectedItem()), endMonthComboBox.getSelectedIndex(), endDayComboBox.getSelectedIndex() + 1);
                            break;
                        default:
                            System.out.println("Invalid action command selected.");
                            break;
                    }

                    //Date time = startday.getTime();
                    //System.out.println(time.toString());
                    long acnumber = Long.parseLong(inquiryTradeAccountNumberField.getText());
                    int size = acc.findDetailsnum(acnumber, startday.getTimeInMillis(), lastday.getTimeInMillis());
                    td = new Trade[size];
                    td = acc.inquiryDetails(acnumber, startday.getTimeInMillis(), lastday.getTimeInMillis());
                    String detail[] = new String[size];
                    for (int i = 0; i < size; i++) {
                        detail[i] = showdetails(td[i]);
                    }
                    inquiryTradeList.setListData(detail);
                } catch (Exception ex) {
                }
            });
        }

        return getTransactionHistoryButton;
    }

    /**
     * This method initializes exitButton
     *
     * @return javax.swing.JButton
     */
    private JButton getJexitButton1() {
        if (exitButton == null) {
            exitButton = new JButton();
            exitButton.setText("Quit ATM");
            exitButton.setPreferredSize(new Dimension(120, 30));
            exitButton.addActionListener((java.awt.event.ActionEvent e) -> {
                try {
                    int n = JOptionPane.showConfirmDialog(landingPanel,
                            "Quit ATM?", "Confirm Exit",
                            JOptionPane.OK_CANCEL_OPTION);
                    if (n == JOptionPane.YES_OPTION) {
                        acc.saveacc();
                        System.exit(0);
                    } else {

                    }
                } catch (Exception ex) {
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
