import java.time.LocalTime;
import java.util.*;
import java.util.ArrayList;
import java.util.Calendar;;

public class Reservation implements Table //Is this correct use?
{
	
	Table table;
	
	private Calendar orderDateTime; //Check to see how we want to standardize the date time formats
	private int seatsBooked;
	private String reservationName;
	private String tableID;
	private long int reservationContact;
	private boolean isSuccess;
	private boolean isMember;
	private int tableID;
	private int reservationID;
	
	//How many tables do we want? Fixed number or ArrayList flexible (table or reservation class?)
	private Reservation[] rList = new Reservation[20];

	//private ArrayList<Reservation> reservationList = new ArrayList<Reservation>();

	//datetime, pax,name,contact,etc
	/**
	 * 
	 * @param tableID
	 * @param name
	 * @param dateTime
	 * @param contact
	 * @param membership
	 * @param seatingPax
	 */
	public void makeReservation(String tableID, String name, 
			Calendar dateTime, long int contact, 
			boolean membership, int seatingPax, int tableNo) 
	{
		// TODO - implement Reservation.makeReservation
		if(rList[tableNo] == null)
		{
			
			rList[tableNo].tableID = tableId;
			rList[tableNo].reservationName = name;
			rList[tableNo].orderDateTime = dateTime;
			rList[tableNo].reservationContact = contact;
			rList[tableNo].isMember = membership;
			rList[tableNo].seatsBooked = seatingPax;
			
			System.out.println("Booking Success");
			//tList[tableNo]
		}
		else
		{
			System.out.println("error unable to reserved table");
		}
		
		
		throw new UnsupportedOperationException();
	
	}
	
	/*
	public void assignReservation(int tableNo)
	{
		
	}*/
	
	/**
	 * 
	 * @param tableID
	 */
	public void cancelReservation(int tableNo) 
	{
		// TODO - implement Reservation.cancelReservation
		
		if(tableNo > rList.length)
		{
			System.out.println("Error, table does not exist");
		}
		else
		{
			rList[tableNo] = null;
			System.out.println("Cancellation is successful");
		}
		
		
		throw new UnsupportedOperationException();
	}

}