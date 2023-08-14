package UserTablePackage;

public class UserTableMain {
	public static void main(String args[]) {
	System.out.println("Welecome to User Table");
	UserTableDAOJDBCImpl usertablejdbcimpl=new UserTableDAOJDBCImpl();
	usertablejdbcimpl.getIntoAction();
    }
}
