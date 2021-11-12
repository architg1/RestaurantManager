import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.io.*;

public class SalesRevenueReport {

	Collection<Invoice> invoice;
	private Integer totalSales;
	private Item itemsSold;
	private PromotionalPackage packagesSold;
	private MenuCtrl menu;
	
	public void SalesRevenueReport(){
		Scanner sc = new Scanner(System.in);
		int choice;
		do {
			System.out.println("SALES REVENUE REPORT");
			System.out.println("(1) View report according to month");
			System.out.println("(2) View report according to day");
			System.out.println("(3) Return to previous page");
			choice = sc.nextInt();
			
			switch(choice){
				case 1:	
					int month;
					System.out.println("Month: (Choose an integer between 1 to 12 only)");
					do {
						month = sc.nextInt();
					} while (month < 1 || month > 12);
					
					printMonthlySales(month);

					break;
					
				case 2:

					int date;
					int month2; 
					System.out.println("Date: (Choose an integer between 1 to 31)");
					do {
						date = sc.nextInt();
					} while (date < 1 || date > 31);
					
					System.out.println("Month: (Choose an integer between 1 to 12)");
					do {
						month2 = sc.nextInt();
					} while (month2 < 1 || month2 > 12);
					
					printDailySales(date, month2);

					break;
					
				case 3:
					break;
			}
		} while (choice != 3);
			
		
	}

	public void printMonthlySales(int month) {
		try (BufferedReader br = new BufferedReader(new FileReader("invoice.txt"))) {
			String line;

			// create dictionaries
			Map<String, Integer> count = new HashMap<String, Integer>();
			Map<String, Double> price = new HashMap<String, Double>();

			while ((line = br.readLine()) != null) {
				String[] elements = line.split(",");

				LocalDate localDate = LocalDate.parse(elements[3]);

				if(month==(localDate.getMonthValue())){
					for(int pos=0; pos<elements.length; pos++){
						if(elements[pos]=="i"){
							count.put(elements[pos+1], count.get(elements[pos+1])+1);
							price.put(elements[pos+1], price.get(elements[pos+1])+Double.valueOf(elements[pos+4]));
						}
						if(elements[pos]=="p"){
							count.put(elements[pos+1], count.get(elements[pos+1])+1);
							price.put(elements[pos+1], price.get(elements[pos+1])+Double.valueOf(elements[pos+3]));
						}
					}
				}

			}

			for(Map.Entry<String, Integer> entry : count.entrySet()){
				System.out.print("Item Name: " + entry.getKey());
				System.out.print("Quantity Sold: " + entry.getValue());
				System.out.println("Money Made: " + price.get(entry.getKey()));
			}
		}

		catch(IOException e){
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		throw new UnsupportedOperationException();

	}

	public void printDailySales(int date, int month) {

		try (BufferedReader br = new BufferedReader(new FileReader("invoice.txt"))) {
			String line;

			// create dictionaries
			Map<String, Integer> count = new HashMap<String, Integer>();
			Map<String, Double> price = new HashMap<String, Double>();

			while ((line = br.readLine()) != null) {
				String[] elements = line.split(",");

				LocalDate localDate = LocalDate.parse(elements[3]);

				if(date==localDate.getDayOfMonth() && month == localDate.getMonthValue()){
					for(int pos=0; pos<elements.length; pos++){
						if(elements[pos]=="i"){
							count.put(elements[pos+1], count.get(elements[pos+1])+1);
							price.put(elements[pos+1], price.get(elements[pos+1])+Double.valueOf(elements[pos+4]));
						}
						if(elements[pos]=="p"){
							count.put(elements[pos+1], count.get(elements[pos+1])+1);
							price.put(elements[pos+1], price.get(elements[pos+1])+Double.valueOf(elements[pos+3]));
						}
					}
				}

			}

			for(Map.Entry<String, Integer> entry : count.entrySet()){
				System.out.print("Item Name: " + entry.getKey());
				System.out.print("Quantity Sold: " + entry.getValue());
				System.out.println("Money Made: " + price.get(entry.getKey()));
			}
		}

		catch(IOException e){
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		throw new UnsupportedOperationException();
	}

	public void calculateTotalRevenue() {
		// TODO - implement SalesRevenueReport.calculateTotalRevenue
		throw new UnsupportedOperationException();
	}

}
