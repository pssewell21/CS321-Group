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

import Common.AesEncryption;
import Common.UserSettings;
import Common.Utility;
import Controllers.UserEditViewController;
import Library.Person;
import java.awt.Graphics;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JOptionPane;

/**
 * The User edit view.
 *
 * @author Patrick Sewell
 */
public class UserEditView extends javax.swing.JFrame {
    // <editor-fold defaultstate="collapsed" desc="Member Variables"> 

    private final UserEditViewController controller;
    private Person selectedPerson;

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Constructors"> 
    /**
     * Creates new form UserEditView.
     *
     * @param controller The UserEditViewController for the view
     * @param selectedPerson The Person to be selected when loading the view
     */
    public UserEditView(UserEditViewController controller, Person selectedPerson) {
        this.controller = controller;
        this.selectedPerson = selectedPerson;
        load();
    }

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Methods"> 
    /**
     * Enables or Disables the delete button.
     *
     * @param isEnabled the value indicating if the button will be enabled or
     * disabled
     */
    public void setDeleteEnabled(boolean isEnabled) {
        deleteButton.setEnabled(isEnabled);
    }

    private void load() {
        initComponents();
        setThemeColors();
        setTitle("Create a User");

        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/Resources/icon.png")).getImage());

        if (controller.model.personId != null) {
            personComboBox.setSelectedItem(selectedPerson);
        } else {
            personComboBox.setSelectedItem(null);
        }

        userNameField.setText(controller.model.userName);
        try {
            passwordField.setText(AesEncryption.decryptText(controller.model.password));
            securityQuestion1Field.setText(AesEncryption.decryptText(controller.model.securityQuestion1));
            securityAnswer1Field.setText(AesEncryption.decryptText(controller.model.securityAnswer1));
            securityQuestion2Field.setText(AesEncryption.decryptText(controller.model.securityQuestion2));
            securityAnswer2Field.setText(AesEncryption.decryptText(controller.model.securityAnswer2));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(jPanel1, "Decryption failure.");
        }

        if (controller.model.isAdministrator != null) {
            isAdministratorCheckBox.setSelected(controller.model.isAdministrator);
        }
        if (controller.model.isAccountLocked != null) {
            isAccountLockedCheckBox.setSelected(controller.model.isAccountLocked);
        }
        if (controller.model.selectedTheme != null) {
            selectedThemeComboBox.setSelectedItem(controller.model.selectedTheme);
        } else {
            selectedThemeComboBox.setSelectedItem(null);
        }

        pack();
        setResizable(false);
        setVisible(true);
    }

