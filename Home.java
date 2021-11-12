import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

// driver class to run all the classes
public class Home {
   private static Scanner sc = new Scanner(System.in);
   
   public static ArrayList<Item> FullMenu = new ArrayList<Item>();
   public static ArrayList<PromotionalPackage> PromotionalPackages = new ArrayList<PromotionalPackage>();
   public static ArrayList<Staff> Staffs = new ArrayList<Staff>();
   public static ArrayList<Table> Tables = new ArrayList<Table>();
   public static ArrayList<Order> Orders = new ArrayList<Order>();
   public static ArrayList<Reservation> Reservations = new ArrayList<Reservation>();
   
   
   public static void main(String args[]){
      int choice;
      
      // read all the arraylists from files
      MenuCtrl menu = new MenuCtrl();
      String fullMenu = "./FullMenu.txt";
      String promotionalPackages = "./PromotionalPackages.txt";
      FullMenu = readFile(fullMenu);
      PromotionalPackages = readFile(promotionalPackages);
      
      StaffCtrl staff = new StaffCtrl();
      String staffName = "./Staffs.txt";
      Staffs = readFile(staffName);
      
      TableCtrl table = new TableCtrl();
      String tableName = "./Tables.txt";
      Tables = readFile(tableName);
      
      OrderCtrl order = new OrderCtrl();
      String orderName = "./Order.txt";
      Orders = readFile(orderName);
      
      ReservationCtrl reservation = new ReservationCtrl();
      String reservationName = "./Reservation.txt";
      Reservations = readFile(reservationName);

      String invoiceFile = "./Invoice.txt";
   
      //  options to call the other classes
      do{
         System.out.println("What would you like to access?");
         System.out.println("(1) Menu");
         System.out.println("(2) Order");
         System.out.println("(3) Reservation");
         System.out.println("(4) Order Invoice");
         System.out.println("(5) Sale Revenue Report");
         System.out.println("(6) Staff");
         System.out.println("(7) Table");
         System.out.println("(8) Exit");
         
         choice = sc.nextInt();
         switch(choice){
            case 1:
               menu.MenuOptions();
            
               writeFile(fullMenu, FullMenu);
               writeFile(promotionalPackages,PromotionalPackages);
               break;
               
            case 2:
               order.createOrder();
               
               writeFile(orderName, Orders);
               break;
               
            case 3: 
               reservation.createReservation();
               
               writeFile(reservationName, Reservations);
               break;
            
            case 6:
               staff.staffOptions();
               
               writeFile(staffName, Staffs);
               break;
               
            case 7:
               table.tableOptions();
               
               writeFile(tableName, Tables);
            
            
               break;
            
            case 8:
               break;
         }
      } while(choice != 8);
   }
   
// Read arraylists from a file
   public static <T> ArrayList<T> readFile(String fileName) {
      ArrayList<T> arrayList = new ArrayList<T>();
   
      try {
                     
         FileInputStream fis = new FileInputStream(fileName);
         ObjectInputStream ois = new ObjectInputStream(fis);
      
         arrayList = (ArrayList) ois.readObject();
      
         ois.close();
         fis.close();
         return arrayList;
      } catch (IOException ioe) {
         ioe.printStackTrace();
         return arrayList; 
      } 
      catch (ClassNotFoundException c) 
      {
         System.out.println("Class not found");
         c.printStackTrace();
         return arrayList;
      }
   }
   
   // Write arraylists into a file
   public static <T> void writeFile(String file, ArrayList<T> arraylist){
      try
      {
         FileOutputStream fos = new FileOutputStream(file);
         ObjectOutputStream oos = new ObjectOutputStream(fos);
         oos.writeObject(arraylist);
         oos.close();
         fos.close();
      } 
      catch (IOException ioe) 
      {
         ioe.printStackTrace();
      }
   }

}
