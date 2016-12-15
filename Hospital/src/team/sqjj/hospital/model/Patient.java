package team.sqjj.hospital.model;

public class Patient {
	private String Patient_Id;
	private String Patient_Name;
	private String Patient_Sex;
	private String Address;
	private String Telephone;
	private int Patient_Age;
	private int IsMarried;

	public void setPatient_Id(String Patient_Id) {
		this.Patient_Id = Patient_Id;
	}

	public void setPatient_Name(String Patient_Name) {
		this.Patient_Name = Patient_Name;
	}

	public void setPatient_Sex(String Patient_Sex) {
		this.Patient_Sex = Patient_Sex;
	}

	public void setAddress(String Address) {
		this.Address = Address;
	}

	public void setTelephone(String Telephone) {
		this.Telephone = Telephone;
	}

	public void setPatient_Age(int Patient_Age) {
		this.Patient_Age = Patient_Age;
	}

	public void setIsMarried(int IsMarried) {
		this.IsMarried = IsMarried;
	}

	public String getPatient_Id() {
		return Patient_Id;
	}

	public String getPatient_Name() {
		return Patient_Name;
	}

	public String getPatient_Sex() {
		return Patient_Sex;
	}

	public String getAddress() {
		return Address;
	}

	public String getTelephone() {
		return Telephone;
	}

	public int getPatient_Age() {
		return Patient_Age;
	}

	public int getIsMarried() {
		return IsMarried;
	}
}
