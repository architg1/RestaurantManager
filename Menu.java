import java.util.*;

public class Menu {

	ArrayList<SetPackage> packages = new ArrayList<SetPackage>();
	ArrayList<Item> items = new ArrayList<Item>();

	public void addItem() {

		Item item = new Item();
		item.addItem();
		items.add(item);
		throw new UnsupportedOperationException();
	}

	public void addSetPackage() {

		SetPackage setPackage = new SetPackage();
		setPackage.createPackage();
		packages.add(setPackage);

		throw new UnsupportedOperationException();
	}

	public void removeItem() {

		Item item = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Which item would you like to remove? ");
		this.showAllItem();
		int choice = sc.nextInt();

		for(int i=0; i<items.size(); i++){
			if(choice==i){
				item = items.get(i);
			}
		}
		items.remove(item);

		throw new UnsupportedOperationException();
	}

	public void removeSetPackage() {
		SetPackage setPackage = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Which set package would you like to remove? ");
		this.showAllSetPackage();
		int choice = sc.nextInt();

		for(int i=0; i<packages.size(); i++){
			if(choice==i){
				setPackage = packages.get(i);
			}
		}
		packages.remove(setPackage);
		throw new UnsupportedOperationException();
	}

	public void showAllItem() {
		for(Item item: items){
			System.out.println(item.itemName);
		}

		throw new UnsupportedOperationException();
	}

	public void showAllSetPackage() {
		for(SetPackage setPackage: packages){
			System.out.println(setPackage.packageName);
		}
		throw new UnsupportedOperationException();
	}

	public void showMenu(){
		this.showAllItem();
		this.showAllSetPackage();
	}

	public void createMenu(){
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.println("1: Add item 2: Add package 3: Exit");
			int choice = sc.nextInt();

			if(choice==1) this.addItem();
			else if(choice==2) this.addSetPackage();
			else break;
		}
	}

}