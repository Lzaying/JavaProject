package team.sqjj.hospital.model;

public class Patient {
	private String patient_Id;
	private String patient_Name;
	private String patient_Sex;
	private String address;
	private String telephone;
	private int patient_Age;
	private int isMarried;

	public void setPatient_Id(String patient_Id) {
		this.patient_Id = patient_Id;
	}

	public void setPatient_Name(String Patient_Name) {
		this.patient_Name = Patient_Name;
	}

	public void setPatient_Sex(String patient_Sex) {
		this.patient_Sex = patient_Sex;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public void setPatient_Age(int patient_Age) {
		this.patient_Age = patient_Age;
	}

	public void setIsMarried(int isMarried) {
		this.isMarried = isMarried;
	}

	public String getPatient_Id() {
		return patient_Id;
	}

	public String getPatient_Name() {
		return patient_Name;
	}

	public String getPatient_Sex() {
		return patient_Sex;
	}

	public String getAddress() {
		return address;
	}

	public String getTelephone() {
		return telephone;
	}

	public int getPatient_Age() {
		return patient_Age;
	}

	public int getIsMarried() {
		return isMarried;
	}
}
