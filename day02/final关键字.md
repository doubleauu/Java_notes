`final` 是 Java 里一个非常重要的关键字，用来**“最终定型”**某个变量、方法或类。它的核心作用就是**不可变/不可被重写**，让代码更安全、更可控。

下面分三种场景讲解：

---

### 1. 用在变量上 —— “不可再修改”

**final 修饰变量**，表示这个变量**只能赋值一次，以后不能更改**。

- 对于**基本类型变量**（如 `int`、`double`），数值定死了不能再变。
- 对于**引用类型变量**（如 `String`、对象），引用地址定死了，但对象内容可以变（除非对象本身不可变）。

**示例：**

```java
final int MAX_SIZE = 100;
MAX_SIZE = 200; // 编译报错：不能再次赋值
```

```java
final Student s = new Student("张三");
s = new Student("李四"); // 错误，不能再指向其他对象
s.setName("王五"); // 这个语法是允许的，因为对象本身没被final修饰
```

---

### 2. 用在方法上 —— “不可被子类重写”

**final 修饰方法**，表示这个方法在子类里**不能被重写/覆盖**。

**示例：**

```java
class Parent {
    public final void printHello() {
        System.out.println("Hello!");
    }
}

class Child extends Parent {
    // 下面这句会编译报错
    // public void printHello() { ... }
}
```

---

### 3. 用在类上 —— “不可被继承”

**final 修饰类**，表示这个类**不能被继承**，不能有子类。

**示例：**

```java
final class Animal {
    // ...
}

// 编译报错！
// class Dog extends Animal { ... }
```

---

### 总结

| 用途      | 作用                       |
|-----------|----------------------------|
| final变量 | 只能赋值一次，不能再修改    |
| final方法 | 不能被子类重写             |
| final类   | 不能被继承                 |

**一句话记忆**：`final` 让“它”成为最终定型，不能再变、不能再扩展、不能再重写！
