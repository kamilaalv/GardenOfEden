package ManagementClasses;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import HasaClass.Bouquet;
import InheritanceClasses.Flower;
import InheritanceClasses.FlowerJewelry;
import InheritanceClasses.Item;

public class ShopManagement {
    //public static double totalRevenueEarnedPerDay; 
    
    private static Timestamp date = new Timestamp(System.currentTimeMillis());
    private static SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
    public static String dateF = f.format(getDate()); //formatted date for display
	private static Map<String, Integer> stat = new HashMap<String, Integer>();
	
	public static void test() {
		stat.put("Rose", 10);
		stat.put("Nekclace", 3);
	}
	
    public static Timestamp getDate() {
		return date;
	}

	public static void setDate(Timestamp date) {
		ShopManagement.date = date;
	}
	

	public static Map<String, Integer> getStat() {
		return stat;
	}

	
	
	public static void addToStat(String type, int q) {
		if(stat.containsKey(type)) {
			stat.put(type,stat.get(type)+q);
		}
		else
			stat.put(type,q);
		
				
	}
	

	
	
	
	
	
    
    
    

   
}