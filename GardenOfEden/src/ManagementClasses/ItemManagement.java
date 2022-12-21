package ManagementClasses;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

//will work on this class later
public class ItemManagement {
    private static doulbe totalRevenue;
    private static double totalRevenueEarnedPerDay; 
    private static Date date = new Date(); //it should be a timestamp i think
    
    //tracking order
    public ItemManagement()
    {
        totalRevenueEarnedPerDay = 0;
       //does date need default values
    }

    public ItemManagement(int maxNumberOfOrders, double totalRevenueEarnedPerDay, Date date) {
        this.totalRevenueEarnedPerDay = totalRevenueEarnedPerDay;
        this.date = date;
    }
}