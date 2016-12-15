package team.sqjj.hospital.model;

public class User {
	private String Id;
	private String Password;
	private int Role;
	private String Name;

	public String getId() {
		return Id;
	}

	public String getPassword() {
		return Password;
	}

	public String getName() {
		return Name;
	}

	public int getRole() {
		return Role;
	}

	public void setId(String Id) {
		this.Id = Id;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public void setPassword(String Password) {
		this.Password = Password;
	}

	public void setRole(int Role) {
		this.Role = Role;
	}
}
