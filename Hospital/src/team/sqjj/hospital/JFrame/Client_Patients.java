package hospital;

import java.util.HashMap;
import java.util.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;


import java.awt.*;

public class Client_Patients extends JFrame{
	Map map=new HashMap();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JButton buttonadd;
	private JButton buttonclose;
	public Client_Patients() {
		
		final BorderLayout borderLayout = new BorderLayout();
		getContentPane().setLayout(borderLayout);
								
		setTitle("病人信息添加");
		this.setSize(600, 360);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 10, 5, 10));// 设置窗体标题－－－必须
		final GridLayout gridLayout = new GridLayout(0, 2);
		gridLayout.setVgap(5);
		gridLayout.setHgap(5);
		
		panel.setLayout(gridLayout);
		getContentPane().add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("\u59D3\u540D\uFF1A");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		
		JLabel lblNewLabel = new JLabel("\u6027\u522B:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("\u7537");
		panel_1.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("\u5973");
		panel_1.add(rdbtnNewRadioButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u5E74\u9F84");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u662F\u5426\u5DF2\u5A5A");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_3);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("\u662F");
		panel_2.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("\u5426");
		panel_2.add(rdbtnNewRadioButton_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u624B\u673A\u53F7");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("\u5BB6\u5EAD\u4F4F\u5740");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_5);
		
		textField_5 = new JTextField();
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("\u9009\u62E9\u79D1\u5BA4");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_6);
		
		JComboBox comboBox = new JComboBox();
		panel.add(comboBox);
		
		map=new HashMap();
		final JPanel panel_3 = new JPanel();
		panel_1.setBorder(new LineBorder(SystemColor.activeCaptionBorder, 1, false));
		getContentPane().add(panel_3, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		panel_3.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u53D6\u6D88");
		panel_3.add(btnNewButton_1);
		this.setVisible(true);
		
	}
	
	
	public static void main(String[] args){
		new Client_Patients();
	}
}
