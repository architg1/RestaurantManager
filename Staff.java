import java.io.Serializable;

public class Staff implements Serializable {
   private String staffName;
   private String gender;
   private long id;
   private String title;
   
   private Table table;
   private int maximumTables = 3;
   private int currentTables;
  
   
   // Constructor for Staff
   public Staff(String staffName, String gender, long id, String title, int maximumTables){
      this.staffName = staffName;
      this.gender = gender;
      this.id = id;
      this.title = title;
      this.maximumTables = maximumTables;
      this.currentTables = 0;
   }
   
   
   public String getStaffName(){
      return this.staffName;
   }
   
   public String getStaffGender(){
      return this.gender;
   }
   
   public long getStaffID(){
      return this.id;
   }
   
   public String getStaffTitle(){
      return this.title;
   }
   
   public boolean serveMoreTables(){
      if((maximumTables-currentTables) > 0 ) 
         return true;
      else 
         return false;
   }
   
   public void allocateTable(Table table){
      this.table = table;
      if(serveMoreTables() == true) 
         this.currentTables++;
   }
   
   public void deallocateTable(){
      this.table = null;
      if(this.currentTables>0) 
         this.currentTables--;
   }
}
