package team.sqjj.hospital.dao;

import java.util.List;

import team.sqjj.hospital.model.Order;

public interface OrderDAO {
public void AddOrder(String patientid,String doctorid,String department,String drugid,int quantity);

public void PayOrder(String orderid);
public List<Order> GetByPatientID (String patientid);
public double GetMoneyByDoctor(String doctorid);
public double GetMoneyByDepartment(String department);



}
