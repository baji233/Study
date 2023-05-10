package work1;

public class User {
    //alt+shift+s==>generate getters/setters
	private String name;
	private String pass;
	private int gendar;
	
	
	
	public User(String name, String pass, int gendar) {
		
		this.name = name;
		this.pass = pass;
		this.gendar = gendar;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getGendar() {
		return gendar;
	}
	public void setGendar(int gendar) {
		this.gendar = gendar;
	}
	
	
	public void getUserInfo()
	{
		System.out.println("用户名："+this.name);
		System.out.println("密码："+this.pass);
		System.out.println("性别："+(this.gendar==0?"男":"女"));
	}
	
}
