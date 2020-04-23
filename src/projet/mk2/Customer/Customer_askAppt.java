package projet.mk2.Customer;

import projet.mk2.User.Customer;
import projet.mk2.User.Manager;
import projet.mk2.User.User;

public class Customer_askAppt extends javax.swing.JFrame{    
    public Customer_askAppt() {
        initComponents();
        for(Customer cust : Customer.customers){
            if(cust.getLogin().equals(Customer.user_connected)){
                if(cust.getPayments().length == 0){
                    label_promo.setText("50% free for the first appointment");
                    float reduc1 = User.price1h/2;
                    float reduc2 = User.price3h/2;
                    label_priceMinor.setText(String.valueOf((int)reduc1));
                    label_priceMajor.setText(String.valueOf((int)reduc2));
                } else {
                    label_priceMinor.setText(String.valueOf(User.price1h));
                    label_priceMajor.setText(String.valueOf(User.price3h));
                }
                break;
            }
        }
        
    }
                 
    private void initComponents() {
        text_type = new javax.swing.JLabel();
        btn_return = new javax.swing.JButton();
        text_enterAmount = new javax.swing.JLabel();
        btn_validate = new javax.swing.JButton();
        combobox_service = new javax.swing.JComboBox<>();
        label_priceMinor = new javax.swing.JLabel();
        label_priceMajor = new javax.swing.JLabel();
        label_textMinor  = new javax.swing.JLabel();
        label_textMajor  = new javax.swing.JLabel();
        label_promo = new javax.swing.JLabel() ;
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setLayout(null);
        setSize(400,320);
        setLocationRelativeTo(null);

        text_type.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        text_type.setForeground(new java.awt.Color(0, 153, 204));
        text_type.setText("Ask appointment");
        text_type.setBounds(10, 10, 120, 30);
        add(text_type);

        btn_return.setBackground(new java.awt.Color(255, 255, 255));
        btn_return.setForeground(new java.awt.Color(0, 153, 204));
        btn_return.setText("return");
        btn_return.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_returnActionPerformed(evt);
            }
        });
        btn_return.setBounds(300, 10, 70, 30);
        add(btn_return);

        text_enterAmount.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        text_enterAmount.setForeground(new java.awt.Color(0, 153, 204));
        text_enterAmount.setText("Select the service :");
        text_enterAmount.setBounds(50, 100, 200, 30);
        add(text_enterAmount);

        combobox_service.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "minor 1h", "major 3h" }));
        combobox_service.setBounds(250, 100, 115, 30);
        add(combobox_service);
        
        label_priceMinor.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label_priceMinor.setText("");
        label_priceMinor.setBounds(280, 150, 50, 30);
        add(label_priceMinor);

        label_textMinor.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label_textMinor.setText("Price of minor appointment : MR");
        label_textMinor.setBounds(50, 150, 230, 30);
        add(label_textMinor);        
        
        label_priceMajor.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label_priceMajor.setText("");
        label_priceMajor.setBounds(280, 200, 50, 30);
        add(label_priceMajor);

        label_textMajor.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label_textMajor.setText("Price of major appointment : MR");
        label_textMajor.setBounds(50, 200, 230, 30);
        add(label_textMajor);

        label_promo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label_promo.setText("");
        label_promo.setBounds(85, 50, 250, 30);
        add(label_promo);

        btn_validate.setBackground(new java.awt.Color(0, 153, 204));
        btn_validate.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_validate.setForeground(new java.awt.Color(255, 255, 255));
        btn_validate.setText("Validate");
        btn_validate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_validateActionPerformed(evt);
            }
        });
        btn_validate.setBounds(150, 250, 100, 45);
        add(btn_validate);
    }                        

    private void btn_returnActionPerformed(java.awt.event.ActionEvent evt) {         
        new Customer_home(Customer.user_connected).setVisible(true);
        this.dispose();
    }                                          

    private void btn_validateActionPerformed(java.awt.event.ActionEvent evt) {    
        for(Customer cust : User.getCustomers()){
            if(cust.getLogin().equals(Customer.user_connected)){
                //create the variable 'ask appointment' 
                cust.setAskApptmnt(cust.getLogin(), combobox_service.getSelectedItem().toString());
                
                //collect the payment
                if("minor 1h".equals(combobox_service.getSelectedItem().toString())){
                    cust.setPayments(Integer.valueOf(label_priceMinor.getText()));
                    Manager.addPayments_collected(Integer.valueOf(label_priceMinor.getText()));
                } else {
                   cust.setPayments(Integer.valueOf(label_priceMajor.getText()));
                    Manager.addPayments_collected(Integer.valueOf(label_priceMajor.getText()));
                }
                break;
            }
        }    
        new Customer_home(Customer.user_connected).setVisible(true);
        this.dispose();
    } 
    
    private javax.swing.JButton btn_return;
    private javax.swing.JButton btn_validate;
    private javax.swing.JComboBox<String> combobox_service;
    private javax.swing.JLabel label_promo;
    private javax.swing.JLabel label_priceMajor;
    private javax.swing.JLabel label_priceMinor;
    private javax.swing.JLabel label_textMinor;
    private javax.swing.JLabel label_textMajor;
    private javax.swing.JLabel text_enterAmount;
    private javax.swing.JLabel text_type;         
}
