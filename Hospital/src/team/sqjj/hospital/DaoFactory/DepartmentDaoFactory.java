package team.sqjj.hospital.DaoFactory;

import team.sqjj.hospital.DaoImpl.DepartmentDaoImpl;
import team.sqjj.hospital.dao.DepartmentDao;

public class DepartmentDaoFactory {
	public static DepartmentDao getInstance(){
		return new DepartmentDaoImpl();
		
	}
}
