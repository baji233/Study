import java.util.Scanner;

/**
 * 选择和循环结构语句的练习题
 */
public class Demo01 {
    int i=23;
    String s="tjw";

    public static void main(String[] args) {
        method03();
    }
    //列举法判断大小
    public static void method01(){
        Scanner sc=new Scanner(System.in);
        int i1=sc.nextInt();
        int i2=sc.nextInt();
        int i3=sc.nextInt();
        if(i1>i2&&i2>i3){
            System.out.println(i1+" "+i2+" "+i3);
        }
        else if(i1>i3&&i3>i2){
            System.out.println(i1+" "+i3+" "+i2);
        }else if(i2>i3&&i3>i1){
            System.out.println(i2+" "+i3+" "+i1);
        }else if(i2>i1&&i1>i3){
            System.out.println(i2+" "+i1+" "+i3);
        }else if(i3>i1&&i1>i2){
            System.out.println(i3+" "+i1+" "+i2);
        }else if(i3>i2&&i2>i1){
            System.out.println(i3+" "+i2+" "+i1);
        }
    }
    //元音判断
    public static void method02(){
        Scanner sc=new Scanner(System.in);
        String s1=sc.next();
        //将string类型转换为char类型
        char[] a1=s1.toCharArray();
        for(int i=0;i<a1.length;i++){
            if(a1[i]=='a'||a1[i]=='e'||a1[i]=='i'||a1[i]=='o'||a1[i]=='u'||a1[i]=='A'||a1[i]=='E'||a1[i]=='I'||a1[i]=='O'||a1[i]=='U'){
                System.out.println("是元音");
                char c=a1[i];
                if(c>='a'&&c<='z'){
                    System.out.println("小写");
                }else if(c>='A'&&c<='Z'){
                    System.out.println("大写");
                }
            }else{
                System.out.println("不是元音");
            }
        }
    }
    //四则运算
    public static void method03(){
        double num=0;
        //输入
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入数字");
        double s1=sc.nextDouble();
        System.out.println("请输入运算符(+-*/)");
        String s2=sc.next();
        System.out.println("请输入数字");
        double s3=sc.nextDouble();
        //判断
        switch(s2){
            case "+":
                num=s1+s3;
                break;
            case "-":
                num=s1-s3;
                break;
            case "*":
                num=s1*s3;
                break;
            case "/":
                if(s3==0){
                    System.out.println("分母不能为0");
                }else{
                    num=s1/s3;
                }
                break;
        }
        System.out.println("计算结果是 "+num);
    }
}

