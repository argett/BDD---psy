package projet.mk2.Manager;

import projet.mk2.User.Manager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import projet.mk2.User.User;

public class Manager_editPrice extends javax.swing.JFrame{
    
    public Manager_editPrice() {
        initComponents();
        if(User.price1h != -1){ 
            input_minor.setText(String.valueOf(User.price1h));
        }
        if(User.price3h != -1){ 
            input_major.setText(String.valueOf(User.price3h));            
        }
    }
    
    private void initComponents() {
        label_editAppt = new javax.swing.JLabel();
        btn_return = new javax.swing.JButton();
        text_minor = new javax.swing.JLabel();
        input_minor = new javax.swing.JTextField();
        btn_validate = new javax.swing.JButton();
        text_major = new javax.swing.JLabel();
        input_major = new javax.swing.JTextField();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setLayout(null);
        setSize(450,300);
        setLocationRelativeTo(null);

        label_editAppt.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label_editAppt.setForeground(new java.awt.Color(0, 153, 204));
        label_editAppt.setText("Edit appointment");
        label_editAppt.setBounds(10, 10, 130, 30);
        add(label_editAppt);

        text_minor.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        text_minor.setForeground(new java.awt.Color(0, 153, 204));
        text_minor.setText("Price of minor appointment (1h) :");
        text_minor.setBounds(25, 100, 300, 30);
        add(text_minor);

        input_minor.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        input_minor.setForeground(new java.awt.Color(0, 0, 0));
        input_minor.setBounds(350, 100, 90, 30);
        add(input_minor);

        text_major.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        text_major.setForeground(new java.awt.Color(0, 153, 204));
        text_major.setText("Price of major appointment (3h) :");
        text_major.setBounds(25, 150, 300, 30);
        add(text_major);

        input_major.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        input_major.setForeground(new java.awt.Color(0, 0, 0));
        input_major.setBounds(350, 150, 90, 30);
        add(input_major);

        btn_validate.setBackground(new java.awt.Color(0, 153, 204));
        btn_validate.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_validate.setForeground(new java.awt.Color(255, 255, 255));
        btn_validate.setText("Validate");
        btn_validate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btn_validateActionPerformed(evt);
            }
        });
        btn_validate.setBounds(150, 250, 150, 30);
        add(btn_validate);

        btn_return.setBackground(new java.awt.Color(255, 255, 255));
        btn_return.setForeground(new java.awt.Color(0, 153, 204));
        btn_return.setText("return");
        btn_return.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btn_returnActionPerformed(evt);
            }
        });
        btn_return.setBounds(350, 10, 70, 30);
        add(btn_return);
    }                       

    private void btn_validateActionPerformed(java.awt.event.ActionEvent evt) {   
        User.price1h = Integer.valueOf(input_minor.getText());
        User.price3h = Integer.valueOf(input_major.getText());
        new Manager_home(Manager.user_connected).setVisible(true);
        this.dispose();
    }                                            

    private void btn_returnActionPerformed(java.awt.event.ActionEvent evt) {  
        new Manager_home(Manager.user_connected).setVisible(true);                                         
        this.dispose();
    }                                          
                  
    private javax.swing.JButton btn_return;
    private javax.swing.JButton btn_validate;
    private javax.swing.JTextField input_major;
    private javax.swing.JTextField input_minor;
    private javax.swing.JLabel label_editAppt;
    private javax.swing.JLabel text_major;
    private javax.swing.JLabel text_minor;             
}
