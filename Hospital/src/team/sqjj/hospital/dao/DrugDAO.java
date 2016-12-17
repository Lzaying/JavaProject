package team.sqjj.hospital.dao;

import team.sqjj.hospital.model.Drug;

public interface DrugDAO {
public void AddDrug(String drugid,String drugname,double price,String unit,int amount);
public void UpdateDrug(String drugid,String drugname,double price,String unit,int amount);
public void DelDrug(String drugid);
public Drug FindByID(String drugid);

}
