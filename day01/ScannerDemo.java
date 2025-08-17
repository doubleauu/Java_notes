package day01;

import java.util.Scanner;

public class ScannerDemo{
    //主函数
    public static void main(String[] args){
        //创建对象，准备使用Scanner类
        //对象就是类的实例
        Scanner scan = new Scanner(System.in);

        //声明变量接受键盘录入
        int i = scan.nextInt();
        i += scan.nextInt();
        System.out.print("你输入的两个数字和是：");
        System.out.print(i);
    }
}