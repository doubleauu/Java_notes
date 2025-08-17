package day06;

import java.util.Arrays;

public class ArrayDemo {
    private static int[] arr1;
    private static int[][] arr2;
    private static int[] arr3;
    private static int[][] arr4;

    public static void main(String[] args) {
        arrayInit();
        //arrayAccess();
        //arrayTraversal();
        bubbleSort();
        //standardSort();
    }
    //数组的定义
    public static void arrayInit() {
        //静态初始化，定义的同时直接赋值，然后系统自动确定长度
        arr1 = new int[]{1,2,3};
        arr2 = new int[][]{{1,2,3}};  //一行三列的二维数组

        //动态初始化，先确定长度，系统分配全部索引位置为0，后面可以自动分配
        arr3 = new int[3];
        arr3[0] = 4;
        arr3[1] = 5;
        arr3[2] = 6;

        arr4 = new int[3][1];
        arr4[0][0] = 1;
        arr4[1][0] = 2;
        //arr4[2][0] 没有赋值默认还是0

    }

    //数组元素的访问
    public static void arrayAccess() {
        System.out.println("二维数组的行数: " + arr4.length);
        System.out.println("二维数组第一行的列数: " + arr4[0].length);
        System.out.println(arr4[2][0]);
    }

    //数组的遍历
    public static void arrayTraversal() {
        String[] arr =new  String[5];  //分配了内存，元素均为null，但作用只是一个声明，下面的赋值会重新分配内存，其实之后的引用也会指向下面的新数组，该旧数组被丢弃
        arr = new String[]{"村雨遥", "海贼王", "进击的巨人", "鬼灭之刃", "斗罗大陆"};
        int size = arr.length;

        //标准for循环
        for (int i = 0; i < size; i++) {
            System.out.println("第 " + (i + 1) + " 个元素：" + arr[i]);
        }

        //增强for循环
        for (String name : arr) {
            System.out.println(name);
        }

        //标准库遍历，将任意类型的数组转换为一个字符串表示形式，从而打印出来。
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr1));
    }

    ///数组排序
    //冒泡排序
    public static void bubbleSort() {
        char[] chArray = {'c', 'u', 'n', 'y', 'u', 'f'};
        //排序前
        System.out.printf("排序前：%s\n", Arrays.toString(chArray));
        int count = 1;

        for (int i = 0; i < chArray.length - 1; i++) { //外层循环确定的是一个轮数而已，无论方向
            for(int j = chArray.length - 1; j > i; j--) { //内层循环确定第i轮需要检验的位数，注意遍历的方向，此处是从右往左遍历
                if(chArray[j] < chArray[j - 1]){
                    char temp = chArray[j];  //经典的换位，简记对角相同，临时变量记哪个都行
                    chArray[j] = chArray[j - 1];
                    chArray[j - 1] = temp;
                }
                System.out.printf("排序中：%s,第 %d 次排序\n", Arrays.toString(chArray), count);  //熟悉使用格式化打印
                count++;
            }
        }

        // 冒泡排序后
        System.out.printf("排序后：%s\n",Arrays.toString(chArray));
    }
    //标准排序
    public static void standardSort() {
        String[] arr = new String[]{"村雨遥", "海贼王", "进击的巨人", "鬼灭之刃", "斗罗大陆"};  //静态初始化
        System.out.printf("排序前：%s\n", Arrays.toString(arr));
        //标准库排序
        Arrays.sort(arr);
        System.out.printf("排序后：%s\n", Arrays.toString(arr));
    }
}