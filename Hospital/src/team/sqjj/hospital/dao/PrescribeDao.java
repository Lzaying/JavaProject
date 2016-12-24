package team.sqjj.hospital.dao;

import java.util.List;
import team.sqjj.hospital.model.Prescribe;

public interface PrescribeDao {
public int payPrescribe(String PrescribeId);
public List<Prescribe> getByPatientID (String patientId);
public List<Prescribe> getByDoctor(String id);//在业务层中用此方法来获取某医生处的收入 id为医生id
public List<Prescribe> getByDepartment(String department);//在业务层中用此方法来获取某处的收入
public int addPrescribe(Prescribe prescribe);
}
