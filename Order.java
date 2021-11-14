import java.time.LocalTime;
import java.time.LocalDate;
import java.util.*;
import java.io.Serializable;

public class Order implements Serializable {
   private  Staff staff;
   private ArrayList<Item> orderItems;
   private ArrayList<PromotionalPackage> orderPackages;
   private LocalTime orderTime;
   private LocalDate orderDate;
   private Table table;
   private int orderID;
   
  
   //Constructor for order
   public Order(Staff staff, ArrayList<Item> orderItems, ArrayList<PromotionalPackage> orderPackages, LocalTime orderTime, LocalDate orderDate, Table table){
      this.staff = staff;
      this.orderItems = orderItems;
      this.orderPackages = orderPackages;
      this.orderTime = orderTime;
      this.orderDate = orderDate;
      this.table = table;
      this.orderID = -1;
      
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

   public LocalDate getOrderDate() { 
      return this.orderDate; }
   
   public Table getTable(){
      return this.table;
   }

   public int getOrderID(){
      return orderID;
   }
   
   public void setOrderID(int orderID){
      this.orderID = orderID;
   }

}
