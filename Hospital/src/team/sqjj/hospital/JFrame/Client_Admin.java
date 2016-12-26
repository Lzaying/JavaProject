package team.sqjj.hospital.JFrame;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import java.awt.Color;
import javax.swing.border.EmptyBorder;

import team.sqjj.hospital.DaoFactory.DepartmentDaoFactory;
import team.sqjj.hospital.DaoFactory.DoctorDaoFactory;
import team.sqjj.hospital.DaoFactory.DrugDaoFactory;
import team.sqjj.hospital.model.Department;
import team.sqjj.hospital.model.Doctor;
import team.sqjj.hospital.model.Drug;

import javax.swing.JToolBar;
import javax.swing.JSplitPane;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Client_Admin extends JFrame{
	private JTextField xkr;
	private JTextField xkd;
	private JTextField zkr;
	private JTextField zkd;
	private JTextField zyz;
	private JTextField zyn;
	private JTextField xyz;
	private JTextField xyn;
	private JTextField syz;
	private JTextField zym;
	private JTextField zyj;
	private JTextField zydan;
	private JTextField zyshu;
	private JTextField zypin;
	private JTextField xym;
	private JTextField xyjia;
	private JTextField xydan;
	private JTextField xyshu;
	private JTextField xypin;
	private JTextField sym;
	public Client_Admin() {
		setTitle("\u533B\u9662\u7BA1\u7406\u5BA2\u6237\u7AEF");
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("科室管理", null, panel, "科室管理");
		panel.setLayout(null);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(0, 0, 479, 381);
		panel.add(tabbedPane_1);
		
		JPanel panel_4 = new JPanel();
		tabbedPane_1.addTab("修改科室", null, panel_4, null);
		panel_4.setLayout(null);
		
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u79D1\u5BA4\u623F\u95F4\u53F7");
		label.setBounds(42, 32, 96, 32);
		panel_4.add(label);
		
		xkr = new JTextField();
		xkr.setBounds(184, 38, 66, 21);
		panel_4.add(xkr);
		xkr.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u79D1\u5BA4\u540D\u79F0");
		lblNewLabel.setBounds(42, 95, 96, 32);
		panel_4.add(lblNewLabel);
		
		xkd = new JTextField();
		xkd.setBounds(184, 101, 66, 21);
		panel_4.add(xkd);
		xkd.setColumns(10);
		
		JLabel label_1 = new JLabel("\u8BF7\u8F93\u5165\u79D1\u5BA4\u4FE1\u606F");
		label_1.setBounds(42, 163, 96, 32);
		panel_4.add(label_1);
		
		JTextArea xki = new JTextArea();
		xki.setBounds(184, 168, 280, 112);
		panel_4.add(xki);
		
		JButton btnNewButton = new JButton("\u63D0\u4EA4");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Department dpt=new Department();
				dpt.setRoom(Integer.parseInt(xkr.getText()));
				dpt.setDepartment(xkd.getText());
				dpt.setInformation(xki.getText());
				int flag=DepartmentDaoFactory.getInstance().updateDepartment(dpt);
				if(flag==1){
					JOptionPane.showMessageDialog(null, "增加成功！");
				}
				else{
					JOptionPane.showMessageDialog(null, "增加失败，请重试！");
				}
			}
		});
		btnNewButton.setBounds(340, 310, 93, 32);
		panel_4.add(btnNewButton);
		
		JPanel panel_5 = new JPanel();
		tabbedPane_1.addTab("删除科室", null, panel_5, null);
		panel_5.setLayout(null);
		
		JLabel label_2 = new JLabel("\u8BF7\u9009\u62E9\u8981\u5220\u9664\u7684\u79D1\u5BA4");
		label_2.setBounds(42, 32, 108, 32);
		panel_5.add(label_2);
		
		JComboBox skd = new JComboBox();
		skd.setBounds(199, 38, 184, 21);
		List<Department> list=DepartmentDaoFactory.getInstance().getDepartment();
		for(int i=0;i<list.size();i++)
		{
			String str=list.get(i).getDepartment();
			skd.addItem(str);
		}
		panel_5.add(skd);
		
		JButton button = new JButton("\u5220\u9664");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int flag=0;
				flag=DepartmentDaoFactory.getInstance().delDepartment(skd.getSelectedItem().toString());
				if(flag==1){
					JOptionPane.showMessageDialog(null, "删除成功！");
				}
				else{
					JOptionPane.showMessageDialog(null, "删除失败，请重试！");
				}
			}
		});
		button.setBounds(339, 311, 93, 31);
		panel_5.add(button);
		
		JPanel panel_3 = new JPanel();
		tabbedPane_1.addTab("增加科室", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel label_3 = new JLabel("\u8BF7\u8F93\u5165\u79D1\u5BA4\u623F\u95F4\u53F7");
		label_3.setBounds(42, 32, 96, 32);
		panel_3.add(label_3);
		
		zkr = new JTextField();
		zkr.setColumns(10);
		zkr.setBounds(184, 38, 66, 21);
		panel_3.add(zkr);
		
		JLabel label_4 = new JLabel("\u8BF7\u8F93\u5165\u79D1\u5BA4\u540D\u79F0");
		label_4.setBounds(42, 95, 96, 32);
		panel_3.add(label_4);
		
		zkd = new JTextField();
		zkd.setColumns(10);
		zkd.setBounds(184, 101, 66, 21);
		panel_3.add(zkd);
		
		JLabel label_5 = new JLabel("\u8BF7\u8F93\u5165\u79D1\u5BA4\u4FE1\u606F");
		label_5.setBounds(42, 163, 96, 32);
		panel_3.add(label_5);
		
		JTextArea zki = new JTextArea();
		zki.setBounds(184, 168, 280, 112);
		panel_3.add(zki);
		
		JButton button_1 = new JButton("\u63D0\u4EA4");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Department dpt=new Department();
				dpt.setRoom(Integer.parseInt(zkr.getText()));
				dpt.setDepartment(zkd.getText());
				dpt.setInformation(zki.getText());
				int flag=0;
				flag=DepartmentDaoFactory.getInstance().addDepartment(dpt);
				if(flag==1){
					JOptionPane.showMessageDialog(null, "增加成功！");
				}
				else{
					JOptionPane.showMessageDialog(null, "增加失败，请重试！");
				}
			}
		});
		button_1.setBounds(340, 310, 93, 32);
		panel_3.add(button_1);
		
		JButton btnNewButton_1 = new JButton("\u9000\u51FA");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setBounds(342, 391, 93, 31);
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("医生管理", null, panel_1, null);
		panel_1.setLayout(null);
		
		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_2.setBounds(0, 0, 479, 381);
		panel_1.add(tabbedPane_2);
		
		JPanel panel_6 = new JPanel();
		tabbedPane_2.addTab("新增医生", null, panel_6, null);
		panel_6.setLayout(null);
		
		JLabel label_6 = new JLabel("\u8BF7\u8F93\u5165\u8BE5\u533B\u751F\u767B\u9646\u8D26\u53F7");
		label_6.setBounds(42, 32, 120, 32);
		panel_6.add(label_6);
		
		zyz = new JTextField();
		zyz.setColumns(10);
		zyz.setBounds(184, 38, 66, 21);
		panel_6.add(zyz);
		
		JLabel label_7 = new JLabel("\u8BF7\u8F93\u5165\u533B\u751F\u59D3\u540D");
		label_7.setBounds(42, 95, 96, 32);
		panel_6.add(label_7);
		
		zyn = new JTextField();
		zyn.setBounds(184, 101, 66, 21);
		panel_6.add(zyn);
		zyn.setColumns(10);
		
		JLabel label_8 = new JLabel("\u8BF7\u9009\u62E9\u79D1\u5BA4");
		label_8.setBounds(42, 163, 96, 32);
		panel_6.add(label_8);
		
		JComboBox zyd = new JComboBox();
		zyd.setBounds(184, 169, 174, 21);
		List<Department> list1=DepartmentDaoFactory.getInstance().getDepartment();
		for(int i=0;i<list.size();i++)
		{
			String str=list.get(i).getDepartment();
			zyd.addItem(str);
		}
		panel_6.add(zyd);
		
		JButton button_3 = new JButton("\u63D0\u4EA4");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Doctor dct=new Doctor();
				dct.setDoctor_Id(zyz.getText());
				dct.setName(zyn.getText());
				dct.setDepartment_Id(DepartmentDaoFactory.getInstance().getDepartment_Id(zyd.getSelectedItem().toString()));
				int flag=0;
				flag=DoctorDaoFactory.getInstance().addDoctor(dct);
				if(flag==1){
					JOptionPane.showMessageDialog(null, "增加成功！");
				}
				else{
					JOptionPane.showMessageDialog(null, "增加失败，请重试！");
				}
			}
		});
		button_3.setBounds(340, 310, 93, 32);
		panel_6.add(button_3);
		
		JPanel panel_8 = new JPanel();
		tabbedPane_2.addTab("修改医生信息", null, panel_8, null);
		panel_8.setLayout(null);
		
		JLabel label_9 = new JLabel("\u8BF7\u8F93\u5165\u8BE5\u533B\u751F\u767B\u9646\u8D26\u53F7");
		label_9.setBounds(42, 32, 120, 32);
		panel_8.add(label_9);
		
		xyz = new JTextField();
		xyz.setColumns(10);
		xyz.setBounds(184, 38, 66, 21);
		panel_8.add(xyz);
		
		JLabel label_10 = new JLabel("\u8BF7\u8F93\u5165\u533B\u751F\u59D3\u540D");
		label_10.setBounds(42, 95, 96, 32);
		panel_8.add(label_10);
		
		xyn = new JTextField();
		xyn.setColumns(10);
		xyn.setBounds(184, 101, 66, 21);
		panel_8.add(xyn);
		
		JLabel label_11 = new JLabel("\u8BF7\u9009\u62E9\u79D1\u5BA4");
		label_11.setBounds(42, 163, 96, 32);
		panel_8.add(label_11);
		
		JComboBox xyd = new JComboBox();
		xyd.setBounds(184, 169, 174, 21);
		panel_8.add(xyd);
		
		JButton button_4 = new JButton("\u63D0\u4EA4");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Doctor dct=new Doctor();
				dct.setDoctor_Id(xyz.getText());
				dct.setName(xyn.getText());
				dct.setDepartment_Id(DepartmentDaoFactory.getInstance().getDepartment_Id(xyd.getSelectedItem().toString()));
				int flag=0;
				flag=DoctorDaoFactory.getInstance().updateDoctor(dct);
				if(flag==1){
					JOptionPane.showMessageDialog(null, "修改成功！");
				}
				else{
					JOptionPane.showMessageDialog(null, "修改失败，请重试！");
				}
			}
		});
		button_4.setBounds(339, 310, 93, 32);
		panel_8.add(button_4);
		
		JPanel panel_7 = new JPanel();
		tabbedPane_2.addTab("删除医生", null, panel_7, null);
		panel_7.setLayout(null);
		
		JLabel label_12 = new JLabel("\u8BF7\u8F93\u5165\u8BE5\u533B\u751F\u767B\u9646\u8D26\u53F7");
		label_12.setBounds(42, 32, 120, 32);
		panel_7.add(label_12);
		
		syz = new JTextField();
		syz.setColumns(10);
		syz.setBounds(184, 38, 66, 21);
		panel_7.add(syz);
		
		JButton button_5 = new JButton("\u5220\u9664");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				int flag=0;
				flag=DoctorDaoFactory.getInstance().delDoctor(syz.getText());
				if(flag==1){
					JOptionPane.showMessageDialog(null, "删除成功！");
				}
				else{
					JOptionPane.showMessageDialog(null, "删除失败，请重试！");
				}
			}
		});
		button_5.setBounds(340, 310, 93, 32);
		panel_7.add(button_5);
		
		JButton button_2 = new JButton("\u9000\u51FA");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button_2.setBounds(342, 391, 93, 31);
		panel_1.add(button_2);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("药品管理", null, panel_2, null);
		panel_2.setLayout(null);
		
		JTabbedPane tabbedPane_3 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_3.setBounds(0, 0, 479, 381);
		panel_2.add(tabbedPane_3);
		
		JPanel qq = new JPanel();
		tabbedPane_3.addTab("新增药品", null, qq, null);
		qq.setLayout(null);
		
		JLabel label_13 = new JLabel("\u8BF7\u8F93\u5165\u836F\u54C1\u540D\u79F0");
		label_13.setBounds(42, 10, 90, 32);
		qq.add(label_13);
		
		JLabel label_14 = new JLabel("\u8BF7\u8F93\u5165\u836F\u54C1\u4EF7\u683C");
		label_14.setBounds(42, 64, 90, 32);
		qq.add(label_14);
		
		JLabel label_15 = new JLabel("\u8BF7\u8F93\u5165\u836F\u54C1\u5355\u4F4D");
		label_15.setBounds(42, 122, 90, 32);
		qq.add(label_15);
		
		JLabel label_16 = new JLabel("\u8BF7\u8F93\u5165\u836F\u54C1\u6570\u91CF");
		label_16.setBounds(42, 176, 90, 32);
		qq.add(label_16);
		
		JLabel label_17 = new JLabel("\u8BF7\u8F93\u5165\u836F\u54C1\u62FC\u97F3\u7801");
		label_17.setBounds(42, 233, 110, 32);
		qq.add(label_17);
		
		JButton button_6 = new JButton("\u63D0\u4EA4");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Drug dg=new Drug();
				dg.setDrug_Name(zym.getText());
				dg.setPrice(Double.parseDouble(zyj.getText()));
				dg.setUnit(zydan.getText());
				dg.setAmount(Integer.parseInt(zyshu.getText()));
				dg.setCode(zypin.getText());
				int flag=0;
				flag=DrugDaoFactory.getInstance().addDrug(dg);
				if(flag==1){
					JOptionPane.showMessageDialog(null, "增加成功！");
				}
				else{
					JOptionPane.showMessageDialog(null, "增加失败，请重试！");
				}
			}
		});
		button_6.setBounds(340, 310, 93, 32);
		qq.add(button_6);
		
		zym = new JTextField();
		zym.setColumns(10);
		zym.setBounds(162, 16, 66, 21);
		qq.add(zym);
		
		zyj = new JTextField();
		zyj.setColumns(10);
		zyj.setBounds(162, 70, 66, 21);
		qq.add(zyj);
		
		zydan = new JTextField();
		zydan.setColumns(10);
		zydan.setBounds(162, 128, 66, 21);
		qq.add(zydan);
		
		zyshu = new JTextField();
		zyshu.setColumns(10);
		zyshu.setBounds(162, 182, 66, 21);
		qq.add(zyshu);
		
		zypin = new JTextField();
		zypin.setColumns(10);
		zypin.setBounds(162, 239, 66, 21);
		qq.add(zypin);
		
		JPanel panel_10 = new JPanel();
		tabbedPane_3.addTab("修改药品信息", null, panel_10, null);
		panel_10.setLayout(null);
		
		JLabel label_18 = new JLabel("\u8BF7\u8F93\u5165\u836F\u54C1\u540D\u79F0");
		label_18.setBounds(42, 10, 90, 32);
		panel_10.add(label_18);
		
		JLabel label_19 = new JLabel("\u8BF7\u8F93\u5165\u836F\u54C1\u4EF7\u683C");
		label_19.setBounds(42, 64, 90, 32);
		panel_10.add(label_19);
		
		JLabel label_20 = new JLabel("\u8BF7\u8F93\u5165\u836F\u54C1\u5355\u4F4D");
		label_20.setBounds(42, 122, 90, 32);
		panel_10.add(label_20);
		
		JLabel label_21 = new JLabel("\u8BF7\u8F93\u5165\u836F\u54C1\u6570\u91CF");
		label_21.setBounds(42, 176, 90, 32);
		panel_10.add(label_21);
		
		JLabel label_22 = new JLabel("\u8BF7\u8F93\u5165\u836F\u54C1\u62FC\u97F3\u7801");
		label_22.setBounds(42, 233, 110, 32);
		panel_10.add(label_22);
		
		xym = new JTextField();
		xym.setColumns(10);
		xym.setBounds(162, 16, 66, 21);
		panel_10.add(xym);
		
		xyjia = new JTextField();
		xyjia.setColumns(10);
		xyjia.setBounds(162, 70, 66, 21);
		panel_10.add(xyjia);
		
		xydan = new JTextField();
		xydan.setColumns(10);
		xydan.setBounds(162, 128, 66, 21);
		panel_10.add(xydan);
		
		xyshu = new JTextField();
		xyshu.setColumns(10);
		xyshu.setBounds(162, 182, 66, 21);
		panel_10.add(xyshu);
		
		xypin = new JTextField();
		xypin.setColumns(10);
		xypin.setBounds(162, 239, 66, 21);
		panel_10.add(xypin);
		
		JButton button_8 = new JButton("\u63D0\u4EA4");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Drug dg=new Drug();
				dg.setDrug_Name(xym.getText());
				dg.setPrice(Double.parseDouble(xyjia.getText()));
				dg.setUnit(xydan.getText());
				dg.setAmount(Integer.parseInt(xyshu.getText()));
				dg.setCode(xypin.getText());
				int flag=0;
				flag=DrugDaoFactory.getInstance().updateDrug(dg);
				if(flag==1){
					JOptionPane.showMessageDialog(null, "修改成功！");
				}
				else{
					JOptionPane.showMessageDialog(null, "修改失败，请重试！");
				}
			}
		});
		button_8.setBounds(341, 310, 93, 32);
		panel_10.add(button_8);
		
		JPanel panel_11 = new JPanel();
		tabbedPane_3.addTab("删除药品", null, panel_11, null);
		panel_11.setLayout(null);
		
		JLabel label_23 = new JLabel("\u8BF7\u8F93\u5165\u836F\u54C1\u540D\u79F0");
		label_23.setBounds(42, 10, 90, 32);
		panel_11.add(label_23);
		
		sym = new JTextField();
		sym.setColumns(10);
		sym.setBounds(162, 16, 66, 21);
		panel_11.add(sym);
		
		JButton button_9 = new JButton("\u63D0\u4EA4");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				int flag=0;
				flag=DrugDaoFactory.getInstance().delDrug(sym.getText());
				if(flag==1){
					JOptionPane.showMessageDialog(null, "删除成功！");
				}
				else{
					JOptionPane.showMessageDialog(null, "删除失败，请重试！");
				}
			}
		});
		button_9.setBounds(340, 310, 93, 32);
		panel_11.add(button_9);
		
		JButton button_7 = new JButton("\u9000\u51FA");
		button_7.setBounds(343, 391, 93, 31);
		panel_2.add(button_7);
		
		JPanel panel_12 = new JPanel();
		tabbedPane.addTab("大屏管理", null, panel_12, null);
		panel_12.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("\u5F00\u542F\u6EDA\u52A8\u5927\u5C4F");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_2.setBounds(169, 114, 151, 23);
		panel_12.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u5173\u95ED\u6EDA\u52A8\u5927\u5C4F");
		btnNewButton_3.setBounds(169, 201, 151, 23);
		panel_12.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("\u9000\u51FA\u7CFB\u7EDF");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_4.setBounds(169, 290, 151, 23);
		panel_12.add(btnNewButton_4);
		
		this.setVisible(true);
		this.setSize(500, 500);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
	public static void main(String[]agrs){
		new Client_Admin();
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
	}
}
