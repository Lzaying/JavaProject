package team.sqjj.hospital.dao;

import java.util.List;
import team.sqjj.hospital.model.Prescription;

public interface PrescriptionDao {
public int payPrescription(int PrescriptionId);
public List<Prescription> getByPatientID (String patientId);
public List<Prescription> getByDoctor(String id);//在业务层中用此方法来获取某医生处的收入 id为医生id
public int addPrescription(Prescription prescription);
}
