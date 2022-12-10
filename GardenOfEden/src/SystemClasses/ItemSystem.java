package SystemClasses;
import java.util.ArrayList;
import HasaClass.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import InheritanceClasses.*;
public class ItemSystem {
	// Im making every method static to test them in main
	// Static labels, main and output lines will be deleted once gui is created
	
	private static ArrayList<Item> items= new ArrayList<Item>();
	private static ArrayList<Bouquet> bouquets = new ArrayList<>();
	private static ArrayList<Flower> fBouquets= new ArrayList<>();
	

	public static boolean addItems(int ItemId, String ItemName, int Quantity, double itemPrice) {
		
		return false;
	}
	
	public static boolean createBouquet(int flowerQuantity, String flowerType, String color, String card, String wrappingPaper)
	{
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
			return true;

		}
	}

	public static boolean removeItem(int id) {
		for (int i=0; i<items.size(); i++) {
			if(items.get(i).getItemId() == id) {
				items.remove(i);
				return true;
			}
		}

		return false;
	}

	public static boolean SearchItem(int id) {
		for (int i=0; i<items.size(); i++) 
			if(items.get(i).getItemId() == id) 
				return true;

		return false;
	}

	// remove and search methods for bouquets doesnt work
	// because there is no unique identifier like an id for bouquets
	// maybe we can use index of the arraylist for these functions
	// since we are gonna list them in the gui, using their indexes
	public static boolean removeBouquet(int index) {  
		for (int i=0; i<bouquets.size(); i++) {
			if(i == index) {
				items.remove(i);
				return true;
			}
		}

		return false;
	}

	public static boolean SearchBouquet(int index) { //item IDs are indexes
		for (int i=0; i<bouquets.size(); i++) 
			if(i == index) 
				return true;

		return false;
	}

	public static double OverallItemPrice()
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
	// calculate item price and discount methods are not implemented yet
	// but i think those methods should return void
	// because to return double, we would need the id of that item
	// so i think these methods should just calculate every item's price in the arraylist
	// we can use the getprice method to display the price in the gui
	
}
