import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class AmericanPie {

	public AmericanPie(String title) {
		JFrame frame = new JFrame(title);
		setLAF(); // 设置风格
		frame.getContentPane().add(new PiePanel());
		init(frame);
	}

	class PiePanel extends JPanel {
		private int width = 200; // 宽
		private int height = 200; // 高
		private int originX; // 起始座标
		private int originY;

		@Override
		public void paintComponent(Graphics g) {
			originX = (this.getSize().width / 2) - (width / 2);
			originY = (this.getSize().height / 2) - (height / 2);
			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(Color.red);
			g2d.fillArc(originX, originY, width, height, 0, 72);
			g2d.setColor(Color.BLUE);
			g2d.fillArc(originX, originY, width, height, 72, 36);
			g2d.setColor(Color.GREEN);
			g2d.fillArc(originX, originY, width, height, 108, 180);
			g2d.setColor(Color.WHITE);
			g2d.fillArc(originX, originY, width, height, 216, 144);
			g2d.setColor(Color.black);
			g2d.drawString("Projects -- 20%", originX + (width * 7 / 8), originY + (height / 6));
			g2d.drawString("Quizzes -- 10%", originX + (width / 2), originY);
			g2d.drawString("Midterms -- 30%", originX - (width / 4), originY + (height / 3));
			g2d.drawString("Final -- 40%", originX + (width * 5 / 8), originY + (height * 15 / 16));
		}
	}

	private void setLAF() {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (Exception ignore) {
			}
		}
	}

	public void init(JFrame f) {
		f.setAlwaysOnTop(true);
		f.setSize(new Dimension(400, 400));
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setLocationRelativeTo(null); // 窗口居中
		f.setVisible(true);
	}

	public static void main(String[] args) {
		new AmericanPie("美国派7");
	}
}