package team.sqjj.hospital.dao;
import java.util.List;

import team.sqjj.hospital.model.Department;

public interface DepartmentDao {
public int delDepartment(String department);
public int addDepartment(Department department);
public int updateDepartment(Department department);
public List<Department> getDepartment();
public int dAppointmentCount(String department);
}
