package projet.mk2.User;

public class Manager extends User{
    static String type = "manager";
    private String department = "";
    private static int payments_collected = 0;
    public static String user_connected; 
    
    /*
    Manager(String id, String pswrd){
        this.setLogin(id);
        this.setPassword(pswrd);
    }
    */
    
    public static void printManagers(Manager user){
        System.out.println("Manager : "+user.getLogin());
        System.out.println("Password: "+user.getPassword());
        System.out.println("---------");
    }   
    
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }    
    public static int getPayments_collected() {     
        return payments_collected;
    }
    public static void addPayments_collected(int payment) {
        Manager.payments_collected += payment;
    }    
    public static void setPayments_collected(int payment) {
        Manager.payments_collected = payment;
    }
}
