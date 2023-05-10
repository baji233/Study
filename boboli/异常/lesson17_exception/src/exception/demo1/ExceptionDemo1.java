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
			System.out.println("finally 被执行");
			result=100;
			//return result;
		}
	}
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("请输入两个整数");
		int a=input.nextInt();
		int b=input.nextInt();
		int result=0;
		int []arr={1,2,3,4};
		try{
			String s=null;
			s.length();//NullPointerException
		 //除法运算
		 result=a/b;
		 System.out.println("结果 "+result);
		 arr[0]=100;
		 arr[5]=10;
		}catch(ArithmeticException ex){
			System.out.println("分母不能为0,重新输入");
			b=input.nextInt();
			result=a/b;
			System.out.println("result: "+result);
		}catch (ArrayIndexOutOfBoundsException ex) {
			System.out.println("数组下标越界");
		}catch (Exception e) {
			//System.out.println(e.getMessage());
			//e.printStackTrace();
			System.out.println("其他异常");
		}finally{
			System.out.println("始终被执行");
		}
		System.out.println(arr[0]);
		System.out.println("后续处理");
		
		
		System.out.println(test());
	}
}
