package team.sqjj.hospital.DaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import team.sqjj.hospital.dao.PatientDao;
import team.sqjj.hospital.model.Patient;

public class PatientDaoImpl implements PatientDao{
     private Dao dao=null;
     public PatientDaoImpl(Dao dao){
    	 this.dao=dao;
      }
     
    @Override
    public Patient getInfoById(String patientId) {
	    // TODO Auto-generated method stub
	    Patient patient=null;	
        String sql="select *from Patient where Patient_Id="+patientId+"";
        ResultSet rs=dao.executeQuery(sql);
        try {
	        while(rs.next()){
		        patient=new Patient();
		        patient.setPatient_Id(rs.getString("Patient_Id"));
		        patient.setPatient_Name(rs.getString("Patient_Name"));
		        patient.setPatient_Sex(rs.getString("Patient_Sex"));
	       	    patient.setAddress(rs.getString("Address"));
		        patient.setTelephone(rs.getString("Telephone"));
	            patient.setPatient_Age(rs.getInt("Patient_Age"));
	            patient.setIsMarried(rs.getInt("IsMarried"));
	        }rs.close();
        } catch (SQLException e) {
	    // TODO Auto-generated catch block
    	         e.printStackTrace();
        }finally{
	       dao.close();
	       return patient;
        }
    }
}
