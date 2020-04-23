package projet.mk2.Manager;

import projet.mk2.User.Manager;
import java.awt.event.ActionListener;
import projet.mk2.User.User;

public class Manager_myAccount extends javax.swing.JFrame{    
    public Manager_myAccount() {       
        initComponents();   
        for(Manager manag : User.getManagers()){    
            if(manag.getLogin().equals(Manager.user_connected)){       
                //load all data in text fields  
                label_id.setText(Manager.user_connected);
                text_address.setText(manag.getAddress());
                text_mail.setText(manag.getEmail());
                text_password.setText(manag.getPassword());
                text_department.setText(manag.getDepartment());
                text_phone.setText(manag.getPhone());
                
                if(manag.getIDCN() != -1){
                    text_idcn.setText(String.valueOf(manag.getIDCN()));
                } else {                    
                    text_idcn.setText("");
                }
                break;
            }
        }
    }
                        
    private void initComponents() {
        label_ID    = new javax.swing.JLabel();
        label_id        = new javax.swing.JLabel();
        label_password  = new javax.swing.JLabel();
        label_phone     = new javax.swing.JLabel();
        label_address   = new javax.swing.JLabel();
        label_idcn      = new javax.swing.JLabel();
        btn_acceptModif = new javax.swing.JButton();
        label_mail      = new javax.swing.JLabel();
        label_department= new javax.swing.JLabel();
        text_department = new javax.swing.JTextField();
        text_password   = new javax.swing.JTextField();
        text_mail       = new javax.swing.JTextField();
        text_address    = new javax.swing.JTextField();
        text_idcn       = new javax.swing.JTextField();
        text_phone      = new javax.swing.JTextField();
        label_edit = new javax.swing.JLabel();
        btn_return = new javax.swing.JButton();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setLayout(null);
        setSize(600,500);
        setLocationRelativeTo(null);

        label_ID.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label_ID.setForeground(new java.awt.Color(0, 153, 204));
        label_ID.setText("ID :");
        label_ID.setBounds(50, 50, 30, 30);
        add(label_ID);
        
        label_id.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label_id.setForeground(new java.awt.Color(0, 153, 204));
        label_id.setText("---- id ----");
        label_id.setBounds(300, 50, 200, 30);
        add(label_id);

        label_password.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label_password.setForeground(new java.awt.Color(0, 153, 204));
        label_password.setText("Password :");
        label_password.setBounds(50, 100, 100, 30);
        add(label_password);
        
        text_password.setBackground(new java.awt.Color(255, 255, 255));
        text_password.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        text_password.setCaretColor(new java.awt.Color(0, 153, 204));
        text_password.setDisabledTextColor(new java.awt.Color(0, 153, 204));
        text_password.setBounds(300, 100, 200, 30);
        add(text_password);

        label_phone.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label_phone.setForeground(new java.awt.Color(0, 153, 204));
        label_phone.setText("Phone :");
        label_phone.setBounds(50, 150, 80, 30);
        add(label_phone);
        
        text_phone.setBackground(new java.awt.Color(255, 255, 255));
        text_phone.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        text_phone.setCaretColor(new java.awt.Color(0, 153, 204));
        text_phone.setDisabledTextColor(new java.awt.Color(0, 153, 204));
        text_phone.setBounds(300, 150, 200, 30);
        add(text_phone);

        label_address.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label_address.setForeground(new java.awt.Color(0, 153, 204));
        label_address.setText("Address :");
        label_address.setBounds(50, 200, 85, 30);
        add(label_address);
        
        text_address.setBackground(new java.awt.Color(255, 255, 255));
        text_address.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        text_address.setCaretColor(new java.awt.Color(0, 153, 204));
        text_address.setDisabledTextColor(new java.awt.Color(0, 153, 204));
        text_address.setBounds(300, 200, 200, 30);
        add(text_address);
        
        label_idcn.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label_idcn.setForeground(new java.awt.Color(0, 153, 204));
        label_idcn.setText("ID card number :");
        label_idcn.setBounds(50, 250, 150, 30);
        add(label_idcn);
        
        text_idcn.setBackground(new java.awt.Color(255, 255, 255));
        text_idcn.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        text_idcn.setCaretColor(new java.awt.Color(0, 153, 204));
        text_idcn.setDisabledTextColor(new java.awt.Color(0, 153, 204));
        text_idcn.setBounds(300, 250, 200, 30);
        add(text_idcn);

        label_edit.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label_edit.setForeground(new java.awt.Color(0, 153, 204));
        label_edit.setText("Edit my account");
        label_edit.setBounds(30, 0, 200, 50);
        add(label_edit);

        label_mail.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label_mail.setForeground(new java.awt.Color(0, 153, 204));
        label_mail.setText("Mail :");
        label_mail.setBounds(50, 300, 60, 30);
        add(label_mail);
        
        text_mail.setBackground(new java.awt.Color(255, 255, 255));
        text_mail.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        text_mail.setCaretColor(new java.awt.Color(0, 153, 204));
        text_mail.setDisabledTextColor(new java.awt.Color(0, 153, 204));
        text_mail.setBounds(300, 300, 200, 30);
        add(text_mail);
        
        label_department.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label_department.setForeground(new java.awt.Color(0, 153, 204));
        label_department.setText("Department :");
        label_department.setBounds(50, 350, 150, 30);
        add(label_department);
        
        text_department.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        text_department.setBounds(300, 350, 200, 30);
        add(text_department);

        btn_return.setBackground(new java.awt.Color(255, 255, 255));
        btn_return.setForeground(new java.awt.Color(0, 153, 204));
        btn_return.setText("return");
        btn_return.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_returnActionPerformed(evt);
            }
        });
        btn_return.setBounds(500, 10, 70, 30);
        add(btn_return);
        
        btn_acceptModif.setBackground(new java.awt.Color(0, 153, 204));
        btn_acceptModif.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btn_acceptModif.setForeground(new java.awt.Color(255, 255, 255));
        btn_acceptModif.setText("Accept modifications");
        btn_acceptModif.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_acceptModifActionPerformed(evt);
            }
        });
        btn_acceptModif.setBounds(200, 425, 300, 50);
        add(btn_acceptModif);
    }                     

    private void btn_acceptModifActionPerformed(java.awt.event.ActionEvent evt) {                                                
        for(Manager manag : User.getManagers()){    
            if(manag.getLogin().equals(Manager.user_connected)){         
                //load all data in text fields  
                if(text_idcn.getText().equals("")){
                    manag.setIDCN(-1);  
                } else { //check what has been entered
                    try { manag.setIDCN(Long.valueOf(text_idcn.getText()));
                    } catch (NumberFormatException ex) {
                        manag.setIDCN(-1);  
                    }
                }
                
                manag.setPhone(text_phone.getText());
                manag.setAddress(text_address.getText());
                manag.setEmail(text_mail.getText());
                manag.setPassword(text_password.getText());
                manag.setDepartment(text_department.getText());
                break;
            }
        }
        new Manager_home(Manager.user_connected).setVisible(true);
        this.dispose();
    }                                               

    private void btn_returnActionPerformed(java.awt.event.ActionEvent evt) {  
        new Manager_home(Manager.user_connected).setVisible(true);                                         
        this.dispose();
    }   
                 
    private javax.swing.JButton btn_acceptModif;
    private javax.swing.JButton btn_return;
    private javax.swing.JLabel label_ID;
    private javax.swing.JLabel label_address;
    private javax.swing.JLabel label_department;
    private javax.swing.JLabel label_edit;
    private javax.swing.JLabel label_id;
    private javax.swing.JLabel label_idcn;
    private javax.swing.JLabel label_mail;
    private javax.swing.JLabel label_password;
    private javax.swing.JLabel label_phone;
    private javax.swing.JTextField text_address;
    private javax.swing.JTextField text_department;
    private javax.swing.JTextField text_idcn;
    private javax.swing.JTextField text_mail;
    private javax.swing.JTextField text_password;
    private javax.swing.JTextField text_phone;        
}
