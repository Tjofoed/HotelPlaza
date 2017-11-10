public class Accountant extends Staff {

      public Accountant(){
      }
    public Accountant(int StaffID, String Title, String First, String Last, int Telephone, int Salary){
        super(StaffID, Title, First, Last, Telephone, Salary);
    }

    public int getSalary() {
        return Salary + 200000;
    }


    public int getVacation() {
        return Vacation + 5;
    }


}