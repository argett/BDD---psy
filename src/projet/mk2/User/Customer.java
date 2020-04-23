package projet.mk2.User;

import java.util.ArrayList;

public class Customer extends User{
    static String type = "customer";
    private String askApptmnt[] = new String[2]; //name of customer inside if yes
    private ArrayList<String> appointments = new ArrayList<>();
    private ArrayList<String> feedBacks = new ArrayList<>();
    private int payments[] = {} ;
    private int status[] = {};
    public static String user_connected;   
    
    /*
    Customer(String id, String pswrd){
        this.setLogin(id);
        this.setPassword(pswrd);
    }
    */
    
    public static void printCustomers(Customer user){
        System.out.println("Customer : "+user.getLogin());
        System.out.println("Password: " +user.getPassword());
        System.out.println("---------");
    }
    public ArrayList<String> getAppointments() {
        return appointments;
    }
    public void setAppointments(String appointments) {
        this.appointments.add(appointments);
    }   
    public ArrayList<String> getFeedBack() {
        return feedBacks;
    }
    public void setFeedBack(String feedback) {
        this.feedBacks.add(feedback);
    }    
    public void modifyFeedbacks(String feedback, int range) {
        this.feedBacks.set(range, feedback);
    }
    public int[] getPayments() {     
        return payments;
    }
    public void setPayments(int payment) {
        int Length = getPayments().length;
        int temp[] = new int[Length+1];
        
        System.arraycopy(getPayments(), 0, temp, 0, payments.length);
        temp[Length] = payment;

        this.payments = temp;
    }  
    public static String getType() {
        return type;
    }
    public static void setType(String type) {
        Customer.type = type;
    }
    public static String getUser_connected() {
        return user_connected;
    }
    public static void setUser_connected(String user_connected) {
        Customer.user_connected = user_connected;
    }    
    public String[] getAskApptmnt() {
        return askApptmnt;
    }
    public void setAskApptmnt(String user, String service) {
        this.askApptmnt[0] = user;
        this.askApptmnt[1] = service;
    }
    public int getStatus(int i) {
        //because i cant make 'status[i]' i dont know why, i use this ridiculous way
        int cpt = 0;
        for(int a : status){
            if(cpt == i){
                return a;
            }
            cpt++;
        }
        return -1;
    }    
    public int[] getStatusGeneral() {
        return status;
    }
    public void setStatus(int stat) {
        int Length = getStatusGeneral().length;
        int temp[] = new int[Length+1];
        System.arraycopy(getStatusGeneral(), 0, temp, 0, status.length);
        temp[Length] = stat;

        this.status = temp;
    }    
    public void modifStatus(int place) {
        this.status[place] = 1;
    }
}

