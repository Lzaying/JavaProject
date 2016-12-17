package team.sqjj.hospital.dao;

import java.util.List;
import team.sqjj.hospital.model.User;

public interface UserDao {
public int addUser(String id,String password,int role,String name);
public int delUser(String id);
public int updateUser(String id,String password,int role,String name);
public User getById(String id);
public List<User> getByRole(int role);
public List<User> getByName(String name);
}
