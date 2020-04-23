package projet.mk2.Technician;

import projet.mk2.User.Technician;
import projet.mk2.User.User;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public class Technician_comments extends JFrame{
    DefaultTableModel model;
    
    public Technician_comments() {          
        initComponents();
        model = (DefaultTableModel)table_comments.getModel();
        for (Technician technician : User.getTechnicians()) { 
            for(int i=0; i< technician.getComments().size(); i+=2){
                if(technician.getLogin().equals(Technician.getUser_connected())){
                    model.insertRow(model.getRowCount(), new Object[]{technician.getComments().get(i), technician.getComments().get(i+1)});
                    break;
                }
            }
        }  
    }

                          
    private void initComponents() {
        label_technician = new javax.swing.JLabel();
        btn_return = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_comments = new javax.swing.JTable();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setLayout(null);
        setSize(500,300);
        setLocationRelativeTo(null);

        label_technician.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label_technician.setForeground(new java.awt.Color(0, 153, 204));
        label_technician.setText("History");
        label_technician.setBounds(10, 10, 60, 30);
        add(label_technician);

        table_comments.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Autor", "Comments"
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
        table_comments.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(table_comments);
        if (table_comments.getColumnModel().getColumnCount() > 0) {
            table_comments.getColumnModel().getColumn(0).setPreferredWidth(100);
        }
        jScrollPane1.setBounds(25, 50, 450, 200);
        add(jScrollPane1);


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
                  
    private javax.swing.JButton btn_return;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_technician;
    private javax.swing.JTable table_comments;       
}
