import java.util.*;
import java.io.*;
public class Booking {
    protected int BookingID;
    protected int  StartDate;
    protected int  EndDate;
    protected int  NumberOfDays;
    Room room = new Room();
    Guest guest = new Guest();
    private int RoomID;
    private int GuestID;

    public Booking(){
    }

    public Booking(int BookingID ,int StartDate, int EndDate, int NumberOfDays, int RoomID, int GuestID) {
        this.BookingID = BookingID;
        this.StartDate = StartDate;
        this.EndDate = EndDate;
        this.NumberOfDays = NumberOfDays;
        this.RoomID = RoomID;
        this.GuestID= GuestID;
    }

    public int getBookingID() {
        return BookingID;
    }

    public void SetBookingID(int BookingID) {
        this.BookingID = BookingID;
    }

    public int GetStartDate(){
        return StartDate;
    }

    public void SetStartDate(int StartDate){
        this.StartDate = StartDate;
    }

    public int GetEndDate(){
        return EndDate;
    }

    public void SetEndDate(int EndDate){
        this.EndDate = EndDate;
    }

    public int GetNumberOfDays(){
        return NumberOfDays;
    }

    public void SetNumberOfDays(int NumberOfDays){
        this.NumberOfDays = NumberOfDays;
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
        return String.format("BookingID: %d \nStartDate: %d \nEndDate: %d \nNumberOfDays: %d \nRoomID: %d \nGuestID %d", BookingID, StartDate, EndDate, NumberOfDays, RoomID,GuestID);
    }



    public void saveFile(String file, Booking[] BookingArray) throws Exception  {
        PrintStream outputToFile = new PrintStream(new FileOutputStream(file, true));
        String bookingp = String.format("%d %d %d %d %d %d", BookingID, StartDate, EndDate, NumberOfDays, RoomID,GuestID );
        outputToFile.println(bookingp);
        outputToFile.flush();
        outputToFile.close();
    }


    public static void saveBookingToFile(String file,Booking[] BookingArray) throws Exception {
        new PrintStream(new File(file));
        for (int i = 0; i < BookingArray.length; i++) {
            if (BookingArray[i]!=null) {
                BookingArray[i].saveFile("BookingList.txt",BookingArray);
            }
        }
    }


    public static void loadBookingFile(String file, Booking[] BookingArray) throws Exception {
        Scanner scanner = new Scanner(new File(file));
        while (scanner.hasNextLine()) {
            for(int i = 0; i<LineCount(file); i++){
                BookingArray[i]=(new Booking(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
                scanner.nextLine();
            }
        }
        scanner.close();
    }

}