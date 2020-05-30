/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pack_psy;

import java.util.Calendar;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lilian
 */
public class Psy_home extends javax.swing.JFrame {
    private static Session psycho;
    DefaultTableModel model;

    public Psy_home(Session psy) throws ClassNotFoundException, SQLException {
        initComponents();
        psycho = psy;
        this.lbl_psyCo.setText("conn.connect(BDD).getName(psi.get(id)) : connectÃ©");
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        this.lbl_date.setText(date.format(calendar.getTime()));
        fillComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_psyCo = new javax.swing.JLabel();
        btn_listePatients = new javax.swing.JButton();
        tab_rdvDuJour = new javax.swing.JScrollPane();
        table_calendrier = new javax.swing.JTable();
        lbl_date = new javax.swing.JLabel();
        btn_dateSupp = new javax.swing.JButton();
        btn_dateInf = new javax.swing.JButton();
        lbl_rechercher = new javax.swing.JLabel();
        txtF_recherche = new javax.swing.JTextField();
        btn_recherche = new javax.swing.JButton();
        btn_exit = new javax.swing.JButton();
        btn_deco = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        lbl_psyCo.setText("Psy connecté");

        btn_listePatients.setText("Voir tous les patients");
        btn_listePatients.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_listePatientsMouseClicked(evt);
            }
        });

        table_calendrier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Horaire", "Nom", "Prénom", "Dernière séance", "Fiche complète"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_calendrier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_calendrierMouseClicked(evt);
            }
        });
        tab_rdvDuJour.setViewportView(table_calendrier);
        if (table_calendrier.getColumnModel().getColumnCount() > 0) {
            table_calendrier.getColumnModel().getColumn(0).setResizable(false);
            table_calendrier.getColumnModel().getColumn(1).setResizable(false);
            table_calendrier.getColumnModel().getColumn(2).setResizable(false);
            table_calendrier.getColumnModel().getColumn(3).setResizable(false);
            table_calendrier.getColumnModel().getColumn(4).setResizable(false);
        }

        lbl_date.setText("Date");

        btn_dateSupp.setText(">");
        btn_dateSupp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_dateSuppMouseClicked(evt);
            }
        });

        btn_dateInf.setText("<");
        btn_dateInf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_dateInfMouseClicked(evt);
            }
        });

        lbl_rechercher.setText("Rechercher un patient :");

        btn_recherche.setText("Rechercher");

        btn_exit.setText(" X ");
        btn_exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_exitMouseClicked(evt);
            }
        });

        btn_deco.setText("Deconnecter");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbl_psyCo, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_deco)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_exit)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lbl_rechercher)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtF_recherche, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btn_recherche))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btn_dateInf)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lbl_date, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btn_dateSupp))
                        .addComponent(tab_rdvDuJour, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_listePatients))
                .addContainerGap(112, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_psyCo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_exit)
                    .addComponent(btn_deco))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_date, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_dateInf)
                    .addComponent(btn_dateSupp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tab_rdvDuJour, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_rechercher)
                    .addComponent(txtF_recherche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_recherche))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_listePatients)
                .addGap(50, 50, 50))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_exitMouseClicked
        this.dispose();
    }//GEN-LAST:event_btn_exitMouseClicked

    /**
     * @param args the command line arguments
     */
    
    private void fillComponents() throws ClassNotFoundException, SQLException{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:54055;databaseName=dbs-psy;integratedSecurity=true");
        Statement stmt = con.createStatement();
        
        ArrayList<String> horaires = new ArrayList<>();
        ArrayList<String> noms = new ArrayList<>();
        ArrayList<String> prenoms = new ArrayList<>();
        ArrayList<String> professions = new ArrayList<>();
        
        
        model = (DefaultTableModel)table_calendrier.getModel();
        try {
            stmt = con.createStatement();
            String getHoraire = "SELECT horaire FROM Consultations";
            String getNoms = "SELECT nom FROM Patients";
            String getPrenoms = "SELECT prenom FROM Patients";
            String getSeance = "SELECT profession FROM Proffessions";
            
            ResultSet rsH = stmt.executeQuery(getHoraire);
            while(rsH.next()){
               horaires.add(rsH.getString("horaire"));
            }
            
            ResultSet rsN = stmt.executeQuery(getNoms);            
            while(rsN.next()){
               noms.add(rsN.getString("nom"));
            }
            
            ResultSet rsP = stmt.executeQuery(getPrenoms);           
            while(rsP.next()){
               prenoms.add(rsP.getString("prenom"));
            }
            
            ResultSet rsS = stmt.executeQuery(getSeance);            
            while(rsS.next()){
               professions.add(rsS.getString("profession"));
            }
            
            for(int i=0; i<horaires.size(); i++){
                model.insertRow(model.getRowCount(), new Object[]{horaires.get(i),noms.get(i),prenoms.get(i),professions.get(i),"click"});                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Psy_home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void btn_dateSuppMouseClicked(MouseEvent evt) {
       Calendar calendar = Calendar.getInstance();
       SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");

       try {
          calendar.setTime(date.parse(this.lbl_date.getText()));
       } catch (ParseException var5) {
          Logger.getLogger(Psy_home.class.getName()).log(Level.SEVERE, (String)null, var5);
       }

       calendar.add(6, 1);
       this.lbl_date.setText(date.format(calendar.getTime()));
    }

    private void btn_dateInfMouseClicked(MouseEvent evt) {
       Calendar calendar = Calendar.getInstance();
       SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");

       try {
          calendar.setTime(date.parse(this.lbl_date.getText()));
       } catch (ParseException var5) {
          Logger.getLogger(Psy_home.class.getName()).log(Level.SEVERE, (String)null, var5);
       }

       calendar.add(6, -1);
       this.lbl_date.setText(date.format(calendar.getTime()));
    }

    private void table_calendrierMouseClicked(MouseEvent evt) {
       Patient_fiche pf = new Patient_fiche(psycho);
       pf.setVisible(true);
    }

    private void btn_listePatientsMouseClicked(MouseEvent evt) {
        try {
            Liste_patients liste = new Liste_patients(psycho);
            liste.setVisible(true);
        } catch (ClassNotFoundException | SQLException e){
            Logger.getLogger(Psy_home.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void mouseClicked(MouseEvent e) {
       int x = e.getX();
       int y = e.getY();
       System.out.println(x + "," + y);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_dateInf;
    private javax.swing.JButton btn_dateSupp;
    private javax.swing.JButton btn_deco;
    private javax.swing.JButton btn_exit;
    private javax.swing.JButton btn_listePatients;
    private javax.swing.JButton btn_recherche;
    private javax.swing.JLabel lbl_date;
    private javax.swing.JLabel lbl_psyCo;
    private javax.swing.JLabel lbl_rechercher;
    private javax.swing.JScrollPane tab_rdvDuJour;
    private javax.swing.JTable table_calendrier;
    private javax.swing.JTextField txtF_recherche;
    // End of variables declaration//GEN-END:variables
}
