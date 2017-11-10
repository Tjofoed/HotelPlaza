import java.util.*;
import java.io.*;
public class Hotelmain {
    public static void main(String[] args)throws Exception {
        Guest[] GuestArray = new Guest[20];
        Staff[] StaffArray = new Staff[20];
        Room[] RoomArray = new Room[20];
        Booking[] BookingArray = new Booking[20];
        Scanner input = new Scanner(System.in);

        Guest.loadGuestFile("GuestList.txt", GuestArray);
        Staff.loadStaffFile("StaffList.txt", StaffArray);
        Room.loadRoomFile("RoomList.txt", RoomArray);
        Booking.loadBookingFile("BookingList.txt", BookingArray);
        MainMenu(GuestArray, StaffArray, RoomArray, BookingArray, input);

        Staff.saveStaffToFile("StaffList.txt",StaffArray);
        Guest.saveGuestsToFile("GuestList.txt",GuestArray);
        Room.saveRoomToFile("RoomList.txt",RoomArray);
        Booking.saveBookingToFile("BookingList.txt",BookingArray);
    }
    
    public static void PrintStaff(){
    Accountant Accountant = new Accountant();
    Director Director = new Director();
    Maintenance Maintenance = new Maintenance();
    Receptionist Receptionist = new Receptionist();
    System.out.println("Accountant\n Salary = " + Accountant.getSalary() + "$\n Vacation days = "+ Accountant.getVacation() + "\n Working hours = " + Accountant.getWorkingHours());
    System.out.println("Director\n Salary = " + Director.getSalary() + "$\n Vacation days = "+ Director.getVacation() + "\n Working hours = " + Director.getWorkingHours()); 
    System.out.println("Maintenance\n Salary = " + Maintenance.GetSalary() + "$\n Vacation days = "+ Maintenance.getVacation() + "\n Working hours = " + Maintenance.getWorkingHours());
     System.out.println("Receptionist\n Salary = " + Receptionist.GetSalary() + "$\n Vacation days = "+ Receptionist.getVacation() + "\n Working hours = " + Receptionist.getWorkingHours()); 
}
    public static Guest Guest(Guest[] GuestArray, Scanner input)throws Exception{
        int GuestID = LineCount("GuestList.txt");
        System.out.println("\nGuest:\n");
        System.out.println("Enter first name : ");
        String First = input.next();
        System.out.println("Enter last name : ");
        String Last = input.next();
        System.out.println("Enter Street name : ");
        String Address = input.next();
        System.out.println("Enter Street number : ");
        IntPrint(input);
        int StreetNr = input.nextInt();
        System.out.println("Enter Zipcode: ");
        IntPrint(input);
        int Zipcode = input.nextInt();
        System.out.println("Enter phone number : ");
        IntPrint(input);
        int Telephone = input.nextInt();
        Guest Guest = new Guest(GuestID, First, Last,Telephone, Address, StreetNr, Zipcode);
        for(int i = 0; i < GuestArray.length; i++){
            GuestArray[GuestID] = Guest;
        }
        if (GuestArray[GuestID]!= null) {
            System.out.println("Your information is as follows:\n");
            System.out.println(GuestArray[GuestID] + "\n");
        }
        return Guest;
    }

    public static void ChangeGuest(String file, Guest[] GuestArray, Scanner input)throws Exception{
        System.out.println("\nChoose ID to change Guest;");
        IntPrint(input);
        int GuestID = input.nextInt();
        System.out.println("Enter first name : ");
        String First = input.next();
        System.out.println("Enter last name : ");
        String Last = input.next();
        System.out.println("Enter Street name : ");
        String Address = input.next();
        System.out.println("Enter Street number : ");
        IntPrint(input);
        int StreetNr = input.nextInt();
        System.out.println("Enter Zipcode: ");
        IntPrint(input);
        int Zipcode = input.nextInt();
        System.out.println("Enter phone number : ");
        IntPrint(input);
        int Telephone = input.nextInt();
        Guest Guest = new Guest(GuestID, First, Last,Telephone, Address, StreetNr, Zipcode);
        for(int i = 0; i < GuestArray.length; i++){
            GuestArray[GuestID] = Guest;
        }
        if (GuestArray[GuestID]!= null) {
            System.out.println(GuestArray[GuestID]);
        }
    }

