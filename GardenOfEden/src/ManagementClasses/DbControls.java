package ManagementClasses;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

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
	
	public static boolean idExists(int id) {
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eden", "root", "9862");
			Statement stmt = myConn.createStatement();
			PreparedStatement p = myConn.prepareStatement("select count(ItemId) as num from eden.inventory where ItemId = ?");
			p.setInt(1, id);
			ResultSet rs = p.executeQuery();
			while(rs.next()) {
				if(rs.getInt("num") == 0) {
					myConn.close();
					return false;
				}
				else {
					myConn.close();
					return true;
				}	
			}
		}catch(Exception exc) {
			
		}
		return false;
	}
	
	public static String deleteByID(int id) {
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eden", "root", "9862");
			myConn.setAutoCommit(false);
			Statement stmt = myConn.createStatement();
			String query = "delete from eden.inventory where ItemId =" + id;
			stmt.executeUpdate(query);
			myConn.commit();
			myConn.close();
			return "Deleted succesfully";
		} catch (SQLException e) {
			try {
				myConn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
			return "Cannot connect to the db";
		}
		
	}
	
	public static ArrayList<Integer> deleteExpiredAll() {
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eden", "root", "9862");
			myConn.setAutoCommit(false);
			Statement stmt = myConn.createStatement();
			String flowerName;
			ArrayList<Integer> out = new ArrayList<Integer>();
			for(String type : ItemOptions.FLOWER_TYPES) {
				flowerName = (type == "Baby's Breath") ? "Baby\\'s Breath" : type;
				Timestamp today = new Timestamp(System.currentTimeMillis()); //today has to be taken from gui
				Map<Integer, Timestamp> datesBought = getDatesBoughtByType(flowerName);
				final int days = ItemOptions.EXPIRATION_DATES.get(type);
				
				for(Integer id: datesBought.keySet()){
					  if(today.compareTo(addDays(datesBought.get(id), days)) > 0 ) { 
						  out.add(id);
						  String queryDelete = "delete from eden.inventory where ItemId = '" + id + "'"; //everything works till here
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
			return out;
		}catch(Exception exc) {
			try {
				myConn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}

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
		if (getQuantityFlower(ftype)<buyQ) //these lines might be unnecessary
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
	
	//first ItemSystem.addFlowerJewelry() must be called. thats is why i am not checking whether buyQ > q
	public static boolean sellJew (String type, int buyQ) {
		int q = getQuantityJew(type);
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
	
	public static int getQuantityStat(String type) {
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eden", "root", "9862");
			Statement myStmt = myConn.createStatement();
			ResultSet myRs = myStmt.executeQuery("select ItemQ from eden.statistics where ItemType = '" + type + "'");
			int q = 0;
			while(myRs.next())
				q =  myRs.getInt("Quantity");
			myConn.close();
			return q;
		} catch (SQLException e) {
			return 0;
		}
		
	}
	
	
	public static boolean recordStats() {
		Map<String, Integer> stat = ShopManagement.getStat();
	    try {
	    	myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eden", "root", "9862");
			myConn.setAutoCommit(false);
			for(Map.Entry<String, Integer> st : stat.entrySet()) 
			{
				
		    	Statement myStmt = myConn.createStatement();
		    	boolean exists = true;
		    	ResultSet myRs = myStmt.executeQuery("SELECT count(*) as c FROM eden.statistics where ItemType = '" + st.getKey() +"'");
		    	while(myRs.next()) {
		    		exists = Integer.parseInt(myRs.getString("c")) == 0 ? false : true;
		    		System.out.println(exists);
		    	}
		    	if(exists) {
		    		
		    		String query = "update eden.statistics set ItemQ = ? where ItemType = ?";
					PreparedStatement preparedStmt = myConn.prepareStatement(query);
					System.out.println(getQuantityStat(st.getKey()));
				    preparedStmt.setInt(1, getQuantityStat(st.getKey()) + st.getValue());
				    preparedStmt.setString(2, st.getKey());
				    preparedStmt.execute();
				  
		    	}
		    	else {
		    		 String query = "insert into eden.statistics (ItemType, ItemQ) values (?, ?)";
					 PreparedStatement preparedStmt = myConn.prepareStatement(query);
				     preparedStmt.setString(1, st.getKey());
				     preparedStmt.setInt(2, st.getValue());
				     preparedStmt.execute();
		    	}
		    	 myConn.commit();
		    }
			myConn.close();
			return true;
		} catch (SQLException e) {
			try {
				myConn.rollback();
			} catch (SQLException e1) {
				//e1.printStackTrace();
				return false;
			}
			return false;
			//e.printStackTrace();
		}
	    
	}

	public static String statsToString() {
		try {
			
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eden", "root", "9862");
			Statement myStmt = myConn.createStatement();
			ResultSet myRs = myStmt.executeQuery("select count(*) as len from eden.statistics");
			myRs.next();
			int len = myRs.getInt("len");
			if(len == 0)
				return "No Statistics have been recorder yet (";
			String res = "               Statistics for all time\n";
			res +="Format: Item Type xQuantity Bought\n";
			ResultSet rs = myStmt.executeQuery("select * from eden.statistics order by ItemQ");
			while(rs.next()) {
				res+= "\n            " + rs.getString("ItemType") + " x" + rs.getString("ItemQ");
			}
			myConn.close();
			return res;
		} catch (SQLException e) {
			return "Db Error";
			
		}
	}
	//for testing
	public static void main(String[] args) throws SQLException{
		ShopManagement.test();
		System.out.println(ShopManagement.getStat());
		recordStats();
	}
	//everything works
}

