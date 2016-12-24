package team.sqjj.hospital.JFrame;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JSplitPane;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JComboBox;
import java.awt.FlowLayout;

public class Example extends JFrame{
	public Example() {
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("科室管理", null, panel, "科室管理");
		panel.setLayout(null);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(0, 0, 479, 268);
		panel.add(tabbedPane_1);
		
		JPanel panel_4 = new JPanel();
		tabbedPane_1.addTab("修改科室", null, panel_4, null);
		
		JPanel panel_5 = new JPanel();
		tabbedPane_1.addTab("删除科室", null, panel_5, null);
		
		JButton btnNewButton = new JButton("New button");
		panel_5.add(btnNewButton);
		
		JPanel panel_3 = new JPanel();
		tabbedPane_1.addTab("增加科室", null, panel_3, null);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("医生管理", null, panel_1, null);
		panel_1.setLayout(null);
		
		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_2.setBounds(0, 0, 469, 269);
		panel_1.add(tabbedPane_2);
		
		JPanel panel_6 = new JPanel();
		tabbedPane_2.addTab("新增医生", null, panel_6, null);
		
		JPanel panel_8 = new JPanel();
		tabbedPane_2.addTab("修改医生信息", null, panel_8, null);
		
		JPanel panel_7 = new JPanel();
		tabbedPane_2.addTab("删除医生", null, panel_7, null);
		panel_7.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(196, 5, 32, 21);
		panel_7.add(comboBox);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("药品管理", null, panel_2, null);
		panel_2.setLayout(null);
		
		JTabbedPane tabbedPane_3 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_3.setBounds(0, 0, 479, 218);
		panel_2.add(tabbedPane_3);
		
		JPanel panel_9 = new JPanel();
		tabbedPane_3.addTab("新增药品", null, panel_9, null);
		
		JPanel panel_10 = new JPanel();
		tabbedPane_3.addTab("修改药品信息", null, panel_10, null);
		
		JPanel panel_11 = new JPanel();
		tabbedPane_3.addTab("删除药品", null, panel_11, null);
		
		this.setVisible(true);
		this.setSize(500, 500);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
	public static void main(String[]agrs){
		new Example();
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
	}
}
