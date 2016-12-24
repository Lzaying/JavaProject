package team.sqjj.hospital.model;

public class User {
	private String id;
	private String password;
	private int role;

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public int getRole() {
		return role;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRole(int role) {
		this.role = role;
	}
}
