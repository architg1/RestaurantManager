import java.time.LocalTime;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Invoice {

	SalesRevenueReport report;
	private LocalTime timestamp;
	private Integer totalCost;
	private Boolean discount;

	/**
	 * 
	 * @param table
	 */
	public void createInvoice(Table table) {
		try{
			FileWriter invoice = new FileWriter("invoice.txt");

			// BASIC DETAILS


		}
		catch(IOException e){
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		throw new UnsupportedOperationException();
	}

	public double calculateTotalPrice(Table table){
		double cost_item = 0;
		double cost_package = 0;
		Order order = table.getOrder();
		for (Item item: order.items){
			cost_item += item.price;
		}
		for(SetPackage setPackage: order.packages){
			cost_package += setPackage.packagePrice;
		}

		double total_cost = cost_item + cost_package;
		return total_cost;
	}

	public void individualDetails(Item item, FileWriter file){
		try{
			System.out.println(item.name);
			for(int i=0; i<item.name.length(); i++){
				file.write(item.name.charAt(i));
			}

			System.out.println(item.description);
			for(int i=0; i<item.description.length(); i++){
				file.write(item.description.charAt(i));
			}

			System.out.println(item.category);
			file.write(item.category.toString());

			System.out.println(item.price);
			file.write((int) item.price);
		}

		catch(IOException e){
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}



}