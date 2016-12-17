package team.sqjj.hospital.dao;

import java.util.Date;
import java.util.List;

import team.sqjj.hospital.model.Appointment;
import team.sqjj.hospital.model.Register;

public interface RegisterDao {
	public void AddRegister(Appointment a);
	public void AddRegister(String Patient_Id, String Department,int Doctor,Date time);
	public List<Register> FindByDoctor(int doctor);
	public List<Register> FindByDepartment(String department);//��û��������

	public Register FindeByID(int Registerid);
	public int GetAmountByDoctor(String doctorid);
	public int GetAmountByDepartment(String department);//�ܵĹҺ���
	public void RegisterLooked(int Register_Id);


}
