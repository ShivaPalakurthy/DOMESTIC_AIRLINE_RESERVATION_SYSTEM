package Flight_DataPackage;

public class FlightDataMain {
	public static void main(String args[]) {
		System.out.println("Welecome to FlightData Table");
		FlightDataDAOJDBCImpl flightdataJdbcImpl=new FlightDataDAOJDBCImpl();
		flightdataJdbcImpl.getIntoAction();
	}
}
