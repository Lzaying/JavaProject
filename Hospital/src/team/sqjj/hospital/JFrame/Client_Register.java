package team.sqjj.hospital.JFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
import team.sqjj.hospital.model.Appointment;
import team.sqjj.hospital.model.Department;
import team.sqjj.hospital.model.Doctor;
import team.sqjj.hospital.model.Patient;
import team.sqjj.hospital.model.Prescription;
import team.sqjj.hospital.model.Register;
import java.awt.event.ItemEvent;

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
		super("门诊挂号收费端。。。");
		getContentPane().setLayout(null);

		JPanel panel_ = new JPanel();
		panel_.setBorder(new LineBorder(Color.BLACK));
		panel_.setBounds(-183, -119, 380, 370);
		getContentPane().add(panel_);
		panel_.setLayout(null);

		JLabel lblNewLabel = new JLabel("病人挂号端");
		lblNewLabel.setFont(new Font("华文新魏", Font.BOLD, 20));
		lblNewLabel.setBounds(130, 0, 127, 24);
		panel_.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(10, 46, 156, 21);
		panel_.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("查询");
		
		btnNewButton.setBounds(193, 45, 93, 23);
		panel_.add(btnNewButton);

		JLabel lblNewLabel_2 = new JLabel("\u59D3\u540D");
		lblNewLabel_2.setBounds(10, 101, 54, 15);
		panel_.add(lblNewLabel_2);

		JLabel label_1 = new JLabel("性别");
		label_1.setBounds(10, 136, 54, 15);
		panel_.add(label_1);

		JLabel lblNewLabel_3 = new JLabel("\u5E74\u9F84");
		lblNewLabel_3.setBounds(10, 175, 54, 15);
		panel_.add(lblNewLabel_3);

		textField_1 = new JTextField();
		textField_1.setBounds(56, 98, 66, 21);
		panel_.add(textField_1);
		textField_1.setColumns(10);

		txtage = new JTextField();
		txtage.setBounds(56, 172, 66, 21);
		panel_.add(txtage);
		txtage.setColumns(10);

		JRadioButton man = new JRadioButton("\u7537");
		man.setBounds(56, 132, 66, 23);
		panel_.add(man);

		JRadioButton woman = new JRadioButton("\u5973");
		woman.setBounds(130, 132, 60, 23);
		panel_.add(woman);

		JLabel label = new JLabel("\u5A5A\u5426");
		label.setBounds(173, 178, 54, 15);
		panel_.add(label);

		JCheckBox ckmarry = new JCheckBox("\u5DF2\u5A5A");
		ckmarry.setBounds(233, 174, 103, 23);
		panel_.add(ckmarry);

		JLabel label_2 = new JLabel("\u8054\u7CFB\u65B9\u5F0F");
		label_2.setBounds(10, 216, 54, 15);
		panel_.add(label_2);

		txttell = new JTextField();
		txttell.setBounds(70, 213, 134, 21);
		panel_.add(txttell);
		txttell.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("\u5BB6\u5EAD\u4F4F\u5740");
		lblNewLabel_4.setBounds(10, 254, 54, 15);
		panel_.add(lblNewLabel_4);

		txtadd = new JTextField();
		txtadd.setBounds(70, 251, 134, 21);
		panel_.add(txtadd);
		txtadd.setColumns(10);

		JLabel label_3 = new JLabel("\u9009\u62E9\u79D1\u5BA4");
		label_3.setBounds(10, 296, 54, 15);
		panel_.add(label_3);

		JComboBox keshi = new JComboBox();
		
		keshi.setBounds(90, 293, 32, 21);
		panel_.add(keshi);

		JLabel label_4 = new JLabel("\u60A8\u7684\u533B\u751F\u4E3A");
		label_4.setBounds(173, 296, 74, 15);
		panel_.add(label_4);

		JButton queren = new JButton("\u786E\u8BA4");
		
		queren.setBounds(134, 337, 93, 23);
		panel_.add(queren);
		
		yisheng = new JTextField();
		yisheng.setEditable(false);
		yisheng.setBounds(257, 293, 66, 21);
		panel_.add(yisheng);
		yisheng.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(192, -35, 221, 370);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("收费端");
		lblNewLabel_1.setBounds(79, 5, 63, 21);
		lblNewLabel_1.setFont(new Font("华文新魏", Font.BOLD, 20));
		panel_1.add(lblNewLabel_1);

		JButton querenshoufei = new JButton("确认收费");
		querenshoufei.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PrescriptionDaoFactory.getInstance().IsPaid(pre.getPrescription_Id());
			}
		});
		querenshoufei.setBounds(67, 266, 93, 23);
		panel_1.add(querenshoufei);

		JLabel label_5 = new JLabel("\u8BA2\u5355\u4FE1\u606F");
		label_5.setBounds(79, 52, 54, 15);
		panel_1.add(label_5);

		JLabel label_6 = new JLabel("\u8BA2\u5355\u53F7");
		label_6.setBounds(10, 81, 54, 15);
		panel_1.add(label_6);

		JLabel label_7 = new JLabel("\u6302\u53F7\u8D39");
		label_7.setBounds(10, 125, 54, 15);
		panel_1.add(label_7);

		JLabel label_8 = new JLabel("\u836F\u54C1\u8D39");
		label_8.setBounds(10, 176, 54, 15);
		panel_1.add(label_8);

		dingdanhao = new JTextField();
		dingdanhao.setBounds(67, 81, 66, 21);
		panel_1.add(dingdanhao);
		dingdanhao.setColumns(10);

		guahaofei = new JTextField();
		guahaofei.setBounds(67, 122, 66, 21);
		panel_1.add(guahaofei);
		guahaofei.setColumns(10);

		yaopinfei = new JTextField();
		yaopinfei.setBounds(67, 173, 66, 21);
		panel_1.add(yaopinfei);
		yaopinfei.setColumns(10);
		
		JButton chadingdan = new JButton("\u67E5\u8BE2");
		
		chadingdan.setBounds(145, 77, 66, 23);
		panel_1.add(chadingdan);
		this.setVisible(true);
	    List<Department> departments=DepartmentDaoFactory.getInstance().getDepartment();
	    Iterator<Department> it=departments.iterator();
	    Map<String,Integer> map=new HashMap();
	    while(it.hasNext()){
	    	Department department=it.next();
	    	map.put( department.getDepartment(),department.getDepartment_Id());
	    	keshi.addItem(department.getDepartment().toString());	
	    	   	
	    }
	   
	    keshi.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				List<Doctor> dlist=DoctorDaoFactory.getInstance().getByDepartment(map.get(keshi.getSelectedItem()));
				Iterator<Doctor> it=dlist.iterator();
				int min=100000;
				
				while(it.hasNext())
				{int renshu=RegisterDaoFactory.getInstance().paidui(it.next().getDoctor_Id()).size();
					if(min>renshu){
					min=renshu;doctorid=it.next().getDoctor_Id();
				}
					yisheng.setText(DoctorDaoFactory.getInstance().getbyID(doctorid).getName());
					
				}		
				
			}
		});
	    
	    
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				patient_Id=textField.getText().toString();
				p=PatientDaoFactory.getInstance().getInfoById(patient_Id);
				if(p!=null){textField_1.setText(p.getPatient_Name());
				txttell.setText(p.getTelephone());
		        txtage.setText(""+p.getPatient_Age());
		        if(p.getIsMarried()==1){ckmarry.setSelected(true);}
		        if(p.getPatient_Sex()==0){man.setSelected(true);}
		        else woman.setSelected(true);
				txtadd.setText(p.getAddress());
				}
	      a= AppointmentDaoFactory.getInstance().getById(patient_Id);
	       if(a!=null){
	    	   Doctor d=DoctorDaoFactory.getInstance().getbyID(a.getDoctor_Id());
	    	   Department de=DepartmentDaoFactory.getInstance().getbyID(d.getDepartment_Id());
	    	   keshi.setSelectedItem(de.getDepartment());
	    	   yisheng.setText((d.getName().toString()));
	    	  
	    	  
	       
	       }		
		}});
		chadingdan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int prescriptionid=Integer.parseInt(dingdanhao.getText());
				pre=PrescriptionDaoFactory.getInstance().getByID(prescriptionid);
				guahaofei.setText("20");
				yaopinfei.setText(""+pre.getTotalPrice());
				
			}
		});
		queren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				if(p==null){
					
					p=new Patient();
					p.setAddress(txtadd.getText());
					if(ckmarry.isSelected()==true)
					p.setIsMarried(1);
					else p.setIsMarried(0);
					p.setPatient_Age(Integer.parseInt(txtage.getText()));
					p.setPatient_Name(textField_1.getText());
					if(man.isSelected()==true)
					p.setPatient_Sex(0);
					else p.setPatient_Sex(1);
					p.setTelephone(txttell.getText());
					PatientDaoFactory.getInstance().addPatient(p);
					
							
					
				}
				else {
					p.setAddress(txtadd.getText());
					if(ckmarry.isSelected()==true)
					p.setIsMarried(1);
					else p.setIsMarried(0);
					p.setPatient_Age(Integer.parseInt(txtage.getText()));
					p.setPatient_Name(textField_1.getText());
					if(man.isSelected()==true)
					p.setPatient_Sex(0);
					else p.setPatient_Sex(1);
					p.setTelephone(txttell.getText());					
					PatientDaoFactory.getInstance().updatePatient(p);}
				Date now=new Date();
				if(a==null){register=new Register();register.setId(doctorid);
				register.setIsLooked(0);register.setPatient_Id(patient_Id);
				register.setTime(now);
					
				}else{
			       if(a.getTime().compareTo(now)>0){
			    	   register=new Register();register.setTime(now);register.setId(a.getDoctor_Id());
				       register.setIsLooked(0);register.setPatient_Id(patient_Id);
			       }
			       else {   register=new Register(a);}
			       AppointmentDaoFactory.getInstance().delAppointment(a.getAppointment_Id());
			      }
				 RegisterDaoFactory.getInstance().addRegister(register);
					
					
					
				}
				
				
				
				
		});
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Client_Register();
	}
}
