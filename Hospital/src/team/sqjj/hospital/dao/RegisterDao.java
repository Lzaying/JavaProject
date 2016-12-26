package team.sqjj.hospital.dao;

import java.util.Date;
import java.util.List;

import team.sqjj.hospital.model.Appointment;
import team.sqjj.hospital.model.Register;

public interface RegisterDao {
	public int addRegister(Register register);//-------------------------------------这里业务层中包含两部分，一部分是有效预约了的，先查询Appointment得到相应信息，接下来在此的操作同没预约过的 id为医生id
	public List<Register> findByDoctor(String doctor_Id);//-------------------------业务层算医生挂号量时用此方法对返回的List计数即可
	public List<Register> findByDepartment(String department);//-----------------业务层算科室挂号量时用此方法对返回的List计数即可
	public Register findById(int register_Id);
	public int registerLooked(int register_Id);
	public int deRegisterCount(String department);//根据科室查挂号数
	public int doRegisterCount(String doctor_Id);//根据医生查挂号数
}
