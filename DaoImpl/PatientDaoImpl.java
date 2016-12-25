package team.sqjj.hospital.DaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import team.sqjj.hospital.dao.PatientDao;
import team.sqjj.hospital.model.Patient;

public class PatientDaoImpl implements PatientDao{
     private Dao dao=null;
     public PatientDaoImpl(){
    	 
        dao=new Dao();   }
  
    @Override
    public Patient getInfoById(String patient_Id) {
	    // TODO Auto-generated method stub
	    Patient patient=null;	
        String sql="select * from Patient where Patient_Id='"+patient_Id+"'";
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

	@Override
	public int addPatient(Patient p) {
		// TODO Auto-generated method stub
		int i=0;
		try{
			String sql="insert into Patient values('"+p.getPatient_Id()+"','"+p.getPatient_Name()+"',"+p.getPatient_Sex()+","+p.getPatient_Age()+","+p.getIsMarried()+",'"+p.getTelephone()+"','"+p.getAddress()+"')";
			i=dao.executeUpdate(sql);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		dao.close();
		return i;
	}
}
