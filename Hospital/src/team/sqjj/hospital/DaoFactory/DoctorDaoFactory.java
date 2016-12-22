package team.sqjj.hospital.DaoFactory;

import team.sqjj.hospital.DaoImpl.DoctorDaoImpl;
import team.sqjj.hospital.dao.DoctorDao;

public class DoctorDaoFactory {
	public static DoctorDao getInstance(){
		return new DoctorDaoImpl();
		
	}
}
