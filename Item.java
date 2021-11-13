import java.io.Serializable;

public class Item extends MenuItem implements Serializable{
   public Category category;
   public String name;
   public double price;
   public String description;
   
   
   //constructor
   public Item(String name, Category category, String description, double price){
      this.price = price;
      this.category = category;
      this.name = name;
      this.description = description;
   }
   
   //accessors and setters
   public String getName(){
      return this.name;
   }
   
   public void setName(String name){
      this.name = name;
   }
   
   public double getPrice(){
      return this.price;
   }
   
   public void setPrice(double price){
      this.price = price;
   }
   
   public String getDescription(){
      return this.description;
   }
   
   public void setDescription(String description){
      this.description = description;
   }
   
   public Category getCategory(){
      return this.category;
   }
   
   public void setCategory(Category category){
      this.category = category;
   }
}
