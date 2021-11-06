import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;



public class TableCtrl {
   private static Scanner sc = new Scanner(System.in);

   

   public void tableOptions(){
      int choice;
      do{
         System.out.println("TABLE");
         System.out.println("(1) View tables");
         System.out.println("(2) Add table");
         System.out.println("(3) Remove table");
         System.out.println("(4) Return to previous page");
         choice = sc.nextInt();
         
         switch(choice){
            case 1:
               Iterator<Table> iter = Home.Tables.iterator();
               while (iter.hasNext()){
                  Table t = iter.next();
                  System.out.println("Table ID: " + t.getTableID());
                  System.out.println("Table Maximum Seating: " + t.getTableMax());
                  System.out.println();
               }
               
               break;
            
            case 2:
               System.out.println("Table ID: ");
               long id = sc.nextLong();
               
               System.out.println("Maximum Seating Capacity");
               int max = sc.nextInt();
               
               Table table = new Table(id, max);
               Home.Tables.add(table);
               break;
            
            case 3:
               System.out.println("Table ID to remove: ");
               long idremove = sc.nextLong();
               
               Iterator<Table> iterr = Home.Tables.iterator();
               while (iterr.hasNext()){
                  Table t = iterr.next();
                  if (t.getTableID() == idremove){
                     iterr.remove();
                     System.out.println("Table removed.");
                  }
               }
            
            case 4:
               break;
         
         }
         
      }while(choice != 4);
   
   }
}
