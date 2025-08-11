`Integer` 不是一个“库”（Library），而是Java核心语言包 `java.lang` 中的一个**核心类**。它非常重要，是每个Java开发者都必须熟练掌握的。

---
### 一、核心概念：`Integer` 是什么？

`Integer` 是一个**包装类（Wrapper Class）**。

*   **它包装了谁？** 它包装了Java的**基本数据类型 `int`**。
*   **为什么需要包装？** 在Java中，`int` 是一种基本类型，它不是一个对象。这意味着 `int` 变量本身只是一块存储数值的内存，没有方法，也不能为 `null`。但在很多场景下，我们必须把 `int` 当作对象来使用，比如：
    1.  **泛型集合**：像 `ArrayList`, `HashMap` 这样的集合类，它们的泛型参数必须是对象类型，不能是基本类型。你不能写 `ArrayList<int>`，必须写 `ArrayList<Integer>`。
    2.  **需要表示“空值”**：一个 `int` 变量必须有值（默认为0），但一个 `Integer` 对象可以被赋值为 `null`，这在表示“未设置”或“无效”状态时非常有用。
    3.  **使用对象方法**：`Integer` 类提供了大量方便的静态方法和实例方法，用于类型转换、进制转换等。

**一句话总结：`Integer` 类的主要作用，就是让基本数据类型 `int` 能够以对象的形式存在和操作。**

---

### 二、核心机制：自动装箱与自动拆箱

在现代Java（JDK 5及以后）中，`int` 和 `Integer` 之间的转换非常智能，这得益于**自动装箱（Autoboxing）**和**自动拆箱（Auto-unboxing）**。

*   **自动装箱**：将一个 `int` 自动转换成一个 `Integer` 对象。
    ```java
    Integer myInteger = 100; // 编译器在背后做的是：Integer myInteger = Integer.valueOf(100);
    ```

*   **自动拆箱**：将一个 `Integer` 对象自动转换成一个 `int` 值。
    ```java
    Integer myInteger = new Integer(100);
    int myInt = myInteger; // 编译器在背后做的是：int myInt = myInteger.intValue();
    ```

这个机制让我们的代码写起来更简洁，但理解其背后的原理对于避免一些“坑”至关重要。

---

### 三、`Integer` 类的常用方法和字段

`Integer` 类提供了许多非常有用的静态字段和方法。

#### 1. 重要字段（常量）

*   `Integer.MAX_VALUE`：表示 `int` 类型能存储的最大值 (2³¹ - 1，约21亿)。
*   `Integer.MIN_VALUE`：表示 `int` 类型能存储的最小值 (-2³¹)。
*   `Integer.SIZE`：表示 `int` 类型在内存中占用的位数（32位）。
*   `Integer.BYTES`：表示 `int` 类型占用的字节数（4字节）。

#### 2. 核心方法：字符串与整数的转换 (最常用)

这是 `Integer` 类最常用的功能。

*   **`static int parseInt(String s)`**: **【强烈推荐】**
    *   **功能**：将一个数字字符串解析成一个**基本类型 `int`**。
    *   **示例**：`int num = Integer.parseInt("123");`
    *   **注意**：如果字符串格式不正确（如 `"abc"` 或 `"12.3"`），会抛出 `NumberFormatException` 异常。

*   **`static Integer valueOf(String s)`**:
    *   **功能**：将一个数字字符串解析成一个 **`Integer` 对象**。
    *   **示例**：`Integer numObj = Integer.valueOf("123");`
    *   **性能提示 (Integer缓存池)**：为了提高性能，`Integer.valueOf()` 方法内部做了一个缓存。对于 **-128 到 127** 之间的值，它会返回缓存中预先创建好的对象，而不是每次都 `new` 一个新对象。

#### 3. 核心方法：进制转换

*   `static String toBinaryString(int i)`: 将整数转换为二进制字符串。
*   `static String toHexString(int i)`: 将整数转换为十六进制字符串。
*   `static String toOctalString(int i)`: 将整数转换为八进制字符串。
    ```java
    int num = 26;
    String binaryStr = Integer.toBinaryString(num); // "11010"
    String hexStr = Integer.toHexString(num);     // "1a"
    ```

#### 4. 实例方法

*   `int intValue()`: 将 `Integer` 对象转换为 `int` 基本类型（手动拆箱）。
*   `String toString()`: 将 `Integer` 对象的值转换为字符串。
*   `boolean equals(Object obj)`: 比较两个 `Integer` 对象的值是否相等。

---

### 四、一个非常重要的“坑”：`==` 与 `equals()` 的区别

这是面试和实际编程中常见的陷阱。

*   `==`：对于基本类型 `int`，它比较的是**值**。对于 `Integer` 这样的对象类型，它比较的是**对象的内存地址**。
*   `equals()`：`Integer` 类重写了 `Object` 的 `equals()` 方法，使其比较的是两个对象内部包装的**值**。

**结论：比较两个 `Integer` 对象的值是否相等时，永远使用 `equals()` 方法！**

**看代码：**

```java
Integer a = 100;
Integer b = 100;
System.out.println(a == b);       // 输出: true  (因为-128到127之间用了缓存，a和b指向同一个对象)

Integer c = 200;
Integer d = 200;
System.out.println(c == d);       // 输出: false (因为超出了缓存范围，c和d是两个不同的新对象)

System.out.println(c.equals(d));  // 输出: true  (equals比较的是内部的值，200 == 200)
```

### 五、总结

| 分类 | 常用成员 | 功能描述 |
| :--- | :--- | :--- |
| **核心概念** | 包装类 | 将 `int` 包装成对象，以便在泛型、集合等场景使用。 |
| **核心机制** | 自动装箱/拆箱 | `int` 和 `Integer` 之间可以方便地自动转换。 |
| **重要常量** | `MAX_VALUE`, `MIN_VALUE` | 获取 `int` 类型的最大/最小值。 |
| **字符串转整数** | `Integer.parseInt(s)` | **首选**。将字符串转为 `int` 基本类型。 |
| **字符串转整数** | `Integer.valueOf(s)` | 将字符串转为 `Integer` 对象（注意缓存）。 |
| **进制转换** | `toBinaryString`, `toHexString` | 方便地进行二进制、十六进制转换。 |
| **对象比较** | `.equals()` | **必须用它**来比较两个 `Integer` 对象的值是否相等。 |

`Integer` 类是Java基础中的基础，理解它的工作原理和常用方法，对于写出健壮、高效的代码至关重要。