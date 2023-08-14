package TravellingDetailsPackage;

import java.util.LinkedList;

public interface TravellingDetailsDAO {
	boolean add(TravellingDetails TD);

	boolean delete(int id);

	boolean update(TravellingDetails TD);

	TravellingDetails get(int id);

	default LinkedList<TravellingDetails> getAllList() {
		return null;
	}
}
