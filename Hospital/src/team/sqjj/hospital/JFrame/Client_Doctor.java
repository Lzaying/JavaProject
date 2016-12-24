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
import java.util.Iterator;
import java.util.List;

import team.sqjj.hospital.DaoFactory.DoctorDaoFactory;
import team.sqjj.hospital.DaoFactory.PatientDaoFactory;
import team.sqjj.hospital.DaoFactory.RegisterDaoFactory;
import team.sqjj.hospital.ServerSocket.ShareVariance;
import team.sqjj.hospital.Util.AutoCompleteComponet;
import team.sqjj.hospital.model.Doctor;
import team.sqjj.hospital.model.Patient;
import team.sqjj.hospital.model.Prescription;
import team.sqjj.hospital.model.Register;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
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
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class Client_Doctor extends JFrame implements ActionListener {
	private JTextField txtFf;
	private JButton mkdrug;
	private List<Register> list = new ArrayList<Register>();
	private Socket socket;
	private OutputStream os;
	private PrintWriter pw;
	private Register register;
	private Patient patient;
	private Doctor doctor;
	private JLabel lblNewLabel_2;
	private JTextPane patients_list;

	public Client_Doctor(String username) {
		super("医生");
		try {
			socket = new Socket("localhost", 8888);
			os = socket.getOutputStream();// 字节输出流
			pw = new PrintWriter(os);// 将输出流包装为打印流
			pw.write(username);
			pw.flush();
			socket.shutdownOutput();// 关闭输出流
			pw.close();
			os.close();
			new DoctorClientThread(socket).start();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		doctor = DoctorDaoFactory.getInstance().getbyID(username);
		register = list.get(0);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("科室：" + doctor.getDepartment());
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel.setBounds(43, 19, 113, 48);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("医生：" + doctor.getName());
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(346, 19, 86, 48);
		getContentPane().add(lblNewLabel_1);

		JPanel panel = new JPanel();
		panel.setBounds(35, 98, 331, 316);
		getContentPane().add(panel);
		panel.setLayout(null);
		String patientlist = "";
		Iterator<Register> it = list.iterator();
		while (it.hasNext()) {
			Register register = it.next();
			Patient patient = PatientDaoFactory.getInstance().getInfoById(register.getPatient_Id());
			patientlist += patient.getPatient_Name();
			patientlist += '\n';

		}
		patient = PatientDaoFactory.getInstance().getInfoById(register.getPatient_Id());
		lblNewLabel_2 = new JLabel("当前病人：" + patient.getPatient_Name());
		lblNewLabel_2.setBounds(10, 10, 109, 15);
		panel.add(lblNewLabel_2);

		txtFf = new JTextField();
		txtFf.setText("ff");
		txtFf.setEditable(false);
		txtFf.setBounds(10, 35, 293, 21);
		panel.add(txtFf);
		txtFf.setColumns(10);

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

	Comparator<Register> cmp = new Comparator<Register>() {

		@Override
		public int compare(Register r1, Register r2) {
			// TODO Auto-generated method stub
			return r1.getTime().compareTo(r2.getTime());
		}

	};

	class DoctorClientThread extends Thread {
		// 和本线程相关的Socket
		Socket socket = null;

		public DoctorClientThread(Socket socket) {
			this.socket = socket;
		}

		// 线程执行的操作，响应客户端的请求
		public void run() {
			while (true) {
				InputStream is = null;
				InputStreamReader isr = null;
				ObjectInputStream ois = null;
				try {
					is = socket.getInputStream();

					isr = new InputStreamReader(is);

					ois = new ObjectInputStream(is);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Register register = null;
				try {
					register = (Register) ois.readObject();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (register != null) {

					list.add(register);
					Collections.sort(list, cmp);
					register = list.get(0);
					patient = PatientDaoFactory.getInstance().getInfoById(register.getPatient_Id());
					lblNewLabel_2.setText(patient.getPatient_Name());
					String patientlist = "";
					Iterator<Register> it = list.iterator();
					while (it.hasNext()) {
						Register register1 = it.next();
						Patient patient = PatientDaoFactory.getInstance().getInfoById(register1.getPatient_Id());
						patientlist += patient.getPatient_Name();
						patientlist += '\n';

					}
					patients_list.setText(patientlist);

				}
			}
		}
	}

	class Window_Prescribe extends JFrame {
		private JTextField textField;
		private JTextField textField_1;
		private Prescription prescription;

		public Window_Prescribe() throws ClassNotFoundException, InstantiationException, IllegalAccessException,
				UnsupportedLookAndFeelException {
			super("开药");

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

			JComboBox comboBox_2 = new JComboBox();
			comboBox_2.setBounds(163, 155, 29, 21);
			getContentPane().add(comboBox_2);
			JButton btnNewButton = new JButton("\u6DFB\u52A0");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					textPane.setText(t);
				}
			});
			btnNewButton.setBounds(288, 153, 93, 23);
			getContentPane().add(btnNewButton);

			JLabel lblNewLabel_2 = new JLabel("\u5F00\u836F");
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 18));
			lblNewLabel_2.setBounds(137, 10, 185, 26);
			getContentPane().add(lblNewLabel_2);

			JLabel label_1 = new JLabel("\u75C5\u4EBA\u59D3\u540D\uFF1A");
			label_1.setBounds(26, 47, 71, 15);
			getContentPane().add(label_1);

			JLabel lblNewLabel_3 = new JLabel("\u533B\u751F\u59D3\u540D\uFF1A");
			lblNewLabel_3.setBounds(25, 74, 72, 15);
			getContentPane().add(lblNewLabel_3);

			JLabel lblNewLabel_4 = new JLabel("\u5355\u4EF7");
			lblNewLabel_4.setBounds(219, 130, 54, 15);
			getContentPane().add(lblNewLabel_4);

			JLabel lblNewLabel_5 = new JLabel("New label");
			lblNewLabel_5.setBounds(208, 161, 54, 15);
			getContentPane().add(lblNewLabel_5);

			JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
			btnNewButton_1.setBounds(381, 200, 93, 23);
			getContentPane().add(btnNewButton_1);
			btnNewButton_1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					textPane.setText("");
				}

			});
			JButton btnNewButton_2 = new JButton("\u786E\u5B9A");
			btnNewButton_2.setBounds(381, 244, 93, 23);
			getContentPane().add(btnNewButton_2);
			btnNewButton_2.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					list.remove(0);
					register = list.get(0);
					patient = PatientDaoFactory.getInstance().getInfoById(register.getPatient_Id());
					lblNewLabel_2.setText(patient.getPatient_Name());
					String patientlist = "";
					Iterator<Register> it = list.iterator();
					while (it.hasNext()) {
						Register register = it.next();
						Patient patient = PatientDaoFactory.getInstance().getInfoById(register.getPatient_Id());
						patientlist += patient.getPatient_Name();
						patientlist += '\n';

					}
					patients_list.setText(patientlist);

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
					dispose();
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
			textField_2.setColumns(10);

			this.setVisible(true);
			this.setSize(500, 500);
			this.setLocation(900, 100);
		}
	}

}
