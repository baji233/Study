package Untitled00;

import java.io.Serializable;

public class Student implements Serializable{

	private int age;
	public String name;
	char sex;
	public Student(int age, String name, char sex) {
		super();
		this.age = age;
		this.name = name;
		this.sex = sex;
	}
	
	private Student(String name)
	{
		this.name=name;
	}
	public Student()
	{
		
	}
	
	public void test()
	{
		System.out.println(name+" "+sex+" "+age);
	}
}
