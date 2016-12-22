package team.sqjj.hospital.DaoFactory;

import team.sqjj.hospital.DaoImpl.RegisterDaoImpl;
import team.sqjj.hospital.dao.RegisterDao;

public class RegisterDaoFactory {
	public static RegisterDao getInstance(){
		return new RegisterDaoImpl();
		
	}
}
