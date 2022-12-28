package InheritanceClasses;
import java.util.Date;

public abstract class Item implements ItemInterface{

	protected int itemId;
	protected double itemPrice;
	
	
	public Item() 
	{
		this.itemId=0;
		this.itemPrice=0.0f;
		
	}

     public Item(double itemPrice)
     {
    	 this();
    	 this.itemPrice=itemPrice;
     }
	

	public int getItemId() {
		return itemId;
	}


	public void setItemId(int itemId) {
		this.itemId = itemId;
	}



	public double getItemPrice() {
		return itemPrice;
	}


	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}
	
	public abstract double calculateDiscount(double OriginalPrice);
	
	
	public String toString()
	{
		return "\nItem ID: " + this.itemId +
				"\nItem Price: " + this.itemPrice;
	}
	
	
	
	
}
