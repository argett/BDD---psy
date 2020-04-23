package projet.mk2.User;

import java.util.ArrayList;

public class Technician extends User{
    static String type = "technician";
    public static String user_connected;
    private int grades[] = {};
    private String department = "";
    private ArrayList<String> WIP = new ArrayList<>();
    private ArrayList<String> appointments = new ArrayList<>();
    private ArrayList<String> comments = new ArrayList<>(); 
    
    /*
    Technician(String id, String pswrd){
        this.setLogin(id);
        this.setPassword(pswrd);
    }
    */
    
    public static void printTechnicians(Technician user){
        System.out.println("Technician:"+user.getLogin());
        System.out.println("Password : " +user.getPassword());
        System.out.println("---------");
    }
    public static String getType() {
        return type;
    }
    public static String getUser_connected() {
        return user_connected;
    }
    public static void setUser_connected(String user_connected) {
        Technician.user_connected = user_connected;
    }
    public int[] getGrades() {
        return grades;
    }    
    public void setGrades(int place, int grade) {
        this.grades[place] = grade;
    }
    public void addGrade(int grade) {
        int Length = getGrades().length;
        int temp[] = new int[Length+1];
        System.arraycopy(getGrades(), 0, temp, 0, grades.length);
        temp[Length] = grade;

        this.grades = temp;
    }
    public ArrayList<String> getWIP() {
        return WIP;
    }
    public void setWIP(String WIP) {
        this.WIP.add(WIP);
    }    
    public void transfertWIP(String name, String serv, String hour, String date) { //transfert appoint from WIP to done (in lists)
        for(int j=0; j< this.WIP.size(); j++){
            if(this.WIP.get(j).equals(name) && this.WIP.get(j+1).equals(serv) && this.WIP.get(j+2).equals(hour) && this.WIP.get(j+3).equals(date)){
                this.setAppointments(this.WIP.get(j)); //transfert in 'done' before to delete it
                this.WIP.remove(j); //cust name
                this.setAppointments(this.WIP.get(j));
                this.WIP.remove(j); //service
                this.setAppointments(this.WIP.get(j));
                this.WIP.remove(j); //hours   
                this.setAppointments(this.WIP.get(j));   
                this.WIP.remove(j); //date
                break;
            }
        }
    }    
    public ArrayList<String> getAppointments() {
        return appointments;
    }
    public void setAppointments(String appointment) {
        this.appointments.add(appointment);
    }
    public ArrayList<String> getComments() {
        return comments;
    }
    public void setComments(String comment, int place) {
        this.comments.set(place, comment);
    }    
    public void addComments(String comment) {
        this.comments.add(comment);
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
}
