package team.sqjj.hospital.dao;

import java.util.List;

import team.sqjj.hospital.model.Appointment;

public interface AppointmentDao {
	public int addAppointment(Appointment a);
    public List<Appointment> getById(String PatientId);//�˴�����ѯ�����ҵ�����Ҫɸѡ���ϵ�ǰԤԼʱ�ε�
    public int delAppointment(int appointmentId);//�Һ�֮�����ɾ������ԤԼ��¼
}
