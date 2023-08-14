package TravellingDetailsPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.Scanner;

import Flight_DataPackage.DatabaseConnection;

public class TrevellingDetailsDAOJDBCImpl implements TravellingDetailsDAO{
	
	Connection connection;
	ResultSet rs;
	
	int Travel_id, User_id, Flight_id;
	Timestamp Booking_date;
	int TotalSeats_booking;
	private String SeatType;
	private float Fare_PerTicket, Total_Fare, Total_DiscountAmount,TotalFare_AfterDiscount, Fare_perTicket_AfterDiscount;
	int Dd, Dm, Dy, Th, Tm;
	Scanner sc = new Scanner(System.in);
	
	@Override
	public boolean add(TravellingDetails TD) {
		// TODO Auto-generated method stub
		try {
			connection = DatabaseConnection.getConnect();
			String sql = "INSERT INTO TRAVELLING_DETAILS(USER_ID, FLIGHT_ID, BOOKING_DATE, TOTAL_SEATS_BOOKING, SEAT_TYPE, FARE_PER_TICKET, TOTAL_FARE, TOAL_DISCOUNTAMMOUNT, TOTAL_FARE_AFTER_DISCOUNT, FARE_PER_TICKET_AFTER_DISCOUNT) VALUES(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(sql);
				ps.setInt(1, User_id);
				ps.setInt(2, Flight_id);
				ps.setTimestamp(3, Booking_date);
				ps.setInt(4, TotalSeats_booking);
				ps.setString(5, SeatType);
				ps.setFloat(6, Fare_PerTicket);
				ps.setFloat(7, Total_Fare);
				ps.setFloat(8, Total_DiscountAmount);
				ps.setFloat(9, TotalFare_AfterDiscount);
				ps.setFloat(10, Fare_perTicket_AfterDiscount);
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
			String sql = "DELETE FROM TRAVELLING_DETAILS WHERE TRAVEL_ID=? ";
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
	public boolean update(TravellingDetails TD) {
		// TODO Auto-generated method stub
		try {
		connection = DatabaseConnection.getConnect();
		String sql = "UPDATE TRAVELLING_DETAILS SET USER_ID=? , FLIGHT_ID=? , BOOKING_DATE =?, TOTAL_SEATS_BOOKING=?, SEAT_TYPE=?, FARE_PER_TICKET=?, TOTAL_FARE=?, TOAL_DISCOUNTAMMOUNT=?, TOTAL_FARE_AFTER_DISCOUNT=?, FARE_PER_TICKET_AFTER_DISCOUNT=? WHERE TRAVEL_ID=? ";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, TD.getUser_id());
		ps.setInt(2, TD.getFlight_id());
		ps.setTimestamp(3, TD.getBooking_date());
		ps.setInt(4, TD.getTotalSeats_booking());
		ps.setString(5, TD.getSeatType());
		ps.setFloat(6, TD.getFare_PerTicket());
		ps.setFloat(7, TD.getTotal_Fare());
		ps.setFloat(8, TD.getTotal_DiscountAmount());
		ps.setFloat(9, TD.getTotalFare_AfterDiscount());
		ps.setFloat(10, TD.getFare_perTicket_AfterDiscount());
		ps.setInt(11, TD.getTravel_id());
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
	public TravellingDetails get(int id) {
		// TODO Auto-generated method stub
		try {
		connection = DatabaseConnection.getConnect();
		String sql = "SELECT * FROM TRAVELLING_DETAILS WHERE TRAVEL_ID=? ";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, id);
		rs = ps.executeQuery();
		if (rs.next()) {
			TravellingDetails At = new TravellingDetails(Travel_id= rs.getInt(1),User_id=rs.getInt(2),Flight_id=rs.getInt(3),Booking_date=rs.getTimestamp(4),TotalSeats_booking=rs.getInt(5),SeatType=rs.getString(6), Fare_PerTicket=rs.getFloat(7),Total_Fare=rs.getFloat(8),Total_DiscountAmount=rs.getFloat(9),TotalFare_AfterDiscount=rs.getFloat(10),Fare_perTicket_AfterDiscount=rs.getFloat(11));
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
	public LinkedList<TravellingDetails> getAllList() {
		// TODO Auto-generated method stub
				LinkedList<TravellingDetails> tdtable = new LinkedList<TravellingDetails>();
		try {
			connection = DatabaseConnection.getConnect();
			String sql = "SELECT * FROM TRAVELLING_DETAILS";
			PreparedStatement ps = connection.prepareStatement(sql);
			rs = ps.executeQuery(sql);
			while (rs.next()) {
				TravellingDetails td = new TravellingDetails(rs.getInt("TRAVEL_ID"),rs.getInt("USER_ID"),rs.getInt("FLIGHT_ID"),rs.getTimestamp("BOOKING_DATE"),rs.getInt("TOTAL_SEATS_BOOKING"),rs.getString("SEAT_TYPE"),rs.getFloat("FARE_PER_TICKET"),rs.getFloat("TOTAL_FARE"),rs.getFloat("TOAL_DISCOUNTAMMOUNT"),rs.getFloat("TOTAL_FARE_AFTER_DISCOUNT"),rs.getFloat("FARE_PER_TICKET_AFTER_DISCOUNT"));
				tdtable.add(td);
			}
			ps.close();
			DatabaseConnection.closeConn(connection);
			return tdtable;
		} catch (Exception e) {
			DatabaseConnection.closeConn(connection);
			e.printStackTrace();
			return null;
		}
	}

 

	public void getIntoAction() {

		System.out.println("Type 1 - Add Travelling Details into the server ");
 		System.out.println("Type 2 - Update Travelling Details into the server ");
 		System.out.println("Type 3 - Delete Travelling Details from the server");
 		System.out.println("Type 4 - Get All the Travelling Details  from the server");
 		System.out.println("Type 5 - Get Travelling Details by Travel_ID from the Server");
 		System.out.println("Type 6 - Exit");
 		System.out.println("Choice: ");
 
 		int selection = sc.nextInt();
 		switch (selection) {
 		case 1:
 			addTravellingDetails();
 			getIntoAction();
 			break;
 		case 2:
 			updateTravellingDetails();
 			getIntoAction();
 			break;
 		case 3:
 			deleteTravellingDetails();
 			getIntoAction();
 			break;
 		case 4:
 			getAllTravellingDetails();
 			getIntoAction();
 			break;
 		case 5:
 			getTravellingDetailByID();
 			getIntoAction();
 			break;
 		case 6:
 			System.out.println("Closing the Travelling Details Server Page...");
 			break;
 		default:
 			System.out.println("\n" + "Invalid Choice." + "\n");
 			getIntoAction();
 		}
 	}

	public void addTravellingDetails() {
		try {
			System.out.println("Enter the User Id");
			User_id= sc.nextInt();
			System.out.println("Enter the Flight Id");
			Flight_id= sc.nextInt();
			System.out.println("Enter the Total Seats Booking");
			TotalSeats_booking= sc.nextInt();
			sc.nextLine();
			System.out.println("Enter the SeatType");
			SeatType=sc.nextLine();
			System.out.println("Enter the Booking Date");
			Dd = sc.nextInt();
			System.out.println("Enter the Booking  Month");
			Dm = sc.nextInt();
			System.out.println("Enter the Booking  Year");
			Dy = sc.nextInt();
			System.out.println("Enter the Booking  Hour");
			Th = sc.nextInt();
			System.out.println("Enter the Booking  Minutes");
			Tm = sc.nextInt();
			Booking_date = new Timestamp(Dy, Dm, Dd, Th, Tm, 0, 0);
			System.out.println("Enter the fare per Ticket");
			Fare_PerTicket=sc.nextFloat();
			Total_Fare=TotalSeats_booking*Fare_PerTicket;
			System.out.println("Enter the total discount amount");
			Total_DiscountAmount=sc.nextFloat();
			TotalFare_AfterDiscount=Total_Fare-Total_DiscountAmount;
			Fare_perTicket_AfterDiscount=TotalFare_AfterDiscount/TotalSeats_booking;
			if(add(new TravellingDetails(Travel_id, User_id, Flight_id, Booking_date, TotalSeats_booking, SeatType, Fare_PerTicket, Total_Fare, Total_DiscountAmount, TotalFare_AfterDiscount, Fare_perTicket_AfterDiscount))) {
			System.out.println("			Travelling Details Table Added Sucessfully");
			}
		} catch (Exception e) {
			System.out.println("		Oops! Travelling Details Table are not Added ");
		}

	}

	public void updateTravellingDetails() {
		try {
			System.out.println("Enter the Travel Id to be updated");
			Travel_id= sc.nextInt();
			System.out.println("Enter the User Id to be updated");
			User_id= sc.nextInt();
			System.out.println("Enter the Flight Id to be updated");
			Flight_id= sc.nextInt();
			System.out.println("Enter the Total Seats Booking to be updated");
			TotalSeats_booking= sc.nextInt();
			sc.nextLine();
			System.out.println("Enter the SeatType to be updated");
			SeatType=sc.nextLine();
			System.out.println("Enter the Booking Date to be updated");
			Dd = sc.nextInt();
			System.out.println("Enter the Booking  Month to be updated");
			Dm = sc.nextInt();
			System.out.println("Enter the Booking  Year to be updated");
			Dy = sc.nextInt();
			System.out.println("Enter the Booking  Hour to be updated");
			Th = sc.nextInt();
			System.out.println("Enter the Booking  Minutes to be updated");
			Tm = sc.nextInt();
			Booking_date = new Timestamp(Dy, Dm, Dd, Th, Tm, 0, 0);
			System.out.println("Enter the fare per Ticket to be updated");
			Fare_PerTicket=sc.nextFloat();
			Total_Fare=TotalSeats_booking*Fare_PerTicket;
			System.out.println("Enter the total discount amount to be updated");
			Total_DiscountAmount=sc.nextFloat();
			TotalFare_AfterDiscount=Total_Fare-Total_DiscountAmount;
			Fare_perTicket_AfterDiscount=TotalFare_AfterDiscount/TotalSeats_booking;
			if(update(new TravellingDetails(Travel_id, User_id, Flight_id, Booking_date, TotalSeats_booking, SeatType, Fare_PerTicket, Total_Fare, Total_DiscountAmount, TotalFare_AfterDiscount, Fare_perTicket_AfterDiscount))){
			System.out.println("			Travelling Details Table Updated Sucessfully");}
		} catch (Exception e) {
			System.out.println("		Oops! Travelling Details Table are not Updated");
		}
	}

	public void deleteTravellingDetails() {
		System.out.println("Enter the Travel Id of Travelling Details Table which you want to delete");
		Travel_id = sc.nextInt();
		try {
			if (delete(Travel_id)) {
				System.out.println("              Travelling Details Table with the given Travel Id is deleted Successfully");
			} else {
				System.out.println(
						"Sorry, Travelling Details Table with the given Travel Id can't be deleted now or Database is empty");
			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	public void getAllTravellingDetails() {
		LinkedList<TravellingDetails> TD = getAllList();
		for (TravellingDetails td : TD) {
			System.out.println(td);
		}
		System.out.println("\n");
	}

	public void getTravellingDetailByID() {
		System.out.println("Enter the Travel Id of Travelling Details Tables");
		Travel_id = sc.nextInt();
		TravellingDetails x = get(Travel_id);
		try {
			if (x != null)
				System.out.println(x);
			else
				System.out.println("Sorry Trevael ID is not present in the Database or the Database is empty");
		} catch (Exception e) {
			System.err.println();
		}
	}
}
