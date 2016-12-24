package team.sqjj.hospital.DaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import team.sqjj.hospital.dao.DepartmentDao;
import team.sqjj.hospital.model.Department;

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
}
