import java.text.DecimalFormat;
import java.util.Scanner;

public class InvoiceCtrl {
   public void invoiceOptions(){
      Scanner sc = new Scanner(System.in);
   
      int userOrder = -1;
      System.out.print("What is the Order ID?");
      int orderID = sc.nextInt();
      for (int i = 0; i < Home.Orders.size(); i++){
         if (Home.Orders.get(i).getOrderID() == orderID){
            userOrder = i;
         }
      }
         
      if (userOrder == -1){
         System.out.println("The order does not exist");
      }
      
      else {
         System.out.println("Creating the invoice...");
         createInvoice(Home.Orders.get(userOrder));
      }
      
    
   
   
   }

   public void createInvoice(Order order){
   
      boolean isMember = order.getTable().isReservationMembership();
   
   	// BASIC DETAILS
   
      System.out.println("Pikachu Restaurant");
      System.out.println("	*********	");
      System.out.println("	LOCATION	");
   
      System.out.print("Server: " + order.getStaff().getStaffName() + "		");
      System.out.println("Table: " + order.getTable().getTableID());
   
      System.out.print("Date: " + order.getOrderDate() + "		");
      System.out.println("Time: " + order.getOrderDate());
      System.out.println("	*********	");
   
   	// ITEM DETAILS
   
      for(Item item : order.getOrderItems()){
      
         System.out.print(item.getName());
      
         if(isMember){
            System.out.print(item.getPrice()*0.9); // 10% discount
         }
         else{
            System.out.print(item.getPrice());
         }
      }
   
      for(PromotionalPackage packages: order.getOrderPackages()) {
      
         System.out.print(packages.getName());
      
         if (isMember) {
            System.out.print(packages.getPrice() * 0.90); // 10% discount
         } else {
            System.out.print(packages.getPrice());
         }
      
         for (Item item : packages.getPackageItems()) {
            System.out.print(item.getName());
         
            if (isMember) {
               System.out.print(item.getPrice() * 0.9); // 10% discount
            } else {
               System.out.print(item.getPrice());
            }
         }
      }
   
      double price = calculateTotalPrice(order);
      double priceTax = calculateTotalPrice(order)*1.07*1.10;
   
      System.out.println("	*********	");
      System.out.println("Total Price: " + price);

      System.out.println("Price After GST: " + priceTax);
   
      System.out.println("	*********	");
      System.out.println("Thanks for Coming!!!");
      System.out.println("	*********	");

      order.getTable().tableEmpty();
   
   
   }

   public double calculateTotalPrice(Order order){
      double cost_item = 0;
      double cost_package = 0;
      for (Item item: order.getOrderItems()){
         if(order.getTable().isReservationMembership()){
            cost_item += item.getPrice()*0.9; // 10% discount
         }
         else{
            cost_item += item.getPrice();
         }
      
      }
      for(PromotionalPackage setPackage: order.getOrderPackages()){
         if(order.getTable().isReservationMembership())
            cost_package += setPackage.getPrice()*0.9; // 10% discount
         else
            cost_package += setPackage.getPrice();
      }
   
      double total_cost = cost_item + cost_package;
   	//this.totalCost = total_cost;
      return total_cost;
   }
}
