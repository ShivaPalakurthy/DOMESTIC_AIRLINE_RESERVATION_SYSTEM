package AdminTablePackage;

import java.util.LinkedList;

public interface AdminTableDAO {
	
	boolean add(AdminTable AT);

	boolean delete(int id);

	boolean update(AdminTable AT);

	AdminTable get(int id);
	
	default LinkedList<AdminTable> getAllList() {
		return null;
	}
}
