import java.io.Serializable;

public class Item implements Serializable{
   
   public Category category;
   public String name;
   public double price;
   public String description;
   
   
   public Item(String name, Category category, String description, double price){
      this.price = price;
      this.category = category;
      this.name = name;
      this.description = description;
   }
   
   public String getName(){
      return this.name;
   }
   
   public void setName(String name){
      this.name = name;
   }
   
   public double getPrice(){
      return this.price;
   }
   
   public void setPrice(Double price){
      this.price = price;
   }
   
   public String getDescription(){
      return this.description;
   }
   
   public void setDescription(String description){
      this.description = description;
   }
}