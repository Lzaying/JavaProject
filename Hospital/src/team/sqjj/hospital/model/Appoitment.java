package team.sqjj.hospital.model;

public class Appoitment {
	private String Patient_Id;
	private String Department;
	private int time;// 没有数据类型为datetime
	private int Appoitment;

	public void setPatient_Id(String Patient_Id) {
		this.Patient_Id = Patient_Id;
	}

	public void setDepartment(String Department) {
		this.Department = Department;
	}

	public void settime(int time) {
		this.time = time;
	}

	public void setAppoitment(int Appoitment) {
		this.Appoitment = Appoitment;
	}

	public String getPatient_Id() {
		return Patient_Id;
	}

	public String getDepartment() {
		return Department;
	}

	public int gettime() {
		return time;
	}

	public int getAppoitment() {
		return Appoitment;
	}
}
