import java.time.LocalTime;
import java.time.LocalDate;
import java.util.*;

public class Order {
   public Staff staff;
   public Item orderitem;
   public PromotionalPackage orderpp;
   public LocalTime orderts;
   public Table table;
   public int orderID;
   
   //Constructor for order
   public Order(Staff staff, Item orderitem, PromotionalPackage orderpp, LocalTime orderts, Table table){
      this.staff = staff;
      this.orderitem = orderitem;
      this.orderpp = orderpp;
      this.orderts = orderts;
      this.table = table;
   }
   
   public Staff getStaff(){
      return this.staff;
   }
   
   public Item getOrderItem(){
      return this.orderitem;
   }
   
   public PromotionalPackage getOrderPP(){
      return this.orderpp;
   }
   
   public LocalTime getOrderTS(){
      return this.orderts;
   }
   
   public Table getTable(){
      return this.table;
   }
   
   // order ID is the index of order in the Orders arraylist
   /*public int getOrderID(Order order){
      
   }*/
}
