package team.sqjj.hospital.dao;

import java.util.List;

import team.sqjj.hospital.model.Doctor;

public interface DoctorDao {
public List<Doctor> getByDepartment_Id(int department_Id);
public int delDoctor(String Doctor_Id);
public int addDoctor(Doctor doctor);
public int updateDoctor(Doctor doctor);
public List<Doctor> getByDoctor_Id(String doctor_Id);
List<Doctor> getByDepartment(String department);
}
