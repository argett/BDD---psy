/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pack_psy;

import java.util.Calendar;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *LILIAN FAVRE GARCIA
 *THEO DELETTRE
 */
public class Psy_home extends javax.swing.JFrame {
    private static Session psycho;
    DefaultTableModel model;

    public Psy_home(Session psy) throws ClassNotFoundException, SQLException {
        initComponents();
        psycho = psy;
        this.lbl_psyCo.setText(psycho.getInfos());
        
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat date = new SimpleDateFormat("yyyy-dd-MM");
        this.lbl_date.setText(date.format(calendar.getTime()));
        fillCalendar();

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
        btn_exit = new javax.swing.JButton();
        btn_deco = new javax.swing.JButton();
        btn_addConsultation = new javax.swing.JButton();

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
                "Heure", "Nom", "Prénom", "Type"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_calendrier.getTableHeader().setReorderingAllowed(false);
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

        btn_exit.setText(" X ");
        btn_exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_exitMouseClicked(evt);
            }
        });

        btn_deco.setText("Deconnecter");
        btn_deco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_decoMouseClicked(evt);
            }
        });

        btn_addConsultation.setText("Ajouter une consultation");
        btn_addConsultation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_addConsultationMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbl_psyCo, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_deco)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_exit)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btn_dateInf)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lbl_date, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btn_dateSupp))
                        .addComponent(tab_rdvDuJour, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_addConsultation)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_listePatients)))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_psyCo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_exit)
                    .addComponent(btn_deco))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_date, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_dateInf)
                    .addComponent(btn_dateSupp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tab_rdvDuJour, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_listePatients)
                    .addComponent(btn_addConsultation))
                .addGap(50, 50, 50))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_exitMouseClicked
        this.dispose();
    }//GEN-LAST:event_btn_exitMouseClicked

    private void btn_addConsultationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addConsultationMouseClicked
        try {
            New_consultation nc = new New_consultation(psycho);
            nc.setVisible(true);
        } catch (ClassNotFoundException | SQLException e){
            Logger.getLogger(Psy_home.class.getName()).log(Level.SEVERE, null, e);
        }

    }//GEN-LAST:event_btn_addConsultationMouseClicked

    private void btn_decoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_decoMouseClicked
        this.dispose();
        Connexion connect = new Connexion();
        connect.setVisible(true);
    }//GEN-LAST:event_btn_decoMouseClicked

    /**
     * @param args the command line arguments
     */
    
    private void fillCalendar() {
        // establish the connection
        Conn_dbs connex = new Conn_dbs(); 
        
        // dont forget to erase the table before make the update
        DefaultTableModel dtm = (DefaultTableModel) table_calendrier.getModel();
        dtm.setRowCount(0);
        
        //Save the dbs content into lists before to fill the table, otherwise the conn will be closed after 1 update
        String heure, nom, prenom, type;
        // to make the update
        model = (DefaultTableModel)table_calendrier.getModel();
        try {
            SimpleDateFormat date = new SimpleDateFormat("yyyy-dd-MM");
            
            // set the bounds of the calendar (select all rendez-vous between today and tomorrow)
            Calendar tomorrow = Calendar.getInstance();
            Date day = new SimpleDateFormat("yyyy-dd-MM").parse(lbl_date.getText()); // we take the day the psy is checking
            tomorrow.setTime(day);      // we transform the date into a calendar
            tomorrow.add(6, 1);         // we add 1 day into the calendar
            
            // make the queries
            String getRDVs = "SELECT Heure, Nom, Prénom, Type   FROM [DISTINCT RDV] WHERE Date >= '" + lbl_date.getText() + "' AND Date <= '" + date.format(tomorrow.getTime()) + "' ORDER BY Date;";
            
            // save the content into lists
            ResultSet rsH = connex.getStatement().executeQuery(getRDVs);

            while(rsH.next()){
                heure = rsH.getString("Heure");
                nom = rsH.getString("Nom");
                prenom = rsH.getString("Prénom");
                type = rsH.getString("Type");
                
                model.insertRow(model.getRowCount(), new Object[]{heure,nom,prenom,type});
            }
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(Psy_home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void btn_dateSuppMouseClicked(MouseEvent evt) {
       Calendar calendar = Calendar.getInstance();
       SimpleDateFormat date = new SimpleDateFormat("yyyy-dd-MM");

       try {
          calendar.setTime(date.parse(this.lbl_date.getText()));
       } catch (ParseException var5) {
          Logger.getLogger(Psy_home.class.getName()).log(Level.SEVERE, (String)null, var5);
       }
       
       // add one day to the one the psy is checking
       calendar.add(6, 1);
       this.lbl_date.setText(date.format(calendar.getTime()));
       fillCalendar();
    }

    private void btn_dateInfMouseClicked(MouseEvent evt) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat date = new SimpleDateFormat("yyyy-dd-MM");

        try {
           calendar.setTime(date.parse(this.lbl_date.getText()));
        } catch (ParseException var5) {
           Logger.getLogger(Psy_home.class.getName()).log(Level.SEVERE, (String)null, var5);
        }

        // remove one day to the one the psy is checking
        calendar.add(6, -1);
        this.lbl_date.setText(date.format(calendar.getTime()));
        fillCalendar();
    }

    private void table_calendrierMouseClicked(MouseEvent evt) {
        try {
            String ID = updateCalendar();
            View_consultation vf = new View_consultation(ID,psycho); 
            vf.setVisible(true);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Psy_home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private String updateCalendar(){
        SimpleDateFormat date = new SimpleDateFormat("yyyy-dd-MM");
        
        try {
            Conn_dbs connex = new Conn_dbs();
            
            String dateTime = date.format(date.parse(lbl_date.getText())) + " " + (String) table_calendrier.getModel().getValueAt(table_calendrier.getSelectedRow(), model.findColumn("Heure"));
            String myQuery = "SELECT consultationid FROM Consultations WHERE horaire = '"+ dateTime +"';";
            ResultSet rs = connex.getStatement().executeQuery(myQuery);
            while(rs.next()){
                return rs.getString(1);
            }
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(Psy_home.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    private void btn_listePatientsMouseClicked(MouseEvent evt) {
        try {
            Liste_patients liste = new Liste_patients(psycho, null);
            liste.setVisible(true);
        } catch (ClassNotFoundException | SQLException e){
            Logger.getLogger(Psy_home.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_addConsultation;
    private javax.swing.JButton btn_dateInf;
    private javax.swing.JButton btn_dateSupp;
    private javax.swing.JButton btn_deco;
    private javax.swing.JButton btn_exit;
    private javax.swing.JButton btn_listePatients;
    private javax.swing.JLabel lbl_date;
    private javax.swing.JLabel lbl_psyCo;
    private javax.swing.JScrollPane tab_rdvDuJour;
    private javax.swing.JTable table_calendrier;
    // End of variables declaration//GEN-END:variables
}
