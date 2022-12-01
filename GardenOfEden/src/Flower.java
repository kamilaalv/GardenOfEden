import java.util.Date;

public class Flower extends Item{

	
	private String flowerType;
	private String color;
	
	
	public Flower()
	{
		this.flowerType=null;
		this.color=null;
	}
	
	public Flower(String flowerType, String color) {
		super();
		this.flowerType = flowerType;
		this.color = color;
	}
	
	public Flower(int itemId, String itemName, int itemQuantity, double itemPrice, String flowerType, String color) {
		super(itemId, itemName, itemQuantity, itemPrice);
		this.flowerType = flowerType;
		this.color = color;
	}
	
	
	public String getFlowerType() {
		return flowerType;
	}

	public void setFlowerType(String flowerType) {
		this.flowerType = flowerType;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public Item displayItemType()
	{
		return null;
	}



	@Override
	public void calculateDiscount(int itemQuantity, double Price)
	{
		//Criteria: If more than 10 standalone flowers of the same type are ordered, give a discount of 20% on each flower
		//The base price for now is $2/flower
		double basePrice=Price;
		if(itemQuantity>10)
		{
			this.setItemPrice(basePrice*.8);
		}else
		{
			this.setItemPrice(basePrice);
		}
		
		
		
	}
	
	@Override
	public int calculateDaystoExpiry(Date current, Date Expiry)
	{
		return 0;
	}
         
}
