package inner;

import java.util.HashMap;

public class TestBody {

	public static void main(String[] args) {
		Body body=new Body();
		//创建内部类对象
		//Body.Heart heart=body.new Heart();
		Body.Heart heart=new Body().new Heart();
		heart.run();
		
		body.method();
		
		//创建静态内部类对象
		Body.Inner2 inner=new Body.Inner2();
		inner.test2();
		
		Usb usb=new Usb(){

			@Override
			public void read() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void write() {
				// TODO Auto-generated method stub
				
			}
			
			
		};
		usb.read();
		
		
		HashMap map=null;
		
	}
}
