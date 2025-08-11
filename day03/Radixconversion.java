package day03;

public class Radixconversion{
    public static void main(String[] args){
        //将一个十进制数字转换为其他进制
        int num = 200;
        System.out.println(num + " 的二进制是：" + Integer.toBinaryString(num));
        System.out.println(num + " 的八进制是：" + Integer.toOctalString(num));
        System.out.println(num + " 的十六进制是：" + Integer.toHexString(num));
        System.out.println(num + " 的三进制是：" + Integer.toString(num, 3));

        //将其他进制数字转换为十进制
        String str = "310";
        int N = 8;
        System.out.println(N +"进制:" + str + " 的十进制是：" + Integer.parseInt(str, N));
    }
}