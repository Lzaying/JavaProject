package team.sqjj.hospital.dao;

import team.sqjj.hospital.DaoImpl.Dao;
import team.sqjj.hospital.model.Prescription;
import team.sqjj.hospital.model.PrescriptionItem;

public interface PrescriptionItemDao {
	public int addPrescriptionItem(PrescriptionItem prescriptionItem);
}
