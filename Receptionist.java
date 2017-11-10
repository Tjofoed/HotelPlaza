public class Receptionist extends Staff {

   public Receptionist(){
   }
    public Receptionist(int StaffID, String Title, String First, String Last, int Salary, int Telephone){
        super(StaffID, Title, First, Last, Telephone, Salary);
    }


    public int getWorkingHours() {
        return WorkingHours + 5;
    }
    public int getVacation() {
        return Vacation + 5;
    }



}