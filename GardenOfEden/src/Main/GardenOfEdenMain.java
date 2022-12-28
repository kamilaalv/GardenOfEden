package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import GUI.Login;
import HasaClass.Bouquet;
import InheritanceClasses.Flower;
import ManagementClasses.DbControls;
import ManagementClasses.ItemSystem;

public class GardenOfEdenMain {

	public static void main(String[] args) throws SQLException {

		Login l= new Login();
		l.setVisible(true);
		
	}

}
