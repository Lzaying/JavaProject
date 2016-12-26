package team.sqjj.hospital.DaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import team.sqjj.hospital.dao.DepartmentDao;
import team.sqjj.hospital.model.Department;
import team.sqjj.hospital.model.Doctor;

public class DepartmentDaoImpl implements DepartmentDao{
    private Dao dao=null;
    public DepartmentDaoImpl(){
    	dao=new Dao();
    }
	@Override
	public int addDepartment(Department department){
		int i=0;
		try{
			String sql="insert into Department values('"+department.getDepartment()+"','"+department.getInformation()+"',"+department.getRoom()+")";
			i=dao.executeUpdate(sql);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		dao.close();
		return i;
	}
	@Override
	public int updateDepartment(Department department){
		int i=0;
		try{
			String sql="update Department set Department='"+department.getDepartment()+"',Information='"+department.getInformation()+"',Room="+department.getRoom()+" where Room="+department.getRoom()+"";
			i=dao.executeUpdate(sql);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		dao.close();
		return i;
	}
	@Override
	public int delDepartment(String department){
		int i=0;
  		try{
  			String sql="delete from Department  where Department='"+department+"'";
 			i=Dao.executeUpdate(sql);
 		}catch(Exception e){
 			e.printStackTrace();
 		}
 		Dao.close();
 		return i;
	}
	@Override
	public List<Department> getDepartment() {
		// TODO Auto-generated method stub
		Department department=null;
        String sql="select * from Department ";
        ResultSet rs=dao.executeQuery(sql);
        List<Department> list = new ArrayList<Department>();
	    try {
	        while(rs.next()){
		        department=new Department();
		        department.setDepartment_Id(rs.getInt("Department_Id"));
		        department.setDepartment(rs.getString("Department"));
		        department.setInformation(rs.getString("Information"));
		        department.setRoom(rs.getInt("Room"));
		        list.add(department);
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
	public int dAppointmentCount(String department) {
		// TODO Auto-generated method stub
		int count=0;
		try{
			String sql="select count(*) from Appointment where Doctor_Id=(select Doctor_Id from Doctor where Department_Id=(select Department_Id from Department where Department='"+department+"'))";
			ResultSet rs=dao.executeQuery(sql);
			if(rs.next())
			{
				count=rs.getInt(1);
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		dao.close();		
		return count;
	}
	@Override
	public int getDepartment_Id(String department) {
		// TODO Auto-generated method stub
		int did=0;
		try{
			String sql="select Department_Id from Department where  Department='"+department+"'";
			ResultSet rs=dao.executeQuery(sql);
			if(rs.next())
			{
				did=rs.getInt(1);
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		dao.close();		
		return did;
	}
}
