package team.sqjj.hospital.dao;

import team.sqjj.hospital.model.Patient;

public interface PatientDao {
	 public Patient getInfoById(String Patient_Id);
	 public int addPatient(Patient p);
}
