/**
 * �����ڲ���
 *���ò����ǽӿ����͵ķ���ʱ(�����ж���ӿ����͵Ĳ���),�������ڲ���
 *
 * Lambda���ʽ
 * ����ֻ��һ�����󷽷��Ľӿڲ������͵ķ���ʱ,������Lambda���ʽ
 *
 * Lambda���ʽ�ķ������ú͹���������
 *
 */
public class Demo07 {
    public static void main(String[] args) {
//        Demo07_1.test01();

        Demo07_1.test02();
    }
    //2.������������������ǽӿ����͵�,�������������ӿ�����������󷽷�
    public static void method01(Animal05 animal05,Animal06 animal06){
        animal05.shout01();
        animal05.shout02();
        animal06.say();
    }
    //4.���������������ͬ���Ͳ���
    public static int method02(Animal07 animal07){
        int x=1;
        int y=2;
        return animal07.eat(x,y);
    }
}
//1.�������ӿ����湲���������󷽷�(��ʵ��..)
interface Animal05{
    void shout01();
    void shout02();

}

interface Animal06{
    void say();
}
@FunctionalInterface//��ע���ʾ����ʽ�ӿ�,��ֻ��һ�����󷽷��Ľӿ�
interface Animal07{
    int eat(int x,int y);
}

class Demo07_1{
    public static void test01(){
        //����һ���ֲ�����
        int i=52;
        //3.����method����,Ȼ�����"�����ڲ���"��Ϊ�ӿ����͵Ĳ���,������ʵ�ָýӿ��еĳ��󷽷�(�ֲ��ڲ���,�����ڲ�����Է��ʷ�final�ֲ�����)
        Demo07.method01(new Animal05() {
            public void shout01(){
                System.out.println("shout01�ɹ�!"+i);
            }
            public void shout02(){
                System.out.println("shout02�ɹ�!");
            }
                      },
                      new Animal06(){
            public void say(){
                System.out.println("say�ɹ�!");

            }
                      }
        );
    }
    //5."Lambda���ʽ"ʵ���˸ó��󷽷��ļӷ����㹦��
    public static void test02(){
        Demo07.method02((x,y)->{
            int c=x+y;
            System.out.println(c);
            return c;
        }
    );
    }
}


/**
 * �����ֵ
 */
class Demo07_2{
    public int method_1(int num){
        if(num>0){
            return num;
        }else{
            return -num;
        }
    }

    public static void method_2(int num,If_1 if_1){
        System.out.println(if_1.abs_1(num));
    }

    public static void test_1(){
        Demo07_2 demo07_2=new Demo07_2();

    }
}
@FunctionalInterface
interface If_1{
    int abs_1(int num);
}




















