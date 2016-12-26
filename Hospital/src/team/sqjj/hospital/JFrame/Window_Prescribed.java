package team.sqjj.hospital.JFrame;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import team.sqjj.hospital.model.Prescription;
import team.sqjj.hospital.model.PrescriptionItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Window_Prescribed extends JFrame{
	
	private JTable table_newlist;
	private JTextField textField;
	private Object[][] getselect(List list){
		Object[][] s = new Object[list.size()][2];
		for (int i = 0; i < list.size(); i++) {
			PrescriptionItem prescribeitem = (PrescriptionItem) list.get(i);
			s[i][0] = prescribeitem.getDrug_id();				
			s[i][1] = prescribeitem.getQuantity();
			
		}
		return s;
	}
	public Window_Prescribed(Prescription prescription) {
		super("新药单");
		
		this.setVisible(true);
		this.setSize(400, 400);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 332, 34);
		getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("订单号");
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setText(""+prescription.getPrescription_Id());
		textField.setEditable(false);
		panel.add(textField);
		textField.setColumns(15);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 54, 332, 192);
		getContentPane().add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane);
		String[] newlist={"药品编号","药品数量"};
		String qin1="";
		Object[][] results_paid=getselect(prescription.getPrescription_Item());
		table_newlist= new JTable(results_paid,newlist);
		table_newlist.setVisible(true);
		scrollPane.setViewportView(table_newlist);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 266, 332, 55);
		getContentPane().add(panel_2);
		
		JButton btnNewButton = new JButton("确定");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
		
			}
		});
		panel_2.add(btnNewButton);
		
		this.setVisible(true);
		this.setSize(370, 400);
		
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
}
