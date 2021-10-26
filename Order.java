import java.time.LocalTime;
import java.util.*;
import java.util.ArrayList;


public class Order {

	Table table;
	private LocalTime timestamp;
	private Item[] items;
	private SetPackage[] packages;
	ArrayList<Item> orders = new ArrayList<Item>();

	/**
	 * 
	 * @param item
	 */
	public void addItem(Item item) {
		// TODO - implement Order.addItem
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
		orders.addAll((Collection<? extends Item>) setPackage);
		System.out.println("Your current order is: " + orders);
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param item
	 */
	public void removeItem(Item item) {
		// TODO - implement Order.removeItem
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
		orders.remove(setPackage);
		System.out.println("Your current order is: " + orders);
		throw new UnsupportedOperationException();
	}

}
