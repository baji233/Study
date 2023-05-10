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
		//获得类所属的包
		Package pkg=c1.getPackage();
		String pkgName=pkg.getName();
		System.out.println(pkgName);
		//获得完整类名
		String cname=c1.getName();
		System.out.println(cname);
		//获得继承的父类
		Class super1=c1.getSuperclass();
		System.out.println("父类: "+super1.getName());
		//获得所实现的接口
		Class[] iterfaces=c1.getInterfaces();
		System.out.println("实现的接口如下");
		for(Class t:iterfaces)
		{
			System.out.println(t.getName());
		}
		//获得构造方法 Constructor--表示构造方法
		Constructor[] const1=c1.getDeclaredConstructors();
		for(Constructor c:const1)
		{
			//或得修饰符
			int a=c.getModifiers();
			//将修饰符转换成字符串
			String s=Modifier.toString(a);
			System.out.println("修饰符:"+s);
			//获得构造方法的名字
			String conName=c.getName();
			System.out.println("方法名: "+conName);
			//获得构造方法的参数
			Class []paramTypes=c.getParameterTypes();
			System.out.println("参数");
			for(Class t3:paramTypes)
			{
				System.out.println(t3.getName());
			}
		}
		//获得public的构造方法
		Constructor[] const2=c1.getConstructors();
		//获取某个指定的构造方法
		Class []params={int.class,String.class,char.class};
		
		try {
			//利用默认无参数的构造函数创建对象
			Object o1=c1.newInstance();
			Constructor cst4=c1.getConstructor(params);
			Object []values={10,"test",'男'};
		    Object o2=cst4.newInstance(values);
		    
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//Field--表示成员
	public static void test3()
	{
		try {
			Class c1=Class.forName("demo.Student");
			//获得所有的成员属性
			Field []allFields=c1.getDeclaredFields();
			for(Field f:allFields)
			{
				//获取修饰符
				int mods=f.getModifiers();
				String strMod=Modifier.toString(mods);
				System.out.print(strMod+"  ");
				//获得成员属性的数据类型
				Class pType=f.getType();
				System.out.print(pType.getName()+" ");
				//获得属性名
				String fname=f.getName();
				System.out.println(fname);
			}
			//创建对象
			Object o1=c1.newInstance();
			//获得指定的属性字段
			Field fname=c1.getField("name");
			//设置对象的成员属性值
			fname.set(o1, "hello");
			//获取成员属性的值
			Object v=fname.get(o1);
			System.out.println(v);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//Method 表示类中的方法
	public static void test4()
	{
		try {
			Class c1=Student.class;
			//获取所有的方法
			Method []methods=c1.getDeclaredMethods();
			for(Method m:methods)
			{
				String mname=m.getName();
				//获得方法的参数
				Class []params=m.getParameterTypes();
			}
			//创建对象并且调用对象的方法
			Method m=c1.getMethod("test", null);
			Class []types={int.class,String.class,char.class};
			Constructor con=c1.getConstructor(types);
			Object o2=con.newInstance(60,"aaa",'女');
			//调用方法
			Object o3=m.invoke(o2, null);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void main(String[] args) {
		test4();
	}
}
