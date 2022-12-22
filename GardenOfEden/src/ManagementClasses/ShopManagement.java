package ManagementClasses;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

//will work on this class later
public class ShopManagement {
    public static double money = 1000.0; //how much money shokeeper has
    public static double totalRevenueEarnedPerDay; 
    public static Date date = new Date(); //it should be a timestamp i think
    
    //tracking order
    public ShopManagement()
    {
        totalRevenueEarnedPerDay = 0;
       //does date need default values
    }

    public ShopManagement(int maxNumberOfOrders, double totalRevenueEarnedPerDay, Date date) {
        this.totalRevenueEarnedPerDay = totalRevenueEarnedPerDay;
        this.date = date;
    }
}