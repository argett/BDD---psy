/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pack_psy;

import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;

/**
 *LILIAN FAVRE GARCIA
 *THEO DELETTRE
 */
public class Connexion extends javax.swing.JFrame {
     private static Session session;

    /**
     * Creates new form Connexion
     */
    public Connexion() {
        System.out.println("pseudo : Jdoe@fakemail.com");
        System.out.println("mail : 0000");
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

        lbl_connexion = new javax.swing.JLabel();
        lbl_pseudo = new javax.swing.JLabel();
        lbl_mdp = new javax.swing.JLabel();
        btn_inscrire = new javax.swing.JButton();
        btn_connecter = new javax.swing.JButton();
        insert_pseudo = new javax.swing.JTextField();
        insert_mdp = new javax.swing.JTextField();
        btn_exit = new javax.swing.JButton();
        lbl_error = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbl_connexion.setText("Connexion");

        lbl_pseudo.setText("Pseudo");

        lbl_mdp.setText("Mot de passe");

        btn_inscrire.setText("S'inscrire");
        btn_inscrire.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_inscrireMouseClicked(evt);
            }
        });

        btn_connecter.setText("Se connecter");
        btn_connecter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_connecterMouseClicked(evt);
            }
        });

        btn_exit.setText(" X ");
        btn_exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_exitMouseClicked(evt);
            }
        });

        lbl_error.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_connexion)
                .addGap(190, 190, 190)
                .addComponent(btn_exit)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(btn_inscrire, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_pseudo)
                            .addComponent(lbl_mdp))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(insert_pseudo)
                            .addComponent(insert_mdp, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_connecter, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(105, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(lbl_error, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_connexion)
                    .addComponent(btn_exit))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_pseudo)
                    .addComponent(insert_pseudo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_mdp)
                    .addComponent(insert_mdp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lbl_error)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_inscrire)
                    .addComponent(btn_connecter))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_exitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btn_exitMouseClicked

    private void btn_connecterMouseClicked(MouseEvent evt) {
        try {
            boolean connected = false;
            Conn_dbs connex = new Conn_dbs();
            String psy = "SELECT psyid FROM Compte_Psy WHERE psyid = '"+ insert_pseudo.getText() +"' AND mdp = '"+ insert_mdp.getText() +"'";
            String client = "SELECT email FROM Patients WHERE email = '"+ insert_pseudo.getText() +"' AND mdp = '"+ insert_mdp.getText() +"'";
            ResultSet infoPsy = connex.getStatement().executeQuery(psy);
            ResultSet infoPatient = connex.getStatement().executeQuery(client);

            while(infoPsy.next()){
                session = new Session("administrator", "Psychologue");
                Psy_home home;
                try {
                    home = new Psy_home(session);
                    home.setVisible(true);
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.dispose();
                return;
            }

            while(infoPatient.next()){
                session = new Session(infoPatient.getString(1), "Patient");
                Info_patient pat;
                try {
                    pat = new Info_patient(session, infoPatient.getString(1));
                    pat.setVisible(true);
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.dispose();
            }

            lbl_error.setText("Le pseudo ou le mot de passe est faux ou ne correspondent pas");

        } catch (SQLException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
        }
   }

   private void btn_inscrireMouseClicked(MouseEvent evt) {
      this.insert_pseudo.setText("toust1");
      this.insert_mdp.setText("toust2");
   }

   public static void main(String[] args) throws ClassNotFoundException, SQLException {        
        Conn_dbs connex = new Conn_dbs();        

        try {
           LookAndFeelInfo[] var10 = UIManager.getInstalledLookAndFeels();
           int var6 = var10.length;

           for(int var7 = 0; var7 < var6; ++var7) {
              LookAndFeelInfo info = var10[var7];
              if ("Nimbus".equals(info.getName())) {
                 UIManager.setLookAndFeel(info.getClassName());
                 break;
              }
           }
        } catch (InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException | ClassNotFoundException var9) {
           System.out.println("Problem :" + var9.getMessage());
        }

      (new Connexion()).setVisible(true);
   }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_connecter;
    private javax.swing.JButton btn_exit;
    private javax.swing.JButton btn_inscrire;
    private javax.swing.JTextField insert_mdp;
    private javax.swing.JTextField insert_pseudo;
    private javax.swing.JLabel lbl_connexion;
    private javax.swing.JLabel lbl_error;
    private javax.swing.JLabel lbl_mdp;
    private javax.swing.JLabel lbl_pseudo;
    // End of variables declaration//GEN-END:variables
}
