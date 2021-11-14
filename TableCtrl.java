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
               Iterator<Table> tableIterator = Home.Tables.iterator();
               while (tableIterator.hasNext()){
                  Table t = tableIterator.next();
                  System.out.println("Table ID: " + t.getTableID());
                  System.out.println("Table Maximum Seating: " + t.getTableMax());
                  System.out.println();
               }
               
               break;

            case 2:
               Iterator<Table> iterator = Home.Tables.iterator();
               while (iterator.hasNext()){
                  Table t = iterator.next();
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
               System.out.println("Table added.");

               break;
            
            case 4:
               System.out.println("Table ID to remove: ");
               long idRemove = sc.nextLong();
               
               Iterator<Table> iterator1 = Home.Tables.iterator();
               while (iterator1.hasNext()){
                  Table t = iterator1.next();
                  if (t.getTableID() == idRemove){
                     iterator1.remove();
                     System.out.println("Table removed.");
                  }
               }
               System.out.println("Table does not exist"); // new
               break; // new

            case 5:
               break;
         
         }
         
      }while(choice != 5);
   
   }
}
