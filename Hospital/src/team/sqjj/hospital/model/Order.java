package team.sqjj.hospital.model;

public class Order {
	
private String patientid;
private String Doctorid;
private String Department;
private String drugid;
private int quantity;
public String getPatientid() {
	return patientid;
}
public void setPatientid(String patientid) {
	this.patientid = patientid;
}
public String getDoctorid() {
	return Doctorid;
}
public void setDoctorid(String doctorid) {
	Doctorid = doctorid;
}
public String getDepartment() {
	return Department;
}
public void setDepartment(String department) {
	Department = department;
}
public String getDrugid() {
	return drugid;
}
public void setDrugid(String drugid) {
	this.drugid = drugid;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public int getIsPaid() {
	return IsPaid;
}
public void setIsPaid(int isPaid) {
	IsPaid = isPaid;
}
private int IsPaid;

}
