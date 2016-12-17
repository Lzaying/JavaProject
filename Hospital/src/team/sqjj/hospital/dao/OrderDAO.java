package team.sqjj.hospital.dao;

import java.util.List;
import team.sqjj.hospital.model.Order;

public interface OrderDao {
public int addOrder(int drugId,String patientId,String id,String doctorName,String department,String drugName,int quantity,String unit,int price,String code,int isPaid);//ҵ�������Ҫ��ѯ����ȫ��ҩƷ��Ϣ���ڴ����
public int payOrder(String orderId);
public List<Order> getByPatientID (String patientId);
public List<Order> getByDoctor(String id);//��ҵ������ô˷�������ȡĳҽ���������� idΪҽ��id
public List<Order> getByDepartment(String department);//��ҵ������ô˷�������ȡĳ��������
}
