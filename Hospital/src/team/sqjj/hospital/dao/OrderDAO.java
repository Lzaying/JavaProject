package team.sqjj.hospital.dao;

import java.util.List;
import team.sqjj.hospital.model.Order;

public interface OrderDao {
public int addOrder(int drugId,String patientId,String id,String doctorName,String department,String drugName,int quantity,String unit,int price,String code,int isPaid);//业务层中先要查询出完全的药品信息，在此添加
public int payOrder(String orderId);
public List<Order> getByPatientID (String patientId);
public List<Order> getByDoctor(String id);//在业务层中用此方法来获取某医生处的收入 id为医生id
public List<Order> getByDepartment(String department);//在业务层中用此方法来获取某处的收入
}
