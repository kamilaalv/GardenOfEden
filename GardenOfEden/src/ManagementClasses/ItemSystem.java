package ManagementClasses;
import java.util.ArrayList; 
import HasaClass.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;
import InheritanceClasses.*;
public class ItemSystem {
	
	private static ArrayList<Item> items= new ArrayList<Item>(); //flowers and flower jewelry in cart
	private static ArrayList<Bouquet> bouquets = new ArrayList<>();
	
	
	public static ArrayList<Item> getItems() {
		return items;
	}

	public static ArrayList<Bouquet> getBouquets() {
		return bouquets;
	}

	//this implementation is based with the GUI interface in mind, not the console one.

	public static boolean addFlowerJewelry(int Quantity, String FlowerJewelryType, boolean RealFake) {
		
		if(DbControls.getQuantityJew(FlowerJewelryType)<Quantity) 
			return false;
		for(int j=0; j<Quantity; j++)  //can order in bulk
		{
			FlowerJewelry f= new FlowerJewelry(FlowerJewelryType, RealFake);
			items.add(f);

		}
		 return true;
	
	}
	
	public static String DisplayBouquet()
	{
		String output="";
		Iterator<Bouquet> it = bouquets.iterator();
		while(it.hasNext())
		{
			Bouquet b= it.next();
			output+=b.toString() + "\n";
		}
		
		return output;
	}
	
	// -2 We do not have enough Flowers in Db. -1 User exceeded max
	public static double addFlowers(int Quantity, String FlowerType, String color)
	{ 
		
		if(DbControls.getQuantityFlower(FlowerType)<Quantity)
			return -2 ;
		
		for(int i=0; i<items.size(); i++) {
			if(items.get(i) instanceof Flower) {
				if(((Flower)items.get(i)).getFlowerType().equalsIgnoreCase(FlowerType))	{ //if flower type already is in cart
					if(Quantity + ((Flower)items.get(i)).getFlowerQuantity()> ((Flower) items.get(i)).getMaxQuantity())
		            {
						return -1;
		                }else 
		            {
		            	((Flower)items.get(i)).setFlowerQuantity(Quantity + ((Flower)items.get(i)).getFlowerQuantity()); // why it doesnt work??
		            	return items.get(i).getItemPrice();
		            }
				}	
			}
		}
		Flower f = new Flower(FlowerType, color, Quantity);
		if(Quantity> f.getMaxQuantity())
		{
			return -1;
		}
		double price= f.calculateDiscount(f.getItemPrice());
		//System.out.println(f.getItemPrice());
		items.add(f);
		return price;
	}

	
	//method checks only inventory, max quantity is checked is gui
	public static boolean addBouquet(Bouquet b) {
		
		for(Flower f: b.getFlowerQuantity()) {
			if(DbControls.getQuantityFlower(f.getFlowerType())<f.getFlowerQuantity())
				return false;
		}
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
			if(bouquets.get(i).getBouquetID() == ID) {
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
	
	
	public static void DiscardBouquets()
	{
		bouquets.removeAll(bouquets); 
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
	
	public static String cartToString() {
		String str = "";
		if(!items.isEmpty()) {
			str+="Items\n";
			str+="-----------------\n";
			for(Item item: items) {
				if(item instanceof Flower)
					str+= ((Flower)item).toString();
				else
					str+= ((FlowerJewelry)item).toString();
				
			}
		}
		
		if(!bouquets.isEmpty()) {
			str+="Bouquets\n";
			str+="-----------------\n";
			for(Bouquet b: bouquets) {
				str+= b.toString();
			}
		}
		return str;
	}


	//do we use this method?
	public static String GetLastItem()
	{
		String str="";
		
			for(int i=0; i<bouquets.size(); i++)
			{
				str=bouquets.get(i).toString() + "\n";
			}
			
			return str;
	}
	
}
