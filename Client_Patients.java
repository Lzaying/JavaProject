package team.sqjj.hospital.JFrame;

import java.util.HashMap;
import java.util.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;


import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Client_Patients extends JFrame{
	Map map=new HashMap();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JButton buttonadd;
	private JButton buttonclose;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_6;
	public Client_Patients() {
		super("预约");
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("病人预约信息登入");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(60, 10, 263, 29);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u59D3\u540D\uFF1A");
		lblNewLabel_1.setBounds(32, 67, 54, 15);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u6027\u522B\uFF1A");
		lblNewLabel_2.setBounds(32, 92, 54, 15);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u5E74\u9F84\uFF1A");
		lblNewLabel_3.setBounds(32, 117, 54, 15);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u51FA\u751F\u65E5\u671F\uFF1A");
		lblNewLabel_4.setBounds(32, 142, 66, 15);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\u5730\u5740\uFF1A");
		lblNewLabel_5.setBounds(32, 167, 54, 15);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("\u9009\u62E9\u79D1\u5BA4");
		lblNewLabel_6.setBounds(32, 192, 54, 15);
		getContentPane().add(lblNewLabel_6);
		
		textField_1 = new JTextField();
		textField_1.setBounds(127, 64, 66, 21);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("男");
		rdbtnNewRadioButton.setBounds(124, 88, 41, 23);
		getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("女");
		rdbtnNewRadioButton_1.setSelected(true);
		rdbtnNewRadioButton_1.setBounds(167, 88, 63, 23);
		getContentPane().add(rdbtnNewRadioButton_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("");
		comboBox.setBounds(127, 139, 61, 21);
		getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(198, 139, 45, 21);
		getContentPane().add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(253, 139, 32, 21);
		getContentPane().add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(127, 114, 45, 21);
		getContentPane().add(comboBox_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(127, 164, 209, 21);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setName("\u79D1\u5BA4");
		comboBox_4.setToolTipText("");
		comboBox_4.setBounds(127, 189, 79, 21);
		getContentPane().add(comboBox_4);
		
		JButton btnNewButton = new JButton("提交");
		btnNewButton.setBounds(32, 307, 93, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("取消");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(151, 307, 93, 23);
		getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_7 = new JLabel("联系电话");
		lblNewLabel_7.setBounds(32, 231, 54, 15);
		getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("预约时间");
		lblNewLabel_8.setBounds(32, 256, 54, 15);
		getContentPane().add(lblNewLabel_8);
		
		textField_6 = new JTextField();
		textField_6.setBounds(127, 228, 66, 21);
		getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		this.setSize(400, 400);
		this.setLocation(400, 0);
		this.setVisible(true);
		
	}
	
	
	public static void main(String[] args){
		new Client_Patients();
	}
}
