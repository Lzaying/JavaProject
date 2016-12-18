package team.sqjj.hospital.JFrame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;

public class Client_Dean extends JFrame{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private final Action action = new SwingAction();

	public Client_Dean() {
		super("院长端");
		getContentPane().setLayout(null);		
		JLabel lblNewLabel = new JLabel("院长办公室");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 19));
		lblNewLabel.setBounds(229, 10, 180, 30);
		getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 50, 175, 244);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("科室挂号量和总金额");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(0, 10, 175, 15);
		panel.add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"妇科"}));
		comboBox.setBounds(82, 35, 63, 21);
		panel.add(comboBox);
		
		JLabel lblNewLabel_2 = new JLabel("选择科室");	
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 35, 68, 21);
		panel.add(lblNewLabel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, null, null, null));
		panel_3.setBounds(20, 66, 125, 157);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(380, 50, 175, 241);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("查询药品库存");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label.setBounds(0, 10, 175, 15);
		panel_1.add(label);
		
		JLabel lblNewLabel_3 = new JLabel("选择药品");
		lblNewLabel_3.setBounds(22, 35, 54, 15);
		panel_1.add(lblNewLabel_3);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"栓黄连"}));
		comboBox_1.setBounds(73, 32, 76, 21);
		panel_1.add(comboBox_1);
		
		JLabel lblNewLabel_10 = new JLabel("库存");
		lblNewLabel_10.setBounds(22, 81, 54, 15);
		panel_1.add(lblNewLabel_10);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(73, 78, 66, 21);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(195, 50, 175, 241);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("医生就诊查询");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(10, 10, 155, 21);
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("选择科室");
		lblNewLabel_5.setBounds(10, 41, 54, 15);
		panel_2.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("选择医生");
		lblNewLabel_6.setBounds(10, 66, 54, 15);
		panel_2.add(lblNewLabel_6);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(74, 38, 73, 21);
		panel_2.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(74, 63, 73, 21);
		panel_2.add(comboBox_3);
		
		JLabel lblNewLabel_7 = new JLabel("姓名：");
		lblNewLabel_7.setBounds(10, 107, 42, 15);
		panel_2.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("就诊数：");
		lblNewLabel_8.setBounds(10, 141, 54, 15);
		panel_2.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("总金额：");
		lblNewLabel_9.setBounds(10, 180, 54, 15);
		panel_2.add(lblNewLabel_9);
		
		textField = new JTextField();	
		textField.setEditable(false);
		textField.setBounds(74, 104, 66, 21);
		panel_2.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();	
		textField_1.setEditable(false);
		textField_1.setBounds(74, 138, 66, 21);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();	
		textField_2.setEditable(false);
		textField_2.setBounds(74, 177, 66, 21);
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("退出");
		btnNewButton.setAction(action);	
		btnNewButton.setBounds(565, 227, 93, 23);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_11 = new JLabel("就诊总数");
		lblNewLabel_11.setBounds(586, 50, 54, 15);
		getContentPane().add(lblNewLabel_11);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setBounds(585, 75, 66, 21);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("总收入");
		lblNewLabel_12.setBounds(586, 106, 54, 15);
		getContentPane().add(lblNewLabel_12);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setBounds(586, 131, 66, 21);
		getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		this.setSize(690,374);
		this.setLocation(0, 400);
		this.setVisible(true);
		
	}
	
	

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "退出");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	}
}
