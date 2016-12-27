package team.sqjj.hospital.JFrame;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.*;
import javax.swing.*;

import team.sqjj.hospital.DaoImpl.PrescriptionDaoImpl;
import team.sqjj.hospital.JFrame.Client_Doctor.DoctorClientThread;
import team.sqjj.hospital.model.Doctor;
import team.sqjj.hospital.model.Patient;
import team.sqjj.hospital.model.Prescription;
import team.sqjj.hospital.model.Prescription;
import team.sqjj.hospital.model.Register;
import team.sqjj.hospital.DaoFactory.*;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout.Alignment;
//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.FormSpecs;
//import com.jgoodies.forms.layout.RowSpec;
//import net.miginfocom.swing.MigLayout;

public class Client_DrugStore extends JFrame{
	
    private Socket socket;
    private OutputStream os;
	private PrintWriter pw;
	private JScrollPane scrollPane_paid;
	private Prescription prescription;
	private JTable table_paid,table_unpaid;
	private DefaultTableModel model1,model2;
	private Object[][] results_paid,results_unpaid;
	private String [] prescriptionlist = { "ҩ����", "��������", "ҽ������", "�ܶ�"};
	private Object[][] getselect(List list){
		Object[][] s = new Object[list.size()][4];
		for (int i = 0; i < list.size(); i++) {
			Prescription prescription = (Prescription) list.get(i);
			s[i][0] = prescription.getPrescription_Id();			
			s[i][1] = PatientDaoFactory.getInstance().getInfoById(prescription.getPatient_Id()).getPatient_Name();
			//�������ҽ��id�õ�ҽ����Ϣ.
			Doctor a=DoctorDaoFactory.getInstance().getbyId(prescription.getDoctor_Id());
			s[i][2] =a.getName();
			s[i][3] = prescription.getTotalPrice();
		}
		return s;
	}
	
	
	public Client_DrugStore() {
		super("ҩ����");
//		try {
//			socket = new Socket("localhost", 8888);
//			os = socket.getOutputStream();// �ֽ������
//			pw = new PrintWriter(os);// ���������װΪ��ӡ��
//			pw.write("4");
//			pw.flush();
//			socket.shutdownOutput();// �ر������
//			pw.close();
//			os.close();
////			new DoctorClientThread(socket).start();
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}

		
		new DrugStoreClientThread().start();;
		
		//======================�Ѹ���================================= 
		final JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.setPreferredSize(new Dimension(0, 50));
		getContentPane().add(tabbedPane);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("�ɷ�ҩ��", null, panel_2, null);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		scrollPane_paid = new JScrollPane();
		panel_2.add(scrollPane_paid);
		
		results_paid=getselect(PrescriptionDaoFactory.getInstance().getPaid());
		
		model1=new DefaultTableModel(results_paid,prescriptionlist){ 
			public boolean isCellEditable(int row,int column){
				return false;  
			}			
		};

		table_paid= new JTable(model1);
		scrollPane_paid.setViewportView(table_paid);

		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		panel_4.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("��ҩ");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			int row=table_paid.getSelectedRow();
			if(row==-1)
				JOptionPane.showMessageDialog(table_paid, "��ѡ��Ҫ�õ�ҩ��");
			
			else{
				String a=table_paid.getValueAt(table_paid.getSelectedRow(), 0).toString();
				PrescriptionDaoFactory.getInstance().freePrescription((Integer.parseInt(a)));
				model1.removeRow(row);

			}
			results_paid=getselect(PrescriptionDaoFactory.getInstance().getPaid());
			model1=new DefaultTableModel(results_paid,prescriptionlist);
			table_paid.setModel(model1);//���±�1
		}

		});
		btnNewButton_2.setBounds(63, 29, 93, 23);
		panel_4.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("�˳�");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_3.setBounds(290, 62, 93, 23);
		panel_4.add(btnNewButton_3);
		
		JButton btnNewButton = new JButton("ˢ��");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				results_paid=getselect(PrescriptionDaoFactory.getInstance().getPaid());
				model1=new DefaultTableModel(results_paid,prescriptionlist);
				table_paid.setModel(model1);//���±�1
				results_unpaid=getselect(PrescriptionDaoFactory.getInstance().getUnPaidr());
				model2 = new DefaultTableModel(results_unpaid,prescriptionlist);
				table_unpaid.setModel(model2);//���±�2

		
			}
		});
		btnNewButton.setBounds(63, 62, 93, 23);
		panel_4.add(btnNewButton);
		//==============================================δ����==============================
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("δ�����", null, panel_1, null);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_1.add(scrollPane_1);
		
		results_unpaid=getselect(PrescriptionDaoFactory.getInstance().getUnPaidr());
		model2=new DefaultTableModel (results_unpaid,prescriptionlist){ 
			public boolean isCellEditable(int row,int column){
				return false;  
			}			
		};
		table_unpaid = new JTable(model2);		
		scrollPane_1.setViewportView(table_unpaid);
		
		JPanel panel = new JPanel();
		panel_1.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("ˢ��");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				results_paid=getselect(PrescriptionDaoFactory.getInstance().getPaid());
				model1=new DefaultTableModel(results_paid,prescriptionlist);
				table_paid.setModel(model1);//���±�1
				results_unpaid=getselect(PrescriptionDaoFactory.getInstance().getUnPaidr());
				model2 = new DefaultTableModel(results_unpaid,prescriptionlist);
				table_unpaid.setModel(model2);//���±�2
			}
		});
		btnNewButton_1.setBounds(76, 34, 93, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_4 = new JButton("�˳�");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_4.setBounds(210, 34, 93, 23);
		panel.add(btnNewButton_4);

		this.setSize(600,400);
		setVisible(true);
	}

	class DrugStoreClientThread extends Thread {
		// �ͱ��߳���ص�Socket
		Socket socket = null;
		ServerSocket serverSocket;
		public DrugStoreClientThread() {
						
			try {
				 serverSocket=new ServerSocket(8887);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			//��¼�ͻ��˵�����
		public void run() {
			System.out.println("�����������");
			while(true){
				//����accept()������ʼ�������ȴ��ͻ��˵�����
				try {
					socket=serverSocket.accept();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				//����һ���µ��߳�
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
				Prescription prescription = null;
				try {
					prescription = (Prescription) ois.readObject();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (prescription != null) {

					new Window_Prescribed(prescription);
				}
			}
		}
	}	
	
	
	

	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
			new Client_DrugStore();
		
	}
}
