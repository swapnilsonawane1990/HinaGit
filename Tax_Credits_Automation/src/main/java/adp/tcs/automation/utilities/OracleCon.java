package adp.tcs.automation.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import adp.tcs.automation.stepsfiles.BaseTempletSteps;

public class OracleCon extends BaseTempletSteps{

	private final String DBURL = "jdbc:oracle:thin:@//"+ loadPropValues("dbHost") +":1521/"+ loadPropValues("dbServiceName");
	private final String DBDRIVER = "oracle.jdbc.driver.OracleDriver";
	private final String DBUSER= loadPropValues("dbUser");
	private final String DBPASS= loadPropValues("dbPassword");
	private final String DBUSEREvoapp= loadPropValues("dbUserEvoapp");
	private final String DBPASSEvoapp= loadPropValues("dbPasswordEvoapp");
	
	 public Connection getConnection() {
	        System.out.println("-------- Oracle JDBC Connection Testing ------");
	        try {
	            Class.forName(DBDRIVER);
	        } catch (ClassNotFoundException e) {
	            System.out.println("Where is your Oracle JDBC Driver?");
	            e.printStackTrace();
	        }
	        System.out.println("Oracle JDBC Driver Registered!");
	        Connection connection = null;
	        try {
	            connection = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
	        	} catch (SQLException e) {
	            System.out.println("Connection Failed! Check output console");
	            e.printStackTrace();
	            }
	        if (connection != null) {
	            System.out.println("You made it, take control your database now!");
	        } else {
	            System.out.println("Failed to make connection!");
	        }	        
	        return connection;
	    }

	//to connect EvoApp
	public Connection getConnectionEvoApp() {
		System.out.println("-------- Oracle JDBC Connection Testing ------");
		try {
			Class.forName(DBDRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your Oracle JDBC Driver for evoAPP?");
			e.printStackTrace();
		}
		System.out.println("Oracle JDBC Driver Registered! evoAPP");
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(DBURL, DBUSEREvoapp, DBPASSEvoapp);
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console evoAPP");
			e.printStackTrace();
		}
		if (connection != null) {
			System.out.println("You made it, take control your database now! evoAPP");
		} else {
			System.out.println("Failed to make connection! evoAPP");
		}
		return connection;
	}
}
