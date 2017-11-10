public class Maintenance extends Staff {

   public Maintenance (){
   }

    public Maintenance(int StaffID, String Title, String First, String Last, int Telephone, int Salary){
        super(StaffID, Title, First, Last, Telephone, Salary);
    }


    public int getVacation() {
        return Vacation + 10;
    }


}