import java.util.Date;

public abstract class Item implements ItemInterface{

	protected int itemId;
	protected String itemName;
	protected String itemImage;
	protected int itemQuantity;
	protected double itemPrice;
	
	
	public Item() 
	{
		this.itemId=0;
		this.itemName=null;
		this.itemQuantity=0;
		this.itemPrice=0.0f;
		
	}


	public Item(int itemId, String itemName, int itemQuantity, double itemPrice) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemQuantity = itemQuantity;
		this.itemPrice = itemPrice;
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


	public int getItemQuantity() {
		return itemQuantity;
	}


	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}


	public double getItemPrice() {
		return itemPrice;
	}


	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}
	
	public abstract void calculateDiscount(int itemQuantity, double Price);
	public String toString()
	{
		return "\nItem ID: " + this.itemId +
				"\nItem Name: " + this.itemName +
				"\nItem Quantity: " + this.itemQuantity +
				"\nItem Price: " + this.itemPrice;
	}
	
	
	
	
}
