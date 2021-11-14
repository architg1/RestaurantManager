import java.util.Scanner;

//import out.production.BaseCtrl;

import java.util.ArrayList;
import java.time.LocalTime;
import java.time.LocalDate;
import java.util.Iterator;

public class OrderCtrl extends BaseCtrl{
   Scanner sc = new Scanner(System.in);
   MenuCtrl menuctrl = new MenuCtrl();
  
   public void createOrder(){
      //create new order and add to orders arraylist
      int orderChoice;
      do{
         ArrayList<Item> orderItems = new ArrayList<Item>();
         ArrayList<PromotionalPackage> orderPackages = new ArrayList<PromotionalPackage>();
      
         System.out.println("ORDER");
         System.out.println("(1) Create a new order.");
         System.out.println("(2) View orders.");
         System.out.println("(3) Return to home page.");
         orderChoice = doCtrlChoice(3);
         
         switch(orderChoice){
            case 1:
               //get user input for new order details
               System.out.println("Name of staff creating this order: ");
               //sc.nextLine();
               String staffName = sc.nextLine();
               
               int staffIndex = -1;
               int tableIndex = -1;
              
               
               //check if input staff exists in staff arraylist
               for(int i = 0; i < Home.Staffs.size(); i++){
                  Staff s = Home.Staffs.get(i);
                  if (s.getStaffName().equals(staffName)){
                     staffIndex = i;
                  }
               }
                 
               if (staffIndex == -1){
                  System.out.println("Staff does not exist ");
               }
               
               else {
                  System.out.println("Table ID for this order: ");
                  long tableID = sc.nextLong();
                  
                  //check if tableID input exists in table arraylist
                  for (int j = 0; j < Home.Tables.size(); j++){
                     Table t = Home.Tables.get(j);
                     if (t.getTableID() == tableID){
                        tableIndex = j;
                     }
                  }
                  
                  if (tableIndex == -1){
                     System.out.println("Table ID does not exist.");
                  }
                  
                  else {
                     //initialise new order with details received from input
                     LocalTime orderTime = LocalTime.now();
                     LocalDate orderDate = LocalDate.now();
                        
                     Order newOrder = new Order(Home.Staffs.get(staffIndex), orderItems, orderPackages, orderTime, orderDate, Home.Tables.get(tableIndex));
                     newOrder.getTable().reserveTable();
                     Home.Orders.add(newOrder);
                     int orderID = Home.Orders.indexOf(newOrder);
                     Home.Orders.get(orderID).setOrderID(orderID);
                        
                     System.out.println("New order created.");
                     orderOptions(newOrder);
                  }
               }
              
               break;
               
            case 2: 
               //print out all existing orders
               Iterator<Order> iter = Home.Orders.iterator();
               while (iter.hasNext()){
                  Order o = iter.next();
                  System.out.println("Order ID: " + Home.Orders.indexOf(o));
                  System.out.println("Order Table: " + o.getTable().getTableID());
                  System.out.println();
               }
               
               break;
               
            case 3:
               break;
         }
      } while (orderChoice != 3);
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
         System.out.println("(6) View order");
         System.out.println("(7) Confirm order & return to previous page");
                     
         choice = doCtrlChoice(7);
         switch(choice){
            case 1:
               menuctrl.viewMenu(); 
               break;
                        
            case 2:
               addItemToOrder(order);
               break;
                        
            case 3:
               addPackageToOrder(order);
               break;
                           
            case 4:
               removeItemFromOrder(order);
               break;
                           
            case 5: 
               removePackageFromOrder(order);
               break;
            
            case 6:
               viewOrder(order);
               break;
                           
            case 7:
               System.out.println("Order confirmed.");
               break;
         }
      } while(choice!=7);  
   }


   //below are implementations for order processing functions to be called in the above orderOptions() function
   
   
