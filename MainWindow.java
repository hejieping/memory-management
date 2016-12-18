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

		// TODO �Զ����ɵĹ��캯�����
	}

	private void Init()
	{
		// ��ʼ�����ڴ����ϵͳ�Ľ������Ӧ����
		frame = new JFrame();
		frame.setSize(800, 600);
		frame.setLocation(new Point(100, 100));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel container = (JPanel) frame.getContentPane();
		container.setOpaque(false);
		frame.getLayeredPane().setLayout(null);
		container.setLayout(null);

		// ��ӳ�ʼ�ڴ���ͼ��
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

		JLabel firstLabel = new JLabel("���������㷨");
		JLabel minLabel = new JLabel("��������㷨");
		firstLabel.setBounds(85, 100, 100, 30);
		minLabel.setBounds(85, 215, 100, 30);
		frame.getLayeredPane().add(firstLabel, new Integer(Integer.MIN_VALUE));
		frame.getLayeredPane().add(minLabel, new Integer(Integer.MIN_VALUE));
		frame.setResizable(false);
		// ��ӿ�ʼ��ť

		JButton button = new JButton("��ʼ��ʾ");
		button.setBounds(625, 500, 100, 20);
		container.add(button);
		button.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent arg0)
			{

				// ���������㷨�߳�
				ThreadAllocFirst threadAllocFirst = new ThreadAllocFirst(frame);
				threadAllocFirst.start();
				// ��������㷨�߳�
				ThreadAllocMin threadAllocMin = new ThreadAllocMin(frame);
				threadAllocMin.start();

			}
		});

		frame.setVisible(true);
	}

	public static void main(String[] args)
	{
		// TODO �Զ����ɵķ������
		MainWindow mainWindow = new MainWindow();

	}

}
