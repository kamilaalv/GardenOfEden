import java.util.Date;
import java.util.Scanner;

public class FlowerJewelry extends Item{

	private String flowerJewelryType;
	private boolean Real;
	
	public FlowerJewelry() {
		super();
	}

	public FlowerJewelry(String flowerJewelryType, boolean fakeOrReal) {
		super();
		this.flowerJewelryType = flowerJewelryType;
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
		this.Real = Real;
	}
	
	public boolean fakeorReal() {
		Scanner input=new Scanner(System.in);
		String choice="";
		
		System.out.println("Do you want real or artificial flowers (r/a)? ");
		choice=input.next();
		
		if(choice.equalsIgnoreCase("r"))
			return true;
		else
			return false;
		
	}

	@Override
	public void calculateDiscount(int itemQuantity, double Price) {
		
		//first we have to find whether the user has
		//selecetd 3 items and if he has, we'll give the 4th item for free
		//but for that we have to store user's choice of jewelry as well
		
	}

	@Override
	public Date calculateDaystoExpiry() {
		
		return null;
	}
	

}
