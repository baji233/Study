package number.demo;
/**
 * Character��װ��
 * @author Administrator
 *
 */
public class CharacterDemo {

	/**
	 * ֻ��һ�����캯��
	 * Character(char c)
	 * valueOf()����,�����˶���,�ַ���Ӧ��ascii��ֵ�ķ�Χ0~127֮�䡣���������Χ
	 * �ͻ��½�����
	 */
	public static void demo1()
	{
		Character c1=new Character('a');
		Character c2='a';
		Character c3=97;
		Character c4=Character.valueOf('a');
		Character c5=Character.valueOf('a');
		System.out.println(c4==c5);
		
	}
	

	//Character���÷���
	/**
	 * @deprecated  ����������ʱ��ʾ
	 */
	public static void demo2()
	{
		Character c1='a';
		//�ж��ַ������Ƿ�Ϊ��ĸ,�������ĸ�򷵻�true
		boolean flag=Character.isLetter('A');
		//�ж��ַ������Ƿ�Ϊ����
		flag=Character.isDigit('1');
		
		//�ж��ַ��Ƿ�Ϊ��д
		flag=Character.isUpperCase('a');
		//�ж��ַ��Ƿ�ΪСд
		flag=Character.isLowerCase('b');
		//�ж��ַ��Ƿ�Ϊ�հ��ַ�
		flag=Character.isWhitespace('\n');
		System.out.println(flag);
		
		//�ַ���Сдת��
		char c2=Character.toUpperCase('a');
		c2=Character.toLowerCase('B');
		System.out.println(c2);
		
		
	}
	
	public static void main(String[] args) {
		demo2();
	}
	
}

