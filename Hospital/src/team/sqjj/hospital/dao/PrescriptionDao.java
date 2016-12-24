package team.sqjj.hospital.dao;

import java.util.List;
import team.sqjj.hospital.model.Prescription;

public interface PrescriptionDao {
public int payPrescription(int prescription_Id);
public List<Prescription> getByPatientID (String patient_Id);
public List<Prescription> getByDoctor(String doctor_Id);//在业务层中用此方法来获取某医生处的收入 id为医生id
public int addPrescription(Prescription prescription);
}
