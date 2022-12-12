package InheritanceClasses;
import java.util.Date;
import java.util.Scanner;

public class FlowerJewelry extends Item {
	private String flowerJewelryType;
	private boolean Real;
	private static int FlowerJewelrysAdded=0;

	
	public FlowerJewelry() {
		flowerJewelryType=null;
		Real=false;
		FlowerJewelrysAdded++;
	}
	

	public FlowerJewelry(double itemPrice, String flowerJewelryType, boolean fakeOrReal) {
		super(itemPrice);
		this.flowerJewelryType=flowerJewelryType;
		this.Real = fakeOrReal;
		FlowerJewelrysAdded++;

	}
	
	public FlowerJewelry(int itemId, String itemName,  double itemPrice, String flowerjewelryType, boolean Real) {
		super(itemId, itemName, itemPrice);
		this.flowerJewelryType = flowerjewelryType;
		this.Real = Real;
		FlowerJewelrysAdded++;

	}

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

	public boolean getFakeOrReal() {
		return Real;
	}

	public void setFakeOrReal(boolean fakeOrReal) {
		this.Real = fakeOrReal;
	}
	
	public int getNumberofFlowerJewelryInCart()
	{
		return FlowerJewelrysAdded;
	}
	
	public boolean fakeorReal() {
		
		if(getFakeOrReal())
		{
			return true;
		}
		
		return false;
		
	}

	@Override
	public void calculateDiscount(double OriginalPrice) {
		
		//Necklace=$10, Headwear=$25, Earings=$10, Bracelet=$15
		
				//giving discount on the 3rd Item
		if(EligibleForDiscount() && fakeorReal())  //if the flowers are real then give the discount && Eligibility
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
	
}
