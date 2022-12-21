package InheritanceClasses;
import java.util.Date;
import java.util.Calendar;
import ManagementClasses.ItemOptions;
public class Flower extends Item{

	
	private String flowerType;
	private String color;
	private int quantity;
	private static int FlowersAdded=0;
	private final int MAX_ID_RANGE=400;
	private static int dummyID=1;
	private final int MAX_FLOWER_QUANTITY=20;
	

	public Flower()
	{
		super();
		this.flowerType=null;
		this.color=null;
		this.quantity=0;
		FlowersAdded++;
		GenerateID();
      
	}
	
	public Flower(String flowerType, String color, int quantity) {
		super();
		this.flowerType = flowerType;
		this.color = color;
		this.quantity = quantity;
		this.itemPrice= ItemOptions.FLOWER_PRICES.get(flowerType) * quantity;
		FlowersAdded++;
		GenerateID();

	}
	
	/*public Flower(String itemName, String flowerType, String color, int quantity) {
		super(itemName, ItemOptions.FLOWER_PRICES.get(flowerType) * quantity);
		this.flowerType = flowerType;
		this.color = color;
		this.quantity = quantity;
		FlowersAdded++;
		GenerateID();
	}*/
	
	
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

	public int getFlowerQuantity() {
		return quantity;
	}

	public void setFlowerQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getNumberOfFlowersIntheCart()
	{
		return FlowersAdded;
	}
	
	public int getMaxQuantity()
	{
		return MAX_FLOWER_QUANTITY;
	}


	@Override
	public double calculateDiscount(double OriginalPrice)
	{
		//Criteria: If more than 10 standalone flowers of the same type are ordered, give a discount of 20% on each flower
		//The base price for now is $2/flower
		
			if(EligibleForDiscount())
			{
				this.setItemPrice(OriginalPrice* .8);
			}else
			{
				this.setItemPrice(OriginalPrice);
			}
	
			return this.itemPrice;
		
	}

	@Override
	public boolean EligibleForDiscount() {
   
		 if(this.quantity>=10)
		 {
			 
			 return true;
		 }
		return false;
	}
	
	public String toString()
	{
		return super.toString() + "\nFlower Type:" + this.flowerType +
				"\nColor: " + this.color + "\nQuantity: " + quantity;
	}

	@Override
	public void GenerateID() {
		// TODO Auto-generated method stub
		if(FlowersAdded<MAX_ID_RANGE)
		{
			this.itemId=dummyID;
			dummyID++;

		}
		
		//for resuability
		if(FlowersAdded==MAX_ID_RANGE)
		{
			dummyID=0;
		}
		
		
	}
	



}
