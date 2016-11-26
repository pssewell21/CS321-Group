/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Common.UserSettings;
import Common.Utility;
import Controllers.AccountEditViewController;
import java.math.BigDecimal;
import javax.swing.JOptionPane;

/**
 *
 * @author Owner
 */
public class AccountEditView extends javax.swing.JFrame {
    // <editor-fold defaultstate="collapsed" desc="Member Variables"> 

    private final AccountEditViewController controller;

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Constructors"> 
    /**
     *
     * @param controller
     */
    public AccountEditView(AccountEditViewController controller) {
        this.controller = controller;
        load();
    }

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Methods"> 
    /**
     *
     * @param isEnabled
     */
    public void setDeleteEnabled(boolean isEnabled) {
        deleteButton.setEnabled(isEnabled);
    }

    private void load() {
        initComponents();
        setThemeColors();

        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/Resources/logo.png")).getImage());

        if (controller.model.accountNumber != null) {
            accountNumberField.setText(controller.model.accountNumber.toString());
        }
        accountTypeField.setText(controller.model.accountType);
        descriptionField.setText(controller.model.description);
        if (controller.model.balance != null) {
            balanceField.setText(controller.model.balance.toString());
        }
        if (controller.model.interestRate != null) {
            interestRateField.setText(controller.model.interestRate.toString());
        }

        pack();
        setResizable(false);
        setVisible(true);
    }

    private void setThemeColors() {
        jPanel1.setBackground(UserSettings.theme.getBackgroundColor());

        accountNumberField.setBackground(UserSettings.theme.getTextFieldBackgroundColor());
        accountTypeField.setBackground(UserSettings.theme.getTextFieldBackgroundColor());
        balanceField.setBackground(UserSettings.theme.getTextFieldBackgroundColor());
        descriptionField.setBackground(UserSettings.theme.getTextFieldBackgroundColor());
        interestRateField.setBackground(UserSettings.theme.getTextFieldBackgroundColor());
        applyButton.setBackground(UserSettings.theme.getTextFieldBackgroundColor());
        saveButton.setBackground(UserSettings.theme.getTextFieldBackgroundColor());
        cancelButton.setBackground(UserSettings.theme.getTextFieldBackgroundColor());
        deleteButton.setBackground(UserSettings.theme.getTextFieldBackgroundColor());

        accountNumberField.setForeground(UserSettings.theme.getTextColor());
        accountTypeField.setForeground(UserSettings.theme.getTextColor());
        balanceField.setForeground(UserSettings.theme.getTextColor());
        descriptionField.setForeground(UserSettings.theme.getTextColor());
        interestRateField.setForeground(UserSettings.theme.getTextColor());
        applyButton.setForeground(UserSettings.theme.getTextColor());
        saveButton.setForeground(UserSettings.theme.getTextColor());
        cancelButton.setForeground(UserSettings.theme.getTextColor());
        deleteButton.setForeground(UserSettings.theme.getTextColor());
        jLabel2.setForeground(UserSettings.theme.getTextColor());
        jLabel3.setForeground(UserSettings.theme.getTextColor());
        jLabel4.setForeground(UserSettings.theme.getTextColor());
        jLabel5.setForeground(UserSettings.theme.getTextColor());
        jLabel6.setForeground(UserSettings.theme.getTextColor());
        requiredLabel.setForeground(UserSettings.theme.getTextColor());
    }

    private void setModelFields() throws Exception {
        if (Utility.isPositiveInteger(accountNumberField.getText())) {
            controller.model.accountNumber = Long.parseLong(accountNumberField.getText());
        } else {
            throw new Exception("Invalid Account Number");
        }

        if (Utility.hasValue(accountTypeField.getText())) {
            controller.model.accountType = accountTypeField.getText();
        } else {
            throw new Exception("Account Type is required");
        }

        controller.model.description = descriptionField.getText();

        if (Utility.isNumeric(balanceField.getText())) {
            controller.model.balance = new BigDecimal(balanceField.getText());
        } else {
            throw new Exception("Invalid Balance");
        }

        if (Utility.hasValue(interestRateField.getText())) {
            if (Utility.isNumeric(interestRateField.getText())) {
                controller.model.interestRate = new BigDecimal(interestRateField.getText());
            } else {
                throw new Exception("Invalid Interest Rate");
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        saveButton = new javax.swing.JButton();
        applyButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        accountNumberField = new javax.swing.JTextField();
        accountTypeField = new javax.swing.JTextField();
        descriptionField = new javax.swing.JTextField();
        balanceField = new javax.swing.JTextField();
        interestRateField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        requiredLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        applyButton.setText("Apply");
        applyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Account Number*:");

        jLabel3.setText("Account Type*:");

        jLabel4.setText("Description:");

        jLabel5.setText("Balance*:");

        jLabel6.setText("Interest Rate:");

        requiredLabel.setText("* - Required");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(accountNumberField)
                            .addComponent(accountTypeField)
                            .addComponent(descriptionField)
                            .addComponent(balanceField)
                            .addComponent(interestRateField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(requiredLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                        .addComponent(applyButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteButton)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(accountNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(accountTypeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descriptionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(balanceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(interestRateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(cancelButton)
                    .addComponent(deleteButton)
                    .addComponent(applyButton)
                    .addComponent(requiredLabel))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 401, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        controller.executeDelete();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        controller.executeCancel();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void applyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyButtonActionPerformed
        try {
            setModelFields();
            controller.executeApply();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(jPanel1, e.getMessage());
        }
    }//GEN-LAST:event_applyButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        try {
            setModelFields();
            controller.executeSave();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(jPanel1, e.getMessage());
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Generated UI Variables"> 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField accountNumberField;
    private javax.swing.JTextField accountTypeField;
    private javax.swing.JButton applyButton;
    private javax.swing.JTextField balanceField;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField descriptionField;
    private javax.swing.JTextField interestRateField;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel requiredLabel;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables

    // </editor-fold> 
}
