package team.sqjj.hospital.dao;

import java.util.List;
import team.sqjj.hospital.model.Prescription;

public interface PrescriptionDao {
public int payPrescription(int prescription_Id);
public List<Prescription> getByPatientID (String patient_Id);
public List<Prescription> getByDoctor(String doctor_Id);//��ҵ������ô˷�������ȡĳҽ���������� idΪҽ��id
public int addPrescription(Prescription prescription);
}
