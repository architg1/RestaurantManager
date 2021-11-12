import java.time.LocalDate;
import java.time.LocalTime;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Invoice {

	private LocalTime timestamp = LocalTime.now();
	private LocalDate datestamp = LocalDate.now();
	private Integer totalCost;
	private Boolean discount;


	public void createInvoice(Order order) {
		try{
			FileWriter invoice = new FileWriter("invoice.txt");
			// BASIC DETAILS
			invoice.write("b,"); // MARKS BASIC DETAILS
			// Table ID
			invoice.write(String.valueOf(order.table.getTableID())); invoice.write(',');
			// Current date
			invoice.write(String.valueOf(datestamp)); invoice.write(',');
			// Current time
			invoice.write(String.valueOf(timestamp)); invoice.write(',');
			// Reservation contact
			invoice.write(String.valueOf(order.table.getReservationContact())); invoice.write(',');
			// Staff name
			invoice.write(String.valueOf(order.table.getStaffName())); invoice.write(',');

			// INDIVIDUAL ITEMS
			invoice.write("o,"); // MARKS ORDER DETAILS
			individualDetails(order, invoice);

			// TOTAL PRICE before GST
			invoice.write("pr,");
			invoice.write(String.valueOf(calculateTotalPrice(order)));
			// TOTAL PRICE AFTER GST
			invoice.write("fpr,");
			invoice.write(String.valueOf(calculateTotalPrice(order)*1.07*1.10));
			// NEW LINE
			invoice.write('\n');

			// SAMPLE FORMAT
			// b,12345,12/12,12:12,85877321,James,o,i,Pizza,Very Tasty,MAINS,800,i,Fries,Long Potato,STARTERS,500,
			// p,House Special,Best meal in NTU,100,pi,Ice cream,Cold,DESSERT,200,pi,Chips,Lays,STARTERS,50,pr,1000,fpr,800

		}
		catch(IOException e){
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		throw new UnsupportedOperationException();
	}

	public double calculateTotalPrice(Order order){
		double cost_item = 0;
		double cost_package = 0;
		for (Item item: order.orderItems){
			if(order.table.isReservationMembership()){
				cost_item += item.getPrice()*0.9; // 10% discount
			}
			else{
				cost_item += item.getPrice();
			}

		}
		for(PromotionalPackage setPackage: order.orderPackages){
			if(order.table.isReservationMembership())
				cost_package += setPackage.getPackagePrice()*0.9; // 10% discount
			else
				cost_package += setPackage.getPackagePrice();
		}

		double total_cost = cost_item + cost_package;
		return total_cost;
	}

	public void individualDetails(Order order, FileWriter file){

		try{
			boolean isMember = order.table.isReservationMembership();

			// ITEMS
			for(Item item : order.orderItems){
				file.write("i,"); // marks the beginning of each item
				writeItem(item, file, isMember);
			}

			// PACKAGES
			file.write("p,");
			for(PromotionalPackage packages: order.getOrderPackages()){
				file.write(packages.getPackageName());
				file.write(packages.getPackageDescription());

				if(isMember)
					file.write(String.valueOf(packages.getPackagePrice()*0.90));
				else
					file.write(String.valueOf(packages.getPackagePrice()));

				for(Item item: packages.packageItems){
					file.write("pi,");
					writeItem(item, file, isMember);
				}
			}
		}

		catch(IOException e){
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}

	public void writeItem(Item item, FileWriter file, boolean isMember){

		try{

			file.write(item.name);
			file.write(item.description);
			file.write(String.valueOf(item.category));

			if(isMember){
				file.write(String.valueOf(item.getPrice()*0.9)); // 10% discount
			}
			else{
				file.write(String.valueOf(item.getPrice()));
			}

			file.write(",");

		}

		catch(IOException e){
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}

}