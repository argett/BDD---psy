package projet.mk2.Technician;

import projet.mk2.User.Technician;
import projet.mk2.User.Customer;
import projet.mk2.User.User;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public class Technician_currAppt extends JFrame{
    DefaultTableModel model;
    
    public Technician_currAppt() {          
        initComponents();
        model = (DefaultTableModel)table_currAppt.getModel();
        for (Technician technician : User.getTechnicians()) { 
            if(!technician.getWIP().isEmpty()){
                if(technician.getLogin().equals(Technician.getUser_connected())){
                    int round = 0;
                    String cust = "", serv = "", hour = "", date = "";
                    for(String data : technician.getWIP()){
                        switch(round){
                            case 0:
                                cust = data;
                                round++;
                                break;
                            case 1:
                                serv = data;
                                round++;
                                break;
                            case 2:
                                hour = data + ":00";
                                round++;
                                break;
                            case 3:
                                date = data;
                                round = 0;
                                //add the row
                                model.insertRow(model.getRowCount(), new Object[]{cust, serv, hour, date});
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
        }  
    }
                        
    private void initComponents() {
        label_technician = new javax.swing.JLabel();
        label_error      = new javax.swing.JLabel();
        btn_return     = new javax.swing.JButton();
        jScrollPane1   = new javax.swing.JScrollPane();
        table_currAppt = new javax.swing.JTable();
        btn_endAppt = new javax.swing.JButton();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setLayout(null);
        setSize(500,300);
        setLocationRelativeTo(null);

        label_technician.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label_technician.setForeground(new java.awt.Color(0, 153, 204));
        label_technician.setText("Future appointments");
        label_technician.setBounds(10, 10, 150, 30);
        add(label_technician);

        label_error.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label_error.setForeground(new java.awt.Color(255, 0, 0));
        label_error.setText("");
        label_error.setBounds(150, 200, 250, 30);
        add(label_error);

        table_currAppt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer", "Service", "Hour", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });        
        table_currAppt.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(table_currAppt);
        if (table_currAppt.getColumnModel().getColumnCount() > 0) {
            table_currAppt.getColumnModel().getColumn(0).setPreferredWidth(100);
        }
        jScrollPane1.setBounds(25, 50, 450, 150);
        add(jScrollPane1);

        btn_endAppt.setBackground(new java.awt.Color(0, 153, 204));
        btn_endAppt.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_endAppt.setForeground(new java.awt.Color(255, 255, 255));
        btn_endAppt.setText("End appointment");
        btn_endAppt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btn_endApptActionPerformed(evt);
            }
        });
        btn_endAppt.setBounds(170, 250, 160, 35);
        add(btn_endAppt);

        btn_return.setBackground(new java.awt.Color(255, 255, 255));
        btn_return.setForeground(new java.awt.Color(0, 153, 204));
        btn_return.setText("return");
        btn_return.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btn_returnActionPerformed(evt);
            }
        });
        btn_return.setBounds(400, 10, 70, 30);
        add(btn_return);
    }                      

    private void btn_returnActionPerformed(java.awt.event.ActionEvent evt) {  
        new Technician_home(Technician.user_connected).setVisible(true);
        this.dispose();
    }                                          

    private void btn_endApptActionPerformed(java.awt.event.ActionEvent evt) {                                            
        int row = table_currAppt.getSelectedRow();
        if(row>=0){
            for (Technician technician : User.getTechnicians()){
                if(technician.getLogin().equals(Technician.getUser_connected())){
 /*transfert all*/  technician.transfertWIP(String.valueOf(table_currAppt.getValueAt(row, 0)), String.valueOf(table_currAppt.getValueAt(row, 1)), String.valueOf(String.valueOf(table_currAppt.getValueAt(row, 2)).charAt(0)), String.valueOf(table_currAppt.getValueAt(row, 3)));
 /*init grades*/    technician.addGrade(-1); 
                    technician.addComments(String.valueOf(table_currAppt.getValueAt(row, 0)));
                    technician.addComments("No comment yet");
                            
                    //now change the customer appointment from 0 to 1 (wip to done)
                    int wip = 0;
                    for(Customer cust : User. getCustomers()){
                        if(cust.getLogin().equals(String.valueOf(table_currAppt.getValueAt(row, 0)))){
                            while(wip < cust.getAppointments().size()){
                                if(cust.getAppointments().get(wip+1).equals(String.valueOf(table_currAppt.getValueAt(row, 1))) && cust.getAppointments().get(wip+2).equals(String.valueOf(String.valueOf(table_currAppt.getValueAt(row, 2)).charAt(0))) && cust.getAppointments().get(wip+3).equals(String.valueOf(table_currAppt.getValueAt(row, 3)))){
                                    cust.modifStatus(wip/4);
                                    this.dispose();
                                }
                                wip += 4;
                            }
                        }
                    }
                }
            }
            new Technician_home(Technician.user_connected).setVisible(true);
            this.dispose();
        } else {
            label_error.setText("Please select an appointment");
        }
    }        
                   
    private javax.swing.JButton btn_endAppt;
    private javax.swing.JButton btn_return;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_technician;
    private javax.swing.JTable table_currAppt;         
    private javax.swing.JLabel label_error;   
}
