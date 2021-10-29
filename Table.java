import java.time.LocalTime;
import java.time.LocalDate;
import java.util.*;
import java.util.ArrayList;

public class Table {
	public String tableIdentification;
	public boolean isReserved;
	public int maximumSeating;
	public LocalTime reservationTime;
	public LocalDate reservationDate;
	public String reservationName;
	public long reservationContact;
	public boolean reservationMembership;
	
	private Order order;
	private Staff staff;
	
	//constructor to initialise table
	public Table(String tableid, int maxseat) {
		tableIdentification=tableid;
		isReserved=false;
		maximumSeating=maxseat;
		reservationTime=null;
		reservationDate=null;
		reservationName=null;
		reservationContact=-1;
		reservationMembership=false;
		order=Order(); //empty order initialised
		staff=Staff(); //empty staff initialised
	}
	
	public void takeOrder() {
		int choice=0;
		Scanner sc	= new Scanner(System.in);
		do {
			System.out.println("What would you like to do?");
			System.out.println("1. Add an item to order");
			System.out.println("2. Add a set package to order");
			System.out.println("3. Remove an item from order");
			System.out.println("4. Remove a set package from order");
			System.out.println("5. Confirm order");
			choice=sc.nextInt();
			
			switch(choice) {
			case 1:{
				//get the menu to show all items
				order.addItem();
			}
			
			case 2:{
				//get the meny to show all set packages
				order.addSetPackage();
			}
			
			case 3:{
				order.removeItem();
			}
			
			case 4:{
				order.removeSetPackage();
			}
	
			case 5:{
				System.out.println("Order confirmed.");
				break;
			}
			
			default:{
				break;
			}
			}
		}while(choice!=5);
	}
	
	public void createInvoice() {
		Invoice invoice=new Invoice(reservationTime, order.calculateTotalCost(), reservationMembership);
		//maybe add function to calculate total cost in order class?
		
		//function to add invoice to revenue database
	}
	
}
