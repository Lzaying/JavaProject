package team.sqjj.hospital.DaoFactory;

public class RegisterDaoFactory {
	public static RegisterDao getInstance(){
		return new RegisterDaoImpl();
		
	}
}
