package memManager;

//�ڴ���࣬
public class Location
{

	/**
	 * @param args
	 */
	private int start; // �ڴ����ʼλ��
	private int end; // �ڴ����ֹλ��
	private int ID; // ���ڴ������ҵ�����IDΪ��ҵID
	private boolean full; // ��¼�ڴ���Ƿ���ҵռ��

	public Location(int s, int e, int I, boolean full)
	{
		// TODO �Զ����ɵĹ��캯�����
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
