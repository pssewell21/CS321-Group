/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Common.UserSettings;
import Controllers.NavigationViewController;

/**
 *
 * @author Owner
 */
public class NavigationView extends javax.swing.JFrame {

    // <editor-fold defaultstate="collapsed" desc="Member Variables"> 
    private final NavigationViewController controller;

    // </editor-fold>
    /**
     * Creates new form NavigationView
     *
     * @param controller
     */
    public NavigationView(NavigationViewController controller) {
        this.controller = controller;
        load();
    }

    // </editor-fold> 
    private void load() {
        initComponents();
        setThemeColors();

        setResizable(false);
        setVisible(true);
    }

    private void setThemeColors() {
        jPanel1.setBackground(UserSettings.theme.getBackgroundColor());

        accountManagerButton.setBackground(UserSettings.theme.getButtonBackgroundColor());
        accountPersonLinkManagerButton.setBackground(UserSettings.theme.getButtonBackgroundColor());
        personManagerButton.setBackground(UserSettings.theme.getButtonBackgroundColor());
        testDataButton.setBackground(UserSettings.theme.getButtonBackgroundColor());
        userManagerButton.setBackground(UserSettings.theme.getButtonBackgroundColor());

        accountManagerButton.setForeground(UserSettings.theme.getTextColor());
        accountPersonLinkManagerButton.setForeground(UserSettings.theme.getTextColor());
        personManagerButton.setForeground(UserSettings.theme.getTextColor());
        testDataButton.setForeground(UserSettings.theme.getTextColor());
        userManagerButton.setForeground(UserSettings.theme.getTextColor());
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
        testDataButton = new javax.swing.JButton();
        personManagerButton = new javax.swing.JButton();
        userManagerButton = new javax.swing.JButton();
        accountManagerButton = new javax.swing.JButton();
        accountPersonLinkManagerButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        testDataButton.setText("Test Data");
        testDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testDataButtonActionPerformed(evt);
            }
        });

        personManagerButton.setText("Person Manager");
        personManagerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                personManagerButtonActionPerformed(evt);
            }
        });

        userManagerButton.setText("User Manager");
        userManagerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userManagerButtonActionPerformed(evt);
            }
        });

        accountManagerButton.setText("Account Manager");
        accountManagerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountManagerButtonActionPerformed(evt);
            }
        });

        accountPersonLinkManagerButton.setText("Account Person Link Manager");
        accountPersonLinkManagerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountPersonLinkManagerButtonActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/logo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(testDataButton, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(accountManagerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(userManagerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(personManagerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(accountPersonLinkManagerButton, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(testDataButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(personManagerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(userManagerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(accountManagerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(accountPersonLinkManagerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel1)))
                .addContainerGap(168, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void testDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testDataButtonActionPerformed
        controller.executeNavigateTestDataList();
    }//GEN-LAST:event_testDataButtonActionPerformed

    private void personManagerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_personManagerButtonActionPerformed
        controller.executeNavigatePersonList();
    }//GEN-LAST:event_personManagerButtonActionPerformed

    private void userManagerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userManagerButtonActionPerformed
        controller.executeNavigateUserList();
    }//GEN-LAST:event_userManagerButtonActionPerformed

    private void accountManagerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountManagerButtonActionPerformed
        controller.executeNavigateAccountList();
    }//GEN-LAST:event_accountManagerButtonActionPerformed

    private void accountPersonLinkManagerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountPersonLinkManagerButtonActionPerformed
        controller.executeNavigateAccountPersonMapList();
    }//GEN-LAST:event_accountPersonLinkManagerButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accountManagerButton;
    private javax.swing.JButton accountPersonLinkManagerButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton personManagerButton;
    private javax.swing.JButton testDataButton;
    private javax.swing.JButton userManagerButton;
    // End of variables declaration//GEN-END:variables
}
