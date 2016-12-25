package team.sqjj.hospital.DaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import team.sqjj.hospital.dao.UserDao;
import team.sqjj.hospital.model.User;

public class UserDaoImpl implements UserDao{
    private Dao dao=null;
    public UserDaoImpl(){
        dao=new Dao();   }
    @Override
    public int addUser(User user){
    	int i=0;
		try{
			String sql="insert into Userinfo values('"+user.getId()+"','"+user.getPassword()+"',"+user.getRole()+")";
			i=dao.executeUpdate(sql);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		dao.close();
		return i;
    }
    @Override
    public int delUser(String User_Id){
    	int i=0;
  		try{
  			String sql="delete from Userinfo where User_Id='"+User_Id+"'";
 			i=dao.executeUpdate(sql);
 		}catch(Exception e){
 			e.printStackTrace();
 		}
 		dao.close();
 		return i;
    }
    @Override
    public int updateUser(User user){
    	int i=0;
  		try{
  			String sql="update Userinfo set 	User_Id="+user.getId()+",User_Password="+user.getPassword()+",Role="+user.getRole()+"";
			i=dao.executeUpdate(sql);
 		}catch(Exception e){
 			e.printStackTrace();
 		}
 		dao.close();
 		return i;
    }
    @Override
    public User getById(String user_Id){
    	User user=null;
		String sql = "select *  from Userinfo where User_Id='"+user_Id+"'";
		ResultSet rs = dao.executeQuery(sql);
		try {
			while (rs.next()) {
				user=new User();
				user.setId(rs.getString("User_Id"));
				user.setPassword(rs.getString("Password"));
				user.setRole(rs.getInt("Role"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dao.close();
		return user;
    }
    @Override
    public List<User> getByRole(int role){
    	User user=null;;
		String sql = "select *  from Userinfo where Role="+role+"";
		ResultSet rs = dao.executeQuery(sql);
		List<User> list = new ArrayList<User>();
		try {
			while (rs.next()) {
				user=new User();
				user.setId(rs.getString("User_Id"));
				user.setPassword(rs.getString("Password"));
				user.setRole(rs.getInt("Role"));
				list.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Dao.close();
		return list;
    }
}
