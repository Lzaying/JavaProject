package team.sqjj.hospital.model;

import java.io.Serializable;

public class PrescriptionItem implements Serializable{
	private int  Item_id;
	private int drug_id;
	private int prescription_id;
	private int quantity;
	public int getItem_id() {
		return Item_id;
	}
	public void setItem_id(int item_id) {
		Item_id = item_id;
	}
	public int getDrug_id() {
		return drug_id;
	}
	public void setDrug_id(int drug_id) {
		this.drug_id = drug_id;
	}
	public int getPrescription_id() {
		return prescription_id;
	}
	public void setPrescription_id(int prescription_id) {
		this.prescription_id = prescription_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

}
