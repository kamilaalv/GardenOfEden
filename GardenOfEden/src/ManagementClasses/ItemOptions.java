package ManagementClasses;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//if anyone needs prices, types of items, colors do not write them manually take from this class
//its purpose is to reduce complexity in other classes
//if it is hard to traverse over something ask

//made everything final
//will add images later with your help
public class ItemOptions {
    public static final ArrayList<String> flowerImages = new ArrayList<String>();
    public static final ArrayList<String> flowerJewelryImages = new ArrayList<String>();
    public static final ArrayList<String> flowerTypes = new ArrayList<String>(Arrays.asList("Rose", "Tulip", "Daffodil", "Violet", "Hyacinth", "Lilac", "Peony", "Daisy", "Lily", "Baby's Breath", "Freesia", "Chrysanthemum", "Gladiolus"));
    public static final ArrayList<String> flowerColors = new ArrayList<String>(Arrays.asList("Red", "Pink", "White", "Yellow", "Purple", "Light Blue", "Blue", "Orange"));
    public static final ArrayList<String> flowerJewelryTypes = new ArrayList<String>(Arrays.asList("Earings", "Bracelet", "Necklace", "Headwear"));
    public static final ArrayList<String> bouquetWrapColor = new ArrayList<String>(Arrays.asList("White", "Beige", "Transparent", "Baby Pink", "Lilac", "Light Blue"));
    public static final ArrayList<String> addons= new ArrayList<String>(Arrays.asList("Crystals", "Feathers", "Chocolate", "Strawberries"));
    

    //prices are in $
    //i came up with them randomly
    public static final Map<String, Double> flowerPrices = new HashMap<String, Double>() {{
        put("Rose", 1.5);
        put("Tulip", 3.0);
        put("Daffodil", 1.8);
        put("Violet", 1.5);
        put("Hyacinth", 4.0);
        put("Lilac", 3.5);
        put("Peony", 3.5);
        put("Daisy", 0.75);
        put("Lily", 2.5);
        put("Baby's Breath", 0.5);
        put("Freesia", 3.5);
        put("Chrysanthemum", 1.5);
        put("Gladiolus", 2.5);
    }};

    //integers are days given flower stays fresh
    public static final Map<String, Integer> expirationDates = new HashMap<String, Integer>() {{
        put("Rose", 7);
        put("Tulip", 12);
        put("Daffodil", 10);
        put("Violet", 4);
        put("Hyacinth", 9);
        put("Lilac", 4);
        put("Peony", 5);
        put("Daisy", 10);
        put("Lily", 12);
        put("Baby's Breath", 9);
        put("Freesia", 21);
        put("Chrysanthemum", 10);
        put("Gladiolus", 9);
    }};

    public static final Map<String, Double> jewelryPrice = new HashMap<String, Double>() {{
        put("Earings", 10.0);
        put("Bracelet", 15.0);
        put("Necklaces", 10.0);
        put("Headwear", 25.0);
    }};


    // Hex Codes for colors in case we would need them in the gui
    //if not delete this hashMap
    public static final Map<String, String> colorHexCodes = new HashMap<String, String>() {{
        put("Red", "FF0000");
        put("Pink", "#FF69B4");
        put("White", "#FFFFFF");
        put("Yellow", "#FFD700");
        put("Purple", "#663399");
        put("Light Blue", "#87CEFA");
        put("Blue", "#191970");
        put("Orange", "#FF6347");
        put("Beige", "#D1C0A8");
        put("Baby Pink", "#F2ACB9");
        put("Lilac", "#E6D7FF");
    }};
    
    
}
