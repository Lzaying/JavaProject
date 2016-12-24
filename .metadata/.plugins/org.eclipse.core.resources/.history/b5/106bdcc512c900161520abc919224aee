package team.sqjj.hospital.DaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import team.sqjj.hospital.dao.UserDao;
import team.sqjj.hospital.model.User;

public class UserDaoImpl implements UserDao{
    private Dao dao=null;
    public 	UserDaoImpl(){
    	
        dao=new Dao();   }
    @Override
    public int addUser(String id,String password,int role,String name){
    	int i=0;
		try{
			String sql="insert into User values('"+id+"','"+password+"',"+role+",'"+name+"')";
			i=dao.executeUpdate(sql);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		dao.close();
		return i;
    }
    @Override
    public int delUser(String id){
    	int i=0;
  		try{
  			String sql="delete from User where Id='"+id+"'";
 			i=dao.executeUpdate(sql);
 		}catch(Exception e){
 			e.printStackTrace();
 		}
 		dao.close();
 		return i;
    }
    @Override
    public int updateUser(String id,String password,int role,String name){
    	int i=0;
  		try{
  			String sql="delete from User where Id='"+id+"'";
 			i=dao.executeUpdate(sql);
 		}catch(Exception e){
 			e.printStackTrace();
 		}
 		dao.close();
 		return i;
    }
    @Override
    public User getById(String id){
    	User user=new User();
		String sql = "select *  from User where Id='"+id+"'";
		ResultSet rs = dao.executeQuery(sql);
		try {
			while (rs.next()) {
				user.setId(rs.getString("Id"));
				user.setPassword(rs.getString("Password"));
				user.setRole(rs.getInt("Role"));
				user.setName(rs.getString("Name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dao.close();
		return user;
    }
    @Override
    public List<User> getByRole(int role){
    	User user=new User();
		String sql = "select *  from User where Role="+role+"";
		ResultSet rs = dao.executeQuery(sql);
		List<User> list = null;
		try {
			while (rs.next()) {
				user.setId(rs.getString("Id"));
				user.setPassword(rs.getString("Password"));
				user.setRole(rs.getInt("Role"));
				user.setName(rs.getString("Name"));
				list.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Dao.close();
		return list;
    }
    @Override
    public List<User> getByName(String name){
    	User user=new User();
		String sql = "select *  from User where Name='"+name+"'";
		ResultSet rs = dao.executeQuery(sql);
		List<User> list = null;
		try {
			while (rs.next()) {
				user.setId(rs.getString("Id"));
				user.setPassword(rs.getString("Password"));
				user.setRole(rs.getInt("Role"));
				user.setName(rs.getString("Name"));
				list.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Dao.close();
		return list;
    }
}
