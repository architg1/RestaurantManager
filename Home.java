import java.util.Scanner;

// driver class to run all the classes
public class Home {
   private static Scanner sc = new Scanner(System.in);
   
   public static void main(String args[]){
      // read the menu from a file
      MenuCtrl menu = new MenuCtrl();
      menu.FileReader();
   
      //  options to call the other classes
      System.out.println("What would you like to access?");
      System.out.println("(1) Menu");
      System.out.println("(2) Order");
      System.out.println("(3) Reservation");
      System.out.println("(4) Order Invoice");
      System.out.println("(5) Sale Revenue Report");
      System.out.println("(6) Exit");
      
      int choice = sc.nextInt();
      
      do{
         switch(choice){
            case 1:
               //MenuCtrl menu = new MenuCtrl();
               menu.MenuOptions();
               break;
            
            /*case 2:
               OrderCtrl order = new OrderCtrl();
               order();
               break;
               */
               
            case 6:
               break;
         }
      } while(choice != 6);
   }
}