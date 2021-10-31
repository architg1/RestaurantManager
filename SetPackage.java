import java.util.*;

public class SetPackage {

	Menu menu;

	protected String packageName;
	protected double packagePrice;
	protected String packageDescription;
	protected int numberOfItems;
	protected ArrayList<Item> packageItems = new ArrayList<Item>();

	public SetPackage(){
		packageName = "null";
		packagePrice = 0;
		packageDescription = "food";
		packageItems = null;
	}

	public SetPackage(String packageName, double packagePrice, String packageDescription, ArrayList<Item> packageItems){
		this.packageName = packageName;
		this.packagePrice = packagePrice;
		this.packageDescription = packageDescription;
		this.packageItems = packageItems;
	}

	public void createPackage(){

		Scanner sc = new Scanner(System.in);
		System.out.println("What's the name of the set package? ");
		String packageName = sc.next();
		this.packageName = packageName;

		System.out.println("What's the type of the describe? ");
		String packageDescription = sc.nextLine();
		this.packageDescription = packageDescription;

		System.out.println("What's the price of the item? ");
		Integer packagePrice = sc.nextInt();
		this.packagePrice = packagePrice;

		while(true) {
			this.addItem();
			System.out.println("Do you want to add more items? ");
			String choice = sc.next();
			if(choice=="No") break;
		}

		this.viewPackage();
	}

	public void addItem() {
		Item item = new Item();
		item.addItem();
		packageItems.add(item);
		this.numberOfItems++;

		throw new UnsupportedOperationException();
	}

	public void removeItem() {
		Item item = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Which item would you like to remove? ");
		viewPackage();
		int choice = sc.nextInt();
		for(int i=0; i<numberOfItems; i++){
			if(choice==i){
				item = packageItems.get(i);
			}
		}

		packageItems.remove(item);
		throw new UnsupportedOperationException();
	}

	public void viewPackage(){

		for(Item item : packageItems){
			System.out.println("Name: " + item.itemName);
			System.out.println("Cost: " + item.itemPrice);
			System.out.println("Type: " + item.itemType);
			System.out.println("Description: " + item.itemDescription);
		}
	}

}