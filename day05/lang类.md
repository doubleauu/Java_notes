`Math`类是Java语言中`java.lang`包中的一个类。`java.lang`包是Java中的基础包，它会被自动导入到每个Java程序中，所以不需要显式地使用`import`语句来引入`Math`类。

这与一些需要显式导入的类不同，比如我们在代码中使用的`Scanner`类，它属于`java.util`包，所以需要使用：
```java
import java.util.Scanner;
```

因此，我们可以直接使用`Math.sqrt()`这样的静态方法，而不需要额外的导入语句。

---
好的，非常乐意为您详细讲解Java中最核心、最基础的包——`java.lang`。

您之前问的 `Object` 类，就是这个包里最重要的成员之一。现在我们把视野扩大，看看整个 `java.lang` 家族。

---

### 一、核心定位：Java语言的心脏

`java.lang` 包是Java语言的核心库。可以把它理解为：

*   **Java的心脏**：它提供了Java编程最基础、最根本的类和接口。没有它，Java程序寸步难行。
*   **无需手动导入**：`java.lang` 是唯一一个**不需要**使用 `import` 语句就可以直接使用的包。Java编译器会自动为你导入这个包里的所有内容。

这就是为什么你可以直接写 `String s = "Hello";` 或者 `Object obj = new Object();`，而不需要在文件开头写 `import java.lang.String;`。编译器已经帮你做了。

---

### 二、`java.lang` 包的核心成员分类讲解

`java.lang` 包里的成员非常多，我们可以把它们按功能分成几大类来理解。

#### 1. 万物之源：`Object` 类

我们已经详细讲过，这里再总结一下它的地位：
*   **根类**：所有Java类的最终父类。
*   **提供基础行为**：定义了如 `equals()`, `hashCode()`, `toString()`, `getClass()`, `wait()`, `notify()` 等所有对象都应具备的基本方法。

#### 2. 基本数据类型的“包装”：包装类 (Wrapper Classes)

Java有8种基本数据类型（`int`, `double`, `boolean` 等），它们不是对象。为了让这些基本类型能够像对象一样被操作（例如，存入 `ArrayList` 这样的集合中），`java.lang` 为每一种基本类型都提供了一个对应的“包装类”。

| 基本类型 | 包装类 |
| :--- | :--- |
| `int` | `Integer` |
| `long` | `Long` |
| `short` | `Short` |
| `byte` | `Byte` |
| `double` | `Double` |
| `float` | `Float` |
| `boolean` | `Boolean` |
| `char` | `Character` |

**核心作用**：
*   在基本类型和对象之间架起一座桥梁。
*   提供了很多有用的静态方法，如 `Integer.parseInt("123")` 用于将字符串转换为整数。

#### 3. 文本处理的基石：字符串相关类

这是日常编程中使用最频繁的类。
*   **`String`**: 代表**不可变**的字符序列。一旦一个 `String` 对象被创建，它的内容就永远无法改变。任何对字符串的“修改”操作，实际上都是创建了一个新的 `String` 对象。
*   **`StringBuilder`**: 代表**可变**的字符序列。用于需要频繁拼接和修改字符串的场景，性能比 `String` 高得多。它是**非线程安全**的，适合在单线程环境中使用。
*   **`StringBuffer`**: 与 `StringBuilder` 功能几乎一样，也是可变的字符序列。但它是**线程安全**的，适合在多线程环境中使用，但性能略低于 `StringBuilder`。

**简单选择**：
*   字符串内容固定不变？用 `String`。
*   单线程下频繁修改字符串？用 `StringBuilder`。
*   多线程下频繁修改字符串？用 `StringBuffer`。

#### 4. 系统与运行时交互：`System`, `Runtime`, `Process`

*   **`System`**: **提供了访问标准输入/输出/错误流**（`System.in`, `System.out`, `System.err`）、获取系统属性（`System.getProperty("java.version")`）和环境变量、以及执行垃圾回收（`System.gc()`）等底层功能。
*   **`Runtime`**: 让程序可以和它所运行的Java虚拟机（JVM）环境进行交互。例如，可以获取可用内存（`Runtime.getRuntime().freeMemory()`）、执行外部命令（`Runtime.getRuntime().exec("notepad.exe")`）等。
*   **`Process`** 和 **`ProcessBuilder`**: 用于创建和管理操作系统级别的进程。

#### 5. 数学计算工具箱：`Math` 和 `StrictMath`

*   **`Math`**: 包含了一系列用于执行基本数学运算的==**静态方法**==%%可以直接通过类名调用%%，如三角函数 (`Math.sin()`)、指数对数 (`Math.log()`)、取整 (`Math.round()`)、最大/最小值 (`Math.max()`)、随机数 (`Math.random()`) 等。你无需创建 `Math` 对象，直接通过类名调用即可。
*   **`StrictMath`**: 与 `Math` 类似，但它保证在所有Java平台上执行的结果都完全一样，用于需要绝对可复现性的科学计算。

#### 6. 错误与异常的顶层设计：`Throwable` 家族

`java.lang` 定义了Java异常处理机制的整个层次结构。
*   **`Throwable`**: 所有错误（Error）和异常（Exception）的根类。
*   **`Error`**: 表示严重的、程序自身通常无法处理的系统级错误，如虚拟机错误（`VirtualMachineError`）、内存溢出（`OutOfMemoryError`）。程序一般不应该（也无法）捕获 `Error`。
*   **`Exception`**: 表示程序可以捕获和处理的异常情况。它又分为两大类：
    *   **受检异常 (Checked Exceptions)**：`Exception` 的直接子类（`RuntimeException` 除外），如 `IOException`。编译器会强制你必须处理（用 `try-catch` 捕获或用 `throws` 声明抛出）。
    *   **非受检异常 (Unchecked Exceptions)**：`RuntimeException` 及其所有子类，如 `NullPointerException`, `ArrayIndexOutOfBoundsException`。它们通常是由代码逻辑错误引起的，编译器不强制你处理。

#### 7. 并发编程的基础：`Thread`, `Runnable`

*   **`Thread`**: Java中对线程的抽象。每个线程都是 `Thread` 类的一个实例。它包含了启动（`start()`）、休眠（`sleep()`）、中断（`interrupt()`）等操作线程的方法。
*   **`Runnable`**: 一个接口，只有一个 `run()` 方法。它将“任务”本身与“执行任务的线程”解耦，是推荐的实现多线程任务的方式。

#### 8. 反射的入口：`Class` 类

*   **`Class`**: `java.lang` 中一个非常特殊的类。每个加载到JVM中的`.class`文件，都会在内存中形成一个对应的 `Class` 对象。这个对象包含了该类的所有信息（元数据），如类名、方法、字段、构造函数等。`Class` 类是Java反射机制的基石。你可以通过 `object.getClass()` 或 `MyClass.class` 来获取它。

---

### 总结

`java.lang` 包是Java程序员的“空气和水”，你无时无刻不在使用它，但又常常因为它的“自动导入”而忽略了它的存在。

**掌握了 `java.lang` 包，就等于掌握了：**
*   面向对象编程的根基 (`Object`)。
*   处理基本数据和文本的核心工具 (`Integer`, `String`)。
*   与操作系统和JVM交互的底层能力 (`System`, `Runtime`)。
*   构建健壮程序的异常处理机制 (`Throwable`, `Exception`)。
*   编写并发程序的入门知识 (`Thread`, `Runnable`)。

可以说，对 `java.lang` 包的理解深度，直接决定了你对Java语言的掌握程度。