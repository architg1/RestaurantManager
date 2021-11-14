import java.util.Scanner;
import java.util.ArrayList;
import java.io.Serializable;

public class PromotionalPackage extends MenuItem implements Serializable{
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
   
   //accessors and setters
   public String getName(){ return this.packageName; }
   
   public void setName(String packageName){
      this.packageName = packageName;
   }
   
   public String getDescription(){
      return this.packageDescription;
   }
   
   public void setDescription(String packageDescription){
      this.packageDescription = packageDescription;
   }
   
   public double getPrice(){
      return this.packagePrice;
   }
   
   public void setPrice(double packagePrice){
      this.packagePrice = packagePrice;
   }
   
   public ArrayList<Item> getPackageItems(){
      return this.packageItems;
   }
}
