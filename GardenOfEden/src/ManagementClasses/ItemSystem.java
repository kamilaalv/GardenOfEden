package ManagementClasses;
import java.util.ArrayList; 
import HasaClass.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import InheritanceClasses.*;
public class ItemSystem {
	
	private static ArrayList<Item> items= new ArrayList<Item>();
	private static ArrayList<Bouquet> bouquets = new ArrayList<>();
	// private static ArrayList<Flower> fBouquets= new ArrayList<>();  //array of flowers needed for bouquets only
	
	
	//this implementation is based with the GUI interface in mind, not the console one.

	
	
	public static boolean addFlowerJewelry(int ItemId, String ItemName, int Quantity, String FlowerJewelryType, boolean RealFake) {
		
		
		for(int i=0; i<items.size(); i++)
		{
			if(items.get(i) instanceof FlowerJewelry)
			if(ItemId==((FlowerJewelry)items.get(i)).getItemId())
			{
				return false;
			}
		}
		
		for(int j=0; j<Quantity; j++)  //can order in bulk
		{
			FlowerJewelry f= new FlowerJewelry(ItemName, FlowerJewelryType, RealFake);
			items.add(f);

		}
		
		
		
		 return true;
	
	}
	
	public static boolean addFlowers(int ItemId, String itemName, int Quantity, String FlowerType, String color)
	{
		
		/* for(int i=0; i<items.size(); i++)
		{
			if(items.get(i) instanceof Flower)
			if(ItemId==((Flower)items.get(i)).getItemId())
			{
				return false;
			}
		} 
		
		for(int j=0; j<Quantity; j++)  //can order in bulk
		{
			Flower f= new Flower(itemName, FlowerType, color);
			items.add(f);

		} */

		for(int i=0; i<items.size(); i++) {
			if(items.get(i) instanceof Flower) {
				if(items.get(i).getItemId() == ItemId) {
					
					((Flower)items.get(i)).setFlowerQuantity(Quantity + ((Flower)items.get(i)).getFlowerQuantity()); // why it doesnt work??

					return true;
				}
			}
		}

		Flower f = new Flower(itemName, FlowerType, color, Quantity);
		items.add(f);

		return true;

		// method always returns true, we need to put a limit to how much flowers can customer buy
		// bouquets have maxquantity, maybe we need it for flowers too
	}
	
	//int flowerQuantity, String flowerType, String color (before i changed it to ArrayList<Flower> flowerQuantity)
	public static boolean createBouquet(ArrayList<Flower> flowers, String card, String wrappingPaper) {

		//this place is for creating bouquet (addItems cannot implement Bouquet)->Has-A
		Bouquet b = new Bouquet();;
		int numOfFlowers = 0;

		for(int i=0; i<flowers.size(); i++) {
			numOfFlowers += flowers.get(i).getFlowerQuantity();
		}

		if(numOfFlowers >= b.getMaxQuantity()) {
			return false;
		}

		b = new Bouquet(flowers, card, wrappingPaper);
		bouquets.add(b);
		return true;
		
		/*
		if(flowerQuantity>=20)
		{
			return false;
		}else
		{
			for(int i=0; i<flowerQuantity; i++)
			{
			
				Flower f= new Flower(flowerType, color);
				fBouquets.add(f);
				
			}
			
			Bouquet b= new Bouquet(fBouquets, card, wrappingPaper);
			bouquets.add(b);
			return true;

		}
		*/
	}

	public static Item removeItem(int id) {
		for (int i=0; i<items.size(); i++) {
			if(items.get(i).getItemId() == id) {
				Item temp = items.get(i);
				items.remove(i);
				return temp;
			}
		}

		return null;
	}

	public static Item searchItem(int id) {
		for (int i=0; i<items.size(); i++) {
			if(items.get(i).getItemId() == id) {
				return items.get(i);
			}
		}

		return null;
	}

	// remove and search methods for bouquets doesnt work
	// because there is no unique identifier like an id for bouquets
	// maybe we can use index of the arraylist for these functions
	// since we are gonna list them in the gui, using their indexes
	public static Bouquet removeBouquet(int index) {  
		for (int i=0; i<bouquets.size(); i++) {
			if(i == index) {
				Bouquet temp = bouquets.get(i);
				bouquets.remove(i);
				return temp;
			}
		}

		return null;
	}

	public static Bouquet searchBouquet(int index) { //item IDs are indexes
		for (int i=0; i<bouquets.size(); i++) 
			if(i == index) 
				return bouquets.get(i);

		return null;
	}

	public static double calculateOverallItemPrice()
	{
		double PriceoftheCart=0f;

          for(Item item: items)
          {
        	  PriceoftheCart+=item.getItemPrice();
          }
		
          for(Bouquet bq: bouquets)
          {
        	  PriceoftheCart+=bq.getBouquetPrice();
          }
		
		return PriceoftheCart;
	}
	
	public static double calculateDiscountOnDate()
	{
		//Valentines day
		
		Calendar calender= Calendar.getInstance();
		int Month=calender.get(Calendar.MONTH);  //0 based system
		int Day= calender.get(Calendar.DAY_OF_MONTH);
		Month+=1;
		
		if(Month==2 && Day==14)
		{
		    //valentine discount
			//all items' prices including Bouquet will be dropped by 50%
			for(int i=0; i<items.size(); i++)
			{
				items.get(i).setItemPrice(items.get(i).getItemPrice() * .05f);
			}
			
			for(int i=0; i<bouquets.size(); i++)
			{
				bouquets.get(i).calculateBouquetPrice(); //we have to calculate the price first
				bouquets.get(i).setBouquetPrice(bouquets.get(i).getBouquetPrice() * .05f);

			}
		}

		
		return 0;
	}
	
}
