public class Demo03 {
    /**
     * 封装
     */
    //封装名字和年龄
    private String name;
    private int age;
    //只有设置和获取的方法
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setAge(int age){
        if(age<0){
            System.err.println("Error");
        }else {
            this.age = age;
        }
    }
    public int getAge(){
        return age;
    }

    public static void main(String[] args){
//        new Demo02(98);
//        Outer outer=new Outer();
//        Outer.Inner inner=outer.new Inner();
//        inner.test02();
//        outer.test04();

//        Outer outer=new Outer();
//        outer.test05();
        Outer.Inner02.test05();  //直接通过类名访问内部类静态成员
        Outer.Inner02 inner02=new Outer.Inner02();
        inner02.test05_3();
    }
}

//外部类
class Outer {
    int i = 1;
    void test01() {
        System.out.println("外部类方法");
    }
    //成员内部类,可和外部类互相访问
    class Inner {
        int n = 2;
        void test02() {
            System.out.println(i);
            test01();  //在成员内部类中可以直接访问外部类方法和变量
        }
        void test03() {
            System.out.println("内部类成员方法");
        }
    }
    //外部类方法访问内部类成员
    void test04() {
        Inner inner=new Inner();
        System.out.println("内部类成员变量"+inner.n);
        inner.test03();
    }
    //局部内部类
    void test05(){
        class Inner01{  //可访问外部类的成员,而外部类不能访问局部内部类成员,只创建该内部类的方法可访问
            int i=3;
            void show(){
                System.out.println("局部内部类的方法");
                test01();  //直接调用外部类方法
            }
        }
        Inner01 inner01=new Inner01();  //内部方法可创建局部内部类对象来访问里面成员
        System.out.println(inner01.i);
        inner01.show();
    }
    static int a=9;
    int b=8;
    static void test05_1(){
        System.out.println("外部类成员方法调用变量"+Inner02.a1);
    }
     void test05_2(){
        System.out.println("外部类静态方法");
    }
    //静态内部类
    static class Inner02{  //只能访问外部类的静态成员
        static int a1=90;
        int b2=80;
        static void test05(){
            System.out.println("静态内部类静态方法只能访问外部类的静态成员"+a);
        }
        void test05_3(){
            System.out.println("静态内部类方法");
        }
    }
    //匿名内部类

}























