package projet.mk2.Technician;

import projet.mk2.User.Technician;
import projet.mk2.User.Customer;
import projet.mk2.User.User;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public class Technician_historyAppt extends JFrame{
    DefaultTableModel model;
    
    public Technician_historyAppt() {          
        initComponents();
        String grades;
        model = (DefaultTableModel)table_history.getModel();
        for (Technician technician : User.getTechnicians()) { 
            if(!technician.getAppointments().isEmpty()){
                if(technician.getLogin().equals(Technician.getUser_connected())){
                    int round = 0, row=-1;
                    String cust = "", serv = "", hour = "", date = "";
                    for(String data : technician.getAppointments()){
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
                                hour = data;
                                round++;
                                break;  
                            case 3:
                                date = data;
                                round = 0;
                                row += 1;
                                //add the grade given by the cust
                                if(technician.getGrades()[row] == -1){grades = "not graded yet";}
                                else {grades = String.valueOf(technician.getGrades()[row]);}                                
                                //add the row
                                model.insertRow(model.getRowCount(), new Object[]{cust, serv, hour, date, grades});
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
        btn_return = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_history = new javax.swing.JTable();
        btn_selectAppt = new javax.swing.JButton();
        text_feedback = new javax.swing.JTextField();
        btn_editFB = new javax.swing.JButton();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setLayout(null);
        setSize(600,400);
        setLocationRelativeTo(null);
        this.setForeground(Color.yellow);

        label_technician.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label_technician.setForeground(new java.awt.Color(0, 153, 204));
        label_technician.setText("History");
        label_technician.setBounds(10, 10, 70, 30);
        add(label_technician);
        
        text_feedback.setBackground(new java.awt.Color(255, 255, 255));
        text_feedback.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        text_feedback.setCaretColor(new java.awt.Color(0, 153, 204));
        text_feedback.setDisabledTextColor(new java.awt.Color(0, 153, 204));
        text_feedback.setBounds(100, 300, 400, 35);
        add(text_feedback);

        table_history.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer", "Service", "Hour", "Date", "Grade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_history.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(table_history);
        if (table_history.getColumnModel().getColumnCount() > 0) {
            table_history.getColumnModel().getColumn(0).setPreferredWidth(100);
        }
        jScrollPane1.setBounds(10, 50, 580, 170);
        add(jScrollPane1);

        btn_selectAppt.setBackground(new java.awt.Color(0, 153, 204));
        btn_selectAppt.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_selectAppt.setForeground(new java.awt.Color(255, 255, 255));
        btn_selectAppt.setText("Get feedback");
        btn_selectAppt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btn_selectApptActionPerformed(evt);
            }
        });
        btn_selectAppt.setBounds(225, 250, 150, 35);
        add(btn_selectAppt);

        btn_editFB.setBackground(new java.awt.Color(0, 153, 204));
        btn_editFB.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_editFB.setForeground(new java.awt.Color(255, 255, 255));
        btn_editFB.setText("Edit feedback");
        btn_editFB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editFBActionPerformed(evt);
            }
        });
        btn_editFB.setBounds(225, 350, 150, 35);
        add(btn_editFB);

        btn_return.setBackground(new java.awt.Color(255, 255, 255));
        btn_return.setForeground(new java.awt.Color(0, 153, 204));
        btn_return.setText("return");
        btn_return.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_returnActionPerformed(evt);
            }
        });
        btn_return.setBounds(500, 10, 70, 30);
        add(btn_return);
    }                      

    private void btn_returnActionPerformed(java.awt.event.ActionEvent evt) {   
        new Technician_home(Technician.user_connected).setVisible(true);                                        
        this.dispose();
    }                                          

    private void btn_selectApptActionPerformed(java.awt.event.ActionEvent evt) {                                               
        int nb_iteration = -1; //the number of time we encounter the same id (-1 because the name exists at least 1 times)
        int curr_row = 0;
        
        if(table_history.getSelectedRow()>=0){
            //check how many times there are the same names
            while(curr_row <= table_history.getSelectedRow()){ 
                if(table_history.getValueAt(curr_row, 0).equals(table_history.getValueAt(table_history.getSelectedRow(), 0))) { //if the actual customer is the same that the one selected
                    nb_iteration++; 
                }                 
                curr_row++;
            }
            
            //try all custmoer to find the good one to change
            for(Customer cust : User.getCustomers()){  
                if(cust.getLogin().equals(table_history.getValueAt(table_history.getSelectedRow(), 0))) {
                    text_feedback.setText(cust.getFeedBack().get(nb_iteration)); //we dont want the n° of row but the number of time that there is the cust before the row. For ex, we can have cust1 - cust 2 - cust1 and we want the 2nd cust1, he is row3 but place 2
                    break; //comment set, useless to continue triying all other user
                }           
            }
        }
    }                                              

    private void btn_editFBActionPerformed(java.awt.event.ActionEvent evt) {                                           
        int nb_iteration = -1; //the number of time we encounter the same id (-1 because the name exists at least 1 times)
        int curr_row = 0;
        
        if(table_history.getSelectedRow()>=0){
            //check how many times there are the same names
            while(curr_row <= table_history.getSelectedRow()){ 
                if(table_history.getValueAt(curr_row, 0).equals(table_history.getValueAt(table_history.getSelectedRow(), 0))) { //if the actual customer is the same that the one selected
                    nb_iteration++; 
                }                 
                curr_row++;
            }
            
            //try all custmoer to find the good one to change
            for(Customer cust : User.getCustomers()){  
                if(cust.getLogin().equals(table_history.getValueAt(table_history.getSelectedRow(), 0))) {
                    cust.modifyFeedbacks(text_feedback.getText(), nb_iteration);
                    break;
                }           
            }
        }
        new Technician_home(Technician.user_connected).setVisible(true);
        this.dispose();
    } 
                  
    private javax.swing.JButton btn_editFB;
    private javax.swing.JButton btn_return;
    private javax.swing.JButton btn_selectAppt;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_technician;
    private javax.swing.JTable table_history;
    private javax.swing.JTextField text_feedback;          
}
