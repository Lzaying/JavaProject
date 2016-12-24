package team.sqjj.hospital.dao;

import java.util.List;

import team.sqjj.hospital.model.Doctor;

public interface DoctorDao {
public List<Doctor> getByDepartment(int department_Id);
public int delDoctor(String Doctor_Id);
public int addDoctor(Doctor doctor);
public int updateDoctor(Doctor doctor);
}
