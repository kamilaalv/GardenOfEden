
public class GardenOfEdenMain {

	public static void main(String[] args) {
		
	   // ItemSystem.addItems();
		FlowerJewelry j1= new FlowerJewelry(25,"Necklace", true);
		j1.DISCOUNT();

		System.out.println(j1.getItemPrice());
		System.out.println(j1.getFlowerJewelryAdded());
		FlowerJewelry j2= new FlowerJewelry(25,"Necklace", true);
		j2.DISCOUNT();

		System.out.println(j2.getItemPrice());
		System.out.println(j2.getFlowerJewelryAdded());
		FlowerJewelry j3= new FlowerJewelry(25,"Necklace", true);
	
		j3.DISCOUNT();

		System.out.println(j3.getItemPrice());
		System.out.println(j3.getFlowerJewelryAdded());

	

		
	


		
	

	}

}
