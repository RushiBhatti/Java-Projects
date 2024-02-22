import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class Patient{
    private String name , mobileNo , address , disease;
    private int priority;
    public ArrayList<Patient> p = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Patient(){}

    public Patient(String name , String disease , int priority){
        this.name = name;
        this.disease = disease;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Patient Name: "+this.name+" || Disease: "+this.disease+" || with Priority: "+this.priority ;
    }

    // Menu Methods
    public void addPatient(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Name : ");
        String name = sc.nextLine();
        System.out.print("Enter Disease : ");
        String disease = sc.nextLine();
        System.out.print("Enter Priority : ");
        int priority = sc.nextInt();
        p.add(new Patient(name , disease , priority));
        System.out.println(name.toUpperCase() + " added Successfully as a Patient...");
        p.sort(new PatientPriorityComparator());
    }

    public void removePatient(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Name : ");
        String name = sc.nextLine();
        for(Patient pt : p){
            if(pt.getName().equals(name)){
                p.remove(pt);
                System.out.println(name.toUpperCase() + " removed Successfully...");
                break;
            }
        }
        System.out.println("* No entry exists for this patient..!");
    }

    public void searchPatient(){
        if(p.isEmpty()){
            System.out.println("*No patients for Now..!");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Name : ");
        String name = sc.nextLine();
        for(Patient pt : p){
            if(pt.getName().equalsIgnoreCase(name)){
                System.out.println(pt);
                break;
            }
        }
        System.out.println("* No entry exists for this patient..!");
    }

    public void viewPatients(){
        if(p.isEmpty()){
            System.out.println("*No patients for Now..!");
            return;
        }

        for(Patient pt : p){
                System.out.println(pt);
        }
    }
}

class PatientPriorityComparator implements Comparator<Patient>{
    public int compare(Patient p1 , Patient p2){
        if(p1.getPriority() == p2.getPriority()) return 0;
        else if (p1.getPriority() > p2.getPriority()) {
            return -1;
        }else return 1;
    }
}

public class PatientManagement {

    static void menu(){
        System.out.println("Options :");
        System.out.println("\t1. Add Patient");
        System.out.println("\t2. Remove Patient");
        System.out.println("\t3. Search Patient");
        System.out.println("\t4. View Patients(Sorted by Priority)");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        menu();
        int t;

        Patient p1 = new Patient();

        do{
            System.out.println("\n--------------------------------------------");
            System.out.print("\tEnter choice : ");
            int ch = sc.nextInt();

            switch (ch){
                case 1 -> p1.addPatient();
                case 2 -> p1.removePatient();
                case 3 -> p1.searchPatient();
                case 4 -> p1.viewPatients();
                default -> System.out.println("***Enter Valid Choice!");
            }

            System.out.print("Enter 0 to exit & 1 to continue : ");
            t = sc.nextInt();
        }while (t!=0);

    }
}