package team.sqjj.hospital.DaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import team.sqjj.hospital.dao.DepartmentDao;
import team.sqjj.hospital.model.Department;

public class DepartmentDaoImpl implements DepartmentDao{
    private Dao dao=null;
    public DepartmentDaoImpl(Dao dao){
    	this.dao=dao;
    }
	@Override
	public int addDepartment(String department,String information,int room){
		int i=0;
		try{
			String sql="insert into Department values('"+department+"','"+information+"',"+room+")";
			i=dao.executeUpdate(sql);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		dao.close();
		return i;
	}
	@Override
	public int updateDepartment(String department,String information,int room){
		int i=0;
		try{
			String sql="update Department set Department='"+department+"',Information='"+information+"',Room="+room+" where Room="+room+"";
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
