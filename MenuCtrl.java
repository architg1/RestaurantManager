import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.text.DecimalFormat;
import java.io.FileWriter;

public class MenuCtrl implements Serializable{

   private static Scanner sc = new Scanner(System.in);
   private static final DecimalFormat df = new DecimalFormat("0.00");
   
   
   String name;
   Category category;
   String description;
   Double price;
  
   // Declare an array list for menu and populate with items
   public ArrayList<Item> FullMenu = new ArrayList<Item>();
   public ArrayList<PromotionalPackage> PromotionalPackages = new ArrayList<PromotionalPackage>();
  
   // testing purposes, delete later
   public static void main(String args[]){
     // Read array list from file
      File file = new File("/Users/joey/Documents/school/y2s1/cz2002 object oriented/FullMenu.txt");
      file.createNewFile();
      
      FileInputStream fis = new FileInputStream(file);
      ObjectInputStream ois = new ObjectInputStream(fis);
      ArrayList<Item> FullMenu = (ArrayList<Item>)ois.readObject();     
      ois.close();  
      
      MenuCtrl menuctrl  = new MenuCtrl();
      menuctrl.MenuOptions();
      
      FileOutputStream fos = new FileOutputStream(file);
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      oos.writeObject(FullMenu);
      oos.close();
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
               System.out.println("(2) Promotional Package");
               System.out.println("(3) Return to previous page");
                 
               int itemTypeChoiceAdd = sc.nextInt();
               switch(itemTypeChoiceAdd){
                  case 1: 
                     addFoodItem();
                     break;
                     
                  case 2: 
                     System.out.println("PROMOTIONAL PACKAGE");
                     System.out.println("(1) Add new promotional package");
                     System.out.println("(2) Add item to promotional package");
                     System.out.println("(3) Return to previous page");
                     int PromotionalPackageChoice = sc.nextInt();
                     
                     switch(PromotionalPackageChoice){
                        case 1:
                           createPromotionalPackage();
                           break;
                        
                        case 2: 
                           System.out.println("What's the name of the promotional package to add an item to?");
                           sc.nextLine();
                           String packagenameadd = sc.nextLine();
                           
                           Iterator<PromotionalPackage> iter = PromotionalPackages.iterator();
                           while (iter.hasNext()){
                              PromotionalPackage pp = iter.next();
                              if(pp.getPackageName().equals(packagenameadd)){
                                 addItemtoPromotionalPackage(pp);
                                 break;
                              }
                           }
                        
                           break;
                           
                        case 3:
                           break;
                     }
                     break;
                      
                  case 3:
                     break;
               }
               
               break;
               
               
            case 3:
               System.out.println("ITEM TYPE");
               System.out.println("(1) Food Item");
               System.out.println("(2) Promotional Package");
                 
               int itemTypeChoiceRemove = sc.nextInt();
                  
               switch(itemTypeChoiceRemove){
                  case 1: 
                     removeFoodItem();
                     break;
                  
                  case 2: 
                     System.out.println("PROMOTIONAL PACKAGE");
                     System.out.println("(1) Remove promotional package");
                     System.out.println("(2) Remove item from promotional package");
                     System.out.println("(3) Return to previous page");
                     int PromotionalPackageChoice = sc.nextInt();
                     
                     switch(PromotionalPackageChoice){
                        case 1:
                           removePromotionalPackage();
                           break;
                        
                        case 2: 
                           System.out.println("What's the name of the promotional package to remove an item from?");
                           sc.nextLine();
                           String packagenameremove = sc.nextLine();
                              
                           Iterator<PromotionalPackage> iter = PromotionalPackages.iterator();
                           while (iter.hasNext()){
                              PromotionalPackage pp = iter.next();
                              if(pp.getPackageName().equals(packagenameremove)){
                                 removeItemfromPackage(pp);
                              }
                           }
                           
                           break;
                           
                        case 3:
                           break;
                     }
                     break;
               }
               
               break;
               
            case 4:   
               updateFoodItem();
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
      System.out.println("(2) Main");
      System.out.println("(3) Desserts");
      System.out.println("(4) Drinks");
      System.out.println("(5) Specials");
      System.out.println("(6) Promotional Packages");
      System.out.println("(7) Go Back to Previous Page");
               
      int categorychoice = sc.nextInt();
      // initialise selectedCategory to a random category
      Category selectedCategory = Category.MAIN;
              
      switch(categorychoice){
         case 1:
            printItems(Category.APPETISER);
            break;
            
         case 2:
            printItems(Category.MAIN);
            break;
            
         case 3:
            printItems(Category.DESSERT);
            break;
            
         case 4:
            printItems(Category.DRINK);
            break;
            
         case 5:
            printItems(Category.SPECIAL);
            break; 
         
         case 6: 
            Iterator<PromotionalPackage> iter = PromotionalPackages.iterator();
            boolean hasPromotionalPackage = false;
            
            while (iter.hasNext()){
               hasPromotionalPackage = true;
               PromotionalPackage pp = iter.next();
               
               System.out.println("Package Name: " + pp.getPackageName());
               System.out.println("Package Price: $" + df.format(pp.getPackagePrice()));
               System.out.println("Package Description: " + pp.getPackageDescription());
               System.out.println("Package Items: ");
               
               // print all the items in package
               ArrayList<Item> packageItems = pp.getPackageItems();
               int index = 0;
               for (Item item: packageItems)
                  System.out.println("(" + index++ + ") " + item.getName() + ", " + item.getDescription());
               
               System.out.println();
            }
            
            if (hasPromotionalPackage == false)
            {
               System.out.println("There are no promotional packages currently.");
            }
            
            break; 
      }      
   }
    
