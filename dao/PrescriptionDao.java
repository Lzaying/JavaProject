package team.sqjj.hospital.dao;

import java.util.List;
import team.sqjj.hospital.model.Prescription;

public interface PrescriptionDao {
public int payPrescription(int prescription_Id);
public List<Prescription> getByPatientID (String patient_Id);
public List<Prescription> getByDoctor(String doctor_Id);
public int addPrescription(Prescription prescription);
public double doTotalPrice(String doctor_Id);//ҽ�������ܽ��
public double deTotalPrice(String department);//���Ҵ����ܽ��
public List<Prescription> getPaid();
public List<Prescription> getUnPaidr();
}
