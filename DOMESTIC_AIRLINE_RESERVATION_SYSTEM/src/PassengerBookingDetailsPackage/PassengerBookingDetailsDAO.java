package PassengerBookingDetailsPackage;

import java.util.LinkedList;

public interface PassengerBookingDetailsDAO {
	boolean add(PassengerBookingDetails PBD);

	boolean delete(long id);

	boolean update(PassengerBookingDetails PBD);

	PassengerBookingDetails get(long id);
	
	default LinkedList<PassengerBookingDetails> getAllList() {
		return null;
	}
}
