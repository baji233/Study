package exception.demo1;

import java.util.Scanner;

public class ExceptionDemo1 {

	
	public static int test()
	{
		int result=0;
		try {
			 result=10/0;
			return result;
		} catch (Exception e) {
			
			return result;
		}finally{
			System.out.println("finally ��ִ��");
			result=100;
			//return result;
		}
	}
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("��������������");
		int a=input.nextInt();
		int b=input.nextInt();
		int result=0;
		int []arr={1,2,3,4};
		try{
			String s=null;
			s.length();//NullPointerException
		 //��������
		 result=a/b;
		 System.out.println("��� "+result);
		 arr[0]=100;
		 arr[5]=10;
		}catch(ArithmeticException ex){
			System.out.println("��ĸ����Ϊ0,��������");
			b=input.nextInt();
			result=a/b;
			System.out.println("result: "+result);
		}catch (ArrayIndexOutOfBoundsException ex) {
			System.out.println("�����±�Խ��");
		}catch (Exception e) {
			//System.out.println(e.getMessage());
			//e.printStackTrace();
			System.out.println("�����쳣");
		}finally{
			System.out.println("ʼ�ձ�ִ��");
		}
		System.out.println(arr[0]);
		System.out.println("��������");
		
		
		System.out.println(test());
	}
}
