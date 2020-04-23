package projet.mk2.Technician;

import projet.mk2.User.Technician;
import projet.mk2.User.User;
import projet.mk2.User.User_connection;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Technician_home extends javax.swing.JFrame{
    
    public Technician_home(String id) {          
        initComponents();
        
        //set the name of the connected account
        var_user.setText(id);        
        Technician.user_connected = id;
    }
                      
    private void initComponents() {
        label_technician = new javax.swing.JLabel();
        var_user = new javax.swing.JLabel();
        btn_deco = new javax.swing.JButton();
        btn_quit = new javax.swing.JButton();
        btn_myGrades = new javax.swing.JButton();
        btn_myAppointment = new javax.swing.JButton();
        btn_myGrades1 = new javax.swing.JButton();
        btn_assignAppoint1 = new javax.swing.JButton();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setLayout(null);
        setSize(550,250);
        setLocationRelativeTo(null);

        label_technician.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label_technician.setForeground(new java.awt.Color(0, 153, 204));
        label_technician.setText("TECHNICIAN :");
        label_technician.setBounds(10, 10, 100, 30);
        add(label_technician);

        var_user.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        var_user.setForeground(new java.awt.Color(0, 153, 204));
        var_user.setText("name");
        var_user.setBounds(150, 10, 100, 30);
        add(var_user);

        btn_deco.setBackground(new java.awt.Color(255, 255, 255));
        btn_deco.setForeground(new java.awt.Color(0, 153, 204));
        btn_deco.setText("Disconnection");
        btn_deco.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btn_decoActionPerformed(evt);
            }
        });
        btn_deco.setBounds(350, 10, 130, 42);
        add(btn_deco);

        btn_quit.setBackground(new java.awt.Color(255, 255, 255));
        btn_quit.setForeground(new java.awt.Color(0, 153, 204));
        btn_quit.setText("X");
        btn_quit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btn_quitActionPerformed(evt);
            }
        });
        btn_quit.setBounds(500, 10, 42, 42);
        add(btn_quit);
        
        btn_myGrades.setBackground(new java.awt.Color(0, 153, 204));
        btn_myGrades.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_myGrades.setForeground(new java.awt.Color(255, 255, 255));
        btn_myGrades.setText("History of appointments");
        btn_myGrades.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btn_myGradesActionPerformed(evt);
            }
        });
        btn_myGrades.setBounds(40, 100, 200, 35);
        add(btn_myGrades);

        btn_myAppointment.setBackground(new java.awt.Color(0, 153, 204));
        btn_myAppointment.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_myAppointment.setForeground(new java.awt.Color(255, 255, 255));
            btn_myAppointment.setText("Currents appointments");
        btn_myAppointment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btn_myAppointmentActionPerformed(evt);
            }
        });
        btn_myAppointment.setBounds(40, 150, 200, 35);
        add(btn_myAppointment);

        btn_myGrades1.setBackground(new java.awt.Color(0, 153, 204));
        btn_myGrades1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_myGrades1.setForeground(new java.awt.Color(255, 255, 255));
        btn_myGrades1.setText("My comments");
        btn_myGrades1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btn_myGrades1ActionPerformed(evt);
            }
        });
        btn_myGrades1.setBounds(300, 100, 200, 35);
        add(btn_myGrades1);

        btn_assignAppoint1.setBackground(new java.awt.Color(0, 153, 204));
        btn_assignAppoint1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_assignAppoint1.setForeground(new java.awt.Color(255, 255, 255));
        btn_assignAppoint1.setText("My account");
        btn_assignAppoint1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btn_assignAppoint1ActionPerformed(evt);
            }
        });
        btn_assignAppoint1.setBounds(300, 150, 200, 35);
        add(btn_assignAppoint1);
    }                      

    private void btn_decoActionPerformed(java.awt.event.ActionEvent evt) {                                         
        User.save_data_cust();
        User.save_data_mana();
        User.save_data_tech();
        
        User_connection menu =  new User_connection();
        menu.setVisible(true);
        this.dispose();
    }                                        

    private void btn_quitActionPerformed(java.awt.event.ActionEvent evt) {                                         
        User.save_data_cust();
        User.save_data_mana();
        User.save_data_tech();
        System.exit(0);
    }                                        

    private void btn_myGradesActionPerformed(java.awt.event.ActionEvent evt) {                                             
        Technician_historyAppt appt =  new Technician_historyAppt();
        appt.setVisible(true);
        this.dispose();
    }                                            

    private void btn_myAppointmentActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        Technician_currAppt curr =  new Technician_currAppt();
        curr.setVisible(true);
        this.dispose();
    }                                                 

    private void btn_myGrades1ActionPerformed(java.awt.event.ActionEvent evt) {                                              
        Technician_comments comm =  new Technician_comments();
        comm.setVisible(true);
        this.dispose();
    }                                             

    private void btn_assignAppoint1ActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        Technician_myAccount account =  new Technician_myAccount();
        account.setVisible(true);
        this.dispose();
    } 
                  
    private javax.swing.JButton btn_assignAppoint1;
    private javax.swing.JButton btn_deco;
    private javax.swing.JButton btn_myAppointment;
    private javax.swing.JButton btn_myGrades;
    private javax.swing.JButton btn_myGrades1;
    private javax.swing.JButton btn_quit;
    private javax.swing.JLabel label_technician;
    private javax.swing.JLabel var_user;               
}
