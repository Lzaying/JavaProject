package team.sqjj.hospital.dao;

import java.util.List;

import team.sqjj.hospital.model.Appointment;

public interface AppointmentDao {
public List<Appointment> GetById(String PatientId);//������ѡû�й�ʱ��

public void DelAppointment(Appointment a);//�Һ�֮�����ɾ������ԤԼ��¼

}
