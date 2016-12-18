package memManager;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

//作业类
public class Job
{
	private JLabel label; // 作业在GUI上显示的图片
	private int length; // 该作业所占的内存大小
	private int ID; // 作业的ID号

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
