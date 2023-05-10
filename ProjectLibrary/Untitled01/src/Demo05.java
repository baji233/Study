import java.lang.reflect.Constructor;

public class Demo05 {
//        public static void main(String[] args){
//        new Demo05_2().method01();

//        System.out.println(if01.I_02);
//        class01 c1=new class01();
//        System.out.println(c1.I_02);
//        c1.setName("小黑");
//        c1.method01();
//        c1.method04();

//        Animal01 a1=new Cat01(); //自动向上转型
//        a1.shout01();  //可以调用重写过的接口方法
//        Cat01 c1=(Cat01) a1;//强制向上转型
//        String s02=c1.catch01();

//        Animal01 dog01=new Dog01();
//        if (dog01 instanceof Cat01) {  //使用instanceof判断对象是否为该类实例或者子类实例
//            Cat01 cat01=(Cat01)dog01;
//            cat01.shout01(); cat01.catch01(); //他们都可以调用重写后的接口方法,但是不能调用对方独有的方法
//        }else{
//            System.out.println("这个对象不是Cat01的类型");
//        }
//        Cat01 c2=(Cat01)dog01;   //因为这两个类都实现了同一个接口,所以他们的类型有共同点,可以互相转型

    /**
     * 反射机制
     * 类-->
     * @param args
     */
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException {
        Class<if01> if01Class = if01.class;  //No.1
        Package package01=if01Class.getPackage();  //获取包名
        String  package01Name=package01.getName();
        System.out.println(package01Name);

        //获取父类
        Class super01=if01Class.getSuperclass();//
        System.out.println(super01.getName());

        //获取接口
        Class[] interface01=if01Class.getInterfaces();

        //获取构造方法
        Class<cat> catClass=cat.class;
        Constructor[] constructors=catClass.getDeclaredConstructors();
        //获取指定构造方法

        catClass.getConstructor();
        for(Constructor cat:constructors){
            int i=catClass.getModifiers();  //获取修饰符

            String constructorsName=catClass.getName();

        }
        //通过构造方法获取全部成员属性
        //给对象成员属性赋值
        //调用对象的方法
        Object o1=catClass.newInstance();



//        Class<> dog01Class=-Class.forName("Dog01");  //No.2

        String s1="abc";
        Class c1=s1.getClass();  //No.3
    }
}
//抽象方法
abstract class Demo05_1{
    public abstract void method01();
}
class Demo05_2 extends Demo05_1{
    public void method01(){
        System.out.println("只能通过继承抽象父类来实现他的抽象方法");
    }
}

//接口
interface if01{
    int i01=0;
    static final int I_02=34;
    public abstract void method01();
    public static int method02(int I_02){
        return I_02;
    }
    public default void setName(String s1){
        System.out.println(s1);
    }
}
interface if02{
    void method04();
}
interface if03 extends if01,if02{  //多继承

}
class Class01 extends Demo05 implements if03,if01{
    public void method01(){  //实现接口的抽象方法
        System.out.println("实现了接口1里的方法1");
    }
    public void method04(){
        System.out.println("实现了接口2里的方法4");
    }

}
//多态
abstract class asc01{
    abstract void shout();  //叫声
        }
class cat extends asc01{
    public void shout(){
        System.out.println("喵喵~");  //不同的类继承一个抽象类去实现同一个抽象方法所表现的形式也不一样
    }
    public void catchs(){
        System.out.println("抓老鼠");
    }
    public void method02(String s2){
        System.out.println(s2);
    }

}
class dog01 extends asc01{
    void shout(){
        System.out.println("汪汪~");  //不同的类继承一个抽象类去实现同一个抽象方法所表现的形式也不一样
    }
}
//向上转型
interface Animal01{
    void shout01();
}
class Cat01 implements Animal01{
    String s01="老鼠";
    public void shout01(){
        System.out.println("喵喵..");
    }
    public String catch01(){
        return s01;
    }
}

class Dog01 implements Animal01{

    @Override
    public void shout01() {
        System.out.println("汪汪..");
    }

    public void eat01(){
        System.out.println("吃骨头");
    }
}




























