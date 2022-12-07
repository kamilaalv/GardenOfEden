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
	

	public FlowerJewelry(String flowerJewelryType, boolean fakeOrReal) {
		super();
		this.flowerJewelryType=flowerJewelryType;
		this.Real = Real;
	}
	
	public FlowerJewelry(int itemId, String itemName, int itemQuantity, double itemPrice, String flowerType, String color) {
		super(itemId, itemName, itemQuantity, itemPrice);
		this.flowerJewelryType = flowerJewelryType;
		this.Real = Real;
	}

	public String getFlowerJewelryType() {
		return flowerJewelryType;
	}

	public void setFlowerJewelryType(String flowerJewelryType) {
		this.flowerJewelryType = flowerJewelryType;
	}

	public boolean isFakeOrReal() {
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
		Scanner input=new Scanner(System.in);
		String choice="";
		
		System.out.println("Do you want real or artificial flowers (r/a)? ");
		choice=input.next();
		
		if(choice.equalsIgnoreCase("r"))
			return true;  //true for Real
		else
			return false;  //false for fake
		
	}

	@Override
	public void calculateDiscount(int itemQuantity, double Price) {
		
		//Necklace=$10, Headwear=$25, Earings=$10, Bracelet=$15
		
		//giving discount on the 3rd Item
		
	}


	@Override
	public boolean EligibleForDiscount() {
		// TODO Auto-generated method stub
		return false;
	}

	
}
