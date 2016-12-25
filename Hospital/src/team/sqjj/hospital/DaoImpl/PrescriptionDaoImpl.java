package team.sqjj.hospital.DaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import team.sqjj.hospital.dao.PrescriptionDao;
import team.sqjj.hospital.model.Prescription;

public class PrescriptionDaoImpl implements PrescriptionDao{
    private Dao dao=null;
    public PrescriptionDaoImpl(){ dao=new Dao();}
    @Override
    public int addPrescription(Prescription prescription){
    	int i=0;
		try{
			String sql="insert into Prescription values("+prescription.getPrescription_Id()+",'"+prescription.getPatient_Id()+"','"+prescription.getDoctor_Id()+"',"+prescription.getTotalPrice()+","+prescription.getIsPaid()+")";
			i=dao.executeUpdate(sql);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		dao.close();
		return i;
    }
    @Override
    public int payPrescription(String prescriptionId){
    	int i=0;
    	int j=1;
		try{
			String sql="update Prescription set IsPaid "+j+" where prescription_Id ="+prescriptionId+"";
			i=dao.executeUpdate(sql);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		dao.close();
		return i;
    }
    @Override
    public List<Prescription> getByPatientID (String patientId){
    	Prescription Prescription=null;
        String sql="select *from Prescription where Patient_Id='"+patientId+"'";
        ResultSet rs=dao.executeQuery(sql);
        List<Prescription> list = new ArrayList<Prescription>();
	    try {
	        while(rs.next()){
	        	Prescription=new Prescription();
	        	Prescription.setPrescription_Id(rs.getInt("prescription_Id"));
	        	Prescription.setDrug_Id(rs.getInt("Drug_Id"));
	        	Prescription.setPatient_Id(rs.getString("Patient_Id"));
	        	Prescription.setDoctor_Id(rs.getString("Dctor_Id"));
	        	Prescription.setIsPaid(rs.getInt("IsPaid"));
		        list.add(Prescription);
	        }rs.close();
        } catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
        }	finally{
	        dao.close();
	        return list;
	        }
    }
    @Override
    public List<Prescription> getByDoctor(String doctor_Id){
    	Prescription Prescription=null;
        String sql="select *from Prescription where Id='"+doctor_Id+"'";
        ResultSet rs=dao.executeQuery(sql);
        List<Prescription> list = new ArrayList<Prescription>();
	    try {
	        while(rs.next()){
	        	Prescription=new Prescription();
	        	Prescription.setPrescription_Id(rs.getInt("prescription_Id"));
	        	Prescription.setDrug_Id(rs.getInt("Drug_Id"));
	        	Prescription.setPatient_Id(rs.getString("Patient_Id"));
	        	Prescription.setDoctor_Id(rs.getString("Dctor_Id"));
	        	Prescription.setIsPaid(rs.getInt("IsPaid"));
		        list.add(Prescription);
	        }rs.close();
        } catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
        }	finally{
	        dao.close();
	        return list;
	        }
    }
	@Override
	public int payPrescription(int prescription_Id) {
		// TODO Auto-generated method stub
		return 0;
	}
}