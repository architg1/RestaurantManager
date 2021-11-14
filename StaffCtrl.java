import java.util.Scanner;

//import out.production.BaseCtrl;

import java.util.ArrayList;
import java.util.Iterator;


public class StaffCtrl extends BaseCtrl {
   private static Scanner sc = new Scanner(System.in); 

   public void staffOptions(){
      //control class function
      int choice;
      do{
         System.out.println("STAFF");
         System.out.println("(1) View staff");
         System.out.println("(2) Add staff member");
         System.out.println("(3) Remove staff member");
         System.out.println("(4) Return to previous page");
         choice = doCtrlChoice(4);
         
         switch(choice){
            case 1:
               //print out details of every staff member
               Iterator<Staff> iter = Home.Staffs.iterator();
               while (iter.hasNext()){
                  Staff s = iter.next();
                  System.out.println("Staff Name: " + s.getStaffName());
                  System.out.println("Staff Gender: " + s.getStaffGender());
                  System.out.println("Staff ID: " + s.getStaffID());
                  System.out.println("Staff Title: " + s.getStaffTitle());
                  System.out.println();
               }
               
               break;
            
            //create and add new staff member 
            case 2:
               System.out.println("Name of staff: ");
               //sc.nextLine();
               String name = sc.nextLine();
               
               System.out.println("Gender of staff: (Male/Female)");
               String gender = sc.next();
               
               System.out.println("ID of staff: ");
               long id = sc.nextLong();
               
               System.out.println("Title of staff: ");
               sc.nextLine();
               String title = sc.nextLine();
            
               System.out.println("Maximum Tables the staff can serve: ");
               int maxTables = sc.nextInt();
            
               Staff staff = new Staff(name, gender, id, title, maxTables);
               Home.Staffs.add(staff);
               
               break;
            
              //remove staff member from collection in driver class
            case 3:
               System.out.println("Name of staff to remove: ");
               sc.nextLine();
               String nameRemove = sc.nextLine();
               
               Iterator<Staff> iterRemove = Home.Staffs.iterator();
               while (iterRemove.hasNext()){
                  Staff s = iterRemove.next();
                  if (s.getStaffName().equals(nameRemove)){
                     iterRemove.remove();
                     System.out.println("Staff removed.");
                  }
               }
               System.out.println("Staff does not exist"); // new
               break; // new

               //return to previous interface
            case 4:
               break;
         
         }
         
      }while(choice != 4);
   
   }
}
