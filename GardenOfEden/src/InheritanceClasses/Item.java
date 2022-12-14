package InheritanceClasses;
import java.util.Date;

public abstract class Item implements ItemInterface{

	protected int itemId;
	protected String itemName;
	protected String itemImage;
	protected double itemPrice;
	
	
	public Item() 
	{
		this.itemId=0;
		this.itemName=null;
		this.itemPrice=0.0f;
		
	}

     public Item(double itemPrice)
     {
    	 this();
    	 this.itemPrice=itemPrice;
     }
	public Item(String itemName, double itemPrice) {
		this(itemPrice); //for constructor chaining
		this.itemName = itemName;
	}


	public int getItemId() {
		return itemId;
	}


	public void setItemId(int itemId) {
		this.itemId = itemId;
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public String getItemImage() {
		return itemImage;
	}


	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}


	public double getItemPrice() {
		return itemPrice;
	}


	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}
	
	public abstract void calculateDiscount(double OriginalPrice);
	
	
	public String toString()
	{
		return "\nItem ID: " + this.itemId +
				"\nItem Name: " + this.itemName +
				"\nItem Price: " + this.itemPrice;
	}
	
	
	
	
}
