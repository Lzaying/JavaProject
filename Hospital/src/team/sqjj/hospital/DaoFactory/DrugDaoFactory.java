package team.sqjj.hospital.DaoFactory;

import team.sqjj.hospital.DaoImpl.DrugDaoImpl;
import team.sqjj.hospital.dao.DrugDao;

public class DrugDaoFactory {
	public static DrugDao getInstance(){
		return new DrugDaoImpl();
		
	}
}
