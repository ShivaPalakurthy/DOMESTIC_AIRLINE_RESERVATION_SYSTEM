package UserTablePackage;

public class UserTable {
	private int User_ID;
	private String UserName;
	private String Email;
	private String pass;
	public UserTable(int user_ID, String userName, String email, String pass) {
		super();
		User_ID = user_ID;
		UserName = userName;
		Email = email;
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "UserTable [User_ID=" + User_ID + ", UserName=" + UserName + ", Email=" + Email + ", pass=" + pass + "]";
	}
	public int getUser_ID() {
		return User_ID;
	}
	public void setUser_ID(int user_ID) {
		User_ID = user_ID;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
}
