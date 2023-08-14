package AdminTablePackage;

import Flight_DataPackage.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.Scanner;


public class AdminTableDAOJDBCImpl implements AdminTableDAO {
	Connection connection;
	ResultSet rs;

	int Admin_ID;
	String AdminName;
	String Email;
	String pass;
	Scanner sc = new Scanner(System.in);

	@Override
	public boolean add(AdminTable AT) {
		// TODO Auto-generated method stub
		try {
			connection = DatabaseConnection.getConnect();
			String sql = "INSERT INTO ADMINTABLE VALUES(?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, AT.getAdmin_ID());
			ps.setString(2, AT.getAdminName());
			ps.setString(3, AT.getEmail());
			ps.setString(4, AT.getPass());
			if (ps.executeUpdate() >= 1) {
				ps.close();
				DatabaseConnection.closeConn(connection);
				return true;
			} else {
				ps.close();
				DatabaseConnection.closeConn(connection);
				return false;
			}
		} catch (Exception e) {
			DatabaseConnection.closeConn(connection);
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		try {
			connection = DatabaseConnection.getConnect();
			String sql = "DELETE FROM ADMINTABLE WHERE ADMIN_ID=? ";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			if (ps.executeUpdate() >= 1) {
				ps.close();
				DatabaseConnection.closeConn(connection);
				return true;
			} else {
				ps.close();
				DatabaseConnection.closeConn(connection);
				return false;
			}
		} catch (Exception e) {
			DatabaseConnection.closeConn(connection);
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(AdminTable AT) {
		// TODO Auto-generated method stub
		try {
			connection = DatabaseConnection.getConnect();
			String sql = "UPDATE  ADMINTABLE SET ADMINNAME=? , EMAIL=? , PASS=? WHERE ADMIN_ID=? ";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, AT.getAdminName());
			ps.setString(2, AT.getEmail());
			ps.setString(3, AT.getPass());
			ps.setInt(4, AT.getAdmin_ID());
			if (ps.executeUpdate() >= 1) {
				ps.close();

				DatabaseConnection.closeConn(connection);
				return true;
			} else {
				ps.close();
				DatabaseConnection.closeConn(connection);
				return false;
			}
		} catch (Exception e) {
			DatabaseConnection.closeConn(connection);
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public AdminTable get(int id) {
		try {
			connection = DatabaseConnection.getConnect();
			String sql = "SELECT * FROM ADMINTABLE WHERE ADMIN_ID=? ";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				AdminTable At = new AdminTable(Admin_ID = rs.getInt(1), AdminName = rs.getString(2), Email = rs.getString(3),
						pass = rs.getString(4));
				return At;
			}
			ps.close();
			DatabaseConnection.closeConn(connection);
			return null;
		} catch (Exception e) {
			DatabaseConnection.closeConn(connection);
			e.printStackTrace();
			return null;

		}
	}

	@Override
	public LinkedList<AdminTable> getAllList() {
		// TODO Auto-generated method stub
		LinkedList<AdminTable> admintable = new LinkedList<AdminTable>();
		try {
			connection = DatabaseConnection.getConnect();
			String sql = "SELECT * FROM ADMINTABLE";
			PreparedStatement ps = connection.prepareStatement(sql);
			rs = ps.executeQuery(sql);
			while (rs.next()) {
				AdminTable at = new AdminTable(rs.getInt("ADMIN_ID"), rs.getString("ADMINNAME"), rs.getString("EMAIL"), rs.getString("PASS"));
				admintable.add(at);
			}
			ps.close();
			DatabaseConnection.closeConn(connection);
			return admintable;
		} catch (Exception e) {
			DatabaseConnection.closeConn(connection);
			e.printStackTrace();
			return null;
		}
	}

	public void getIntoAction() {

		System.out.println("Type 1 - Add Admin Details into the server ");
		System.out.println("Type 2 - Update Admin Details into the server ");
		System.out.println("Type 3 - Delete Admin Details from the server");
		System.out.println("Type 4 - Get All the Admin Details  from the server");
		System.out.println("Type 5 - Get Admin Details by Access_ID from the Server");
		System.out.println("Type 6 - Exit");
		System.out.println("Choice: ");

		int selection = sc.nextInt();
		switch (selection) {
		case 1:
			addAccessDetails();
			getIntoAction();
			break;
		case 2:
			updateAccessDetails();
			getIntoAction();
			break;
		case 3:
			deleteAccessDetails();
			getIntoAction();
			break;
		case 4:
			getAllAccessDetails();
			getIntoAction();
			break;
		case 5:
			getAccessDetailByID();
			getIntoAction();
			break;
		case 6:
			System.out.println("Closing the Admin Details Server Page...");
			break;
		default:
			System.out.println("\n" + "Invalid Choice." + "\n");
			getIntoAction();
		}
	}

	public void addAccessDetails() {
		try {
			System.out.println("Enter the Admin Id");
			Admin_ID= sc.nextInt();
			sc.nextLine();
			System.out.println("Enter the Admin Name");
			AdminName=sc.nextLine();
			System.out.println("Enter the Email Name");
			Email = sc.nextLine();
			System.out.println("Enter the password");
			pass = sc.nextLine();
			if(add(new AdminTable(Admin_ID,AdminName, Email, pass))) {
			System.out.println("			Admin Table Added Sucessfully");
			}
		} catch (Exception e) {
			System.out.println("		Oops! Admin Table are not Added ");
		}

	}

	public void updateAccessDetails() {
		try {
			System.out.println("Enter the Admin Id to be updated");
			Admin_ID = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter the Admin Name to be updated");
			AdminName=sc.nextLine();
			System.out.println("Enter the Email name to be updated");
			Email = sc.nextLine();
			System.out.println("Enter the password to be updated");
			pass = sc.nextLine();
			update(new AdminTable(Admin_ID,AdminName, Email, pass));
			System.out.println("			Admin Table Updated Sucessfully");
		} catch (Exception e) {
			System.out.println("		Oops! Admin Table are not Updated");
		}
	}

	public void deleteAccessDetails() {
		System.out.println("Enter the Admin Id of AdminTable which you want to delete");
		Admin_ID = sc.nextInt();
		try {
			if (delete(Admin_ID)) {
				System.out.println("              Admin Table with the given Admin Id is deleted Successfully");
			} else {
				System.out.println(
						"Sorry, Admin Table with the given Admin Id can't be deleted now or Database is empty");
			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	public void getAllAccessDetails() {
		LinkedList<AdminTable> AT = getAllList();
		for (AdminTable at : AT) {
			System.out.println(at);
		}
		System.out.println("\n\n\n");
	}

	public void getAccessDetailByID() {
		System.out.println("Enter the Admin Id of Admin Tables");
		Admin_ID = sc.nextInt();
		AdminTable x = get(Admin_ID);
		try {
			if (x != null)
				System.out.println(x);
			else
				System.out.println("Sorry Admin ID is not present in the Database or the Database is empty");
		} catch (Exception e) {
			System.err.println();
		}
	}
}
