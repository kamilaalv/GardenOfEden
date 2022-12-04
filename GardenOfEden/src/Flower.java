import java.util.Date;
import java.util.Calendar;
public class Flower extends Item{

	
	private String flowerType;
	private String color;
	private Date current;
	private Date expiryDate;
	private static int FlowersAdded=0;
	public Flower()
	{
		this.flowerType=null;
		this.color=null;
		current= new Date();
		FlowersAdded++;
      
	}
	
	public Flower(String flowerType, String color) {
		super();
		this.flowerType = flowerType;
		this.color = color;

	}
	
	public Flower(int itemId, String itemName, int itemQuantity, double itemPrice, String flowerType, String color) {
		super(itemId, itemName, itemQuantity, itemPrice);
		this.flowerType = flowerType;
		this.color = color;

	}
	
	
	public String getFlowerType() {
		return flowerType;
	}

	public void setFlowerType(String flowerType) {
		this.flowerType = flowerType;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	public int getNumberOfFlowersIntheCart()
	{
		return FlowersAdded;
	}
         

	@Override
	public void calculateDiscount(int itemQuantity, double Price)
	{
		//Criteria: If more than 10 standalone flowers of the same type are ordered, give a discount of 20% on each flower
		//The base price for now is $2/flower
		double basePrice=Price;
		if(itemQuantity>10)
		{
			this.setItemPrice(basePrice*.8);
		}else
		{
			this.setItemPrice(basePrice);
		}
		
		
	}
	
	@Override
	public Date calculateDaystoExpiry()
	{
		Calendar calender= Calendar.getInstance();
		
		switch(flowerType)
		{
		case "Rose":
			
			calender.add(Calendar.DAY_OF_MONTH,5); 
			break;
			
		case "Tulip":
			calender.add(Calendar.DAY_OF_MONTH,10);
			break;			
		case "Daffodil":
			calender.add(Calendar.DAY_OF_MONTH,12); 
			break;
		case "Violet":
			calender.add(Calendar.DAY_OF_MONTH,15); 
			break;
		case "Hyacinth":
			calender.add(Calendar.DAY_OF_MONTH,20); 
			break;
		case "Lilac":
			calender.add(Calendar.DAY_OF_MONTH,11); 
			break;
		case "Peony":
			calender.add(Calendar.DAY_OF_MONTH,25);
			break;
		case "Daisy":
			calender.add(Calendar.DAY_OF_MONTH,2);
			break;
		case "Baby's Breath":
			calender.add(Calendar.DAY_OF_MONTH,3); 
			break;
		case "Freesia":
			calender.add(Calendar.DAY_OF_MONTH,6); 
			break;
		case "Chrysanthemum":
			calender.add(Calendar.DAY_OF_MONTH,6); 
			break;
		case "Gladiolus":
			calender.add(Calendar.DAY_OF_MONTH,15); 
			break;
			
		}
		
		return expiryDate=calender.getTime();
	}


}
