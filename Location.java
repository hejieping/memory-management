package memManager;

//内存块类，
public class Location
{

	/**
	 * @param args
	 */
	private int start; // 内存块起始位置
	private int end; // 内存块终止位置
	private int ID; // 若内存块有作业，则该ID为作业ID
	private boolean full; // 记录内存块是否被作业占有

	public Location(int s, int e, int I, boolean full)
	{
		// TODO 自动生成的构造函数存根
		start = s;
		end = e;
		ID = I;
		this.full = full;

	}

	public int Length()
	{
		return (end - start);
	}

	public int getStart()
	{
		return start;
	}

	public int getID()
	{
		return ID;
	}

	public boolean isFull()
	{
		return full;
	}

	public void setStart(int start)
	{
		this.start = start;

	}

	public void setFull(boolean full)
	{
		this.full = full;
	}

	public void setID(int ID)
	{
		this.ID = ID;
	}

	public void setEnd(int end)
	{
		this.end = end;
	}

	public int getEnd()
	{
		return end;
	}

}
