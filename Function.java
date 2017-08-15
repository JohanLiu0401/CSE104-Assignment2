package assignment2;
import java.util.*;

public class Function {
//	Add a new product
	public static void newProduct(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a new product:");
		String name = sc.nextLine();
		System.out.println("Enter Vendor name:");
		String vendor = sc.nextLine();
		String key = name.toLowerCase()+vendor.toLowerCase();
		if(Product.table.containsKey(key)){
			System.out.println("Product "+name+"("+vendor+") existes already.");
		}
		else{
			System.out.println("Selling price(RMB):");
			boolean inputValid = false;
			while(!inputValid){
				try{
					Scanner kb = new Scanner(System.in);
					int price = kb.nextInt();
					inputValid = true;
					Product newProduct = new Product();
					newProduct.setName(name);
					newProduct.setVendor(vendor);
					newProduct.setPrice(price);
					Product.table.put(key, newProduct);
					System.out.println("New product "+name+"("+vendor+") entred.");
				}
				catch(Exception e){
					System.out.println("Invalid price input, please input again:");
				}
			}	
		}
	}
	
//	Update a product
	public static void update(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter product name:");
		String name = sc.nextLine();
		System.out.println("Enter Vendor name:");
		String vendor = sc.nextLine();
		String key = name.toLowerCase() + vendor.toLowerCase();
		if(Product.table.containsKey(key)){
			System.out.println("Selling price(RMB):");
			boolean inputValid = false;
			while(!inputValid){
				try{
					Scanner kb = new Scanner(System.in);
					int price = kb.nextInt();
					Product p = Product.table.get(key);
					p.setPrice(price);
					inputValid = true;
					System.out.println("Product "+name+"("+vendor+") price updated.");
				}
				catch(Exception e){
					System.out.println("Invalid price input, please input again:");
				}
			}
		}
		else{
			System.out.println("No such this product!");
		}
	}
	
//	Ask a product or products
	public static void ask(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter product name:");
		String name = sc.nextLine();
		System.out.println("Enter vendor name:");
		String vendor = sc.nextLine();
		String key = name.toLowerCase()+vendor.toLowerCase();
		if(vendor.equals("")){
			int amount = 0;
			for(Map.Entry<String, Product> entry: Product.table.entrySet()){
				Product p = entry.getValue();
				if(p.getName().equalsIgnoreCase(name)){
					System.out.println("("+p.getName()+","+p.getVendor()+","+p.getPrice()+")");
					amount++;
				}
			}
			System.out.println(amount+" "+name+" entries found");
		}
		else{
			if(Product.table.containsKey(key)){
				Product p = Product.table.get(key);
				System.out.println("Selling price(RMB) of "+name+"/"+vendor+" is "+p.getPrice());
			}
			else{
				System.out.println("No such product!");
			}
		}
	}
	
//	Delete a product or products
	public static void delete(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter product name:");
		String name = sc.nextLine();
		System.out.println("Enter vendor name:");
		String vendor = sc.nextLine();
		String key = name.toLowerCase()+vendor.toLowerCase();
		if(vendor.equals("")){
			int amount=0;
			Iterator<String> itr = Product.table.keySet().iterator();
			while(itr.hasNext()){
				String keySearch = itr.next();
				if(Product.table.get(keySearch).getName().equalsIgnoreCase(name)){
					itr.remove();
					amount++;
				}
			}
			System.out.println(amount+" "+name+" entries deleted.");
		}
		else{
			if(Product.table.containsKey(key)){
				Product.table.remove(key);
				System.out.println(name+"/"+vendor+" is deleted");
			}
			else{
				System.out.println("No such product!");
			}
		}
	}
	
//	Ask the user to quit to the main interface
	public static void quit(){
		Scanner sc = new Scanner(System.in);
		boolean quit = false;
		while(!quit){
			System.out.println("Please enter \"Quit\" to return to main interface:");
			String input = sc.nextLine();
			if(input.equalsIgnoreCase("Quit")){
				quit = true;
			}
			else{
				System.out.println("Invalid input!");
			}
		}
	}
}
