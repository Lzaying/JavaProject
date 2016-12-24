package team.sqjj.hospital.DaoFactory;

import team.sqjj.hospital.DaoImpl.PrescriptionDaoImpl;
import team.sqjj.hospital.dao.PrescriptionDao;

public class PrescribeDaoFactory {
	public static PrescriptionDao getInstance(){
		return new PrescriptionDaoImpl();
		
	}
}
