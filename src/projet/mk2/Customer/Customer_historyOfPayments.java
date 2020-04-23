package projet.mk2.Customer;

import projet.mk2.User.Customer;
import projet.mk2.User.User;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class Customer_historyOfPayments extends javax.swing.JFrame{
    DefaultTableModel model;
    
    public Customer_historyOfPayments() {
        initComponents();
        
        model = (DefaultTableModel)table_payments.getModel();
        //find the correct customer connected
        for(Customer cust : User.getCustomers()){    
            if(cust.getLogin().equals(Customer.user_connected)){       
                //load all payments in the table
                for(int j : cust.getPayments()){      
                    model.insertRow(model.getRowCount(), new Object[]{j});
                }
                break;
            }
        }    
    }
    
    private void initComponents() {
        label_history = new javax.swing.JLabel();
        btn_return = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_payments = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setLayout(null);
        setSize(450,300);
        setLocationRelativeTo(null);

        label_history.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label_history.setForeground(new java.awt.Color(0, 153, 204));
        label_history.setText("History of payments ");
        label_history.setBounds(10, 10, 150, 30);
        add(label_history);

        btn_return.setBackground(new java.awt.Color(255, 255, 255));
        btn_return.setForeground(new java.awt.Color(0, 153, 204));
        btn_return.setText("return");
        btn_return.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_returnActionPerformed(evt);
            }
        });
        btn_return.setBounds(350, 10, 70, 30);
        add(btn_return);

        table_payments.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Payments "
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_payments.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(table_payments);
        if (table_payments.getColumnModel().getColumnCount() > 0) {
            table_payments.getColumnModel().getColumn(0).setPreferredWidth(100);
        }
        jScrollPane1.setBounds(100, 75, 250, 200);
        add(jScrollPane1);
    }                     

    private void btn_returnActionPerformed(java.awt.event.ActionEvent evt) {    
        new Customer_home(Customer.user_connected).setVisible(true);                                       
        this.dispose();
    }  
                   
    private javax.swing.JButton btn_return;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_history;
    private javax.swing.JTable table_payments;    
}
