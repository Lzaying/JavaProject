package team.sqjj.hospital.DaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import team.sqjj.hospital.dao.AppointmentDao;

import team.sqjj.hospital.model.Appointment;

public class AppointmentDaoImpl implements AppointmentDao{
	private Dao dao=null;
    public AppointmentDaoImpl(){dao=new Dao();}    
    @Override
    public List<Appointment> getById(String PatientId) {
	    // TODO Auto-generated method stub
	    Appointment appointment=null;
        String sql="select *from Appointment where Appointment_Id="+PatientId+"";
        ResultSet rs=dao.executeQuery(sql);
        List<Appointment> list = new ArrayList<Appointment>();
	    try {
	        while(rs.next()){
		        appointment=new Appointment();
		        appointment.setAppointment_Id(rs.getString("Appointment_Id"));
		        appointment.setPatient_Id(rs.getString("Patient_Id"));
		        appointment.setTime(rs.getDate("Time"));
		        appointment.setDepartment(rs.getString("Department"));
		        list.add(appointment);
	        }rs.close();
        } catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
        }	finally{
	        dao.close();
	        return list;
	        }
    }
    @Override
    public int delAppointment(int appointmentId) {
	    // TODO Auto-generated method stub
	    int i=0;
		    try{
			    String sql="delete from Appointment where Appointment_Id="+appointmentId+"";
			    i=dao.executeUpdate(sql);
		    }catch(Exception e){
			    e.printStackTrace();
		    }
		    dao.close();
		    return i;
    }
}
