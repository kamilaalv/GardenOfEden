import java.util.ArrayList;
import java.util.Scanner;

public class ItemSystem {
	// Im making every method static to test them in main
	// Static labels, main and output lines will be deleted once gui is created
	
	private static ArrayList<Item> items= new ArrayList<Item>();
	private static ArrayList<Bouquet> bouquets = new ArrayList<>();

	public static boolean addItems() {
		Scanner scan = new Scanner(System.in);
		System.out.print("\n(Flower/Bouquet/Jewelry): ");
		String choice = scan.next();

		// when add single flower button is clicked
		if(choice.equalsIgnoreCase("flower")) {
			Flower flower = new Flower();

			// these inputs will be implemented with gui in the future
			// no error-checking for now
			System.out.print("(Rose/Lily): ");
			flower.setFlowerType(scan.next());

			System.out.print("Quantity: ");
			flower.setItemQuantity(scan.nextInt());
			scan.skip("\\R");

			System.out.print("(Red/Purple): ");
			flower.setColor(scan.next());

			items.add(flower);
			return true;

		} else if(choice.equalsIgnoreCase("bouquet")) {
			// when make bouquet button is clicked

			Bouquet bouquet = new Bouquet();
			bouquet.setMaxQuantity(20); // for now
			int totquantity = 0;
			int flowerquantity;
			ArrayList<Flower> bqflowers = new ArrayList<>();

			do {
				Flower flower = new Flower();

				System.out.print("(Rose/Lily): ");
				flower.setFlowerType(scan.next());
				scan.skip("\\R");

				do {
					System.out.print("Quantity: ");
					flowerquantity = scan.nextInt();

					// checking if max flower quantity is reached
					if(totquantity + flowerquantity > bouquet.getMaxQuantity()) {
						System.out.print("Too many flowers!\nChange quantity?(yes/no): ");
						choice = scan.next();
					} else { 
						flower.setItemQuantity(flowerquantity); 
						totquantity += flowerquantity;
					}

				} while (choice.equalsIgnoreCase("yes"));

				// if user doesnt change the quantity by writing no
				// they wont be able to choose the color
				// and flowers wont be added to the bouquet
				if(!choice.equalsIgnoreCase("no")) {
					System.out.print("(Red/Purple): ");
					flower.setColor(scan.next());
					
					bqflowers.add(flower);
				}
				
	
				System.out.println("Add more flowers(yes/no): ");
				choice = scan.next();

			} while(choice.equalsIgnoreCase("yes"));
			bouquet.setFlowerQuantity(bqflowers);

			System.out.println("Writing on the card will be: ");
			bouquet.setCard(scan.nextLine());

			System.out.println("Wrapping paper color?(Red/Blue) ");
			bouquet.setWrappingPaper(scan.next());

			// not asking for add-ons for now
			
			bouquets.add(bouquet);
			return true;

		} else if(choice.equalsIgnoreCase("jewelry")) {
			FlowerJewelry flowerjwl = new FlowerJewelry();

			System.out.print("(HeadWear,Earings,Necklace,Bracelet): ");
			//flowerjwl.setFlowerJewelryType(scan.next());
			// why is flower jewelry type an array?

			System.out.print("(real/fake): ");
			if(scan.next().equalsIgnoreCase("real")){
				flowerjwl.setFakeOrReal(true);
			} else { flowerjwl.setFakeOrReal(false); }

			items.add(flowerjwl);
			return true;
		}

		return false;
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

	public static boolean SearchBouquet(int index) {
		for (int i=0; i<bouquets.size(); i++) 
			if(i == index) 
				return true;

		return false;
	}

	// calculate item price and discount methods are not implemented yet
	// but i think those methods should return void
	// because to return double, we would need the id of that item
	// so i think these methods should just calculate every item's price in the arraylist
	// we can use the getprice method to display the price in the gui
	
}
