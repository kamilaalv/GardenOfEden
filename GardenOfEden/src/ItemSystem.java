import java.util.ArrayList;
import java.util.Scanner;

public class ItemSystem {
	// Im making every method static to test them in main
	// Static labels, main and output lines will be deleted once gui is created
	
	private static ArrayList<Item> items= new ArrayList<Item>();

	public static boolean addItems() {
		Scanner scan = new Scanner(System.in);
		System.out.print("\n(Flower/Bouquet/Jewelry): ");
		String choice = scan.next();

		if(choice.equalsIgnoreCase("flower")) {
			Flower flower = new Flower();

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
			Bouquet bouquet = new Bouquet();
			bouquet.setMaxQuantity(10);
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

					if(totquantity + flowerquantity > bouquet.getMaxQuantity()) {
						System.out.print("Too many flowers!\nChange quantity?(yes/no): ");
						choice = scan.next();
					} else { 
						flower.setItemQuantity(flowerquantity); 
						totquantity += flowerquantity;
					}

				} while (choice.equalsIgnoreCase("yes"));

				if(choice.equalsIgnoreCase("no")) {
					return false;
				}
				
				System.out.print("(Red/Purple): ");
				flower.setColor(scan.next());

				bqflowers.add(flower);
				System.out.println("Add more flowers(yes/no): ");
				choice = scan.next();

			} while(choice.equalsIgnoreCase("yes"));
			bouquet.setFlowerQuantity(bqflowers);

			System.out.println("Writing on the card will be: ");
			bouquet.setCard(scan.nextLine());

			System.out.println("Wrapping paper color?(Red/Blue) ");
			bouquet.setWrappingPaper(scan.next());

			// not asking for add-ons for now
			// couldnt add bouquet to items because we made bouquet not an item
			// items.add(bouquet);
			return true;

		} else if(choice.equalsIgnoreCase("jewelry")) {
			FlowerJewelry flowerjwl = new FlowerJewelry();

			System.out.print("(HeadWear,Earings,Necklace,Bracelet): ");
			flowerjwl.setFlowerJewelryType(scan.next());
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

	public static boolean removeItems() {

		return false;
	}

	public static boolean SearchItem() {

		return false;
	}

	// why do we need 2 remove methods?
	public static boolean removeItem() {

		return false;
	}

}
