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
	private String staffname;
	private Order order;
	private boolean arrived;


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
		staffname = null; 
	}

	public void autoCancel(){
		int time = LocalTime.now().toSecondOfDay() - reservationTime.toSecondOfDay();
		if(time > 1800){
			this.cancelReservation();
		}
	}

	public boolean isReserved(){
		if(this.isReserved == true) return true;
		else return false;
	}

	public Order getOrder() {
		return order;
	}

	public int getMaximumSeating() {
		return maximumSeating;
	}

	public void setStaff(String staff){
		this.staffname = staff;
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
