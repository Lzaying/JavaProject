package team.sqjj.hospital.dao;

import java.util.List;

import team.sqjj.hospital.model.Drug;

public interface DrugDao {
public int delDrug(int drug_Id);
public Drug findByID(int drug_Id);
public int addDrug(Drug drug);
public int updateDrug(Drug drug);
public List<Drug> getByname(String name);


public List<Drug> getByname(String name);


}
