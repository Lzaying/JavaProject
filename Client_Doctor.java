package team.sqjj.hospital.JFrame;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import team.sqjj.hospital.DaoFactory.PatientDaoFactory;
import team.sqjj.hospital.DaoFactory.PrescriptionDaoFactory;
import team.sqjj.hospital.DaoFactory.RegisterDaoFactory;
import team.sqjj.hospital.ServerSocket.ShareVariance;
import team.sqjj.hospital.model.Patient;
import team.sqjj.hospital.DaoFactory.DepartmentDaoFactory;
import team.sqjj.hospital.DaoFactory.DoctorDaoFactory;
import team.sqjj.hospital.DaoFactory.DrugDaoFactory;
import team.sqjj.hospital.DaoFactory.PatientDaoFactory;
import team.sqjj.hospital.DaoFactory.RegisterDaoFactory;
import team.sqjj.hospital.ServerSocket.ShareVariance;
import team.sqjj.hospital.Util.AutoCompleteComponet;
import team.sqjj.hospital.model.Doctor;
import team.sqjj.hospital.model.Drug;
import team.sqjj.hospital.model.Patient;
import team.sqjj.hospital.model.Prescription;
import team.sqjj.hospital.model.PrescriptionItem;

import team.sqjj.hospital.model.Register;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JSplitPane;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class Client_Doctor extends JFrame implements ActionListener {
	private JTextField br;
	private JButton mkdrug;
	private List<Patient> list;
	private Socket socket;
	private OutputStream os;
	private PrintWriter pw;
	private JPanel panel;
	private Patient patient = null;
	private Doctor doctor;
	private JLabel lblNewLabel_2;
	private JTextPane patients_list;
	private boolean stopped=true;
  private DoctorClientThread th;
	public Client_Doctor(String username) {

		try {
			socket = new Socket("localhost", 8887);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("我在这里欢笑" + Queue.qlist.get(username));
		
		doctor = DoctorDaoFactory.getInstance().getbyId(username);
		th=new DoctorClientThread();
				th.start();
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel(
				"科室：" + DepartmentDaoFactory.getInstance().getbyID(doctor.getDepartment_Id()).getDepartment());
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel.setBounds(43, 19, 113, 48);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("医生：" + doctor.getName());
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(346, 19, 161, 48);
		getContentPane().add(lblNewLabel_1);

		panel = new JPanel();
		panel.setBounds(35, 98, 331, 316);
		getContentPane().add(panel);
		panel.setLayout(null);
		String patientlist = "";
		// list=Queue.qlist.get(username);
		// if(list!=null){
		//// Iterator<Patient> it = list.iterator();
		//// while (it.hasNext()) {
		//// Patient patient = it.next();
		////
		//// patientlist += patient.getPatient_Name();
		//// patientlist += '\n';
		////
		//// }}
		lblNewLabel_2 = new JLabel("当前病人：");
		lblNewLabel_2.setBounds(10, 10, 109, 15);

		panel.add(lblNewLabel_2);

		br = new JTextField();
		if (patient != null)
			br.setText(patient.getPatient_Name());
		br.setEditable(false);
		br.setBounds(10, 35, 293, 21);
		panel.add(br);
		br.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("病人队列：");
		lblNewLabel_3.setBounds(10, 75, 71, 15);
		panel.add(lblNewLabel_3);
		patients_list = new JTextPane();

		patients_list.setText(patientlist);
		patients_list.setEditable(false);
		patients_list.setBounds(10, 100, 293, 178);
		panel.add(patients_list);

		mkdrug = new JButton("开药");
		mkdrug.setBounds(432, 205, 93, 23);
		getContentPane().add(mkdrug);
		mkdrug.addActionListener(this);

		JButton btnNewButton_1 = new JButton("退出");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(432, 260, 93, 23);
		getContentPane().add(btnNewButton_1);

		this.setVisible(true);
		this.setSize(600, 500);
		this.setLocation(800, 0);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == mkdrug)
			if (patient == null) {
				JOptionPane.showMessageDialog(panel, "当前没有病人");
				return;
			}
		try {
			new Window_Prescribe();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	class DoctorClientThread extends Thread {
		// 和本线程相关的Socket

		public void run() {
			while (stopped) {
				System.out.println("我在这里欢笑" + Queue.qlist.get(doctor.getDoctor_Id()));
				list = Queue.qlist.get(doctor.getId());
				if (list != null) {
					if (list.size() != 0) {
                        patient=list.get(0);
						br.setText(patient.getPatient_Name());
						String patientlist = "";
						Iterator<Patient> it = Queue.qlist.get(doctor.getDoctor_Id()).iterator();
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

	class Window_Prescribe extends JFrame {
		private JTextField textField;
		private JTextField textField_1;
		private Map<String, Drug> drugmap;
		private Prescription prescription ;
		private int amount;
		private int totalprice = 0;
		private List<Drug> dlist;
		private Drug d;
		private List<PrescriptionItem> tiaomu = new ArrayList<PrescriptionItem>();;
		private String yaodan = "";
		private JTextField textField_3;

		public Window_Prescribe() throws ClassNotFoundException, InstantiationException, IllegalAccessException,
				UnsupportedLookAndFeelException {
			super("开药");
			prescription= new Prescription();
			getContentPane().setLayout(null);

			JPanel panel = new JPanel();
			panel.setBounds(25, 186, 356, 160);
			getContentPane().add(panel);
			panel.setLayout(null);

			JTextPane textPane = new JTextPane();
			textPane.setBounds(0, 0, 346, 160);
			panel.add(textPane);

			JLabel label = new JLabel("\u836F\u540D");
			label.setBounds(66, 130, 29, 15);
			getContentPane().add(label);

			JLabel lblNewLabel_1 = new JLabel("\u6570\u91CF");
			lblNewLabel_1.setBounds(163, 130, 35, 15);
			getContentPane().add(lblNewLabel_1);
			JButton btnNewButton = new JButton("\u6DFB\u52A0");

			btnNewButton.setBounds(288, 153, 93, 23);
			getContentPane().add(btnNewButton);

			JLabel yaodanhao = new JLabel("");
			yaodanhao.setText("药单号" + Queue.PrescriptionNumber);
			yaodanhao.setHorizontalAlignment(SwingConstants.CENTER);
			yaodanhao.setFont(new Font("宋体", Font.PLAIN, 18));
			yaodanhao.setBounds(137, 10, 185, 26);
			getContentPane().add(yaodanhao);

			JLabel label_1 = new JLabel("\u75C5\u4EBA\u59D3\u540D\uFF1A");
			label_1.setBounds(26, 47, 71, 15);
			getContentPane().add(label_1);

			JLabel lblNewLabel_3 = new JLabel("\u533B\u751F\u59D3\u540D\uFF1A");
			lblNewLabel_3.setBounds(25, 74, 72, 15);
			getContentPane().add(lblNewLabel_3);

			JLabel lblNewLabel_4 = new JLabel("\u5355\u4F4D");
			lblNewLabel_4.setBounds(219, 130, 54, 15);
			getContentPane().add(lblNewLabel_4);

			JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
			btnNewButton_1.setBounds(381, 200, 93, 23);
			getContentPane().add(btnNewButton_1);
			btnNewButton_1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					textPane.setText("");
					yaodan = "";
					tiaomu.clear();
				}

			});
			JButton btnNewButton_2 = new JButton("\u786E\u5B9A");
			btnNewButton_2.setBounds(381, 244, 93, 23);
			getContentPane().add(btnNewButton_2);
			btnNewButton_2.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					dispose();
					if (patient != null) {
						stopped=false;
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						list.remove(patient);
						Queue.qlist.get(doctor.getDoctor_Id()).remove(patient);
						Queue.qlist1.get(doctor.getDoctor_Id()).remove(patient);
						Queue.qlist2.get(doctor.getDoctor_Id()).remove(patient);
					}stopped=true;
					th=new DoctorClientThread();
					th.start();
					br.setText(""); 
					patients_list.setText("");

					prescription.setDoctor_Id(doctor.getDoctor_Id());
					
				    prescription.setPatient_Id(patient.getPatient_Id());
					
					prescription.setPrescription_Id(Queue.PrescriptionNumber);
					prescription.setPrescription_Item(tiaomu);
					Queue.PrescriptionNumber++;
					prescription.setTotalPrice(totalprice);

					PrescriptionDaoFactory.getInstance().addPrescription(prescription);
				    yaodan="";

					 try {
					
					 OutputStream os = socket.getOutputStream();
					 ObjectOutputStream oos = new ObjectOutputStream(os);
					 oos.writeObject(prescription);
					
					 oos.flush();
					
					 socket.shutdownOutput();// 关闭输出流
					 os.close();
					 oos.close();
					 } catch (IOException e1) {
					 // TODO Auto-generated catch block
					 e1.printStackTrace();
					 }
					
				}

			});
			JButton btnNewButton_3 = new JButton("\u9000\u51FA");
			btnNewButton_3.setBounds(381, 291, 93, 23);
			getContentPane().add(btnNewButton_3);
			btnNewButton_3.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					dispose();
				}

			});
			textField = new JTextField();
			textField.setEditable(false);
			textField.setBounds(109, 46, 99, 21);
			getContentPane().add(textField);
			textField.setColumns(10);
			if (patient != null)
				textField.setText(patient.getPatient_Name());
			textField_1 = new JTextField();
			textField_1.setEditable(false);
			textField_1.setBounds(109, 71, 99, 21);
			getContentPane().add(textField_1);
			textField_1.setColumns(10);
			textField_1.setText(doctor.getName());
			JTextField textField_2 = AutoCompleteComponet.create();
			textField_2.setBounds(49, 155, 66, 21);
			getContentPane().add(textField_2);
			JComboBox comboBox = new JComboBox();
			comboBox.addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent arg0) {
					// TODO Auto-generated method stub
					d = drugmap.get(comboBox.getSelectedItem().toString());
					System.out.println("nimeide" + d);
					amount = d.getAmount();
				}

				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}
			});
			comboBox.setBounds(219, 155, 59, 21);
			getContentPane().add(comboBox);

			textField_3 = new JTextField();
			textField_3.setBounds(137, 155, 66, 21);
			getContentPane().add(textField_3);
			textField_3.setColumns(10);

			JLabel lblNewLabel = new JLabel("\u5E93\u5B58\u4E0D\u591F");
			lblNewLabel.setBounds(393, 157, 54, 15);
			getContentPane().add(lblNewLabel);
			textField_2.setColumns(10);
			lblNewLabel.setVisible(false);

			this.setVisible(true);
			this.setSize(500, 500);
			this.setLocation(900, 100);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int number = Integer.parseInt(textField_3.getText());
					System.out.println(amount);
					if (0 < number && number <= amount) {
						yaodan += d.getDrug_Name() + "\t" + number + "\t " + comboBox.getSelectedItem().toString()
								+ '\n';
						totalprice += number * d.getPrice();
						textPane.setText(yaodan);
						PrescriptionItem preitem = new PrescriptionItem();
						preitem.setDrug_id(d.getDrug_Id());
						preitem.setQuantity(number);
						preitem.setPrescription_id(Queue.PrescriptionNumber);

						tiaomu.add(preitem);

					} else {
						lblNewLabel.setVisible(true);
						return;
					}
				}
			});
			textField_2.addMouseListener(new MouseListener() {

				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseClicked(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub
					dlist = DrugDaoFactory.getInstance().getByname(textField_2.getText());
					comboBox.removeAllItems();
					drugmap = new HashMap();
					for (int i = 0; i < dlist.size(); i++) {
						Drug d = dlist.get(i);
						drugmap.put(d.getUnit(), d);
						comboBox.addItem(d.getUnit());
					}
				}

			});

		}
	}

	public static void main(String[] args) {
		new Client_Doctor("li");

	}
}
