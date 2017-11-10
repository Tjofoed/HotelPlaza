import java.util.*;
import java.io.*;
public class Guest {
   Scanner console = new Scanner(System.in);
   private int GuestID;
   private String First;
   private String Last;
   private int Telephone;
   private String Address;
   private int StreetNr;
   private int Zipcode;

   public Guest(){
   }
      
   public Guest(int GuestID, String First, String Last, int Telephone, String Address, int StreetNr, int Zipcode) {
   	this.GuestID = GuestID;
      this.First = First;
   	this.Last = Last;
   	this.Telephone = Telephone;
      this.Address = Address;
      this.StreetNr = StreetNr;
      this.Zipcode = Zipcode;
   }
   
   public int GetGuestID(){
	   return GuestID;
   }

   public void SetGuestID(int GuestID){
	   this.GuestID = GuestID;
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
	   LastName=Last;
   }
   
   public String GetAddress(){
   	return Address;
   }
   
   public void SetAddress(String Address){
	   this.Address = Address;
   }
   
   public int GetPhone(){
   	return Telephone;
   }
   
   public void SetPhone(int Phone){
	   Phone = Telephone;
   }
   
   public void SetStreetNr(int StreetNr){
	   this.StreetNr = StreetNr;
   }
   
   public int GetStreetNr(){
   	return StreetNr;
   }
   
   public void SetZipcode(int Zipcode){
	   this.Zipcode = Zipcode;
   }
   
   public int GetZipcode(){
   	return Zipcode;
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
   	return String.format("GuestID: %-8d \nName: %s %-8s \nAddress: %s %d %d \nPhoneNumber: %d ", GuestID, First, Last, Address, StreetNr, Zipcode, Telephone);
   }
   
   public void saveFile(String file, Guest[] GuestArray) throws Exception  {
      PrintStream outputToFile = new PrintStream(new FileOutputStream(file, true));
      String guest = String.format("%d %s %s %d %s %d %d", GuestID, First, Last, Telephone, Address, StreetNr, Zipcode);
      outputToFile.println(guest);
      outputToFile.flush();
      outputToFile.close();
   }   
       
   public static void saveGuestsToFile(String file,Guest[] GuestArray) throws Exception {
      new PrintStream(new File(file));
      for (int i = 0; i < GuestArray.length; i++) {
         if (GuestArray[i]!=null) {
         GuestArray[i].saveFile("GuestList.txt ",GuestArray);
         }
      }
   }
  
   public static void loadGuestFile(String file, Guest[] GuestArray) throws Exception {
      Scanner scanner = new Scanner(new File(file));
      while (scanner.hasNextLine()) {
         for(int i = 0; i<LineCount(file); i++){
         GuestArray[i]=(new Guest(scanner.nextInt(), scanner.next(), scanner.next(), scanner.nextInt(), scanner.next(), scanner.nextInt(), scanner.nextInt()));
         scanner.nextLine();
         }
      }
      scanner.close();
   }

}