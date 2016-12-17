package team.sqjj.hospital.DaoImpl;

import team.sqjj.hospital.dao.PatientDao;
import team.sqjj.hospital.model.Patient;

public class PatientDaoImpl implements PatientDao{
private Dao dao=null;
public PatientDaoImpl(Dao dao){this.dao=dao;}
@Override
public Patient GetInfoById(String PatientId) {
	// TODO Auto-generated method stub
String sql="select *from Patient where PatientId";
	dao.executeQuery(sql);
	
	
	return null;
}


}
