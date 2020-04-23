package projet.mk2.Manager;

import projet.mk2.User.Manager;
import projet.mk2.User.User;
import projet.mk2.User.User_connection;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Manager_home extends javax.swing.JFrame{
    
    public Manager_home(String id) {          
        initComponents();
        
        //set the name of the connected account
        var_user.setText(id);        
        Manager.user_connected = id; 
    }
                      
    private void initComponents() {
        label_manager = new javax.swing.JLabel();
        var_user      = new javax.swing.JLabel();
        label_managment= new javax.swing.JLabel();
        label_price   = new javax.swing.JLabel();
        label_payments= new javax.swing.JLabel();
        btn_deco      = new javax.swing.JButton();
        btn_quit      = new javax.swing.JButton();
        btn_adduser   = new javax.swing.JButton();
        btn_editUsers = new javax.swing.JButton();
        btn_editPrice = new javax.swing.JButton();
        btn_createAppt= new javax.swing.JButton();
        btn_assignAppoint = new javax.swing.JButton();
        label_appointement = new javax.swing.JLabel();
        btn_myAccount = new javax.swing.JButton();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setLayout(null);
        setSize(600,400);
        setLocationRelativeTo(null);
        

        var_user.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        var_user.setForeground(new java.awt.Color(0, 153, 204));
        var_user.setText("name");
        var_user.setBounds(110, 20, 150, 30);
        add(var_user);

        label_manager.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label_manager.setForeground(new java.awt.Color(0, 153, 204));
        label_manager.setText("MANAGER :");
        label_manager.setBounds(20, 20, 90, 30);
        add(label_manager);

        label_managment.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label_managment.setForeground(new java.awt.Color(0, 153, 204));
        label_managment.setText("MANAGEMENT ");
        label_managment.setBounds(50, 100, 150, 30);
        add(label_managment);

        label_price.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label_price.setForeground(new java.awt.Color(0, 153, 204));
        label_price.setText("PRICE ");
        label_price.setBounds(270, 100, 70, 30);
        add(label_price);

        label_appointement.setFont(new Font("Dialog", 1, 18)); // NOI18N
        label_appointement.setForeground(new java.awt.Color(0, 153, 204));
        label_appointement.setText("APPOINTEMENT");
        label_appointement.setBounds(410, 100, 150, 30);
        add(label_appointement);

        label_payments.setFont(new Font("Dialog", 1, 18)); // NOI18N
        label_payments.setForeground(new java.awt.Color(0, 153, 204));
        label_payments.setText("Total receips = RM"+Manager.getPayments_collected());
        label_payments.setBounds(200, 250, 250, 30);
        add(label_payments);
        
        btn_myAccount.setBackground(new java.awt.Color(0, 153, 204));
        btn_myAccount.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_myAccount.setForeground(new java.awt.Color(255, 255, 255));
        btn_myAccount.setText("My account");
        btn_myAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_myAccountActionPerformed(evt);
            }
        });
        btn_myAccount.setBounds(350, 320, 150, 35);
        add(btn_myAccount);

        btn_deco.setBackground(new java.awt.Color(255, 255, 255));
        btn_deco.setForeground(new java.awt.Color(0, 153, 204));
        btn_deco.setText("Disconnection");
        btn_deco.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btn_decoActionPerformed(evt);
            }
        });
        btn_deco.setBounds(400, 10, 130, 42);
        add(btn_deco);

        btn_quit.setBackground(new java.awt.Color(255, 255, 255));
        btn_quit.setFont(new java.awt.Font("Dialog", 3, 12)); 
        btn_quit.setForeground(new java.awt.Color(0, 153, 204));
        btn_quit.setText("X");
        btn_quit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btn_quitActionPerformed(evt);
            }
        });
        btn_quit.setBounds(550, 10, 42, 42);
        add(btn_quit);

        btn_adduser.setBackground(new java.awt.Color(0, 153, 204));
        btn_adduser.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_adduser.setForeground(new java.awt.Color(255, 255, 255));
        btn_adduser.setText("Add new user");
        btn_adduser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btn_adduserActionPerformed(evt);
            }
        });
        btn_adduser.setBounds(50, 180, 140, 35);
        add(btn_adduser);

        btn_editUsers.setBackground(new java.awt.Color(0, 153, 204));
        btn_editUsers.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_editUsers.setForeground(new java.awt.Color(255, 255, 255));
        btn_editUsers.setText("Edit users");
        btn_editUsers.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btn_editUsersActionPerformed(evt);
            }
        });
        btn_editUsers.setBounds(50,250, 140, 35);
        add(btn_editUsers);

        btn_editPrice.setBackground(new java.awt.Color(0, 153, 204));
        btn_editPrice.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_editPrice.setForeground(new java.awt.Color(255, 255, 255));
        btn_editPrice.setText("Edit prices");
        btn_editPrice.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btn_editPriceActionPerformed(evt);
            }
        });
        btn_editPrice.setBounds(250, 180, 110, 35);
        add(btn_editPrice);

        btn_assignAppoint.setBackground(new java.awt.Color(0, 153, 204));
        btn_assignAppoint.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_assignAppoint.setForeground(new java.awt.Color(255, 255, 255));
        btn_assignAppoint.setText("Assign ");
        btn_assignAppoint.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btn_assignAppointActionPerformed(evt);
            }
        });
        btn_assignAppoint.setBounds(420, 180, 110, 35);
        add(btn_assignAppoint);

        btn_createAppt.setBackground(new java.awt.Color(0, 153, 204));
        btn_createAppt.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_createAppt.setForeground(new java.awt.Color(255, 255, 255));
        btn_createAppt.setText("Create ");
        btn_createAppt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btn_createApptActionPerformed(evt);
            }
        });
        btn_createAppt.setBounds(420, 250, 110, 35);
        add(btn_createAppt);
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

    private void btn_assignAppointActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        Manager_assignAppmt assign =  new Manager_assignAppmt();
        assign.setVisible(true);
        this.dispose();
    }                                        

    private void btn_createApptActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        Manager_createAppt create =  new Manager_createAppt();
        create.setVisible(true);
        this.dispose();
    }                                               

    private void btn_editUsersActionPerformed(java.awt.event.ActionEvent evt) {                                              
        Manager_editUser edit =  new Manager_editUser();
        edit.setVisible(true);
        this.dispose();
    }                                             

    private void btn_adduserActionPerformed(java.awt.event.ActionEvent evt) {                                            
        Manager_addUser add =  new Manager_addUser();
        add.setVisible(true);
        this.dispose();
    }                                           

    private void btn_editPriceActionPerformed(java.awt.event.ActionEvent evt) {                                              
        Manager_editPrice price =  new Manager_editPrice();
        price.setVisible(true);
        this.dispose();
    }                                             

    private void btn_myAccountActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        Manager_myAccount account =  new Manager_myAccount();
        account.setVisible(true);
        this.dispose();
    }                                                  
                   
    private javax.swing.JButton btn_adduser;
    private javax.swing.JButton btn_assignAppoint;
    private javax.swing.JButton btn_myAccount;
    private javax.swing.JButton btn_deco;
    private javax.swing.JButton btn_editPrice;
    private javax.swing.JButton btn_editUsers;
    private javax.swing.JButton btn_createAppt;
    private javax.swing.JButton btn_quit;
    private javax.swing.JLabel label_appointement;
    private javax.swing.JLabel label_manager;
    private javax.swing.JLabel label_managment;
    private javax.swing.JLabel label_price;
    private javax.swing.JLabel label_payments;
    private javax.swing.JLabel var_user;            
}
