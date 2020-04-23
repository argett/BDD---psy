package projet.mk2.Manager;

import projet.mk2.User.Manager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.table.DefaultTableModel;
import projet.mk2.User.Technician;
import projet.mk2.User.User;

public class Manager_assignAppmt extends javax.swing.JFrame{    
    DefaultTableModel model;
        
    public Manager_assignAppmt() {       
        initComponents();  

        model = (DefaultTableModel)table_customers.getModel();
        //load customers who asked a appointment
        for(int i= 0; i<User.getCustomers().size(); i++){            
            if(User.getCustomers().get(i).getAskApptmnt()[0] != null){
                model.insertRow(model.getRowCount(),new Object[]{User.getCustomers().get(i).getAskApptmnt()[0],User.getCustomers().get(i).getAskApptmnt()[1]});
            }
        }
        
        //load the 2 weeks after mine
        Calendar calendar = Calendar.getInstance(); 
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        for(int day=0; day<15; day++){
            combobox_date.addItem(date.format(calendar.getTime()));
            calendar.add(calendar.DATE, 1);
        }
        
        //load the hours
        int hours=8;
        while(hours<=17){
            combobox_hour.addItem(hours + ":00");
            hours++;
        }
    }
                       
    private void initComponents() {
        jScrollPane1 = new javax.swing.JScrollPane();
        table_customers = new javax.swing.JTable();
        combobox_date = new javax.swing.JComboBox<>();
        btn_assign = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_technicians = new javax.swing.JTable();
        btn_daySelected = new javax.swing.JButton();
        combobox_hour = new javax.swing.JComboBox<>();
        label_error = new javax.swing.JLabel();
        label_deleteUser = new javax.swing.JLabel();
        btn_return = new javax.swing.JButton();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setLayout(null);
        setSize(700,400);
        setLocationRelativeTo(null);
        
        combobox_date.setBounds(320, 100, 115, 25);
        add(combobox_date);
        
        combobox_hour.setBounds(320, 150, 115, 25);
        add(combobox_hour);
        
        label_error.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label_error.setForeground(new java.awt.Color(255, 0, 0));
        label_error.setBounds(320, 250, 180, 30);
        add(label_error);
        
        label_deleteUser.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label_deleteUser.setForeground(new java.awt.Color(0, 153, 204));
        label_deleteUser.setText("Attribute an appointment");
        label_deleteUser.setBounds(10, 10, 200, 30);
        add(label_deleteUser);

        table_customers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customers", "Service"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_customers.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(table_customers);
        if (table_customers.getColumnModel().getColumnCount() > 0) {
            table_customers.getColumnModel().getColumn(0).setPreferredWidth(100);
        }
        jScrollPane1.setBounds(50, 50, 200, 250);
        add(jScrollPane1);

        table_technicians.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Technicians"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
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
        table_customers.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(table_technicians);
        if (table_technicians.getColumnModel().getColumnCount() > 0) {
            table_technicians.getColumnModel().getColumn(0).setPreferredWidth(100);
        }
        jScrollPane2.setBounds(500, 50, 150, 250);
        add(jScrollPane2);

        btn_return.setBackground(new java.awt.Color(255, 255, 255));
        btn_return.setForeground(new java.awt.Color(0, 153, 204));
        btn_return.setText("return");
        btn_return.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btn_returnActionPerformed(evt);
            }
        });
        btn_return.setBounds(600, 10, 70, 30);
        add(btn_return);

        btn_daySelected.setBackground(new java.awt.Color(0, 153, 204));
        btn_daySelected.setForeground(new java.awt.Color(255, 255, 255));
        btn_daySelected.setText("Select the date");
        btn_daySelected.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btn_daySelectedActionPerformed(evt);
            }
        });
        btn_daySelected.setBounds(320, 200, 115, 25);
        add(btn_daySelected);

        btn_assign.setBackground(new java.awt.Color(0, 153, 204));
        btn_assign.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btn_assign.setForeground(new java.awt.Color(255, 255, 255));
        btn_assign.setText("Assign appointment");
        btn_assign.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btn_assignActionPerformed(evt);
            }
        });
        btn_assign.setBounds(270, 310, 210, 50);
        add(btn_assign);
    }               

    private void btn_returnActionPerformed(java.awt.event.ActionEvent evt) { 
        new Manager_home(Manager.user_connected).setVisible(true);                                          
        this.dispose();
    }                                          

    private void btn_assignActionPerformed(java.awt.event.ActionEvent evt) {                                           
        if(table_customers.getSelectedRow() >= 0 && table_technicians.getSelectedRow() >= 0){
            for(int i= 0; i<User.getCustomers().size(); i++){    
                if(User.getCustomers().get(i).getLogin().equals(table_customers.getValueAt(table_customers.getSelectedRow(), 0))){  
                    label_error.setText(""); //if we have added a label error before, now take out it
                    //set the appointments infos
                    User.getCustomers().get(i).setAppointments((String) table_technicians.getValueAt(table_technicians.getSelectedRow(), 0));          
                    User.getCustomers().get(i).setAppointments(User.getCustomers().get(i).getAskApptmnt()[1]); 
                    User.getCustomers().get(i).setAppointments(String.valueOf(combobox_hour.getSelectedIndex()+8));
                    User.getCustomers().get(i).setAppointments(combobox_date.getSelectedItem().toString());     
                    User.getCustomers().get(i).setStatus(0);
                    User.getCustomers().get(i).setFeedBack("No feedback yet");
                    //take off the demand of appointment
                    User.getCustomers().get(i).setAskApptmnt(null,null);
                    
                    
                    //set the technician appointment
                    for (Technician technician : User.getTechnicians()){
                        if(technician.getLogin() == table_technicians.getValueAt(table_technicians.getSelectedRow(), 0)){
                            technician.setWIP(String.valueOf(table_customers.getValueAt(table_customers.getSelectedRow(), 0))); // name of the cust
                            technician.setWIP(String.valueOf(table_customers.getValueAt(table_customers.getSelectedRow(), 1))); // service
                            technician.setWIP(String.valueOf(combobox_hour.getSelectedIndex()+8)); // hour, +8 bcs start ata 8am at rank 0
                            technician.setWIP(String.valueOf(combobox_date.getSelectedItem().toString())); // date       
                        }
                    }
                    break;
                }
            }
        }
        new Manager_home(Manager.user_connected).setVisible(true);
        this.dispose();
    }                                          

    private void btn_daySelectedActionPerformed(java.awt.event.ActionEvent evt) {                                                
        if(table_customers.getSelectedRow()>=0){
            model = (DefaultTableModel)table_technicians.getModel();
            model.setRowCount(0);
            int freeDay = 0;
            for(Technician tech : User.getTechnicians()){ 
                int cpt = 0;
                if(tech.getWIP().size() > 0){                                   //if a tech get already appointments not finished
                    while(cpt < tech.getWIP().size()){                          //run the whole WIP list
                        if(tech.getWIP().get(cpt+3).equals(combobox_date.getSelectedItem().toString())){                //3 data per wip so to go to next wip, i must make +3   
                            if("minor 1h".equals(tech.getWIP().get(cpt+1))){                                            //duration exists
                                if(table_customers.getValueAt(table_customers.getSelectedRow(), 1).equals("minor 1h")){ //duration choose
                                    int begin_choose = combobox_hour.getSelectedIndex()+8;
                                    int duration_choose = 1;
                                    int begin_exists = Integer.valueOf(tech.getWIP().get(cpt+2));
                                    int duration_exists = 1;
/*+8 bcs rank0 start 8am*/          if(begin_choose >= begin_exists + duration_exists ||  begin_choose + duration_choose <= begin_exists){
                                        model.insertRow(model.getRowCount(),new Object[]{tech.getLogin()});
                                    }
                                } else {
                                    int begin_choose = combobox_hour.getSelectedIndex()+8;
                                    int duration_choose = 3;
                                    int begin_exists = Integer.valueOf(tech.getWIP().get(cpt+2));
                                    int duration_exists = 1;
                                    if(begin_choose >= begin_exists + duration_exists ||  begin_choose + duration_choose <= begin_exists){
                                        model.insertRow(model.getRowCount(),new Object[]{tech.getLogin()});
                                    }
                                }
                            } else { //so major 3h
                                if(table_customers.getValueAt(table_customers.getSelectedRow(), 1).equals("minor 1h")){
                                    int begin_choose = combobox_hour.getSelectedIndex()+8;
                                    int duration_choose = 1;
                                    int begin_exists = Integer.valueOf(tech.getWIP().get(cpt+2)) ;
                                    int duration_exists = 3;
                                    if(begin_choose >= begin_exists + duration_exists ||  begin_choose + duration_choose <= begin_exists){
                                        model.insertRow(model.getRowCount(),new Object[]{tech.getLogin()});
                                    }
                                } else {
                                    int begin_choose = combobox_hour.getSelectedIndex()+8;
                                    int duration_choose = 3;
                                    int begin_exists = Integer.valueOf(tech.getWIP().get(cpt+2)) ;
                                    int duration_exists = 3;
                                    if(begin_choose >= begin_exists + duration_exists ||  begin_choose + duration_choose <= begin_exists){
                                        model.insertRow(model.getRowCount(),new Object[]{tech.getLogin()});
                                    }
                                }
                            }
                        } else {
                            freeDay++;
                        }
                        cpt += 4; // a wip contain 4 data
                    }
                    if(freeDay == (tech.getWIP().size()/4)){    // if all wip are not on the same day          
                        model.insertRow(model.getRowCount(),new Object[]{tech.getLogin()});
                    }
                } else { // if there is no wip
                     model.insertRow(model.getRowCount(),new Object[]{tech.getLogin()});
                }
                
            }
        } else {
            label_error.setText("Please select a customer");
        }
    }                                               
               
    private javax.swing.JButton btn_assign;
    private javax.swing.JButton btn_daySelected;
    private javax.swing.JButton btn_return;
    private javax.swing.JComboBox<String> combobox_date;
    private javax.swing.JComboBox<String> combobox_hour;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label_deleteUser;
    private javax.swing.JLabel label_error;
    private javax.swing.JTable table_customers;
    private javax.swing.JTable table_technicians;         
}
