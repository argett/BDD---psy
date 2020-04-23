package projet.mk2.Customer;

import projet.mk2.User.Customer;
import projet.mk2.User.User;
import projet.mk2.User.User_connection;

import java.awt.event.ActionListener;

public class Customer_home extends javax.swing.JFrame{
    
    public Customer_home(String id) {          
        initComponents();
        
        //set the name of the connected account
        var_user.setText(id);        
        Customer.user_connected = id;  
    }
                      
    private void initComponents() {
        label_customer = new javax.swing.JLabel();
        var_user = new javax.swing.JLabel();
        btn_deco = new javax.swing.JButton();
        btn_quit = new javax.swing.JButton();
        btn_history_payment = new javax.swing.JButton();
        btn_editProfile = new javax.swing.JButton();
        btn_askAppointment = new javax.swing.JButton();
        btn_seeAppointment = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setLayout(null);
        setSize(550,250);
        setLocationRelativeTo(null);
        
        label_customer.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label_customer.setForeground(new java.awt.Color(0, 153, 204));
        label_customer.setText("CUSTOMER :");
        label_customer.setBounds(10, 10, 90, 30);
        add(label_customer);

        var_user.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        var_user.setForeground(new java.awt.Color(0, 153, 204));
        var_user.setText("name");
        var_user.setBounds(100, 10, 100, 30);
        add(var_user);

        btn_deco.setBackground(new java.awt.Color(255, 255, 255));
        btn_deco.setForeground(new java.awt.Color(0, 153, 204));
        btn_deco.setText("Disconnection");
        btn_deco.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_decoActionPerformed(evt);
            }
        });
        btn_deco.setBounds(350, 10, 130, 42);
        add(btn_deco);

        btn_quit.setBackground(new java.awt.Color(255, 255, 255));
        btn_quit.setForeground(new java.awt.Color(0, 153, 204));
        btn_quit.setText("X");
        btn_quit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_quitActionPerformed(evt);
            }
        });
        btn_quit.setBounds(500, 10, 42, 42);
        add(btn_quit);

        btn_history_payment.setBackground(new java.awt.Color(0, 153, 204));
        btn_history_payment.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_history_payment.setForeground(new java.awt.Color(255, 255, 255));
        btn_history_payment.setText("History of payments");
        btn_history_payment.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_history_paymentActionPerformed(evt);
            }
        });
        btn_history_payment.setBounds(50, 150, 200, 35);
        add(btn_history_payment);

        btn_editProfile.setBackground(new java.awt.Color(0, 153, 204));
        btn_editProfile.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_editProfile.setForeground(new java.awt.Color(255, 255, 255));
        btn_editProfile.setText("Edit profile");
        btn_editProfile.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editProfileActionPerformed(evt);
            }
        });
        btn_editProfile.setBounds(50, 100, 200, 35);
        add(btn_editProfile);

        btn_askAppointment.setBackground(new java.awt.Color(0, 153, 204));
        btn_askAppointment.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_askAppointment.setForeground(new java.awt.Color(255, 255, 255));
        btn_askAppointment.setText("Ask appointment");
        btn_askAppointment.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_askAppointmentActionPerformed(evt);
            }
        });
        btn_askAppointment.setBounds(300, 100, 200, 35);
        add(btn_askAppointment);

        btn_seeAppointment.setBackground(new java.awt.Color(0, 153, 204));
        btn_seeAppointment.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_seeAppointment.setForeground(new java.awt.Color(255, 255, 255));
        btn_seeAppointment.setText("See my appointments");
        btn_seeAppointment.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_seeAppointmentActionPerformed(evt);
            }
        });
        btn_seeAppointment.setBounds(300, 150, 200, 35);
        add(btn_seeAppointment);        
    }                       

    private void btn_history_paymentActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        Customer_historyOfPayments HOP =  new Customer_historyOfPayments();
        HOP.setVisible(true);
        this.dispose();
    }                                                   

    private void btn_decoActionPerformed(java.awt.event.ActionEvent evt) {                                               
        User.save_data_cust();
        User.save_data_tech();
        User.save_data_mana();
        User_connection menu =  new User_connection();
        menu.setVisible(true);
        this.dispose();       
    }                                        

    private void btn_editProfileActionPerformed(java.awt.event.ActionEvent evt) {
        Customer_myAccount edit =  new Customer_myAccount();
        edit.setVisible(true);
        this.dispose();
    }                                               

    private void btn_quitActionPerformed(java.awt.event.ActionEvent evt) {                                         
        User.save_data_cust();
        User.save_data_mana();
        User.save_data_tech();
        System.exit(0);
    }                                        

    private void btn_askAppointmentActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        Customer_askAppt ask = new Customer_askAppt();
        ask.setVisible(true);
        this.dispose();
    }                                                  

    private void btn_seeAppointmentActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        Customer_seeAppt see = new Customer_seeAppt();
        see.setVisible(true);
        this.dispose();
    } 
                  
    private javax.swing.JButton btn_askAppointment;
    private javax.swing.JButton btn_deco;
    private javax.swing.JButton btn_editProfile;
    private javax.swing.JButton btn_history_payment;
    private javax.swing.JButton btn_quit;
    private javax.swing.JButton btn_seeAppointment;
    private javax.swing.JLabel label_customer;
    private javax.swing.JLabel var_user;               
}
