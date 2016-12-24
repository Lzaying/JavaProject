package team.sqjj.hospital.dao;

import team.sqjj.hospital.model.Department;

public interface DepartmentDao {

public int addDepartment(Department d) ;
public int updateDepartment(Department d);
public int delDepartment(int department_id);

}
