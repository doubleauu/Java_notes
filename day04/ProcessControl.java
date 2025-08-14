package day04;

import java.util.Scanner;

/**
 * @class ProcessControl
 * @brief 本类用于演示 Java 中的基本流程控制结构。
 * 包括：
 * 1. 数据的输入与输出
 * 2. if-else 分支结构
 * 3. switch 分支结构
 * 4. while、do-while、for 循环结构
 * 5. 循环控制关键字（break, continue, return）
 */
public class ProcessControl {
    public static void main(String[] args) {
        // 以下是不同功能的示例方法，您可以取消注释来运行特定的示例。
        // inputExample();       // 演示如何从键盘读取输入
        // outputExample();      // 演示多种输出数据的方式
        // ifElseExample();      // 演示 if-else-if-else 分支结构
        // switchExample();      // 演示 switch 分支结构
        // whileLoopExample();   // 演示 while 循环
        // doWhileLoopExample(); // 演示 do-while 循环
        // forLoopExample();     // 演示 for 循环和增强 for 循环
        loopKeywordsExample();  // 演示循环中的 break, continue, return 关键字
    }

    /**
     * @brief 演示如何使用 Scanner 类从键盘获取用户输入。
     * Scanner 是 Java 中用于读取输入的常用工具。
     */
    public static void inputExample() {
        // 创建一个 Scanner 对象，并将其连接到标准输入流（键盘）
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入一个整数：");
        // 读取用户输入的下一个整数
        int number = scanner.nextInt();
        System.out.println("您输入的整数是：" + number);

        System.out.println("请输入一个字符串（不含空格）：");
        // 读取用户输入的下一个字符串（以空格为分隔符）
        String word = scanner.next();
        System.out.println("您输入的字符串是：" + word);

        // 注意：如果在 nextInt() 之后立即调用 nextLine()，需要额外处理换行符。
        scanner.nextLine(); // 消耗掉之前输入留下的换行符

        System.out.println("请输入一行字符串（可包含空格）：");
        // 读取用户输入的整行字符串（直到按下回车）
        String line = scanner.nextLine();
        System.out.println("您输入的一行字符串是：" + line);

        System.out.println("请输入一个浮点数：");
        // 读取用户输入的下一个双精度浮点数
        double decimal = scanner.nextDouble();
        System.out.println("您输入的浮点数是：" + decimal);

        // 关闭 scanner 对象，释放资源，这是一个好习惯
        scanner.close();
    }

    /**
     * @brief 演示 Java 中不同的输出方法。
     * 包括打印后换行、不换行、格式化输出以及错误流输出。
     */
    public static void outputExample() {
        // 声明并初始化一些用于演示的变量
        int count = 10;
        double price = 34.9;
        String itemName = "村雨遥";

        // 1. 使用 System.out.println() 进行输出，并自动在末尾添加换行符
        System.out.println("--- println 示例 (自动换行) ---");
        System.out.println("商品名称：" + itemName);
        System.out.println("数量：" + count);

        // 2. 使用 System.out.print() 进行输出，不会自动换行
        System.out.println("\n--- print 示例 (不换行) ---");
        System.out.print("商品名称：" + itemName);
        System.out.print("，数量：" + count); // 这行会紧跟上一行输出
        System.out.println(); // 手动输出一个换行符，让后续输出在新的一行

        // 3. 使用 System.out.printf() 或 System.out.format() 进行格式化输出
        System.out.println("\n--- printf/format 示例 (格式化输出) ---");
        // %d 用于整数, %f 用于浮点数, %s 用于字符串, \n 是换行符, \t 是制表符
        System.out.printf("商品：%s, 数量：%d\n", itemName, count);
        System.out.printf("价格：%.2f\n", price); // .2f 表示保留两位小数

        // 4. 使用 System.err.println() 输出错误信息，通常在控制台中以红色显示
        System.out.println("\n--- System.err 示例 (错误流输出) ---");
        System.err.println("这是一个错误信息示例。");
    }

    /**
     * @brief 演示 if-else-if-else 分支结构。
     * 用于根据不同条件执行不同的代码块。
     */
    public static void ifElseExample() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入分数（0-100）：");
        double score = scanner.nextDouble();

