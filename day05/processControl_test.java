package day05;

import java.util.Scanner;
import java.util.Random;

public class processControl_test {
    public static void main(String[] args){
    //folderTimes();
    //palindrome();
    //getDivisionAndRemainder();
    //sevenBoom();
    //squareRoot();
    isPrime();
    guessNumber();
    }

    //打印折纸的次数
    public static void folderTimes() {
        System.out.println("已知世界上最高的山峰是珠穆朗玛峰，它的高度是 8844.43 米，假设有一张足够大的纸，其厚度为 0.1 毫米，那么请问我要折叠多少次，才能将这张纸折成珠穆朗玛峰的高度？");
        int count = 0;
        double targetHigh = 8844.43 * 1000;   //注意单位
        double currentHigh = 0.1;

        while(currentHigh < targetHigh) {
            currentHigh *= 2;
            count++;
        }
        System.out.printf("解：共需要折叠 %d 次\n", count);
    }

    //回文数的判断
    public static void palindrome() {
        System.out.println("假设给你一个整数 x，如果这个数是回文数，打印 true，否则打印 false。");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要判断的整数x：");
        int x = scanner.nextInt();
        int temp = x;
        int reverse = 0;
        while(x != 0) {
            reverse *= 10;
            reverse += x % 10;
            x /= 10;    //注意x要更新，避免无限循环
        }
        if(reverse == temp)
            System.out.printf("数字 %d 是回文\n", temp);
        else
            System.out.printf("数字 %d 不是回文\n", temp);
        System.out.println(reverse == temp); //直接返回ture或者false
    }

    //求商和余数
    public static void getDivisionAndRemainder() {
    System.out.println("给定两个整数，分别是被除数和除数，然后在不使用乘法、除法和 % 运算符的情况下，求出商和余数。");
    Scanner scanner = new Scanner(System.in);
    System.out.print("请输入被除数：");
    int num1 = scanner.nextInt();
    System.out.print("请输入除数：");
    int num2 = scanner.nextInt();
    int count = 0;
    while (num1 >= num2) {
        num1 -= num2;
        count++;
    }
    System.out.printf("解：商是 %d ；余数是 %d。", count, num1);
    }

    //逢七必过
    public static void sevenBoom() {
        System.out.println("游戏规则：从任意一个数字开始报数，当要报的数字是包含 7 或 7 的倍数时，都要说：过。打印出 1 - 1000 之间的满足逢七必过规则的数据。");
        for (int i = 1; i <= 1000; i++) {
            int temp = i;
            boolean containsSeven = false;
            while (temp > 0) {
                if (temp % 10 == 7) {       //个位是7则结束循环
                    containsSeven = true;
                    break;
                }
                temp /= 10;                 //每次检验个位，不是则删去进行下一轮循环
            }

            if (i % 7 == 0 || containsSeven) {
                System.out.print("过\t");
            } else {
                System.out.printf("%d\t", i);
            }
            //使得每行只显示20个结果
            if (i % 20 == 0) {              //在第20位后打印一个换行即可
                System.out.println();
            }
        }
    }
    
    //平方根
    public static void squareRoot() {
        System.out.println("输入一个大于等于 2 的整数，计算并返回这个数的平方根，结果只保留整数部分。");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("请输入一个整数（负数退出）:");
            int num = scanner.nextInt();
            if (num < 0) {
                break;
            }

            int sqrt = 1;
            while (sqrt <= num / sqrt) {
                if (sqrt * sqrt == num) {
                    break;
                }
                sqrt++;
            }
            sqrt--;

            System.out.printf("%d 的平方根是 %d\n", num, sqrt);
        }
    }

    //判断一个数是否为质数
    public static void isPrime() {
        System.out.println("从键盘输入一个正整数，判断该数是否为质数。");
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.print("请输入一个正整数(负数或0退出)：");
            int num = scanner.nextInt();
            if (num <= 0) break;                         //使用无限循环时注意设置退出条件
            boolean isPrime = true;
            for (int i = 2; i <= Math.sqrt(num); i++) {  //减少循环次数
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime)
                System.out.printf("数字 %d 是质数\n", num);
            else
                System.out.printf("数字 %d 不是质数\n", num);
        }
    }

    //猜数字小游戏
    public static void guessNumber() {
        System.out.println("系统随机给出一个 1 - 100 之间的整数，然后用程序实现才出这个数字是多少。");
        Random rand = new Random();       //在Java中，Random类默认使用系统时间作为种子（seed）来生成随机数。当你使用new Random()创建实例时，它会自动使用System.currentTimeMillis()作为种子值。因此，不需要显式地设置时间种子。
        int num = rand.nextInt(100) + 1;  //nextInt(int bound) 是 Random 类提供的一个方法，用于生成一个在 0（包含）到指定上限（不包含）之间的随机整数。非静态方法，所以要先实例化
        Scanner scanner = new Scanner(System.in);
        System.out.print("请猜数字（1-100）：");
        int temp = scanner.nextInt();
        while(temp != num) {
            if(temp < num) {
                System.out.print("你猜小了,请重新猜：");
                temp = scanner.nextInt();

            }
            else {
                System.out.print("你猜大了，请重新猜：");
                temp = scanner.nextInt();

            }
        }
        System.out.printf("你猜对了，结果是 %d ",num);
    }
}
