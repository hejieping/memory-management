package memManager;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Memory
{

	/**
	 * @param args
	 */
	private java.util.List<Location> memoryList;
	private JFrame frame;
	private JPanel panel;

	public List<Location> getlist()
	{
		return memoryList;
	}

	public Memory(JFrame frame)
	{
		memoryList = new ArrayList<Location>();
		memoryList.add(new Location(0, 640, 0, false));// ��ʼ����һ���СΪ640���ڴ��
		this.frame = frame;
		panel = (JPanel) frame.getContentPane();

		// TODO Auto-generated constructor stub
	}

	// �̹߳���һ����
	private void pause()
	{
		try
		{
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e)
		{
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}

	// ������ҵ���ͷź����ڵ��ڴ���Ƿ���Ժ��ڱߵ�δʹ�õ��ڴ��ϲ�
	private void check_merge(int index)
	{
		// ���������ڴ��
		if (memoryList.get(index + 1).isFull() == false)
		{
			memoryList.get(index).setEnd(memoryList.get(index + 1).getEnd());
			memoryList.remove(index + 1);
		}
		// ���ǰ�����ڴ��
		if (index != 0)
		{
			if (memoryList.get(index - 1).isFull() == false)
			{
				memoryList.get(index).setStart(
						memoryList.get(index - 1).getStart());
				memoryList.remove(index - 1);
			}
		}
	}

	// �״���Ӧ�㷨�������ʵ��ڴ����з���
	public boolean allocFirst(Job job)
	{
		// �ӱ�ͷ��ʼ����ڴ�����������Ƿ��п��ڴ���ҿ�������Job
		for (int i = 0; i < memoryList.size(); i++)
		{
			if (memoryList.get(i).Length() >= job.getlength()
					&& memoryList.get(i).isFull() == false)
			{

				System.out.println("��ҵ" + job.getID() + "����ɹ�");

				addLabel(job.getLabel(), memoryList.get(i).getStart(), true);// �ҵ����ʵĿ��ڴ�飬������ҵͼ��

				// ���ڴ滮�ֳ������֣�һ���ִ�СΪjob�Ĵ�С���ṩ��jobʹ�ã���һ����Ϊ�գ������ڴ���һ���ָ�jobʹ��
				Location location = new Location(memoryList.get(i).getStart(),
						memoryList.get(i).getStart() + job.getlength(),
						job.getID(), true);
				memoryList.get(i).setStart(
						memoryList.get(i).getStart() + job.getlength());// �Ӹÿ��ڴ�����ڴ��job���ÿ��ڴ�������С����
				memoryList.add(i, location);// job��ռ�ڴ���������

				pause();
				return true;

			}

		}
		pause();
		return false;

	}

	// ��������㷨�����ڴ�
	public boolean allocMin(Job job)
	{
		int index = 0;
		int length = 6400;
		// Ѱ����С�ʺϵ��ڴ��

		for (int i = 0; i < memoryList.size(); i++)
		{
			if (memoryList.get(i).Length() >= job.getlength()
					&& memoryList.get(i).isFull() == false
					&& memoryList.get(i).Length() < length)
			{
				index = i;
				length = memoryList.get(i).Length();
			}
		}
		if (length != 6400)
		{
			System.out.println("��ҵ" + job.getID() + "����ɹ�");

			addLabel(job.getLabel(), memoryList.get(index).getStart(), false);
			Location location = new Location(memoryList.get(index).getStart(),
					memoryList.get(index).getStart() + job.getlength(),
					job.getID(), true);
			memoryList.get(index).setStart(
					memoryList.get(index).getStart() + job.getlength());
			memoryList.add(index, location);

			pause();
			return true;
		} else
		{
			return false;
		}
	}

	// �����ҵ
	public boolean remove(Job job)
	{
		// ����ڴ�����������Ƿ���ڸ���ҵ
		for (int i = 0; i < memoryList.size(); i++)
		{
			if (memoryList.get(i).getID() == job.getID())
			{
				System.out.println("��ҵ" + job.getID() + "�ͷųɹ�");
				removeLabel(job.getLabel()); // �ͷ���ҵͼƬ
				memoryList.get(i).setFull(false); // �������ڴ���ÿ�
				memoryList.get(i).setID(0);
				check_merge(i); // ��鱻�ͷ��ڴ���Ƿ���Ժϲ�
				pause();
				return true;
			}
		}
		pause();
		return false;
	}

	// ��jobͼ����ӵ�frame
	private void addLabel(JLabel label, int start, boolean isFirst)
	{
		panel.add(label);
		if (isFirst == true)
		{
			label.setBounds(start + 84, 132, label.getIcon().getIconWidth(),
					label.getIcon().getIconHeight());
		} else
		{
			label.setBounds(start + 84, 252, label.getIcon().getIconWidth(),
					label.getIcon().getIconHeight());
		}

	}

	// ɾ��label��ͼ��
	private void removeLabel(JLabel label)
	{
		label.setVisible(false);
	}

}
