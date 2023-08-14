package AdminTablePackage;

public class AdminTableMain {
		public static void main(String args[]) {
			System.out.println("Welecome to Admin Table");
			AdminTableDAOJDBCImpl admintablejdbcimpl=new AdminTableDAOJDBCImpl();
			admintablejdbcimpl.getIntoAction();
		}
}	
