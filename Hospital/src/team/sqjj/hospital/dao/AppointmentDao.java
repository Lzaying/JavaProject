package team.sqjj.hospital.dao;

import java.util.List;

import team.sqjj.hospital.model.Appointment;

public interface AppointmentDao {
public List<Appointment> GetById(String PatientId);//仅仅挑选没有过时的

public void DelAppointment(int appointmentid);//挂号之后可以删除这条预约记录

}
