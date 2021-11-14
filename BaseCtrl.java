package out.production;
import java.io.*;
import java.util.*;

public abstract class BaseCtrl {
	
	   @SuppressWarnings("SameParameterValue")
	   public static int doCtrlChoice(int max) {
	        Scanner choiceInput = new Scanner(System.in);
	        int selection;
	        do {
	            System.out.print("Enter choice: ");
	            try {
	                selection = choiceInput.nextInt();
	                if ((selection > max) || selection < 1)
	                    System.out.println("Invalid Selection\n. Please select an option from 1 - " + max);
	            } catch (InputMismatchException e) {
	                selection = -1;
	                System.out.println("Invalid Input\n. Please enter a valid number");
	                choiceInput.nextLine();
	            }
	            System.out.println();
	        } while ((selection > max) || selection < 1);
	        return selection;
	    }
}
