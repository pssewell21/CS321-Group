/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Common.AesEncryption;
import Common.UserSettings;
import Controllers.UserEditViewController;
import Library.Person;
import java.awt.Graphics;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JOptionPane;

/**
 *
 * @author Owner
 */
public class UserEditView extends javax.swing.JFrame {
    // <editor-fold defaultstate="collapsed" desc="Member Variables"> 

    private final UserEditViewController controller;

    private Person selectedPerson;

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Constructors"> 
    /**
     *
     * @param controller
     * @param selectedPerson
     */
    public UserEditView(UserEditViewController controller, Person selectedPerson) {
        this.controller = controller;
        this.selectedPerson = selectedPerson;
        load();
    }

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Methods"> 
    private void load() {
        initComponents();
        setThemeColors();
        
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/Resources/logo.png")).getImage());

        if (controller.model.PersonId != null) {
            personComboBox.setSelectedItem(selectedPerson);
        } else {
            personComboBox.setSelectedItem(null);
        }

        userNameField.setText(controller.model.UserName);
        try {
            passwordField.setText(AesEncryption.decryptText(controller.model.Password));
            securityQuestion1Field.setText(AesEncryption.decryptText(controller.model.SecurityQuestion1));
            securityAnswer1Field.setText(AesEncryption.decryptText(controller.model.SecurityAnswer1));
            securityQuestion2Field.setText(AesEncryption.decryptText(controller.model.SecurityQuestion2));
            securityAnswer2Field.setText(AesEncryption.decryptText(controller.model.SecurityAnswer2));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(jPanel1, "Decryption failure.");
        }
        
        if (controller.model.IsAdministrator != null) {
            isAdministratorCheckBox.setSelected(controller.model.IsAdministrator);
        }
        if (controller.model.IsAccountLocked != null) {
            isAccountLockedCheckBox.setSelected(controller.model.IsAccountLocked);
        }
        if (controller.model.SelectedTheme != null) {
            selectedThemeComboBox.setSelectedItem(controller.model.SelectedTheme);
        } else {
            selectedThemeComboBox.setSelectedItem(null);
        }

        pack();
        setResizable(false);
        setVisible(true);
    }

    private void setThemeColors() {
        jPanel1.setBackground(UserSettings.theme.getBackgroundColor());

        personComboBox.setBackground(UserSettings.theme.getComboBoxBackgroundColor());
        selectedThemeComboBox.setBackground(UserSettings.theme.getComboBoxBackgroundColor());
        passwordField.setBackground(UserSettings.theme.getTextFieldBackgroundColor());
        securityAnswer1Field.setBackground(UserSettings.theme.getTextFieldBackgroundColor());
        securityAnswer2Field.setBackground(UserSettings.theme.getTextFieldBackgroundColor());
        securityQuestion1Field.setBackground(UserSettings.theme.getTextFieldBackgroundColor());
        securityQuestion2Field.setBackground(UserSettings.theme.getTextFieldBackgroundColor());
        userNameField.setBackground(UserSettings.theme.getTextFieldBackgroundColor());
        applyButton.setBackground(UserSettings.theme.getTextFieldBackgroundColor());
        saveButton.setBackground(UserSettings.theme.getTextFieldBackgroundColor());
        cancelButton.setBackground(UserSettings.theme.getTextFieldBackgroundColor());
        deleteButton.setBackground(UserSettings.theme.getTextFieldBackgroundColor());

        personComboBox.setForeground(UserSettings.theme.getTextColor());
        selectedThemeComboBox.setForeground(UserSettings.theme.getTextColor());
        passwordField.setForeground(UserSettings.theme.getTextColor());
        securityAnswer1Field.setForeground(UserSettings.theme.getTextColor());
        securityAnswer2Field.setForeground(UserSettings.theme.getTextColor());
        securityQuestion1Field.setForeground(UserSettings.theme.getTextColor());
        securityQuestion2Field.setForeground(UserSettings.theme.getTextColor());
        userNameField.setForeground(UserSettings.theme.getTextColor());
        applyButton.setForeground(UserSettings.theme.getTextColor());
        saveButton.setForeground(UserSettings.theme.getTextColor());
        cancelButton.setForeground(UserSettings.theme.getTextColor());
        deleteButton.setForeground(UserSettings.theme.getTextColor());
        jLabel2.setForeground(UserSettings.theme.getTextColor());
        jLabel3.setForeground(UserSettings.theme.getTextColor());
        jLabel4.setForeground(UserSettings.theme.getTextColor());
        jLabel5.setForeground(UserSettings.theme.getTextColor());
        jLabel6.setForeground(UserSettings.theme.getTextColor());
        jLabel7.setForeground(UserSettings.theme.getTextColor());
        jLabel8.setForeground(UserSettings.theme.getTextColor());
        jLabel9.setForeground(UserSettings.theme.getTextColor());
        jLabel10.setForeground(UserSettings.theme.getTextColor());
        jLabel11.setForeground(UserSettings.theme.getTextColor());

        personComboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public void paint(Graphics g) {
                setBackground(UserSettings.theme.getListBackgroundColor());
                setForeground(UserSettings.theme.getTextColor());
                super.paint(g);
            }
        });
        selectedThemeComboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public void paint(Graphics g) {
                setBackground(UserSettings.theme.getListBackgroundColor());
                setForeground(UserSettings.theme.getTextColor());
                super.paint(g);
            }
        });
    }

    /**
     *
     * @param isEnabled
     */
    public void setDeleteEnabled(boolean isEnabled) {
        deleteButton.setEnabled(isEnabled);
    }

    private void setModelFields() {
        selectedPerson = (Person) personComboBox.getSelectedItem();

        try {
            controller.model.PersonId = selectedPerson.Id;
            controller.model.UserName = userNameField.getText();
            controller.model.Password = AesEncryption.encryptText(new String(passwordField.getPassword()));
            controller.model.SecurityQuestion1 = AesEncryption.encryptText(securityQuestion1Field.getText());
            controller.model.SecurityAnswer1 = AesEncryption.encryptText(securityAnswer1Field.getText());
            controller.model.SecurityQuestion2 = AesEncryption.encryptText(securityQuestion2Field.getText());
            controller.model.SecurityAnswer2 = AesEncryption.encryptText(securityAnswer2Field.getText());
            controller.model.IsAdministrator = isAdministratorCheckBox.isSelected();
            controller.model.IsAccountLocked = isAccountLockedCheckBox.isSelected();
            controller.model.SelectedTheme = (String) selectedThemeComboBox.getSelectedItem();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(jPanel1, "Encryption failure.");
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

        jLabel2.setText("Person ID:");

        jLabel3.setText("User Name:");

        jLabel4.setText("Password:");

        jLabel5.setText("Security Question 1:");

        jLabel6.setText("Security Answer 1:");

        jLabel7.setText("Security Question 2:");

        jLabel8.setText("Security Answer 2:");

        jLabel9.setText("Is Administrator:");

        jLabel10.setText("Is Account Locked:");

        jLabel11.setText("Selected Theme:");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 395, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        setModelFields();
        controller.executeSave();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void applyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyButtonActionPerformed
        setModelFields();
        controller.executeApply();
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
