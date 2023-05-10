package number.demo;

public class FloatDemo {

	public static void demo1()
	{
		//Float f=12.5f;
		//错误,自动装箱的过程中,基本类型的值只能向对应的包装类转型
		//Double f2=12.5f;
		//通过字符串创建Float对象的时候,字符串内容可以是float类型的兼容类型
		Float f=new Float("12.5f");
		//Float和Double的valueOf特点,没有在-128~127缓存对象，每次新建不同的对象
		Float f1=Float.valueOf(12f);
		Float f2=Float.valueOf(12f);
		System.out.println(f1==f2);
		
		float f3=Float.parseFloat("12.5");
		double f4=Double.parseDouble("12.5");
		
		float f5=f1+f2;
		System.out.println(f5);
	}
	/**
	 * Boolean
	 * valueOf方法缓存了两个对象,true和false的包装类对象
	 * @param args
	 */
	public static void demo2()
	{
		//创建对象的方式
		Boolean b1=new Boolean(true);
		//带字符串的构造函数,字符串内容为null,true,false
		Boolean b2=new Boolean("null");
		Boolean b3=Boolean.valueOf(true);
		Boolean b4=Boolean.valueOf("true");
		System.out.println(b3==b4);
		Boolean b5=Boolean.parseBoolean("false");
		
	}
	
	
	
	public static void main(String[] args) {
		demo2();
	}
}
