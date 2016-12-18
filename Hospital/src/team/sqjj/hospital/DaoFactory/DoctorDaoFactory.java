package team.sqjj.hospital.DaoFactory;

public class DoctorDaoFactory {
	public static DoctorDao getInstance(){
		return new DoctorDaoImpl();
		
	}
}
