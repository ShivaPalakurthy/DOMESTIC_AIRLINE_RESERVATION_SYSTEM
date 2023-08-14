package PassengerBookingDetailsPackage;

public class PassengerBookingDetailsMain {
	public static void main(String args[]) {
	System.out.println("Welecome to Passenger Booking Details Table ");
	PassengerBookingDetailsDAOJDBCImpl passBookingdetailsDAOJdbcImpl=new PassengerBookingDetailsDAOJDBCImpl();
	passBookingdetailsDAOJdbcImpl.getIntoAction();
}
}
