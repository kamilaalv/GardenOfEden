package ManagementClasses;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

//will work on this class later
public class ShopManagement {
    public static double totalRevenueEarnedPerDay; 
    
    private static Timestamp date = new Timestamp(System.currentTimeMillis());
    private static SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
    public static String dateF = f.format(getDate()); //formatted date for display
	public static Timestamp getDate() {
		return date;
	}

	public static void setDate(Timestamp date) {
		ShopManagement.date = date;
	}

	
    
    
    

   
}