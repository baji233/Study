package inner;

public class Body {

	double weight=200;//����
	static String COUNTRY="china";
	//��Ա�ڲ���,����ʹ�����ַ������η�
	class Heart{
		double weight=10;
		public void run(){
			System.out.println("����������,����:"+Body.this.weight+",����:"+COUNTRY);
		}
	}
	//��̬�ڲ���,����ʹ���ⲿ���еķǾ�̬��Ա
	
	 static class Inner2{
		
		 public void test2()
		 {
			 System.out.println();
		 }
	}
	
	public void say()
	{
		System.out.println("zasdfa");
	}
	 
	public void method()
	{
		final String name="hello";
		//���巽���ڲ���,�൱���ڷ����ж����˾ֲ�����,����ʹ�÷������η�
		class Inner1{
			
			public void test1()
			{
				System.out.println("�����ڲ���,"+name+",����: "+weight);
				say();
			}
		}
		//ֻ���ڷ�����ʹ�÷����ڲ��ഴ������
		Inner1 inner=new Inner1();
		inner.test1();
		
		
	}
	
	
}
