import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

public class ItemManagement {
    private static int  maxNumberOfOrders;
    private static double totalRevenueEarnedPerDay; 
    private static Date date = new Date(); 
    
    //tracking order
    public ItemManagement()
    {
        totalRevenueEarnedPerDay = 0;
        maxNumberOfOrders = 20; // just put random number for now
       //does date need default values
    }

    public ItemManagement(int maxNumberOfOrders, double totalRevenueEarnedPerDay, Date date) {
        this.maxNumberOfOrders = maxNumberOfOrders;
        this.totalRevenueEarnedPerDay = totalRevenueEarnedPerDay;
        this.date = date;
    }
}