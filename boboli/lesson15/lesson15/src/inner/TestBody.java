package inner;

import java.util.HashMap;

public class TestBody {

	public static void main(String[] args) {
		Body body=new Body();
		//�����ڲ������
		//Body.Heart heart=body.new Heart();
		Body.Heart heart=new Body().new Heart();
		heart.run();
		
		body.method();
		
		//������̬�ڲ������
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
