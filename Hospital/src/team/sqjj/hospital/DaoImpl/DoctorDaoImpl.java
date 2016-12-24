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
    public List<Doctor> getByDepartment(String department){
    	Doctor doctor=null;
        String sql="select *from Doctor where Department="+department+"";
        ResultSet rs=dao.executeQuery(sql);
        List<Doctor> list = new ArrayList<Doctor>();
	    try {
	        while(rs.next()){
		        doctor=new Doctor();
		        doctor.setId(rs.getString("Id"));
		        doctor.setName(rs.getString("Name"));
		        doctor.setDepartment(rs.getString("Department"));
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
			String sql="insert into Doctor values('"+doctor.getId()+"','"+doctor.getName()+"','"+doctor.getDepartment()+"')";
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
			String sql="update Doctor set Id='"+doctor.getId()+"',Name='"+doctor.getName()+"',Department='"+doctor.getDepartment()+"'";
			i=dao.executeUpdate(sql);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		dao.close();
		return i;
    }
    @Override
    public int delDoctor(String id){
    	int i=0;
  		try{
  			String sql="delete from doctor where Id='"+id+"'";
 			i=dao.executeUpdate(sql);
 		}catch(Exception e){
 			e.printStackTrace();
 		}
 		dao.close();
 		return i;
    }
}
