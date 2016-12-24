package team.sqjj.hospital.dao;

import java.util.List;
import team.sqjj.hospital.model.Prescribe;

public interface PrescribeDao {
public int payPrescribe(String PrescribeId);
public List<Prescribe> getByPatientID (String patientId);
public List<Prescribe> getByDoctor(String id);//��ҵ������ô˷�������ȡĳҽ���������� idΪҽ��id
public List<Prescribe> getByDepartment(String department);//��ҵ������ô˷�������ȡĳ��������
public int addPrescribe(Prescribe prescribe);
}
