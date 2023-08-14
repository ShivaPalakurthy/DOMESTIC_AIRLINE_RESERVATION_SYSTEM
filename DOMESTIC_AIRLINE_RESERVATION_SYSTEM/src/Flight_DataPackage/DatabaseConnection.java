package Flight_DataPackage;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	private DatabaseConnection() {

	}
	public static Connection getConnect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // Loads the driver
			

			// Establish Connection between our java application & databases
			Connection cnn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "c##shivapalakurthy",
					"1234567890");
			return cnn;
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}
	public static boolean closeConn(Connection cnn) {
		try {
			cnn.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}