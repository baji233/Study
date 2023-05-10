/**
 * 匿名内部类
 *调用参数是接口类型的方法时(可以有多个接口类型的参数),用匿名内部类
 *
 * Lambda表达式
 * 调用只有一个抽象方法的接口参数类型的方法时,可以用Lambda表达式
 *
 * Lambda表达式的方法引用和构造器引用
 *
 */
public class Demo07 {
    public static void main(String[] args) {
//        Demo07_1.test01();

        Demo07_1.test02();
    }
    //2.这个方法的两个参数是接口类型的,他调用了两个接口里的三个抽象方法
    public static void method01(Animal05 animal05,Animal06 animal06){
        animal05.shout01();
        animal05.shout02();
        animal06.say();
    }
    //4.这个方法的两个不同类型参数
    public static int method02(Animal07 animal07){
        int x=1;
        int y=2;
        return animal07.eat(x,y);
    }
}
//1.这两个接口里面共有三个抽象方法(待实现..)
interface Animal05{
    void shout01();
    void shout02();

}

interface Animal06{
    void say();
}
@FunctionalInterface//该注解表示函数式接口,即只有一个抽象方法的接口
interface Animal07{
    int eat(int x,int y);
}

class Demo07_1{
    public static void test01(){
        //定义一个局部变量
        int i=52;
        //3.调用method方法,然后可用"匿名内部类"作为接口类型的参数,并且来实现该接口中的抽象方法(局部内部类,匿名内部类可以访问非final局部变量)
        Demo07.method01(new Animal05() {
            public void shout01(){
                System.out.println("shout01成功!"+i);
            }
            public void shout02(){
                System.out.println("shout02成功!");
            }
                      },
                      new Animal06(){
            public void say(){
                System.out.println("say成功!");

            }
                      }
        );
    }
    //5."Lambda表达式"实现了该抽象方法的加法运算功能
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
 * 求绝对值
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




















