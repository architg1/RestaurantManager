public class Item{
   
   protected Category category;
   protected String name;
   protected double price;
   protected String description;
   
   
   public Item(String name, Category category, String description, double price){
      this.price = price;
      this.category = category;
      this.name = name;
      this.description = description;
   }
   
   public String getName(){
      return this.name;
   }
   
   /*public Category getCategory(){
      return this.category;
   }*/
   
   public double getPrice(){
      return this.price;
   }
   
   public String getDescription(){
      return this.description;
   }
   
  
   
   @Override
    public String toString() {
      return (name + " " + category + " " + price + " " + description);
   }
}
