package exception.work;

public class LongRiver extends River{

	private int currentLevel;
	private int warmLevel;
	
	public LongRiver(int currentLevel,int warmLevel)
	{
		this.currentLevel=currentLevel;
		this.warmLevel=warmLevel;
	}
	public void flow()throws Exception {
		if(currentLevel-warmLevel>2)
		{
			throw new RiverException("���������ˣ����й�����");
		}else{
			System.out.println("��ȫ....");
		}
		
	}

	
}
