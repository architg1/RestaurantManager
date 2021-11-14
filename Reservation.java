import java.time.LocalTime;
import java.time.LocalDate;
import java.util.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.io.Serializable;

public class Reservation implements Serializable, Runnable
{
	
   private boolean isReserved;
   private String reservationName;
   private long reservationContact;
   private boolean reservationMembership;
   private LocalTime reservationTime;
   private LocalDate reservationDate;
   private int reservedSeating;

   private Table reserveTable;
   
   ReservationCtrl reservationctrl = new ReservationCtrl();
	
	
	//How many tables do we want? Fixed number or ArrayList flexible (table or reservation class?)
	//protected Reservation[] rList = new Reservation[20];

	//private ArrayList<Reservation> reservationList = new ArrayList<Reservation>();

	//datetime, pax,name,contact,etc

   public Reservation (String reservationName,
   					long reservationContact, 
   					boolean reservationMembership, 
   					LocalDate reservationDate, 
   					LocalTime reservationTime, int reservedSeating){
      this.reservationName = reservationName;
      this.reservationContact = reservationContact;
      this.reservationMembership = reservationMembership;
      this.reservationTime = reservationTime;
      this.reservationDate = reservationDate;
      this.reservedSeating = reservedSeating;
      this.isReserved = true;
   }
	

   public String getCustomerName()
   { 
      return this.reservationName; 
   }

   public long getCustomerContact()
   { 
      return this.reservationContact; 
   }

   public int getNumPax()
   { 
      return this.reservedSeating; 
   }

   public LocalTime getArrivalTime()
   {
      return this.reservationTime; 
   }
	
   public LocalDate getReservationDate()
   {
      return this.reservationDate;
   }


   //implementation of auto cancel function
   //to be run as a thread in ReservationCtrl class

   public void run()
   {
      while(true){
         int time = LocalTime.now().toSecondOfDay() - reservationTime.toSecondOfDay();
         if(time>=30)
         {
            reservationctrl.cancelReservation(this.reservationName, this.reservationContact);
            break;
         }
      }
   }

}
