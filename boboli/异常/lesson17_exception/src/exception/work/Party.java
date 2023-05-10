package exception.work;

public class Party {

	public static void main(String[] args) throws Exception{
		try {
			River river = new LongRiver(10, 5);
			river.flow();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			System.out.println("共产党不想处理....");
			//throw e;
		}
	}
}
