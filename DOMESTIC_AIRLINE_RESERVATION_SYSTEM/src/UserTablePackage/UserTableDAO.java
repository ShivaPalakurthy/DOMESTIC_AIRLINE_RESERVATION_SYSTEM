package UserTablePackage;

import java.util.LinkedList;

public interface UserTableDAO {
	
	boolean add(UserTable UT);

	boolean delete(int id);

	boolean update(UserTable UT);

	UserTable get(int id);
	
	default LinkedList<UserTable> getAllList() {
		return null;
	}
}
