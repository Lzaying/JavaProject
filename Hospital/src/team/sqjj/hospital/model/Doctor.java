package team.sqjj.hospital.model;

public class Doctor {
	private String doctor_Id;
	private String name;
	private String department;
	
	public void setId(String doctor_Id) {
		this.doctor_Id = doctor_Id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getId() {
		return doctor_Id;
	}

	public String getName() {
		return name;
	}

	public String getDepartment() {
		return department;
	}
}