        // 检查分数是否在有效范围内
        if (score < 0 || score > 100) {
            System.out.println("输入的分数无效，必须在 0-100 之间。");
        } else if (score >= 90) { // 90-100分
            System.out.println("等级：A");
        } else if (score >= 80) { // 80-89分
            System.out.println("等级：B");
        } else if (score >= 60) { // 60-79分
            System.out.println("等级：C");
        } else { // 60分以下
            System.out.println("等级：D");
        }
        scanner.close();
    }

    /**
     * @brief 演示 switch 分支结构。
     * 适用于对一个变量的多个固定值进行判断。
     */
    public static void switchExample() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入星期几的数字（1-7）：");
        int dayOfWeek = scanner.nextInt();

        // switch 语句会根据 dayOfWeek 的值，跳转到对应的 case 执行
        switch (dayOfWeek) {
            case 1:
                System.out.println("星期一");
                break; // break 用于跳出 switch 结构，否则会继续执行下一个 case
            case 2:
                System.out.println("星期二");
                break;
            case 3:
                System.out.println("星期三");
                break;
            case 4:
                System.out.println("星期四");
                break;
            case 5:
                System.out.println("星期五");
                break;
            case 6:
            case 7: // case 6 和 7 会执行相同的代码块
                System.out.println("周末");
                break;
            default: // 如果没有任何 case 匹配，则执行 default
                System.out.println("输入错误，请输入 1-7 之间的数字。");
                break;
        }
        scanner.close();
    }

    /**
     * @brief 演示 while 循环。
     * 先判断条件，如果条件为真，则执行循环体。
     */
    public static void whileLoopExample() {
        int sum = 0;
        int num = 1; // 初始化循环变量
        // 当 num 小于等于 50 时，循环会一直执行
        while (num <= 50) {
            sum += num; // 将当前的 num 加到 sum 中
            num++;      // num 自增 1，为下一次循环做准备
        }
        System.out.println("1 到 50 的累加和是：" + sum);
    }

    /**
     * @brief 演示 do-while 循环。
     * 特点是无论条件是否成立，循环体至少会执行一次。
     */
    public static void doWhileLoopExample() {
        int sum = 0;
        int num = 1;
        // do-while 循环先执行一次循环体，然后再判断条件
        do {
            sum += num;
            num++;
        } while (num <= 50); // 循环条件
        System.out.println("1 到 50 的累加和是：" + sum);
    }

    /**
     * @brief 演示 for 循环和增强 for 循环。
     * for 循环非常适合在循环次数已知的情况下使用。
     */
    public static void forLoopExample() {
        // --- 传统 for 循环 ---
        int sum = 0;
        // for (初始化; 循环条件; 迭代语句)
        for (int num = 1; num <= 50; num++) {
            sum += num;
        }
        System.out.println("1 到 50 的累加和是：" + sum);

        // --- 增强 for 循环 (for-each) ---
        // 用于遍历数组或集合，更简洁
        int[] numbers = {1, 4, 5, 6, 7, 10};
        System.out.println("\n遍历数组元素：");
        // for (元素类型 变量名 : 数组或集合)
        for (int number : numbers) {
            System.out.print(number + "\t"); // \t 是制表符，用于对齐
        }
        System.out.println();
    }

    /**
     * @brief 演示循环控制关键字：break, continue, return。
     */
    public static void loopKeywordsExample() {
        // --- break 示例 ---
        // break 用于完全终止并跳出当前循环。
        System.out.println("--- break 示例 ---");
        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                System.out.println("\n遇到 break，循环在 i=5 时终止。");
                break; // 当 i 等于 5 时，跳出 for 循环
            }
            System.out.print(i + "\t");
        }

        // --- continue 示例 ---
        // continue 用于跳过本次循环中余下的语句，直接开始下一次迭代。
        System.out.println("\n\n--- continue 示例 ---");
        for (int i = 1; i <= 5; i++) {
            if (i == 3) {
                System.out.print("(跳过3) ");
                continue; // 当 i 等于 3 时，跳过本次循环的打印语句
            }
            System.out.print(i + "\t");
        }
        System.out.println("\n循环结束。");

        // --- return 示例 ---
        // return 用于直接终止整个方法的执行。
        System.out.println("\n--- return 示例 ---");
        for (int i = 1; i <= 10; i++) {
            if (i == 7) {
                System.out.println("\n遇到 return，整个方法在 i=7 时结束。");
                return; // 直接退出 loopKeywordsExample 方法
            }
            System.out.print(i + "\t");
        }
        // 因为上面的 return 会被执行，所以这行代码永远不会被执行到。
        System.out.println("这行代码不会被输出。");
    }
}

/*
 * # 初学者重要知识点总结
 *
 * 1.  **Scanner 输入**：
 *     - `Scanner scanner = new Scanner(System.in);` 是获取键盘输入的标准写法。
 *     - `scanner.nextInt()` 读取整数，`scanner.nextDouble()` 读取浮点数，`scanner.next()` 读取不含空格的字符串，`scanner.nextLine()` 读取一整行。
 *     - 使用完 `Scanner` 后，最好用 `scanner.close()` 关闭它以释放资源。
 *
 * 2.  **输出方式**：
 *     - `System.out.println()`：最常用，输出后会自动换行。
 *     - `System.out.print()`：输出后不换行。
 *     - `System.out.printf()`：格式化输出，通过占位符（如 `%d`, `%s`, `%.2f`）可以精确控制输出格式。
 *
 * 3.  **分支结构**：
 *     - `if-else`：用于处理需要根据条件判断来执行不同逻辑的场景。`else if` 可以链接多个条件。
 *     - `switch`：当判断的变量是固定的几个值（整数、字符、字符串等）时，使用 `switch` 比 `if-else` 更清晰。记得在每个 `case` 结尾加 `break`。
 *
 * 4.  **循环结构**：
 *     - `while`：先判断条件再执行。如果一开始条件就不满足，一次都不会执行。
 *     - `do-while`：先执行一次再判断条件。保证循环体至少执行一次。
 *     - `for`：非常适合循环次数已知的情况。结构紧凑，将初始化、条件和迭代都放在一起。
 *     - **增强 for 循环 (for-each)**：遍历数组或集合的最佳选择，代码非常简洁。
 *
 * 5.  **循环控制关键字**：
 *     - `break`：强制“刹车”，完全跳出当前所在的循环。
 *     - `continue`：“跳过本次”，结束当前这次迭代，直接进入下一次迭代。
 *     - `return`：最强力的“退出”，直接结束整个方法的执行，不仅仅是循环。
 *
 * 6.  **Java 编码规范**：
 *     - **类名**：使用大驼峰命名法（PascalCase），例如 `ProcessControl`。
 *     - **方法名和变量名**：使用小驼峰命名法（camelCase），例如 `inputExample`、`dayOfWeek`。
 *     - **代码块**：使用花括号 `{}` 包围代码块，即使只有一行，以增加代码清晰度和避免错误。
 *     - **缩进**：统一使用 4 个空格进行缩进。
 */