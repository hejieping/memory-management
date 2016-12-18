package memManager;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

//首先适配算法线程
public class ThreadAllocFirst extends Thread
{

	/**
	 * @param args
	 */
	private JFrame frame;

	public ThreadAllocFirst(JFrame frame)
	{
		this.frame = frame;
	}

	public void run()
	{
		Job job1 = new Job(1, 130);
		Job job2 = new Job(2, 60);
		Job job3 = new Job(3, 100);
		Job job4 = new Job(4, 200);
		Job job5 = new Job(5, 140);
		Job job6 = new Job(6, 60);
		Job job7 = new Job(7, 50);
		java.util.List<Job> jobList = new ArrayList<Job>();
		jobList.add(job1);
		jobList.add(job2);
		jobList.add(job3);
		jobList.add(job4);
		jobList.add(job5);
		jobList.add(job6);
		jobList.add(job7);

		Memory memory = new Memory(frame);
		List<Location> list = memory.getlist();
		memory.allocFirst(job1);
		memory.allocFirst(job2);
		memory.allocFirst(job3);
		memory.remove(job2);
		memory.allocFirst(job4);
		memory.remove(job3);
		memory.remove(job1);
		memory.allocFirst(job5);
		memory.allocFirst(job6);
		memory.allocFirst(job7);
		memory.remove(job6);
		removeAllLabel(jobList);
	}

	private void removeAllLabel(List<Job> list)
	{
		for (int i = 0; i < list.size(); i++)
		{
			list.get(i).getLabel().setVisible(false);
		}
	}

}
