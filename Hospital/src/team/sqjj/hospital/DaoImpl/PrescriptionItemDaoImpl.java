package team.sqjj.hospital.DaoImpl;

import team.sqjj.hospital.dao.PrescriptionItemDao;
import team.sqjj.hospital.dao.RegisterDao;
import team.sqjj.hospital.model.PrescriptionItem;

public class PrescriptionItemDaoImpl implements PrescriptionItemDao{
	private Dao dao=null;
    public PrescriptionItemDaoImpl(){ dao=new Dao();}
	@Override
	public int addPrescriptionItem(PrescriptionItem prescriptionItem) {
		// TODO Auto-generated method stub
		int i=0;
		try{
			String sql="insert into PrescriptionItem values("+prescriptionItem.getDrug_id()+","+prescriptionItem.getPrescription_id()+","+prescriptionItem.getQuantity()+"";
			i=dao.executeUpdate(sql);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		dao.close();
		return i;
	}
	

}
