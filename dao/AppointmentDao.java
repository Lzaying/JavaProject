package team.sqjj.hospital.dao;

import java.util.List;

import team.sqjj.hospital.model.Appointment;

public interface AppointmentDao {
	public int addAppointment(Appointment a);
    public List<Appointment> getById(String PatientId);//此处仅查询结果，业务层中要筛选符合当前预约时段的
    public int delAppointment(int appointmentId);//挂号之后可以删除这条预约记录
}
