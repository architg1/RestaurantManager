import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.io.*;

public class SalesRevenueReport {



   Map<String, Integer> count = new HashMap<String, Integer>();
   Map<String, Double> price = new HashMap<String, Double>();
   private Double totalSales = 0.0;
   private Integer itemsSold = 0;
   private Integer packagesSold = 0;


   public void reportOptions(){
      Scanner sc = new Scanner(System.in);
      int choice;
      do {
         System.out.println("SALES REVENUE REPORT");
         System.out.println("(1) View overall sales report");
         System.out.println("(2) View report according to month");
         System.out.println("(3) View report according to day");
         System.out.println("(4) Return to previous page");
         choice = sc.nextInt();
      
         switch(choice){
            case 1:
            
               printOverallSales();
            
               break;
         
            case 2:
            
               int month;
               System.out.println("Month: (Choose an integer between 1 to 12 only)");
               do {
                  month = sc.nextInt();
               } while (month < 1 || month > 12);
            
               System.out.println("Monthly sales report...");
               printOverallSales();
            
            	//printMonthlySales(month);
            
               break;
         
            case 3:
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
            
               System.out.println("Daily sales report...");
               printOverallSales();
            
            	//printDailySales(date, month2);
            
               break;
         
            case 4:
               break;
         }
      } while (choice != 4);
   
   
   }

   public void printOverallSales(){

      updateValues();
      for(Map.Entry<String, Integer> entry : count.entrySet()){
         System.out.print("Item Name: " + entry.getKey());
         System.out.print(" Quantity Sold: " + entry.getValue());
         System.out.print(" Money Made: " + price.get(entry.getKey()));
      }

      System.out.println("Total items sold: " + this.itemsSold);
      System.out.println("Total packages sold: " + this.packagesSold);
      System.out.println("Total sales: " + this.totalSales);

   }


   public void updateValues() {
   
      ArrayList<Order> Orders = Home.Orders;
      for (Order order : Orders) {
      
         for (Item item : order.orderItems) {
            if (!count.containsValue(item.getName())) {
               count.put(item.getName(), 1);
               price.put(item.getName(), item.getPrice());
               this.totalSales += item.getPrice();
               this.itemsSold +=1;
            }
            else{
               count.put(item.getName(), count.get(item.getName()) + 1);
               price.put(item.getName(), count.get(item.getName()) + item.getPrice());
               this.totalSales +=item.getPrice();
               this.itemsSold += 1;
            }
         }
      
         for (PromotionalPackage packages : order.getOrderPackages()) {
            if (!count.containsValue(packages.getName())) {
               count.put(packages.getName(), 1);
               price.put(packages.getName(), packages.getPrice());
               this.totalSales +=packages.getPrice();
               this.packagesSold +=1;
            }
            else{
               count.put(packages.getName(), count.get(packages.getName()) + 1);
               price.put(packages.getName(), count.get(packages.getName()) + packages.getPrice());
               this.totalSales +=packages.getPrice();
               this.packagesSold +=1;
            }
         }
      }
   }
}
