package team.sqjj.hospital.dao;

import team.sqjj.hospital.model.Drug;

public interface DrugDao {
public int delDrug(String drugId);
public Drug findByID(String drugId);
public int addDrug(Drug drug);
public int updateDrug(Drug drug);

}
