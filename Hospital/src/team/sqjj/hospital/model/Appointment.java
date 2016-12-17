package team.sqjj.hospital.model;

import java.util.Date;

public class Appointment {
	private String Patient_Id;
	private String Department;
	private Date time;// 没有数据类型为datetime
	private int Appointment;

	public void setPatient_Id(String Patient_Id) {
		this.Patient_Id = Patient_Id;
	}

	public void setDepartment(String Department) {
		this.Department = Department;
	}

	public void settime(Date time) {
		this.time = time;
	}

	public void setAppoitment(int Appoitment) {
		this.Appointment = Appoitment;
	}

	public String getPatient_Id() {
		return Patient_Id;
	}

	public String getDepartment() {
		return Department;
	}

	public Date gettime() {
		return time;
	}

	public int getAppointment() {
		return Appointment;
	}
}
