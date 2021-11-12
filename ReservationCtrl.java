import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalTime;
import java.time.LocalDate;
import java.util.Iterator;

public class ReservationCtrl {
   Scanner sc = new Scanner(System.in);
  
   public void createReservation(){

      //create new reservation and add to reservation arraylist
      int reservationChoice;

      do{
         System.out.println("Reservation");
         System.out.println("(1) Create a new reservation.");
         System.out.println("(2) View reservations.");
         System.out.println("(3) Remove reservations.");
         System.out.println("(4) Return to home page.");
         reservationChoice = sc.nextInt();
         
         switch(reservationChoice){
            case 1:
               System.out.println("Name of customer: ");
               sc.nextLine();
               String customerName = sc.nextLine();
               
               System.out.println("Contact of customer: ");
               long customerContact = sc.nextLong();
               
               System.out.println("Customer membership: (True/False) ");
               boolean customerMembership = sc.nextBoolean();
               
               System.out.println("Number of seats: ");
               int customerSeating = sc.nextInt();
               
               System.out.println("Estimated arrival time: ");
               String time = sc.nextLine();
               LocalTime reservationTime = LocalTime.parse(time);
               
               System.out.println("Reservation date: ");
               String date = sc.nextLine();
               LocalDate reservationDate = LocalDate.parse(date);
                  
               Reservation newReservation = new Reservation(customerName, customerContact, customerMembership, reservationDate, reservationTime, customerSeating);
               Home.Reservations.add(newReservation);
                  
               System.out.println("New Reservation created.");
               
               break;
               
            case 2: 
               Iterator<Reservation> iter = Home.Reservations.iterator();
               while (iter.hasNext()){
                  Reservation r = iter.next();
                  System.out.println("Reservation Name: " + r.getCustomerName());
                  System.out.println("Reservation Contact: " + r.getCustomerContact());
                  System.out.println("Reservation Seating: " + r.getNumPax());
                  System.out.println("Reservation Arrival Time: " + r.getArrivalTime());
                  System.out.println("Reservation Date: " + r.getReservationDate());
                  System.out.println();
               }
               
               break;
               
            case 3:
               System.out.println("Name of customer to remove reservation: ");
               String removeName = sc.nextLine();
               
               System.out.println("Contact of customer to remove reservation: ");
               long removeContact = sc.nextLong();
               
               cancelReservation(removeName,removeContact);
            
               break;
               
            case 4:
               break;
         }
      } while (reservationChoice != 4);
   }
   
   public void cancelReservation(String removeName, long removeContact){
               Iterator<Reservation> iterr = Home.Reservations.iterator();
               while (iterr.hasNext()){
                  Reservation r = iterr.next();
                  if (r.getCustomerName().equals(removeName)){
                     if (r.getCustomerContact() == removeContact){
                        iterr.remove();
                        System.out.println("Reservation removed.");
                     }
                  }
               }
   }
}
