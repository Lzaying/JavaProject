package team.sqjj.hospital.DaoFactory;

public class OrderDaoFactory {
	public static OrderDao getInstance(){
		return new OrderDaoImpl();
		
	}
}
