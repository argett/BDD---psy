package projet.mk2.Customer;

import projet.mk2.User.Customer;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import projet.mk2.User.Technician;
import projet.mk2.User.Technician;
import projet.mk2.User.User;
import projet.mk2.User.User;

public class Customer_seeAppt extends javax.swing.JFrame{
    DefaultTableModel model;
    
    public Customer_seeAppt() {
        initComponents();
        
        model = (DefaultTableModel)table_myAppt.getModel();
        String tech = null, serv = null, hour = null, date = null, fb = null;
        int round = 0, row = 0;
        for(Customer cust : User.getCustomers()){
            if(cust.getLogin().equals(Customer.user_connected)) { //check the correct customer
                if(!cust.getAppointments().isEmpty()){
                    for(String data : cust.getAppointments()){
                        switch (round) {
                            case 0:
                                tech = data;
                                round ++;
                                break;
                            case 1:
                                serv = data;
                                round++;
                                break;
                            case 2:
                                hour = data + ":00";
                                round ++;
                                break;
                            case 3:
                                date = data;
                                //add the feedback
                                fb = cust.getFeedBack().get(row);
                                String status;
                                if(cust.getStatus(row) == 0){
                                    status = "In progress";
                                } else {
                                    status = "Finished";
                                }
                                model.insertRow(model.getRowCount(), new Object[]{tech, serv, hour, date, fb, status});
                                round = 0;
                                row++;
                                break;
                            default:
                                break;
                        }
                    }
                }
                break;
            }   
        }
    }
                         
