package team.sqjj.hospital.DaoFactory;

public class UserDaoFactory {
	public static UserDao getInstance(){
		return new UserDaoImpl();
		
	}
}
