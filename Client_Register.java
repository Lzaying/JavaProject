package team.sqjj.hospital.JFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import team.sqjj.hospital.DaoFactory.AppointmentDaoFactory;
import team.sqjj.hospital.DaoFactory.DepartmentDaoFactory;
import team.sqjj.hospital.DaoFactory.DoctorDaoFactory;
import team.sqjj.hospital.DaoFactory.PatientDaoFactory;
import team.sqjj.hospital.DaoFactory.PrescriptionDaoFactory;
import team.sqjj.hospital.DaoFactory.RegisterDaoFactory;
import team.sqjj.hospital.TEST.TEST;
import team.sqjj.hospital.model.Appointment;
import team.sqjj.hospital.model.Department;
import team.sqjj.hospital.model.Doctor;
import team.sqjj.hospital.model.Patient;
import team.sqjj.hospital.model.Prescription;
import team.sqjj.hospital.model.Register;
import java.awt.event.ItemEvent;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;

public class Client_Register extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtage;
	private JTextField txttell;
	private JTextField txtadd;
	private JTextField dingdanhao;
	private JTextField guahaofei;
	private JTextField yaopinfei;
	private Patient p;
	private Appointment a;
	private Register register;
	private JTextField yisheng;
	private String doctorid;
	private String patient_Id;
	private Prescription pre;

	@SuppressWarnings("unchecked")
	public Client_Register() {
		super("����Һ��շѶˡ�����");

		List<Doctor> doctors = DoctorDaoFactory.getInstance().getAll();
		for (int i = 0; i < doctors.size(); i++) {
			Queue.paiduirenshu.put(doctors.get(i).getDoctor_Id(), 0);
		}
		getContentPane().setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 676, 443);
		getContentPane().add(tabbedPane);

		JPanel panel_ = new JPanel();
		tabbedPane.addTab(" �Һ�  ", null, panel_, null);
		panel_.setLayout(null);

		JLabel lblNewLabel = new JLabel("���˹ҺŶ�");
		lblNewLabel.setFont(new Font("������κ", Font.BOLD, 20));
		lblNewLabel.setBounds(274, 10, 127, 24);
		panel_.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(212, 44, 156, 21);
		panel_.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("��ѯ");

		btnNewButton.setBounds(384, 44, 93, 23);
		panel_.add(btnNewButton);

		JLabel lblNewLabel_2 = new JLabel("����");
		lblNewLabel_2.setBounds(212, 101, 54, 15);
		panel_.add(lblNewLabel_2);

		JLabel label_1 = new JLabel("�Ա�");
		label_1.setBounds(212, 136, 54, 15);
		panel_.add(label_1);

		JLabel lblNewLabel_3 = new JLabel("����");
		lblNewLabel_3.setBounds(212, 175, 54, 15);
		panel_.add(lblNewLabel_3);

		textField_1 = new JTextField();
		textField_1.setBounds(274, 98, 74, 21);
		panel_.add(textField_1);
		textField_1.setColumns(10);

		txtage = new JTextField();
		txtage.setBounds(274, 172, 66, 21);
		panel_.add(txtage);
		txtage.setColumns(10);

		JRadioButton man = new JRadioButton("��");
		man.setSelected(true);
		man.setBounds(270, 132, 66, 23);
		panel_.add(man);

		JRadioButton woman = new JRadioButton("Ů");
		woman.setBounds(341, 132, 60, 23);
		panel_.add(woman);
		ButtonGroup nv = new ButtonGroup();
		nv.add(man);
		nv.add(woman);

		JLabel label = new JLabel("���");
		label.setBounds(383, 175, 37, 15);
		panel_.add(label);

		JCheckBox ckmarry = new JCheckBox("�ѻ�");
		ckmarry.setBounds(426, 171, 103, 23);
		panel_.add(ckmarry);

		JLabel label_2 = new JLabel("��ϵ��ʽ");
		label_2.setBounds(212, 216, 54, 15);
		panel_.add(label_2);

		txttell = new JTextField();
		txttell.setBounds(274, 213, 134, 21);
		panel_.add(txttell);
		txttell.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("��ͥסַ");
		lblNewLabel_4.setBounds(212, 252, 54, 18);
		panel_.add(lblNewLabel_4);

		txtadd = new JTextField();
		txtadd.setBounds(274, 251, 134, 21);
		panel_.add(txtadd);
		txtadd.setColumns(10);

		JLabel label_3 = new JLabel("ѡ�����");
		label_3.setBounds(212, 296, 54, 15);
		panel_.add(label_3);

		JComboBox<String> keshi = new JComboBox<String>();

		keshi.setBounds(274, 293, 62, 21);
		panel_.add(keshi);

		JLabel label_4 = new JLabel("����ҽ��Ϊ");
		label_4.setBounds(365, 296, 74, 15);
		panel_.add(label_4);

		JButton queren = new JButton("ȷ��");

		queren.setBounds(212, 345, 93, 23);
		panel_.add(queren);

		yisheng = new JTextField();
		yisheng.setEditable(false);
		yisheng.setBounds(463, 293, 66, 21);
		panel_.add(yisheng);
		yisheng.setColumns(10);

		JButton btnNewButton_1 = new JButton("�˳�");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(327, 345, 93, 23);
		panel_.add(btnNewButton_1);
		List<Department> departments = DepartmentDaoFactory.getInstance().getDepartment();
		Iterator<Department> it = departments.iterator();
		Map<String, Integer> map = new HashMap<String, Integer>();
		while (it.hasNext()) {
			Department department = it.next();
			map.put(department.getDepartment(), department.getDepartment_Id());
			keshi.addItem(department.getDepartment());

		}

		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if (textField.getText().length() == 0) {
					JOptionPane.showMessageDialog(panel_, "�����������֤��");
					return;
				}
				patient_Id = textField.getText().toString();
				p = PatientDaoFactory.getInstance().getInfoById(patient_Id);
				if (p != null) {
					textField_1.setText(p.getPatient_Name());
					txttell.setText(p.getTelephone());
					txtage.setText("" + p.getPatient_Age());
					if (p.getIsMarried() == 1) {
						ckmarry.setSelected(true);
					}
					if (p.getPatient_Sex() == 0) {
						man.setSelected(true);
					} else
						woman.setSelected(true);
					txtadd.setText(p.getAddress());
				} else {
					JOptionPane.showMessageDialog(panel_, "û�иò��˼�¼");
				}
				a = AppointmentDaoFactory.getInstance().getById(patient_Id);
				if (a != null) {
					System.out.println("�����Ѿ�ԤԼ");
					Doctor d = DoctorDaoFactory.getInstance().getbyId(a.getDoctor_Id());
					Department de = DepartmentDaoFactory.getInstance().getbyID(d.getDepartment_Id());
					System.out.println("�����Ѿ�ԤԼ");
					doctorid = d.getDoctor_Id();
					keshi.setSelectedItem(de.getDepartment());
					System.out.println(d.getName());
					yisheng.setText(d.getName());

				}
			}
		});
		keshi.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				List<Doctor> dlist = DoctorDaoFactory.getInstance().getByDepartment(map.get(keshi.getSelectedItem()));
				System.out.println(dlist);
				Iterator<Doctor> it = dlist.iterator();
				int min = 1000000;

				while (it.hasNext()) {

					int renshu = Queue.paiduirenshu.get(it.next().getDoctor_Id());
					System.out.println(renshu);
					if (min > renshu) {
						min = renshu;
						doctorid = it.next().getDoctor_Id();
						System.out.println(it.next().getDoctor_Id());
					}
				}

				yisheng.setText(DoctorDaoFactory.getInstance().getbyId(doctorid).getName());

			}
		});
		queren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textField_1.getText().length() == 0) {
					JOptionPane.showMessageDialog(panel_, "����������");
					return;
				}
				if (!txtage.getText().matches("^(?:[1-9][0-9]?|1[01][0-9]|120)$")) {
					JOptionPane.showMessageDialog(panel_, "�����������������䣨1~120��");
					return;
				}
				if (!txttell.getText().matches("^1(3|4|5|7|8)\\d{9}$")) {
					JOptionPane.showMessageDialog(panel_, "��������ϵ��ʽ");
					return;
				}
				if (txtadd.getText().length() == 0) {
					JOptionPane.showMessageDialog(panel_, "��������ϵ��ַ");
					return;
				}
				if (p == null) {

					p = new Patient();
					p.setAddress(txtadd.getText());
					if (ckmarry.isSelected() == true)
						p.setIsMarried(1);
					else
						p.setIsMarried(0);
					p.setPatient_Age(Integer.parseInt(txtage.getText()));
					p.setPatient_Name(textField_1.getText());
					if (man.isSelected() == true)
						p.setPatient_Sex(0);
					else
						p.setPatient_Sex(1);
					p.setTelephone(txttell.getText());
					PatientDaoFactory.getInstance().addPatient(p);

				} else {
					p.setAddress(txtadd.getText());
					if (ckmarry.isSelected() == true)
						p.setIsMarried(1);
					else
						p.setIsMarried(0);
					p.setPatient_Age(Integer.parseInt(txtage.getText()));
					p.setPatient_Name(textField_1.getText());
					if (man.isSelected() == true)
						p.setPatient_Sex(0);
					else
						p.setPatient_Sex(1);
					p.setTelephone(txttell.getText());
					PatientDaoFactory.getInstance().updatePatient(p);

				}
				long currentTime = System.currentTimeMillis();

				if (Queue.qlist1.get(doctorid) == null) {
					List<Patient> plist1 = new ArrayList<Patient>();

					Queue.qlist1.put(doctorid, plist1);
				}
				if (Queue.qlist2.get(doctorid) == null) {
					List<Patient> plist2 = new ArrayList<Patient>();

					Queue.qlist2.put(doctorid, plist2);
				}
				if (Queue.qlist.get(doctorid) == null) {
					List<Patient> plist = new ArrayList<Patient>();

					Queue.qlist.put(doctorid, plist);
				}
				if (a == null) {
					register = new Register();
					register.setId(doctorid);
					register.setIsLooked(0);
					register.setPatient_Id(patient_Id);
					Queue.qlist2.get(doctorid).add(p);
				} 
				 else {
				 SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmm");
				 String str = sdf.format(a.getTime());
				 long millionSeconds = 0;
				 try {
				 millionSeconds = sdf.parse(str).getTime();
				 } catch (ParseException e) {
				 // TODO Auto-generated catch block
				 e.printStackTrace();
				 } // ����
				 long cha = millionSeconds - currentTime;
				 register = new Register();
				 doctorid = a.getDoctor_Id();
				 register.setId(doctorid);
				 register.setIsLooked(0);
				 register.setPatient_Id(patient_Id);
				
				 if (cha >= -1 * 60 * 60 * 1000 || cha <= 1 * 60 * 60 * 1000)
				 {
				
				 Queue.qlist1.get(doctorid).add(p);
				
				 }
				 else Queue.qlist2.get(doctorid).add(p);
				
				 AppointmentDaoFactory.getInstance().delAppointment(a.getAppointment_Id());
				 }
				Queue.qlist.get(doctorid).clear();
				Queue.qlist.get(doctorid).addAll(Queue.qlist1.get(doctorid));

				Queue.qlist.get(doctorid).addAll(Queue.qlist2.get(doctorid));
				int number = Queue.paiduirenshu.get(doctorid);
				Queue.paiduirenshu.put(doctorid, number + 1);
				System.out.println((Queue.paiduirenshu.get("li")));
				System.out.println((Queue.paiduirenshu.get(doctorid)));
				// System.out.println(register.getDoctor_Id());
				RegisterDaoFactory.getInstance().addRegister(register);
				JOptionPane.showMessageDialog(panel_, "��Ϣ¼��ɹ�");
			}

		});

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab(" �շ�  ", null, panel_1, null);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("�շѶ�");
		lblNewLabel_1.setBounds(293, 10, 63, 21);
		lblNewLabel_1.setFont(new Font("������κ", Font.BOLD, 20));
		panel_1.add(lblNewLabel_1);

		JButton querenshoufei = new JButton("ȷ���շ�");
		querenshoufei.setBounds(263, 248, 93, 23);
		querenshoufei.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PrescriptionDaoFactory.getInstance().payPrescription(pre.getPrescription_Id());
			}
		});
		panel_1.add(querenshoufei);

		JLabel label_5 = new JLabel("������Ϣ");
		label_5.setBounds(303, 41, 54, 15);
		panel_1.add(label_5);

		JLabel label_6 = new JLabel("������");
		label_6.setBounds(243, 69, 54, 15);
		panel_1.add(label_6);

		JLabel label_7 = new JLabel("�Һŷ�");
		label_7.setBounds(243, 125, 54, 15);
		panel_1.add(label_7);

		JLabel label_8 = new JLabel("ҩƷ��");
		label_8.setBounds(243, 176, 54, 15);
		panel_1.add(label_8);

		dingdanhao = new JTextField();
		dingdanhao.setBounds(323, 66, 66, 21);
		panel_1.add(dingdanhao);
		dingdanhao.setColumns(10);

		guahaofei = new JTextField();
		guahaofei.setBounds(323, 122, 66, 21);
		panel_1.add(guahaofei);
		guahaofei.setColumns(10);

		yaopinfei = new JTextField();
		yaopinfei.setBounds(323, 173, 66, 21);
		panel_1.add(yaopinfei);
		yaopinfei.setColumns(10);

		JButton chadingdan = new JButton("��ѯ");
		chadingdan.setBounds(416, 65, 66, 23);
		panel_1.add(chadingdan);

		JButton btnNewButton_2 = new JButton("�˳�");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_2.setBounds(263, 295, 93, 23);
		panel_1.add(btnNewButton_2);
		chadingdan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int prescriptionid = Integer.parseInt(dingdanhao.getText());
				pre = PrescriptionDaoFactory.getInstance().getbyid(prescriptionid);
				guahaofei.setText("20");
				yaopinfei.setText("" + pre.getTotalPrice());

			}
		});

		this.setSize(685, 505);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	new TEST();
		new Client_Register();

		 new Client_Doctor("li");
	}
}