    private void initComponents() {
        jScrollPane1 = new javax.swing.JScrollPane();
        table_myAppt = new javax.swing.JTable();
        btn_return   = new javax.swing.JButton();
        label_editGrade = new javax.swing.JLabel();
        combobox_grade  = new javax.swing.JComboBox<>();
        text_comment    = new javax.swing.JTextField();
        label_editComment = new javax.swing.JLabel();
        text_type       = new javax.swing.JLabel();
        btn_editComment = new javax.swing.JButton();
        btn_selectAppt  = new javax.swing.JButton();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setLayout(null);
        setSize(650,450);
        setLocationRelativeTo(null);

        text_type.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        text_type.setForeground(new java.awt.Color(0, 153, 204));
        text_type.setText("See my appointments ");
        text_type.setBounds(10, 10, 160, 30);
        add(text_type);

        table_myAppt.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Technician ", "Service ", "Hour", "Date", "FeedBack", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });        
        table_myAppt.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(table_myAppt);
        if (table_myAppt.getColumnModel().getColumnCount() > 0) {
            table_myAppt.getColumnModel().getColumn(0).setPreferredWidth(100);
        }
        jScrollPane1.setBounds(50, 70, 550, 200);
        add(jScrollPane1);

        label_editGrade.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label_editGrade.setText("Edit grade :");
        label_editGrade.setBounds(50, 400, 100, 30);
        add(label_editGrade);

        combobox_grade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));
        combobox_grade.setBounds(150, 400, 100, 30);
        add(combobox_grade);
        
        label_editComment.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label_editComment.setText("Edit comment :");
        label_editComment.setBounds(50, 320, 360, 30);
        add(label_editComment);
        
        text_comment.setBackground(new java.awt.Color(255, 255, 255));
        text_comment.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        text_comment.setCaretColor(new java.awt.Color(0, 153, 204));
        text_comment.setDisabledTextColor(new java.awt.Color(0, 153, 204));
        text_comment.setBounds(50, 350, 550, 40);
        add(text_comment);
                

        btn_editComment.setBackground(new java.awt.Color(0, 153, 204));
        btn_editComment.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_editComment.setForeground(new java.awt.Color(255, 255, 255));
        btn_editComment.setText("Edit");
        btn_editComment.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editCommentActionPerformed(evt);
            }
        });
        btn_editComment.setBounds(425, 400, 150, 40);
        add(btn_editComment);

        btn_selectAppt.setBackground(new java.awt.Color(0, 153, 204));
        btn_selectAppt.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_selectAppt.setForeground(new java.awt.Color(255, 255, 255));
        btn_selectAppt.setText("Select appointment");
        btn_selectAppt.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_selectApptActionPerformed(evt);
            }
        });
        btn_selectAppt.setBounds(220, 280, 220, 30);
        add(btn_selectAppt);

        btn_return.setBackground(new java.awt.Color(255, 255, 255));
        btn_return.setForeground(new java.awt.Color(0, 153, 204));
        btn_return.setText("return");
        btn_return.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_returnActionPerformed(evt);
            }
        });
        btn_return.setBounds(550, 10, 70, 30);
        add(btn_return);
    }  
    
    
    private void btn_returnActionPerformed(java.awt.event.ActionEvent evt) {  
        new Customer_home(Customer.user_connected).setVisible(true);                                         
        this.dispose();
    }                                          

    private void btn_editCommentActionPerformed(java.awt.event.ActionEvent evt) {  
        OUTER:
        if(table_myAppt.getSelectedRow()>=0){
            String name_tech = table_myAppt.getValueAt(table_myAppt.getSelectedRow(), 0).toString();
            int row_selected = table_myAppt.getSelectedRow();
            int currRow = 0;
            int nbOccur_name = 0, inv_nbOccur_name = 0;
                        
            while(currRow < row_selected){ //check how many appointments with the same tech
                if(table_myAppt.getValueAt(row_selected, 0).equals(name_tech)){
                    nbOccur_name++; 
                }
                currRow++;
            }
            
            for(Technician tech : User.getTechnicians()){ //fin the good tech in the tech list
                if(tech.getLogin().equals(name_tech)){
                    int rank = 0, tmp = nbOccur_name;                           
                    while(tmp >= 0){ // find the grade corresponding to the apptmnt
                        if(tech.getAppointments().get(rank).equals(Customer.user_connected)){
                            rank += 4; 
                        } else {
                            inv_nbOccur_name++;
                        }
                        tmp--;
                    }
                    tech.setGrades(nbOccur_name + inv_nbOccur_name, Integer.valueOf(combobox_grade.getSelectedItem().toString())); //we got the rank of the grade we want to change so we change the grade
                    
                    for(int i=0; i < tech.getComments().size(); i++){ // check all comment to find the good one
                        if(tech.getComments().get(i).equals(Customer.user_connected)){
                            tech.setComments(text_comment.getText(), i+1);
                        }
                    }
                    break OUTER; //comment set & grade too, useless to continue triying all other user
                }
            }
        }
        new Customer_home(Customer.user_connected).setVisible(true);
        this.dispose();
    }                                               

    private void btn_selectApptActionPerformed(java.awt.event.ActionEvent evt) {                                               
        int curr_row = 0;
        OUTER:
        if(table_myAppt.getSelectedRow()>=0){
            while(curr_row <= table_myAppt.getSelectedRow()){
                for(Technician tech : User.getTechnicians()){               //try all technician
                    if(tech.getLogin().equals(table_myAppt.getValueAt(table_myAppt.getSelectedRow(), 0))) { //if the actual customer is the same that the one selected
                        if(curr_row == table_myAppt.getSelectedRow()){      // A QUOI CA SERT
                            for(int i=0; i < tech.getComments().size(); i++){ // check all comment to find the good one
                                if(tech.getComments().get(i).equals(Customer.user_connected)){
                                    text_comment.setText(tech.getComments().get(i+1)); //2*row + 1 because each row has 2 cells : the autor and the comment. And +1 because we want the comment which is after the autor
                                    break OUTER; //comment set, useless to continue trying all other user
                                }
                            }
                        }
                    }           
                }
                curr_row++;
            }
        }
    } 
                   
    private javax.swing.JButton btn_editComment;
    private javax.swing.JButton btn_return;
    private javax.swing.JButton btn_selectAppt;
    private javax.swing.JComboBox<String> combobox_grade;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_editComment;
    private javax.swing.JLabel label_editGrade;
    private javax.swing.JTable table_myAppt;
    private javax.swing.JTextField text_comment;
    private javax.swing.JLabel text_type;               
}
