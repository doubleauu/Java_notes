package day03;
public class operatordemo{
    public static void main(String[] args){
        //注意自增符号放在前后的区别
        //位于操作数之前，先自增再赋值；位于操作数之后，先赋值再自增
        //自减同理
        int a = 10;
        int b = a++;
        int c = ++a;  //赋值运算符总是在右侧表达式计算完成后才执行。即 等号的优先级最低

        //三元条件运算符
        int result = b > c? b : c;
    }
}