package team.sqjj.hospital.dao;

import team.sqjj.hospital.model.Department;

public interface DepartmentDao {
public int delDepartment(String department);
public int addDepartment(Department department);
public int updateDepartment(Department department);
}