    public static Staff Staff(Staff[] StaffArray, Scanner input)throws Exception{
        int StaffID = LineCount("StaffList.txt");
        System.out.println("\nStaff:\n");
        System.out.println("Enter title : ");
        String Title = input.next();
        System.out.println("Enter first name : ");
        String First = input.next();
        System.out.println("Enter last name : ");
        String Last = input.next();
        System.out.println("Enter Salary : ");
        IntPrint(input);
        int Salary = input.nextInt();
        System.out.println("Enter phone number : ");
        IntPrint(input);
        int Telephone = input.nextInt();
        Staff Staff = new Staff(StaffID,Title, First, Last, Salary, Telephone);
        for(int i = 0; i < StaffArray.length; i++){
            StaffArray[StaffID] = Staff;
        }
        if (StaffArray[StaffID]!= null) {
            System.out.println(StaffArray[StaffID]);
        }
        return Staff;
    }

    public static Staff ChangeStaff(String file, Staff[] StaffArray, Scanner input)throws Exception{
        System.out.println("\nChoose ID to change Staff;");
        IntPrint(input);
        int StaffID = input.nextInt();
        System.out.println("\nStaff:\n");
        System.out.println("Enter title : ");
        String Title = input.next();
        System.out.println("Enter first name : ");
        String First = input.next();
        System.out.println("Enter last name : ");
        String Last = input.next();
        System.out.println("Enter Salary : ");
        IntPrint(input);
        int Salary = input.nextInt();
        System.out.println("Enter phone number : ");
        IntPrint(input);
        int Telephone = input.nextInt();
        Staff Staff = new Staff(StaffID,Title, First, Last, Salary, Telephone);
        for(int i = 0; i < StaffArray.length; i++){
            StaffArray[StaffID] = Staff;
        }
        if (StaffArray[StaffID]!= null) {
            System.out.println(StaffArray[StaffID]);
        }
        return Staff;
    }

    public static Room Room(Room[] RoomArray,Scanner input)throws Exception{
        int RoomID = LineCount("RoomList.txt");
        System.out.println("\nRoom:\n");
        System.out.println("What room would you like?");
        System.out.println("1. One bed room (500$, no internet)");
        System.out.println("2. Two bed room (1000$, internet)");
        System.out.println("3. Suite (1500$, internet)");
        IntPrint(input);
        int choice = input.nextInt();
        String RoomType = "";
        int price = 0;
        String floor = "";
        String Internet = "";
        if (choice == 1) {
            System.out.println("You have chosen one bed room");
            price = 500;
            RoomType = "Onebed";
            floor = "First";
            Internet = "No";
        } else if (choice == 2) {
            System.out.println("You have chosen two bed room");
            price = 1000;
            RoomType = "Twobed";
            floor = "Second";
            Internet = "Yes";
        }else if (choice == 3) {
            System.out.println("You have chosen suite");
            price = 1500;
            RoomType = "Suite";
            floor = "Third";
            Internet = "Yes";
        }
        Room Room = new Room(RoomType, RoomID, Internet, price, floor);
        for(int i = 0; i < RoomArray.length; i++){
            RoomArray[RoomID] = Room;
        }
        if (RoomArray[RoomID]!= null) {
            System.out.println(RoomArray[RoomID]);
        }
        return Room;
    }

