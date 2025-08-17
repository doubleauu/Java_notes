- 成员变量可以被同名的局部变量覆盖或者重写
- 在声明这些静态成员变量时，只会为引用变量本身（例如 `arr1`）分配内存，并将其初始化为默认值 `null`。

- 此时并不会为数组对象（即数组的内容）分配内存。数组对象本身是在 `arrayInit` 方法中通过 `new` 关键字显式创建时才在堆内存中进行分配的。
- ---

好的，`static` 是Java中一个非常非常重要的关键字，理解它就等于理解了Java面向对象设计的半壁江山。很多初学者会在这里感到困惑，我将用一个非常形象的比喻来帮您彻底搞懂它。

---

### 一、核心比喻：学校与学生

想象一下，我们正在创建一个 `Student`（学生）的蓝图（`class`）。

*   **非静态 (Non-static) 成员**：这些是**每个学生自己独有的**东西。
    *   **非静态变量**：比如 `name` (姓名)、`studentId` (学号)。每个学生（对象）都有自己的一份。张三的姓名是"张三"，李四的姓名是"李四"，互不影响。
    *   **非静态方法**：比如 `study()` (学习)、`doHomework()` (做作业)。这是每个学生自己去执行的动作。张三在学习，李四也在学习，他们是各自独立的行为。

*   **静态 (static) 成员**：这些是**属于整个学校（Class本身），被所有学生共享的**东西，而不是某个学生私有的。
    *   **静态变量**：比如 `totalStudentCount` (学生总人数)。这个数字不属于任何一个学生，而是属于整个 `Student` 这个群体。每新来一个学生，这个共享的数字就加一。
    *   **静态方法**：比如 `getSchoolAddress()` (获取学校地址)。获取学校地址这个动作，不需要一个具体的学生来执行。你不需要抓住张三问他：“请你执行一下‘获取学校地址’这个动作”。你直接问“学生”这个群体（`Student` 类）就行了。

**一句话总结核心区别：**

*   **非`static`的，属于对象 (object/instance)，必须先有对象才能用。**
*   **`static`的，属于类 (class)，可以直接用类名来调用，无需创建对象。**

---

### 二、`static` 修饰变量（静态变量/类变量）

当 `static` 用来修饰一个成员变量时，这个变量就从“实例变量”变成了“类变量”。

**特点：**
1.  **属于类**：它存储在内存中的一个特殊区域（方法区），不属于任何单个对象。
2.  **只有一份**：无论你创建了多少个学生对象 (`new Student()`)，`totalStudentCount` 在内存中永远只有一份。
3.  **被所有对象共享**：任何一个学生对象去修改这个变量，其他所有学生对象看到的值都会改变。
4.  **优先于对象加载**：当类被加载到JVM中时，静态变量就已经被分配了内存空间。它比任何对象的创建都要早。
5.  **调用方式**：强烈推荐使用 **`类名.静态变量名`** 的方式调用。虽然也可以用 `对象名.静态变量名`，但非常不推荐，因为它会引起混淆。

**代码示例：**

```java
public class Student {
    // 非静态（实例）变量：每个学生对象都有一份
    String name;
    
    // 静态（类）变量：所有学生对象共享这一份
    static int totalStudentCount = 0;

    public Student(String name) {
        this.name = name;
        totalStudentCount++; // 每创建一个新学生，总人数就加1
    }
}
```

```java
public class SchoolTest {
    public static void main(String[] args) {
        System.out.println("初始学生总数: " + Student.totalStudentCount); // 输出: 0

        Student zhangsan = new Student("张三");
        System.out.println("当前学生总数: " + Student.totalStudentCount); // 输出: 1

        Student lisi = new Student("李四");
        System.out.println("当前学生总数: " + Student.totalStudentCount); // 输出: 2

        // 不推荐的访问方式（但可以运行）
        System.out.println("通过张三对象看总人数: " + zhangsan.totalStudentCount); // 输出: 2
    }
}
```

---

### 三、`static` 修饰方法（静态方法/类方法）

当 `static` 修饰一个方法时，这个方法就成了类方法。

**特点：**
1.  **属于类**：可以直接通过类名调用。
2.  **无需对象**：调用它时，不需要先 `new` 一个对象。
3.  **重要限制**：
    *   **静态方法中，不能直接访问非静态的成员（变量或方法）**。
    *   **原因**：因为静态方法属于类，它加载时，可能还没有任何对象被创建出来。它不知道你要访问的是**哪一个**对象的 `name`。就像你问“学生”这个抽象群体：“你的名字是什么？”，它无法回答。
    *   **静态方法中，不能使用 `this` 关键字**。因为 `this` 代表“当前对象”，而静态方法不依赖于任何对象。

**代码示例：**
Java自带的 `Math` 类就是最好的例子，它里面所有的方法几乎都是 `static` 的。

```java
// 我们不需要 new 一个 Math 对象
// double result = new Math().max(10, 20); // 这是错误的！

// 直接通过类名调用静态方法
double maxValue = Math.max(10.5, 20.8);
double randomValue = Math.random();

System.out.println("最大值是: " + maxValue);
```

**自定义工具类示例：**

```java
public class ArrayUtils {
    // 这是一个静态方法，属于 ArrayUtils 类
    // 它的功能是打印一个整数数组，这个功能不依赖于任何具体对象
    public static void printArray(int[] arr) {
        if (arr == null) {
            System.out.println("null");
            return;
        }
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}

// 在其他地方使用
public class Main {
    public static void main(String[] args) {
        int[] myScores = {98, 85, 100};
        // 直接用类名调用静态工具方法
        ArrayUtils.printArray(myScores); // 输出: [98, 85, 100]
    }
}
```

---

### 总结

| 对比项      | `static` (静态)   | `non-static` (非静态/实例) |
| :------- | :-------------- | :-------------------- |
| **归属**   | **属于类**         | **属于对象**              |
| **内存**   | 存储在方法区，**只有一份** | 存储在堆内存中，**每个对象都有一份**  |
| **生命周期** | 随类的加载而生，随类的卸载而灭 | 随对象的创建而生，随对象的回收而灭     |
| **调用方式** | **类名.成员** (推荐)  | **对象名.成员** (必须)       |
| **核心用途** | 定义共享数据、创建工具类方法  | 描述每个对象独有的属性和行为        |