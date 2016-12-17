package team.sqjj.hospital.dao;

public interface UserDao {
public void AddUser(String Id,String password,int role);
public void DelUser(String id);
public void UpdateUser(String id,String password,int role);
}
