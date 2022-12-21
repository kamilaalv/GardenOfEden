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
	
	
	//this implementation is based with the GUI interface in mind, not the console one.

	
	
	public static boolean addFlowerJewelry(/*int ItemId, String ItemName,*/ int Quantity, String FlowerJewelryType, boolean RealFake) {
		
		
		/*for(int i=0; i<items.size(); i++)
		{
			if(items.get(i) instanceof FlowerJewelry)
			if(ItemId==((FlowerJewelry)items.get(i)).getItemId())
			{
				return false;
			}
		}*/  //no need for this part
		
		//method will return false if user wants to order more than the quantity in inventory. (db part, Ill add it later)
		
		for(int j=0; j<Quantity; j++)  //can order in bulk
		{
			FlowerJewelry f= new FlowerJewelry(/*ItemName,*/ FlowerJewelryType, RealFake);
			items.add(f);

		}
		 return true;
	
	}
	
	public static boolean addFlowers(/*int ItemId, String itemName,*/int Quantity, String FlowerType, String color)
	{ 
		for(int i=0; i<items.size(); i++) {
			if(items.get(i) instanceof Flower) {
				//if(items.get(i).getItemId() == ItemId) {
				if(((Flower)items.get(i)).getFlowerType().equalsIgnoreCase(FlowerType))	{ //if flower type already is in cart
	                if(Quantity + ((Flower)items.get(i)).getFlowerQuantity()> ((Flower) items.get(i)).getMaxQuantity())
	                {
	                	return false;
	                }else 
	                {
	                	((Flower)items.get(i)).setFlowerQuantity(Quantity + ((Flower)items.get(i)).getFlowerQuantity()); // why it doesnt work??
						return true;
	                }
				}	
			}
		}
		 Flower f = new Flower(/*itemName,*/ FlowerType, color, Quantity);
		 if(Quantity> f.getMaxQuantity())
		 {
			 return false;
		 }
		 
		 
		items.add(f);
		return true;
	}
	
	//int flowerQuantity, String flowerType, String color (before i changed it to ArrayList<Flower> flowerQuantity)
	public static boolean createBouquet(ArrayList<Flower> flowers, String card, String wrappingPaper) {

		//this place is for creating bouquet (addItems cannot implement Bouquet)->Has-A
		Bouquet b = new Bouquet();
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
	public static Bouquet removeBouquet(int ID) {  
		for (int i=0; i<bouquets.size(); i++) {
			if(bouquets.get(i).getBouquetID() == ID) {
				Bouquet temp = bouquets.get(i);
				bouquets.remove(i);
				return temp;
			}
		}

		return null;
	}

	public static Bouquet searchBouquet(int ID) { //item IDs are indexes
		for (int i=0; i<bouquets.size(); i++) {
			if(items.get(i).getItemId() == ID) {
				return bouquets.get(i);
			}
		}
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
