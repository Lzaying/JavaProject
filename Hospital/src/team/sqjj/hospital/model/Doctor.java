package team.sqjj.hospital.model;

public class Doctor {
	private String doctor_Id;
	private String name;
	private int department_Id;
	
	public void setId(String doctor_Id) {
		this.doctor_Id = doctor_Id;
	}
	public String getDoctor_Id() {
		return doctor_Id;
	}
	public void setDoctor_Id(String doctor_Id) {
		this.doctor_Id = doctor_Id;
	}
	public void setName(String name) {
		this.name = name;
	}

	public void setDepartment_Id(int department_Id) {
		this.department_Id= department_Id;
	}

	public String getId() {
		return doctor_Id;
	}

	public String getName() {
		return name;
	}

	public int getDepartment_Id() {
		return department_Id;
	}
}
