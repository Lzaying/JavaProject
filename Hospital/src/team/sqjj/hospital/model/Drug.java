package team.sqjj.hospital.model;

public class Drug {
	private String Drug_Id;
	private String Drug_Name;
	private double Price;
	private String Unit;
	private int Amount;

	public void setDrug_Id(String Drug_Id) {
		this.Drug_Id = Drug_Id;
	}

	public void setDrug_Name(String Drug_Name) {
		this.Drug_Name = Drug_Name;
	}

	

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}

	public void setUnit(String Unit) {
		this.Unit = Unit;
	}

	public void setAmount(int Amount) {
		this.Amount = Amount;
	}

	public String getDrug_Id() {
		return Drug_Id;
	}

	public String getDrug_Name() {
		return Drug_Name;
	}



	public String getUnit() {
		return Unit;
	}

	public int getAmount() {
		return Amount;
	}
}
