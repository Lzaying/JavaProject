package team.sqjj.hospital.dao;

import java.util.List;

import team.sqjj.hospital.model.Doctor;

public interface DoctorDao {

public List<Doctor> getByDepartment(int department_id);
public int addDoctor(Doctor d);
public int updateDoctor(String id,String name,String department);

public int delDoctor(String Id);
public Doctor getbyID(String id);
public int updateDoctor(Doctor doctor);
}
