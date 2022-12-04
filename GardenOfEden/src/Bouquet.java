import java.util.ArrayList;

public class Bouquet {

	public enum WRAPPINGPAPER  //enum for the color
	{
		RED("RED"),
		BLUE("BLUE"),
		PURPLE("PURPLE"),
		GREEN("GREEN");
		
		private final String wrapcolor;
		
		private WRAPPINGPAPER(String wrapcolor)
		{
			this.wrapcolor=wrapcolor;
		}
	}
	WRAPPINGPAPER wrappaper=null;

	
	private final double red=3f;
	private final double blue=4f;
	private final double green=5f;
	private final double purple=6f;

	
	private ArrayList<Flower> flowerQuantity= new ArrayList<>();
	private int maxQuantity;
	private String card;
	private String wrappingPaper;
	private ArrayList<String> Addons= new ArrayList<String>();
	private double BouquetPrice;
	private static int BouquetsCreated=0;
	
	
	
	public Bouquet() {
		maxQuantity=0;
		card=null;
		wrappingPaper=null;
		BouquetPrice=0;
		BouquetsCreated++;
	}
	
	
	public Bouquet(ArrayList<Flower> flowerQuantity, int maxQuantity, String card, String wrappingPaper,
			ArrayList<String> addons) {
		super();
		this.flowerQuantity = flowerQuantity;
		this.maxQuantity = maxQuantity;
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
		switch(wrappingPaper)
		{
			case "RED":
				wrappaper=wrappaper.RED;
				setBouquetPrice(getBouquetPrice() + red );
				break;
				
			case "GREEN":
				wrappaper=wrappaper.GREEN;
				setBouquetPrice(getBouquetPrice() + green );
				break;
				
			case "BLUE":
				wrappaper=wrappaper.BLUE;
				setBouquetPrice(getBouquetPrice() + blue );
				break;
			
			case "PURPLE":
				wrappaper=wrappaper.PURPLE;
				setBouquetPrice(getBouquetPrice() + purple );
				break;
				
		}
		
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
	
}
