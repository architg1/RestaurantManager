import java.time.LocalTime;
import java.util.*;
import java.util.ArrayList;


public class Order {

	Table table;
	private LocalTime timestamp;
	private Item[] items;
	private SetPackage[] packages;

	/**
	 * 
	 * @param item
	 */
	public void addItem(Item item) {
		// TODO - implement Order.addItem
		ArrayList<Item> orders = new ArrayList<Item>();
		orders.add(item);
		System.out.println("Your current order is: " + orders);
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param setPackage
	 */
	public void addSetPackage(SetPackage setPackage) {
		// TODO - implement Order.addSetPackage
		ArrayList<SetPackage> setPackages = new ArrayList<SetPackage>();
		setPackages.add(setPackage);
		System.out.println("Your current order is: " + setPackages);
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param item
	 */
	public void removeItem(Item item) {
		// TODO - implement Order.removeItem
		ArrayList<Item> orders = new ArrayList<Item>();
		orders.remove(item);
		System.out.println("Your current order is: " + orders);
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param setPackage
	 */
	public void removeSetPackage(SetPackage setPackage) {
		// TODO - implement Order.removeSetPackage
		ArrayList<SetPackage> setPackages = new ArrayList<SetPackage>();
		setPackages.remove(setPackage);
		System.out.println("Your current order is: " + setPackages);
		throw new UnsupportedOperationException();
	}

}
