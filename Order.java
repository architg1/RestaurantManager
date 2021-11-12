import java.time.LocalTime;
import java.util.*;
import java.io.Serializable;

public class Order implements Serializable {
   public Staff staff;
   public ArrayList<Item> orderItems;
   public ArrayList<PromotionalPackage> orderPackages;
   public LocalTime orderTime;
   public Table table;
   public int orderID;
   
   //Constructor for order
   public Order(Staff staff, ArrayList<Item> orderItems, ArrayList<PromotionalPackage> orderPackages, LocalTime orderTime, Table table){
      this.staff = staff;
      this.orderItems = orderItems;
      this.orderPackages = orderPackages;
      this.orderTime = orderTime;
      this.table = table;
   }
   
   public Staff getStaff(){
      return this.staff;
   }
   
   public ArrayList<Item> getOrderItems(){
      return this.orderItems;
   }
   
   public ArrayList<PromotionalPackage> getOrderPackages(){
      return this.orderPackages;
   }
   
   public LocalTime getOrderTime(){
      return this.orderTime;
   }
   
   public Table getTable(){
      return this.table;
   }

   public int getOrderID(){
      return orderID;
   }

}
