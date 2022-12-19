package ManagementClasses;
import java.sql.*;
import java.text.SimpleDateFormat;

public class DbControls {
	
	private static Connection myConn; //myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eden", "root", "");
	
	public static boolean displayInventory(){
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eden", "root", "");
			Statement myStmt = myConn.createStatement();
			ResultSet myRs = myStmt.executeQuery("select * from eden.inventory");
			while(myRs.next()) {
				System.out.println(myRs.getString("Name") + " "+ myRs.getString("Quantity") + " " + myRs.getString("DateBought"));
			}
		} catch (SQLException e) {
			return false;
		}
		return true;
		
	}
	
	public static boolean setDateBoughtToNow() {
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eden", "root", "");
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			final SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			 
			Statement stmt = myConn.createStatement();
			String query = "update eden.inventory set DateBought = '" + f.format(timestamp)+"'";
			stmt.executeUpdate(query); 
		}catch(Exception exc) {
			return false;
		}
		return true;

	}
	
	public static boolean deleteExpired() {
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eden", "root", "");
			
		}catch(Exception exc) {
			return false;
		}
		return true;

	}
	
	//for testing
	public static void main(String[] args) {
		/*displayInventory();
		System.out.println(" ");
		setDateBoughtToNow();
		displayInventory();
		*/
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		final SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
	}
	
	//everything works
}

