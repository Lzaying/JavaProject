package team.sqjj.hospital.model;

public class Order {
private int order_Id;
private String doctor_Name;
private String drug_Name;
private String patient_Id;
private String id;
private String department;
private int drug_Id;
private int quantity;
public String getPatient_Id() {
	return patient_Id;
}
public void setOrder_Id(int order_Id){
	this.order_Id=order_Id;
}
public void setPatient_Id(String patient_Id) {
	this.patient_Id = patient_Id;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getDepartment() {
	return department;
}
public void setDepartment(String department) {
	this.department = department;
}
public int getDrug_Id() {
	return drug_Id;
}
public void setDrug_Id(int drug_Id) {
	this.drug_Id = drug_Id;
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
	this.IsPaid = isPaid;
}

public void setDoctor_Name(String doctor_Name){
	this.doctor_Name=doctor_Name;
}
public void setDrug_Name(String drug_Name)
{
	this.drug_Name=drug_Name;
}
private int IsPaid;

}

