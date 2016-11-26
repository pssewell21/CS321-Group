/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Common.AesEncryption;
import Common.UserSettings;
import Common.Utility;
import Controllers.PersonEditViewController;
import javax.swing.JOptionPane;

/**
 *
 * @author Owner
 */
public class PersonEditView extends javax.swing.JFrame {
    // <editor-fold defaultstate="collapsed" desc="Member Variables"> 

    private final PersonEditViewController controller;

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Constructors"> 
    /**
     *
     * @param controller
     */
    public PersonEditView(PersonEditViewController controller) {
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
        setTitle("Create a Person");

        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/Resources/logo.png")).getImage());

        try {
            nameField.setText(controller.model.name);
            dateOfBirthField.setText(controller.model.dateOfBirth);
            addressField.setText(controller.model.address);
            phoneNumberField.setText(controller.model.phoneNumber);
            socialSecurityNumberField.setText(AesEncryption.decryptText(controller.model.socialSecurityNumber));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(jPanel1, "Decryption failure.");
        }

        pack();
        setResizable(false);
        setVisible(true);
    }

    private void setThemeColors() {
        jPanel1.setBackground(UserSettings.theme.getBackgroundColor());

        addressField.setBackground(UserSettings.theme.getTextFieldBackgroundColor());
        dateOfBirthField.setBackground(UserSettings.theme.getTextFieldBackgroundColor());
        nameField.setBackground(UserSettings.theme.getTextFieldBackgroundColor());
        phoneNumberField.setBackground(UserSettings.theme.getTextFieldBackgroundColor());
        socialSecurityNumberField.setBackground(UserSettings.theme.getTextFieldBackgroundColor());
        applyButton.setBackground(UserSettings.theme.getTextFieldBackgroundColor());
        saveButton.setBackground(UserSettings.theme.getTextFieldBackgroundColor());
        cancelButton.setBackground(UserSettings.theme.getTextFieldBackgroundColor());
        deleteButton.setBackground(UserSettings.theme.getTextFieldBackgroundColor());

        addressField.setForeground(UserSettings.theme.getTextColor());
        dateOfBirthField.setForeground(UserSettings.theme.getTextColor());
        nameField.setForeground(UserSettings.theme.getTextColor());
        phoneNumberField.setForeground(UserSettings.theme.getTextColor());
        socialSecurityNumberField.setForeground(UserSettings.theme.getTextColor());
        applyButton.setForeground(UserSettings.theme.getTextColor());
        saveButton.setForeground(UserSettings.theme.getTextColor());
        cancelButton.setForeground(UserSettings.theme.getTextColor());
        deleteButton.setForeground(UserSettings.theme.getTextColor());
        jLabel1.setForeground(UserSettings.theme.getTextColor());
        jLabel2.setForeground(UserSettings.theme.getTextColor());
        jLabel3.setForeground(UserSettings.theme.getTextColor());
        jLabel4.setForeground(UserSettings.theme.getTextColor());
        jLabel5.setForeground(UserSettings.theme.getTextColor());
        jLabel6.setForeground(UserSettings.theme.getTextColor());
        jLabel7.setForeground(UserSettings.theme.getTextColor());
        requiredLabel.setForeground(UserSettings.theme.getTextColor());
    }

    private void setModelFields() throws Exception {
        if (Utility.hasValue(nameField.getText())) {
            controller.model.name = nameField.getText();
        } else {
            throw new Exception("Name is required");
        }

        if (Utility.hasValue(dateOfBirthField.getText())) {
            if (Utility.isValidDate(dateOfBirthField.getText())) {
                controller.model.dateOfBirth = dateOfBirthField.getText();
            } else {
                throw new Exception("Invalid Date of Birth");
            }
        } else {
            throw new Exception("Date of Birth is required");
        }

        if (Utility.hasValue(addressField.getText())) {
            controller.model.address = addressField.getText();
        } else {
            throw new Exception("Address is required");
        }

        controller.model.phoneNumber = phoneNumberField.getText();

        if (Utility.hasValue(socialSecurityNumberField.getText())) {
            if (Utility.isValidSocialSecurityNumber(socialSecurityNumberField.getText())) {
                try {
                    controller.model.socialSecurityNumber = AesEncryption.encryptText(socialSecurityNumberField.getText());
                } catch (Exception ex) {
                    throw new Exception("Encryption failure");
                }
            } else {
                throw new Exception("Invalid Social Security Number");
            }
        } else {
            throw new Exception("Social Security Number is required");
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
        nameField = new javax.swing.JTextField();
        dateOfBirthField = new javax.swing.JTextField();
        addressField = new javax.swing.JTextField();
        phoneNumberField = new javax.swing.JTextField();
        socialSecurityNumberField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
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

        jLabel2.setText("Name*:");

        jLabel3.setText("Date of Birth*:");

        jLabel4.setText("Address*:");

        jLabel5.setText("Phone Number:");

        jLabel6.setText("Social Security Number*:");

        jLabel1.setText("(YYYY-MM-DD)");

        jLabel7.setText("(111-11-1111)");

        requiredLabel.setText("* - Required");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(requiredLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(applyButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteButton)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nameField)
                    .addComponent(dateOfBirthField)
                    .addComponent(addressField)
                    .addComponent(phoneNumberField)
                    .addComponent(socialSecurityNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateOfBirthField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(socialSecurityNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
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
            .addGap(0, 444, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 222, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        try {
            setModelFields();
            controller.executeSave();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(jPanel1, e.getMessage());
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        controller.executeCancel();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        controller.executeDelete();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void applyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyButtonActionPerformed
        try {
            setModelFields();
            controller.executeApply();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(jPanel1, e.getMessage());
        }
    }//GEN-LAST:event_applyButtonActionPerformed

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Generated UI Variables"> 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressField;
    private javax.swing.JButton applyButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField dateOfBirthField;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField phoneNumberField;
    private javax.swing.JLabel requiredLabel;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField socialSecurityNumberField;
    // End of variables declaration//GEN-END:variables

    // </editor-fold> 
}