    // print out the menu for the category
   public void printItems(Category selectedCategory){
      boolean hasCategoryItem = false; 
         
      Iterator<Item> iter = FullMenu.iterator();
      while (iter.hasNext()){
         Item i = iter.next();
         if (i.category == selectedCategory){
            hasCategoryItem = true;
               
            System.out.println("Item Name: " + i.getName());
            System.out.println("Item Price: $" + df.format(i.getPrice()));
            System.out.println("Item Description: " + i.getDescription());
            System.out.println();
         }
      }
         
      if (hasCategoryItem == false){
         System.out.println("List is empty.");
      }
        
   }
    
      
   // (2)(1) Add Food Item
   public void addFoodItem(){
      do{
         try{
            System.out.println("What's the category of the item?" );
            System.out.println("Select between: Main, Appetiser, Drink, Dessert, Special");
            String categoryStr = sc.next();
            sc.nextLine();
            Category category = Category.valueOf(categoryStr.toUpperCase());
         
            System.out.println("What's the name of the item? ");
            String name = sc.nextLine();
         
         // prevent duplicate items 
            if (checkDuplicateItem(name, category) == true){
               break;
            }
         
            System.out.println("What's the price of the item? Enter numbers only. ");
            Double price = sc.nextDouble();
            sc.nextLine();
            
            System.out.println("What's the description of the item? ");
            String description = sc.nextLine();
         
            FullMenu.add(new Item(name, category, description, price));
         } catch (Exception e){
            System.out.println("Invalid input. Please try again.");
         }
      } while(false);
   }
   
   
   // (2)(2)(1) Create a new promotional package.
   public void createPromotionalPackage(){
      ArrayList<Item> packageItems = new ArrayList<Item>();
            
      System.out.println("Name: ");
      sc.nextLine();
      String packageName = sc.nextLine();
   
      System.out.println("Description: ");
      String packageDescription = sc.nextLine();
   
      System.out.println("Price: (Please only enter an integer)");
      Integer packagePrice = sc.nextInt();
             
      PromotionalPackage newPackage = new PromotionalPackage(packageName, packageDescription, packagePrice, packageItems);
      PromotionalPackages.add(newPackage); 
      
      String choice;
      do {
         addItemtoPromotionalPackage(newPackage);
         /*
         System.out.println("What's the category of the item to add?" );
         System.out.println("Select between: Main, Appetiser, Drink, Dessert, Special");
         String categoryStr = sc.next();
         Category category = Category.valueOf(categoryStr.toUpperCase());
      
         System.out.println("What's the name of the item to add?");
         sc.nextLine();
         String name = sc.nextLine();
      
         int indexofItemtoAdd = getIndexByName(name, category);  
      // find the index of item and add it to the package
         if (indexofItemtoAdd == -1){
            System.out.println("The item does not exist. Please create the item first before adding it to any packages.");
         }
         
         else{
            Item tempadd = FullMenu.get(indexofItemtoAdd);
            packageItems.add(tempadd);
         } */
         
        
         System.out.println("Continue adding menu item to promotional package? (Y/N)");
         choice = sc.next();
      } while(choice == "Y");
      
     
      
   }
   
    //(2)(2)(2) Add items to promotional packages
   public void addItemtoPromotionalPackage(PromotionalPackage pp){
      System.out.println("What's the category of the item to add?" );
      System.out.println("Select between: Main, Appetiser, Drink, Dessert, Special");
      String categoryStr = sc.next();
      Category category = Category.valueOf(categoryStr.toUpperCase());
      
      System.out.println("What's the name of the item to add?");
      sc.nextLine();
      String name = sc.nextLine();
      
      int indexofItemtoAdd = getIndexByName(name, category);  
      // find the index of item and add it to the package
      if (indexofItemtoAdd == -1){
         System.out.println("The item does not exist. Please create the item first before adding it to any packages.");
      }
      
      else{
         Item tempadd = FullMenu.get(indexofItemtoAdd);
         
         pp.getPackageItems().add(tempadd);
      }
   }
   
         
   
