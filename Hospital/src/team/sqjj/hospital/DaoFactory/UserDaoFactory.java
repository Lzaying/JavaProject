package team.sqjj.hospital.DaoFactory;

import team.sqjj.hospital.DaoImpl.UserDaoImpl;
import team.sqjj.hospital.dao.UserDao;

public class UserDaoFactory {
	public static UserDao getInstance(){
		return new UserDaoImpl();
		
	}
}
