import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.text.DecimalFormat;

public class MenuCtrl extends BaseCtrl
{
   private static Scanner sc = new Scanner(System.in);
   private static final DecimalFormat df = new DecimalFormat("0.00");   
   
   
  
    // Get the user's input 
   public void MenuOptions(){
      int choice;
      
      do{
         //interface display for user

         System.out.println("MENU");
         System.out.println("(1) View menu");
         System.out.println("(2) Add new item to menu");
         System.out.println("(3) Add new promotional package to menu");
         System.out.println("(4) Remove item from menu");
         System.out.println("(5) Remove promotional package from menu");
         System.out.println("(6) Update item in menu");
         System.out.println("(7) Update promotional package in menu");
         System.out.println("(8) Return to home page");
         choice = doCtrlChoice(8);
        
         switch(choice){
            case 1:
               viewMenu();
               break;
               
            case 2:
               addFoodItem();
               break;
               
            case 3: 
               System.out.println("PROMOTIONAL PACKAGE");
               System.out.println("(1) Add new promotional package");
               System.out.println("(2) Add item to promotional package");
               System.out.println("(3) Return to previous page");
             
              //intPromotionalPackageChoiceAdd = sc.nextInt();
               
               int PromotionalPackageChoiceAdd = doCtrlChoice(3);
               switch(PromotionalPackageChoiceAdd){
                  case 1:
                     createPromotionalPackage();
                     break;
                  
                  case 2: 
                     Iterator<PromotionalPackage> iterator = Home.PromotionalPackages.iterator();
                     while(iterator.hasNext()){
                        PromotionalPackage pp = iterator.next();
                        System.out.println("Name of Package: " + pp.getName());
                        System.out.println();
                     }
                     
                     System.out.println("Name of the promotional package to add an item to:");
                     sc.reset();
                     String packageNameAdd = sc.nextLine();
                     
                     Iterator<PromotionalPackage> iters = Home.PromotionalPackages.iterator();
                     String again = "N";
                     do{
                        while (iters.hasNext()){
                           //find the desired promotional package name and add desired item to it
                           PromotionalPackage pp = iters.next();
                           if(pp.getName().equals(packageNameAdd)){
                              addItemToPromotionalPackage(pp);
                              break;
                           }
                           System.out.println("Continue adding items? (Y/N)");
                           again = sc.next();
                        }
                     } while (again.equals("Y")||again.equals("y"));
                     
                     break;
                     
                  case 3:
                     //go back to previous enclosing while loop, return to previous interface
                     break;
               }
               break;
               
               
            case 4:
               removeFoodItem();
               break;
               
               
            case 5: 
               System.out.println("PROMOTIONAL PACKAGE");
               System.out.println("(1) Remove promotional package");
               System.out.println("(2) Remove item from promotional package");
               System.out.println("(3) Return to previous page");
               int PromotionalPackageChoiceRemove = doCtrlChoice(3);
               
               switch(PromotionalPackageChoiceRemove){
                  case 1:
                     removePromotionalPackage();
                     break;
                     
                  case 2: 
                     System.out.println("Name of the promotional package to remove an item from:");
                     //sc.nextLine();
                     String packageNameRemove = sc.nextLine();
                     
                     //search for desired promotional package and remove item from it
                     Iterator<PromotionalPackage> iterator = Home.PromotionalPackages.iterator();
                     while (iterator.hasNext()){
                        PromotionalPackage pp = iterator.next();
                        if(pp.getName().equals(packageNameRemove)){
                           removeItemFromPackage(pp);
                        }
                     } 
                     break;
                 
                  case 3:
                     break;
               }
               break;
             
               
            case 6:
               updateFoodItem();
               break;
               
               
            case 7: 
               updatePromotionalPackage();
               break;
         
            case 8:
               break;
         } 
      } while (choice != 8);
   }


