package team.sqjj.hospital.dao;

import java.util.List;

import team.sqjj.hospital.model.Doctor;

public interface DoctorDao {
public List<Doctor> GetByDepartment(String department);
public void AddDoctor(String Id,String name,String department);
public void UpdateDoctor(String id,String name,String department);
public void DelDoctor(String Id);


}
