package UserTablePackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.Scanner;

import Flight_DataPackage.DatabaseConnection;

public class UserTableDAOJDBCImpl implements UserTableDAO {
	Connection connection;
	ResultSet rs;

	int User_ID;
	String UserName;
	String Email;
	String pass;
	Scanner sc = new Scanner(System.in);

	@Override
	public boolean add(UserTable AT) {
		// TODO Auto-generated method stub
		try {
			connection = DatabaseConnection.getConnect();
			String sql = "INSERT INTO USER_TABLE VALUES(?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, AT.getUser_ID());
			ps.setString(2, AT.getUserName());
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
			String sql = "DELETE FROM USER_TABLE WHERE USER_ID=? ";
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
	public boolean update(UserTable AT) {
		// TODO Auto-generated method stub
		try {
			connection = DatabaseConnection.getConnect();
			String sql = "UPDATE  USER_TABLE SET USERNAME=? , EMAIL=? , PASS=? WHERE USER_ID=? ";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, AT.getUserName());
			ps.setString(2, AT.getEmail());
			ps.setString(3, AT.getPass());
			ps.setInt(4, AT.getUser_ID());
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
	public UserTable get(int id) {
		try {
			connection = DatabaseConnection.getConnect();
			String sql = "SELECT * FROM USER_TABLE WHERE USER_ID=? ";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				UserTable At = new UserTable(User_ID = rs.getInt(1), UserName = rs.getString(2), Email = rs.getString(3),
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
	public LinkedList<UserTable> getAllList() {
		// TODO Auto-generated method stub
		LinkedList<UserTable> usertable = new LinkedList<UserTable>();
		try {
			connection = DatabaseConnection.getConnect();
			String sql = "SELECT * FROM USER_TABLE";
			PreparedStatement ps = connection.prepareStatement(sql);
			rs = ps.executeQuery(sql);
			while (rs.next()) {
				UserTable at = new UserTable(rs.getInt("USER_ID"), rs.getString("USERNAME"), rs.getString("EMAIL"), rs.getString("PASS"));
				usertable.add(at);
			}
			ps.close();
			DatabaseConnection.closeConn(connection);
			return usertable;
		} catch (Exception e) {
			DatabaseConnection.closeConn(connection);
			e.printStackTrace();
			return null;
		}
	}

	public void getIntoAction() {

		System.out.println("Type 1 - Add User Details into the server ");
		System.out.println("Type 2 - Update User Details into the server ");
		System.out.println("Type 3 - Delete User Details from the server");
		System.out.println("Type 4 - Get All the User Details  from the server");
		System.out.println("Type 5 - Get User Details by User_ID from the Server");
		System.out.println("Type 6 - Exit");
		System.out.println("Choice: ");

		int selection = sc.nextInt();
		switch (selection) {
		case 1:
			addUserDetails();
			getIntoAction();
			break;
		case 2:
			updateUserDetails();
			getIntoAction();
			break;
		case 3:
			deleteUserDetails();
			getIntoAction();
			break;
		case 4:
			getAllUserDetails();
			getIntoAction();
			break;
		case 5:
			getUserDetailByID();
			getIntoAction();
			break;
		case 6:
			System.out.println("Closing the User Details Server Page...");
			break;
		default:
			System.out.println("\n" + "Invalid Choice." + "\n");
			getIntoAction();
		}
	}

	public void addUserDetails() {
		try {
			System.out.println("Enter the User Id");
			User_ID= sc.nextInt();
			sc.nextLine();
			System.out.println("Enter the User Name");
			UserName=sc.nextLine();
			System.out.println("Enter the User Name");
			Email = sc.nextLine();
			System.out.println("Enter the password");
			pass = sc.nextLine();
			if(add(new UserTable(User_ID,UserName, Email, pass))) {
			System.out.println("			User Table Added Sucessfully");
			}
		} catch (Exception e) {
			System.out.println("		Oops! User Table is not Added ");
		}

	}

	public void updateUserDetails() {
		try {
			System.out.println("Enter the User Id to be updated");
			User_ID = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter the User Name to be updated");
			UserName=sc.nextLine();
			System.out.println("Enter the Email name to be updated");
			Email = sc.nextLine();
			System.out.println("Enter the password to be updated");
			pass = sc.nextLine();
			update(new UserTable(User_ID,UserName, Email, pass));
			System.out.println("			User Table Updated Sucessfully");
		} catch (Exception e) {
			System.out.println("		Oops! User Table are not Updated");
		}
	}

	public void deleteUserDetails() {
		System.out.println("Enter the User Id of UserTable which you want to delete");
		User_ID = sc.nextInt();
		try {
			if (delete(User_ID)) {
				System.out.println("              User Table with the given User Id is deleted Successfully");
			} else {
				System.out.println(
						"Sorry, User Table with the given User Id can't be deleted now or Database is empty");
			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	public void getAllUserDetails() {
		LinkedList<UserTable> UT = getAllList();
		for (UserTable ut : UT) {
			System.out.println(ut);
		}
		System.out.println("\n");
	}

	public void getUserDetailByID() {
		System.out.println("Enter the User Id of User Tables");
		User_ID= sc.nextInt();
		UserTable x = get(User_ID);
		try {
			if (x != null)
				System.out.println(x);
			else
				System.out.println("Sorry User ID is not present in the Database or the Database is empty");
		} catch (Exception e) {
			System.err.println();
		}
	}
}
