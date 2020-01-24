package presentation;

import base.RepairDao;
import domaine.Customer;
import domaine.Repair;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;
import metier.ListeObjects;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import domaine.Note;
import domaine.Part;
import java.awt.event.KeyEvent;
import java.io.FileOutputStream;
import java.util.StringTokenizer;

/**
 *
 * @author Thery Ehrlich
 * Information d'ordre général : 
 * Les methodes keyPressed, keyReleased, focusGained et focusLost gèrent pour chaque champ 
 * le placement et la suppression des placeholders qui sont gérés par une classe 
 * centrale PlaceholderControl.java
 */
public class FrmMain extends javax.swing.JFrame {

    /* Identifiant du centre technique (à remplacer avec l'identifiant correct) */
    protected static final String VENDOR_ID = "R271";
    /* Code postal du centre technique (à remplacer avec le bon code) */
    protected static final String VENDOR_LOCATION = "022";
    /* Code du pays ou se trouve le centre technique (à remplacer avec le bon code) */
    protected static final String VENDOR_COUNTRY = "CH";
    protected static final boolean NEW_REPAIR = true;
    protected static final String NEW_REP_LBL = "Nouvelle réparation";
    protected static final String SEARCH_PLACEHOLDER = "N° réparation, email";
    //Texte de conditions de service pour la sociétée (doit être modifié par l'entreprise) 
    private static final String LEGAL = "Autorisation d'intervention. J'accepte "
            + "ce qui suit : les Conditions générales de réparation "
            + "figurant au dos de cette page s'appliqueront à l'intervention "
            + "affectant le Produit identifié ci-dessus ; GoInfo SA ne peut être "
            + "tenue responsable de la perte, de la corruption ou de la "
            + "divulgation des données stockées sur mon produit pendant "
            + "l'intervention ; l'intervention pouvant entraîner une "
            + "perte de données, il est de ma responsabilité d'effectuer "
            + "une sauvegarde de mes données avant de déposer mon produit "
            + "chez GoInfo SA pour réparation ; les produits déposés pour "
            + "réparation pourront être remplacés par des appareils "
            + "reconditionnés du même type au lieu d'être réparés. "
            + "Des pièces reconditionnées pourront être utilisées pour "
            + "réparer le produit déposé.\n\n";
    //Texte de remerciement d'utilisation du service et autres infos pratiques (doit être modifié par l'entreprise)
    private static final String THANKS = "Merci d’avoir choisi GoInfo SA pour "
            + "la réparation de votre produit. Afin d’assurer le niveau de "
            + "qualité et de fiabilité le plus élevé possible, tous les "
            + "travaux sont réalisés par des techniciens certifiés utilisant "
            + "des pièces de qualité. De plus, toutes les réparations sont "
            + "couvertes par la garantie de service GoGoGo de 90 jours ou "
            + "bien jusqu’à la fin de la garantie originale d’un an de votre "
            + "produit, selon la période la plus longue. \n\n"
            + "Pour obtenir du soutien technique ou administratif supplémentaire, veuillez communiquer "
            + "avec le soutien GoPhone au (41) 0848 000 132. Vous trouverez "
            + "également des réponses à de nombreuses questions concernant "
            + "le fonctionnement de votre produit sur : www.goinfo.com/chfr/support/ "
            + "\n\n"
            + "Les Conditions générales des interventions de réparation peuvent "
            + "être consultées à l'adresse suivante http://www.goinfo.com/legal/sales-support/terms/repair/retailservice.html.";
    private ListeObjects lstRepairs;
    private ListeObjects lstCustomers;
    private ArrayList openTabs = new ArrayList();
    private ArrayList statusList;
    private DefaultTableModel repModel;

    /**
     * Creates new form FrmMain
     */
    FrmLogin frmLogin = new FrmLogin();
    //FrmParts frmParts = new FrmParts(this);
    JPanel tabComp;
    PnlCase p;

    public FrmMain() {
        initComponents();
        repModel = (DefaultTableModel) tblRepairList.getModel();
        loadRepairList();
        loadCustomerList();
        loadStatusList();
        displayRepairList();
        tfSearch.setCaretPosition(0);
        openTabs.add(0);
    }

