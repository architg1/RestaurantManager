import java.util.Scanner;

//import System.out.production.BaseCtrl;

import java.util.ArrayList;
import java.util.Iterator;


public class TableCtrl extends BaseCtrl {
   private static Scanner sc = new Scanner(System.in);

   
   public void tableOptions(){
      int choice;
      do{
         System.out.println("TABLE");
         System.out.println("(1) View tables");
         System.out.println("(2) View available tables");
         System.out.println("(3) Add table");
         System.out.println("(4) Remove table");
         System.out.println("(5) Return to previous page");
         choice = doCtrlChoice(5);
         
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
               Iterator<Table> iter2 = Home.Tables.iterator();
               while (iter2.hasNext()){
                  Table t = iter2.next();
                  if(t.isReserved()==false){
                     System.out.println("Table ID: " + t.getTableID());
                     System.out.println("Table Maximum Seating: " + t.getTableMax());
                     System.out.println();
                  }
               }

               break;

            case 3:
               System.out.println("Table ID: ");
               long id = sc.nextLong();

               System.out.println("Maximum Seating Capacity: ");
               int max = sc.nextInt();
               
               Table table = new Table(id, max);
               Home.Tables.add(table);
               break;
            
            case 4:
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
            
            case 5:
               break;
         
         }
         
      }while(choice != 5);
   
   }
}
