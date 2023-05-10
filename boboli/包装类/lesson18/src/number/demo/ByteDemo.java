package number.demo;
/**
 * Byte对byte类型的值进行包装
 * 
 * 
 * @author Administrator
 *
 */
public class ByteDemo {

	/**
	 * Byte对象的创建方式
	 * 
	 * 1、通过构造函数的方式
	 *    Byte b=new Byte(b);
	 *    重新创建一个新的对象
	 * 2、通过静态方法valueOf获得对象
	 *    Byte _b3=Byte.valueOf(b);
	 *    特点:因为在Byte类中有一个静态的Byte对象数组,里面缓存了byte类型值对应的Byte对象
	 *    而valueOf会根据byte类型的值从数组中直接获取已经创建好的对象
	 *    所以byte类型的值相同，通过valueOf方法得到的对象是同一对象
	 *    
	 */
	public static void demo1()
	{
		byte b=12;
		Byte _b1=new Byte(b);
		Byte _b5=new Byte(b);
		System.out.println(_b1==_b5);
		/**
		 * 会出现运行时异常NumberFormatException(数字格式化异常),
		 * 通过字符串创建一个Byte对象，字符串的内容不能随便给，要求字符串内容
		 * 必须整数
		 * new Byte("abcd");//抛出异常
		 */
		Byte _b2=new Byte("12");
		
		
		//可以通过调用Byte类的静态方法获得Byte对象
		Byte _b3=Byte.valueOf(b);
		Byte _b6=Byte.valueOf(b);
		System.out.println(_b3==_b6);
		Byte _b4=Byte.valueOf("12");
	}
	/**
	 * Short和Byte的区别在于,
	 * valueOf方法,值的范围在-128~127之间，得到对象是相同的，超过这个范围,
	 * 内部重新创建一个对象
	 */
	public static void demo4()
	{
		short s=-200;
		Short s1=Short.valueOf(s);
		Short s2=Short.valueOf(s);
		System.out.println(s1==s2);
	}
	/**
	 * Integer
	 */
	public static void demo5()
	{
		int s=-200;
		Integer s1=Integer.valueOf(s);
		Integer s2=Integer.valueOf(s);
		System.out.println(s1==s2);
		
		//将整形转换成二进制
		String result=Integer.toBinaryString(4);
		//转换成八进制
		result=Integer.toOctalString(9);
		//转换成十六进制
		result=Integer.toHexString(11);
		System.out.println(result);
	}
	
	/**
	 * Long
	 * 
	 */
	public static void demo6()
	{
		int s=-200;
		Long s1=Long.valueOf(s);
		Long s2=Long.valueOf(s);
		System.out.println(s1==s2);
		
		//将整形转换成二进制
		String result=Long.toBinaryString(4);
		//转换成八进制
		result=Long.toOctalString(9);
		//转换成十六进制
		result=Long.toHexString(11);
		System.out.println(result);
	}
	/**
	 * 包装类的自动装箱、自动拆箱
	 * @param args
	 */
	public static void demo2()
	{
		//将基本类型byte的值直接赋值给一个Byte对象.自动装箱
		byte s=12;
		Byte b1=s;//Byte.valueOf(s);
		Byte b2=s;
		Byte b3=new Byte(s);
		System.out.println(b1==b2);
		
		//自动拆箱(对象向基本类型的转换)
		byte s2=b1;//b1.byteValue();
		//自动装箱的过程,先将12转换成Byte对象,而Byte对象属于Object
		b1.equals(12);
		//将b3对象进行拆箱，得到具体的值,然后进行比较
		System.out.println(12==b3);
		
	}
	/**
	 * 将字符串转换成基本类型
	 * @param args
	 */
	public static void demo3()
	{
		String s1="123";
		byte b1=new Byte(s1);//内部调用了partByte(s1)方法
		byte b2=Byte.parseByte(s1);
	}
	
	public static void main(String[] args) {
		demo6();
	}
}
