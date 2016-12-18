package team.sqjj.hospital.DaoFactory;

public class DepartmentDaoFactory {
	public static DepartmentDao getInstance(){
		return new DepartmentDaoImpl();
		
	}
}
