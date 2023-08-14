package Flight_DataPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.Scanner;


public class FlightDataDAOJDBCImpl implements FlightDataDAO{
	Connection connection;
	ResultSet rs;
	
	int Flight_ID;
	int Flight_Detail_ID;
	int Admin_ID;
	String Flight_Company;
	String Flight_Src;
	String Flight_Desc;
	Timestamp Travel_Date_Time;
	int Business_TotalSeats;
	int Business_SeatAvailable;
	float Business_Price;
	int First_TotalSeats;
	int First_SeatAvailable;
	float First_Price;
	int Economy_TotalSeats;
	int Economy_SeatAvailable;
	float Economy_Price;
	int Total_NoOfSeats;
	int Total_Available_Seats;
	int Dd, Dm, Dy, Th, Tm;
	
	Scanner sc = new Scanner(System.in);
	
	@Override
	public boolean add(FlightData Fd) {
		// TODO Auto-generated method stub
		try {
			connection = DatabaseConnection.getConnect();
			String sql = "INSERT INTO FLIGHT_DATA(FLIGHT_DETAIL_ID , ADMIN_ID , FLIGHT_COMPANY , FLIGHT_SRC , FLIGHT_DES , TRAVEL_DATE_TIME , BUSSINESS_TOTALSEATS , BUSSINESS_SEAT_AVAILABLE , BUSINESSCLASS_PRICE , FIRSTCLASS_TOTALSEATS , FIRST_SEAT_AVAILABLE , FIRSTCLASS_PRICE , ECONOMYCLASS_TOTALSEATS , ECONOMY_SEAT_AVAILABLE , ECONOMYCLASS_PRICE , TOTAL_NOOFSEATS , TOTAL_AVAILABLE_SEATS ) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1,Fd.getFlight_Detail_ID());
			ps.setInt(2,Fd.getAdmin_ID());
			ps.setString(3,Fd.getFlight_Company());
			ps.setString(4,Fd.getFlight_Src());
			ps.setString(5,Fd.getFlight_Desc());
			ps.setTimestamp(6, Fd.getTravel_Date_Time());
			ps.setInt(7,Fd.getBusiness_TotalSeats());
			ps.setInt(8, Fd.getBusiness_SeatAvailable());
			ps.setFloat(9, Fd.getBusiness_Price());
			ps.setInt(10,Fd.getFirst_TotalSeats());
			ps.setInt(11, Fd.getFirst_SeatAvailable());
			ps.setFloat(12, Fd.getFirst_Price());
			ps.setInt(13,Fd.getEconomy_TotalSeats());
			ps.setInt(14, Fd.getEconomy_SeatAvailable());
			ps.setFloat(15, Fd.getEconomy_Price());
			ps.setInt(16, Fd.getTotal_NoOfSeats());
			ps.setInt(17, Fd.getTotal_Available_Seats());
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
		try {
			connection = DatabaseConnection.getConnect();
			String sql = "DELETE FROM FLIGHT_DATA WHERE FLIGHT_ID=? ";
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
	public boolean update(FlightData Fd) {
		try {
			connection = DatabaseConnection.getConnect();
			String sql = "UPDATE FLIGHT_DATA SET FLIGHT_DETAIL_ID=? , ADMIN_ID=? , FLIGHT_COMPANY=? , FLIGHT_SRC=? , FLIGHT_DES=? , TRAVEL_DATE_TIME=? , BUSSINESS_TOTALSEATS=? , BUSSINESS_SEAT_AVAILABLE=? , BUSINESSCLASS_PRICE=? , FIRSTCLASS_TOTALSEATS=? , FIRST_SEAT_AVAILABLE=? , FIRSTCLASS_PRICE=? , ECONOMYCLASS_TOTALSEATS=? , ECONOMY_SEAT_AVAILABLE=? , ECONOMYCLASS_PRICE=? , TOTAL_NOOFSEATS=? , TOTAL_AVAILABLE_SEATS=? WHERE FLIGHT_ID=? ";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1,Fd.getFlight_Detail_ID());
			ps.setInt(2,Fd.getAdmin_ID());
			ps.setString(3,Fd.getFlight_Company());
			ps.setString(4,Fd.getFlight_Src());
			ps.setString(5,Fd.getFlight_Desc());
			ps.setTimestamp(6, Fd.getTravel_Date_Time());
			ps.setInt(7,Fd.getBusiness_TotalSeats());
			ps.setInt(8, Fd.getBusiness_SeatAvailable());
			ps.setFloat(9, Fd.getBusiness_Price());
			ps.setInt(10,Fd.getFirst_TotalSeats());
			ps.setInt(11, Fd.getFirst_SeatAvailable());
			ps.setFloat(12, Fd.getFirst_Price());
			ps.setInt(13,Fd.getEconomy_TotalSeats());
			ps.setInt(14, Fd.getEconomy_SeatAvailable());
			ps.setFloat(15, Fd.getEconomy_Price());
			ps.setInt(16, Fd.getTotal_NoOfSeats());
			ps.setInt(17, Fd.getTotal_Available_Seats());
			ps.setInt(18,Fd.getFlight_ID());
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
	public FlightData get(int id) {
		try {
			connection = DatabaseConnection.getConnect();
			String sql = "SELECT * FROM FLIGHT_DATA WHERE FLIGHT_ID=? ";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				FlightData Fd = new FlightData(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6),
						rs.getTimestamp(7),rs.getInt(8),rs.getInt(9),rs.getFloat(10),rs.getInt(11),rs.getInt(12),rs.getFloat(13),
						rs.getInt(14),rs.getInt(15),rs.getFloat(16),rs.getInt(17),rs.getInt(18));
				return Fd;
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
	public LinkedList<FlightData> getAllList() {
		LinkedList<FlightData> flightdata = new LinkedList<FlightData>();
		try {
			connection = DatabaseConnection.getConnect();
			String sql = "SELECT * FROM FLIGHT_DATA";
			PreparedStatement ps = connection.prepareStatement(sql);
			rs = ps.executeQuery(sql);
			while (rs.next()) {
				FlightData fd = new FlightData(rs.getInt("FLIGHT_ID"), rs.getInt("FLIGHT_DETAIL_ID"), rs.getInt("ADMIN_ID"), rs.getString("FLIGHT_COMPANY"), rs.getString("FLIGHT_SRC"), rs.getString("FLIGHT_DES"), rs.getTimestamp("TRAVEL_DATE_TIME"), rs.getInt("BUSSINESS_TOTALSEATS"), rs.getInt("BUSSINESS_SEAT_AVAILABLE"), rs.getFloat("BUSINESSCLASS_PRICE"), rs.getInt("FIRSTCLASS_TOTALSEATS"), rs.getInt("FIRST_SEAT_AVAILABLE"), rs.getFloat("FIRSTCLASS_PRICE"), rs.getInt("ECONOMYCLASS_TOTALSEATS"), rs.getInt("ECONOMY_SEAT_AVAILABLE"), rs.getFloat("ECONOMYCLASS_PRICE"), rs.getInt("TOTAL_NOOFSEATS"), rs.getInt("TOTAL_AVAILABLE_SEATS"));
				flightdata.add(fd);
			}
			ps.close();
			DatabaseConnection.closeConn(connection);
			return flightdata;
		} catch (Exception e) {
			DatabaseConnection.closeConn(connection);
			e.printStackTrace();
			return null;
		}
	}

	public void getIntoAction() {

		System.out.println("Type 1 - Add Flight Data into the server ");
		System.out.println("Type 2 - Update Flight Data in the server ");
		System.out.println("Type 3 - Delete Flight Data from the server");
		System.out.println("Type 4 - Get All the Flight Data  from the server");
		System.out.println("Type 5 - Get Flight Data by Flight_ID from the Server");
		System.out.println("Type 6 - Exit");
		System.out.println("Choice: ");

		int selection = sc.nextInt();
		switch (selection) {
		case 1:
			addFlightData();
			getIntoAction();
			break;
		case 2:
			updateFlightData();
			getIntoAction();
			break;
		case 3:
			deleteFlightData();
			getIntoAction();
			break;
		case 4:
			getAllFlightData();
			getIntoAction();
			break;
		case 5:
			getFlightDataByID();
			getIntoAction();
			break;
		case 6:
			System.out.println("Closing the Flight Data Server Page...");
			break;
		default:
			System.out.println("\n" + "Invalid Choice." + "\n");
			getIntoAction();
		}
	}

	public void addFlightData() {
		try {
			System.out.println("Enter the Flight_Detail_Id");
			Flight_Detail_ID = sc.nextInt();
			System.out.println("Enter the Admin Id");
			Admin_ID = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter the Flight Company");
			Flight_Company = sc.nextLine();
			System.out.println("Enter the source");
			Flight_Src = sc.nextLine();
			System.out.println("Enter the destination");
			Flight_Desc= sc.nextLine();
			System.out.println("Enter the Travel Date");
			Dd = sc.nextInt();
			System.out.println("Enter the Travel Month");
			Dm = sc.nextInt();
			System.out.println("Enter the Travel Year");
			Dy = sc.nextInt();
			System.out.println("Enter the Travel Hour");
			Th = sc.nextInt();
			System.out.println("Enter the Travel Minutes");
			Tm = sc.nextInt();
			Travel_Date_Time = new Timestamp(Dy, Dm, Dd, Th, Tm, 0, 0);
			System.out.println("Enter the Total Number of Business Class Seats");
			Business_TotalSeats=sc.nextInt();
			System.out.println("Enter the Seats Available in Business Class");
			Business_SeatAvailable=sc.nextInt();
			System.out.println("Enter the price of each ticket in Business Class");
			Business_Price=sc.nextFloat();
			System.out.println("Enter the Total Number of First Class Seats");
			First_TotalSeats=sc.nextInt();
			System.out.println("Enter the Seats Available in First Class");
			First_SeatAvailable=sc.nextInt();
			System.out.println("Enter the price of each ticket in First Class");
			First_Price=sc.nextFloat();
			System.out.println("Enter the Total Number of Economy Class Class Seats");
			Economy_TotalSeats=sc.nextInt();
			System.out.println("Enter the Seats Available in Economy Class");
			Economy_SeatAvailable=sc.nextInt();
			System.out.println("Enter the price of each ticket in Economy Class");
			Economy_Price=sc.nextFloat();
			Total_NoOfSeats=Business_TotalSeats+First_TotalSeats+Economy_TotalSeats;
			Total_Available_Seats=Business_SeatAvailable+First_SeatAvailable+Economy_SeatAvailable;
			if(add(new FlightData(Flight_ID, Flight_Detail_ID, Admin_ID, Flight_Company, Flight_Src, Flight_Desc, Travel_Date_Time, Business_TotalSeats, Business_SeatAvailable, Business_Price, First_TotalSeats, First_SeatAvailable, First_Price, Economy_TotalSeats, Economy_SeatAvailable, Economy_Price, Total_NoOfSeats, Total_Available_Seats))) {
			System.out.println("			Flight Data Added Sucessfully");}
		} catch (Exception e) {
			System.out.println("		Oops! Flight Data are not Added ");
		}

	}

	public void updateFlightData() {
		try {
			System.out.println("Enter the Flight Id to be updated");
			Flight_ID = sc.nextInt();
			System.out.println("Enter the Flight_Detail_ID to be updated");
			Flight_Detail_ID=sc.nextInt();
			System.out.println("Enter the Admin Id to be updated");
			Admin_ID = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter the Flight Company to be updated");
			Flight_Company = sc.nextLine();
			System.out.println("Enter the source to be updated");
			Flight_Src = sc.nextLine();
			System.out.println("Enter the destination to be updated");
			Flight_Desc= sc.nextLine();
			System.out.println("Enter the Travel Date to be updated");
			Dd = sc.nextInt();
			System.out.println("Enter the Travel Month to be updated");
			Dm = sc.nextInt();
			System.out.println("Enter the Travel Year to be updated");
			Dy = sc.nextInt();
			System.out.println("Enter the Travel Hour to be updated");
			Th = sc.nextInt();
			System.out.println("Enter the Travel Minutes to be updated");
			Tm = sc.nextInt();
			Travel_Date_Time = new Timestamp(Dy, Dm, Dd, Th, Tm, 0, 0);
			System.out.println("Enter the Total Number of Business Class Seats to be updated");
			Business_TotalSeats=sc.nextInt();
			System.out.println("Enter the Seats Available in Business Class to be updated");
			Business_SeatAvailable=sc.nextInt();
			System.out.println("Enter the price of each ticket in Business Class to be updated");
			Business_Price=sc.nextFloat();
			System.out.println("Enter the Total Number of First Class Seats to be updated");
			First_TotalSeats=sc.nextInt();
			System.out.println("Enter the Seats Available in First Class to be updated");
			First_SeatAvailable=sc.nextInt();
			System.out.println("Enter the price of each ticket in First Class to be updated");
			First_Price=sc.nextFloat();
			System.out.println("Enter the Total Number of Economy Class Class Seats to be updated");
			Economy_TotalSeats=sc.nextInt();
			System.out.println("Enter the Seats Available in Economy Class to be updated");
			Economy_SeatAvailable=sc.nextInt();
			System.out.println("Enter the price of each ticket in Economy Class to be updated");
			Economy_Price=sc.nextFloat();
			Total_NoOfSeats=Business_TotalSeats+First_TotalSeats+Economy_TotalSeats;
			Total_Available_Seats=Business_SeatAvailable+First_SeatAvailable+Economy_SeatAvailable;
			if(update(new FlightData(Flight_ID,Flight_Detail_ID, Admin_ID, Flight_Company, Flight_Src, Flight_Desc, Travel_Date_Time, Business_TotalSeats, Business_SeatAvailable, Business_Price, First_TotalSeats, First_SeatAvailable, First_Price, Economy_TotalSeats, Economy_SeatAvailable, Economy_Price, Total_NoOfSeats, Total_Available_Seats))) {
			System.out.println("			Flight Data Updated Sucessfully");}
		} catch (Exception e) {
			System.out.println("		Oops! Flight Data isnot Updated");
		}
	}

	public void deleteFlightData() {
		System.out.println("Enter the Flight Id of FlightData Table which you want to delete");
		Flight_ID = sc.nextInt();
		try {
			if (delete(Flight_ID)) {
				System.out.println("               FlightData with the given Flight Id is deleted Successfully");
			} else {
				System.out.println(
						"Sorry, FlightData Table with the given Flight Id can't be deleted now or Database is empty");
			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	public void getAllFlightData() {
		LinkedList<FlightData> FD = getAllList();
		for (FlightData fd : FD) {
			System.out.println(fd);
		}
		System.out.println("\n");
	}

	public void getFlightDataByID() {
		System.out.println("Enter the Flight Id  of FlightData Table");
		Flight_ID = sc.nextInt();
		FlightData x = get(Flight_ID);
		try {
			if (x != null)
				System.out.println(x);
			else
				System.out.println("Sorry Flight Id  is not present in the Database or the Database is empty");
		} catch (Exception e) {
			System.err.println();
		}
	}

}
