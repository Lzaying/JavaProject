package team.sjqq.hospital.dao;
import java.awt.List;
import java.sql.*;
import java.util.*;

public class Dao {
	protected static String dbClassName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	protected static String dbUrl = "jdbc:sqlserver://localhost:1433;"
			+ "DatabaseName=Hospital;SelectMethod=Cursor";
	protected static String dbUser = "sa";
	protected static String second = null;
	private static Connection conn = null;
	protected static String dbPwd = "";
	
	private Dao() {
		try {
			if (conn == null) {
				Class.forName(dbClassName).newInstance();
				conn = DriverManager.getConnection(dbUrl, dbUser, dbPwd);
			}
			else
				return;
		} catch (Exception ee) {
			ee.printStackTrace();
		}
	}
	
	private static ResultSet executeQuery(String sql) {
		try {
			if(conn==null)
			new Dao();
			return conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE).executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
		}
	}
	
    private static int executeUpdate(String sql) {
		
		try {
			if(conn==null)
				new Dao();
			return conn.createStatement().executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return -1;
		} finally {
		}
	}
	
    public static void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			conn = null;
		}
	}
	
    //医生登陆的方法
    public static Doctor doctorCheck(String id, String password) {
		int i = 0;
		Doctor doctor=new Doctor();
		String sql = "select * from User where Id='" + id
				+ "' and password='" + password + "'and role=1";
		ResultSet rs = Dao.executeQuery(sql);
		try {
			while (rs.next()) {
				String names = rs.getString(1);
				doctor.setId(rs.getString("Id"));
				doctor.setName(rs.getString("Name"));
				doctor.setGrade(rs.getInt("Role"));
				doctor.setPassword(rs.getString("Password"));
				if (names != null) {
					i = 1;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Dao.close();
		return doctor;	
	}
	
    //收费人员登陆
    public static Cashier  cashierCheck(String id, String password) {
		int i = 0;
		Cashier cashier=new Cashier();
		String sql = "select * from User where Id='" + id
				+ "' and password='" + password + "'and role=2";
		ResultSet rs = Dao.executeQuery(sql);
		try {
			while (rs.next()) {
				String names = rs.getString(1);
				cashier.setId(rs.getString("Id"));
				cashier.setName(rs.getString("Name"));
				cashier.setRole(rs.getInt("Role"));
				cashier.setPassword(rs.getString("Password"));
				if (names != null) {
					i = 1;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Dao.close();
		return cashier;	
	}
	
    //药师登陆方法
    public static Pharmacist  pharmacistCheck(String id, String password) {
		int i = 0;
		Pharmacist pharmacist=new Pharmacist();
		String sql = "select * from User where Id='" + id
				+ "' and password='" + password + "'and role=3";
		ResultSet rs = Dao.executeQuery(sql);
		try {
			while (rs.next()) {
				String names = rs.getString(1);
				pharmacist.setId(rs.getString("Id"));
				pharmacist.setName(rs.getString("Name"));
				pharmacist.setRole(rs.getInt("Role"));
				pharmacist.setPassword(rs.getString("Password"));
				if (names != null) {
					i = 1;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Dao.close();
		return pharmacist;	
	}
	
    //院长登陆方法
    public static Dean  deanCheck(String id, String password) {
		int i = 0;
		Dean dean=new Dean();
		String sql = "select * from User where Id='" + id
				+ "' and password='" + password + "'and role=4";
		ResultSet rs = Dao.executeQuery(sql);
		try {
			while (rs.next()) {
				String names = rs.getString(1);
				dean.setId(rs.getString("Id"));
				dean.setName(rs.getString("Name"));
				dean.setRole(rs.getInt("Role"));
				dean.setPassword(rs.getString("Password"));
				if (names != null) {
					i = 1;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Dao.close();
		return dean;	
	}
    
    //管理员登陆方法
    public static Admin  adminCheck(String id, String password) {
		int i = 0;
		Admin admin=new Admin();
		String sql = "select * from User where Id='" + id
				+ "' and password='" + password + "'and role=0";
		ResultSet rs = Dao.executeQuery(sql);
		try {
			while (rs.next()) {
				String names = rs.getString(1);
				admin.setId(rs.getString("Id"));
				admin.setName(rs.getString("Name"));
				admin.setRole(rs.getInt("Role"));
				admin.setPassword(rs.getString("Password"));
				if (names != null) {
					i = 1;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Dao.close();
		return admin;	
	}

//对Drug表的操作
    //查询所有药品的信息
    public static ArrayList selectDrugInfo() {
		ArrayList list=new ArrayList();
		String sql = "select * from Drug";
		ResultSet rs = Dao.executeQuery(sql);
		try {
			while (rs.next()) {
				DrugInfo drugInfo=new DrugInfo();
				drugInfo.setDrugId(rs.getInt("Drug_Id"));
				drugInfo.setDrugName(rs.getString("Drug_Name"));
				drugInfo.setUnit(rs.getString("Unit"));
				drugInfo.setAmout(rs.getInt("Amout"));
				drugInfo.setPrice(rs.getDouble("Price"));
				list.add(drugInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Dao.close();
		return list;
	}
    
    //按药品编号查询某种药的信息
    public static ArrayList selectDrugInfo(String drugId) {
		ArrayList list=new ArrayList();
		String sql = "select *  from Drug where Drug_Id="+drugId+"";
		ResultSet rs = Dao.executeQuery(sql);
		try {
			while (rs.next()) {
				DrugInfo drugInfo=new DrugInfo();
				drugInfo.setDrugId(rs.getInt("Drug_Id"));
				drugInfo.setDrugName(rs.getString("Drug_Name"));
				drugInfo.setUnit(rs.getString("Unit"));
				drugInfo.setAmout(rs.getInt("Amout"));
				drugInfo.setPrice(rs.getDouble("Price"));
				list.add(drugInfo);
				list.add(drugInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Dao.close();
		return list;
	}
    
    //增加某种药品
    public static int insertDrug(int drugId,String drugName,double price,String unit,int amout){
		int i=0;
		try{
			String sql="insert into Drug values("+drugId+",'"+drugName+"',"+price+",'"+unit+"',"+amout+")";
			i=Dao.executeUpdate(sql);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		Dao.close();
		return i;
	}
    
    //更新药品信息
    public static int updateDrug(int drugId,String drugName,double price,String unit,int amount){
		int i=0;
		try{
			String sql="update Drug set Drug_Id="+drugId+",Drug_Name='"+drugName+"',Price="+price+",Unit='"+unit+"' ,Amount="+amount+" where Drug_Id="+drugId+"";
			i=Dao.executeUpdate(sql);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		Dao.close();
		return i;
	}
   
    //药品售出，数量-1
    public static int outDrug(int drugId){
		int i=0;
		String sql1 = "select *  from Drug where Drug_Id="+drugId+"";
		ResultSet rs = Dao.executeQuery(sql1);
		try{
			int newAmount = rs.getInt("Drug_Id");
			String sql2="update Drug  set Amount="+newAmount+" where Drug_Id="+drugId+"";
			i=Dao.executeUpdate(sql2);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		Dao.close();
		return i;
	}
    
    //删除某种药
    public static int delDrug(int drugId){
   		int i=0;
  		try{
  			String sql="delete from Drug where Drug_Id="+drugId+"";
 			i=Dao.executeUpdate(sql);
 		}catch(Exception e){
 			e.printStackTrace();
 		}
 		Dao.close();
 		return i;
 	}
	
    
//对Appointment表的操作
    public static ArrayList selectAppointInfo(String patientName) {
		ArrayList list=new ArrayList();
		String sql = "select *  from Appointment where Patient_Name='"+patientName+"'";
		ResultSet rs = Dao.executeQuery(sql);
		try {
			while (rs.next()) {
				AppointInfo appointInfo=new AppointInfo();
				appointInfo.setAppointmentId(rs.getInt("Appointment_Id"));
				appointInfo.setPatientName(rs.getString("Patient_Name"));
				appointInfo.setTime(rs.getDate("Time"));
				appointInfo.setDepartment(rs.getDouble("Department"));
				list.add(appointInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Dao.close();
		return list;
	}
    
//对User表的操作
    //查询所有用户的信息
    public static ArrayList selectUserInfo() {
		ArrayList list=new ArrayList();
		String sql = "select *  from User ";
		ResultSet rs = Dao.executeQuery(sql);
		try {
			while (rs.next()) {
				UserInfo userInfo=new UserInfo();
				userInfo.setId(rs.getString("Id"));
				userInfo.setPassword(rs.getString("Password"));
				userInfo.setRole(rs.getInt("Role"));
				userInfo.setName(rs.getString("Name"));
				list.add(userInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Dao.close();
		return list;
	}
    
    //按用户Id查询某一账号信息
    public static ArrayList selectUserInfo(String id) {
		ArrayList list=new ArrayList();
		String sql = "select *  from User where Id='"+id+"'";
		ResultSet rs = Dao.executeQuery(sql);
		try {
			while (rs.next()) {
				UserInfo userInfo=new UserInfo();
				userInfo.setId(rs.getString("Id"));
				userInfo.setPassword(rs.getString("Password"));
				userInfo.setRole(rs.getInt("Role"));
				userInfo.setName(rs.getString("Name"));
				list.add(userInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Dao.close();
		return list;
	}
    
    //按用户Id更新某一账号信息
    public static int updateUser(String id,String password,int role,String name){
		int i=0;
		try{
			String sql="update User set Id='"+id+"',Password='"+password+"',Role="+role+",Name='"+name+"' where Id='"+id+"'";
			i=Dao.executeUpdate(sql);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		Dao.close();
		return i;
	}
    
    //新增用户
    public static int insertUser(String id,String password,int role,String name){
    	int i=0;
		try{
			String sql="insert into User values('"+id+"','"+password+"',"+role+",'"+name+"')";
			i=Dao.executeUpdate(sql);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		Dao.close();
		return i;
    }
    
    //删除用户
    public static int delUser(int id){
   		int i=0;
  		try{
  			String sql="delete from User where Id='"+id+"'";
 			i=Dao.executeUpdate(sql);
 		}catch(Exception e){
 			e.printStackTrace();
 		}
 		Dao.close();
 		return i;
 	}
    
//对Department表的操作
    //查询所有科室信息
    public static ArrayList selectDepartInfo() {
		ArrayList list=new ArrayList();
		String sql = "select *  from Department ";
		ResultSet rs = Dao.executeQuery(sql);
		try {
			while (rs.next()) {
				DepartInfo departInfo=new DepartInfo();
				departInfo.setDepartment(rs.getString("Department"));
				departInfo.setInformation(rs.getString("Information"));
				departInfo.setRoom(rs.getInt("Room"));
				list.add(departInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Dao.close();
		return list;
	}
    
    //通过科室名查询某一科室的信息
    public static ArrayList selectDepartInfo(String department) {
		ArrayList list=new ArrayList();
		String sql = "select *  from Department where Department='"+department+"'";
		ResultSet rs = Dao.executeQuery(sql);
		try {
			while (rs.next()) {
				DepartInfo departInfo=new DepartInfo();
				departInfo.setDepartment(rs.getString("Department"));
				departInfo.setInformation(rs.getString("Information"));
				departInfo.setRoom(rs.getInt("Room"));
				list.add(departInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Dao.close();
		return list;
	}
    
    //通过房间号查询某一科室的信息
    public static ArrayList selectDepartInfo(int room) {
		ArrayList list=new ArrayList();
		String sql = "select *  from Department where Room='"+room+"'";
		ResultSet rs = Dao.executeQuery(sql);
		try {
			while (rs.next()) {
				DepartInfo departInfo=new DepartInfo();
				departInfo.setDepartment(rs.getString("Department"));
				departInfo.setInformation(rs.getString("Information"));
				departInfo.setRoom(rs.getInt("Room"));
				list.add(departInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Dao.close();
		return list;
	}
    
    //更新某科室信息(按科室名)
    public static int updateDepartInfoD(String department,String information,int room) {
    	int i=0;
		try{
			String sql="update Department set Department='"+department+"',Information='"+information+"',Room="+room+" where Deparment='"+department+"'";
			i=Dao.executeUpdate(sql);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		Dao.close();
		return i;
	}
    
  //更新某科室信息(按房间号)
    public static int updateDepartInfoR(String department,String information,int room) {
    	int i=0;
		try{
			String sql="update Department set Department='"+department+"',Information='"+information+"',Room="+room+" where Room="+room+"";
			i=Dao.executeUpdate(sql);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		Dao.close();
		return i;
	}
    
    //增加科室
    public static int insertDepartInfo(String department,String information,int room) {
    	int i=0;
		try{
			String sql="insert into Department values('"+department+"','"+information+"',"+room+")";
			i=Dao.executeUpdate(sql);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		Dao.close();
		return i;
	}
    
    //删除科室
    public static int delDepartment(String department){
   		int i=0;
  		try{
  			String sql="delete from Department  where Department='"+department+"'";
 			i=Dao.executeUpdate(sql);
 		}catch(Exception e){
 			e.printStackTrace();
 		}
 		Dao.close();
 		return i;
 	}
    
//对Register表的操作
    //查询挂号信息
    public static ArrayList selectRegisterInfo() {
		ArrayList list=new ArrayList();
		String sql = "select *  from RegisterInfo ";
		ResultSet rs = Dao.executeQuery(sql);
		try {
			while (rs.next()) {
				RegisterInfo registerInfo=new RegisterInfo();
				registerInfo.setRegisterId(rs.getInt("Register_Id"));
				registerInfo.setPatientId(rs.getString("Patient_Id"));
				registerInfo.setDepartment(rs.getString("Department"));
				registerInfo.setDoctor(rs.getString("Doctor"));
				registerInfo.setTime(rs.getDate("Time"));
				registerInfo.setIsLooked(rs.getInt("IsLooked"));
				list.add(registerInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Dao.close();
		return list;
	}
    
    //按病人Id查询挂号信息
    public static ArrayList selectRegisterInfoP(int patientId) {
		ArrayList list=new ArrayList();
		String sql = "select *  from RegisterInfo where Patient_Id="+patientId+"";
		ResultSet rs = Dao.executeQuery(sql);
		try {
			while (rs.next()) {
				RegisterInfo registerInfo=new RegisterInfo();
				registerInfo.setRegisterId(rs.getInt("Register_Id"));
				registerInfo.setPatientId(rs.getString("Patient_Id"));
				registerInfo.setDepartment(rs.getString("Department"));
				registerInfo.setDoctor(rs.getString("Doctor"));
				registerInfo.setTime(rs.getDate("Time"));
				registerInfo.setIsLooked(rs.getInt("IsLooked"));
				list.add(registerInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Dao.close();
		return list;
	}
    
    //按医生查询挂号信息
    public static ArrayList selectRegisterInfoDo(String doctor) {
		ArrayList list=new ArrayList();
		String sql = "select *  from RegisterInfo where Doctor='"+doctor+"'";
		ResultSet rs = Dao.executeQuery(sql);
		try {
			while (rs.next()) {
				RegisterInfo registerInfo=new RegisterInfo();
				registerInfo.setRegisterId(rs.getInt("Register_Id"));
				registerInfo.setPatientId(rs.getString("Patient_Id"));
				registerInfo.setDepartment(rs.getString("Department"));
				registerInfo.setDoctor(rs.getString("Doctor"));
				registerInfo.setTime(rs.getDate("Time"));
				registerInfo.setIsLooked(rs.getInt("IsLooked"));
				list.add(registerInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Dao.close();
		return list;
	}
    
    //按科室查询挂号信息
    public static ArrayList selectRegisterInfoDe(String department) {
		ArrayList list=new ArrayList();
		String sql = "select *  from RegisterInfo where Department='"+department+"'";
		ResultSet rs = Dao.executeQuery(sql);
		try {
			while (rs.next()) {
				RegisterInfo registerInfo=new RegisterInfo();
				registerInfo.setRegisterId(rs.getInt("Register_Id"));
				registerInfo.setPatientId(rs.getString("Patient_Id"));
				registerInfo.setDepartment(rs.getString("Department"));
				registerInfo.setDoctor(rs.getString("Doctor"));
				registerInfo.setTime(rs.getDate("Time"));
				registerInfo.setIsLooked(rs.getInt("IsLooked"));
				list.add(registerInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Dao.close();
		return list;
	}
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
