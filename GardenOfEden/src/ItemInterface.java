import java.util.Date;

public interface ItemInterface {
	
	public abstract void calculateDiscount(int itemQuantity,double Price);
	public abstract Date calculateDaystoExpiry(); //maybe charging less if the flower is about to die?

}
