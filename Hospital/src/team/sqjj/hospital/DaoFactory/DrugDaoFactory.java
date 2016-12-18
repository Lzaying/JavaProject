package team.sqjj.hospital.DaoFactory;

public class DrugDaoFactory {
	public static DrugDAO getInstance(){
		return new DrugDAOImpl();
		
	}
}
