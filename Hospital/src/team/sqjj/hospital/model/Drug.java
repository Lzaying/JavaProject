package team.sqjj.hospital.model;

public class Drug {
	private int drug_Id;
	private String drug_Name;
	private double price;
	private String unit;
	private int amount;

	public void setDrug_Id(int drug_Id) {
		this.drug_Id = drug_Id;
	}

	public void setDrug_Name(String drug_Name) {
		this.drug_Name = drug_Name;
	}

	

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getDrug_Id() {
		return drug_Id;
	}

	public String getDrug_Name() {
		return drug_Name;
	}



	public String getUnit() {
		return unit;
	}

	public int getAmount() {
		return amount;
	}
}
