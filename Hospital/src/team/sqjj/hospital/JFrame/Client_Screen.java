package team.sqjj.hospital.JFrame;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;
import javax.swing.text.Caret;

import java.awt.event.KeyEvent;
import javax.swing.JTable;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.DropMode;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;

public class Client_Screen extends JFrame{
	
	
	public Client_Screen() {
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("科室");
		mnNewMenu.setSelectedIcon(new ImageIcon(Client_Screen.class.getResource("/javax/swing/plaf/basic/icons/JavaCup16.png")));
		mnNewMenu.setIcon(new ImageIcon(Client_Screen.class.getResource("/javax/swing/plaf/metal/icons/ocean/menu.gif")));
		menuBar.add(mnNewMenu);
		
		
		JMenu mnNewMenu_1 = new JMenu("退出");
		mnNewMenu_1.setIcon(new ImageIcon(Client_Screen.class.getResource("/javax/swing/plaf/metal/icons/ocean/close.gif")));
		menuBar.add(mnNewMenu_1);
		
		JButton btnNewButton = new JButton("退出");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				dispose();
			}
		});
		mnNewMenu_1.add(btnNewButton);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(72, 60, 400, 177);
		getContentPane().add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 210, 106);
		scrollPane.setPreferredSize(new Dimension(200,100));
		String[]str={"aa","bb","cc"};
		panel.setLayout(null);
		final JList jlist=new JList(str);
		jlist.setModel(new AbstractListModel() {
			String[] values = new String[] {"aa", "bb", "cc", "dd", "ff", "dd", "d", "s", "", "s"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(jlist);
		panel.add(scrollPane);
		
		
		
		
		
		JLabel lblNewLabel = new JLabel("选择科室");
		lblNewLabel.setBounds(54, 266, 54, 15);
		getContentPane().add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(118, 263, 65, 21);
		getContentPane().add(comboBox);
		
		this.setVisible(true);
		this.setSize(600,499);
	}
	public static void main(String[]agrs){
		new Client_Screen();
	}
}
