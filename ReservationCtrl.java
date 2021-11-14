import java.util.Scanner;

import out.production.BaseCtrl;

import java.util.ArrayList;
import java.time.LocalTime;
import java.time.LocalDate;
import java.util.Iterator;

public class ReservationCtrl extends BaseCtrl {
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
         reservationChoice = doCtrlChoice(4);
         
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
               time = sc.nextLine();
               LocalTime reservationTime = LocalTime.parse(time);
               
               System.out.println("Reservation date: ");
               String date = sc.nextLine();
               LocalDate reservationDate = LocalDate.parse(date);
                  
               //new reservation created and initialised with input from above
               Reservation newReservation = new Reservation(customerName, customerContact, customerMembership, reservationDate, reservationTime, customerSeating);
               Home.Reservations.add(newReservation);
               
               //new thread is created and run with the auto-cancel function for this reservation to be automatically cancelled after 15 minutes
               Thread t = new Thread(new Reservation(customerName, customerContact, customerMembership, reservationDate, reservationTime, customerSeating));
               t.start();
                  
               System.out.println("New Reservation created.");
               
               break;
               
            case 2: 
               //print out all existing reservations
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
   
   
   //function to cancel reservation with details as function input
   //to be used in auto-cancel function as well 
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
