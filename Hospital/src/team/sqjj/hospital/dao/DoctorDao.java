package team.sqjj.hospital.dao;

import java.util.List;

import team.sqjj.hospital.model.Doctor;

public interface DoctorDao {
public List<Doctor> getByDepartment(String department);
public int delDoctor(String Id);
public int addDoctor(Doctor doctor);
public int updateDoctor(Doctor doctor);
}
