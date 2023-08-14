package PassengerBookingDetailsPackage;

public class PassengerBookingDetails {
		private long PNR; //Passenger Name Record
		private int Travel_ID;
		private String Fname;
		private String Lname;
		private String Email;
		private int Age;
		private int Seat_Number;
		private String Address;
		@Override
		public String toString() {
			return "PassengerBookingDetails [PNR=" + PNR + ", Travel_ID=" + Travel_ID + ", Fname=" + Fname + ", Lname="
					+ Lname + ", Email=" + Email + ", Age=" + Age + ", Seat_Number=" + Seat_Number + ", Address="
					+ Address + "]";
		}
		public PassengerBookingDetails(long pNR, int travel_ID, String fname, String lname, String email, int age,
				int seat_Number, String address) {
			super();
			PNR = pNR;
			Travel_ID = travel_ID;
			Fname = fname;
			Lname = lname;
			Email = email;
			Age = age;
			Seat_Number = seat_Number;
			Address = address;
		}
		public long getPNR() {
			return PNR;
		}
		public void setPNR(long pNR) {
			PNR = pNR;
		}
		public int getTravel_ID() {
			return Travel_ID;
		}
		public void setTravel_ID(int travel_ID) {
			Travel_ID = travel_ID;
		}
		public String getFname() {
			return Fname;
		}
		public void setFname(String fname) {
			Fname = fname;
		}
		public String getLname() {
			return Lname;
		}
		public void setLname(String lname) {
			Lname = lname;
		}
		public String getEmail() {
			return Email;
		}
		public void setEmail(String email) {
			Email = email;
		}
		public int getAge() {
			return Age;
		}
		public void setAge(int age) {
			Age = age;
		}
		public int getSeat_Number() {
			return Seat_Number;
		}
		public void setSeat_Number(int seat_Number) {
			Seat_Number = seat_Number;
		}
		public String getAddress() {
			return Address;
		}
		public void setAddress(String address) {
			Address = address;
		}
}
