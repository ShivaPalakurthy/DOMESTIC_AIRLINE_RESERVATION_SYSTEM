package TravellingDetailsPackage;

import java.sql.Timestamp;

public class TravellingDetails {
		private int Travel_id;
		private int User_id;
		private int Flight_id;
		private Timestamp Booking_date;
		private int TotalSeats_booking;
		private String SeatType;
		private float Fare_PerTicket;
		private float Total_Fare;
		private float Total_DiscountAmount;
		private float TotalFare_AfterDiscount;
		private float Fare_perTicket_AfterDiscount;
		@Override
		public String toString() {
			return "TravellingDetails [Travel_id=" + Travel_id + ", User_id=" + User_id + ", Flight_id=" + Flight_id
					+ ", Booking_date=" + Booking_date + ", TotalSeats_booking=" + TotalSeats_booking + ", SeatType="
					+ SeatType + ", Fare_PerTicket=" + Fare_PerTicket + ", Total_Fare=" + Total_Fare
					+ ", Total_DiscountAmount=" + Total_DiscountAmount + ", TotalFare_AfterDiscount="
					+ TotalFare_AfterDiscount + ", Fare_perTicket_AfterDiscount=" + Fare_perTicket_AfterDiscount + "]";
		}
		public TravellingDetails(int travel_id, int user_id, int flight_id, Timestamp booking_date,
				int totalSeats_booking, String seatType, float fare_PerTicket, float total_Fare,
				float total_DiscountAmount, float totalFare_AfterDiscount, float fare_perTicket_AfterDiscount) {
			super();
			Travel_id = travel_id;
			User_id = user_id;
			Flight_id = flight_id;
			Booking_date = booking_date;
			TotalSeats_booking = totalSeats_booking;
			SeatType = seatType;
			Fare_PerTicket = fare_PerTicket;
			Total_Fare = total_Fare;
			Total_DiscountAmount = total_DiscountAmount;
			TotalFare_AfterDiscount = totalFare_AfterDiscount;
			Fare_perTicket_AfterDiscount = fare_perTicket_AfterDiscount;
		}
		public int getTravel_id() {
			return Travel_id;
		}
		public void setTravel_id(int travel_id) {
			Travel_id = travel_id;
		}
		public int getUser_id() {
			return User_id;
		}
		public void setUser_id(int user_id) {
			User_id = user_id;
		}
		public int getFlight_id() {
			return Flight_id;
		}
		public void setFlight_id(int flight_id) {
			Flight_id = flight_id;
		}
		public Timestamp getBooking_date() {
			return Booking_date;
		}
		public void setBooking_date(Timestamp booking_date) {
			Booking_date = booking_date;
		}
		public int getTotalSeats_booking() {
			return TotalSeats_booking;
		}
		public void setTotalSeats_booking(int totalSeats_booking) {
			TotalSeats_booking = totalSeats_booking;
		}
		public String getSeatType() {
			return SeatType;
		}
		public void setSeatType(String seatType) {
			SeatType = seatType;
		}
		public float getFare_PerTicket() {
			return Fare_PerTicket;
		}
		public void setFare_PerTicket(float fare_PerTicket) {
			Fare_PerTicket = fare_PerTicket;
		}
		public float getTotal_Fare() {
			return Total_Fare;
		}
		public void setTotal_Fare(float total_Fare) {
			Total_Fare = total_Fare;
		}
		public float getTotal_DiscountAmount() {
			return Total_DiscountAmount;
		}
		public void setTotal_DiscountAmount(float total_DiscountAmount) {
			Total_DiscountAmount = total_DiscountAmount;
		}
		public float getTotalFare_AfterDiscount() {
			return TotalFare_AfterDiscount;
		}
		public void setTotalFare_AfterDiscount(float totalFare_AfterDiscount) {
			TotalFare_AfterDiscount = totalFare_AfterDiscount;
		}
		public float getFare_perTicket_AfterDiscount() {
			return Fare_perTicket_AfterDiscount;
		}
		public void setFare_perTicket_AfterDiscount(float fare_perTicket_AfterDiscount) {
			Fare_perTicket_AfterDiscount = fare_perTicket_AfterDiscount;
		}
}
