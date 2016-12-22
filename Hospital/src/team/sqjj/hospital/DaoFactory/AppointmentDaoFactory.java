package team.sqjj.hospital.DaoFactory;

import team.sqjj.hospital.DaoImpl.AppointmentDaoImpl;
import team.sqjj.hospital.dao.AppointmentDao;

public class AppointmentDaoFactory {
	public static AppointmentDao getInstance(){
		return new AppointmentDaoImpl();
		
	}
}
