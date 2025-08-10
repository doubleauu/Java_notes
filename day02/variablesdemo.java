package day02;


public class variablesdemo {

    double pi = 3.14; //成员变量，全局变量

    public static final double PI = 3.14; //静态常量
    final int num0 = 1024; //成员常量

    public static void main(String[] args){
        //变量的重新赋值
        int id = 1;
        System.out.println(id);
        id = 2;
        System.out.println(id);
        System.out.println("---");

        //其他类型变量
        float score = 89.0F;
        double score1 = 88.0D;
        int age = 26;
        System.out.println("---");


        //堆上的引用数据类型String
        String name = new String("Descartes");
        System.out.println(name);
        System.out.println("---");


        //类型转换
        int a = 110;
        double b = 113.9D;
        b = a;
        a = (int)b;
        System.out.println(a);
        System.out.println(b);
        System.out.println("---");


        //其他类型到字符串类型的转换方法一
        String str1 = Integer.toString(a);
        String str2 = Double.toString(b);
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str1.getClass());
        System.out.println("---");


        //其他类型到字符串的转换方法二
        String str3 = "" + a;
        System.out.println(str3);
        System.out.println(str3.getClass());
        System.out.println("---");


        //其他类型到字符串的转换方法三
        String str4 = String.valueOf(b);
        System.out.println(str4);
        System.out.println(str4.getClass());
        System.out.println("---");

        //字符串转换成其他类型方法一
        int num1 = Integer.parseInt(str1);
        double num2 = Double.parseDouble(str2);

        //字符串转换为其他类型方法二
        int num3 = Integer.valueOf(str1).intValue();
        double num4 =Double.valueOf(str2).doubleValue();

        //局部变量的作用域，即代码块内定义的变量

        //常量的使用，final类似const;
        final int num = 1024;  //局部常量
    }
}