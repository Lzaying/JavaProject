package team.sqjj.hospital.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Login extends JFrame implements ActionListener{
	private JTextField textField;
	private JTextField textField_1;
	private JButton doc;
	private final Action action = new SwingAction();
	public Login() {
		super("登录");
			
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("用户名");
		lblNewLabel.setBounds(41, 52, 54, 15);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("密码");
		lblNewLabel_1.setBounds(41, 77, 54, 15);
		getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				textField_1.setText("密码不用输了");
			}
		});
		textField.setBounds(105, 49, 143, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(105, 74, 143, 21);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		doc = new JButton("登录");
		doc.setBounds(31, 156, 93, 23);
		getContentPane().add(doc);
		doc.addActionListener(this);
		
		JButton btnNewButton_1 = new JButton("退出");
		btnNewButton_1.setAction(action);
		btnNewButton_1.setBounds(155, 156, 93, 23);
		getContentPane().add(btnNewButton_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("\u533B\u751F");
		rdbtnNewRadioButton.setBounds(19, 115, 63, 23);
		getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("\u9662\u957F");
		rdbtnNewRadioButton_1.setBounds(96, 115, 63, 23);
		getContentPane().add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("\u836F\u5E08");
		rdbtnNewRadioButton_2.setBounds(168, 115, 63, 23);
		getContentPane().add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("\u6536\u8D39");
		rdbtnNewRadioButton_3.setBounds(233, 115, 63, 23);
		getContentPane().add(rdbtnNewRadioButton_3);
		
		JLabel lblNewLabel_2 = new JLabel("医院管理系统");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("华文新魏", Font.PLAIN, 21));
		lblNewLabel_2.setBounds(96, 10, 177, 29);
		getContentPane().add(lblNewLabel_2);
		
		this.setVisible(true);
		this.setSize(400, 300);
			
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Login();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==doc){
			new Client_Doctor();
			new Client_Dean();
			new Client_Patients();
			new Client_Admin();
		}
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
