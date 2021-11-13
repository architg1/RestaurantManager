import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalTime;
import java.time.LocalDate;

public class Manager {

    //initialise a menu and 2 array lists of tables and staff respectively
    private ArrayList<Table> tables = new ArrayList<Table>();
    private ArrayList<Staff> staff = new ArrayList<Staff>();
    private MenuCtrl menu = new MenuCtrl();

    Scanner sc = new Scanner(System.in);

    public void createMenu(){
        //call MenuOptions from MenuCtrl class
        menu.MenuOptions();
    }

    //adding a new table to the arraylist
    public void addTable(){
        System.out.println("What's the table ID?");
        int maximumSeating = sc.nextInt();

        System.out.println("What's the maximum table size?");
        long tableIdentification = sc.nextLong();

        Table newTable = new Table(tableIdentification, maximumSeating);
        tables.add(newTable);
    }

    //adding a new staff to the arraylist
    public void addStaff(){

        System.out.println("What's their name?");
        String staffName = sc.next();

        System.out.println("What's their gender?");
        String gender = sc.next();

        System.out.println("What's their identification number?");
        long tableIdentification = sc.nextLong();

        System.out.println("What's their title?");
        String title = sc.next();

        System.out.println("How many tables can they serve?");
        int maximumTables = sc.nextInt();

        Staff newStaff = new Staff(staffName, gender, tableIdentification, title, maximumTables);
        staff.add(newStaff);

    }

    
    public void makeReservation(){

        //get the reservation details
        System.out.println("What's your name?");
        String reservationName = sc.next();

        System.out.println("What's your contact number?");
        long reservationContact = sc.nextLong();

        System.out.println("How's many people?");
        int reservedSeating = sc.nextInt();

        System.out.println("Are you a member?");
        Boolean reservationMembership = sc.nextBoolean();

        LocalTime reservationTime = LocalTime.now();
        LocalDate reservationDate = LocalDate.now();

        //find a free table and staff to assign the reservation to
        for(Table table: tables){
            if(table.isReserved()==false && table.getMaximumSeating()<=reservedSeating){
                table.reserveTable(reservationName, reservationContact, reservationMembership, reservationDate, reservationTime, reservedSeating);
            }
            for(Staff staffMember: staff){
                if(staffMember.serveMoreTables()==true) table.setStaff(staffMember);
            }
        }

    }

}