    public static Room ChangeRoom(String file, Room[] RoomArray,Scanner input)throws Exception{
        System.out.println("\nChoose ID to change RoomType for that ID");
        IntPrint(input);
        int RoomID = input.nextInt();
        System.out.println("\nRoom:\n");
        System.out.println("What room would you like?");
        System.out.println("1. One bed room (500$)");
        System.out.println("2. Two bed room (1000$)");
        System.out.println("3. Suite (1500$)");
        IntPrint(input);
        int choice = input.nextInt();
        String RoomType = "";
        int price = 0;
        String floor = "";
        String Internet = "";
        if (choice == 1) {
            System.out.println("\nYou have chosen one bed room\n");
            price = 500;
            RoomType = "Onebed";
            floor = "First";
            Internet = "No";
        } else if (choice == 2) {
            System.out.println("\nYou have chosen two bed room\n");
            price = 1000;
            RoomType = "Twobed";
            floor = "Second";
            Internet = "Yes";
        }else if (choice == 3) {
            System.out.println("\nYou have chosen suite\n");
            price = 1500;
            RoomType = "Suite";
            floor = "Third";
            Internet = "Yes";
        }
        Room Room = new Room(RoomType, RoomID, Internet, price, floor);
        for(int i = 0; i < RoomArray.length; i++){
            RoomArray[RoomID] = Room;
        }
        if (RoomArray[RoomID]!= null) {
            System.out.println(RoomArray[RoomID] + "\n");
        }
        return Room;
    }

    public static Booking Booking(Guest[] GuestArray,Room[] RoomArray, Booking[] BookingArray, Scanner input)throws Exception{
        int BookingID = LineCount("BookingList.txt");
        Guest Guest = Guest(GuestArray, input);
        Room Room = Room(RoomArray, input);
        System.out.println("Which day would you want to book on?");
        IntPrint(input);
        int StartDate = input.nextInt();
        System.out.println("Which day would you like to travel home?");
        IntPrint(input);
        int EndDate = input.nextInt();
        int NumberOfDays = Math.abs(EndDate-StartDate);
        Booking Booking = new Booking(BookingID,StartDate, EndDate, NumberOfDays, Room.GetRoomID(), Guest.GetGuestID());
        for(int i = 0; i < BookingArray.length; i++){
            BookingArray[BookingID] = Booking;
        }
        if (BookingArray[BookingID]!= null) {
            System.out.println(BookingArray[BookingID] + "\n");
            
            BookingReceipt(Booking,Guest,Room);

        }
        return Booking;
    }


    public static void BookingReceipt(Booking Booking, Guest Guest, Room Room){
        System.out.format("BookingID: %d%n Name: %s %s%n RoomType: %s%n StartDate: %d%n EndDate: %d%n NumberOfDays: %d%n ______________________ %n Price: %d",
                Booking.getBookingID(), Guest.GetFirstName(), Guest.GetLastName(), Room.GetRoomType(), Booking.GetStartDate(), Booking.GetEndDate(), Booking.GetNumberOfDays(), Room.Getprice()*Booking.GetNumberOfDays());
    }

    public static Booking ChangeBooking(String file, Guest[] GuestArray,Room[] RoomArray, Booking[] BookingArray, Scanner input)throws Exception{
        System.out.println("\nChoose ID to change booking for that ID");
        IntPrint(input);
        int BookingID = input.nextInt();
        System.out.println("Welcome to Booking");
        Guest Guest = Guest(GuestArray,input);
        System.out.println("Which room would you like?");
        Room Room = Room(RoomArray, input);
        System.out.println("Which day would you want to book on?");
        IntPrint(input);
        int StartDate = input.nextInt();
        System.out.println("Which day would you like to travel home?");
        IntPrint(input);
        int EndDate = input.nextInt();
        int NumberOfDays = Math.abs(EndDate-StartDate);
        Booking Booking = new Booking(BookingID,StartDate, EndDate, NumberOfDays, Room.GetRoomID(), Guest.GetGuestID());
        for(int i = 0; i < BookingArray.length; i++){
            BookingArray[BookingID] = Booking;
        }
        if (BookingArray[BookingID]!= null) {
            System.out.println(BookingArray[BookingID]);
        }
        BookingReceipt(Booking,Guest,Room);
        return Booking;
    }



