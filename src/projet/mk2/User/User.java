package projet.mk2.User;

import projet.mk2.text_file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class User{
    private String login;
    private String password;
    private String email ="";
    private String address ="";
    private String phone ="";
    private long IDCN = -1; //id card number  
    public static int price1h = -1;
    public static int price3h = -1;
    public static ArrayList<Customer> customers;
    public static ArrayList<Manager> managers;
    public static ArrayList<Technician> technicians;
    
    public static void load_customer(){
        //to avoid problems if the text file is empty
        boolean empty = true;                              
        //create list
        customers = new ArrayList<>();
        //load file
        List<String> data = null; 
        String[] appt = new String[2];
        
        try { data = Files.readAllLines(Paths.get("list_customer.txt"));
        } catch (IOException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int next = -1;
        Customer cust = new Customer();
        //attribute file to new customer variable        
        OUTER:
        for (String A_string : data) {
            switch (next) {
                case 0:
                    cust.setLogin(A_string);
                    next = -1;
                    break ;             
                case 1:
                    cust.setPassword(A_string);
                    next = -1;
                    break;            
                case 2:
                    cust.setIDCN(Long.valueOf(A_string));
                    next = -1;
                    break;            
                case 3:
                    cust.setPhone(A_string);
                    next = -1;
                    break;            
                case 4:
                    cust.setEmail(A_string);
                    next = -1;
                    break;            
                case 5:
                    cust.setAddress(A_string);
                    next = -1;
                    break;             
                case 6:
                    if("ask apptmnt:".equals(A_string) || "appointments:".equals(A_string)) {break;}
                    cust.setFeedBack(A_string);
                    break;            
                case 7:
                    appt[0] = A_string;
                    next = 77;
                    break; 
                case 77:
                    appt[1] = A_string;
                    cust.setAskApptmnt(appt[0], appt[1]);
                    next = -1;
                    break;
                case 8:
                    if("status:".equals(A_string)) {break;}
                    cust.setAppointments(A_string);
                    //no next because we can have several appointments
                    break; 
                case 9:
                    if("payments:".equals(A_string)) {break;}
                    if("-".equals(A_string)) {break;}
                    cust.setStatus(Integer.parseInt(A_string));
                    break; 
                case 10:
                    if("-".equals(A_string)) {break;}
                    if("+".equals(A_string)){next = -1; break;} //because we can gave many lines of number
                    cust.setPayments(Integer.parseInt(A_string));
                    break;
                default:
                    break;
            }
            
            switch (A_string) {
                case "+":
                    next = -1;                   
                    //cust.setAppointments(appointments_local); //no matter if there is something in the String, we have to initialize it for the program
                    customers.add(cust); // add the technician    
                    cust = new Customer();
                    // we cant do appointments_local.clear() because there is a "bug" of pointer only solvable in C
                    // so redefine a new array list allow to solve this problem (put for all customers the same appointment as the last) 
                    break;           
                case "id:":
                    empty = false;
                    next=0;
                    break;
                case "password:":
                    next=1;
                    break;
                case "idcn:":
                    next=2;
                    break;
                case "phone:":
                    next=3;
                    break;
                case "mail:":
                    next=4;
                    break;
                case "address:":
                    next=5;
                    break;
                case "feedback:":
                    next=6;
                    break;
                case "ask apptmnt:":
                    next=7;
                    break;
                case "appointments:":
                    next=8;
                    break;
                case "status:":
                    next=9;
                    break;
                case "payments:":
                    next=10;
                    break;
                case "-":    
                    if(!empty){
                        customers.add(cust);
                    }  
                    break OUTER; 
                default:
                    break;
            }
        }
    }
    public static void load_manager(){
        //to avoid problems if the text file is empty
        boolean empty = true;        
        //create list
        managers = new ArrayList<>();
        //load file
        List<String> data = null;              
        try { data = Files.readAllLines(Paths.get("list_manager.txt"));
        } catch (IOException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int next = -1;
        Manager mngr = new Manager();
        //attribute file to new customer variable        
        OUTER:
        for (String A_string : data) {
            switch (next) {
                case 0:
                    mngr.setLogin(A_string);                  
                    next = -1;
                    break ;             
                case 1:
                    mngr.setPassword(A_string);
                    next = -1;
                    break;            
                case 2:
                    mngr.setIDCN(Long.valueOf(A_string));
                    next = -1;
                    break;             
                case 3:
                    mngr.setPhone(A_string);
                    next = -1;
                    break;            
                case 4:
                    mngr.setEmail(A_string);
                    next = -1;
                    break;            
                case 5:
                    mngr.setAddress(A_string);
                    next = -1;
                    break;   
                case 6:                     
                    User.price1h = Integer.valueOf(A_string);
                    next = -1;
                    break;            
                case 7:                    
                    User.price3h = Integer.valueOf(A_string);
                    next = -1;
                    break;              
                case 8:                    
                    Manager.setPayments_collected(Integer.valueOf(A_string));
                    next = -1;
                    break;     
                case 9:
                    mngr.setDepartment(A_string);
                    next = -1;
                    break; 
                default:
                    break;
            }
            
            switch (A_string) {
                case "+":
                    next = -1;
                    managers.add(mngr); //we add the manager to the array list
                    mngr = new Manager();
                    break;           
                case "id:":
                    empty  = false;
                    next=0;
                    break;
                case "password:":
                    next=1;
                    break;
                case "idcn:":
                    next=2;
                    break;
                case "phone:":
                    next=3;
                    break;
                case "mail:":
                    next=4;
                    break;
                case "address:":
                    next=5;
                    break;
                case "1h:":
                    next=6;
                    break;
                case "3h:":
                    next=7;
                    break;          
                case "Money:":
                    next=8;
                    break;
                case "department:":
                    next=9;
                    break;
                case "-":
                    if(!empty){ managers.add(mngr); }                 
                    break OUTER;    
                default:
                    break;
            }
        }
    }
    public static void load_technician(){
        //to avoid problems if the text file is empty
        boolean empty = true;   
        //create list
        technicians = new ArrayList<>();
        //load file
        List<String> data = null;             
        try { data = Files.readAllLines(Paths.get("list_technician.txt"));
        } catch (IOException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        int next = -1;
        Technician tech = new Technician();
        //attribute file to new customer variable        
        OUTER:
        for (String A_string : data) {
            switch (next) {
                case 0:
                    tech.setLogin(A_string);
                    next = -1;
                    break ;             
                case 1:                    
                    tech.setPassword(A_string);
                    next = -1;
                    break;            
                case 2:                    
                    tech.setIDCN(Long.valueOf(A_string));
                    next = -1;
                    break;           
                case 3:
                    tech.setPhone(A_string);
                    next = -1;
                    break;            
                case 4:
                    tech.setEmail(A_string);
                    next = -1;
                    break;            
                case 5:
                    tech.setAddress(A_string);
                    next = -1;
                    break;            
                case 6:                    
                    tech.setDepartment(A_string);
                    next = -1;
                    break;
                case 7: 
                    if("-".equals(A_string)){break;}
                    if("+".equals(A_string)){break;}
                    if("appointment:".equals(A_string)){break;}
                    tech.setWIP(A_string);
                    break;
                case 8:
                    //if we get appointments, we're sure to have grades and feedbacks
                    if("grades:".equals(A_string)){break;} // we can not have comments and if we got appointments we're sure to get grades so they can be just after so check
                    tech.setAppointments(A_string);
                    break;
                case 9:
                    if("comment:".equals(A_string)){break;}
                    if("+".equals(A_string)){break;}    
                    if("-".equals(A_string)){break;}
                    tech.addGrade(Integer.valueOf(A_string));
                    break;
                case 10:              
                    if("+".equals(A_string)){break;}    
                    if("-".equals(A_string)){break;}
                    tech.addComments(A_string);
                    break;
                default:
                    break;
            }
            
            switch (A_string) {
                case "+":
                    next = -1;
                    technicians.add(tech);
                    tech = new Technician();
                    break;           
                case "id:":
                    empty = false;
                    next=0;
                    break;
                case "password:":
                    next=1;
                    break;
                case "idcn:":
                    next=2;
                    break;
                case "phone:":
                    next=3;
                    break;
                case "mail:":
                    next=4;
                    break;
                case "address:":
                    next=5;
                    break;
                case "department:":
                    next=6;
                    break;
                case "wip:":
                    next=7;
                    break;
                case "appointment:":
                    next=8;
                    break;
                case "grades:":
                    next=9;
                    break;
                case "comment:":
                    next=10;
                    break;
                case "-":
                    if(!empty){ technicians.add(tech); }
                    break OUTER;
                default:
                    break;
            }
        }        
    }  
    public static void save_data_cust(){
        List<String> dataToSave = new ArrayList<>();
        for(int i= 0; i<User.getCustomers().size(); i++){           
            dataToSave.add("id:\n" +         User.getCustomers().get(i).getLogin());
            dataToSave.add("password:\n" +   User.getCustomers().get(i).getPassword());
            dataToSave.add("idcn:\n" +       User.getCustomers().get(i).getIDCN());
            if(!"".equals(User.getCustomers().get(i).getPhone()))  { dataToSave.add("phone:\n"   + User.getCustomers().get(i).getPhone()); }
            if(!"".equals(User.getCustomers().get(i).getEmail())){   dataToSave.add("mail:\n"    + User.getCustomers().get(i).getEmail()); }
            if(!"".equals(User.getCustomers().get(i).getAddress())){ dataToSave.add("address:\n" + User.getCustomers().get(i).getAddress());}
            
            
            //write the feedback
            if(!User.getCustomers().get(i).getFeedBack().isEmpty()){
                dataToSave.add("feedback:");
                for(String data : User.getCustomers().get(i).getFeedBack()){
                    dataToSave.add(data);
                }
            }
            
            if(User.getCustomers().get(i).getAskApptmnt()[0] != null){ dataToSave.add("ask apptmnt:\n" + User.getCustomers().get(i).getAskApptmnt()[0] + "\n" + User.getCustomers().get(i).getAskApptmnt()[1]);}
            //add all the appointments:
            if(!User.getCustomers().get(i).getAppointments().isEmpty()){
                dataToSave.add("appointments:");
                for(String j : User.getCustomers().get(i).getAppointments()){      
                    dataToSave.add(j);
                }
            }
            
            // write the status
            if(User.getCustomers().get(i).getStatusGeneral().length > 0){
                dataToSave.add("status:");
                for(int k : User.getCustomers().get(i).getStatusGeneral()){      
                    dataToSave.add(Integer.toString(k));
                }
            }
            
            //add all the payments  
            if(User.getCustomers().get(i).getPayments().length > 0){
                dataToSave.add("payments:");
                for(int l : User.getCustomers().get(i).getPayments()){      
                    dataToSave.add(Integer.toString(l));
                }
            }
            
            //we add + only if there is an other customer after
            if(i+1 < User.getCustomers().size()){dataToSave.add("+");}
        }
        dataToSave.add("-");
        text_file.fileWrite("list_customer.txt",dataToSave);
    }
    public static void save_data_mana(){
        List<String> dataToSave = new ArrayList<>();
        //first, set the prices of each appointment
        if(User.price1h != -1){
            dataToSave.add("1h:\n" + User.price1h);
        }
        if(User.price3h != -1){
            dataToSave.add("3h:\n" + User.price3h);
        }
        dataToSave.add("Money:\n" + Manager.getPayments_collected());
        
        for(int i= 0; i<User.getManagers().size(); i++){           
            dataToSave.add("id:\n" +         User.getManagers().get(i).getLogin());
            dataToSave.add("password:\n" +   User.getManagers().get(i).getPassword());
            dataToSave.add("idcn:\n" +       User.getManagers().get(i).getIDCN());
            if(!"".equals(User.getManagers().get(i).getPhone()))  { dataToSave.add("phone:\n"   + User.getManagers().get(i).getPhone()); }
            if(!"".equals(User.getManagers().get(i).getEmail())){   dataToSave.add("mail:\n"    + User.getManagers().get(i).getEmail()); }
            if(!"".equals(User.getManagers().get(i).getAddress())){ dataToSave.add("address:\n" + User.getManagers().get(i).getAddress());}
            if(!"".equals(User.getManagers().get(i).getDepartment())){dataToSave.add("department:\n" + User.getManagers().get(i).getDepartment());}
            if(i+1 < User.getManagers().size()){dataToSave.add("+");}
        }
        dataToSave.add("-");
        text_file.fileWrite("list_manager.txt",dataToSave);
    }
    public static void save_data_tech(){
        List<String> dataToSave = new ArrayList<>();
        int data4_grade1=0; //we write 4 lines of name-service-hours-date and then we write the grade
        
        for(int i= 0; i<User.getTechnicians().size(); i++){           
            dataToSave.add("id:\n" +         User.getTechnicians().get(i).getLogin());
            dataToSave.add("password:\n" +   User.getTechnicians().get(i).getPassword());
            dataToSave.add("idcn:\n" +       User.getTechnicians().get(i).getIDCN());
            if(!"".equals(User.getTechnicians().get(i).getPhone()))  { dataToSave.add("phone:\n"   + User.getTechnicians().get(i).getPhone()); }
            if(!"".equals(User.getTechnicians().get(i).getEmail()))  { dataToSave.add("mail:\n"    + User.getTechnicians().get(i).getEmail()); }
            if(!"".equals(User.getTechnicians().get(i).getAddress())){ dataToSave.add("address:\n" + User.getTechnicians().get(i).getAddress());}
            if(!"".equals(User.getTechnicians().get(i).getDepartment())){dataToSave.add("department:\n" + User.getTechnicians().get(i).getDepartment());}
            
            //write the appointments not finished (WIP)
            if(!User.getTechnicians().get(i).getWIP().isEmpty()){
                dataToSave.add("wip:");
                for(String data : User.getTechnicians().get(i).getWIP()){
                    dataToSave.add(data);
                }
            }
            
            //write the appointments
            if(!User.getTechnicians().get(i).getAppointments().isEmpty()){
                dataToSave.add("appointment:");
                for(String data : User.getTechnicians().get(i).getAppointments()){
                    dataToSave.add(data);
                }
            }
            
            //write the grades
            if(User.getTechnicians().get(i).getGrades().length>0){
                dataToSave.add("grades:");
                for(int data : User.getTechnicians().get(i).getGrades()){
                    dataToSave.add(String.valueOf(data));
                }
            }
            
            //write the comments
            if(!User.getTechnicians().get(i).getComments().isEmpty()){
                dataToSave.add("comment:");
                for(String data : User.getTechnicians().get(i).getComments()){
                    dataToSave.add(data);
                }
            }
            if(i+1 < User.getTechnicians().size()){dataToSave.add("+");}
        }
        dataToSave.add("-");
        text_file.fileWrite("list_technician.txt",dataToSave);
    }
    
    public static String exist(String ID, String PWD){
        //try all files
        List<String> text_file = null;
        boolean login_find = false;
        boolean password_find = false;
        
        //try manager
        try { text_file = Files.readAllLines(Paths.get("list_manager.txt"));
        } catch (IOException ex) {
            Logger.getLogger(User_connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        for (String line_string : text_file){      // line_string is created because foreach{} need a new declaration varaiable
            if("+".equals(line_string)){        //reset password & login every users
                login_find = false;                 
                password_find = false; 
            } 
            if(line_string.equals(ID)) {login_find = true;}
            if(line_string.equals(PWD)){password_find = true;}
            if(password_find && login_find){return "M";}
        }
        
        login_find = false;                 
        password_find = false;
        
        //try customer
        try { text_file = Files.readAllLines(Paths.get("list_customer.txt"));
        } catch (IOException ex) {
            Logger.getLogger(User_connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for (String line_string : text_file){      // line_string is created because foreach{} need a new declaration varaiable
            if("+".equals(line_string)){        //reset password & login every users
                login_find = false;                 
                password_find = false; 
            } 
            if(line_string.equals(ID)) {login_find = true;} 
            if(line_string.equals(PWD)){password_find = true;}
            if(password_find && login_find){return "C";}
        } 
        
        login_find = false;                 
        password_find = false; 
        
        //try technician
        try { text_file = Files.readAllLines(Paths.get("list_technician.txt"));
        } catch (IOException ex) {
            Logger.getLogger(User_connection.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        for (String line_string : text_file){      // line_string is created because foreach{} need a new declaration varaiable
            if("+".equals(line_string)){        //reset password & login every users
                login_find = false;                 
                password_find = false; 
            } 
            if(line_string.equals(ID)) {login_find = true;}
            if(line_string.equals(PWD)){password_find = true;}
            if(password_find & login_find){return "T";}
        }            
        
        return "False";
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }    
    public static ArrayList<Customer> getCustomers() {
        return customers;
    }
    public static void setCustomers(Customer cust) {
        User.customers.add(cust);
    }
    public static ArrayList<Manager> getManagers() {
        return managers;
    }
    public static void setManagers(Manager mngr) {
        User.managers.add(mngr);
    }
    public static ArrayList<Technician> getTechnicians() {
        return technicians;
    }
    public static void setTechnicians(Technician tech) {
        User.technicians.add(tech);
    }    
    public long getIDCN() {
        return IDCN;
    }
    public void setIDCN(long IDCN) {
        this.IDCN = IDCN;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
