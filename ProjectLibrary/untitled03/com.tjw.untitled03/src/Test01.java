public class Test01 {
    public static void main(String[] args){
        Test02.getTest02().print("����,singleton");
    }
}

/**
 * ��̬��������
 * �������湹�췽������ʵ������
 */
class Test02{
    //װ����ת��
    public static Boolean valuesOf(boolean b){
        return b ? Boolean.TRUE:Boolean.FALSE;
    }

    public static Test02 getTest02(){
        return new Test02();//�������ʵ��
    }

    public void print(String s){
        System.out.println(s);
    }
}