   // (1) - View Menu
   public void viewMenu(){
      int categorychoice;
      do{
         //user can choose to filter menu items based on category
         System.out.println("MENU CATEGORY");
         System.out.println("(1) Appetisers");
         System.out.println("(2) Main");
         System.out.println("(3) Desserts");
         System.out.println("(4) Drinks");
         System.out.println("(5) Specials");
         System.out.println("(6) View all Ala cartes");
         System.out.println("(7) Promotional Packages");
         System.out.println("(8) Go Back to Previous Page");

         categorychoice = doCtrlChoice(8);
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
               System.out.println("**********APPETISERS***********");
               printItems(Category.APPETISER);
               System.out.println();
               System.out.println("**********MAINS***********");
               printItems(Category.MAIN);
               System.out.println();
               System.out.println("**********DESSERTS***********");
               printItems(Category.DESSERT);
               System.out.println();
               System.out.println("**********DRINKS***********");
               printItems(Category.DRINK);
               System.out.println();
               System.out.println("**********SPECIALS***********");
               printItems(Category.SPECIAL);
               System.out.println();
            	
            	
               break;   
               
            case 7: 
               Iterator<PromotionalPackage> iterator = Home.PromotionalPackages.iterator();
               boolean hasPromotionalPackage = false;
               
               //check if there are any promotional packages
               while (iterator.hasNext()){
                  hasPromotionalPackage = true;
                  PromotionalPackage pp = iterator.next();
                     
                  System.out.println("Package Name: " + pp.getName());
                  System.out.println("Package Price: $" + df.format(pp.getPrice()));
                  System.out.println("Package Description: " + pp.getDescription());
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
                  
               break; 
         }    
      } while(categorychoice != 8);  
   }
    
