package team.sqjj.hospital.dao;

import team.sqjj.hospital.model.Drug;

public interface DrugDao {
public int delDrug(int drug_Id);
public Drug findByID(int drug_Id);
public int addDrug(Drug drug);
public int updateDrug(Drug drug);
}
