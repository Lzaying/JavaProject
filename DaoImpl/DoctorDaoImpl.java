package team.sqjj.hospital.DaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import team.sqjj.hospital.dao.DoctorDao;
import team.sqjj.hospital.model.Doctor;

public class DoctorDaoImpl implements DoctorDao{
    private Dao dao=null;
    public 	DoctorDaoImpl(){
    	dao=new Dao();
    }
    @Override
    public List<Doctor> getByDepartment_Id(int department_Id){
    	Doctor doctor=null;
        String sql="select * from Doctor where Department_Id="+department_Id+"";
        ResultSet rs=dao.executeQuery(sql);
        List<Doctor> list = new ArrayList<Doctor>();
	    try {
	        while(rs.next()){
		        doctor=new Doctor();
		        doctor.setDoctor_Id(rs.getString("Doctor_Id"));
		        doctor.setName(rs.getString("Name"));
		        doctor.setDepartment_Id(rs.getInt("Department_Id"));
		        list.add(doctor);
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
    public int addDoctor(Doctor doctor){
    	int i=0;
		try{
			String sql="insert into Doctor values('"+doctor.getDoctor_Id()+"','"+doctor.getName()+"',"+doctor.getDepartment_Id()+")";
			i=dao.executeUpdate(sql);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		dao.close();
		return i;
    }
    @Override
    public int updateDoctor(Doctor doctor){
    	int i=0;
		try{
			String sql="update Doctor set Doctor_Id='"+doctor.getDoctor_Id()+"',Name='"+doctor.getName()+"',Department_Id="+doctor.getDepartment_Id()+"";
			i=dao.executeUpdate(sql);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		dao.close();
		return i;
    }
    @Override
    public int delDoctor(String Doctor_Id){
    	int i=0;
  		try{
  			String sql="delete from doctor where Doctor_Id='"+Doctor_Id+"'";
 			i=dao.executeUpdate(sql);
 		}catch(Exception e){
 			e.printStackTrace();
 		}
 		dao.close();
 		return i;
    }
	@Override
	public List<Doctor> getByDoctor_Id(String doctor_Id) {
		Doctor doctor=null;
        String sql="select * from Doctor where Doctor_Id='"+doctor_Id+"'";
        ResultSet rs=dao.executeQuery(sql);
        List<Doctor> list = new ArrayList<Doctor>();
	    try {
	        while(rs.next()){
		        doctor=new Doctor();
		        doctor.setDoctor_Id(rs.getString("Doctor_Id"));
		        doctor.setName(rs.getString("Name"));
		        doctor.setDepartment_Id(rs.getInt("Department_Id"));
		        list.add(doctor);
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
    public List<Doctor> getByDepartment(String department){
    	Doctor doctor=null;
        String sql="select * from Doctor where Department='"+department+"'";
        ResultSet rs=dao.executeQuery(sql);
        List<Doctor> list = new ArrayList<Doctor>();
	    try {
	        while(rs.next()){
		        doctor=new Doctor();
		        doctor.setDoctor_Id(rs.getString("Doctor_Id"));
		        doctor.setName(rs.getString("Name"));
		        doctor.setDepartment_Id(rs.getInt("Department_Id"));
		        list.add(doctor);
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
