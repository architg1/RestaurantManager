import java.time.LocalTime;
import java.time.LocalDate;
import java.util.*;
import java.util.ArrayList;
import java.io.Serializable;


public class Table implements Serializable {
   private long tableID;
   public boolean isReserved;
   private int maximumSeating;
   private int reservedSeating;
   private LocalTime reservationTime;
   private LocalDate reservationDate;
   private String reservationName;
   private long reservationContact;
   private boolean reservationMembership;
   private Staff staff;
   private boolean arrived;
   
   public Table(long tableID, int maximumSeating) {
      this.tableID = tableID;
      isReserved = false;
      this.maximumSeating = maximumSeating;
      reservationTime = null;
      reservationDate = null;
      reservationName = null;
      reservationContact = -1;
      reservationMembership = false;
      //Staff staff= new Staff(); //empty staff initialised
   }
   
   public long getTableID(){
      return this.tableID;
   }
   
   public int getTableMax(){
      return this.maximumSeating;
   }

   public LocalTime getReservationTime(){
      return this.reservationTime;
   }

   public LocalDate getReservationDate(){
      return this.reservationDate;
   }

   public long getReservationContact(){
      return this.reservationContact;
   }

   public String getStaffName(){
      return this.staff.getStaffName();
   }
   
   //dont need this function anymore, auto cancel implemented in reservation
   /*
   public void autoCancel(){
      int time = LocalTime.now().toSecondOfDay() - reservationTime.toSecondOfDay();
      if(time > 1800){
         this.cancelReservation();
      }
   }*/
  
   public boolean isReserved(){
      if(this.isReserved == true) 
         return true;
      else 
         return false;
   }

   public boolean isReservationMembership(){
      return reservationMembership;
   }

   public int getMaximumSeating() {
      return maximumSeating;
   }

   public void setStaff(Staff staff){
      this.staff = staff;
   }


   public void reserveTable(String reservationName, long reservationContact, boolean reservationMembership, LocalDate reservationDate, LocalTime reservationTime, int reservedSeating){
      this.reservationName = reservationName;
      this.reservationContact = reservationContact;
      this.reservationMembership = reservationMembership;
      this.reservationTime = reservationTime;
      this.reservationDate = reservationDate;
      this.reservedSeating = reservedSeating;
      this.isReserved = true;
   }

   public void cancelReservation(){
      this.isReserved = false;
      this.reservedSeating = 0;
   }
	
}