    public static void MainMenu(Guest[] GuestArray, Staff[] StaffArray, Room[] RoomArray, Booking[] BookingArray, Scanner input)throws Exception{
        boolean quit = false;
        do{
            System.out.println(" \n");
            System.out.println("Welcome to HotelPlaza.\n");
            System.out.println("1. Guest menu");
            System.out.println("2. Admin menu");
            System.out.println("0. Quit");
            System.out.print("\nPlease choose menu item: ");
            IntPrint(input);
            int menuItem = input.nextInt();
            switch (menuItem) {
                case 1:
                    Booking(GuestArray, RoomArray, BookingArray, input);
                    break;
                case 2:
                    System.out.println("\nPlease enter admin password\n");
                    String password = input.next();
                    if(password.equals("123")){
                        System.out.println("\nAccess granted.\n\n");
                        AdminMenu(GuestArray, StaffArray, RoomArray, BookingArray, input);
                    }else{
                        System.out.println("\nAccess denied!\n\n");
                    }
                    break;
                case 0:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }while (!quit);
        System.out.println("Thank you and please come again!");
    }

    public static void AdminMenu(Guest[] GuestArray, Staff[] StaffArray, Room[] RoomArray, Booking[] BookingArray, Scanner input)throws Exception{
        boolean quit = false;
        do {
            System.out.println("1. Create guest");
            System.out.println("2. Change guest");
            System.out.println("3. Create staff");
            System.out.println("4. Change staff");
            System.out.println("5. Create room");
            System.out.println("6. Change room");
            System.out.println("7. Create booking");
            System.out.println("8. Change booking");
            System.out.println("9. Staff Info");
            System.out.println("9. Back to main menu");
            System.out.println("0. Quit");
            System.out.print("\nChoose menu item: ");
            int menuItem = input.nextInt();
            switch (menuItem) {
                case 1:
                    System.out.println("\nYou have chosen Create guest\n");
                    Guest(GuestArray, input);
                    break;
                case 2:
                    System.out.println("\nYou have chosen Change guest\n");
                    ChangeGuest("GuestList.txt", GuestArray, input);
                    break;
                case 3:
                    System.out.println("\nYou have chosen Create staff\n");
                    Staff(StaffArray, input);
                    break;
                case 4:
                    System.out.println("\nYou have chosen Change staff\n");
                    ChangeStaff("StaffList.txt", StaffArray, input);
                    break;
                case 5:
                    System.out.println("\nYou have chosen Create room\n");
                    Room(RoomArray, input);
                    break;
                case 6:
                    System.out.println("\nYou have chosen Change room\n");
                    ChangeRoom("RoomList.txt", RoomArray, input);
                    break;
                case 7:
                    System.out.println("\nYou have chosen Create booking\n");
                    Booking(GuestArray, RoomArray, BookingArray, input);
                    break;
                case 8:
                    System.out.println("\nYou have chosen Change booking\n");
                    ChangeBooking("BookingList.txt", GuestArray, RoomArray, BookingArray, input);
                    break;
                    case 9:
                    System.out.println("\nYou have chosen to Staff Info\n\n");
                    PrintStaff();
                    break;
                case 10:
                    System.out.println("\nYou have chosen Back to main menu\n\n");
                    MainMenu(GuestArray, StaffArray, RoomArray, BookingArray, input);
                    break;
                case 0:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (!quit);
        System.out.println("Thank you and please come again!");
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

    public static String IntPrint(Scanner input){
        String number =null;
        while (!input.hasNextInt()) {
            number = input.next();
            System.out.println("Invalid input please enter number");
        }
        return number;
    }

}