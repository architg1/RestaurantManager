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
   
   public static void main(String args[]){
      int choice;
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
               String fullmenu = "./FullMenu.txt";
               String promotionalpackages = "./PromotionalPackages.txt";
               
               FullMenu = readFile(fullmenu);
               PromotionalPackages = readFile(promotionalpackages);
               
               MenuCtrl menu = new MenuCtrl();
               menu.MenuOptions();
               
               writeFile(fullmenu, FullMenu);
               writeFile(promotionalpackages,PromotionalPackages);
               break;
               
            case 2:
               OrderCtrl order = new OrderCtrl();
               order.createOrder();
               break;
            
            case 6:
               StaffCtrl staff = new StaffCtrl();
               
               String staffname = "./Staffs.txt";
               Staffs = readFile(staffname);
               
               staff.staffOptions();
               
               writeFile(staffname, Staffs);
               
               break;
               
            case 7:
               TableCtrl table = new TableCtrl();
               
               String tablename = "./Tables.txt";
               Tables = readFile(tablename);
               
               table.tableOptions();
               
               writeFile(tablename, Tables);
            
            
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
