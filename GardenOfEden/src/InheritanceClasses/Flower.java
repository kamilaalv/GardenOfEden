package InheritanceClasses;
import java.util.Date;
import java.util.Calendar;
import ManagementClasses.ItemOptions;
public class Flower extends Item{

	
	private String flowerType;
	private String color;
	private static int FlowersAdded=0;
	private final int MAX_ID_RANGE=400;
	private static int dummyID=1;
	public Flower()
	{
		super();
		this.flowerType=null;
		this.color=null;
		FlowersAdded++;
		GenerateID();
      
	}
	
	public Flower(String flowerType, String color) {
		super();
		this.flowerType = flowerType;
		this.color = color;
		FlowersAdded++;
		GenerateID();

	}
	
	public Flower(String itemName, String flowerType, String color) {
		super(itemName, ItemOptions.flowerPrices.get(flowerType));
		this.flowerType = flowerType;
		this.color = color;
		FlowersAdded++;
		GenerateID();


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

	
	public int getNumberOfFlowersIntheCart()
	{
		return FlowersAdded;
	}

	@Override
	public void calculateDiscount(double OriginalPrice)
	{
		//Criteria: If more than 10 standalone flowers of the same type are ordered, give a discount of 20% on each flower
		//The base price for now is $2/flower
		
		if(EligibleForDiscount())
		{
			this.setItemPrice(OriginalPrice*.8);
		}else
		{
			this.setItemPrice(OriginalPrice);
		}
		
		
	}

	@Override
	public boolean EligibleForDiscount() {
   
		 if(FlowersAdded>=10)
		 {
			 FlowersAdded=0;//reset the discount!
			 return true;
		 }
			 
			 

		return false;
	}
	
	public String toString()
	{
		return super.toString() + "\nFlower Type:" + this.flowerType +
				"\nColor: " + this.color ;
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
