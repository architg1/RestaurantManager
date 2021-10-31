import java.time.LocalTime;
import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;



public class Order {

	static final int itemTypes = 5;

	protected Table table;
	protected LocalTime timestamp;
	protected ArrayList<Item> items = new ArrayList<Item>();
	protected ArrayList<SetPackage> packages = new ArrayList<SetPackage>();

	Scanner sc = new Scanner(System.in);

	public Order(){
		table = null;
		timestamp = null;
		items = null;
		packages = null;
	}

	public void takeOrder(Menu menu){
		int choice = 0;

		do {
			System.out.println("What would you like to do?");
			System.out.println("1. See the menu");
			System.out.println("2. Add an item to the order");
			System.out.println("3. Add a set package to order");
			System.out.println("4. Remove an item from order");
			System.out.println("5. Remove a set package from order");
			System.out.println("6. Confirm your order");
			choice=sc.nextInt();

			switch(choice) {
				case 1:{
					menu.showMenu(); break;
				}

				case 2:{
					menu.showAllItem();
					this.addItem(menu); break;
				}

				case 3:{
					menu.showAllSetPackage();
					this.addSetPackage(menu); break;
				}

				case 4:{
					this.removeItem(menu); break;
				}

				case 5: {
					this.removeSetPackage(menu); break;
				}

				case 6:{
					System.out.println("Order confirmed.");
					break;
				}

				default:{
					System.out.println("Wrong choice! Please try again :)");
					break;
				}
			}
		}   while(choice!=5);
	}



	public void addItem(Menu menu) {
		//Menu menu = new Menu();
		Item item = null;

		menu.showAllItem();

		int choice = sc.nextInt();
		for(int i=0; i<menu.items.size(); i++){
			if(choice==i){
				item = menu.items.get(i);
			}
		}
		items.add(item);

		System.out.println("Your current order is: " + items + packages);
		throw new UnsupportedOperationException();
	}

	public void addSetPackage(Menu menu) {
		//Menu menu = new Menu();
		SetPackage setPackage = null;

		menu.showAllSetPackage();

		int choice = sc.nextInt();
		for(int i=0; i<menu.packages.size(); i++){
			if(choice==i){
				setPackage = menu.packages.get(i);
			}
		}
		packages.add(setPackage);

		System.out.println("Your current order is: " + items + packages);
		throw new UnsupportedOperationException();
	}


	public void removeItem(Menu menu) {
		//Menu menu = new Menu();
		Item item = null;

		menu.showAllItem();

		int choice = sc.nextInt();
		for(int i=0; i<menu.items.size(); i++){
			if(choice==i){
				item = menu.items.get(i);
			}
		}
		items.remove(item);

		System.out.println("Your current order is: " + items + packages);
		throw new UnsupportedOperationException();
	}

	public void removeSetPackage(Menu menu) {

		//Menu menu = new Menu();
		SetPackage setPackage = null;

		menu.showAllSetPackage();

		int choice = sc.nextInt();
		for(int i=0; i<menu.packages.size(); i++){
			if(choice==i){
				setPackage = menu.packages.get(i);
			}
		}
		packages.remove(setPackage);

		System.out.println("Your current order is: " + items + packages);
		throw new UnsupportedOperationException();
	}

}
