import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;


public class MenuCtrl{

   private static Scanner sc = new Scanner(System.in);
   
   String name;
   Category category;
   String description;
   Double price;
  
   // Declare an array list for menu and populate with items
   public ArrayList<Item> FullMenu = new ArrayList<Item>();
  
   public static void main(String args[]){ 
      MenuCtrl menuctrl  = new MenuCtrl();
      menuctrl.MenuOptions();
   }
    
    // Get the user's input 
   public void MenuOptions(){
      
      int choice;
      
      do{
         System.out.println("MENU OPTIONS");
         System.out.println("(1) View menu");
         System.out.println("(2) Add new item to menu");
         System.out.println("(3) Remove item from menu");
         System.out.println("(4) Update item in menu");
         System.out.println("(5) Exit menu options");
      
         choice = sc.nextInt();
      
         switch(choice){
            case 1:
               viewMenu();
               break;
               
            case 2:
               System.out.println("ITEM TYPE");
               System.out.println("(1) Food Item");
               System.out.println("(2) Set Package");
                 
               int itemTypeChoice = sc.nextInt();
                 
               switch(itemTypeChoice){
                  case 1: 
                     addFoodItem();
                     break;
                     //case 2: 
                        //addSetPackage(); 
                        //break;
               }
               
               
            case 3:
               System.out.println("ITEM TYPE");
               System.out.println("(1) Food Item");
               System.out.println("(2) Set Package");
                  
                  /*int itemTypeChoice = sc.nextInt();
                  
                  switch(itemTypeChoice){
                     case 1: removeFoodItem();
                     case 2: removeSetPackage();
                  }
                  */
                  
               break;
               
            case 4:
               System.out.println("ITEM TYPE");
               System.out.println("(1) Food Item");
               System.out.println("(2) Set Package");
                  
                  /*
                  
                  int itemTypeChoice = sc.nextInt();
                  
                  switch(itemTypeChoice){
                     case 1: updateFoodItem();
                     case 2: updateSetPackage();
                  }
                  
                  */
                  
               break;
               
            case 5:
               break;
         } 
      } while (choice != 5);
   }
 


   // (1) - View Menu
   public void viewMenu(){
      System.out.println("MENU CATEGORY");
      System.out.println("(1) Appetisers");
      System.out.println("(2) Main Menu");
      System.out.println("(3) Desserts");
      System.out.println("(4) Drinks");
      System.out.println("(5) Specials");
      System.out.println("(6) Set Packages");
      System.out.println("(7) Go Back to Previous Page");
               
      int categorychoice = sc.nextInt();
               
      switch(categorychoice){
         case 1: 
            for (Item item: FullMenu){
               if (item.category == Category.APPETISER){
                  System.out.println(item);
               }
            }
         
        case 2: 
            for (Item item: FullMenu){
               if (item.category == Category.MAIN){
                  System.out.println(item);
               }
            }
        
        case 3: 
            for (Item item: FullMenu){
               if (item.category == Category.DESSERT){
                  System.out.println(item);
               }
            }
            
        case 4: 
            for (Item item: FullMenu){
               if (item.category == Category.DRINK){
                  System.out.println(item);
               }
            }
            
            
        case 5: 
            for (Item item: FullMenu){
               if (item.category == Category.SPECIAL){
                  System.out.println(item);
               }
            }
            
        case 7: 
         break;
      }
   }
   
   // (2)(1) Add Food Item
   public void addFoodItem(){
      System.out.println("What's the category of the item?" );
      System.out.println("Select between: Main, Appetiser, Drink, Dessert, Special");
      String categoryStr = sc.next();
      Category category = Category.valueOf(categoryStr.toUpperCase());
         
      System.out.println("What's the name of the item? ");
      String name = sc.next();
     
      System.out.println("What's the price of the item? ");
            
      System.out.println("What's the description of the item? ");
      String description = sc.next();
         
      FullMenu.add(new Item(name, category, description, price));
   }
   
   
    // (3)(1) Remove Food Item
   public void removeFoodItem(){
      System.out.println("What's the category of the item to remove?" );
      System.out.println("Select between: Main, Appetiser, Drink, Dessert, Special");
      String categoryStr = sc.next();
      Category category = Category.valueOf(categoryStr.toUpperCase());
         
      System.out.println("What's the name of the item to remove? ");
      String name = sc.next();
     
      System.out.println("What's the price of the item to remove? ");
            
      System.out.println("What's the description of the item to remove? ");
      String description = sc.next();
      
      
      
          
      FullMenu.add(new Item(name, category, description, price));
   }

}

