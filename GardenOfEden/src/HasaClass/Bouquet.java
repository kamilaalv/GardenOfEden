package HasaClass;
import java.util.ArrayList;
import InheritanceClasses.*;
public class Bouquet {
	
	private ArrayList<Flower> flowerQuantity= new ArrayList<>();
	private int maxQuantity;
	private String card;
	private String wrappingPaper;
	private double BouquetPrice;
	private static int BouquetsCreated=0;
	
	
	
	public Bouquet() {
		maxQuantity=0;
		card=null;
		wrappingPaper=null;
		BouquetPrice=0;
		BouquetsCreated++; //increments it
	}
	
	
	public Bouquet(ArrayList<Flower> flowerQuantity, String card, String wrappingPaper) {
		super();
		this.flowerQuantity = flowerQuantity;
		this.card = card;
		this.wrappingPaper = wrappingPaper;
		
	}

	public double getBouquetPrice() {
		return BouquetPrice;
	}

	public void setBouquetPrice(double bouquetPrice) {
		BouquetPrice = bouquetPrice;
	}

	public ArrayList<Flower> getFlowerQuantity() {
		return flowerQuantity;
	}

	public void setFlowerQuantity(ArrayList<Flower> flowerQuantity) {
		this.flowerQuantity = flowerQuantity;
	}

	public int getMaxQuantity() {
		return maxQuantity;
	}

	public void setMaxQuantity(int maxQuantity) {
		this.maxQuantity = maxQuantity;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public String getWrappingPaper() {
		return wrappingPaper;
	}

	public void setWrappingPaper(String wrappingPaper) {
		this.wrappingPaper = wrappingPaper;
	}

	
	public int getNumberofBouquetsInCart()

	{
		return BouquetsCreated;
	}
	public double calculateBouquetPrice() {
		
		double TotalPrice = 0;
		
		if(flowerQuantity.size()==0)
		{
			return 0;
		}
		
		for(int i=0; i<flowerQuantity.size(); i++)
		{
			TotalPrice+= flowerQuantity.get(i).getItemPrice();
		}
		
		setBouquetPrice(TotalPrice);
		return getBouquetPrice();
		
	}
	
	public String toString()
	{
		return "\nQuantity of Flowers:" + flowerQuantity.size() +
				"\nCard: " + this.card +
				"\nWrapping Paper: " + this.wrappingPaper +
	             "\nBouquet Price: " + this.BouquetPrice;
	             
	}
	
}
