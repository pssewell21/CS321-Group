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
import Controllers.AccountPersonMapEditViewController;
import Library.Account;
import Library.Person;
import java.awt.Graphics;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JOptionPane;

/**
 *The AccountPersonMap edit view.
 * @author Patrick Sewell
 */
public class AccountPersonMapEditView extends javax.swing.JFrame {
    // <editor-fold defaultstate="collapsed" desc="Member Variables"> 

    private final AccountPersonMapEditViewController controller;

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Constructors"> 
    /**
     * Creates new form AccountPersonMapEditView.
     * @param controller The AccountPersonMapEditViewController for the view
     */
    public AccountPersonMapEditView(AccountPersonMapEditViewController controller) {
        this.controller = controller;
        load();
    }

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Methods"> 
    /**
     * Enables or Disables the delete button.
     * @param isEnabled the value indicating if the button will be enabled or disabled
     */
    public void setDeleteEnabled(boolean isEnabled) {
        deleteButton.setEnabled(isEnabled);
    }

    private void load() {
        initComponents();
        setThemeColors();
        setTitle("Create an Account Link");

        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/Resources/icon.png")).getImage());

        if (controller.model.accountId != null) {
            ComboBoxModel<Account> comboBoxModel = accountComboBox.getModel();

            for (int i = 0; i < comboBoxModel.getSize(); i++) {
                Account account = comboBoxModel.getElementAt(i);

                if (account.id.equals(controller.model.accountId)) {
                    comboBoxModel.setSelectedItem(account);
                }
            }
        } else {
            accountComboBox.setSelectedItem(null);
        }

        pack();
        setResizable(false);
        setVisible(true);
    }

    private void setThemeColors() {
        jPanel1.setBackground(UserSettings.selectedTheme.getBackgroundColor());

        personComboBox.setBackground(UserSettings.selectedTheme.getComboBoxBackgroundColor());
        accountComboBox.setBackground(UserSettings.selectedTheme.getComboBoxBackgroundColor());
        applyButton.setBackground(UserSettings.selectedTheme.getTextFieldBackgroundColor());
        saveButton.setBackground(UserSettings.selectedTheme.getTextFieldBackgroundColor());
        cancelButton.setBackground(UserSettings.selectedTheme.getTextFieldBackgroundColor());
        deleteButton.setBackground(UserSettings.selectedTheme.getTextFieldBackgroundColor());

        personComboBox.setForeground(UserSettings.selectedTheme.getTextColor());
        accountComboBox.setForeground(UserSettings.selectedTheme.getTextColor());
        applyButton.setForeground(UserSettings.selectedTheme.getTextColor());
        saveButton.setForeground(UserSettings.selectedTheme.getTextColor());
        cancelButton.setForeground(UserSettings.selectedTheme.getTextColor());
        deleteButton.setForeground(UserSettings.selectedTheme.getTextColor());
        jLabel2.setForeground(UserSettings.selectedTheme.getTextColor());
        jLabel3.setForeground(UserSettings.selectedTheme.getTextColor());
        requiredLabel.setForeground(UserSettings.selectedTheme.getTextColor());

        personComboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public void paint(Graphics g) {
                setBackground(UserSettings.selectedTheme.getListBackgroundColor());
                setForeground(UserSettings.selectedTheme.getTextColor());
                super.paint(g);
            }
        });
        accountComboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public void paint(Graphics g) {
                setBackground(UserSettings.selectedTheme.getListBackgroundColor());
                setForeground(UserSettings.selectedTheme.getTextColor());
                super.paint(g);
            }
        });
    }

    private void setModelFields() throws Exception {
        Person person = (Person) personComboBox.getSelectedItem();
        Account account = (Account) accountComboBox.getSelectedItem();

        if (person != null) {
            controller.model.personId = person.id;
        } else {
            throw new Exception("Person ID is required");
        }

        if (account != null) {
            controller.model.accountId = account.id;
        } else {
            throw new Exception("Person ID is required");
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        personComboBox = new javax.swing.JComboBox<>();
        accountComboBox = new javax.swing.JComboBox<>();
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

        jLabel2.setText("Account ID*:");

        jLabel3.setText("Person ID*:");

        personComboBox.setModel(controller.personListModel);
        personComboBox.setEnabled(false);

        accountComboBox.setModel(controller.accountListModel);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(personComboBox, 0, 158, Short.MAX_VALUE)
                    .addComponent(accountComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(87, 87, 87))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(applyButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(personComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(accountComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addContainerGap(324, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .addComponent(requiredLabel)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Generated UI Variables"> 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Account> accountComboBox;
    private javax.swing.JButton applyButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<Person> personComboBox;
    private javax.swing.JLabel requiredLabel;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables

    // </editor-fold> 
}
