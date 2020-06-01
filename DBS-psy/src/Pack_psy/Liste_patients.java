/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pack_psy;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lilian
 */
public class Liste_patients extends javax.swing.JFrame {
    Session psycho;
    DefaultTableModel model;
    
    public Liste_patients(Session psy, ArrayList<String> choisis) throws ClassNotFoundException, SQLException{
       this.psycho = psy;
       this.initComponents();
       this.lbl_psyCo.setText(psycho.getInfos());
       
       fillComponents(choisis);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tab_rdvDuJour = new javax.swing.JScrollPane();
        table_calendrier = new javax.swing.JTable();
        lbl_psyCo = new javax.swing.JLabel();
        btn_exit = new javax.swing.JButton();
        lbl_rechercher = new javax.swing.JLabel();
        txtF_recherche = new javax.swing.JTextField();
        btn_recherche = new javax.swing.JButton();
        btn_newPatient = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        table_calendrier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nom", "Prénom", "Mail"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
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
        }

        lbl_psyCo.setText("Psy connecté");

        btn_exit.setText(" X ");
        btn_exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_exitMouseClicked(evt);
            }
        });

        lbl_rechercher.setText("Rechercher un patient :");

        btn_recherche.setText("Rechercher");
        btn_recherche.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_rechercheMouseClicked(evt);
            }
        });

        btn_newPatient.setText("Nouveau Patient");
        btn_newPatient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_newPatientMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_newPatient)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_psyCo, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_exit)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(lbl_rechercher, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtF_recherche, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btn_recherche)
                .addContainerGap(92, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(tab_rdvDuJour, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_psyCo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_exit)
                    .addComponent(btn_newPatient))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 245, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_rechercher, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_recherche)
                    .addComponent(txtF_recherche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(46, 46, 46)
                    .addComponent(tab_rdvDuJour, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(64, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //get patient info from the db
    private void fillComponents(ArrayList<String> choisis) throws ClassNotFoundException, SQLException{
        // establish the connection
        Conn_dbs connex = new Conn_dbs(); 
        
        model = (DefaultTableModel)table_calendrier.getModel();
        try {
            String nom,prenom,email;
            String getPatients = "SELECT * FROM [Quick Patient] ORDER BY nom;";            

            ResultSet rs = connex.getStatement().executeQuery(getPatients);
            while(rs.next()){
                email = rs.getString("email");
                nom= rs.getString("nom");
                prenom= rs.getString("prenom");
                model.insertRow(model.getRowCount(), new Object[]{nom,prenom,email});
            }       
        } catch (SQLException ex) {
            Logger.getLogger(Psy_home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void btn_exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_exitMouseClicked
        this.dispose();
    }//GEN-LAST:event_btn_exitMouseClicked

    //opens appropriate patient info when we click on the row
    private void table_calendrierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_calendrierMouseClicked
        int row;
        row=table_calendrier.rowAtPoint(evt.getPoint());
        model = (DefaultTableModel)table_calendrier.getModel();
        
        try {
            Info_patient pf = new Info_patient(psycho, (String) model.getValueAt(row, model.findColumn("Mail")));
            pf.setVisible(true);
        } catch (ClassNotFoundException e){
            Logger.getLogger(Psy_home.class.getName()).log(Level.SEVERE, null, e);
        } catch (SQLException ex) {
            Logger.getLogger(Liste_patients.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_table_calendrierMouseClicked

    private void btn_rechercheMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_rechercheMouseClicked
        try {
            String nom, prenom, email;
            String patient = txtF_recherche.getText();
            Conn_dbs connex = new Conn_dbs();
            String myQuery = "SELECT * FROM [Quick Patient] WHERE nom LIKE '%" + patient + "%' OR prenom LIKE '%" + patient + "%' ORDER BY nom";
            ResultSet rs = connex.getStatement().executeQuery(myQuery);            
            
            // dont forget to erase the table before make the update
            DefaultTableModel dtm = (DefaultTableModel) table_calendrier.getModel();
            dtm.setRowCount(0);
        
            while(rs.next()){
                email = rs.getString("email");
                nom = rs.getString("nom");
                prenom = rs.getString("prenom");
                model.insertRow(model.getRowCount(), new Object[]{nom,prenom,email});
            }  
        } catch (SQLException ex) {
            Logger.getLogger(Psy_home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_rechercheMouseClicked

    private void btn_newPatientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_newPatientMouseClicked
        try {
            New_patients newPatient = new New_patients(psycho);
            newPatient.setVisible(true);
        } catch (ClassNotFoundException | SQLException e){
            Logger.getLogger(Psy_home.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_btn_newPatientMouseClicked

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_exit;
    private javax.swing.JButton btn_newPatient;
    private javax.swing.JButton btn_recherche;
    private javax.swing.JLabel lbl_psyCo;
    private javax.swing.JLabel lbl_rechercher;
    private javax.swing.JScrollPane tab_rdvDuJour;
    private javax.swing.JTable table_calendrier;
    private javax.swing.JTextField txtF_recherche;
    // End of variables declaration//GEN-END:variables
}
