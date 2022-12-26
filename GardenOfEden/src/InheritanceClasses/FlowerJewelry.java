package InheritanceClasses;
import java.util.Date;
import java.util.Scanner;
import ManagementClasses.ItemOptions;

public class FlowerJewelry extends Item {
	private String flowerJewelryType;
	private boolean Real;
	private static int FlowerJewelrysAdded=0;
    private final int  LOWER_BOUND_ID=400;
    private final int UPPER_BOUND_ID=800;
	private static int dummyID=400;
	public FlowerJewelry() {
		super();
		flowerJewelryType=null;
		Real=false;
		FlowerJewelrysAdded++;
		GenerateID();
	}
	

	public FlowerJewelry( String flowerJewelryType, boolean Real) {
		super(ItemOptions.JEWELRY_PRICE.get(flowerJewelryType));
		this.flowerJewelryType=flowerJewelryType;
		this.Real = Real;
		FlowerJewelrysAdded++;
		GenerateID();


	}
	
	/*public FlowerJewelry(String itemName, String flowerjewelryType, boolean Real) {
		super(itemName, ItemOptions.JEWELRY_PRICE.get(flowerjewelryType));
		this.flowerJewelryType = flowerjewelryType;
		this.Real = Real;
		FlowerJewelrysAdded++;
		GenerateID();
	}*/

	public String getFlowerJewelryType() {
		return flowerJewelryType;
	}

	public int getFlowerJewelryAdded()
	{
		return FlowerJewelrysAdded;
	}
	public void setFlowerJewelryType(String flowerJewelryType) {
		this.flowerJewelryType = flowerJewelryType;
	}

	public boolean isReal() {
		return Real;
	}

	public void setFakeOrReal(boolean fakeOrReal) {
		this.Real = fakeOrReal;
	}
	
	public int getNumberofFlowerJewelryInCart()
	{
		return FlowerJewelrysAdded;
	}
	
	@Override
	public double calculateDiscount(double OriginalPrice) {
		
		//Necklace=$10, Headwear=$25, Earings=$10, Bracelet=$15
		
				//giving discount on the 3rd Item
		if(EligibleForDiscount() && isReal())  //if the flowers are real then give the discount && Eligibility
		{
			switch(flowerJewelryType)
			{
			case "Necklace":
				 itemPrice=OriginalPrice * .70; //30 percent discount
				break;
				
			case "Headwear":
				 itemPrice=OriginalPrice * .60; //40 percent discount

				break;
			case "Earings":
				 itemPrice=OriginalPrice * .60; //40 percent discount

				break;
				
			case "Bracelet":
				 itemPrice=OriginalPrice * .80; //20 percent discount

				break;
			}
		}
	
		return this.itemPrice;
		
	}


	@Override
	public boolean EligibleForDiscount() {
		
		if(FlowerJewelrysAdded>=3)
		{
			FlowerJewelrysAdded=0; //reset it
			return true;
		}
		
		return false;
	}

	public String toString()
	{
		return super.toString() + "\nFlower Jewelry Type:" + this.flowerJewelryType +
				"\nReal/Fake: " + this.Real;
	}


	@Override
	public void GenerateID() {
		// TODO Auto-generated method stub
	   
		if(dummyID>=LOWER_BOUND_ID && dummyID<UPPER_BOUND_ID)
		{
			this.itemId=dummyID;
			dummyID++;
		}
		
		if(dummyID==UPPER_BOUND_ID)
		{
			dummyID=LOWER_BOUND_ID;
		}
		
		
	}
	
}
