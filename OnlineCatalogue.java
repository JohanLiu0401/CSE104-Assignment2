package assignment2;
import java.util.*;

public class OnlineCatalogue{

	public static void main(String[] args) {
		System.out.print("Welcome to the online quotation services, functions provided included the following:\n"
				+ "New\nUpdate\nAsk\nDelete\nQuit\n");//OnlineCatalogue interface information
		boolean start = true;
		while(start){
			System.out.println("Enter your command here:");
			Scanner sc = new Scanner(System.in);
			String input = sc.nextLine();
			if(input.equalsIgnoreCase("New")){
				Function.newProduct();//Add a new product
				Function.quit();
			}
			else if(input.equalsIgnoreCase("Update")){
				Function.update();//Update a product
				Function.quit();
			}
			else if(input.equalsIgnoreCase("Ask")){
				Function.ask();//Ask a product or products
				Function.quit();
			}
			else if(input.equalsIgnoreCase("Delete")){
				Function.delete();//Delete a product or products
				Function.quit();
			}
			else if(input.equalsIgnoreCase("Quit")){
				System.out.print("Quit successfully!");//Jump out of loop and quit the system
				start = false;
			}
			else{
				System.out.println("Invalid command!");//Print error dealing information for invalid command
			}
		}
	}
}