    // print out the menu for the category
   public void printItems(Category selectedCategory){
      boolean hasCategoryItem = false; 
         
      Iterator<Item> iter = Home.FullMenu.iterator();
      //sequential search and print menu item if it matches input category type
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
            System.out.println("Category of item: " );
            System.out.println("Select between: Main, Appetiser, Drink, Dessert, Special");
            String categoryStr = sc.next();
            sc.nextLine(); // works so don't remove
            Category category = Category.valueOf(categoryStr.toUpperCase());
         
            System.out.println("Name of item: ");
            String name = sc.nextLine();
         
         // prevent duplicate items 
            if (checkDuplicateItem(name, category) == true){
               break;
            }
         
            System.out.println("Price of item: (Enter numbers only) "); 
            double price = sc.nextDouble();
            sc.nextLine();
            
            System.out.println("Description of item: ");
            String description = sc.nextLine();
         
            Home.FullMenu.add(new Item(name, category, description, price));
         } catch (Exception e){
            System.out.println("Invalid input. Please try again.");
         }
      } while(false);
   }
   
   
   // (2)(2)(1) Create a new promotional package.
   public void createPromotionalPackage(){
      ArrayList<Item> packageItems = new ArrayList<Item>();
            
      System.out.println("Name of promotional package: ");
      //sc.nextLine();
      String packageName = sc.nextLine();
   
      System.out.println("Description of promotional package: ");
      String packageDescription = sc.nextLine();
   
      System.out.println("Price of promotional package: (Enter numbers only)");
      double packagePrice = sc.nextDouble();
             
      PromotionalPackage newPackage = new PromotionalPackage(packageName, packageDescription, packagePrice, packageItems);
      Home.PromotionalPackages.add(newPackage); 
      
      String choice;
      do {
         addItemToPromotionalPackage(newPackage);
         System.out.println("Continue adding menu item to promotional package? (Y/N)");
         choice = sc.next();
      } while(choice.equals("Y"));
      
     
      
   }
   
    //(2)(2)(2) Add items to promotional packages
   public void addItemToPromotionalPackage(PromotionalPackage pp){
      System.out.println("Category of item to add: " );
      System.out.println("Select between: Main, Appetiser, Drink, Dessert, Special");
      String categoryStr = sc.next();
      Category category = Category.valueOf(categoryStr.toUpperCase());
      printItems(category);
      
      boolean hasCategoryItem = false;
      Iterator<Item> iter = Home.FullMenu.iterator();
      while (iter.hasNext()){
         Item i = iter.next();
         if (i.category == category){
            hasCategoryItem = true;
         }
         
         if (hasCategoryItem == false){
            System.out.println("List is empty.");
         }
         
         else{
            System.out.println("Name of the item to add: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.println("Item added into Promotion Package.");
         
         
            int indexofItemtoAdd = getIndexByName(name, category);  
         // find the index of item and add it to the package
            if (indexofItemtoAdd == -1){
               System.out.println("Item does not exist. Please create the item first before adding it to any packages.");
            }
            
            else{
               Item tempAdd = Home.FullMenu.get(indexofItemtoAdd);
            
               pp.getPackageItems().add(tempAdd);
            }
         }
      }
   }
   
   
         
   
    //(3)(1) Remove Food Item
   public void removeFoodItem(){
      try{
         System.out.println("Category of the item to remove:" );
         System.out.println("Select between: Main, Appetiser, Drink, Dessert, Special");
         String categoryStrRemove = sc.next();
         Category categoryRemove = Category.valueOf(categoryStrRemove.toUpperCase());
         printItems(categoryRemove);
      
         System.out.println("Name of the item to remove: ");
         sc.nextLine();
         String removeName = sc.nextLine();
         
         //search for food item by name and remove it
         Iterator<Item> iter = Home.FullMenu.iterator();
         while (iter.hasNext()){
            Item i = iter.next();
            if(i.category.equals(categoryRemove)){
               if (i.getName().equals(removeName)){
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
      
      System.out.println("Name of promotional package to remove:");
      //sc.nextLine();
      String removePackage = sc.nextLine();
      
      //search for promotional package by name and remove it
      Iterator<PromotionalPackage> iterator = Home.PromotionalPackages.iterator();
      while (iterator.hasNext()){
         PromotionalPackage pp = iterator.next();
         if(pp.getName().equals(removePackage)){
            iterator.remove();
            System.out.println("Package removed. ");
         }
      }
   }
   
   // (3)(2)(2) Remove Item from Promotional Package
   public void removeItemFromPackage(PromotionalPackage pp){
      //print items in promo package
      Iterator<PromotionalPackage> iterator = Home.PromotionalPackages.iterator();
      boolean hasPromotionalPackage = false;
       
      while (iterator.hasNext()){
         hasPromotionalPackage = true;
         PromotionalPackage pp2 = iterator.next();
             
         System.out.println("Package Name: " + pp2.getName());
         System.out.println("Package Items: ");
             
             // print all the items in package
         ArrayList<Item> packageItems = pp2.getPackageItems();
         int index = 1;
         for (Item item: packageItems)
            System.out.println("(" + index++ + ") " + item.getName() + ", " + item.getCategory());
             
         System.out.println();
      }
          
      if (hasPromotionalPackage == false)
      {
         System.out.println("There are no promotional packages currently.");
      }
      //***********
   
      
      try{
         System.out.println("Category of the item to remove:" );
         System.out.println("Select between: Main, Appetiser, Drink, Dessert, Special");
         String categoryStrRemove = sc.next();
         Category categoryRemove = Category.valueOf(categoryStrRemove.toUpperCase());
            
         System.out.println("Name of the item to remove: ");
         sc.nextLine();
         String removeName = sc.nextLine();
         
         //search for specific item in promotional package by name and remove it
         Iterator<Item> iter = pp.getPackageItems().iterator();
         while (iter.hasNext()){
            Item i = iter.next();
            if(i.category.equals(categoryRemove)){
               if (i.getName().equals(removeName)){
                  iter.remove();
                  System.out.println("Item in Package removed. ");
               
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
            System.out.println("Category of the item to update:" );
            System.out.println("Select between: Main, Appetiser, Drink, Dessert, Special");
            String categoryStr = sc.next();
            sc.nextLine();
            Category category = Category.valueOf(categoryStr.toUpperCase());
            printItems(category);
         
            System.out.println("Name of the item to update: ");
            String name = sc.nextLine();
            
            int indexOfItem = getIndexByName(name, category);
            
            // user input to change attributes of existing item
            System.out.println("Choose what to update: ");
            System.out.println("(1) Name");
            System.out.println("(2) Price");
            System.out.println("(3) Description");
            System.out.println("(4) Category");
            System.out.println("(5) Return back to menu options");
            int updateChoice = doCtrlChoice(5);
            
            switch(updateChoice)
            {
               case 1:
                  System.out.println("Enter new name: ");
                  //sc.nextLine();
                  String newName = sc.nextLine();
                  Home.FullMenu.get(indexOfItem).setName(newName);
                  System.out.println("Name of the item updated. ");
                  
                  break;
              
               case 2:
                  System.out.println("Enter new price: ");
                  double newPrice = sc.nextDouble();
                  Home.FullMenu.get(indexOfItem).setPrice(newPrice);
                  System.out.println("Price of the item updated. ");
                  
                  break;
                  
               case 3:
                  System.out.println("Enter new description: ");
                  String newDescription = sc.nextLine();
                  Home.FullMenu.get(indexOfItem).setDescription(newDescription);
                  System.out.println("Description of the item updated. ");
                  
                  break;
                  
               case 4:
                  System.out.println("Enter new category: ");
                  String newCategoryStr = sc.nextLine();
                  Category newCategory = Category.valueOf(newCategoryStr.toUpperCase());
                  Home.FullMenu.get(indexOfItem).setCategory(newCategory);
                  System.out.println("Category of the item updated. ");
            }
         }
         catch (Exception e){
            System.out.println("Invalid input. Please try again.");
         }
      } while(false);
   }
   
   //(4)(2) Update existing Promotional Package
   public void updatePromotionalPackage(){
      do{
         try{
            //print current package
            Iterator<PromotionalPackage> iterator = Home.PromotionalPackages.iterator();
            boolean hasPromotionalPackage = false;
             
            while (iterator.hasNext()){
               hasPromotionalPackage = true;
               PromotionalPackage pp = iterator.next();
                   
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
             //********
            System.out.println("What's the name of the promotional package to update? ");
            String name = sc.nextLine();
            
            int indexOfPackage = -1;
            for (int i = 0; i < Home.PromotionalPackages.size(); i++){
               PromotionalPackage p = Home.PromotionalPackages.get(i);
               if (p.getName().equals(name)){
                  indexOfPackage = i;
               }
            }
            
            if (indexOfPackage == -1){
               System.out.println("Promotional Package does not exist.");
            }
         
            System.out.println("Choose what to update: ");
            System.out.println("(1) Name");
            System.out.println("(2) Price");
            System.out.println("(3) Description");
            System.out.println("(4) Return back to menu options");
            int updateChoice = doCtrlChoice(4);
            
            switch(updateChoice)
            {
               case 1:
                  System.out.println("Enter new name: ");
                  //sc.nextLine();
                  String newName = sc.nextLine();
                  Home.PromotionalPackages.get(indexOfPackage).setName(newName);
                  System.out.println("Name of the promotion package updated. ");
                  
                  break;
              
               case 2:
                  System.out.println("Enter new price: ");
                  Double newPrice = sc.nextDouble();
                  Home.PromotionalPackages.get(indexOfPackage).setPrice(newPrice);
                  System.out.println("Price of the promotion package updated. ");
                  
                  break;
                  
               case 3:
                  System.out.println("Enter new description: ");
                  String newDescription = sc.nextLine();
                  Home.PromotionalPackages.get(indexOfPackage).setDescription(newDescription);
                  System.out.println("Description of the promotion package updated. ");
                  
                  break;
                  
               case 4:
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
      Iterator<Item> iterator = Home.FullMenu.iterator();
      while (iterator.hasNext()){
         Item i = iterator.next();
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
      for (int i = 0; i < Home.FullMenu.size(); i++) {
         Item temp = Home.FullMenu.get(i);
         
         if (temp !=null && temp.getName().equals(name) && temp.category.equals(category)) {
            return i;
         }
      }
        // not found
      return -1;
   }
      
}        




   

