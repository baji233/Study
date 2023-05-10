
public class Demo04 {
    public static void main(String[] args){


//        new Animal("小龙");
//        Demo04_2 d42=new Demo04_2("");
//        d42.name="喵喵";
//        d42.shout();
//        new Demo04_3().m1();
//        Demo04_2 d42=new Demo04_2();
//        d42.name="小狗";
//        d42.say();
//        d42.shout();
    }
}
//继承,super
class Demo04_1 {
    String name="小狗";
    protected void shout(){
        System.out.println(name+"在大叫");
    }
    public Demo04_1(Object s1){
        System.out.println(s1+"在吃东西");
    }
}

class Demo04_2 extends Demo04_1{
    Demo04_1 d41=new Demo04_1("小羊");

    public Demo04_2(String s2) {
        super(s2);
    }

    void say(){
        System.out.println("MyName Is "+name);
    }
    public void shout() {
        System.out.println("汪汪");//重写父类方法,多态
        super.name="小猪";
        super.shout();
    }
}


//自增自减
class Demo04_3 {
    int a = 4;
    int b = 5;
    int c = ++a+b++;

    void m1() {
        System.out.println(c);
    }
}
//一个类在继承一个类之后是必须要初始化这个父类的，不然你子类继承父类的那些参数无法初始化，使用时可能会出现异常。
// 所以在子类继承父类后，必须要在子类构造方法中调用父类的构造方法。
class Animal{
    public String toString(){
        return "被我重写了";
    }
public Animal(String s3){
    System.out.println("我是"+s3);
    int i=this.hashCode();//调用终极父类的方法
    Boolean b=this.equals(new Animal());
    System.out.println(b+"\n"+i);
}
public Animal(){}
}

class Dog extends Animal{
    int i=0;
    public Dog() {
        super("小黑");//易忘记!!
    }
}