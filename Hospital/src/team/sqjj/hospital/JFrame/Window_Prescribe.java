package team.sqjj.hospital.JFrame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JList;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Window_Prescribe extends JFrame{
	private JTextField textField;
	private JTextField textField_1;
	public Window_Prescribe() {
		super("¿ªÒ©");
		
		
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(25, 186, 356, 160);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(0, 0, 346, 160);
		panel.add(textPane);
		
		JLabel lblNewLabel = new JLabel("\u836F\u54C1\u7B80\u7801");
		lblNewLabel.setBounds(25, 130, 48, 15);
		getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("\u836F\u540D");
		label.setBounds(109, 130, 29, 15);
		getContentPane().add(label);
		
		JLabel lblNewLabel_1 = new JLabel("\u6570\u91CF");
		lblNewLabel_1.setBounds(163, 130, 35, 15);
		getContentPane().add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(25, 155, 55, 21);
		getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(90, 155, 63, 21);
		getContentPane().add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();		
		comboBox_2.setBounds(163, 155, 29, 21);
		getContentPane().add(comboBox_2);
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(288, 153, 93, 23);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("\u5F00\u836F");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("ËÎÌå", Font.PLAIN, 18));
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
		
		JButton btnNewButton_2 = new JButton("\u786E\u5B9A");
		btnNewButton_2.setBounds(381, 244, 93, 23);
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u9000\u51FA");
		btnNewButton_3.setBounds(381, 291, 93, 23);
		getContentPane().add(btnNewButton_3);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(109, 46, 99, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(109, 71, 99, 21);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		
		this.setVisible(true);
		this.setSize(500, 500);
		this.setLocation(900, 100);
	}
}
