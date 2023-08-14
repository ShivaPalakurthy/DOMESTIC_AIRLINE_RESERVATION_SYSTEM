package Flight_DataPackage;

import java.util.LinkedList;

public interface FlightDataDAO {
	boolean add(FlightData Fd);

	boolean delete(int id);

	boolean update(FlightData Fd);

	FlightData get(int id);
	
	default LinkedList<FlightData> getAllList() {
		return null;
	}
}
