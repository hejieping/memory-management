package memManager;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

//��ҵ��
public class Job
{
	private JLabel label; // ��ҵ��GUI����ʾ��ͼƬ
	private int length; // ����ҵ��ռ���ڴ��С
	private int ID; // ��ҵ��ID��

	public Job(int ID, int length)
	{
		this.ID = ID;
		this.length = length;

		String imagePath = new String("job");
		imagePath += Integer.toString(ID);
		imagePath += ".png";
		ImageIcon icon = new ImageIcon(getClass().getResource(imagePath));
		label = new JLabel(icon);
		// TODO Auto-generated constructor stub
	}

	public int getID()
	{
		return ID;
	}

	public int getlength()
	{
		return length;
	}

	public JLabel getLabel()
	{
		return label;
	}

}
