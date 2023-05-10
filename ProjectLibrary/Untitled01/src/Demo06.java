import java.io.Serializable;
import java.lang.reflect.*;

import static jdk.nashorn.internal.runtime.PrototypeObject.getConstructor;

public class Demo06 {
    /**
     * �������:
     * java.reflect.*;
     * @param args
     */
    int i1=18;
    String s1="tjw";
    void show(String s2,int i2){
        System.out.println(s2+" "+i2);
    }

    //��ȡClass��������ַ�ʽ
    public static void method01() throws ClassNotFoundException {  //ʹ��try����
        //No.1: Class c=class.forName("����");
        Class c1=Class.forName("Demo06");

        //No.2: Object o=������.getClass();
        Demo06 d6=new Demo06();
        Class c2=d6.getClass();

        //No.3: Class c=��������.class
        Class c3=String.class;

        //No4: Class c=�����������Ͱ�װ��.TYPE
        Class c4=Integer.TYPE;

        //No5: ʹ���������ClassLoader
        ClassLoader cl=Demo06.class.getClassLoader();
        Class c5=cl.loadClass("java.lang.String");
    }

    //��ȡclass��Ϣ
    public void method02() throws NoSuchMethodException {
        Class c=Student.class;
        Package p=c.getPackage();
        String pName=p.getName();System.out.println(pName);//����
        String className=c.getName();System.out.println(className);//����
        Class superclass=c.getSuperclass();System.out.println("����: "+superclass.getName());//������
        Class[] ifs=c.getInterfaces();//�ӿ���
        System.out.println("ʵ�ֵĽӿ�����");
        for(Class x:ifs){
            System.out.println(x.getName()+" ");
        }
        Constructor[] constructors=c.getDeclaredConstructors();//��ȡ���췽����Ϣ
        for(Constructor y:constructors){
            int modifiers=y.getModifiers();
            String contructorModifier=Modifier.toString(modifiers);System.out.println("���η�: "+contructorModifier+" ");//��ӡ���η�
            Class[] parameterTypes=y.getParameterTypes();//����
            for(Class z:parameterTypes){
                System.out.println("����: "+z+" ");
            }
            System.out.println(y.getName()+" ");//��ӡ�������췽����
        }
        Constructor constructor=c.getConstructor();//��ȡ�������췽������
        Class[] pointConstructors={String.class,int.class,char.class};//��ȡָ�����췽��
        try {//����Ĭ���޲ι��췽����������
            Object oc=c.newInstance();//Student��ʵ������
            Constructor myConstructors=c.getConstructor(pointConstructors);//ָ�����췽��
            Object[] parameterValues={"С��",18,'��'};//����������б�
            Object omc=myConstructors.newInstance(parameterValues);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
    //Field--->��Ա
    public void method03(){
        {
            try {
                Class c1 = Class.forName("src/Demo06.java");
                Field[] allField=c1.getDeclaredFields();//��ȡȫ���ֶ�
                for(Field f:allField){
                    int fieldModifiers=f.getModifiers();//��ȡ���η�
                    String strModifiers=Modifier.toString(fieldModifiers);System.out.println(strModifiers+" ");
                    Class fieldTyple=f.getType();System.out.println(fieldTyple+" ");//��ȡ�ֶ���������
                    String fieldName=f.getName();System.out.println(fieldName+" ");//��ȡ�ֶ���
                }
                //��ȡָ���ֶ�,������ֵ
                Field myField=c1.getField("name");//��ȡָ��name�ֶ�
                Object oc1=c1.newInstance();//��ȡ��ʵ������
                myField.set(oc1,"С��");//С��ֵ���ֶ�name
                Object xiaoYu=myField.get(oc1);System.out.println(xiaoYu);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (NoSuchFieldException e) {
                throw new RuntimeException(e);
            }
        }
    }
    //Method-->����
    public void method04() throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Demo06 demo06=new Demo06();
        Class c2=demo06.getClass();
        Method[] allMethods=c2.getDeclaredMethods();//��ȡ���з���
        for(Method m:allMethods){
            String mNamem=m.getName();System.out.println(mNamem+" ");//��ȡ������
            Class[] methodParameter=m.getParameterTypes();//��÷����Ĳ���
            for(Class mArr:methodParameter){
                System.out.println(mArr+" ");
            }
        }
        Method testMethod=c2.getMethod("Test",null);//��ȡָ������Test,��������Ϊ��
        Class[] methodParameter={String.class,int.class,char.class};//ͨ����������ָ�����췽��
        Constructor c2c=c2.getConstructor(methodParameter);//��ȡָ�����췽������
        Object object=c2c.newInstance("��̫��",88,'Ů');//ʵ�����ö��󲢴���
        testMethod.invoke(object,null);//ͨ������Ķ�����÷���,���᷵�ض���
    }
    public static void main(String[] args) {
        Demo06 d6=new Demo06();
        try {
            d6.method02();
            d6.method03();
            d6.method04();
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
//������
class Student implements Serializable{
    public String name;
    private int age;
    char sex;
    //���췽��
    public Student(String name, int age, char sex){
        super();
        name=this.name;
        age=this.age;
        sex=this.sex;
    }
    public Student(){};
    //���Է���
    public void test(){
        System.out.println(name+" "+age+" "+sex);
    }
}






























