package team.sqjj.hospital.model;

public class Doctor {
	private String Id;
	private String Name;
	private String Department;

	public void setId(String Id) {
		this.Id = Id;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public void setDepartment(String Department) {
		this.Department = Department;
	}

	public String getId() {
		return Id;
	}

	public String getName() {
		return Name;
	}

	public String getDepartment() {
		return Department;
	}
}
