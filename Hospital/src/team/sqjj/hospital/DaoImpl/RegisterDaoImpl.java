package team.sqjj.hospital.DaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import team.sqjj.hospital.dao.RegisterDao;
import team.sqjj.hospital.model.Appointment;
import team.sqjj.hospital.model.Prescription;
import team.sqjj.hospital.model.Register;

public class RegisterDaoImpl implements RegisterDao{
    private Dao dao=null;
    public 	RegisterDaoImpl(){
   dao=new Dao();   }

    
    @Override
	public int addRegister(Register register){
    	String patient_Id=register.getPatient_Id();
    	Date time=register.getTime();
    	int i=0;
		try{
			String sql="insert into Register values('"+patient_Id+"','"+register.getDoctor_Id()+"','"+time+"',"+register.getIsLooked()+")";
			i=dao.executeUpdate(sql);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		dao.close();
		return i;
	}
    @Override
	public List<Register> findByDoctor(String doctor_Id){
    	Register register=null;
        String sql="select *from Register where Doctor_Id='"+doctor_Id+"'";
        ResultSet rs=dao.executeQuery(sql);
        List<Register> list = new ArrayList<Register>();
	    try {
	        while(rs.next()){
	        	register=new Register();
	        	register.setRegister_Id(rs.getInt("Register_Id"));
	        	register.setPatient_Id(rs.getString("Patient_Id"));
	        	register.setId(rs.getString("Doctor_Id"));
	        	register.setTime(rs.getDate("Time"));
	        	register.setIsLooked(rs.getInt("IsLooked"));
				list.add(register);
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
	public List<Register> findByDepartment(String department){
    	Register register=null;
        String sql="select * from Register where Doctor_Id=(select Doctor_Id from Department where Department='"+department+"';)";
        ResultSet rs=dao.executeQuery(sql);
        List<Register> list = new ArrayList<Register>();
	    try {
	        while(rs.next()){
	        	register=new Register();
	        	register.setRegister_Id(rs.getInt("Register_Id"));
	        	register.setPatient_Id(rs.getString("Patient_Id"));
	        	register.setId(rs.getString("Doctor_Id"));
	        	register.setTime(rs.getDate("Time"));
	        	register.setIsLooked(rs.getInt("IsLooked"));
				list.add(register);
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
	public Register findById(int register_Id){
    	Register register=null;
        String sql="select *from Register where Register_Id="+register_Id+"";
        ResultSet rs=dao.executeQuery(sql);
	    try {
	        while(rs.next()){
	        	register=new Register();
	        	register.setRegister_Id(rs.getInt("Register_Id"));
	        	register.setPatient_Id(rs.getString("Patient_Id"));
	        	register.setId(rs.getString("Doctor_Id"));
	        	register.setTime(rs.getDate("Time"));
	        	register.setIsLooked(rs.getInt("IsLooked"));
	        }rs.close();
        } catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
        }	finally{
	        dao.close();
	        return register;
	        }
	}
    @Override
	public int registerLooked(int register_Id){
    	int i=0;
    	int j=1;
		try{
			String sql="update Register set IsLooked "+j+" where Register_Id ="+register_Id+"";
			i=dao.executeUpdate(sql);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		dao.close();
		return i;
	}


	@Override
	public int deRegisterCount(String department) {
		int count=0;
		try{
			String sql="select count(*) from Register where Doctor_Id=(select Doctor_Id from Doctor where Department_Id=(select Department_Id from Department where Department='"+department+"'))";
			ResultSet rs=dao.executeQuery(sql);
			if(rs.next())
			{
				count=rs.getInt(1);
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		dao.close();		
		return count;
	}
	


	@Override
	public int doRegisterCount(String doctor_Id) {
		int count=0;
		try{
			String sql="select count(*) from Register where Doctor_Id='"+doctor_Id+"'";
			ResultSet rs=dao.executeQuery(sql);
			if(rs.next())
			{
				count=rs.getInt(1);
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		dao.close();		
		return count;
	}
}
