import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;



public class StaffCtrl {
   private static Scanner sc = new Scanner(System.in); 

   public void staffOptions(){
      int choice;
      do{
         System.out.println("STAFF");
         System.out.println("(1) View staff");
         System.out.println("(2) Add staff member");
         System.out.println("(3) Remove staff member");
         System.out.println("(4) Return to previous page");
         choice = sc.nextInt();
         
         switch(choice){
            case 1:
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
            
            case 2:
               System.out.println("Name of staff: ");
               sc.nextLine();
               String name = sc.nextLine();
               
               System.out.println("Gender of staff: (Male/Female)");
               String gender = sc.next();
               
               System.out.println("ID of staff: ");
               long id = sc.nextLong();
               
               System.out.println("Title of staff: ");
               sc.nextLine();
               String title = sc.nextLine();
               
               Staff staff = new Staff(name, gender, id, title);
               Home.Staffs.add(staff);
               
               break;
            
            case 3:
               System.out.println("Name of staff to remove: ");
               sc.nextLine();
               String nameremove = sc.nextLine();
               
               Iterator<Staff> iterremove = Home.Staffs.iterator();
               while (iterremove.hasNext()){
                  Staff s = iterremove.next();
                  if (s.getStaffName().equals(nameremove)){
                     iterremove.remove();
                     System.out.println("Staff removed.");
                  }
               }
            
            case 4:
               break;
         
         }
         
      }while(choice != 4);
   
   }
}
