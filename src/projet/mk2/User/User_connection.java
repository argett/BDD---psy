package projet.mk2.User;

import projet.mk2.Technician.Technician_home;
import projet.mk2.Manager.Manager_home;
import projet.mk2.Customer.Customer_home;

import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class User_connection extends JFrame {
                                                                        
    public User_connection() {
        initComponents();
        
        //load all users
        User.load_customer();
        User.load_manager();
        User.load_technician(); 
        
        //print in console to see if all is correct
        for(int i= 0; i<User.getCustomers().size(); i++){           
            Customer.printCustomers(User.getCustomers().get(i));
        }
        for(int i= 0; i<User.getManagers().size(); i++){           
            Manager.printManagers(User.getManagers().get(i));
        }
        for(int i= 0; i<User.getTechnicians().size(); i++){           
            Technician.printTechnicians(User.getTechnicians().get(i));
        }
    }
    
    private void initComponents() {
        label_login = new javax.swing.JLabel();
        btn_quit = new javax.swing.JButton();
        insert_pseudo = new javax.swing.JTextField();
        label_username = new javax.swing.JLabel();
        insert_password = new javax.swing.JPasswordField();
        label_password = new javax.swing.JLabel();
        btn_accept = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setLayout(null);
        setSize(500,300);
        setLocationRelativeTo(null);

        label_login.setBackground(new java.awt.Color(255, 51, 0));
        label_login.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        label_login.setForeground(new java.awt.Color(0, 153, 204));
        label_login.setText("LOGIN");
        label_login.setBounds(175, 10, 120, 50);
        add(label_login);

        btn_quit.setBackground(new java.awt.Color(255, 255, 255));
        btn_quit.setForeground(new java.awt.Color(0, 153, 204));
        btn_quit.setText("X");
        btn_quit.setBounds(450, 10, 35, 35);
        btn_quit.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_quitActionPerformed(evt);
            }
        });
        add(btn_quit);
        label_username.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label_username.setForeground(new java.awt.Color(0, 0, 0));
        label_username.setText("Username :");
        label_username.setBounds(50, 100, 130, 30);
        add(label_username);
        
        insert_pseudo.setBackground(new java.awt.Color(255, 255, 255));
        insert_pseudo.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        insert_pseudo.setCaretColor(new java.awt.Color(0, 153, 204));
        insert_pseudo.setDisabledTextColor(new java.awt.Color(0, 153, 204));
        insert_pseudo.setBounds(200, 100, 220, 30);
        add(insert_pseudo);

        label_password.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label_password.setForeground(new java.awt.Color(0, 0, 0));
        label_password.setText("Password :");
        label_password.setBounds(50, 150, 130, 30);
        add(label_password);
        
        insert_password.setBackground(new java.awt.Color(255, 255, 255));
        insert_password.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        insert_password.setForeground(new java.awt.Color(0, 0, 0));
        insert_password.setCaretColor(new java.awt.Color(0, 153, 204));
        insert_password.setBounds(200, 150, 220, 30);
        add(insert_password);

        btn_accept.setBackground(new java.awt.Color(0, 153, 204));
        btn_accept.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btn_accept.setForeground(new java.awt.Color(255, 255, 255));
        btn_accept.setText("ACCEPT");
        btn_accept.setName(""); // NOI18N
        btn_accept.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_acceptActionPerformed(evt);
            }
        });
        btn_accept.setBounds(150, 200, 200, 60);
        add(btn_accept);
    }                      
    
    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            System.out.println("Problem :" + ex.getMessage());
        }
        new User_connection().setVisible(true);
    }
    
    private void btn_acceptActionPerformed(java.awt.event.ActionEvent evt) {    
        switch (User.exist(insert_pseudo.getText(), insert_password.getText())) {
            case "M":
                {
                    //to know who is connected in the next windows with all data                    
                    Manager_home user =  new Manager_home(insert_pseudo.getText());
                    user.setVisible(true);
                    this.dispose();
                    break;
                }
            case "C":
                {
                    //to know who is connected in the next windows with all data                    
                    Customer_home user =  new Customer_home(insert_pseudo.getText());
                    user.setVisible(true);
                    this.dispose();
                    break;
                }
            case "T":
                {
                    //to know who is connected in the next windows with all data                    
                    Technician_home user =  new Technician_home(insert_pseudo.getText());
                    user.setVisible(true);
                    this.dispose();
                    break;
                }
            default:
                System.out.println("Existe pas");
                break;
        }
    }                                         

    private void btn_quitActionPerformed(java.awt.event.ActionEvent evt) {                                         
        User.save_data_cust();
        User.save_data_mana();
        User.save_data_tech();
        System.exit(0);
    }                                        
             
    private javax.swing.JButton btn_accept;
    private javax.swing.JButton btn_quit;
    private javax.swing.JPasswordField insert_password;
    private javax.swing.JTextField insert_pseudo;
    private javax.swing.JLabel label_login;
    private javax.swing.JLabel label_password;
    private javax.swing.JLabel label_username;
}