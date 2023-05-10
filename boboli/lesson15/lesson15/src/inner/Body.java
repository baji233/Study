package inner;

public class Body {

	double weight=200;//体重
	static String COUNTRY="china";
	//成员内部类,可以使用四种访问修饰符
	class Heart{
		double weight=10;
		public void run(){
			System.out.println("心脏在跳动,体重:"+Body.this.weight+",国家:"+COUNTRY);
		}
	}
	//静态内部类,不能使用外部类中的非静态成员
	
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
		//定义方法内部类,相当于在方法中定义了局部变量,不能使用访问修饰符
		class Inner1{
			
			public void test1()
			{
				System.out.println("方法内部类,"+name+",体重: "+weight);
				say();
			}
		}
		//只能在方法中使用方法内部类创建对象
		Inner1 inner=new Inner1();
		inner.test1();
		
		
	}
	
	
}
