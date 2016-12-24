package team.sqjj.hospital.JFrame;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.*;
import javax.swing.*;

import team.sqjj.hospital.DaoImpl.PrescribeDaoImpl;
import team.sqjj.hospital.model.Prescribe;
import team.sqjj.hospital.DaoFactory.*;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

public class Client_DrugStore extends JFrame{
	private JTable table_1,table_2,table_3;
	private JScrollPane scrollPane;

	
	private Object[][] getselect(List list){
		Object[][] s = new Object[list.size()][4];
		for (int i = 0; i < list.size(); i++) {
			Prescribe prescribe = (Prescribe) list.get(i);
			s[i][0] = prescribe.getId();				
			s[i][1] = prescribe.getDrug_Name();
			s[i][2] = prescribe.getDrug_Id();
			s[i][3] = prescribe.getPatient_Id();
		}
		return s;
	}
	
	
	public Client_DrugStore() {
		super("药房端");
		final JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.setPreferredSize(new Dimension(0, 50));
		getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("待抓药订单", null, panel, null);
		panel.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(21, 0, 448, 143);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(174, 29, 264, 104);
		panel_3.add(textPane);
		
		JLabel lblNewLabel = new JLabel("订单队列");
		lblNewLabel.setBounds(65, 52, 99, 35);
		panel_3.add(lblNewLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(21, 202, 450, 123);
		scrollPane.setPreferredSize(new Dimension(450, 250));
		panel.add(scrollPane);
		
		String qin=null;//需要病人id，下面调用的不对
		 String [] druglist = { "简码", "名称", "单价", "单位","数量" };
		Object[][] results=getselect(PrescribeDaoFactory.getInstance().getByPatientID(qin));		
		table_1 = new JTable(results,druglist);
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		
		table_1.setAutoResizeMode(WIDTH);
		scrollPane.setViewportView(table_1);
		
		JButton btnNewButton = new JButton("抓药");
		btnNewButton.setBounds(246, 169, 93, 23);
		panel.add(btnNewButton);
		
		
		JButton btnNewButton_1 = new JButton("退出");
		btnNewButton_1.setBounds(349, 169, 93, 23);
		panel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("未付款订单", null, panel_1, null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_1.add(scrollPane_1);
		
		String sun=null;//需要病人id,下面调用的不对
		 String [] druglist_2 = { "药单号", "病人姓名", "医生姓名", "总额"};
		Object[][] results_2=getselect(PrescribeDaoFactory.getInstance().getByPatientID(sun));		
		table_2 = new JTable(results_2,druglist_2);
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"\u836F\u5355\u53F7", "\u75C5\u4EBA\u59D3\u540D", "\u533B\u751F\u59D3\u540D", "\u603B\u989D"
			}
		));
		table_2.getColumnModel().getColumn(0).setMinWidth(16);
		table_2.getColumnModel().getColumn(3).setPreferredWidth(76);
		table_2.getColumnModel().getColumn(3).setMinWidth(20);
		scrollPane_1.setViewportView(table_2);
		
		
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("可发药单", null, panel_2, null);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(6, 10, 452, 268);
		panel_2.add(scrollPane_3);
		String li=null;//需要病人id,下面调用的不对
		 String [] druglist_3 = { "药单号", "病人姓名", "医生姓名", "总额"};
		Object[][] results_3=getselect(PrescribeDaoFactory.getInstance().getByPatientID(li));		
		table_3 = new JTable(results_3,druglist_3);
		table_3.setVisible(true);
		scrollPane_3.setViewportView(table_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 297, 448, 126);
		panel_2.add(panel_4);
		panel_4.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("发药");
		btnNewButton_2.setBounds(333, 22, 93, 23);
		panel_4.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("退出");
		btnNewButton_3.setBounds(333, 63, 93, 23);
		panel_4.add(btnNewButton_3);
		
		this.setSize(500,500);
		setVisible(true);
	}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			new Client_DrugStore();
	}
}
