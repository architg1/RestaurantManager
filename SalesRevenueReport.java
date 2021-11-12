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

	public void printMonthlySales(int month, LocalDate datestamp) {
		try (BufferedReader br = new BufferedReader(new FileReader("invoice.txt"))) {
			String line;

			// create dictionaries
			Map<String, Integer> count = new HashMap<String, Integer>();
			Map<String, Double> price = new HashMap<String, Double>();

			while ((line = br.readLine()) != null) {
				String[] elements = line.split(",");
				if(elements[3]==String.valueOf(datestamp.getMonthValue())){
					for(int pos=0; pos<elements.length; pos++){
						if(elements[pos]=="i"){
							count.put(elements[pos+1], count.get(elements[pos+1])+1);
							price.put(elements[pos+1], price.get(elements[pos+1])+Double.valueOf(elements[pos+4]));
						}
						if(elements[pos]=="p"){
							count.put(elements[pos+1], count.get(elements[pos+1])+1);
							price.put(elements[pos+1], price.get(elements[pos+1])+Double.valueOf(elements[pos+4]));
						}
					}
				}

			}
		}
		catch(IOException e){
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		throw new UnsupportedOperationException();

	}

	public void printDailySales() {
		// TODO - implement SalesRevenueReport.printMonthlySalesReport
		throw new UnsupportedOperationException();
	}

	public void calculateTotalRevenue() {
		// TODO - implement SalesRevenueReport.calculateTotalRevenue
		throw new UnsupportedOperationException();
	}

}