    private void setThemeColors() {
        jPanel1.setBackground(UserSettings.selectedTheme.getBackgroundColor());

        personComboBox.setBackground(UserSettings.selectedTheme.getComboBoxBackgroundColor());
        selectedThemeComboBox.setBackground(UserSettings.selectedTheme.getComboBoxBackgroundColor());
        passwordField.setBackground(UserSettings.selectedTheme.getTextFieldBackgroundColor());
        securityAnswer1Field.setBackground(UserSettings.selectedTheme.getTextFieldBackgroundColor());
        securityAnswer2Field.setBackground(UserSettings.selectedTheme.getTextFieldBackgroundColor());
        securityQuestion1Field.setBackground(UserSettings.selectedTheme.getTextFieldBackgroundColor());
        securityQuestion2Field.setBackground(UserSettings.selectedTheme.getTextFieldBackgroundColor());
        userNameField.setBackground(UserSettings.selectedTheme.getTextFieldBackgroundColor());
        applyButton.setBackground(UserSettings.selectedTheme.getTextFieldBackgroundColor());
        saveButton.setBackground(UserSettings.selectedTheme.getTextFieldBackgroundColor());
        cancelButton.setBackground(UserSettings.selectedTheme.getTextFieldBackgroundColor());
        deleteButton.setBackground(UserSettings.selectedTheme.getTextFieldBackgroundColor());

        personComboBox.setForeground(UserSettings.selectedTheme.getTextColor());
        selectedThemeComboBox.setForeground(UserSettings.selectedTheme.getTextColor());
        passwordField.setForeground(UserSettings.selectedTheme.getTextColor());
        securityAnswer1Field.setForeground(UserSettings.selectedTheme.getTextColor());
        securityAnswer2Field.setForeground(UserSettings.selectedTheme.getTextColor());
        securityQuestion1Field.setForeground(UserSettings.selectedTheme.getTextColor());
        securityQuestion2Field.setForeground(UserSettings.selectedTheme.getTextColor());
        userNameField.setForeground(UserSettings.selectedTheme.getTextColor());
        applyButton.setForeground(UserSettings.selectedTheme.getTextColor());
        saveButton.setForeground(UserSettings.selectedTheme.getTextColor());
        cancelButton.setForeground(UserSettings.selectedTheme.getTextColor());
        deleteButton.setForeground(UserSettings.selectedTheme.getTextColor());
        jLabel2.setForeground(UserSettings.selectedTheme.getTextColor());
        jLabel3.setForeground(UserSettings.selectedTheme.getTextColor());
        jLabel4.setForeground(UserSettings.selectedTheme.getTextColor());
        jLabel5.setForeground(UserSettings.selectedTheme.getTextColor());
        jLabel6.setForeground(UserSettings.selectedTheme.getTextColor());
        jLabel7.setForeground(UserSettings.selectedTheme.getTextColor());
        jLabel8.setForeground(UserSettings.selectedTheme.getTextColor());
        jLabel9.setForeground(UserSettings.selectedTheme.getTextColor());
        jLabel10.setForeground(UserSettings.selectedTheme.getTextColor());
        jLabel11.setForeground(UserSettings.selectedTheme.getTextColor());
        requiredLabel.setForeground(UserSettings.selectedTheme.getTextColor());

        personComboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public void paint(Graphics g) {
                setBackground(UserSettings.selectedTheme.getListBackgroundColor());
                setForeground(UserSettings.selectedTheme.getTextColor());
                super.paint(g);
            }
        });
        selectedThemeComboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public void paint(Graphics g) {
                setBackground(UserSettings.selectedTheme.getListBackgroundColor());
                setForeground(UserSettings.selectedTheme.getTextColor());
                super.paint(g);
            }
        });
    }

    private void setModelFields() throws Exception {
        selectedPerson = (Person) personComboBox.getSelectedItem();

        if (selectedPerson != null && selectedPerson.id != null) {
            controller.model.personId = selectedPerson.id;
        } else {
            throw new Exception("Person ID is required");
        }

        if (Utility.hasValue(userNameField.getText())) {
            controller.model.userName = userNameField.getText();
        } else {
            throw new Exception("User Name is required");
        }

        if (Utility.hasValue(new String(passwordField.getPassword()))) {
            try {
                controller.model.password = AesEncryption.encryptText(new String(passwordField.getPassword()));
            } catch (Exception e) {
                throw new Exception("Encryption failure");
            }
        } else {
            throw new Exception("Password is required");
        }

        if (Utility.hasValue(securityQuestion1Field.getText())) {
            try {
                controller.model.securityQuestion1 = AesEncryption.encryptText(securityQuestion1Field.getText());
            } catch (Exception e) {
                throw new Exception("Encryption failure");
            }
        } else {
            throw new Exception("Security Question 1 is required");
        }

        if (Utility.hasValue(securityAnswer1Field.getText())) {
            try {
                controller.model.securityAnswer1 = AesEncryption.encryptText(securityAnswer1Field.getText());
            } catch (Exception e) {
                throw new Exception("Encryption failure");
            }
        } else {
            throw new Exception("Security Answer 1 is required");
        }

        if (Utility.hasValue(securityQuestion2Field.getText())) {
            try {
                controller.model.securityQuestion2 = AesEncryption.encryptText(securityQuestion2Field.getText());
            } catch (Exception e) {
                throw new Exception("Encryption failure");
            }
        } else {
            throw new Exception("Security Question 2 is required");
        }

        if (Utility.hasValue(securityAnswer2Field.getText())) {
            try {
                controller.model.securityAnswer2 = AesEncryption.encryptText(securityAnswer2Field.getText());
            } catch (Exception e) {
                throw new Exception("Encryption failure");
            }
        } else {
            throw new Exception("Security Answer 2 is required");
        }

        controller.model.isAdministrator = isAdministratorCheckBox.isSelected();
        controller.model.isAccountLocked = isAccountLockedCheckBox.isSelected();

        if (Utility.hasValue((String) selectedThemeComboBox.getSelectedItem())) {
            controller.model.selectedTheme = (String) selectedThemeComboBox.getSelectedItem();
        } else {
            throw new Exception("Selected Theme is required");
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
        userNameField = new javax.swing.JTextField();
        securityQuestion1Field = new javax.swing.JTextField();
        securityAnswer1Field = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        securityQuestion2Field = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        securityAnswer2Field = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        personComboBox = new javax.swing.JComboBox<>();
        isAdministratorCheckBox = new javax.swing.JCheckBox();
        isAccountLockedCheckBox = new javax.swing.JCheckBox();
        passwordField = new javax.swing.JPasswordField();
        selectedThemeComboBox = new javax.swing.JComboBox<>();
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

        jLabel2.setText("Person*:");

        jLabel3.setText("User Name*:");

        jLabel4.setText("Password*:");

        jLabel5.setText("Security Question 1*:");

        jLabel6.setText("Security Answer 1*:");

        jLabel7.setText("Security Question 2*:");

        jLabel8.setText("Security Answer 2*:");

        jLabel9.setText("Is Administrator*:");

        jLabel10.setText("Is Account Locked*:");

        jLabel11.setText("Selected Theme*:");

        personComboBox.setModel(controller.personModel);

        isAdministratorCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isAdministratorCheckBoxActionPerformed(evt);
            }
        });

        isAccountLockedCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isAccountLockedCheckBoxActionPerformed(evt);
            }
        });

        selectedThemeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Light Theme", "Dark Theme" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(153, Short.MAX_VALUE)
                .addComponent(applyButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteButton)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(42, 42, 42)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)))
                        .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(securityQuestion2Field, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(userNameField)
                    .addComponent(securityQuestion1Field)
                    .addComponent(securityAnswer1Field)
                    .addComponent(personComboBox, 0, 180, Short.MAX_VALUE)
                    .addComponent(securityAnswer2Field, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(isAccountLockedCheckBox)
                            .addComponent(isAdministratorCheckBox))
                        .addGap(117, 117, 117))
                    .addComponent(passwordField)
                    .addComponent(selectedThemeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(personComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(securityQuestion1Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(securityAnswer1Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(securityQuestion2Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(securityAnswer2Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(isAdministratorCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(isAccountLockedCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(selectedThemeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(cancelButton)
                    .addComponent(deleteButton)
                    .addComponent(applyButton))
                .addContainerGap())
        );

        requiredLabel.setText("* - Required");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(requiredLabel)
                .addContainerGap(348, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(373, Short.MAX_VALUE)
                .addComponent(requiredLabel)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
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

    private void applyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyButtonActionPerformed
        try {
            setModelFields();
            controller.executeApply();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(jPanel1, e.getMessage());
        }
    }//GEN-LAST:event_applyButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        controller.executeCancel();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        controller.executeDelete();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void isAccountLockedCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isAccountLockedCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_isAccountLockedCheckBoxActionPerformed

    private void isAdministratorCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isAdministratorCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_isAdministratorCheckBoxActionPerformed

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Generated UI Variables"> 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton applyButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JCheckBox isAccountLockedCheckBox;
    private javax.swing.JCheckBox isAdministratorCheckBox;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JComboBox<Person> personComboBox;
    private javax.swing.JLabel requiredLabel;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField securityAnswer1Field;
    private javax.swing.JTextField securityAnswer2Field;
    private javax.swing.JTextField securityQuestion1Field;
    private javax.swing.JTextField securityQuestion2Field;
    private javax.swing.JComboBox<String> selectedThemeComboBox;
    private javax.swing.JTextField userNameField;
    // End of variables declaration//GEN-END:variables

    // </editor-fold> 
}
