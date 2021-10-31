import java.util.Scanner;

public class Item  {

	public enum ItemType {
		MAIN,
		STARTER,
		DESSERT,
		DRINK,
		SPECIAL
	}

	protected String itemName;
	protected Item.ItemType itemType;
	protected Integer itemPrice;
	protected String itemDescription;

	public Item(){
		itemName = "null";
		itemType = null;
		itemPrice = 0;
		itemDescription = "food";
	}

	public Item(String itemName, Item.ItemType itemType, Integer itemPrice, String itemDescription){
		this.itemName = itemName;
		this.itemType = itemType;
		this.itemPrice = itemPrice;
		this.itemDescription = itemDescription;
	}

	public void addItem(){
		// create an item
		Scanner sc = new Scanner(System.in);
		System.out.println("What's the name of the item? ");
		String itemName = sc.next();
		this.itemName = itemName;
		System.out.println("What's the type of the item? ");
		Item.ItemType itemType = null; // throwaway value
		this.itemType = itemType;
		System.out.println("What's the price of the item? ");
		Integer itemPrice = sc.nextInt();
		this.itemPrice = itemPrice;
		System.out.println("What's the description of the item? ");
		String itemDescription = sc.nextLine();
		this.itemDescription = itemDescription;
	}

}