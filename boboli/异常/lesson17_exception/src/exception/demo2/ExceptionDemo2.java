package exception.demo2;

import java.util.Scanner;

public class ExceptionDemo2 {

	public static void test() throws Exception,ArithmeticException{
		Scanner input = new Scanner(System.in);
		System.out.println("����������С��");
		double a = input.nextDouble();
		double b = input.nextDouble();
		if (b == 0) {

			// ��Ϊ�����쳣
			throw new ArithmeticException("��ĸ����Ϊ��");
			
		}
		double result = a / b;

		System.out.println(result);

	}
	
	public static void main(String[] args) {
		try {
			test();
		} catch (Exception e) {
			System.out.println("�쳣����");
		}
		
	}
}
