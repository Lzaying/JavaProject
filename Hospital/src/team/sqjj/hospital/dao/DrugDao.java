package team.sqjj.hospital.dao;

import team.sqjj.hospital.model.Drug;

public interface DrugDAO {
	public int addDrug(String drugId, String drugName, double price, String unit, int amount);

	public int updateDrug(String drugId, String drugName, double price, String unit, int amount);

	public int delDrug(String drugId);

	public Drug findByID(String drugId);
}
