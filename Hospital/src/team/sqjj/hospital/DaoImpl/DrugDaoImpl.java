package team.sqjj.hospital.DaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import team.sqjj.hospital.dao.DrugDao;
import team.sqjj.hospital.model.Doctor;
import team.sqjj.hospital.model.Drug;
import team.sqjj.hospital.model.Patient;

public class DrugDaoImpl implements DrugDao{
    private Dao dao=null;
    public 	DrugDaoImpl(){
    	dao=new Dao();   }
    @Override
    public int addDrug(Drug drug){
    	int i=0;
		try{
			String sql="insert into Drug values('"+drug.getDrug_Name()+"',"+drug.getPrice()+",'"+drug.getUnit()+"',"+drug.getAmount()+"'"+drug.getCode()+"')";
			i=dao.executeUpdate(sql);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		dao.close();
		return i;
    }
    @Override
    public int updateDrug(Drug drug){
    	int i=0;
		try{
			String sql="update Drug set Drug_Id="+drug.getDrug_Id()+",Drug_Name='"+drug.getDrug_Name()+"',Price="+drug.getPrice()+",Unit='"+drug.getUnit()+"' ,Amount="+drug.getAmount()+" where Drug_Id="+drug.getDrug_Id()+"";
			i=dao.executeUpdate(sql);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		dao.close();
		return i;
    }
    @Override
    public int delDrug(int drug_Id){
    	int i=0;
  		try{
  			String sql="delete from Drug where Drug_Id="+drug_Id+"";
 			i=dao.executeUpdate(sql);
 		}catch(Exception e){
 			e.printStackTrace();
 		}
 		dao.close();
 		return i;
    }
    @Override
    public Drug findByID(int  drug_Id){
    	Drug drug=null;	
        String sql="select * from Drug where Drug_Id="+drug_Id+"";
        ResultSet rs=dao.executeQuery(sql);
        try {
	        while(rs.next()){
		        drug=new Drug();
		        drug.setDrug_Id(rs.getInt("Drug_Id"));
		        drug.setDrug_Name(rs.getString("Drug_Name"));
		        drug.setUnit(rs.getString("Unit"));
		        drug.setAmount(rs.getInt("Amount"));
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
	@Override
	public List<Drug> getByname(String name) {
		// TODO Auto-generated method stub
		Drug drug=null;
        String sql="select * from Drug where Drug_Name="+name+"";
        ResultSet rs=dao.executeQuery(sql);
        List<Drug> list = new ArrayList<Drug>();
	    try {
	        while(rs.next()){
		        drug=new Drug();
		        drug.setDrug_Id(rs.getInt("Drug_Id"));
		        drug.setDrug_Name(rs.getString("Drug_Name"));
		        drug.setPrice(rs.getDouble("Price"));
		        drug.setUnit(rs.getString("Unit"));
		        drug.setAmount(rs.getInt("Amount"));
		        drug.setCode(rs.getString("Code"));
		        list.add(drug);
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
	public List<Drug> getAllDrug() {
		Drug drug=null;
        String sql="select * from Drug";
        ResultSet rs=dao.executeQuery(sql);
        List<Drug> list = new ArrayList<Drug>();
	    try {
	        while(rs.next()){
		        drug=new Drug();
		        drug.setDrug_Id(rs.getInt("Drug_Id"));
		        drug.setDrug_Name(rs.getString("Drug_Name"));
		        drug.setPrice(rs.getDouble("Price"));
		        drug.setUnit(rs.getString("Unit"));
		        drug.setAmount(rs.getInt("Amount"));
		        drug.setCode(rs.getString("Code"));
		        list.add(drug);
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
	public int delDrug(String drug_Name) {
    	int i=0;
  		try{
  			String sql="delete from Drug where Drug_Name='"+drug_Name+"'";
 			i=dao.executeUpdate(sql);
 		}catch(Exception e){
 			e.printStackTrace();
 		}
 		dao.close();
 		return i;
	}
}
