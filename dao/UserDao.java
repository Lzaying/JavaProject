package team.sqjj.hospital.dao;

import java.util.List;
import team.sqjj.hospital.model.User;

public interface UserDao {
public int delUser(String id);
public User getById(String id);
public List<User> getByRole(int role);
public int addUser(User user);
int updateUser(User user);
}
