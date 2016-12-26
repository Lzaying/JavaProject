package team.sqjj.hospital.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.SwingConstants;

import team.sqjj.hospital.DaoFactory.UserDaoFactory;
import team.sqjj.hospital.model.User;

import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;

public class Login extends JFrame implements ActionListener{
	private JTextField textField;
	private JButton doc;
	private JPasswordField passwordField;
	public Login() {
		super("登录");
			
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("用户名");
		lblNewLabel.setBounds(54, 52, 54, 15);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("密码");
		lblNewLabel_1.setBounds(54, 92, 54, 15);
		getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(118, 49, 143, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		doc = new JButton("登录");
		doc.setBounds(52, 156, 93, 23);
		getContentPane().add(doc);
		doc.addActionListener(this);
		
		JButton btnNewButton_1 = new JButton("退出");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(168, 156, 93, 23);
		getContentPane().add(btnNewButton_1);

		
		JLabel lblNewLabel_2 = new JLabel("医院管理系统");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("华文新魏", Font.PLAIN, 21));
		lblNewLabel_2.setBounds(96, 10, 177, 29);
		getContentPane().add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(118, 89, 143, 21);
		getContentPane().add(passwordField);
		
		this.setVisible(true);
		this.setSize(400, 300);
			
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub		
		if(e.getSource()==doc){


			if(textField.getText().length()==0){
				JOptionPane.showMessageDialog(this, "用户名不能为空！");
			}
			else if(passwordField.getPassword().length==0){
				JOptionPane.showMessageDialog(this, "密码不能为空！");
			}else{
				String username=textField.getText();
				String password=passwordField.getPassword().toString();
				User user=	UserDaoFactory.getInstance().getById(username);
				if(user!=null&&user.getPassword()==password){
					if(user.getRole()==0){new Client_Admin();}
					else if(user.getRole()==1){new Client_Register();}
					else if(user.getRole()==2){new Client_Doctor(username);}
					else if(user.getRole()==3){new Client_Dean();}
					else if(user.getRole()==4){new Client_DrugStore();}
				}
				else{
					JOptionPane.showMessageDialog(this, "用户名或密码错误！请重试");
				}
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Login();
	}
}
