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

	public void printDailySales(int date) {

		try (BufferedReader br = new BufferedReader(new FileReader("invoice.txt"))) {
			String line;

			// create dictionaries
			Map<String, Integer> count = new HashMap<String, Integer>();
			Map<String, Double> price = new HashMap<String, Double>();

			while ((line = br.readLine()) != null) {
				String[] elements = line.split(",");

				LocalDate localDate = LocalDate.parse(elements[3]);

				if(date==(localDate.getDayOfYear())){
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