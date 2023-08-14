package AdminTablePackage;

public class AdminTable {
	private int Admin_ID;
	private String AdminName;
	private String Email;
	private String pass;
	@Override
	public String toString() {
		return "AdminTable [Admin_ID=" + Admin_ID + ", AdminName=" + AdminName + ", Email=" + Email + ", pass=" + pass
				+ "]";
	}
	public AdminTable(int admin_ID, String adminName, String email, String pass) {
		super();
		Admin_ID = admin_ID;
		AdminName = adminName;
		Email = email;
		this.pass = pass;
	}
	public int getAdmin_ID() {
		return Admin_ID;
	}
	public void setAdmin_ID(int admin_ID) {
		Admin_ID = admin_ID;
	}
	public String getAdminName() {
		return AdminName;
	}
	public void setAdminName(String adminName) {
		AdminName = adminName;
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
