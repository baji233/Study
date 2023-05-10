package number.demo;
/**
 * Character包装类
 * @author Administrator
 *
 */
public class CharacterDemo {

	/**
	 * 只有一个构造函数
	 * Character(char c)
	 * valueOf()方法,缓存了对象,字符对应的ascii码值的范围0~127之间。超出这个范围
	 * 就会新建对象
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
	

	//Character常用方法
	/**
	 * @deprecated  方法即将过时提示
	 */
	public static void demo2()
	{
		Character c1='a';
		//判断字符内容是否为字母,如果是字母则返回true
		boolean flag=Character.isLetter('A');
		//判断字符内容是否为数字
		flag=Character.isDigit('1');
		
		//判断字符是否为大写
		flag=Character.isUpperCase('a');
		//判断字符是否为小写
		flag=Character.isLowerCase('b');
		//判断字符是否为空白字符
		flag=Character.isWhitespace('\n');
		System.out.println(flag);
		
		//字符大小写转换
		char c2=Character.toUpperCase('a');
		c2=Character.toLowerCase('B');
		System.out.println(c2);
		
		
	}
	
	public static void main(String[] args) {
		demo2();
	}
	
}

