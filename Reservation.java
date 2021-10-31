import java.time.LocalTime;
import java.util.*;
import java.util.ArrayList;
import java.util.Calendar;;

public class Reservation
{
	
	Table table;
	
	protected Calendar orderDateTime; //Check to see how we want to standardize the date time formats
	protected int seatsBooked;
	protected String reservationName;
	protected String tableID;
	protected long reservationContact;
	protected boolean isSuccess;
	protected boolean isMember;
	//private int tableID;
	protected int reservationID;
	
	//How many tables do we want? Fixed number or ArrayList flexible (table or reservation class?)
	protected Reservation[] rList = new Reservation[20];

	//private ArrayList<Reservation> reservationList = new ArrayList<Reservation>();

	//datetime, pax,name,contact,etc

	public void makeReservation(String tableID, String name, 
			Calendar dateTime, long contact,
			boolean membership, int seatingPax, int tableNo) 
	{
		// TODO - implement Reservation.makeReservation
		if(rList[tableNo] == null)
		{
			
			rList[tableNo].tableID = tableID;
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
	 * //@param tableID
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