package number.demo;
/**
 * Byte��byte���͵�ֵ���а�װ
 * 
 * 
 * @author Administrator
 *
 */
public class ByteDemo {

	/**
	 * Byte����Ĵ�����ʽ
	 * 
	 * 1��ͨ�����캯���ķ�ʽ
	 *    Byte b=new Byte(b);
	 *    ���´���һ���µĶ���
	 * 2��ͨ����̬����valueOf��ö���
	 *    Byte _b3=Byte.valueOf(b);
	 *    �ص�:��Ϊ��Byte������һ����̬��Byte��������,���滺����byte����ֵ��Ӧ��Byte����
	 *    ��valueOf�����byte���͵�ֵ��������ֱ�ӻ�ȡ�Ѿ������õĶ���
	 *    ����byte���͵�ֵ��ͬ��ͨ��valueOf�����õ��Ķ�����ͬһ����
	 *    
	 */
	public static void demo1()
	{
		byte b=12;
		Byte _b1=new Byte(b);
		Byte _b5=new Byte(b);
		System.out.println(_b1==_b5);
		/**
		 * ���������ʱ�쳣NumberFormatException(���ָ�ʽ���쳣),
		 * ͨ���ַ�������һ��Byte�����ַ��������ݲ���������Ҫ���ַ�������
		 * ��������
		 * new Byte("abcd");//�׳��쳣
		 */
		Byte _b2=new Byte("12");
		
		
		//����ͨ������Byte��ľ�̬�������Byte����
		Byte _b3=Byte.valueOf(b);
		Byte _b6=Byte.valueOf(b);
		System.out.println(_b3==_b6);
		Byte _b4=Byte.valueOf("12");
	}
	/**
	 * Short��Byte����������,
	 * valueOf����,ֵ�ķ�Χ��-128~127֮�䣬�õ���������ͬ�ģ����������Χ,
	 * �ڲ����´���һ������
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
		
		//������ת���ɶ�����
		String result=Integer.toBinaryString(4);
		//ת���ɰ˽���
		result=Integer.toOctalString(9);
		//ת����ʮ������
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
		
		//������ת���ɶ�����
		String result=Long.toBinaryString(4);
		//ת���ɰ˽���
		result=Long.toOctalString(9);
		//ת����ʮ������
		result=Long.toHexString(11);
		System.out.println(result);
	}
	/**
	 * ��װ����Զ�װ�䡢�Զ�����
	 * @param args
	 */
	public static void demo2()
	{
		//����������byte��ֱֵ�Ӹ�ֵ��һ��Byte����.�Զ�װ��
		byte s=12;
		Byte b1=s;//Byte.valueOf(s);
		Byte b2=s;
		Byte b3=new Byte(s);
		System.out.println(b1==b2);
		
		//�Զ�����(������������͵�ת��)
		byte s2=b1;//b1.byteValue();
		//�Զ�װ��Ĺ���,�Ƚ�12ת����Byte����,��Byte��������Object
		b1.equals(12);
		//��b3������в��䣬�õ������ֵ,Ȼ����бȽ�
		System.out.println(12==b3);
		
	}
	/**
	 * ���ַ���ת���ɻ�������
	 * @param args
	 */
	public static void demo3()
	{
		String s1="123";
		byte b1=new Byte(s1);//�ڲ�������partByte(s1)����
		byte b2=Byte.parseByte(s1);
	}
	
	public static void main(String[] args) {
		demo6();
	}
}
