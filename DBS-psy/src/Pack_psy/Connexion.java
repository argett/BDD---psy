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
 *
 * @author lilian
 */
public class Connexion extends javax.swing.JFrame {
     private static Session session;

    /**
     * Creates new form Connexion
     */
    public Connexion() {
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
                        .addGap(92, 92, 92)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_pseudo)
                            .addComponent(lbl_mdp))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(insert_pseudo)
                            .addComponent(insert_mdp, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(btn_inscrire, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_connecter, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(105, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
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
      boolean connected = true;
      if (connected) {
        session = new Session(0, "conn.connect(BDD).getName(psi.get(id)) : connectÃ©");
        Psy_home home;
        try {
            home = new Psy_home(session);
            home.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
      }

      this.insert_pseudo.setText("test1");
      this.insert_mdp.setText("test2");
   }

   private void btn_inscrireMouseClicked(MouseEvent evt) {
      this.insert_pseudo.setText("toust1");
      this.insert_mdp.setText("toust2");
   }

   public static void main(String[] args) throws ClassNotFoundException, SQLException {        
        Conn_dbs connex = new Conn_dbs(); 
       
        String myQuery = "SELECT * FROM Anterieure";
        ResultSet rs = connex.getStatement().executeQuery(myQuery);

        while(rs.next()) {
           String s = rs.getString("patientid");
           System.out.println(s);
        }

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
    private javax.swing.JLabel lbl_mdp;
    private javax.swing.JLabel lbl_pseudo;
    // End of variables declaration//GEN-END:variables
}
