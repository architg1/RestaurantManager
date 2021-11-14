import java.time.LocalTime;
import java.time.LocalDate;
import java.io.Serializable;


public class Table implements Serializable {
   private long tableID;
   private boolean isReserved;
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

   public void tableEmpty(){ this.isReserved = false;}
   

  
   public boolean isReserved(){
      if(this.isReserved == true) 
         return true;
      else 
         return false;
   }

   public boolean isReservationMembership(){
      return reservationMembership;
   }

	
}