// (2) Add item to order
   public void addItemToOrder(Order order){
      System.out.println("Category of item to add: " );
      System.out.println("Select between: Main, Appetiser, Drink, Dessert, Special");
      String categoryStr = sc.next();
      Category category = Category.valueOf(categoryStr.toUpperCase());
      menuctrl.printItems(category);
      
      System.out.println("Name of item to add: ");
      sc.nextLine();
      String itemName = sc.nextLine();
      System.out.println("Item added. ");
   
      
   
      int indexofItemtoAdd = menuctrl.getIndexByName(itemName, category);
      if (indexofItemtoAdd == -1){
         System.out.println("The item does not exist. Please create the item first before adding it to any order.");
      }
      
      else {
         order.getOrderItems().add(Home.FullMenu.get(indexofItemtoAdd));
      }
   }
   
   
   //(3) Add Promotional Package to Order
   public void addPackageToOrder(Order order){
    //******* print the current promo package
      Iterator<PromotionalPackage> iters = Home.PromotionalPackages.iterator();
      boolean hasPromotionalPackage = false;
         
      while (iters.hasNext()){
         hasPromotionalPackage = true;
         PromotionalPackage pp = iters.next();
               
         System.out.println("Package Name: " + pp.getName());
         System.out.println("Package Items: ");
               
               // print all the items in package
         ArrayList<Item> packageItems = pp.getPackageItems();
         int index = 1;
         for (Item item: packageItems)
            System.out.println("(" + index++ + ") " + item.getName() + ", " + item.getCategory());
               
         System.out.println();
      }
         
            
      if (hasPromotionalPackage == false)
      {
         System.out.println("There are no promotional packages currently.");
      }
         //**********
      
      
      System.out.println("What's the name of the promotional package you wish to add?");
      sc.nextLine();
      String packageName = sc.nextLine();
      
      int indexOfPackagetoAdd;
      for (int i = 0; i < Home.PromotionalPackages.size(); i++) {
         PromotionalPackage p = Home.PromotionalPackages.get(i);
         if (p != null && p.getName().equals(packageName)){
            indexOfPackagetoAdd = i;
            order.getOrderPackages().add(Home.PromotionalPackages.get(indexOfPackagetoAdd));
            System.out.println("Package added. ");
         
         }
      }
     
   }
   
   
   //(4) Remove Item from Order
   public void removeItemFromOrder(Order order){
      
      
      System.out.println("What's the category of the item?" );
      System.out.println("Select between: Main, Appetiser, Drink, Dessert, Special");
      String categoryStrRemove = sc.next();
      Category categoryRemove = Category.valueOf(categoryStrRemove.toUpperCase());
      viewOrder(order);
   
      System.out.println("What's the name of the item you wish to remove?");
      sc.nextLine();
      String itemName = sc.nextLine();
      
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
   public void removePackageFromOrder(Order order){
      
      viewOrder(order);
      
      System.out.println("What's the name of the package you wish to remove?");
      String packageName = sc.nextLine();
   
      Iterator<PromotionalPackage> iter = order.getOrderPackages().iterator();
      while (iter.hasNext()){
         PromotionalPackage p = iter.next();
         if(p.getName().equals(packageName)){
            iter.remove();
            System.out.println("Package removed from order.");
         }
      }
   }
   
   // (6) View Order
   public void viewOrder(Order order){
      System.out.println("Order Items: ");
      Iterator<Item> iter = order.getOrderItems().iterator();
      while (iter.hasNext()){
         Item i = iter.next();
         System.out.println(" Name of item: " + i.getName());
         System.out.println(" Category of item: " + i.getCategory());
         System.out.println(" Price of item: " + i.getPrice());
      }
      
      System.out.println();
      
      System.out.println("Order Packages: ");
      Iterator<PromotionalPackage> iterp = order.getOrderPackages().iterator();
      while (iterp.hasNext()){
         PromotionalPackage p = iterp.next();
         System.out.println(" Name of package: " + p.getName());
         System.out.println(" Price of item: " + p.getPrice());
      }
      
      System.out.println();
   
      System.out.println("Order Time: " + order.getOrderTime());
      System.out.println("Order Table: " + order.getTable().getTableID());
   }

}
