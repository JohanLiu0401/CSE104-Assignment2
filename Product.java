package assignment2;
import java.util.*;

public class Product {
	public static Hashtable<String,Product> table = new Hashtable<String,Product>();
	private String name;
	private String vendor;
	private int price;
	
	public String getName(){
		return this.name;
	}
	public String getVendor(){
		return this.vendor;
	}
	public int getPrice(){
		return this.price;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setVendor(String vendor){
		this.vendor = vendor;
	}
	public void setPrice(int price){
		this.price = price;
	}
	
}
