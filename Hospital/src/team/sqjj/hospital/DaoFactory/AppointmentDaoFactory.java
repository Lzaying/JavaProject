package team.sqjj.hospital.DaoFactory;

public class AppointmentDaoFactory {
	public static AppointmentDao getInstance(){
		return new AppointmentDaoImpl();
		
	}
}
