package number.demo;

public class FloatDemo {

	public static void demo1()
	{
		//Float f=12.5f;
		//����,�Զ�װ��Ĺ�����,�������͵�ֵֻ�����Ӧ�İ�װ��ת��
		//Double f2=12.5f;
		//ͨ���ַ�������Float�����ʱ��,�ַ������ݿ�����float���͵ļ�������
		Float f=new Float("12.5f");
		//Float��Double��valueOf�ص�,û����-128~127�������ÿ���½���ͬ�Ķ���
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
	 * valueOf������������������,true��false�İ�װ�����
	 * @param args
	 */
	public static void demo2()
	{
		//��������ķ�ʽ
		Boolean b1=new Boolean(true);
		//���ַ����Ĺ��캯��,�ַ�������Ϊnull,true,false
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
