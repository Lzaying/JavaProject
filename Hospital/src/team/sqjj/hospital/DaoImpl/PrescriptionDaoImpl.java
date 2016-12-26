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
    public int payPrescription(int prescription_Id){
    	int i=0;
    	int j=1;
		try{
			String sql="update Prescription set IsPaid "+j+" where prescription_Id ="+prescription_Id+"";
			i=dao.executeUpdate(sql);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		dao.close();
		return i;
    }
    @Override
    public List<Prescription> getByPatientID (String patient_Id){
    	Prescription prescription=null;
        String sql="select *from Prescription where Patient_Id='"+patient_Id+"'";
        ResultSet rs=dao.executeQuery(sql);
        List<Prescription> list = new ArrayList<Prescription>();
	    try {
	        while(rs.next()){
	        	prescription=new Prescription();
	        	prescription.setPrescription_Id(rs.getInt("prescription_Id"));
	        	prescription.setTotalPrice(rs.getDouble("TotalPrice"));
	        	prescription.setPatient_Id(rs.getString("Patient_Id"));
	        	prescription.setDoctor_Id(rs.getString("Dctor_Id"));
	        	prescription.setIsPaid(rs.getInt("IsPaid"));
		        list.add(prescription);
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
    	Prescription prescription=null;
        String sql="select *from Prescription where Doctor_Id='"+doctor_Id+"'";
        ResultSet rs=dao.executeQuery(sql);
        List<Prescription> list = new ArrayList<Prescription>();
	    try {
	        while(rs.next()){
	        	prescription=new Prescription();
	        	prescription.setPrescription_Id(rs.getInt("prescription_Id"));
	        	prescription.setTotalPrice(rs.getDouble("TotalPrice"));
	        	prescription.setPatient_Id(rs.getString("Patient_Id"));
	        	prescription.setDoctor_Id(rs.getString("Dctor_Id"));
	        	prescription.setIsPaid(rs.getInt("IsPaid"));
		        list.add(prescription);
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
	public double doTotalPrice(String doctor_Id) {
		double dotp=0;
		try{
			String sql="select sum(TotalPrice) from Prescription where Doctor_Id='"+doctor_Id+"'";
			ResultSet rs=dao.executeQuery(sql);
			if(rs.next())
			{
				dotp=rs.getInt(1);
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		dao.close();		
		return dotp;
	}
	@Override
	public double deTotalPrice(String department) {
		double detp=0;
		try{
			String sql="select sum(TotalPrice) from Prescription where Doctor_Id=(select Doctor_Id from Doctor where Department_Id=(select Department_Id from Department where Department='"+department+"'))";
			ResultSet rs=dao.executeQuery(sql);
			if(rs.next())
			{
				detp=rs.getDouble(1);
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		dao.close();		
		return detp;
	}
	@Override
	public List<Prescription> getPaid() {
		Prescription prescription=null;
        String sql="select *from Prescription where IsPaid=1";
        ResultSet rs=dao.executeQuery(sql);
        List<Prescription> list = new ArrayList<Prescription>();
	    try {
	        while(rs.next()){
	        	prescription=new Prescription();
	        	prescription.setPrescription_Id(rs.getInt("prescription_Id"));
	        	prescription.setTotalPrice(rs.getDouble("TotalPrice"));
	        	prescription.setPatient_Id(rs.getString("Patient_Id"));
	        	prescription.setDoctor_Id(rs.getString("Dctor_Id"));
	        	prescription.setIsPaid(rs.getInt("IsPaid"));
		        list.add(prescription);
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
	public List<Prescription> getUnPaidr() {
		Prescription prescription=null;
        String sql="select *from Prescription where Patient_Id=0";
        ResultSet rs=dao.executeQuery(sql);
        List<Prescription> list = new ArrayList<Prescription>();
	    try {
	        while(rs.next()){
	        	prescription=new Prescription();
	        	prescription.setPrescription_Id(rs.getInt("prescription_Id"));
	        	prescription.setTotalPrice(rs.getDouble("TotalPrice"));
	        	prescription.setPatient_Id(rs.getString("Patient_Id"));
	        	prescription.setDoctor_Id(rs.getString("Dctor_Id"));
	        	prescription.setIsPaid(rs.getInt("IsPaid"));
		        list.add(prescription);
	        }rs.close();
        } catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
        }	finally{
	        dao.close();
	        return list;
	        }
	}
}
