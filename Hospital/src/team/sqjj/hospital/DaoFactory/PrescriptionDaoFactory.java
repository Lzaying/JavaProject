package team.sqjj.hospital.DaoFactory;

import team.sqjj.hospital.DaoImpl.PrescriptionDaoImpl;
import team.sqjj.hospital.dao.PrescriptionDao;

public class PrescriptionDaoFactory {
	public static PrescriptionDao getInstance(){
		return new PrescriptionDaoImpl();
		
	}
}
