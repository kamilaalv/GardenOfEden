package ManagementClasses;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class DbControls {
	
	//I assuming that prices for buying items is twice less selling prices
	
	private static Connection myConn; //myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eden", "root", "9862");
	private static final SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static boolean displayInventory(){
			try {
				myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eden", "root", "9862");
				Statement myStmt = myConn.createStatement();
				ResultSet myRs = myStmt.executeQuery("select * from eden.inventory");
				while(myRs.next()) {
					System.out.println(myRs.getString("ItemId") + " " + myRs.getString("Name") + " "+ myRs.getString("Quantity") + " " + myRs.getString("DateBought"));
				}
				myConn.close();
				return true;
			} catch (SQLException e) {
				return false;
				//e.printStackTrace();
			}
	}
	
	public static boolean setAllDatesBoughtToNow() {
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eden", "root", "9862");
			myConn.setAutoCommit(false);
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			Statement stmt = myConn.createStatement();
			String query = "update eden.inventory set DateBought = '" + f.format(timestamp)+"'";
			stmt.executeUpdate(query); 
			myConn.commit();
			myConn.close();
		}catch(Exception exc) {
			try {
				myConn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
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
			myConn.close();
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
	
	
	public static String deleteExpiredByID(int id) {
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eden", "root", "9862");
			myConn.setAutoCommit(false);
			Statement stmt = myConn.createStatement();	
			String queryDelete = "delete from eden.inventory where ItemId = '" + id + "'"; //everything works till here
			try {
				stmt.executeUpdate(queryDelete);
			}catch (SQLException e) {
				return "Id does not exist. Please write to correct id";
			}
			myConn.commit();
			myConn.close();	    
		}catch(Exception exc) {
			try {
				myConn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return "Cannot connect to db";
		}
		return "Deleted Succesfully";
	}
	
	public static boolean deleteExpiredAll() {
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eden", "root", "9862");
			myConn.setAutoCommit(false);
			Statement stmt = myConn.createStatement();
			String flowerName;
			for(String type : ItemOptions.FLOWER_TYPES) {
				flowerName = (type == "Baby's Breath") ? "Baby\\'s Breath" : type;
				Timestamp today = new Timestamp(System.currentTimeMillis()); //today has to be taken from gui
				Map<Integer, Timestamp> datesBought = getDatesBoughtByType(flowerName);
				final int days = ItemOptions.EXPIRATION_DATES.get(type);
				
				for(Integer id: datesBought.keySet()){
					  if(today.compareTo(addDays(datesBought.get(id), days)) > 0 ) { 
						  String queryDelete = "delete from eden.inventory where ItemId = '" + id + "'"; //everything works till here
						  //havent tested only this try catch block
						  try {
							stmt.executeUpdate(queryDelete);
							myConn.commit();
						  }catch (SQLException e) {
							//do nothing keep traversing
							//maybe print smtg wrong with id
						  }
					  }  
				}
			}
			myConn.close();
		}catch(Exception exc) {
			try {
				myConn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false;
		}
		return true;

	}

	public static String addFlower(String type, int q) {
		if(ItemManagement.money-ItemOptions.FLOWER_PRICES.get(type)/2.0<0) {
			return "You do not have enough money";
		}
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eden", "root", "9862");
			myConn.setAutoCommit(false);
			Statement myStmt = myConn.createStatement();
			int newId = 0;
			ResultSet myRs = myStmt.executeQuery("SELECT MAX(ItemId) As LastId FROM eden.inventory");
			while(myRs.next()) {
				newId  = Integer.parseInt(myRs.getString("LastId")) + 1;
			}
			
			 String query = "insert into eden.inventory (ItemId, Name, Quantity) values (?, ?, ?)";
			 PreparedStatement preparedStmt = myConn.prepareStatement(query);
			 preparedStmt.setInt(1, newId);
		     preparedStmt.setString(2, type);
		     preparedStmt.setInt(3, q);
		     preparedStmt.execute();
		     myConn.commit();
			 myConn.close();
			 
			 ItemManagement.money -= ItemOptions.FLOWER_PRICES.get(type)/2.0;
			 return "Bought Succsesfully";
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				myConn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
				return "Could not rollback";
			}
			return "Db connection error";
			
		}
		
	}
	
	public static String addJewelry(String type, int q) {
		if(ItemManagement.money-ItemOptions.JEWELRY_PRICE.get(type)/2.0<0) {
			return "You do not have enough money";
		}
		try {
			 myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eden", "root", "9862");
			 myConn.setAutoCommit(false);
			 Statement myStmt = myConn.createStatement();
			 int currentQ = 0;
			 ResultSet myRs = myStmt.executeQuery("SELECT Quantity FROM eden.jewelry_inventory where JName = '" + type +"'");
				while(myRs.next()) {
					currentQ = Integer.parseInt(myRs.getString("Quantity"));
				}
			 String query = "update eden.jewelry_inventory set Quantity = ? where JName = ?";
			 PreparedStatement preparedStmt = myConn.prepareStatement(query);
		     preparedStmt.setInt(1, q + currentQ);
		     preparedStmt.setString(2, type);
		     preparedStmt.execute();
		     myConn.commit();
			 myConn.close();
			
			 ItemManagement.money -= ItemOptions.JEWELRY_PRICE.get(type)/2.0;
			 return "Bought Succsesfully";
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				myConn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
				return "Could not rollback";
			}
			return "Db connection error";
		}
		
	}
	
	//for testing
	public static void main(String[] args) throws SQLException{
		
		
	}
	//everything works
}

