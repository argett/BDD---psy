package projet.mk2.Manager;

import static projet.mk2.User.User.customers;
import static projet.mk2.User.User.managers;
import static projet.mk2.User.User.technicians;

import projet.mk2.User.Technician;
import projet.mk2.User.Manager;
import projet.mk2.User.Customer;
import projet.mk2.User.User;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Manager_addUser extends javax.swing.JFrame{    
    public Manager_addUser() {       
        initComponents();     
    }
                         
    private void initComponents() {
        label_typeOfUser = new javax.swing.JLabel();
        label_addCustomer= new javax.swing.JLabel();
        label_error    = new javax.swing.JLabel();
        label_ID       = new javax.swing.JLabel();
        label_password = new javax.swing.JLabel();
        input_password = new javax.swing.JTextField();
        input_ID       = new javax.swing.JTextField();
        input_type = new javax.swing.JComboBox<>();
        btn_create = new javax.swing.JButton();
        btn_return = new javax.swing.JButton();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setLayout(null);
        setSize(500,330);
        setLocationRelativeTo(null);

        label_addCustomer.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label_addCustomer.setForeground(new java.awt.Color(0, 153, 204));
        label_addCustomer.setText("Add a customer");
        label_addCustomer.setBounds(10, 10, 130, 30);
        add(label_addCustomer);

        label_typeOfUser.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label_typeOfUser.setForeground(new java.awt.Color(0, 153, 204));
        label_typeOfUser.setText("Type of user :");
        label_typeOfUser.setBounds(50, 100, 130, 30);
        add(label_typeOfUser);

        label_ID.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label_ID.setForeground(new java.awt.Color(0, 153, 204));
        label_ID.setText("ID :");
        label_ID.setBounds(50, 150, 130, 30);
        add(label_ID);

        label_password.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label_password.setForeground(new java.awt.Color(0, 153, 204));
        label_password.setText("Password :");
        label_password.setBounds(50, 200, 130, 30);
        add(label_password);

        label_error.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label_error.setForeground(new java.awt.Color(255, 0, 0));
        label_error.setText("");
        label_error.setBounds(50, 50, 250, 30);
        add(label_error);

        input_type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Customer", "Manager", "Technician" }));
        input_type.setBounds(250, 100, 150, 30);
        add(input_type);
        
        input_ID.setBackground(new java.awt.Color(255, 255, 255));
        input_ID.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        input_ID.setCaretColor(new java.awt.Color(0, 153, 204));
        input_ID.setDisabledTextColor(new java.awt.Color(0, 153, 204));
        input_ID.setBounds(250, 150, 150, 30);
        add(input_ID);
        
        input_password.setBackground(new java.awt.Color(255, 255, 255));
        input_password.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        input_password.setCaretColor(new java.awt.Color(0, 153, 204));
        input_password.setDisabledTextColor(new java.awt.Color(0, 153, 204));
        input_password.setBounds(250, 200, 150, 30);
        add(input_password);

        btn_return.setBackground(new java.awt.Color(255, 255, 255));
        btn_return.setForeground(new java.awt.Color(0, 153, 204));
        btn_return.setText("return");
        btn_return.addActionListener(new ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                btn_returnActionPerformed(evt);
            }
        });
        btn_return.setBounds(400, 10, 70, 30);
        add(btn_return);

        btn_create.setBackground(new java.awt.Color(0, 153, 204));
        btn_create.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btn_create.setForeground(new java.awt.Color(255, 255, 255));
        btn_create.setText("Create");
        btn_create.addActionListener(new ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                btn_createActionPerformed(evt);
            }
        });
        btn_create.setBounds(200, 250, 110, 50);
        add(btn_create);
    }                     

    private void btn_createActionPerformed( ActionEvent evt) {
        boolean same_name = false;                          //to be sure to not enter twice the same id
        for(Customer user : User.customers){
            if(input_ID.getText().equals(user.getLogin())){
                same_name = true;
            }
        }
        for(Manager user : User.managers){
            if(input_ID.getText().equals(user.getLogin())){
                same_name = true;
            }
        } 
        for(Technician user : User.technicians){
            if(input_ID.getText().equals(user.getLogin())){
                same_name = true;
            }
        }
        if(same_name){
            label_error.setText("This ID already exists !");
        } else {
            String type = input_type.getSelectedItem().toString();
            switch(type){
                case "Customer":
                    Customer added1 = new Customer();
                    added1.setLogin(input_ID.getText());
                    added1.setPassword(input_password.getText());
                    added1.setIDCN(-1);
                    customers.add(added1);
                    break;
                case "Manager":
                    Manager added2 = new Manager();
                    added2.setLogin(input_ID.getText());
                    added2.setPassword(input_password.getText());
                    added2.setIDCN(-1);
                    managers.add(added2);
                    break;
                case "Technician":
                    Technician added3 = new Technician();
                    added3.setLogin(input_ID.getText());
                    added3.setPassword(input_password.getText());
                    added3.setIDCN(-1);
                    technicians.add(added3);
                    break;
            }
            new Manager_home(Manager.user_connected).setVisible(true);
            this.dispose();            
        }
    }                                          

    private void btn_returnActionPerformed(ActionEvent evt) {    
        new Manager_home(Manager.user_connected).setVisible(true);                                       
        this.dispose();
    }
    
    private javax.swing.JButton btn_create;
    private javax.swing.JButton btn_return;
    private javax.swing.JTextField input_ID;
    private javax.swing.JTextField input_password;
    private javax.swing.JComboBox<String> input_type;
    private javax.swing.JLabel label_ID;
    private javax.swing.JLabel label_addCustomer;
    private javax.swing.JLabel label_password;
    private javax.swing.JLabel label_typeOfUser; 
    private javax.swing.JLabel label_error;           
}
