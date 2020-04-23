package projet.mk2.Manager;

import projet.mk2.User.Manager;
import projet.mk2.User.Customer;
import projet.mk2.User.Technician;
import projet.mk2.User.User;
import static projet.mk2.User.User.customers;
import static projet.mk2.User.User.managers;
import static projet.mk2.User.User.technicians;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public class Manager_editUser extends JFrame{  
    String header[] = {"Type", "Name", "Password", "ID Card Number", "Phone", "Mail", "Adress", "Ask Appointement", "Department"};  
    DefaultTableModel model;
        
    public Manager_editUser() {       
        initComponents();  
        
        model = (DefaultTableModel)table_allUser.getModel();
        //load all users in the table
        for(Customer cust : User.getCustomers()){
            String ask_apptmnt; //to display line 32
            if(cust.getAskApptmnt()[0] == null) {ask_apptmnt = "no";}
            else {ask_apptmnt = "yes";}
            
            String idcn;
            if(cust.getIDCN() == -1) {
                idcn = "";
            } else {
                idcn = String.valueOf(cust.getIDCN());
            }
            
            model.insertRow(model.getRowCount(), new Object[]{"Customer",cust.getLogin(),cust.getPassword(), idcn, cust.getPhone(), cust.getEmail(), cust.getAddress(), ask_apptmnt, "x"});
        }
        for(Manager mang : User.getManagers()){    
            
            String idcn;
            if(mang.getIDCN() == -1) {
                idcn = "No ID card number";
            } else {
                idcn = String.valueOf(mang.getIDCN());
            }
            
            model.insertRow(model.getRowCount(), new Object[]{"Manager", mang.getLogin(), mang.getPassword(), idcn, mang.getPhone(), mang.getEmail() ,mang.getAddress(), "x", mang.getDepartment()});
        }
        for(Technician tech : User.getTechnicians()){    
            
            String idcn;
            if(tech.getIDCN() == -1) {
                idcn = "No ID card number";
            } else {
                idcn = String.valueOf(tech.getIDCN());
            }     
            model.insertRow(model.getRowCount(), new Object[]{"Technician",tech.getLogin(),tech.getPassword(),idcn, tech.getPhone(), tech.getEmail(), tech.getAddress(), "x", tech.getDepartment()});
        }
    }
                        
    private void initComponents() {
        table_allUser = new javax.swing.JTable();
        jScrollPane1  = new javax.swing.JScrollPane();
        btn_delete    = new javax.swing.JButton();
        btn_edit      = new javax.swing.JButton();
        input_user    = new javax.swing.JTextField();
        btn_findUser  = new javax.swing.JButton();
        label_error   = new javax.swing.JLabel();
        label_deleteUser = new javax.swing.JLabel();
        btn_return       = new javax.swing.JButton();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setLayout(null);
        setSize(1400,600);
        setLocationRelativeTo(null);

        input_user.setBackground(new java.awt.Color(255, 255, 255));
        input_user.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        input_user.setForeground(new java.awt.Color(0, 153, 204));
        input_user.setText("Enter a user");
        input_user.setBounds(100, 80, 175, 35);
        add(input_user);

        label_error.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label_error.setForeground(new java.awt.Color(255, 51, 51));
        label_error.setBounds(400, 80, 300, 30);
        add(label_error);

        label_deleteUser.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label_deleteUser.setForeground(new java.awt.Color(0, 153, 204));
        label_deleteUser.setText("Edit users");
        label_deleteUser.setBounds(10, 10, 100, 30);
        add(label_deleteUser);

        btn_return.setBackground(new java.awt.Color(255, 255, 255));
        btn_return.setForeground(new java.awt.Color(0, 153, 204));
        btn_return.setText("return");
        btn_return.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btn_returnActionPerformed(evt);
            }
        });
        btn_return.setBounds(1300, 10, 70, 30);
        add(btn_return);

        btn_findUser.setBackground(new java.awt.Color(255, 255, 255));
        btn_findUser.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_findUser.setForeground(new java.awt.Color(0, 153, 204));
        btn_findUser.setText("Find");
        btn_findUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btn_findUserActionPerformed(evt);
            }
        });
        btn_findUser.setBounds(300, 80, 70, 35);
        add(btn_findUser);

        btn_delete.setBackground(new java.awt.Color(0, 153, 204));
        btn_delete.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btn_delete.setForeground(new java.awt.Color(255, 255, 255));
        btn_delete.setText("Delete");
        btn_delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });
        btn_delete.setBounds(450, 500, 150, 50);
        add(btn_delete);

        btn_edit.setBackground(new java.awt.Color(0, 153, 204));
        btn_edit.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btn_edit.setForeground(new java.awt.Color(255, 255, 255));
        btn_edit.setText("Edit");
        btn_edit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });
        
        btn_edit.setBounds(800, 500, 150, 50);
        add(btn_edit);
        
        
        table_allUser.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Type", "Name", "Password", "ID Card Number", "Phone", "Mail", "Adress", "Ask Appointement", "Department"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, false, true
            };
            
            @Override
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
            
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
            
            @Override
            public String getColumnName(int column) {
               return header[column];
            }
        });
        table_allUser.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(table_allUser);
        if (table_allUser.getColumnModel().getColumnCount() > 0) {
            table_allUser.getColumnModel().getColumn(0).setPreferredWidth(100);
        }
        jScrollPane1.setBounds(50, 150, 1300, 300);
        add(jScrollPane1);
    }                        

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {                                           
        if(table_allUser.getSelectedRow()>=0){
            label_error.setText("");
            if(table_allUser.getValueAt(table_allUser.getSelectedRow(), 1).equals(Manager.user_connected)){
                label_error.setText("You can't delete your own account !");
            } else {
                int compare = 0, row = table_allUser.getSelectedRow();
                boolean done = false;
                //delete in the table
                model.removeRow(table_allUser.getSelectedRow());
                //delete in the arrayList
                for(int i= 0; i<User.getCustomers().size(); i++){
                    //check is the row is a cutomer
                    if(row == compare){
                        customers.remove(User.getCustomers().get(i));
                        done = true;
                        break;
                    }
                    compare++;
                }
                if(!done){
                    for(int i= 0; i<User.getManagers().size(); i++){
                        //check is the row is a manager
                        if(row == compare){
                            managers.remove(User.getManagers().get(i));
                            done = true;
                            break;
                        }
                        compare++;
                    }
                    if(!done){
                        for(int i= 0; i<User.getTechnicians().size(); i++){  
                            //check is the row is a technician         
                            if(row == compare){
                                technicians.remove(User.getTechnicians().get(i));
                                done = true;
                                break;
                            }
                            compare++;
                        }
                    }
                }
                if(done){System.out.println("done");}
                else {System.out.println("Problem 'manager_delete' line 170");}

            }
        }
    }                                          

    private void btn_returnActionPerformed(java.awt.event.ActionEvent evt) {  
        new Manager_home(Manager.user_connected).setVisible(true);                                         
        this.dispose();
    }                                          

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {                                         
        if(table_allUser.getSelectedRow()>=0){
            int compare = 0, row = table_allUser.getSelectedRow();
            boolean done = false;
            //delete in the arrayList
            for(Customer cust : User.getCustomers()){
                //check is the row is a cutomer     
                if(row == compare){
                    cust.setLogin(String.valueOf(model.getValueAt(table_allUser.getSelectedRow(), 1)));
                    cust.setPassword(String.valueOf(model.getValueAt(table_allUser.getSelectedRow(), 2)));
                    
                    try { cust.setIDCN(Long.valueOf(model.getValueAt(table_allUser.getSelectedRow(), 3).toString()));
                    } catch (NumberFormatException ex) {
                        cust.setIDCN(-1);  
                    }
                    
                    cust.setPhone(model.getValueAt(table_allUser.getSelectedRow(), 4).toString());                     
                    cust.setEmail(String.valueOf(model.getValueAt(table_allUser.getSelectedRow(), 5)));
                    cust.setAddress(String.valueOf(model.getValueAt(table_allUser.getSelectedRow(), 6)));
                    done = true;
                    break;
                }
                compare++; //we compare all user until we found, when the user nb X = column's nb, we find it
            }
            if(!done){
                for(Manager manag : User.getManagers()){
                    //check is the row is a manager
                    if(row == compare){
                        manag.setLogin(String.valueOf(model.getValueAt(table_allUser.getSelectedRow(), 1)));
                        manag.setPassword(String.valueOf(model.getValueAt(table_allUser.getSelectedRow(), 2)));
                        
                        try { manag.setIDCN(Long.valueOf(model.getValueAt(table_allUser.getSelectedRow(), 3).toString()));
                        } catch (NumberFormatException ex) {
                            manag.setIDCN(-1);  
                        }
                        
                        manag.setPhone((String) model.getValueAt(table_allUser.getSelectedRow(), 4));    
                        manag.setEmail(String.valueOf(model.getValueAt(table_allUser.getSelectedRow(), 5)));
                        manag.setAddress(String.valueOf(model.getValueAt(table_allUser.getSelectedRow(), 6)));
                        manag.setDepartment(String.valueOf(model.getValueAt(table_allUser.getSelectedRow(), 8)));
                        done = true;
                        break;
                    }
                    compare++;
                }
                if(!done){
                    for(Technician tech : User.getTechnicians()){  
                        //check is the row is a technician         
                        if(row == compare){
                            tech.setLogin(String.valueOf(model.getValueAt(table_allUser.getSelectedRow(), 1)));
                            tech.setPassword(String.valueOf(model.getValueAt(table_allUser.getSelectedRow(), 2))); 
                        
                            try { tech.setIDCN(Long.valueOf(model.getValueAt(table_allUser.getSelectedRow(), 3).toString()));
                            } catch (NumberFormatException ex) {
                                tech.setIDCN(-1);  
                            }

                           
                            tech.setPhone((String) model.getValueAt(table_allUser.getSelectedRow(), 4));  
                            tech.setEmail(String.valueOf(model.getValueAt(table_allUser.getSelectedRow(), 5)));
                            tech.setAddress(String.valueOf(model.getValueAt(table_allUser.getSelectedRow(), 6)));
                            tech.setDepartment(String.valueOf(model.getValueAt(table_allUser.getSelectedRow(), 8)));
                            done = true;
                            break;
                        }
                        compare++;
                    }
                }
            }
            if(done){System.out.println("done");}
            else {System.out.println("Problem 'manager_delete' line 170");}
        }
    }                                        

    private void btn_findUserActionPerformed(java.awt.event.ActionEvent evt) {                                             
        boolean found = false;
        model = (DefaultTableModel)table_allUser.getModel();
        
        //load the correct user is the table
        if(input_user.getText().equals("")){
            //reset the frame                                
            Manager_editUser edit =  new Manager_editUser();
            edit.setVisible(true);
            this.dispose();
        } else {    
            for(Customer cust : User.getCustomers()){
                if(cust.getLogin().equals(input_user.getText())){
                    model.getDataVector().removeAllElements();

                    String ask_apptmnt;
                    if(cust.getAskApptmnt()[0] == null) {ask_apptmnt = "no";}
                    else {ask_apptmnt = "yes";}   

                    String idcn;
                    if(cust.getIDCN() == -1) {
                        idcn = "";
                    } else {
                        idcn = String.valueOf(cust.getIDCN());
                    }

                    model.insertRow(model.getRowCount(), new Object[]{"Customer",cust.getLogin(),cust.getPassword(), idcn, cust.getPhone(), cust.getEmail(), cust.getAddress(), ask_apptmnt, "x"});
                    found = true;
                }
            }
            if(!found){
                for(Manager mang : User.getManagers()){  
                    if(mang.getLogin().equals(input_user.getText())){

                        String idcn;
                        if(mang.getIDCN() == -1) {
                            idcn = "";
                        } else {
                            idcn = String.valueOf(mang.getIDCN());
                        }
                        model.getDataVector().removeAllElements();
                        model.insertRow(model.getRowCount(), new Object[]{"Manager", mang.getLogin(), mang.getPassword(), idcn, mang.getPhone(), mang.getEmail() ,mang.getAddress(), "x", mang.getDepartment()});
                        found = true;
                    }
                }
                if(!found){
                    for(Technician tech : User.getTechnicians()){     
                        if(tech.getLogin().equals(input_user.getText())){         

                            String idcn;
                            if(tech.getIDCN() == -1) {
                                idcn = "";
                            } else {
                                idcn = String.valueOf(tech.getIDCN());
                            }

                            model.getDataVector().removeAllElements();
                            model.insertRow(model.getRowCount(), new Object[]{"Technician",tech.getLogin(),tech.getPassword(),idcn, tech.getPhone(), tech.getEmail(), tech.getAddress(), "x", tech.getDepartment()});
                            found = true;
                        }
                    }
                }
            }
            if(!found){label_error.setText("No user with such name exists");}
            else {label_error.setText("");} //if we re-enter a name after a false one, juste make the message disapeare
        }
    }            
    
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_findUser;
    private javax.swing.JButton btn_return;
    private javax.swing.JTextField input_user;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_deleteUser;
    private javax.swing.JLabel label_error;
    private javax.swing.JTable table_allUser;
}
