package memManager;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainWindow
{

	/**
	 * @param args
	 */
	public JFrame frame;

	public MainWindow()
	{
		Init();

		// TODO 自动生成的构造函数存根
	}

	private void Init()
	{
		// 初始化该内存分配系统的界面和相应数据
		frame = new JFrame();
		frame.setSize(800, 600);
		frame.setLocation(new Point(100, 100));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel container = (JPanel) frame.getContentPane();
		container.setOpaque(false);
		frame.getLayeredPane().setLayout(null);
		container.setLayout(null);

		// 添加初始内存块的图像
		ImageIcon icon1 = new ImageIcon(getClass()
				.getResource("background.png"));
		ImageIcon icon2 = new ImageIcon(getClass()
				.getResource("background.png"));
		JLabel backgroundJLabel1 = new JLabel(icon1);
		JLabel backgroundJLabel2 = new JLabel(icon2);

		backgroundJLabel1.setBounds(85, 132, 640, 80);
		frame.getLayeredPane().add(backgroundJLabel1,
				new Integer(Integer.MIN_VALUE));
		backgroundJLabel2.setBounds(85, 252, 640, 80);
		frame.getLayeredPane().add(backgroundJLabel2,
				new Integer(Integer.MIN_VALUE));

		JLabel firstLabel = new JLabel("首先适配算法");
		JLabel minLabel = new JLabel("最佳适配算法");
		firstLabel.setBounds(85, 100, 100, 30);
		minLabel.setBounds(85, 215, 100, 30);
		frame.getLayeredPane().add(firstLabel, new Integer(Integer.MIN_VALUE));
		frame.getLayeredPane().add(minLabel, new Integer(Integer.MIN_VALUE));
		frame.setResizable(false);
		// 添加开始按钮

		JButton button = new JButton("开始演示");
		button.setBounds(625, 500, 100, 20);
		container.add(button);
		button.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent arg0)
			{

				// 首先适配算法线程
				ThreadAllocFirst threadAllocFirst = new ThreadAllocFirst(frame);
				threadAllocFirst.start();
				// 最佳适配算法线程
				ThreadAllocMin threadAllocMin = new ThreadAllocMin(frame);
				threadAllocMin.start();

			}
		});

		frame.setVisible(true);
	}

	public static void main(String[] args)
	{
		// TODO 自动生成的方法存根
		MainWindow mainWindow = new MainWindow();

	}

}
