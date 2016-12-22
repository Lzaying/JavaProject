package team.sqjj.hospital.DaoFactory;

import team.sqjj.hospital.DaoImpl.OrderDaoImpl;
import team.sqjj.hospital.dao.OrderDao;

public class OrderDaoFactory {
	public static OrderDao getInstance(){
		return new OrderDaoImpl();
		
	}
}
