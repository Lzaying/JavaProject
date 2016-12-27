package team.sqjj.hospital.JFrame;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;
import javax.swing.text.Caret;

import team.sqjj.hospital.DaoFactory.DepartmentDaoFactory;
import team.sqjj.hospital.DaoFactory.DoctorDaoFactory;
import team.sqjj.hospital.model.Department;
import team.sqjj.hospital.model.Doctor;
import team.sqjj.hospital.model.Patient;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.JTable;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.Dimension;

import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.DropMode;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Client_Screen extends JFrame{
	private Doctor doctor=null;
	private List<Patient> list;
	private JTextPane patients_list;
	public Client_Screen() {
		Map<String, Doctor> map2 = new HashMap<String, Doctor>();
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		
		JMenu mnNewMenu_1 = new JMenu("退出");
		mnNewMenu_1.setIcon(new ImageIcon(Client_Screen.class.getResource("/javax/swing/plaf/metal/icons/ocean/close.gif")));
		menuBar.add(mnNewMenu_1);
		
		JButton btnNewButton = new JButton("退出");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				dispose();
			}
		});
		mnNewMenu_1.add(btnNewButton);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(72, 60, 400, 177);
		getContentPane().add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 210, 106);
		scrollPane.setPreferredSize(new Dimension(200,100));
		String[]str={"aa","bb","cc"};
		panel.setLayout(null);
		
		patients_list = new JTextPane();
		patients_list.setText("");
		patients_list.setEditable(false);
		patients_list.setBounds(0, 0, 293, 178);
		panel.add(patients_list);
		//final JList jlist=new JList(str);
		
		
		
		
		
		
		JLabel lblNewLabel = new JLabel("选择科室");
		lblNewLabel.setBounds(54, 266, 54, 15);
		getContentPane().add(lblNewLabel);
		
		JComboBox keshi = new JComboBox();//选择科室 
		List<Department> departments = DepartmentDaoFactory.getInstance().getDepartment();
		Iterator<Department> it = departments.iterator();
		Map<String, Integer> map = new HashMap<String, Integer>();
		while (it.hasNext()) {
			Department department = it.next();
			map.put(department.getDepartment(), department.getDepartment_Id());
			keshi.addItem(department.getDepartment());

		}
	
		keshi.setBounds(118, 263, 65, 21);
		getContentPane().add(keshi);
		
		JLabel label = new JLabel("\u9009\u62E9\u533B\u751F");
		label.setBounds(231, 266, 54, 15);
		getContentPane().add(label);
		
		JComboBox yisheng = new JComboBox();
		
		yisheng.setBounds(324, 263, 54, 21);
		getContentPane().add(yisheng);
		
		this.setVisible(true);
		this.setSize(600,499);
		keshi.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				List<Doctor> dlist = DoctorDaoFactory.getInstance().getByDepartment(map.get(keshi.getSelectedItem()));
  			    System.out.println(dlist);
				//Iterator<Doctor> it = dlist.iterator();
				
                yisheng.removeAllItems();
                for(int i=0;i<dlist.size();i++) {
//                	 System.out.println(it.next());
					yisheng.addItem(dlist.get(i).getName());
					map2.put(dlist.get(i).getName(), dlist.get(i));
				}

				

			}
		});
		yisheng.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				/////////////////////////////////////;
				doctor=map2.get(yisheng.getSelectedItem().toString());
				//new DoctorClientThread();
//				jlist.setModel(new AbstractListModel() {
//					String[] values = new String[] {"aa", "bb", "cc", "dd", "ff", "dd", "d", "s", "", "s"};
//					public int getSize() {
//						return values.length;
//					}
//					public Object getElementAt(int index) {
//						return values[index];
//					}
//				});
//				scrollPane.setViewportView(jlist);
//				panel.add(scrollPane);
				
			}
		}
			);
	}
	class DoctorClientThread extends Thread {
		// 和本线程相关的Socket
		
		public void run() {
			while (true) {
				System.out.println("我在这里欢笑" + Queue.qlist.get(doctor.getDoctor_Id()));
				list = Queue.qlist.get(doctor.getId());
				if (list != null) {
					if (list.size() != 0) {
                     
						String patientlist = "";
						Iterator<Patient> it =list.iterator();
						while (it.hasNext()) {
							Patient patient = it.next();

							patientlist += patient.getPatient_Name();
							patientlist += '\n';
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

						}
						patients_list.setText(patientlist);

					}
				}
			}
		}
	}
	public static void main(String[]agrs){
		new Client_Screen();
	}
}
