package PassengerBookingDetailsPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.Scanner;

import Flight_DataPackage.DatabaseConnection;

public class PassengerBookingDetailsDAOJDBCImpl implements PassengerBookingDetailsDAO{
	Connection connection;
	ResultSet rs;

	long PNR;
	int Travel_ID;
	String Fname,Lname,Email;
	int Age,Seat_Number;
	String Address;
	Scanner sc = new Scanner(System.in);
	@Override
	public boolean add(PassengerBookingDetails PBD) {
		// TODO Auto-generated method stub
		try {
			connection = DatabaseConnection.getConnect();
			String sql = "INSERT INTO PASSENGER_BOOKING_DETAILS(TRAVEL_ID, FNAME, LNAME, EMAIL, AGE, SEAT_NUMBER, ADDRESS) VALUES(?,?,?,?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, PBD.getTravel_ID());
			ps.setString(2, PBD.getFname());
			ps.setString(3, PBD.getLname());
			ps.setString(4, PBD.getEmail());
			ps.setInt(5, PBD.getAge());
			ps.setInt(6, PBD.getSeat_Number());
			ps.setString(7, PBD.getAddress());
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
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		try {
			connection = DatabaseConnection.getConnect();
			String sql = "DELETE FROM PASSENGER_BOOKING_DETAILS WHERE PNR=? ";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setLong(1, id);
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
	public boolean update(PassengerBookingDetails PBD) {
		// TODO Auto-generated method stub
		try {
		connection = DatabaseConnection.getConnect();
		String sql = "UPDATE  PASSENGER_BOOKING_DETAILS SET TRAVEL_ID=? , FNAME=? , LNAME=? , EMAIL=? , AGE=? , SEAT_NUMBER=? , ADDRESS=? WHERE PNR=? ";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, PBD.getTravel_ID());
		ps.setString(2, PBD.getFname());
		ps.setString(3, PBD.getLname());
		ps.setString(4, PBD.getEmail());
		ps.setInt(5, PBD.getAge());
		ps.setInt(6, PBD.getSeat_Number());
		ps.setString(7, PBD.getAddress());
		ps.setLong(8, PBD.getPNR());
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
	public PassengerBookingDetails get(long id) {
		// TODO Auto-generated method stub
		try {
		connection = DatabaseConnection.getConnect();
		String sql = "SELECT * FROM PASSENGER_BOOKING_DETAILS WHERE PNR=? ";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setLong(1, id);
		rs = ps.executeQuery();
		if (rs.next()) {
			PassengerBookingDetails pbd = new PassengerBookingDetails(PNR = rs.getLong(1), Travel_ID = rs.getInt(2), Fname = rs.getString(3), Lname = rs.getString(4),
					Email = rs.getString(5), Age = rs.getInt(6), Seat_Number = rs.getInt(7), Address=rs.getString(8));
			return pbd;
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
	public LinkedList<PassengerBookingDetails> getAllList() {
		// TODO Auto-generated method stub
		LinkedList<PassengerBookingDetails> passBookDetails = new LinkedList<PassengerBookingDetails>();
		try {
			connection = DatabaseConnection.getConnect();
			String sql = "SELECT * FROM PASSENGER_BOOKING_DETAILS";
			PreparedStatement ps = connection.prepareStatement(sql);
			rs = ps.executeQuery(sql);
			while (rs.next()) {
				PassengerBookingDetails PBD = new PassengerBookingDetails(rs.getLong("PNR"),rs.getInt("TRAVEL_ID"),rs.getString("FNAME"),rs.getString("LNAME"),rs.getString("EMAIL"),rs.getInt("AGE"),rs.getInt("SEAT_NUMBER"),rs.getString("ADDRESS"));
				passBookDetails.add(PBD);
			}
			ps.close();
			DatabaseConnection.closeConn(connection);
			return passBookDetails;
		} catch (Exception e) {
			DatabaseConnection.closeConn(connection);
			e.printStackTrace();
			return null;
		}
	}

	public void getIntoAction() {

		System.out.println("Type 1 - Add Passenger Booking Details into the server ");
		System.out.println("Type 2 - Update Passenger Booking Details  in the server ");
		System.out.println("Type 3 - Delete Passenger Booking Details  from the server");
		System.out.println("Type 4 - Get All the Passenger Booking Details   from the server");
		System.out.println("Type 5 - Get Passenger Booking Details  by PNR from the Server");
		System.out.println("Type 6 - Exit");
		System.out.println("Choice: ");

		int selection = sc.nextInt();
		switch (selection) {
		case 1:
			addPassBookingDetails();
			getIntoAction();
			break;
		case 2:
			updatePassBookingDetails();
			getIntoAction();
			break;
		case 3:
			deletePassBookingDetails();
			getIntoAction();
			break;
		case 4:
			getAllPassBookingDetails();
			getIntoAction();
			break;
		case 5:
			getPassBookingDetailByID();
			getIntoAction();
			break;
		case 6:
			System.out.println("Closing the Passenger Booking Details Server Page...");
			break;
		default:
			System.out.println("\n" + "Invalid Choice." + "\n");
			getIntoAction();
		}
	}

	public void addPassBookingDetails() {
		try {
			System.out.println("Enter the Travel Id");
			Travel_ID= sc.nextInt();
			System.out.println("Enter the Seat Number");
			Seat_Number=sc.nextInt();
			System.out.println("Enter the Age of Passenger");
			Age=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter the FName Name");
			Fname=sc.nextLine();
			System.out.println("Enter the LName Name");
			Lname = sc.nextLine();
			System.out.println("Enter the Email");
			Email = sc.nextLine();
			System.out.println("Enter the Address");
			Address=sc.nextLine();
			if(add(new PassengerBookingDetails(PNR, Travel_ID, Fname, Lname, Email, Age, Seat_Number, Address))) {
			System.out.println("			Passenger Booking Details Added Sucessfully");
			}
		} catch (Exception e) {
			System.out.println("		Oops! Passenger Booking Details are not Added ");
		}

	}

	public void updatePassBookingDetails() {
		try {
			System.out.println("Enter the PNR to be updated");
			PNR=sc.nextLong();
			System.out.println("Enter the Travel Id");
			Travel_ID= sc.nextInt();
			System.out.println("Enter the Seat Number");
			Seat_Number=sc.nextInt();
			System.out.println("Enter the Age of Passenger");
			Age=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter the FName Name");
			Fname=sc.nextLine();
			System.out.println("Enter the LName Name");
			Lname = sc.nextLine();
			System.out.println("Enter the Email");
			Email = sc.nextLine();
			System.out.println("Enter the Address");
			Address=sc.nextLine();
			if(update(new PassengerBookingDetails(PNR, Travel_ID, Fname, Lname, Email, Age, Seat_Number, Address)))
			System.out.println("			Passenger Booking Details Updated Sucessfully");
		} catch (Exception e) {
			System.out.println("		Oops! Passenger Booking Details are not Updated");
		}
	}

	public void deletePassBookingDetails() {
		System.out.println("Enter the PNR of Passenger Booking Details which you want to delete");
		PNR= sc.nextLong();
		try {
			if (delete(PNR)) {
				System.out.println("              Passenger Booking Details with the given PNR is deleted Successfully");
			} else {
				System.out.println(
						"Sorry, Passenger Booking Details with the given PNR can't be deleted now or Database is empty");
			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	public void getAllPassBookingDetails() {
		LinkedList<PassengerBookingDetails> PBD = getAllList();
		for (PassengerBookingDetails pbd : PBD) {
			System.out.println(pbd);
		}
		System.out.println("\n");
	}

	public void getPassBookingDetailByID() {
		System.out.println("Enter the PNR of Passenger Booking Details");
		PNR = sc.nextLong();
		PassengerBookingDetails x = get(PNR);
		try {
			if (x != null)
				System.out.println(x);
			else
				System.out.println("Sorry PNR is not present in the Database or the Database is empty");
		} catch (Exception e) {
			System.err.println();
		}
	}
}
