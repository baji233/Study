import java.util.*;

/**
 * 面向对象的练习代码
 */
public class Demo02 {
    final int A_BC=52;
    public static void main(String[] args){
        new Demo02_1();

//          无法访问静态方法中的非静态成员
//          Demo02.method05().f;

//          System.out.println(method03(5));

//          Demo03 d3=new Demo03();
//          d3.setName("小明");
//          d3.setAge(-2);
//          System.out.println(d3.getName()+"是"+d3.getAge()+"岁");

    }
    //最值
    public static void method01(){
        Object[]i=new Object[12];
        String[] k=new String[]{"King","Interface"};
        int[] n={1,2,3,4};
        int o=n[2];
        int max=n[0];
        for(int a=0;a<n.length; a++) {
            if(n[a]>max){
                max=n[a];
            }
        }
        System.out.println(max);
    }
    //冒泡排序
    public static void method02(){
        int[] arr={9,8,3,5,2};
        for(int i=0;i<arr.length; i++){
            System.out.println(arr[i]);
        }
        System.out.println();
        //比较轮数
        for(int a=1;a<arr.length;a++){
            //比较相邻两数
            for(int b=0;b<arr.length-a;b++){
                if(arr[b]>arr[b+1]){
                    int c=arr[b];
                    arr[b]=arr[b+1];
                    arr[b+1]=c;
                }
            }
        }
        for(int i=0;i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }
    //方法的递归
    public static int method03(int i){
        if(i==1){
            return 1;
        }
        int a=method03(i-1);
        return a+i;
    }
    //构造方法(与重载构造方法)
    private int i,a;
    public Demo02(int i){
        this(0.5, 4.5F);//只能在构造方法中使用this调用其他构造方法,而且必须位于第一行,还不能互相调用
        i=i;//(如果不使用this.i引用,可读性很差)
        System.out.println(i);
    }
    public Demo02(double i,float a){
        a=a;
        i=i;
        System.out.println(i+"  "+a);

    }
    public Demo02(){
        //如果不手动创建构造方法,JVM也会自动的创建一个隐性无参构造方法
    }
    //this关键字
    public void method04(){
        int q=this.A_BC;//可调用全局变量或常量
        this.method02();//可调用全局方法
    }
    //static关键字
    static String schoolName;//static只能修饰全局变量
    public static void method05(){//定义静态方法
        int f=24;
        Demo02 d2=new Demo02();
        Demo02.schoolName="九云IT学院";//类名.静态变量
        System.out.println("我是"+d2.schoolName+"的学生");
    }
    static{
        System.out.println("先\n");//静态代码块常用来初始化数据,它在类被加载时只执行一次
    }
    }
class Demo02_1{
    static{
        System.out.println("后");
    }
}
