    /* Tiens compte des onglets */
    int tabNo = 0;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlHeader = new javax.swing.JPanel();
        lblMaster = new javax.swing.JLabel();
        lblRepair = new javax.swing.JLabel();
        tfSearch = new javax.swing.JTextField();
        lblSearch = new javax.swing.JLabel();
        tabs = new javax.swing.JTabbedPane();
        pnlGrid = new javax.swing.JPanel();
        pnlMain = new javax.swing.JPanel();
        btnNewRep = new javax.swing.JButton();
        scpTblRepairList = new javax.swing.JScrollPane();
        tblRepairList = new javax.swing.JTable();
        btnLogout = new javax.swing.JButton();
        pnlNewCase = new javax.swing.JPanel();
        mnuMain = new javax.swing.JMenuBar();
        mnuFile = new javax.swing.JMenu();
        mnuFileNew = new javax.swing.JMenuItem();
        mnuFileCloseTab = new javax.swing.JMenuItem();
        mnuFilePrint = new javax.swing.JMenuItem();
        mnuFileLogout = new javax.swing.JMenuItem();
        mnuFileQuit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Repair Master");
        setBackground(new java.awt.Color(255, 255, 255));
        setLocation(new java.awt.Point(350, 100));
        setMinimumSize(new java.awt.Dimension(1176, 835));
        setPreferredSize(new java.awt.Dimension(1176, 835));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.PAGE_AXIS));

        lblMaster.setFont(new java.awt.Font("Helvetica Neue", 0, 41)); // NOI18N
        lblMaster.setForeground(new java.awt.Color(0, 102, 255));
        lblMaster.setText("Master");

        lblRepair.setFont(new java.awt.Font("Helvetica Neue", 0, 41)); // NOI18N
        lblRepair.setText("Repair");

        tfSearch.setForeground(java.awt.Color.gray);
        tfSearch.setText("N° réparation, email");
        tfSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfSearchFocusGained(evt);
            }
        });
        tfSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfSearchMouseClicked(evt);
            }
        });
        tfSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfSearchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfSearchKeyReleased(evt);
            }
        });

        lblSearch.setDisplayedMnemonic('r');
        lblSearch.setLabelFor(tfSearch);
        lblSearch.setText("Rechercher");

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblRepair)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMaster)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 616, Short.MAX_VALUE)
                .addComponent(lblSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaster)
                    .addComponent(lblRepair)
                    .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSearch))
                .addContainerGap())
        );

        getContentPane().add(pnlHeader);

        tabs.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        tabs.setAutoscrolls(true);
        tabs.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 14)); // NOI18N
        tabs.setMinimumSize(new java.awt.Dimension(1171, 700));
        tabs.setPreferredSize(new java.awt.Dimension(1171, 700));
        tabs.setVerifyInputWhenFocusTarget(false);

        pnlGrid.setLayout(new javax.swing.OverlayLayout(pnlGrid));

        pnlMain.setBackground(new java.awt.Color(255, 255, 255));
        pnlMain.setMinimumSize(new java.awt.Dimension(1176, 824));
        pnlMain.setPreferredSize(new java.awt.Dimension(1176, 824));

        btnNewRep.setMnemonic('n');
        btnNewRep.setText("Nouvelle réparation");
        btnNewRep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewRepActionPerformed(evt);
            }
        });

        scpTblRepairList.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        tblRepairList.setAutoCreateRowSorter(true);
        tblRepairList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N° réparation", "Client", "N° de série", "Statut", "Date d'entrée", "Date de sortie"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblRepairList.setFocusable(false);
        tblRepairList.setGridColor(new java.awt.Color(204, 204, 204));
        tblRepairList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRepairListMouseClicked(evt);
            }
        });
        scpTblRepairList.setViewportView(tblRepairList);

        btnLogout.setMnemonic('d');
        btnLogout.setText("Se déconnecter");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scpTblRepairList, javax.swing.GroupLayout.DEFAULT_SIZE, 1151, Short.MAX_VALUE)
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addComponent(btnLogout)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnNewRep)))
                .addContainerGap())
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scpTblRepairList, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNewRep)
                    .addComponent(btnLogout))
                .addContainerGap())
        );

        pnlGrid.add(pnlMain);

        pnlNewCase.setLayout(new javax.swing.BoxLayout(pnlNewCase, javax.swing.BoxLayout.PAGE_AXIS));
        pnlGrid.add(pnlNewCase);

        tabs.addTab("Réparations", pnlGrid);

        getContentPane().add(tabs);
        tabs.getAccessibleContext().setAccessibleName("tabRepair");

        mnuFile.setMnemonic('f');
        mnuFile.setText("Fichier");

        mnuFileNew.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        mnuFileNew.setMnemonic('n');
        mnuFileNew.setText("Nouvelle réparation");
        mnuFileNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuFileNewActionPerformed(evt);
            }
        });
        mnuFile.add(mnuFileNew);

        mnuFileCloseTab.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        mnuFileCloseTab.setMnemonic('o');
        mnuFileCloseTab.setText("Fermer l'ongelt courant");
        mnuFileCloseTab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuFileCloseTabActionPerformed(evt);
            }
        });
        mnuFile.add(mnuFileCloseTab);

        mnuFilePrint.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        mnuFilePrint.setMnemonic('i');
        mnuFilePrint.setText("Imprimer devis");
        mnuFilePrint.setEnabled(false);
        mnuFilePrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuFilePrintActionPerformed(evt);
            }
        });
        mnuFile.add(mnuFilePrint);

        mnuFileLogout.setMnemonic('d');
        mnuFileLogout.setText("Se déconnecter...");
        mnuFileLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuFileLogoutActionPerformed(evt);
            }
        });
        mnuFile.add(mnuFileLogout);

        mnuFileQuit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        mnuFileQuit.setMnemonic('q');
        mnuFileQuit.setText("Quitter Repair Master");
        mnuFileQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuFileQuitActionPerformed(evt);
            }
        });
        mnuFile.add(mnuFileQuit);

        mnuMain.add(mnuFile);

        setJMenuBar(mnuMain);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /* Permet de supprimer un onglet lorsque le bouton "x" est cliqué */
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            for (int i = 0; i < tabs.getTabCount(); i++) {
                if (SwingUtilities.isDescendingFrom(button, tabs.getTabComponentAt(i))) {
                    tabs.remove(i);
                    openTabs.remove(i);
                    tabNo--;
                    break;
                }
            }
        }
    };

    /* Crée un nouvel onglet avec une nouvelle réparation après avoir cliqué sur
       le bouton "Nouvelle réparation" */
    private void btnNewRepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewRepActionPerformed
        newRepair();
    }//GEN-LAST:event_btnNewRepActionPerformed

    /* Crée un nouvel onglet avec une nouvelle réparation après avoir cliqué sur
       le champ "Nouvelle réparation" dans la barre de menu */
    private void mnuFileNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuFileNewActionPerformed
        newRepair();
    }//GEN-LAST:event_mnuFileNewActionPerformed

    /* Affiche un prompt qui demande si l'on souhaite se déconnecter ou quitter
       l'application */
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        DiaQuit diaQuit = new DiaQuit(this, true);
        diaQuit.setParent(this);
        diaQuit.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    /* Quitte l'application sans avertissement */
    private void mnuFileQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuFileQuitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_mnuFileQuitActionPerformed

    /* Quitte la session courante après avoir cliqué sur
       le champ "Se déconnecter" dans la barre de menu */
    private void mnuFileLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuFileLogoutActionPerformed
        frmLogin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_mnuFileLogoutActionPerformed

    /* Quitte la session courante après avoir cliqué sur
       le bouton "Se déconnecter" */
    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        this.dispose();
        frmLogin.setVisible(true);
    }//GEN-LAST:event_btnLogoutActionPerformed

    /* Ferme un onglet si on utilise le racourci clavier ou le bouton de menu */
    private void mnuFileCloseTabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuFileCloseTabActionPerformed
        if (tabs.getTabCount() > 1) {
            tabs.remove(tabs.getSelectedIndex());
            tabNo--;
        }
    }//GEN-LAST:event_mnuFileCloseTabActionPerformed

    private void tfSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfSearchMouseClicked
        if (tfSearch.getText().equals(SEARCH_PLACEHOLDER)) {
            tfSearch.setCaretPosition(0);
        }
    }//GEN-LAST:event_tfSearchMouseClicked

    private void tfSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSearchKeyPressed
        PlaceholderControl.controlPlaceHolder(evt, tfSearch, SEARCH_PLACEHOLDER);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            //fonctionnalité à implémenter
        }
    }//GEN-LAST:event_tfSearchKeyPressed

    private void tfSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSearchKeyReleased
        PlaceholderControl.setKeyRelease(tfSearch, SEARCH_PLACEHOLDER);
    }//GEN-LAST:event_tfSearchKeyReleased

    private void tblRepairListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRepairListMouseClicked
        int index = tblRepairList.getSelectedRow();
        if (evt.getClickCount() == 2) {
            try {
                openRepair(index);
            } catch (BadLocationException ex) {
                Logger.getLogger(FrmMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_tblRepairListMouseClicked
    
    //Gère l'impression du PDF du devis de réparation
    private void mnuFilePrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuFilePrintActionPerformed
        ArrayList<Part> usedParts = p.p1.getUsedParts();
        ArrayList<Note> notes = p.getNotes();
        int repairNo = p.getRepairNo();
        String customerInfo = p.getCustomerInfo();
        double subTotal = 0;

        Document document = new Document(PageSize.A4);
        document.addAuthor("GoInfo SA");
        document.addTitle("Devis de réparation");
        try {
            PdfWriter.getInstance(document, new FileOutputStream("Devis" + VENDOR_COUNTRY + VENDOR_ID + VENDOR_LOCATION + repairNo + ".pdf"));
            document.open();
            Font bigFont = FontFactory.getFont("Arial", 20);
            bigFont.setStyle(java.awt.Font.BOLD);
            Font smallFont = FontFactory.getFont("Arial", 8);
            Font normalFont = FontFactory.getFont("Arial", 10);
            Paragraph title = new Paragraph("Devis de service GoInfo SA\n", bigFont);
            Paragraph custDesc = new Paragraph("\nInformations client\n\n", smallFont);
            DottedLineSeparator d = new DottedLineSeparator();
            Paragraph custInfo = new Paragraph(customerInfo + "\n\n");
            Paragraph issueDesc = new Paragraph("Description du problème/diagnostic\n\n", smallFont);
            Paragraph quote = new Paragraph("\nEstimation de la réparation\n\n", smallFont);
            Paragraph legal = new Paragraph("\n" + LEGAL, normalFont);
            Paragraph thanks = new Paragraph(THANKS, normalFont);
            Paragraph sep = new Paragraph("\n");
            PdfPTable table = new PdfPTable(3);
            table.setWidthPercentage(100);
            document.add(title);
            document.add(custDesc);
            document.add(d);
            document.add(custInfo);
            document.add(issueDesc);
            document.add(d);
            StringTokenizer st = new StringTokenizer(notes.get(0).getBody(), ";");
            while (st.hasMoreTokens()) {
                Paragraph p = new Paragraph(st.nextToken() + "\n", normalFont);
                document.add(p);
            }
            document.add(quote);
            document.add(d);
            document.add(sep);
            for (int i = 0; i < usedParts.size(); i++) {
                table.addCell(usedParts.get(i).getDesc());
                table.addCell(usedParts.get(i).getSerialNo());
                table.addCell(String.valueOf(usedParts.get(i).getPrice()));
                subTotal += usedParts.get(i).getPrice();
            }
            double taxAmount = (double) (long) (((subTotal * 0.08) * 20 + 0.5) / 20);
            table.addCell("");
            table.addCell("Sous-total");
            table.addCell(String.valueOf(subTotal));
            table.addCell("");
            table.addCell("Taxe (8%)");
            table.addCell(String.valueOf(taxAmount));
            table.addCell("");
            table.addCell("Total");
            double totalPrice = (double) (long) (((subTotal + taxAmount) * 20 + 0.5) / 20);
            table.addCell(String.valueOf(totalPrice));
            table.setWidths(new int[]{60, 30, 10});
            document.add(table);
            document.add(legal);
            document.add(thanks);
        } catch (Exception e) {
            e.printStackTrace();
        }
        document.close();
    }//GEN-LAST:event_mnuFilePrintActionPerformed

    private void tfSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfSearchFocusGained
        if (tfSearch.getText().equals(SEARCH_PLACEHOLDER)) {
            tfSearch.setCaretPosition(0);
        }
    }//GEN-LAST:event_tfSearchFocusGained

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnNewRep;
    private javax.swing.JLabel lblMaster;
    private javax.swing.JLabel lblRepair;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JMenu mnuFile;
    private javax.swing.JMenuItem mnuFileCloseTab;
    private javax.swing.JMenuItem mnuFileLogout;
    private javax.swing.JMenuItem mnuFileNew;
    private javax.swing.JMenuItem mnuFilePrint;
    private javax.swing.JMenuItem mnuFileQuit;
    private javax.swing.JMenuBar mnuMain;
    private javax.swing.JPanel pnlGrid;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlNewCase;
    private javax.swing.JScrollPane scpTblRepairList;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblRepairList;
    private javax.swing.JTextField tfSearch;
    // End of variables declaration//GEN-END:variables

    /* crée une nouvelle réparation */
    private void newRepair() {
        p = new PnlCase(this, NEW_REPAIR);
        setTabComponent(NEW_REPAIR);
        tabs.addTab(null, p);
        tabs.setTabComponentAt(tabs.getTabCount() - 1, tabComp);
        tabs.setSelectedIndex(tabs.getTabCount() - 1);
        mnuFilePrint.setEnabled(false);
    }

    /* ouvre une réparation existante */
    private void openRepair(int index) throws BadLocationException {
        Repair r = (Repair) lstRepairs.get(index);
        if (openTabs.indexOf(r.getRepairNo()) == -1) {
            openTabs.add(tabs.getTabCount(), r.getRepairNo());
            p = new PnlCase(this, !NEW_REPAIR, r.getRepairNo());
            setTabComponent(!NEW_REPAIR);
            tabs.addTab(null, p);
            tabs.setTabComponentAt(tabs.getTabCount() - 1, tabComp);
            tabs.setSelectedIndex(tabs.getTabCount() - 1);
            for (int i = 0; i < lstCustomers.size(); i++) {
                Customer c = (Customer) lstCustomers.get(i);
                if (c.getId() == r.getOwnerId()) {
                    p.displayCustomer(c);
                    break;
                }
            }
            p.displayStatus(r.getStatus());
            p.displayBeginDate(r.getBeginDate());
            //p.loadUsedParts(r.getRepairNo());
            p.loadNotes(r.getRepairNo());
            p.displayPermaNote();
            mnuFilePrint.setEnabled(true);
        } else {
            tabs.setSelectedIndex(index + 1);
        }
    }

    /* récupère la réparation existante (à développer) */
    private void findRepair(int repNo) {
        p = new PnlCase(this, !NEW_REPAIR);
        setTabComponent(!NEW_REPAIR);
        tabs.addTab(null, p);
        tabs.setTabComponentAt(tabNo, tabComp);
        tabs.setSelectedIndex(tabNo);
        mnuFilePrint.setEnabled(true);
    }

    /* Définit le contenu d'un ongelt (titre et  bouton "x") */
    private void setTabComponent(boolean isNewRep) {
        int index = tblRepairList.getSelectedRow();
        Repair r = (Repair) lstRepairs.get(index);
        JLabel label;
        if (!isNewRep) {
            label = new JLabel(VENDOR_COUNTRY + VENDOR_ID + VENDOR_LOCATION + r.getRepairNo() + " ", JLabel.RIGHT);
            ++tabNo;
        } else {
            label = new JLabel(NEW_REP_LBL + " " + ++tabNo);
        }
        label.setFont(new java.awt.Font("Lucida Grande", 1, 14));
        label.setOpaque(false);
        JButton closeButton = new JButton();
        closeButton.setOpaque(false);
        closeButton.setForeground(new java.awt.Color(255, 0, 0));
        closeButton.setText("x");
        closeButton.setAlignmentY(0.0F);
        closeButton.setAutoscrolls(true);
        closeButton.setBorderPainted(false);
        closeButton.setContentAreaFilled(false);
        closeButton.setFocusable(true);
        closeButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        closeButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        closeButton.setIconTextGap(0);
        closeButton.setInheritsPopupMenu(true);
        closeButton.setMargin(new java.awt.Insets(1, 4, 1, 4));
        closeButton.setFont(new java.awt.Font("Lucida Grande", 1, 14));
        closeButton.addActionListener(actionListener);
        tabComp = new JPanel(new BorderLayout());
        tabComp.setOpaque(false);
        tabComp.add(label, BorderLayout.WEST);
        tabComp.add(closeButton, BorderLayout.EAST);
        tabComp.setBackground(new java.awt.Color(255, 255, 255));
    }

    private void loadRepairList() {
        try {
            lstRepairs = new ListeObjects<Repair>(base.RepairDao.getRepairs());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadCustomerList() {
        try {
            lstCustomers = new ListeObjects<Customer>(base.CustomerDao.getCustomers());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void displayRepairList() {
        repModel.setRowCount(0);
        for (int i = 0; i < lstRepairs.size(); i++) {
            Repair r = (Repair) lstRepairs.get(i);
            repModel.insertRow(i, new Object[]{VENDOR_COUNTRY + VENDOR_ID + VENDOR_LOCATION + r.getRepairNo(), r.getOwner(), r.getDeviceSN(), statusList.get(r.getStatus()), r.getBeginDate(), r.getEndDate()});
        }
    }

    private void loadStatusList() {
        try {
            statusList = RepairDao.getStatusList();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
