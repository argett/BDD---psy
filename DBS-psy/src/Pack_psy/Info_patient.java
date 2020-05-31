/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pack_psy;

import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


public class Info_patient extends javax.swing.JFrame {
    Session psycho;
    DefaultTableModel model;
    String inMail;

    public Info_patient(Session psy, String pEmail) throws ClassNotFoundException, SQLException{
        this.psycho = psy;
        this.initComponents();
        this.lbl_psyCo.setText(psycho.getInfos());
        
        inMail = pEmail;
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
        btn_quit = new javax.swing.JButton();
        lbl_nom = new javax.swing.JLabel();
        lbl_prenom = new javax.swing.JLabel();
        lbl_dateNaissance = new javax.swing.JLabel();
        lbl_decouverte = new javax.swing.JLabel();
        lbl_inNom = new javax.swing.JLabel();
        lbl_inPrenom = new javax.swing.JLabel();
        lbl_inDateNaissance = new javax.swing.JLabel();
        lbl_Sexe = new javax.swing.JLabel();
        lbl_inSexe = new javax.swing.JLabel();
        lbl_inDecouverte = new javax.swing.JLabel();
        lbl_ProfActuelle = new javax.swing.JLabel();
        lbl_inProfActuelle = new javax.swing.JLabel();
        lbl_anterieure = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_anterieure = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_rdvPasse = new javax.swing.JTable();
        lbl_rdvPasse = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_rdvFutur = new javax.swing.JTable();
        lbl_rdvFutur = new javax.swing.JLabel();
        lbl_oldProfession = new javax.swing.JLabel();
        inProfession = new javax.swing.JTextField();
        btn_ajouterProf = new javax.swing.JButton();
        lbl_email = new javax.swing.JLabel();
        lbl_inEmail = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbl_psyCo.setText("Psy connecté");

        btn_quit.setText("X");
        btn_quit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_quitMouseClicked(evt);
            }
        });

        lbl_nom.setText("Nom :");

        lbl_prenom.setText("Prénom :");

        lbl_dateNaissance.setText("Date de Naissance :");

        lbl_decouverte.setText("Comment me connait-il ?");

        lbl_inNom.setText("inNom");

        lbl_inPrenom.setText("inPrenom");

        lbl_inDateNaissance.setText("inDateNaissance");

        lbl_Sexe.setText("Sexe :");

        lbl_inSexe.setText("inSexe");

        lbl_inDecouverte.setText("inDecouverte");

        lbl_ProfActuelle.setText("Profession Actuelle: ");

        lbl_inProfActuelle.setText("inProfActuelle");

        lbl_anterieure.setText("Professions Anterieures: ");

        table_anterieure.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Profession"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table_anterieure);
        if (table_anterieure.getColumnModel().getColumnCount() > 0) {
            table_anterieure.getColumnModel().getColumn(0).setResizable(false);
        }

        table_rdvPasse.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Horaire", "Type", "Anxiete"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
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
        jScrollPane2.setViewportView(table_rdvPasse);
        if (table_rdvPasse.getColumnModel().getColumnCount() > 0) {
            table_rdvPasse.getColumnModel().getColumn(0).setResizable(false);
            table_rdvPasse.getColumnModel().getColumn(1).setResizable(false);
            table_rdvPasse.getColumnModel().getColumn(2).setResizable(false);
            table_rdvPasse.getColumnModel().getColumn(3).setResizable(false);
        }

        lbl_rdvPasse.setText("Rendez-Vous Passés:");

        table_rdvFutur.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Horaire", "Type", "Anxiete"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
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
        jScrollPane3.setViewportView(table_rdvFutur);
        if (table_rdvFutur.getColumnModel().getColumnCount() > 0) {
            table_rdvFutur.getColumnModel().getColumn(0).setResizable(false);
            table_rdvFutur.getColumnModel().getColumn(1).setResizable(false);
            table_rdvFutur.getColumnModel().getColumn(2).setResizable(false);
            table_rdvFutur.getColumnModel().getColumn(3).setResizable(false);
        }

        lbl_rdvFutur.setText("Rendez-Vous Futurs:");

        lbl_oldProfession.setText("Ancienne Profession:");

        inProfession.setText("Profession");

        btn_ajouterProf.setText("Ajouter");
        btn_ajouterProf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ajouterProfMouseClicked(evt);
            }
        });

        lbl_email.setText("E-mail :");

        lbl_inEmail.setText("inEmail");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_rdvPasse)
                            .addComponent(lbl_rdvFutur))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_nom)
                                    .addComponent(lbl_prenom)
                                    .addComponent(lbl_email)
                                    .addComponent(lbl_dateNaissance)
                                    .addComponent(lbl_Sexe)
                                    .addComponent(lbl_decouverte))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(lbl_psyCo, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbl_inSexe)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbl_anterieure)
                                            .addComponent(lbl_oldProfession))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btn_ajouterProf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                            .addComponent(inProfession, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbl_inPrenom)
                                            .addComponent(lbl_inNom)
                                            .addComponent(lbl_inDateNaissance)
                                            .addComponent(lbl_inEmail)
                                            .addComponent(lbl_inDecouverte))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                                        .addComponent(lbl_ProfActuelle)
                                        .addGap(31, 31, 31)
                                        .addComponent(lbl_inProfActuelle))))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_quit)
                        .addGap(15, 15, 15))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_rdvPasse)
                        .addGap(12, 12, 12))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_psyCo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_quit))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_ProfActuelle)
                            .addComponent(lbl_inProfActuelle)
                            .addComponent(lbl_nom)
                            .addComponent(lbl_inNom))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_oldProfession)
                            .addComponent(inProfession, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_prenom)
                            .addComponent(lbl_inPrenom))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_ajouterProf)
                            .addComponent(lbl_email)
                            .addComponent(lbl_inEmail))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_dateNaissance)
                            .addComponent(lbl_inDateNaissance))
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbl_anterieure)
                                    .addComponent(lbl_Sexe)
                                    .addComponent(lbl_inSexe))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbl_decouverte)
                                    .addComponent(lbl_inDecouverte))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_rdvFutur)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ajouterProfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ajouterProfMouseClicked
        Conn_dbs connex = new Conn_dbs(); 
        String oldProf = inProfession.getText();
        
        if(!oldProf.isEmpty() && !oldProf.equals("Profession") && oldProf.length()<30)
        {
            try{
                Statement stmt = connex.getStatement();
                String archiveProf = "INSERT INTO Anterieure (patientid, profession) VALUES ("+inMail+",'"+oldProf+"')";
                
                ResultSet rs = stmt.executeQuery("SELECT * FROM Professions WHERE profession = '" + oldProf + "';");
                if(!rs.next())
                {
                    stmt.executeUpdate("INSERT INTO Professions (profession) VALUES ('" + oldProf + "');");
                }
                if(stmt.executeUpdate(archiveProf)!=0)
                {
                        model = (DefaultTableModel)table_anterieure.getModel();
                        model.insertRow(model.getRowCount(), new Object[]{oldProf});
                }
            } catch (SQLException ex) {
            Logger.getLogger(Psy_home.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btn_ajouterProfMouseClicked

private void fillComponents() throws ClassNotFoundException, SQLException{
        // establish the connection
        Conn_dbs connex = new Conn_dbs(); 
        SimpleDateFormat ydmFormat = new SimpleDateFormat("yyyy-dd-MM HH:mm:ss");
        
        try {
            String getPatients = "SELECT * FROM Patients WHERE email = '" + inMail + "';";
            
            ResultSet rs = connex.getStatement().executeQuery(getPatients);
            rs.next();
            lbl_inNom.setText(rs.getString("nom"));
            lbl_inPrenom.setText(rs.getString("prenom"));
            lbl_inEmail.setText(rs.getString("email"));
            lbl_inDateNaissance.setText(rs.getString("datenaissance"));
            lbl_inSexe.setText(rs.getString("sexe"));
            lbl_inProfActuelle.setText(rs.getString("profession"));
            lbl_inDecouverte.setText(rs.getString("connupar"));
            
            String getAnterieures = "SELECT profession FROM Anterieure WHERE email = '" + inMail + "';";
            
            rs = connex.getStatement().executeQuery(getAnterieures);
            
            model = (DefaultTableModel)table_anterieure.getModel();
            while(rs.next()){
                model.insertRow(model.getRowCount(), new Object[]{rs.getString("profession")});
            }
            
            long millis=System.currentTimeMillis();  
            java.sql.Timestamp date= new java.sql.Timestamp(millis);
            
            String getRDVPasse= "SELECT date, horaire, type, anxiete FROM [Quick RDV]"
                    + "WHERE email = '"+ inMail +"' AND exact_time< '" + ydmFormat.format(date)
                    + "' ORDER BY exact_time;";
            rs = connex.getStatement().executeQuery(getRDVPasse);
            
            model = (DefaultTableModel)table_rdvPasse.getModel();
            while(rs.next()){
                model.insertRow(model.getRowCount(), new Object[]{rs.getString("date"),rs.getString("horaire"),rs.getString("type"),rs.getString("anxiete")});
            }
            
            String getRDVFutur= "SELECT date, horaire, type, anxiete FROM [Quick RDV]"
                    + "WHERE email = '"+ inMail +"' AND exact_time> '" + ydmFormat.format(date)
                    + "' ORDER BY exact_time;";
            rs = connex.getStatement().executeQuery(getRDVFutur);

            model = (DefaultTableModel)table_rdvFutur.getModel();
            while(rs.next()){
                model.insertRow(model.getRowCount(), new Object[]{rs.getString("date"),rs.getString("horaire"),rs.getString("type"),rs.getString("anxiete")});
            }  
        } catch (SQLException ex) {
            Logger.getLogger(Psy_home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   private void btn_quitMouseClicked(MouseEvent evt) {
      this.dispose();
   }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ajouterProf;
    private javax.swing.JButton btn_quit;
    private javax.swing.JTextField inProfession;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_ProfActuelle;
    private javax.swing.JLabel lbl_Sexe;
    private javax.swing.JLabel lbl_anterieure;
    private javax.swing.JLabel lbl_dateNaissance;
    private javax.swing.JLabel lbl_decouverte;
    private javax.swing.JLabel lbl_email;
    private javax.swing.JLabel lbl_inDateNaissance;
    private javax.swing.JLabel lbl_inDecouverte;
    private javax.swing.JLabel lbl_inEmail;
    private javax.swing.JLabel lbl_inNom;
    private javax.swing.JLabel lbl_inPrenom;
    private javax.swing.JLabel lbl_inProfActuelle;
    private javax.swing.JLabel lbl_inSexe;
    private javax.swing.JLabel lbl_nom;
    private javax.swing.JLabel lbl_oldProfession;
    private javax.swing.JLabel lbl_prenom;
    private javax.swing.JLabel lbl_psyCo;
    private javax.swing.JLabel lbl_rdvFutur;
    private javax.swing.JLabel lbl_rdvPasse;
    private javax.swing.JTable table_anterieure;
    private javax.swing.JTable table_rdvFutur;
    private javax.swing.JTable table_rdvPasse;
    // End of variables declaration//GEN-END:variables
}