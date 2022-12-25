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
	
	//first three methods are for JTable
	public static String[][] getFlowersData(){
			try {
				
				myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eden", "root", "9862");
				Statement myStmt = myConn.createStatement();
				ResultSet myRs = myStmt.executeQuery("select count(*) as len from eden.inventory");
				myRs.next();
				String[][] arr = new String[myRs.getInt("len")][4];
				int i = 0;
				ResultSet rs = myStmt.executeQuery("select * from eden.inventory");
				while(rs.next()) {
					arr[i][0] = rs.getString("ItemId");
					arr[i][1] = rs.getString("Name");
					arr[i][2] = rs.getString("Quantity");
					arr[i][3] = rs.getString("DateBought");
					i++;
				}
				myConn.close();
				return arr;
			} catch (SQLException e) {
				return null;
				//e.printStackTrace();
			}
	}
	
	public static String[][] getJewData(){
		try {
			
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eden", "root", "9862");
			Statement myStmt = myConn.createStatement();
			ResultSet myRs = myStmt.executeQuery("select count(*) as len from eden.jewelry_inventory");
			myRs.next();
			String[][] arr = new String[myRs.getInt("len")][2];
			int i = 0;
			ResultSet rs = myStmt.executeQuery("select * from eden.jewelry_inventory");
			while(rs.next()) {
				arr[i][0] = rs.getString("JName");
				arr[i][1] = rs.getString("Quantity");
				i++;
			}
			myConn.close();
			return arr;
		} catch (SQLException e) {
			return null;
			//e.printStackTrace();
		}
		
}
	
	//for updating JTable
	public static Object[] getLastFlower() {
		try {
			
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eden", "root", "9862");
			Statement myStmt = myConn.createStatement();
			String[] arr = new String[4];
			ResultSet rs = myStmt.executeQuery("SELECT * FROM eden.inventory WHERE ItemId=(SELECT max(ItemId) FROM  eden.inventory)");
			while(rs.next()) {
				arr[0] = rs.getString("ItemId");
				arr[1] = rs.getString("Name");
				arr[2] = rs.getString("Quantity");
				arr[3] = rs.getString("DateBought");
			}
			myConn.close();
			return (Object[])arr;
		} catch (SQLException e) {
			return null;
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
				int id = myRs.getInt("ItemId");
				dates.put(id, t);
			}
			myConn.close();
			return dates;
		} catch (SQLException e) {
			return null;
		}
		
	}
	
	public static Timestamp addDays(Timestamp date, int days) {
		Calendar cal = Calendar.getInstance();
	    cal.setTime(date);
	    cal.add(Calendar.DATE, days);
	    Timestamp newDate = new Timestamp(cal.getTime().getTime());
	    return newDate;
	}
	
	public static String deleteByID(int id) {
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
	
	public static boolean setMoney(double newMoney) {
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eden", "root", "9862");
			myConn.setAutoCommit(false);
			String query = "update eden.users set money=?";
			PreparedStatement preparedStmt = myConn.prepareStatement(query);
			preparedStmt.setDouble(1, newMoney);
			preparedStmt.execute();
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
	
	public static double getMoney() {
		double m = 0;
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eden", "root", "9862");
			myConn.setAutoCommit(false);
			Statement stmt = myConn.createStatement();
			ResultSet rs = stmt.executeQuery("select money from eden.users");
			
			while(rs.next())
				 m  = rs.getDouble("money");
			myConn.close();
			return m;
			
		}catch(Exception exc) {
			return -1;
		}
	}
	
	public static int getQuantityFlower(String type) {
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eden", "root", "9862");
			Statement myStmt = myConn.createStatement();
			ResultSet myRs = myStmt.executeQuery("select sum(Quantity)as total from eden.inventory where Name = '" + type + "'");
			while(myRs.next()) {
				return myRs.getInt("total");
			}
			myConn.close();
		
		} catch (SQLException e) {
			return 0;
		}
		return 0;	
	}
	
	public static boolean sellFlower(String ftype, int buyQ) {
		if (getQuantityFlower(ftype)<buyQ)
			return false;
		try {
			setMoney(getMoney() + ItemOptions.FLOWER_PRICES.get(ftype)* buyQ);
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eden", "root", "9862");
			myConn.setAutoCommit(false);
			Statement myStmt = myConn.createStatement();
			ResultSet myRs = myStmt.executeQuery("select ItemId, Quantity from eden.inventory where Name = '" + ftype +"' order by DateBought asc");
			while(myRs.next()) {
				int id = myRs.getInt("ItemId");
				int q = myRs.getInt("Quantity");
				if(q - buyQ > 0) {
					Statement stmt = myConn.createStatement();
					String u = "update eden.inventory set Quantity = Quantity - " + buyQ + " where ItemId = " + id;
					stmt.executeUpdate(u);
					myConn.commit();
					myConn.close();
					return true;
				}
				else {
					deleteByID(id);
					if(buyQ - q == 0) {
						//myConn.commit(); //do we need to commit here
						myConn.close();
						return true;
					}
				}	
			}
			
			
		
		} catch (SQLException e) {
			try {
				myConn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return false;
		}
		return false;
		
	}

	public static int getQuantityJew(String type) {
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eden", "root", "9862");
			Statement myStmt = myConn.createStatement();
			ResultSet myRs = myStmt.executeQuery("select Quantity from eden.jewelry_inventory where JName = '" + type + "'");
			int q = 0;
			while(myRs.next())
				q =  myRs.getInt("Quantity");
			myConn.close();
			return q;
		} catch (SQLException e) {
			return 0;
		}
		
	}
	
	public static boolean sellJew (String type, int buyQ) {
		int q = getQuantityJew(type);
		if(q<buyQ)
			return false;
		try {
			setMoney(getMoney()+ItemOptions.JEWELRY_PRICE.get(type)* buyQ);
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eden", "root", "9862");
			myConn.setAutoCommit(false);
			Statement stmt = myConn.createStatement();
			String query;
			if(q - buyQ > 0)
				query = "update eden.jewelry_inventory set Quantity = Quantity - " + buyQ + " where JName = '" + type + "'";
			else 
				query = "delete from eden.jewelry_inventory where JName = '" + type + "'";
			
			stmt.executeUpdate(query);
			myConn.commit();
			myConn.close();
			return true;
		
		} catch (SQLException e) {
			try {
				myConn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return false;
		}
	}
	
	public static String buyFlower(String type, int q) {
		if(getMoney()-ItemOptions.FLOWER_PRICES.get(type)*q/2.0<0) {
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
			 
			 setMoney(getMoney() - ItemOptions.FLOWER_PRICES.get(type)*q/2.0);
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
	
	public static String buyJewelry(String type, int q) {
		if(getMoney()-ItemOptions.JEWELRY_PRICE.get(type)*q/2.0<0) {
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
			
			 setMoney(getMoney() - ItemOptions.JEWELRY_PRICE.get(type)*q/2.0);
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
	
	//System.out.println(ItemOptions.JEWELRY_PRICE.get("Necklace")*7/2);	
		
	}
	//everything works
}

