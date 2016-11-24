/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Common.UserSettings;
import Controllers.UserEditViewController;
import Library.Person;
import java.awt.Graphics;
import javax.swing.DefaultListCellRenderer;

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
        
        if (controller.model.PersonId != null) { 
            PersonComboBox.setSelectedItem(selectedPerson);
        }
        else {
            PersonComboBox.setSelectedItem(null);
        }
            
        UserNameField.setText(controller.model.UserName);
        PasswordField.setText(controller.model.Password);
        SecurityQuestion1Field.setText(controller.model.SecurityQuestion1);
        SecurityAnswer1Field.setText(controller.model.SecurityAnswer1);
        SecurityQuestion2Field.setText(controller.model.SecurityQuestion2);
        SecurityAnswer2Field.setText(controller.model.SecurityAnswer2);
        if (controller.model.IsAdministrator != null) { 
            IsAdministratorCheckBox.setSelected(controller.model.IsAdministrator);
        }
        if (controller.model.IsAccountLocked != null) { 
            IsAccountLockedCheckBox.setSelected(controller.model.IsAccountLocked);
        }
        SelectedThemeField.setText(controller.model.SelectedTheme);

        pack();
        setVisible(true);
    }
    
    private void setThemeColors() {
        jPanel1.setBackground(UserSettings.theme.getBackgroundColor());
                
        PersonComboBox.setBackground(UserSettings.theme.getComboBoxBackgroundColor());
        PasswordField.setBackground(UserSettings.theme.getTextFieldBackgroundColor());
        SecurityAnswer1Field.setBackground(UserSettings.theme.getTextFieldBackgroundColor());
        SecurityAnswer2Field.setBackground(UserSettings.theme.getTextFieldBackgroundColor());
        SecurityQuestion1Field.setBackground(UserSettings.theme.getTextFieldBackgroundColor());
        SecurityQuestion2Field.setBackground(UserSettings.theme.getTextFieldBackgroundColor());
        SelectedThemeField.setBackground(UserSettings.theme.getTextFieldBackgroundColor());
        UserNameField.setBackground(UserSettings.theme.getTextFieldBackgroundColor());
        applyButton.setBackground(UserSettings.theme.getTextFieldBackgroundColor());
        saveButton.setBackground(UserSettings.theme.getTextFieldBackgroundColor());
        cancelButton.setBackground(UserSettings.theme.getTextFieldBackgroundColor());
        deleteButton.setBackground(UserSettings.theme.getTextFieldBackgroundColor());
        
        PersonComboBox.setForeground(UserSettings.theme.getTextColor());
        PasswordField.setForeground(UserSettings.theme.getTextColor());
        SecurityAnswer1Field.setForeground(UserSettings.theme.getTextColor());
        SecurityAnswer2Field.setForeground(UserSettings.theme.getTextColor());
        SecurityQuestion1Field.setForeground(UserSettings.theme.getTextColor());
        SecurityQuestion2Field.setForeground(UserSettings.theme.getTextColor());
        SelectedThemeField.setForeground(UserSettings.theme.getTextColor());
        UserNameField.setForeground(UserSettings.theme.getTextColor());
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
        
        PersonComboBox.setRenderer(new DefaultListCellRenderer() {
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
        selectedPerson = (Person) PersonComboBox.getSelectedItem();
        
        controller.model.PersonId = selectedPerson.Id;
        controller.model.UserName = UserNameField.getText();
        controller.model.Password = PasswordField.getText();
        controller.model.SecurityQuestion1 = SecurityQuestion1Field.getText();
        controller.model.SecurityAnswer1 = SecurityAnswer1Field.getText();
        controller.model.SecurityQuestion2 = SecurityQuestion2Field.getText();
        controller.model.SecurityAnswer2 = SecurityAnswer2Field.getText();
        controller.model.IsAdministrator = IsAdministratorCheckBox.isSelected();
        controller.model.IsAccountLocked = IsAccountLockedCheckBox.isSelected();
        controller.model.SelectedTheme = SelectedThemeField.getText();
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
        UserNameField = new javax.swing.JTextField();
        PasswordField = new javax.swing.JTextField();
        SecurityQuestion1Field = new javax.swing.JTextField();
        SecurityAnswer1Field = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        SecurityQuestion2Field = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        SecurityAnswer2Field = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        SelectedThemeField = new javax.swing.JTextField();
        PersonComboBox = new javax.swing.JComboBox<>();
        IsAdministratorCheckBox = new javax.swing.JCheckBox();
        IsAccountLockedCheckBox = new javax.swing.JCheckBox();

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

        PersonComboBox.setModel(controller.personModel);

        IsAdministratorCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IsAdministratorCheckBoxActionPerformed(evt);
            }
        });

        IsAccountLockedCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IsAccountLockedCheckBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(SelectedThemeField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SecurityQuestion2Field, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(UserNameField)
                        .addComponent(PasswordField)
                        .addComponent(SecurityQuestion1Field)
                        .addComponent(SecurityAnswer1Field)
                        .addComponent(PersonComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(SecurityAnswer2Field, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(IsAccountLockedCheckBox)
                                .addComponent(IsAdministratorCheckBox)))))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PersonComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UserNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SecurityQuestion1Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SecurityAnswer1Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SecurityQuestion2Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SecurityAnswer2Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(IsAdministratorCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(IsAccountLockedCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SelectedThemeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
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

    private void IsAccountLockedCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IsAccountLockedCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IsAccountLockedCheckBoxActionPerformed

    private void IsAdministratorCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IsAdministratorCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IsAdministratorCheckBoxActionPerformed

    // </editor-fold> 
    
    // <editor-fold defaultstate="collapsed" desc="Generated UI Variables"> 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox IsAccountLockedCheckBox;
    private javax.swing.JCheckBox IsAdministratorCheckBox;
    private javax.swing.JTextField PasswordField;
    private javax.swing.JComboBox<Person> PersonComboBox;
    private javax.swing.JTextField SecurityAnswer1Field;
    private javax.swing.JTextField SecurityAnswer2Field;
    private javax.swing.JTextField SecurityQuestion1Field;
    private javax.swing.JTextField SecurityQuestion2Field;
    private javax.swing.JTextField SelectedThemeField;
    private javax.swing.JTextField UserNameField;
    private javax.swing.JButton applyButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton deleteButton;
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
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables

    // </editor-fold> 
}
