import java.time.LocalTime;
import java.time.LocalDate;
import java.util.*;
import java.util.ArrayList;

public class Table {
	private long tableIdentification;
	private boolean isReserved;
	private int maximumSeating;
	private int reservedSeating;
	private LocalTime reservationTime;
	private LocalDate reservationDate;
	private String reservationName;
	private long reservationContact;
	private boolean reservationMembership;
	private Staff staff;


	private Order order;


	public Table(long tableIdentification, int maximumSeating) {
		this.tableIdentification = tableIdentification;
		isReserved = false;
		this.maximumSeating = maximumSeating;
		reservationTime = null;
		reservationDate = null;
		reservationName = null;
		reservationContact = -1;
		reservationMembership = false;
		Order order = new Order(); //empty order initialised
		Staff staff= new Staff(); //empty staff initialised
	}

	public boolean isReserved(){
		if(this.isReserved == true) return true;
		else return false;
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

	
	public void createInvoice() {
		//Invoice invoice=new Invoice(reservationTime, 0, reservationMembership);
		//maybe add function to calculate total cost in order class?
		
		//function to add invoice to revenue database
	}
	
}