    //(3)(1) Remove Food Item
   public void removeFoodItem(){
      try{
         System.out.println("What's the category of the item to remove?" );
         System.out.println("Select between: Main, Appetiser, Drink, Dessert, Special");
         String categoryStrRemove = sc.next();
         Category categoryRemove = Category.valueOf(categoryStrRemove.toUpperCase());
            
         System.out.println("What's the name of the item to remove? ");
         sc.nextLine();
         String removename = sc.nextLine();
         
         Iterator<Item> iter = FullMenu.iterator();
         while (iter.hasNext()){
            Item i = iter.next();
            if(i.category.equals(categoryRemove)){
               if (i.getName().equals(removename)){
                  iter.remove();
                  System.out.println("Item removed. ");
               }
            }
         }
         
      } catch (Exception e){
         System.out.println("Invalid input.");
      }
   }
   
   // (3)(2)(1) Remove Promotional Package
   public void removePromotionalPackage(){
      System.out.println("What's the name of the promotional package to remove?");
      sc.nextLine();
      String removepackage = sc.nextLine();
      
      Iterator<PromotionalPackage> iter = PromotionalPackages.iterator();
      while (iter.hasNext()){
         PromotionalPackage pp = iter.next();
         if(pp.getPackageName().equals(removepackage)){
            iter.remove();
         }
      }
   }
   
   // (3)(2)(2) Remove Item from Promotional Package
   public void removeItemfromPackage(PromotionalPackage pp){
      try{
         System.out.println("What's the category of the item to remove?" );
         System.out.println("Select between: Main, Appetiser, Drink, Dessert, Special");
         String categoryStrRemove = sc.next();
         Category categoryRemove = Category.valueOf(categoryStrRemove.toUpperCase());
            
         System.out.println("What's the name of the item to remove? ");
         sc.nextLine();
         String removename = sc.nextLine();
         
         Iterator<Item> iter = pp.getPackageItems().iterator();
         while (iter.hasNext()){
            Item i = iter.next();
            if(i.category.equals(categoryRemove)){
               if (i.getName().equals(removename)){
                  iter.remove();
               }
            }
         }
      } catch (Exception e){
         System.out.println("Invalid input.");
      }
   }
   
   
   // (4) Update Food Item
   public void updateFoodItem(){
      do{
         try{
            System.out.println("What's the category of the item to update?" );
            System.out.println("Select between: Main, Appetiser, Drink, Dessert, Special");
            String categoryStr = sc.next();
            sc.nextLine();
            Category category = Category.valueOf(categoryStr.toUpperCase());
         
            System.out.println("What's the name of the item to update? ");
            String name = sc.nextLine();
            
            int indexofItem = getIndexByName(name, category);
            
            // user input
            System.out.println("Choose what to update: ");
            System.out.println("(1) Name");
            System.out.println("(2) Price");
            System.out.println("(3) Description");
            System.out.println("(4) Category");
            System.out.println("(5) Return back to menu options");
            int updateChoice = sc.nextInt();
            
            switch(updateChoice)
            {
               case 1:
                  System.out.println("Enter new name: ");
                  sc.nextLine();
                  String newname = sc.nextLine();
                  FullMenu.get(indexofItem).setName(newname);
                  
                  break;
              
               case 2:
                  System.out.println("Enter new price: ");
                  Double newPrice = sc.nextDouble();
                  FullMenu.get(indexofItem).setPrice(newPrice);
                  
                  break;
                  
               case 3:
                  System.out.println("Enter new description: ");
                  String newDescription = sc.nextLine();
                  FullMenu.get(indexofItem).setDescription(newDescription);
                  
                  break;
            }
         }
         catch (Exception e){
            System.out.println("Invalid input. Please try again.");
         }
      } while(false);
   }
   
   
   
   // check for duplicate items already in FullMenu array
   public boolean checkDuplicateItem(String name, Category category){
      Iterator<Item> iter = FullMenu.iterator();
      while (iter.hasNext()){
         Item i = iter.next();
         if(i.getName().equals(name)){
            if (i.category.equals(category)){
               System.out.println("Item already exists in the menu.");
               return true;
            } 
            else {
               System.out.println("Name of item already exists in menu but category is different. To continue, Enter -1 to exit the page and return to menu options.");
               int userChoice = sc.nextInt();
               if (userChoice == -1)
               {
                  return true;
               }
               return false;
            }
         }
         return false;
      }
      return false;
   }
   
    // find the index of item by its name and category
   public int getIndexByName(String name, Category category) {
      for (int i = 0; i < FullMenu.size(); i++) {
         Item temp = FullMenu.get(i);
         
         if (temp !=null && temp.getName().equals(name) && temp.category.equals(category)) {
            return i;
         }
      }
        // not found
      return -1;
   }
      
}        




   



