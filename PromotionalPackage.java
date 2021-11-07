import java.util.Scanner;
import java.util.ArrayList;
import java.io.Serializable;

public class PromotionalPackage implements Serializable{
   private static Scanner sc = new Scanner(System.in);
   
   public String packageName;
   public String packageDescription;
   public double packagePrice;
   public ArrayList<Item> packageItems;
   
   //constructor for PromotionalPackage
   public PromotionalPackage(String packageName, String packageDescription, double packagePrice, ArrayList<Item> packageItems){
      this.packageName = packageName;
      this.packageDescription = packageDescription;
      this.packagePrice = packagePrice;
      this.packageItems = packageItems;
   }
   
   //accessors
   public String getPackageName(){
      return this.packageName;
   }
   
   public void setPackageName(String packageName){
      this.packageName = packageName;
   }
   
   public String getPackageDescription(){
      return this.packageDescription;
   }
   
   public void setPackageDescription(String packageDescription){
      this.packageDescription = packageDescription;
   }
   
   public double getPackagePrice(){
      return this.packagePrice;
   }
   
   public void setPackagePrice(double packagePrice){
      this.packagePrice = packagePrice;
   }
   
   public ArrayList<Item> getPackageItems(){
      return this.packageItems;
   }
}
/*
import java.util.Scanner;
import java.util.ArrayList;
import java.io.Serializable;

public class PromotionalPackage implements Serializable{
   private static Scanner sc = new Scanner(System.in);
   
   public String packageName;
   public String packageDescription;
   public double packagePrice;
   public ArrayList<Item> packageItems;
   
   //constructor for PromotionalPackage
   public PromotionalPackage(String packageName, String packageDescription, double packagePrice, ArrayList<Item> packageItems){
      this.packageName = packageName;
      this.packageDescription = packageDescription;
      this.packagePrice = packagePrice;
      this.packageItems = packageItems;
   }
   
   //accessors
   public String getPackageName(){
      return this.packageName;
   }
   
   public void setPackageName(String packageName){
      this.packageName = packageName;
   }
   
   public String getPackageDescription(){
      return this.packageDescription;
   }
   
   public void setPackageDescription(String packageDescription){
      this.packageDescription = packageDescription;
   }
   
   public double getPackagePrice(){
      return this.packagePrice;
   }
   
   public void setPackagePrice(double packagePrice){
      this.packagePrice = packagePrice;
   }
   
   public ArrayList<Item> getPackageItems(){
      return this.packageItems;
   }
}
*/