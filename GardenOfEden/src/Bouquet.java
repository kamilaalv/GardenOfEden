import java.util.ArrayList;

public class Bouquet {

	private ArrayList<Flower> flowerQuantity= new ArrayList<>();
	private int maxQuantity;
	private String card;
	private String wrappingPaper;
	private ArrayList<String> Addons= new ArrayList<String>();
	
	public Bouquet() {
		super();
	}

	public Bouquet(ArrayList<Flower> flowerQuantity, int maxQuantity, String card, String wrappingPaper,
			ArrayList<String> addons) {
		super();
		this.flowerQuantity = flowerQuantity;
		this.maxQuantity = maxQuantity;
		this.card = card;
		this.wrappingPaper = wrappingPaper;
		Addons = addons;
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

	public ArrayList<String> getAddons() {
		return Addons;
	}

	public void setAddons(ArrayList<String> addons) {
		Addons = addons;
	}
	
	public double calculateBouquetPrice() {
		return maxQuantity;
		
	}
	
}
