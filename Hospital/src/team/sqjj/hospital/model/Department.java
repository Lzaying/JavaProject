package team.sqjj.hospital.model;

public class Department {
	private int department_Id;
	private String department;
	private String information;
	private int room;
	
    public int getDepartmentId(){
    	return department_Id;
    }

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getDepartment_Id() {
		return department_Id;
	}

	public void setDepartment_Id(int department_Id) {
		this.department_Id = department_Id;
	}

	public void setRoom(int room) {
		this.room = room;
	}

	public void setInformation(String information) {
		this.information =information;
	}

	public String getDepartment() {
		return department;
	}

	public String getInformation() {
		return information;
	}
	public int getRoom(){
		return room;
	}
}
