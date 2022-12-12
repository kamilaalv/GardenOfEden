package ManagementClasses;
import java.sql.*;

public class DbTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//1. get connection
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/flowershop", "221", "1111");
			//2. create a statement
			Statement myStmt = myConn.createStatement();
			
			ResultSet myRs = myStmt.executeQuery("select * from flowershop.inventory");
			//4. process the result set
			while(myRs.next()) {
				System.out.println(myRs.getString("Name") + " "+ myRs.getString("Quantity"));
			}
		}catch(Exception exc) {
			exc.printStackTrace();
		}
		
	}
}

