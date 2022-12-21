package ManagementClasses;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class DbControls {
	
	private static Connection myConn; //myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eden", "root", "");
	private static final SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static boolean displayInventory(){
			try {
				myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eden", "root", "9862");
				Statement myStmt = myConn.createStatement();
				ResultSet myRs = myStmt.executeQuery("select * from eden.inventory");
				while(myRs.next()) {
					System.out.println(myRs.getString("Name") + " "+ myRs.getString("Quantity") + " " + myRs.getString("DateBought"));
				}
				myConn.close();
				return true;
			} catch (SQLException e) {
				return false;
				//e.printStackTrace();
			}
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
	
	public static Map<Integer, Timestamp> getDatesBoughtByType(String type){
		try {
			Map<Integer, Timestamp> dates = new HashMap<Integer,Timestamp>();
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eden", "root", "9862");
			Statement myStmt = myConn.createStatement();
			if(type == "Baby's Breath")
				type = "Baby\\'s Breath";
			ResultSet myRs = myStmt.executeQuery("select ItemId, DateBought from eden.inventory where Name = '" + type + "'");
			while(myRs.next()) {
				Timestamp t = Timestamp.valueOf(myRs.getString("DateBought"));
				int id = Integer.parseInt(myRs.getString("ItemId"));
				dates.put(id, t);
			}
			return dates;
		} catch (SQLException e) {
			return null;
		}
		
	}
	
	//returns total quantity by type for flowers
	public static int getQuantityFlower(String type) {
		try {
			int q = 0;
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eden", "root", "9862");
			Statement myStmt = myConn.createStatement();
			ResultSet myRs = myStmt.executeQuery("select Quantity from eden.inventory where Name = '" + type + "'");
			while(myRs.next()) {
				q += Integer.parseInt(myRs.getString("Quantity"));
			}
			myConn.close();
			return q;
		} catch (SQLException e) {
			return 0;
		}
		
	}
	
	public static int getQuantityJew(String type) {
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eden", "root", "9862");
			Statement myStmt = myConn.createStatement();
			ResultSet myRs = myStmt.executeQuery("select Quantity from eden.jewelry_inventory where Name = '" + type + "'");
			myConn.close();
			return Integer.parseInt(myRs.getString("Quantity"));
		} catch (SQLException e) {
			return 0;
		}
		
	}
	
	public static Timestamp addDays(Timestamp date, int days) {
		Calendar cal = Calendar.getInstance();
	    cal.setTime(date);
	    cal.add(Calendar.DATE, days);
	    Timestamp newDate = new Timestamp(cal.getTime().getTime());
	    return newDate;
	}
	
	
	
	public static boolean deleteExpired() {
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eden", "root", "9862");
			Statement stmt = myConn.createStatement();
			String flowerName;
			for(String type : ItemOptions.FLOWER_TYPES) {
				if(type == "Baby's Breath")
					flowerName = "Baby\\'s Breath";
				else
					flowerName = type;
				Timestamp today = new Timestamp(System.currentTimeMillis());
				Map<Integer, Timestamp> datesBought = getDatesBoughtByType(flowerName);
				final int days = ItemOptions.EXPIRATION_DATES.get(type);
				
				for(Integer id: datesBought.keySet()){
					  if(today.compareTo(addDays(datesBought.get(id), days)) > 0 ) { 
						  String queryDelete = "delete from eden.inventory where ItemId = '" + id + "'"; //everything works till here
						  //havent tested only this try catch block
						  try {
							stmt.executeUpdate(queryDelete);
						  }catch (SQLException e) {
							//do nothing keep traversing
							//maybe print smtg wrong with id
						  }
					  }  
				}
			}
		}catch(Exception exc) {
			return false;
		}
		return true;

	}

	
	
	//for testing
	public static void main(String[] args){
		displayInventory();

	}
	//everything works
}

