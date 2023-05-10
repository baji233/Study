package demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Test01 {

	public  static  void test1()
	{
		Class cls=String.class;
		try {
			Class.forName("java.lang.String");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String s="abc";
		Class c2=s.getClass();
	}
	public static void test2()
	{
		Class c1=Student.class;
		//����������İ�
		Package pkg=c1.getPackage();
		String pkgName=pkg.getName();
		System.out.println(pkgName);
		//�����������
		String cname=c1.getName();
		System.out.println(cname);
		//��ü̳еĸ���
		Class super1=c1.getSuperclass();
		System.out.println("����: "+super1.getName());
		//�����ʵ�ֵĽӿ�
		Class[] iterfaces=c1.getInterfaces();
		System.out.println("ʵ�ֵĽӿ�����");
		for(Class t:iterfaces)
		{
			System.out.println(t.getName());
		}
		//��ù��췽�� Constructor--��ʾ���췽��
		Constructor[] const1=c1.getDeclaredConstructors();
		for(Constructor c:const1)
		{
			//������η�
			int a=c.getModifiers();
			//�����η�ת�����ַ���
			String s=Modifier.toString(a);
			System.out.println("���η�:"+s);
			//��ù��췽��������
			String conName=c.getName();
			System.out.println("������: "+conName);
			//��ù��췽���Ĳ���
			Class []paramTypes=c.getParameterTypes();
			System.out.println("����");
			for(Class t3:paramTypes)
			{
				System.out.println(t3.getName());
			}
		}
		//���public�Ĺ��췽��
		Constructor[] const2=c1.getConstructors();
		//��ȡĳ��ָ���Ĺ��췽��
		Class []params={int.class,String.class,char.class};
		
		try {
			//����Ĭ���޲����Ĺ��캯����������
			Object o1=c1.newInstance();
			Constructor cst4=c1.getConstructor(params);
			Object []values={10,"test",'��'};
		    Object o2=cst4.newInstance(values);
		    
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//Field--��ʾ��Ա
	public static void test3()
	{
		try {
			Class c1=Class.forName("demo.Student");
			//������еĳ�Ա����
			Field []allFields=c1.getDeclaredFields();
			for(Field f:allFields)
			{
				//��ȡ���η�
				int mods=f.getModifiers();
				String strMod=Modifier.toString(mods);
				System.out.print(strMod+"  ");
				//��ó�Ա���Ե���������
				Class pType=f.getType();
				System.out.print(pType.getName()+" ");
				//���������
				String fname=f.getName();
				System.out.println(fname);
			}
			//��������
			Object o1=c1.newInstance();
			//���ָ���������ֶ�
			Field fname=c1.getField("name");
			//���ö���ĳ�Ա����ֵ
			fname.set(o1, "hello");
			//��ȡ��Ա���Ե�ֵ
			Object v=fname.get(o1);
			System.out.println(v);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//Method ��ʾ���еķ���
	public static void test4()
	{
		try {
			Class c1=Student.class;
			//��ȡ���еķ���
			Method []methods=c1.getDeclaredMethods();
			for(Method m:methods)
			{
				String mname=m.getName();
				//��÷����Ĳ���
				Class []params=m.getParameterTypes();
			}
			//���������ҵ��ö���ķ���
			Method m=c1.getMethod("test", null);
			Class []types={int.class,String.class,char.class};
			Constructor con=c1.getConstructor(types);
			Object o2=con.newInstance(60,"aaa",'Ů');
			//���÷���
			Object o3=m.invoke(o2, null);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void main(String[] args) {
		test4();
	}
}
