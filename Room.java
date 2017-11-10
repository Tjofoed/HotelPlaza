import java.util.*;
import java.io.*;
public class Room {
    Scanner console = new Scanner(System.in);
    protected String RoomType;
    private int RoomID;
    private String Internet;
    protected int price;
    private String floor;

    public Room(){
    }

    public Room(String RoomType, int RoomID, String Internet, int price, String floor) {
        this.RoomType = RoomType;
        this.RoomID = RoomID;
        this.Internet = Internet;
        this.price = price;
        this.floor = floor;
    }

    public String GetRoomType(){
        return RoomType;
    }

    public void SetRoomType(String RoomType){
        this.RoomType = RoomType;
    }

    public int GetRoomID(){
        return RoomID;
    }

    public void SetRoomID(int RoomID){
        this.RoomID = RoomID;
    }

    public String GetInternet(){
        return Internet;
    }

    public void SetInternet(String Internet){
        this.Internet = Internet;
    }

    public int Getprice(){
        return price;
    }

    public void Setprice(int price){
        this.price = price;
    }

    public String Getfloor(){
        return floor;
    }

    public void Setfloor(String floor){
        this.floor = floor;
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
        return String.format("RoomType: %s \nRoomID: %d \nInternet: %s \nprice: %d \nfloor: %s", RoomType, RoomID, Internet, price, floor);
    }

    public void saveFile(String file, Room[] RoomArray) throws Exception  {
        PrintStream outputToFile = new PrintStream(new FileOutputStream(file, true));
        String guest = String.format("%s %d %s %d %s", RoomType, RoomID, Internet, price, floor);
        outputToFile.println(guest);
        outputToFile.flush();
        outputToFile.close();
    }

    public static void saveRoomToFile(String file,Room[] RoomArray) throws Exception {
        new PrintStream(new File(file));
        for (int i = 0; i < RoomArray.length; i++) {
            if (RoomArray[i]!=null) {
                RoomArray[i].saveFile("RoomList.txt ",RoomArray);
            }
        }
    }

    public static void loadRoomFile(String file, Room[] RoomArray) throws Exception {
        Scanner scanner = new Scanner(new File(file));
        while (scanner.hasNextLine()) {
            for(int i = 0; i<LineCount(file); i++){
                RoomArray[i]=(new Room(scanner.next(), scanner.nextInt(), scanner.next(), scanner.nextInt(), scanner.next()));
                scanner.nextLine();
            }
        }
        scanner.close();
    }

}