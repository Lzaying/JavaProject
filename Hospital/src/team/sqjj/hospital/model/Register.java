package team.sqjj.hospital.model;

public class Register {
	private String Register_Id;
	private String Patient_Id;
	private String Department;
	private int Doctor;
	private int IsLooked;// �������Ϳ���ʹ�ò���ֵ

	public void setRegister_Id(String Register_Id) {
		this.Register_Id = Register_Id;
	}

	public void setPatient_Id(String Patient_Id) {
		this.Patient_Id = Patient_Id;
	}

	public void setDepartment(String Department) {
		this.Department = Department;
	}

	public void setDoctor(int Doctor) {
		this.Doctor = Doctor;
	}

	public void setIsLooked(int IsLooked) {
		this.IsLooked = IsLooked;
	}

	public String getRegister_Id() {
		return Register_Id;
	}

	public String getPatient_Id() {
		return Patient_Id;
	}

	public String getDepartment() {
		return Department;
	}

	public int getDoctor() {
		return Doctor;
	}

	public int getIsLooked() {
		return IsLooked;
	}

}
