package team.sqjj.hospital.JFrame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JSplitPane;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class Client_Doctor extends JFrame implements ActionListener{
	private JTextField txtFf;
	private JButton mkdrug;
	
	public Client_Doctor() {
		super("ҽ��");
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("���ң�");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 18));
		lblNewLabel.setBounds(43, 19, 113, 48);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ҽ����");
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(346, 19, 86, 48);
		getContentPane().add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(35, 98, 331, 316);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("��ǰ���ˣ�");
		lblNewLabel_2.setBounds(10, 10, 109, 15);
		panel.add(lblNewLabel_2);
		
		txtFf = new JTextField();
		txtFf.setText("ff");
		txtFf.setEditable(false);
		txtFf.setBounds(10, 35, 293, 21);
		panel.add(txtFf);
		txtFf.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("���˶��У�");
		lblNewLabel_3.setBounds(10, 75, 71, 15);
		panel.add(lblNewLabel_3);
		
		JTextPane patients_list = new JTextPane();
		patients_list.setText("1 s\r\n2 j\r\n3 q\r\n4 q");
		patients_list.setEditable(false);
		patients_list.setBounds(10, 100, 293, 178);
		panel.add(patients_list);
		
		mkdrug = new JButton("��ҩ");
		mkdrug.setBounds(432, 227, 93, 23);
		getContentPane().add(mkdrug);
		mkdrug.addActionListener(this);
		
		JButton btnNewButton_1 = new JButton("�˳�");
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
		if(e.getSource()==mkdrug)new Window_Prescribe();
	}



	

}
