public class Director extends Staff {

     public Director(){
     }
   
    public Director(int StaffID, String Title, String First, String Last, int Telephone, int Salary){
        super(StaffID, Title, First, Last, Telephone, Salary);
    }

    public int getSalary() {
        return Salary + 350000;
    }
    public int getWorkingHours() {
        return WorkingHours + 15;
    }


}