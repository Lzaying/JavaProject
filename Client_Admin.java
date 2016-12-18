package team.sqjj.hospital.JFrame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;

public class Client_Admin extends JFrame{
	private final Action action = new SwingAction();
	
	public Client_Admin() {
		super("管理端");
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("系统管理端");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		lblNewLabel.setBounds(123, 10, 186, 35);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_4 = new JButton("退出");
	
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_4.setBounds(300, 199, 93, 29);
		getContentPane().add(btnNewButton_4);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("宋体", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"增加科室", "修改科室", "删除科室"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(64, 109, 85, 35);
		getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("宋体", Font.PLAIN, 15));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"增加医生", "修改医生信息", "删除医生"}));
		comboBox_1.setBounds(178, 109, 85, 35);
		getContentPane().add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("宋体", Font.PLAIN, 15));
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"增加药品", "修改药品", "删除药品"}));
		comboBox_2.setBounds(300, 109, 85, 35);
		getContentPane().add(comboBox_2);
		
		JLabel lblNewLabel_1 = new JLabel("科室管理");
		lblNewLabel_1.setBounds(68, 84, 54, 15);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("医生管理");
		lblNewLabel_2.setBounds(183, 84, 54, 15);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("药品管理");
		lblNewLabel_3.setBounds(305, 84, 54, 15);
		getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("关闭系统");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setAction(action);
		btnNewButton.setBounds(170, 199, 93, 29);
		getContentPane().add(btnNewButton);
		
		
		this.setSize(500,300);
		this.setVisible(true);;
		this.setLocation(690, 500);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "关闭系统");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			
			System.exit(0);
		}
	}
	
}
