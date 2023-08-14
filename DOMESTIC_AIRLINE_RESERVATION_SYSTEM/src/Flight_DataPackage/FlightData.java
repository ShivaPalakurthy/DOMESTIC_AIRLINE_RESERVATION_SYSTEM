package Flight_DataPackage;

import java.sql.Timestamp;

public class FlightData {
	private int Flight_ID;
	private int Flight_Detail_ID;
	private int Admin_ID;
	private String Flight_Company;
	private String Flight_Src;
	private String Flight_Desc;
	private Timestamp Travel_Date_Time;
	private int Business_TotalSeats;
	private int Business_SeatAvailable;
	private float Business_Price;
	private int First_TotalSeats;
	private int First_SeatAvailable;
	private float First_Price;
	private int Economy_TotalSeats;
	private int Economy_SeatAvailable;
	private float Economy_Price;
	private int Total_NoOfSeats;
	private int Total_Available_Seats;
	public FlightData(int flight_ID, int flight_Detail_ID, int admin_ID, String flight_Company, String flight_Src,
			String flight_Desc, Timestamp travel_Date_Time, int business_TotalSeats, int business_SeatAvailable,
			float business_Price, int first_TotalSeats, int first_SeatAvailable, float first_Price,
			int economy_TotalSeats, int economy_SeatAvailable, float economy_Price, int total_NoOfSeats,
			int total_Available_Seats) {
		super();
		Flight_ID = flight_ID;
		Flight_Detail_ID = flight_Detail_ID;
		Admin_ID = admin_ID;
		Flight_Company = flight_Company;
		Flight_Src = flight_Src;
		Flight_Desc = flight_Desc;
		Travel_Date_Time = travel_Date_Time;
		Business_TotalSeats = business_TotalSeats;
		Business_SeatAvailable = business_SeatAvailable;
		Business_Price = business_Price;
		First_TotalSeats = first_TotalSeats;
		First_SeatAvailable = first_SeatAvailable;
		First_Price = first_Price;
		Economy_TotalSeats = economy_TotalSeats;
		Economy_SeatAvailable = economy_SeatAvailable;
		Economy_Price = economy_Price;
		Total_NoOfSeats = total_NoOfSeats;
		Total_Available_Seats = total_Available_Seats;
	}
	@Override
	public String toString() {
		return "FlightData [Flight_ID=" + Flight_ID + ", Flight_Detail_ID=" + Flight_Detail_ID + ", Admin_ID="
				+ Admin_ID + ", Flight_Company=" + Flight_Company + ", Flight_Src=" + Flight_Src + ", Flight_Desc="
				+ Flight_Desc + ", Travel_Date_Time=" + Travel_Date_Time + ", Business_TotalSeats="
				+ Business_TotalSeats + ", Business_SeatAvailable=" + Business_SeatAvailable + ", Business_Price="
				+ Business_Price + ", First_TotalSeats=" + First_TotalSeats + ", First_SeatAvailable="
				+ First_SeatAvailable + ", First_Price=" + First_Price + ", Economy_TotalSeats=" + Economy_TotalSeats
				+ ", Economy_SeatAvailable=" + Economy_SeatAvailable + ", Economy_Price=" + Economy_Price
				+ ", Total_NoOfSeats=" + Total_NoOfSeats + ", Total_Available_Seats=" + Total_Available_Seats + "]";
	}
	public int getFlight_ID() {
		return Flight_ID;
	}
	public void setFlight_ID(int flight_ID) {
		Flight_ID = flight_ID;
	}
	public int getFlight_Detail_ID() {
		return Flight_Detail_ID;
	}
	public void setFlight_Detail_ID(int flight_Detail_ID) {
		Flight_Detail_ID = flight_Detail_ID;
	}
	public int getAdmin_ID() {
		return Admin_ID;
	}
	public void setAdmin_ID(int admin_ID) {
		Admin_ID = admin_ID;
	}
	public String getFlight_Company() {
		return Flight_Company;
	}
	public void setFlight_Company(String flight_Company) {
		Flight_Company = flight_Company;
	}
	public String getFlight_Src() {
		return Flight_Src;
	}
	public void setFlight_Src(String flight_Src) {
		Flight_Src = flight_Src;
	}
	public String getFlight_Desc() {
		return Flight_Desc;
	}
	public void setFlight_Desc(String flight_Desc) {
		Flight_Desc = flight_Desc;
	}
	public Timestamp getTravel_Date_Time() {
		return Travel_Date_Time;
	}
	public void setTravel_Date_Time(Timestamp travel_Date_Time) {
		Travel_Date_Time = travel_Date_Time;
	}
	public int getBusiness_TotalSeats() {
		return Business_TotalSeats;
	}
	public void setBusiness_TotalSeats(int business_TotalSeats) {
		Business_TotalSeats = business_TotalSeats;
	}
	public int getBusiness_SeatAvailable() {
		return Business_SeatAvailable;
	}
	public void setBusiness_SeatAvailable(int business_SeatAvailable) {
		Business_SeatAvailable = business_SeatAvailable;
	}
	public float getBusiness_Price() {
		return Business_Price;
	}
	public void setBusiness_Price(float business_Price) {
		Business_Price = business_Price;
	}
	public int getFirst_TotalSeats() {
		return First_TotalSeats;
	}
	public void setFirst_TotalSeats(int first_TotalSeats) {
		First_TotalSeats = first_TotalSeats;
	}
	public int getFirst_SeatAvailable() {
		return First_SeatAvailable;
	}
	public void setFirst_SeatAvailable(int first_SeatAvailable) {
		First_SeatAvailable = first_SeatAvailable;
	}
	public float getFirst_Price() {
		return First_Price;
	}
	public void setFirst_Price(float first_Price) {
		First_Price = first_Price;
	}
	public int getEconomy_TotalSeats() {
		return Economy_TotalSeats;
	}
	public void setEconomy_TotalSeats(int economy_TotalSeats) {
		Economy_TotalSeats = economy_TotalSeats;
	}
	public int getEconomy_SeatAvailable() {
		return Economy_SeatAvailable;
	}
	public void setEconomy_SeatAvailable(int economy_SeatAvailable) {
		Economy_SeatAvailable = economy_SeatAvailable;
	}
	public float getEconomy_Price() {
		return Economy_Price;
	}
	public void setEconomy_Price(float economy_Price) {
		Economy_Price = economy_Price;
	}
	public int getTotal_NoOfSeats() {
		return Total_NoOfSeats;
	}
	public void setTotal_NoOfSeats(int total_NoOfSeats) {
		Total_NoOfSeats = total_NoOfSeats;
	}
	public int getTotal_Available_Seats() {
		return Total_Available_Seats;
	}
	public void setTotal_Available_Seats(int total_Available_Seats) {
		Total_Available_Seats = total_Available_Seats;
	}
	
	
}
