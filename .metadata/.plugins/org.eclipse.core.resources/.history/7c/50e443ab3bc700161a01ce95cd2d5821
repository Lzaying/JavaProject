package team.sqjj.hospital.DaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import team.sqjj.hospital.dao.DrugDao;
import team.sqjj.hospital.model.Drug;
import team.sqjj.hospital.model.Patient;

public class DrugDaoImpl implements DrugDao{
    private Dao dao=null;
    public 	DrugDaoImpl(){
    	dao=new Dao();   }
    @Override
    public int addDrug(String drugId,String drugName,double price,String unit,int amount){
    	int i=0;
		try{
			String sql="insert into Drug values("+drugId+",'"+drugName+"',"+price+",'"+unit+"',"+amount+")";
			i=dao.executeUpdate(sql);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		dao.close();
		return i;
    }
    @Override
    public int updateDrug(String drugId,String drugName,double price,String unit,int amount){
    	int i=0;
		try{
			String sql="update Drug set Drug_Id="+drugId+",Drug_Name='"+drugName+"',Price="+price+",Unit='"+unit+"' ,Amount="+amount+" where Drug_Id="+drugId+"";
			i=dao.executeUpdate(sql);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		dao.close();
		return i;
    }
    @Override
    public int delDrug(String drugId){
    	int i=0;
  		try{
  			String sql="delete from Drug where Drug_Id="+drugId+"";
 			i=dao.executeUpdate(sql);
 		}catch(Exception e){
 			e.printStackTrace();
 		}
 		dao.close();
 		return i;
    }
    @Override
    public Drug findByID(String drugId){
    	Drug drug=null;	
        String sql="select *from Drug where Drug_Id="+drugId+"";
        ResultSet rs=dao.executeQuery(sql);
        try {
	        while(rs.next()){
		        drug=new Drug();
		        drug.setDrug_Id(rs.getInt("Drug_Id"));
		        drug.setDrug_Name(rs.getString("Drug_Name"));
		        drug.setUnit(rs.getString("Unit"));
		        drug.setAmout(rs.getInt("Amout"));
		        drug.setPrice(rs.getDouble("Price"));
	        }rs.close();
        } catch (SQLException e) {
	    // TODO Auto-generated catch block
    	         e.printStackTrace();
        }finally{
	       dao.close();
	       return drug;
        }
    }
}
