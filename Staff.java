import java.util.*;
import java.io.*;
public class Staff {
    Scanner console = new Scanner(System.in);
    private int StaffID;
    private String Title;
    private String First;
    private String Last;
    protected int Salary;
    private int Telephone;
    protected int Vacation;
    protected int WorkingHours;

    public Staff(){
    }

    public Staff(int StaffID, String Title, String First, String Last, int Salary, int Telephone) {
        this.StaffID = StaffID;
        this.Title = Title;
        this.First = First;
        this.Last = Last;
        this.Salary = Salary;
        this.Telephone = Telephone;
    }

    public int GetStaffID(){
        return StaffID;
    }

    public void SetStaffID(int StaffID){
        this.StaffID = StaffID;
    }

    public String GetTitle(){
        return Title;
    }

    public void SetTitle(String Title){
        this.Title = Title;
    }

    public String GetFirstName(){
        return First;
    }

    public void SetFirstName(String FirstName){
        FirstName = First;
    }

    public String GetLastName(){
        return Last;
    }

    public void SetLastName(String LastName){
        LastName = Last;
    }

    public int GetSalary(){
        return 250000;
    }

    public void SetSalary(int Salary){
        this.Salary = Salary;
    }

    public int GetPhone(){
        return Telephone;
    }

    public void SetPhone(int Phone){
        Phone = Telephone;
    }

    public int getVacation() {
        return 25;
    }

    public void SetVacation(int Vacation){
        this.Vacation = Vacation;
    }

    public int getWorkingHours() {
        return 37;
    }

    public void SetWorkingHours(int WorkingHours){
        this.WorkingHours = WorkingHours;
    }

    public static int LineCount(String filename)throws Exception{
        Scanner file = new Scanner(new File(filename));
        int count = 0;
        while (file.hasNextLine()) {
            file.nextLine();
            count++;
        }
        return count;
    }

    public String toString() {
        return String.format("StaffID: %d \nTitle: %s \nName: %s %s \nSalary: %d \nPhoneNumber: %d", StaffID, Title, First, Last, Salary, Telephone);
    }

    public void saveFile(String file, Staff[] StaffArray) throws Exception  {
        PrintStream outputToFile = new PrintStream(new FileOutputStream(file, true));
        String guest = String.format("%d %s %s %s %d %d", StaffID, Title, First, Last, Salary, Telephone);
        outputToFile.println(guest);
        outputToFile.flush();
        outputToFile.close();
    }

    public static void saveStaffToFile(String file,Staff[] StaffArray) throws Exception {
        new PrintStream(new File(file));
        for (int i = 0; i < StaffArray.length; i++) {
            if (StaffArray[i]!=null) {
                StaffArray[i].saveFile("StaffList.txt ",StaffArray);
            }
        }
    }

    public static void loadStaffFile(String file, Staff[] StaffArray) throws Exception {
        Scanner scanner = new Scanner(new File(file));
        while (scanner.hasNextLine()) {
            for(int i = 0; i<LineCount(file); i++){
                StaffArray[i]=(new Staff(scanner.nextInt(), scanner.next(), scanner.next(), scanner.next(), scanner.nextInt(), scanner.nextInt()));
                scanner.nextLine();
            }
        }
        scanner.close();
    }

}