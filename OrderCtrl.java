import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalTime;
import java.util.Iterator;

public class OrderCtrl {
   Scanner sc = new Scanner(System.in);
   MenuCtrl menuctrl = new MenuCtrl();
   
   ArrayList<Order> Orders = new ArrayList<Order>();
  
   public void createOrder(){
      //create new order and add to orders arraylist
      int orderChoice;
      do{
         ArrayList<Item> orderItems = new ArrayList<Item>();
         ArrayList<PromotionalPackage> orderPackages = new ArrayList<PromotionalPackage>();
      
         System.out.println("ORDER");
         System.out.println("(1) Create a new order.");
         System.out.println("(2) Return to home page.");
         orderChoice = sc.nextInt();
         
         switch(orderChoice){
            case 1:
               System.out.println("Name of staff creating this order: ");
               sc.nextLine();
               String staffName = sc.nextLine();
               
               int staffIndex = -1;
               int tableIndex = -1;
               
               for(int i = 0; i < Home.Staffs.size(); i++){
                  Staff s = Home.Staffs.get(i);
                  if (s.getStaffName().equals(staffName)){
                     staffIndex = i;
                  }
               }
               
               System.out.println("Table ID for this order: ");
               long tableID = sc.nextLong();
               
               for (int j = 0; j < Home.Tables.size(); j++){
                  Table t = Home.Tables.get(j);
                  if (t.getTableID() == tableID){
                     tableIndex = j;
                  }
               }
                  
               LocalTime orderTime = LocalTime.now();
                  
               Order newOrder = new Order(Home.Staffs.get(staffIndex), orderItems, orderPackages, orderTime, Home.Tables.get(tableIndex));
               Orders.add(newOrder);
                  
               System.out.println("New order created.");
               orderOptions(newOrder);
               
              
               break;
               
            case 2: 
               break;
         }
      } while (orderChoice == 1);
   }
    
    
    
    
    
   public void orderOptions(Order order){
      int choice;
      do {
         System.out.println("NEW ORDER");
         System.out.println("(1) View menu");
         System.out.println("(2) Add an item to the order");
         System.out.println("(3) Add a promotional package to order");
         System.out.println("(4) Remove an item from order");
         System.out.println("(5) Remove a promotional package from order");
         System.out.println("(6) Confirm order");
                     
         choice = sc.nextInt();
         switch(choice){
            case 1:
               menuctrl.viewMenu(); 
               break;
                        
            case 2:
               addItemtoOrder(order);
               break;
                        
            case 3:
               addPackagetoOrder(order);
               break;
                           
            case 4:
               removeItemfromOrder(order);
               break;
                           
            case 5: 
               removePackagefromOrder(order); 
               break;
                           
            case 6:
               System.out.println("Order confirmed.");
               break;
         }
      } while(choice!=6);  
   }


// (2) Add item to order
   public void addItemtoOrder(Order order){
      System.out.println("Name of item to add: ");
      sc.nextLine();
      String itemName = sc.nextLine();
   
      System.out.println("Category of item to add: " );
      System.out.println("Select between: Main, Appetiser, Drink, Dessert, Special");
      String categoryStr = sc.next();
      Category category = Category.valueOf(categoryStr.toUpperCase());
   
      int indexofItemtoAdd = menuctrl.getIndexByName(itemName, category);
      if (indexofItemtoAdd == -1){
         System.out.println("The item does not exist. Please create the item first before adding it to any order.");
      }
      
      else {
         order.getOrderItems().add(Home.FullMenu.get(indexofItemtoAdd));
      }
   }
   
   
   //(3) Add Promotional Package to Order
   public void addPackagetoOrder(Order order){
      System.out.println("What's the name of the promotional package you wish to add?");
      sc.nextLine();
      String packageName = sc.nextLine();
      
      int indexOfPackagetoAdd = -1;
      for (int i = 0; i < Home.PromotionalPackages.size(); i++) {
         PromotionalPackage p = Home.PromotionalPackages.get(i);
         if (p != null && p.getPackageName().equals(packageName)){
            indexOfPackagetoAdd = i;
         }
      }
      
      order.getOrderPackages().add(Home.PromotionalPackages.get(indexOfPackagetoAdd));
   }
   
   
   //(4) Remove Item from Order
   public void removeItemfromOrder(Order order){
      System.out.println("What's the name of the item you wish to remove?");
      String itemName = sc.nextLine();
      
      System.out.println("What's the category of the item?" );
      System.out.println("Select between: Main, Appetiser, Drink, Dessert, Special");
      String categoryStrRemove = sc.next();
      Category categoryRemove = Category.valueOf(categoryStrRemove.toUpperCase());
      
      Iterator<Item> iter = order.getOrderItems().iterator();
      while (iter.hasNext()){
         Item i = iter.next();
         if(i.category.equals(categoryRemove)){
            if (i.getName().equals(itemName)){
               iter.remove();
               System.out.println("Item removed from order.");
            }
         }
      }
   }
   
   
   // (5) Remove Package from Order
   public void removePackagefromOrder(Order order){
      System.out.println("What's the name of the package you wish to remove?");
      String packageName = sc.nextLine();
   
      Iterator<PromotionalPackage> iter = order.getOrderPackages().iterator();
      while (iter.hasNext()){
         PromotionalPackage p = iter.next();
         if(p.getPackageName().equals(packageName)){
            iter.remove();
            System.out.println("Package removed from order.");
         }
      }
   }



}
