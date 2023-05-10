public class Test01 {
    public static void main(String[] args){
        Test02.getTest02().print("测试,singleton");
    }
}

/**
 * 静态工厂方法
 * 用来代替构造方法创建实例对象
 */
class Test02{
    //装箱类转换
    public static Boolean valuesOf(boolean b){
        return b ? Boolean.TRUE:Boolean.FALSE;
    }

    public static Test02 getTest02(){
        return new Test02();//返回类的实例
    }

    public void print(String s){
        System.out.println(s);
    }
}















