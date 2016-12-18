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
		memoryList.add(new Location(0, 640, 0, false));// 初始分配一块大小为640的内存块
		this.frame = frame;
		panel = (JPanel) frame.getContentPane();

		// TODO Auto-generated constructor stub
	}

	// 线程挂起一秒钟
	private void pause()
	{
		try
		{
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e)
		{
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	// 检查该作业被释放后，所在的内存块是否可以和邻边的未使用的内存块合并
	private void check_merge(int index)
	{
		// 检查后相邻内存块
		if (memoryList.get(index + 1).isFull() == false)
		{
			memoryList.get(index).setEnd(memoryList.get(index + 1).getEnd());
			memoryList.remove(index + 1);
		}
		// 检查前相邻内存块
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

	// 首次适应算法搜索合适的内存块进行分配
	public boolean allocFirst(Job job)
	{
		// 从表头开始检查内存块链表里面是否有空内存块且可以容下Job
		for (int i = 0; i < memoryList.size(); i++)
		{
			if (memoryList.get(i).Length() >= job.getlength()
					&& memoryList.get(i).isFull() == false)
			{

				System.out.println("作业" + job.getID() + "插入成功");

				addLabel(job.getLabel(), memoryList.get(i).getStart(), true);// 找到合适的空内存块，插入作业图像

				// 空内存划分成两部分，一部分大小为job的大小，提供给job使用，另一部分为空，即空内存割出一部分给job使用
				Location location = new Location(memoryList.get(i).getStart(),
						memoryList.get(i).getStart() + job.getlength(),
						job.getID(), true);
				memoryList.get(i).setStart(
						memoryList.get(i).getStart() + job.getlength());// 从该空内存分配内存给job，该空内存快自身大小减少
				memoryList.add(i, location);// job所占内存块加入链表

				pause();
				return true;

			}

		}
		pause();
		return false;

	}

	// 最佳适配算法分配内存
	public boolean allocMin(Job job)
	{
		int index = 0;
		int length = 6400;
		// 寻找最小适合的内存块

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
			System.out.println("作业" + job.getID() + "插入成功");

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

	// 清除作业
	public boolean remove(Job job)
	{
		// 检查内存块链表里面是否存在该作业
		for (int i = 0; i < memoryList.size(); i++)
		{
			if (memoryList.get(i).getID() == job.getID())
			{
				System.out.println("作业" + job.getID() + "释放成功");
				removeLabel(job.getLabel()); // 释放作业图片
				memoryList.get(i).setFull(false); // 将所在内存块置空
				memoryList.get(i).setID(0);
				check_merge(i); // 检查被释放内存块是否可以合并
				pause();
				return true;
			}
		}
		pause();
		return false;
	}

	// 将job图像添加到frame
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

	// 删除label的图像
	private void removeLabel(JLabel label)
	{
		label.setVisible(false);
	}

}
