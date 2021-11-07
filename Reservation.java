import java.time.LocalTime;
import java.time.LocalDate;
import java.util.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.io.Serializable;

public class Reservation implements Serializable;
{
	
	//Table table;
	/*
	protected Calendar orderDateTime; //Check to see how we want to standardize the date time formats
	protected int seatsBooked;
	protected String reservationName;
	protected String tableID;
	protected long reservationContact;
	protected boolean isSuccess;
	protected boolean isMember;
	protected int reservationID;
	*/
	
	private boolean isReserved;
	private String reservationName;
	private long reservationContact;
	private boolean reservationMembership;
	private LocalTime reservationTime;
	private LocalDate reservationDate;
	private int reservedSeating;

	private Table reserveTable;
	
	
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
	}
	
	/**
	 * get the name of the customer who made this reservation
	 * @return this reservation's name
	 */
	public String getCustomerName()
	{ 
		return this.reservationName; 
	}
	
	/**
	 * get the contact number of the customer who made this reservation
	 * @return this reservation's contact number
	 */
	public int getCustomerContact()
	{ 
		return this.reservationContact; 
	}
	
	/**
	 * get the number of expected people for this reservation
	 * @return this reservation's number of expected people
	 */
	public int getNumPax()
	{ 
		return this.reservedSeating; 
	}
	
	
	/**
	 * get the expected arrival time of this reservation
	 * @return this reservation's expected arrival time
	 */
	public LocalTime getArrivalTime()
	{
		return this.reservationTime; 
	}
	
	public LocalDate getReservationDate()
	{
		return this.reservationDate;
	}

	

}
