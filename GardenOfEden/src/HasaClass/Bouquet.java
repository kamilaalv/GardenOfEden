package HasaClass;
import java.util.ArrayList;
import InheritanceClasses.*;
public class Bouquet {
	
	private ArrayList<Flower> flowerQuantity= new ArrayList<>();
	private final int  MAX_QUANTITY=20;
	private int BouquetID;
	private String card;
	private String wrappingPaper;
	private double BouquetPrice;
	private static int BouquetsCreated=0;
    private final int  LOWER_BOUND_ID=800;
    private final int UPPER_BOUND_ID=900;
	private static int dummyID=800;
	
	
	
	public Bouquet() {
		card=null;
		wrappingPaper=null;
		BouquetPrice=0;
		BouquetsCreated++; //increments it
		GenerateID();
	}
	
	
	public Bouquet(ArrayList<Flower> flowerQuantity, String card, String wrappingPaper) {
		super();
		this.flowerQuantity.addAll(flowerQuantity);
		this.card = card;
		this.wrappingPaper = wrappingPaper;
		GenerateID();
		
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
		return MAX_QUANTITY;
	}
	
	public int getBouquetID() {
		return BouquetID;
	}


	public void setBouquetID(int bouquetID) {
		BouquetID = bouquetID;
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
		
		//price for 1 wrapping paper:3
		
		
	     setBouquetPrice(TotalPrice + 3);

		
		return getBouquetPrice();
		
	}
	
	public void GenerateID() {
		// TODO Auto-generated method stub
	   
		if(dummyID>=LOWER_BOUND_ID && dummyID<UPPER_BOUND_ID)
		{
			this.BouquetID=dummyID;
			dummyID++;
		}
		
		if(dummyID==UPPER_BOUND_ID)
		{
			dummyID=LOWER_BOUND_ID;
		}
		
		
	}
	
	public int CalculateFlowerQuantity()  //Will we need this method?
	{
		int quantity=0;
		for(Flower f: flowerQuantity)
		{
			quantity+= f.getFlowerQuantity();
			System.out.println(quantity);
		}
		
		return quantity;
	}
	
	public String toString()
	{
		int quantity= CalculateFlowerQuantity();
		System.out.println(quantity);
		return "\nQuantity of Flowers:" + quantity +
				"\nCard: " + this.card +
				"\nWrapping Paper: " + this.wrappingPaper +
	             "\nBouquet Price: " + this.BouquetPrice;
	             
	}



	
}
