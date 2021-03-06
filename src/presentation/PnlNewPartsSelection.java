package presentation;

import domaine.Customer;
import java.awt.Color;
import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author Thery Ehrlich
 * 
 * Information d'ordre général : 
 * Les methodes keyPressed, keyReleased, focusGained et focusLost gèrent pour chaque champ 
 * le placement et la suppression des placeholders qui sont gérés par une classe 
 * centrale PlaceholderControl.java
 * 
 * 
 */
public class PnlNewPartsSelection extends javax.swing.JPanel {

    public static final String NO_STREET_PLACEHOLDER = "N° ou nom d'immeuble et nom de rue";
    public static final String EXTRA_INFO_PLACEHOLDER = "Code d'entrée, n° d'appartement";
    public static final String NPA_PLACEHOLDER = "NPA";
    public static final String AREA_PLACEHOLDER = "Lieu";

    FrmMain frmMain;
    PnlCase parent;
    PnlNewCaseNotes p1;
    FrmParts frmPartsQuoted;
    Component[] customerComponents;

    /**
     * Creates new form PnlNewPartsSelection
     *
     * @param parent
     */
    public PnlNewPartsSelection(PnlCase parent, PnlNewCaseNotes p1) {
        initComponents();
        this.parent = parent;
        this.p1 = p1;
        customerComponents = new Component[]{btnDelQuotedParts, tfPrenom, tfNom, tfEmail, tfPhone, tfAddress, tfAddressDetails, tfNPA, tfArea, btnSave, btnAddQuotedParts};
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        pnlNewCust = new javax.swing.JPanel();
        lblClient = new javax.swing.JLabel();
        sepNewCust = new javax.swing.JSeparator();
        lblPrenom = new javax.swing.JLabel();
        tfPrenom = new javax.swing.JTextField();
        lblNom = new javax.swing.JLabel();
        tfNom = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        lblPhone = new javax.swing.JLabel();
        tfPhone = new javax.swing.JTextField();
        lblAddress = new javax.swing.JLabel();
        tfAddress = new javax.swing.JTextField();
        tfAddressDetails = new javax.swing.JTextField();
        tfNPA = new javax.swing.JTextField();
        tfArea = new javax.swing.JTextField();
        lblCountry = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        pnlQuotedParts = new javax.swing.JPanel();
        lblQuotedParts = new javax.swing.JLabel();
        btnAddQuotedParts = new javax.swing.JButton();
        btnDelQuotedParts = new javax.swing.JButton();
        sepQuotedParts = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setBackground(javax.swing.UIManager.getDefaults().getColor("Button.light"));
        setMinimumSize(new java.awt.Dimension(383, 500));
        setPreferredSize(new java.awt.Dimension(383, 500));

        pnlNewCust.setBackground(new java.awt.Color(255, 255, 255));
        pnlNewCust.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnlNewCust.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pnlNewCustFocusGained(evt);
            }
        });
        pnlNewCust.setLayout(new java.awt.GridBagLayout());

        lblClient.setFont(new java.awt.Font("PingFang HK", 1, 18)); // NOI18N
        lblClient.setText("Client");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 11, 0, 0);
        pnlNewCust.add(lblClient, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.ipadx = 340;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 11, 0, 11);
        pnlNewCust.add(sepNewCust, gridBagConstraints);

        lblPrenom.setDisplayedMnemonic('p');
        lblPrenom.setLabelFor(tfPrenom);
        lblPrenom.setText("Prénom");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(9, 45, 0, 0);
        pnlNewCust.add(lblPrenom, gridBagConstraints);

        tfPrenom.setMinimumSize(new java.awt.Dimension(30, 20));
        tfPrenom.setPreferredSize(new java.awt.Dimension(30, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 231;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 8, 0, 11);
        pnlNewCust.add(tfPrenom, gridBagConstraints);

        lblNom.setDisplayedMnemonic('n');
        lblNom.setLabelFor(tfNom);
        lblNom.setText("Nom");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(9, 60, 0, 0);
        pnlNewCust.add(lblNom, gridBagConstraints);

        tfNom.setMinimumSize(new java.awt.Dimension(30, 20));
        tfNom.setPreferredSize(new java.awt.Dimension(30, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 231;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 8, 0, 11);
        pnlNewCust.add(tfNom, gridBagConstraints);

        lblEmail.setDisplayedMnemonic('m');
        lblEmail.setLabelFor(tfEmail);
        lblEmail.setText("Email");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(9, 59, 0, 0);
        pnlNewCust.add(lblEmail, gridBagConstraints);

        tfEmail.setMinimumSize(new java.awt.Dimension(30, 20));
        tfEmail.setPreferredSize(new java.awt.Dimension(30, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 231;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 8, 0, 11);
        pnlNewCust.add(tfEmail, gridBagConstraints);

        lblPhone.setDisplayedMnemonic('t');
        lblPhone.setLabelFor(tfPhone);
        lblPhone.setText("Téléphone");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(9, 33, 0, 0);
        pnlNewCust.add(lblPhone, gridBagConstraints);

        tfPhone.setMinimumSize(new java.awt.Dimension(30, 20));
        tfPhone.setNextFocusableComponent(tfAddress);
        tfPhone.setPreferredSize(new java.awt.Dimension(30, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 231;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 8, 0, 11);
        pnlNewCust.add(tfPhone, gridBagConstraints);

        lblAddress.setDisplayedMnemonic('a');
        lblAddress.setLabelFor(tfAddress);
        lblAddress.setText("Adresse");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(9, 42, 0, 0);
        pnlNewCust.add(lblAddress, gridBagConstraints);

        tfAddress.setForeground(new java.awt.Color(153, 153, 153));
        tfAddress.setText("N° ou nom d'immeuble et nom de rue");
        tfAddress.setMinimumSize(new java.awt.Dimension(30, 20));
        tfAddress.setPreferredSize(new java.awt.Dimension(30, 20));
        tfAddress.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfAddressFocusGained(evt);
            }
        });
        tfAddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfAddressKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfAddressKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 231;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 8, 0, 11);
        pnlNewCust.add(tfAddress, gridBagConstraints);

        tfAddressDetails.setForeground(new java.awt.Color(153, 153, 153));
        tfAddressDetails.setText("Code d'entrée, n° d'appartement");
        tfAddressDetails.setMinimumSize(new java.awt.Dimension(30, 20));
        tfAddressDetails.setPreferredSize(new java.awt.Dimension(30, 20));
        tfAddressDetails.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfAddressDetailsFocusGained(evt);
            }
        });
        tfAddressDetails.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfAddressDetailsKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfAddressDetailsKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 231;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 8, 0, 11);
        pnlNewCust.add(tfAddressDetails, gridBagConstraints);

        tfNPA.setForeground(new java.awt.Color(153, 153, 153));
        tfNPA.setText("NPA");
        tfNPA.setMinimumSize(new java.awt.Dimension(30, 20));
        tfNPA.setPreferredSize(new java.awt.Dimension(30, 20));
        tfNPA.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfNPAFocusGained(evt);
            }
        });
        tfNPA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfNPAKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfNPAKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 40;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 8, 0, 0);
        pnlNewCust.add(tfNPA, gridBagConstraints);

        tfArea.setForeground(new java.awt.Color(153, 153, 153));
        tfArea.setText("Lieu");
        tfArea.setMinimumSize(new java.awt.Dimension(30, 20));
        tfArea.setPreferredSize(new java.awt.Dimension(30, 20));
        tfArea.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfAreaFocusGained(evt);
            }
        });
        tfArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfAreaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfAreaKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.ipadx = 155;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 0, 11);
        pnlNewCust.add(tfArea, gridBagConstraints);

        lblCountry.setText("CH");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 13, 0, 0);
        pnlNewCust.add(lblCountry, gridBagConstraints);

        btnSave.setMnemonic('g');
        btnSave.setText("Enregistrer");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 106, 12, 11);
        pnlNewCust.add(btnSave, gridBagConstraints);

        pnlQuotedParts.setBackground(new java.awt.Color(255, 255, 255));
        pnlQuotedParts.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        lblQuotedParts.setFont(new java.awt.Font("PingFang HK", 1, 18)); // NOI18N
        lblQuotedParts.setText("Pièces devisées");

        btnAddQuotedParts.setMnemonic('j');
        btnAddQuotedParts.setText("Ajouter");
        btnAddQuotedParts.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                btnAddQuotedPartsFocusLost(evt);
            }
        });
        btnAddQuotedParts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddQuotedPartsActionPerformed(evt);
            }
        });

        btnDelQuotedParts.setMnemonic('u');
        btnDelQuotedParts.setText("Supprimer");
        btnDelQuotedParts.setEnabled(false);
        btnDelQuotedParts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelQuotedPartsActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Pièce", "Prix", "Stock dispo."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout pnlQuotedPartsLayout = new javax.swing.GroupLayout(pnlQuotedParts);
        pnlQuotedParts.setLayout(pnlQuotedPartsLayout);
        pnlQuotedPartsLayout.setHorizontalGroup(
            pnlQuotedPartsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlQuotedPartsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlQuotedPartsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sepQuotedParts)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlQuotedPartsLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAddQuotedParts)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelQuotedParts))
                    .addGroup(pnlQuotedPartsLayout.createSequentialGroup()
                        .addComponent(lblQuotedParts)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlQuotedPartsLayout.setVerticalGroup(
            pnlQuotedPartsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlQuotedPartsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblQuotedParts)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sepQuotedParts, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlQuotedPartsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddQuotedParts)
                    .addComponent(btnDelQuotedParts))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlNewCust, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlQuotedParts, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlNewCust, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlQuotedParts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleName("");
        getAccessibleContext().setAccessibleDescription("");
    }// </editor-fold>//GEN-END:initComponents

    //Enregistre un client et affiche ses données
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (CustomerInfoValid()) {
            tfPhone.setForeground(Color.black);
            Customer c = new Customer(0, tfNom.getText(), tfPrenom.getText(), tfEmail.getText(), tfPhone.getText(), tfAddress.getText(), tfAddressDetails.getText(), Integer.parseInt(tfNPA.getText()), tfArea.getText());
            parent.displayCustomer(c);
            System.out.println(c.toString());
            pnlNewCust.setVisible(false);
            pnlNewCust.setEnabled(false);
            parent.getBtnModifyCust().setEnabled(true);
            parent.getBtnModifyCust().setVisible(true);
            disableCustomerComponents();
            p1.getTaProblem().requestFocusInWindow();
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void pnlNewCustFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pnlNewCustFocusGained
        if (!this.isVisible()) {
            p1.requestFocusInWindow();
        }
    }//GEN-LAST:event_pnlNewCustFocusGained

    private void tfAddressKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfAddressKeyPressed
        PlaceholderControl.controlPlaceHolder(evt, tfAddress, NO_STREET_PLACEHOLDER);
    }//GEN-LAST:event_tfAddressKeyPressed

    private void tfAddressDetailsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfAddressDetailsKeyPressed
        PlaceholderControl.controlPlaceHolder(evt, tfAddressDetails, EXTRA_INFO_PLACEHOLDER);
    }//GEN-LAST:event_tfAddressDetailsKeyPressed

    private void tfNPAKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNPAKeyPressed
        PlaceholderControl.controlPlaceHolder(evt, tfNPA, NPA_PLACEHOLDER);
    }//GEN-LAST:event_tfNPAKeyPressed

    private void tfAreaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfAreaKeyPressed
        PlaceholderControl.controlPlaceHolder(evt, tfArea, AREA_PLACEHOLDER);
    }//GEN-LAST:event_tfAreaKeyPressed

    private void tfAddressKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfAddressKeyReleased
        PlaceholderControl.setKeyRelease(tfAddress, NO_STREET_PLACEHOLDER);
    }//GEN-LAST:event_tfAddressKeyReleased

    private void tfAddressDetailsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfAddressDetailsKeyReleased
        PlaceholderControl.setKeyRelease(tfAddressDetails, EXTRA_INFO_PLACEHOLDER);
    }//GEN-LAST:event_tfAddressDetailsKeyReleased

    private void tfNPAKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNPAKeyReleased
        PlaceholderControl.setKeyRelease(tfNPA, NPA_PLACEHOLDER);
    }//GEN-LAST:event_tfNPAKeyReleased

    private void tfAreaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfAreaKeyReleased
        PlaceholderControl.setKeyRelease(tfArea, AREA_PLACEHOLDER);
    }//GEN-LAST:event_tfAreaKeyReleased

    private void tfAddressFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfAddressFocusGained
        tfAddress.setCaretPosition(0);
    }//GEN-LAST:event_tfAddressFocusGained

    private void tfAddressDetailsFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfAddressDetailsFocusGained
        tfAddressDetails.setCaretPosition(0);
    }//GEN-LAST:event_tfAddressDetailsFocusGained

    private void tfNPAFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfNPAFocusGained
        tfNPA.setCaretPosition(0);
    }//GEN-LAST:event_tfNPAFocusGained

    private void tfAreaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfAreaFocusGained
        tfArea.setCaretPosition(0);
    }//GEN-LAST:event_tfAreaFocusGained

    private void btnDelQuotedPartsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelQuotedPartsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDelQuotedPartsActionPerformed

    private void btnAddQuotedPartsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddQuotedPartsActionPerformed
        if (frmPartsQuoted == null) {
            frmPartsQuoted = new FrmParts(frmMain);
            frmPartsQuoted.setTitle("Pièces devisées");
        }
        frmPartsQuoted.setVisible(true);
    }//GEN-LAST:event_btnAddQuotedPartsActionPerformed

    private void btnAddQuotedPartsFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnAddQuotedPartsFocusLost
        p1.getTaProblem().requestFocusInWindow();
    }//GEN-LAST:event_btnAddQuotedPartsFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddQuotedParts;
    private javax.swing.JButton btnDelQuotedParts;
    private javax.swing.JButton btnSave;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblClient;
    private javax.swing.JLabel lblCountry;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblNom;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblPrenom;
    private javax.swing.JLabel lblQuotedParts;
    private javax.swing.JPanel pnlNewCust;
    private javax.swing.JPanel pnlQuotedParts;
    private javax.swing.JSeparator sepNewCust;
    private javax.swing.JSeparator sepQuotedParts;
    private javax.swing.JTextField tfAddress;
    private javax.swing.JTextField tfAddressDetails;
    private javax.swing.JTextField tfArea;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfNPA;
    private javax.swing.JTextField tfNom;
    private javax.swing.JTextField tfPhone;
    private javax.swing.JTextField tfPrenom;
    // End of variables declaration//GEN-END:variables

    protected Component[] getCustomerComponents() {
        return customerComponents;
    }

    protected JPanel getPnlNewCust() {
        return pnlNewCust;
    }

    /* Gère l'affichage d'alertes dans les cas ou les champs ne sont pas 
     * correctement remplis 
     */
    private boolean CustomerInfoValid() {
        Border errordBdr = BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(1, 1, 1, 5, Color.red), BorderFactory.createEmptyBorder(2, 2, 2, 2));
        Border correctBdr = BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)), BorderFactory.createEmptyBorder(2, 2, 2, 2));
        boolean isValid = true;

        if (tfPrenom.getText().length() < 1) {
            isValid = false;
            tfPrenom.setBorder(errordBdr);
        } else {
            tfPrenom.setBorder(correctBdr);
        }
        if (tfNom.getText().length() < 1) {
            isValid = false;
            tfNom.setBorder(errordBdr);
        } else {
            tfNom.setBorder(correctBdr);
        }
        if (tfEmail.getText().length() < 1) {
            isValid = false;
            tfEmail.setBorder(errordBdr);
        } else {
            tfEmail.setBorder(correctBdr);
        }
        if (tfPhone.getText().length() != 10) {
            isValid = false;
            tfPhone.setBorder(errordBdr);
        } else {
            tfPhone.setBorder(correctBdr);
        }
        if (tfAddress.getText().length() < 1 || tfAddress.getText().equals(NO_STREET_PLACEHOLDER)) {
            isValid = false;
            tfAddress.setBorder(errordBdr);
        } else {
            tfAddress.setBorder(correctBdr);
        }
        if (tfNPA.getText().length() < 1 || tfNPA.getText().equals(NPA_PLACEHOLDER)) {
            isValid = false;
            tfNPA.setBorder(errordBdr);
        } else {
            tfNPA.setBorder(correctBdr);
        }
        if (tfArea.getText().length() < 1 || tfArea.getText().equals(AREA_PLACEHOLDER)) {
            isValid = false;
            tfArea.setBorder(errordBdr);
        } else {
            tfArea.setBorder(correctBdr);
        }
        return isValid;
    }

    private void disableCustomerComponents() {
        tfNom.setEnabled(false);
        tfPrenom.setEnabled(false);
        tfEmail.setEnabled(false);
        tfPhone.setEnabled(false);
        tfAddress.setEnabled(false);
        tfAddressDetails.setEnabled(false);
        tfNPA.setEnabled(false);
        tfArea.setEnabled(false);
        btnSave.setEnabled(false);
    }

}
