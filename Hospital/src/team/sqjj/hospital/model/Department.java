package team.sqjj.hospital.model;

public class Department {
	private String Department;
	private String Information;
	private int Room;

	public void setDepartment(String Department) {
		this.Department = Department;
	}

	public void setInformation(String Information) {
		this.Information = Information;
	}

	public void setRoom(int Room) {
		this.Room = Room;
	}

	public String getDepartment() {
		return Department;
	}

	public String getInformation() {
		return Information;
	}

	public int getRoom() {
		return Room;
	}
}
