import java.util.Date;

public interface ItemInterface {
	
	public abstract Item displayItemType();
	public abstract void calculateDiscount(int itemQuantity,double Price);
	public abstract int calculateDaystoExpiry(Date current, Date Expiry); //maybe charging less if the flower is about to die?

}
