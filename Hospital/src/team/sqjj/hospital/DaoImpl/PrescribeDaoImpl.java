package team.sqjj.hospital.DaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import team.sqjj.hospital.dao.PrescribeDao;
import team.sqjj.hospital.model.Prescribe;

public class PrescribeDaoImpl implements PrescribeDao{
    private Dao dao=null;
    public PrescribeDaoImpl(){ dao=new Dao();}
    @Override
    public int addPrescribe(Prescribe prescribe){
    	int i=0;
		try{
			String sql="insert into Prescribe values("+prescribe.getDrug_Id()+",'"+prescribe.getPatient_Id()+"','"+prescribe.getId()+"','"+prescribe.getDoctor_Name()+"','"+prescribe.getDepartment()+"','"+prescribe.getDrug_Name()+"',"+prescribe.getQuantity()+","+prescribe.getIsPaid()+")";
			i=dao.executeUpdate(sql);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		dao.close();
		return i;
    }
    @Override
    public int payPrescribe(String PrescribeId){
    	int i=0;
    	int j=1;
		try{
			String sql="update Prescribe set IsPaid "+j+" where Prescribe_Id ="+PrescribeId+"";
			i=dao.executeUpdate(sql);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		dao.close();
		return i;
    }
    @Override
    public List<Prescribe> getByPatientID (String patientId){
    	Prescribe Prescribe=null;
        String sql="select *from Prescribe where Patient_Id='"+patientId+"'";
        ResultSet rs=dao.executeQuery(sql);
        List<Prescribe> list = new ArrayList<Prescribe>();
	    try {
	        while(rs.next()){
	        	Prescribe=new Prescribe();
	        	Prescribe.setPrescribe_Id(rs.getInt("Prescribe_Id"));
	        	Prescribe.setDrug_Id(rs.getInt("Drug_Id"));
	        	Prescribe.setPatient_Id(rs.getString("Patient_Id"));
	        	Prescribe.setId(rs.getString("Id"));
	        	Prescribe.setDoctor_Name(rs.getString("Doctor_Name"));
	        	Prescribe.setDepartment(rs.getString("Department"));
	        	Prescribe.setDrug_Name(rs.getString("Drug_Name"));
		        list.add(Prescribe);
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
    public List<Prescribe> getByDoctor(String id){
    	Prescribe Prescribe=null;
        String sql="select *from Prescribe where Id='"+id+"'";
        ResultSet rs=dao.executeQuery(sql);
        List<Prescribe> list = new ArrayList<Prescribe>();
	    try {
	        while(rs.next()){
	        	Prescribe=new Prescribe();
	        	Prescribe.setPrescribe_Id(rs.getInt("Prescribe_Id"));
	        	Prescribe.setDrug_Id(rs.getInt("Drug_Id"));
	        	Prescribe.setPatient_Id(rs.getString("Patient_Id"));
	        	Prescribe.setId(rs.getString("Id"));
	        	Prescribe.setDoctor_Name(rs.getString("Doctor_Name"));
	        	Prescribe.setDepartment(rs.getString("Department"));
	        	Prescribe.setDrug_Name(rs.getString("Drug_Name"));
		        list.add(Prescribe);
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
    public List<Prescribe> getByDepartment(String department){
    	Prescribe Prescribe=null;
        String sql="select *from Prescribe where Department='"+department+"'";
        ResultSet rs=dao.executeQuery(sql);
        List<Prescribe> list = new ArrayList<Prescribe>();
	    try {
	        while(rs.next()){
	        	Prescribe=new Prescribe();
	        	Prescribe.setPrescribe_Id(rs.getInt("Prescribe_Id"));
	        	Prescribe.setDrug_Id(rs.getInt("Drug_Id"));
	        	Prescribe.setPatient_Id(rs.getString("Patient_Id"));
	        	Prescribe.setId(rs.getString("Id"));
	        	Prescribe.setDoctor_Name(rs.getString("Doctor_Name"));
	        	Prescribe.setDepartment(rs.getString("Department"));
	        	Prescribe.setDrug_Name(rs.getString("Drug_Name"));
		        list.add(Prescribe);
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
