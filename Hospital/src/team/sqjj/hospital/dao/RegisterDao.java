package team.sqjj.hospital.dao;

import java.util.Date;
import java.util.List;

import team.sqjj.hospital.model.Appointment;
import team.sqjj.hospital.model.Register;

public interface RegisterDao {
	public int addRegister(Register register);//����ҵ����а��������֣�һ��������ЧԤԼ�˵ģ��Ȳ�ѯAppointment�õ���Ӧ��Ϣ���������ڴ˵Ĳ���ͬûԤԼ���� idΪҽ��id
	public List<Register> findByDoctor(String doctor_Id);//ҵ�����ҽ���Һ���ʱ�ô˷����Է��ص�List��������
	public List<Register> findByDepartment(String department);//ҵ�������ҹҺ���ʱ�ô˷����Է��ص�List��������
	public Register findById(int register_Id);
	public int registerLooked(int register_Id);
}
