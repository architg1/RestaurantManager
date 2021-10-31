import java.util.Scanner;

public class Staff {

	private Table table;
	private String staffName;
	private String gender;
	private long identificationNumber;
	private String title;
	private int maximumTables;
	private int currentTables;
	static private int totalNumber = 0;

	public Staff(){

		table = null;
		staffName = null;
		gender = null;
		identificationNumber = 0;
		title = null;
		totalNumber++;
		maximumTables = 3;
		currentTables = 0;
	}

	public Staff(String staffName, String gender, long identificationNumber, String title, int maximumTables){
		this.staffName = staffName;
		this.gender = gender;
		this.identificationNumber = identificationNumber;
		this.title = title;
		totalNumber++;
		this.maximumTables = maximumTables;
		this.currentTables = 0;
	}


	public boolean serveMoreTables(){
		if((maximumTables-currentTables) > 0 ) return true;
		else return false;
	}

	public void allocateTable(Table table){
		this.table = table;
		if(currentTables<maximumTables) this.currentTables++;
	}

	public void deallocateTable(){
		this.table = null;
		if(this.currentTables>0) this.currentTables--;
	}



}