/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.awt.Frame;

/**
 *
 * @author mgtub
 */
public class DiaAdminChoice extends javax.swing.JDialog {
    
    FrmLogin frmLogin = new FrmLogin();
    Frame par;

    /**
     * Creates new form DiaAdminChoice
     * @param parent
     * @param modal
     */
    public DiaAdminChoice(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblInfo = new javax.swing.JLabel();
        btnAdmin = new javax.swing.JButton();
        btnRepairs = new javax.swing.JButton();

        setLocation(new java.awt.Point(800, 500));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lblInfo.setText("Quel environnement souhaitez-vous ouvrir ?");

        btnAdmin.setText("Administration");
        btnAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminActionPerformed(evt);
            }
        });

        btnRepairs.setText("Réparations");
        btnRepairs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRepairsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblInfo)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdmin)
                        .addGap(20, 20, 20)
                        .addComponent(btnRepairs)))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblInfo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdmin)
                    .addComponent(btnRepairs))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRepairsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRepairsActionPerformed
        this.dispose();
        new FrmMain().setVisible(true);
    }//GEN-LAST:event_btnRepairsActionPerformed

    private void btnAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminActionPerformed
        this.dispose();
        new FrmAdmin().setVisible(true);
    }//GEN-LAST:event_btnAdminActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.dispose();
        new FrmLogin().setVisible(true);
    }//GEN-LAST:event_formWindowClosing
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdmin;
    private javax.swing.JButton btnRepairs;
    private javax.swing.JLabel lblInfo;
    // End of variables declaration//GEN-END:variables

    public void setParent(Frame p) {
        par = p;
    }
    
    @Override
    public Frame getParent() {
        return par;
    }
}
