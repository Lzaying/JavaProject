package team.sqjj.hospital.DaoFactory;

import team.sqjj.hospital.DaoImpl.PatientDaoImpl;
import team.sqjj.hospital.dao.PatientDao;

public class PatientDaoFactory {
public static PatientDao getInstance(){
	return new PatientDaoImpl();
	
}
}
