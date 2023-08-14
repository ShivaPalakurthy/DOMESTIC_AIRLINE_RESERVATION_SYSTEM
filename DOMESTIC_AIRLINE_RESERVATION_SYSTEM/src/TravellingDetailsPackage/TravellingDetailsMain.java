package TravellingDetailsPackage;

public class TravellingDetailsMain {
	public static void main(String args[]) {
	System.out.println("Welecome to Travelling Details Table");
	TrevellingDetailsDAOJDBCImpl travellingdetailsDaoJDBCImpl=new TrevellingDetailsDAOJDBCImpl();
	travellingdetailsDaoJDBCImpl.getIntoAction();
}
}
