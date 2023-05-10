package exception.demo2;

import java.util.Scanner;

public class ExceptionDemo2 {

	public static void test() throws Exception,ArithmeticException{
		Scanner input = new Scanner(System.in);
		System.out.println("请输入两个小数");
		double a = input.nextDouble();
		double b = input.nextDouble();
		if (b == 0) {

			// 人为产生异常
			throw new ArithmeticException("分母不能为零");
			
		}
		double result = a / b;

		System.out.println(result);

	}
	
	public static void main(String[] args) {
		try {
			test();
		} catch (Exception e) {
			System.out.println("异常处理");
		}
		
	}
}
