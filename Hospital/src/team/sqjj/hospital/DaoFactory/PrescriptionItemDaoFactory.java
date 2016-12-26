package team.sqjj.hospital.DaoFactory;
import team.sqjj.hospital.DaoImpl.PrescriptionItemDaoImpl;
import team.sqjj.hospital.dao.PrescriptionItemDao;

public class PrescriptionItemDaoFactory {
	public static PrescriptionItemDao getInstance(){
		return new PrescriptionItemDaoImpl();		
	}
}
