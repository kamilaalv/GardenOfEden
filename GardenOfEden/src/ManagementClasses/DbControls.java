package ManagementClasses;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DbControls {
	
	private static Connection myConn; //myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eden", "root", "");
	private static final SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
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
			//not finished
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eden", "root", "");
			String name = "";
			int days;
			for(String flower : ItemOptions.FLOWER_TYPES) {
				name = flower;
				days = ItemOptions.EXPIRATION_DATES.get(name);
				
				//add days to timestamp
					Timestamp date = new Timestamp(System.currentTimeMillis()); //should be taken from db for each record //maybe write that in a separate method
						//String getDateBought = "select DateBought from eden.inventory where name = '" + name + "'"; //maybe would delete where name part
						//prepare the result set
						
					Calendar cal = Calendar.getInstance();
					cal.setTime(date);
					cal.add(Calendar.DATE, days);
					Timestamp newT = new Timestamp(cal.getTime().getTime());
			    
			    Statement stmt = myConn.createStatement();
				String queryDelete = "delete from eden.inventory where DateBought > '" + f.format(newT) + "'" + " and Name = '"+ name + "'";
				//execute query
			}
			
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
		
		
		//add days to timestamp
		Timestamp date = new Timestamp(System.currentTimeMillis());
		Calendar cal = Calendar.getInstance();
	    cal.setTime(date);
	    cal.add(Calendar.DATE, 10);
	    Timestamp newT = new Timestamp(cal.getTime().getTime());
	    
	    System.out.println(f.format(newT));
	    
	  
		
	}
	
	//everything works
}

