package team.sqjj.hospital.JFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Client_Register extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	public Client_Register() {
		super("门诊挂号收费端。。。");
		getContentPane().setLayout(null);

		JPanel panel_ = new JPanel();
		panel_.setBorder(new LineBorder(Color.BLACK));
		panel_.setBounds(10, 10, 380, 370);
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
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
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

		textField_2 = new JTextField();
		textField_2.setBounds(56, 172, 66, 21);
		panel_.add(textField_2);
		textField_2.setColumns(10);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("\u7537");
		rdbtnNewRadioButton.setBounds(56, 132, 66, 23);
		panel_.add(rdbtnNewRadioButton);

		JRadioButton radioButton = new JRadioButton("\u5973");
		radioButton.setBounds(130, 132, 60, 23);
		panel_.add(radioButton);

		JLabel label = new JLabel("\u5A5A\u5426");
		label.setBounds(173, 178, 54, 15);
		panel_.add(label);

		JCheckBox checkBox = new JCheckBox("\u5DF2\u5A5A");
		checkBox.setBounds(233, 174, 103, 23);
		panel_.add(checkBox);

		JLabel label_2 = new JLabel("\u8054\u7CFB\u65B9\u5F0F");
		label_2.setBounds(10, 216, 54, 15);
		panel_.add(label_2);

		textField_3 = new JTextField();
		textField_3.setBounds(70, 213, 134, 21);
		panel_.add(textField_3);
		textField_3.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("\u5BB6\u5EAD\u4F4F\u5740");
		lblNewLabel_4.setBounds(10, 254, 54, 15);
		panel_.add(lblNewLabel_4);

		textField_4 = new JTextField();
		textField_4.setBounds(70, 251, 134, 21);
		panel_.add(textField_4);
		textField_4.setColumns(10);

		JLabel label_3 = new JLabel("\u9009\u62E9\u79D1\u5BA4");
		label_3.setBounds(10, 296, 54, 15);
		panel_.add(label_3);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(90, 293, 32, 21);
		panel_.add(comboBox);

		JLabel label_4 = new JLabel("\u60A8\u7684\u533B\u751F\u4E3A");
		label_4.setBounds(173, 296, 74, 15);
		panel_.add(label_4);

		textField_5 = new JTextField();
		textField_5.setBounds(257, 293, 66, 21);
		panel_.add(textField_5);
		textField_5.setColumns(10);

		JButton button_1 = new JButton("\u786E\u8BA4");
		button_1.setBounds(134, 337, 93, 23);
		panel_.add(button_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(400, 10, 221, 370);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("收费端");
		lblNewLabel_1.setBounds(79, 5, 63, 21);
		lblNewLabel_1.setFont(new Font("华文新魏", Font.BOLD, 20));
		panel_1.add(lblNewLabel_1);

		JButton button = new JButton("确认收费");
		button.setBounds(67, 266, 93, 23);
		panel_1.add(button);

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

		textField_6 = new JTextField();
		textField_6.setBounds(67, 81, 66, 21);
		panel_1.add(textField_6);
		textField_6.setColumns(10);

		textField_7 = new JTextField();
		textField_7.setBounds(67, 122, 66, 21);
		panel_1.add(textField_7);
		textField_7.setColumns(10);

		textField_8 = new JTextField();
		textField_8.setBounds(67, 173, 66, 21);
		panel_1.add(textField_8);
		textField_8.setColumns(10);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Client_Register();
	}
}
