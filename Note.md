## 面向对象-初级
类与对象
类的定义与对象的创建
对象的使用
方法的创建与使用
方法进阶使用
构造方法

静态变量和静态方法（`static`）
> 每个对象都会具有类中设定的属性和相关方法
> 所以说类就像是一个模板
> 我们可以模板捏造出一个又一个对象
> 而静态的内容，我们可以理解为属于这个类的，也可以理解为所有对象共享的内容
> 我们通过static关键字来声明一个变量或一个方法
> 一个对象改变了静态变量的值，那么其他的对象读取的就是被改变的值
> 我们可以通过 类名.xx 的方式调用
> 因为静态内容是属于类的，所以静态方法不能使用非静态的方法和字段
>
> 那么静态变量是什么时候加载的呢？
> 我们知道.class文件是交给JVM去执行的，而每一个.class文件其实就是我们编写的一个类
> 我们在使用一个类之前，JVN并不会在一开始就去加载它，而是在需要的时候才会加载，一般有以下情况：
>
> - 访问类的静态变量，或者为静态变量赋值
> - new创建类的实例（隐式加载）
> - 调用类的静态方法
> - 子类初始化时
> - 其他的情况会在讲到反射时介绍
>
> 类中对象加载顺序
>
> 静态变量/代码块->普通代码块/成员变量->构造函数

包声明和导入

> package 和 import

访问权限控制

> Java中引入了访问权限控制（可见性），我们可以为成员变量，成员方法，静态变量，静态方法甚至是类指定访问权限
>
> 不同的权限有不同程度的访问限制：
>
> - private 私有 标记为私有内容无法被除当前类以外的任何位置访问
> - 默认 只能被类本身和同包中的其他类访问
> - protected 受保护 标记为受保护的内容 可以被类本身和同包中的其他类访问，也可以被子类访问
> - public 公共 标记为公共的内容，允许在任何地方被访问
>
> 如果类中存在静态方法是静态变量，那么我们可以通过静态导入的方式将其中的静态方法或是静态变量直接导入使用，同样需要有访问权限
>
> ```java
> import static com.test.entity.Person.test;
> public class Main {
>     public static void main(String[] args) {
>         test();
>     }
> }
> ```
>
> 



>### 封装，继承和多态
>
>封装，把对象的属性和方法结合成一个独立的整体，隐藏实现细节，并提供对外访问接口。
>
>继承，从已知的一个类中派生出一个新的类，叫做子类，子类实现了父类所有非私有化的属性和方法，并根据实际需求扩展出新的行为
>
>多态，多个不同的对象对同一消息做出响应，同一消息根据不同的对象而采用各种不同的方法
>
>
>
>**类的封装**
>
>我们可以将属性的权限设为private，外部现在只能通过方法来获取成员属性，而我们可以在这个方法中进行一些额外的操作，比如小明可以修改名字，但是不能包含“小”这个字：
>
>```java
>public void setName(String name) {
>if (name.contains("小")) return;
>this.name = name;
>}
>```
>
>我们甚至可以将构造方法设为私有，需要通过我们内部的方式来构造对象：
>
>```java
>public class Person {
>private String name;
>private int age;
>private String sex;
>
>private Person() {}
>
>public static Person getInstance() {
>   return new Person();
>}
>}
>```
>
>通过这种方式，我们可以实现单例模式
>
>```java
>public class Test {
>    private static Test instance;
>    private Test(){}
>    public static Test getInstance() {
>        if (instance == null)
>            instance = new Test();
>        return instance;
>    }
>}
>```
>
>封装思想其实就是把实现细节给隐藏了，外部只需要知道这个方法是什么作用，而无需关心实现，要用什么由类自己来做，不需要外面来操作类内部的东西，封装就是通过访问权限控制来实现的
>
>
>
>类的继承
>
>在定义不同类的时候存在一些相同属性，为了方便实用可以将这些共同属性抽象成一个父类，在定义其他子类时可以继承自该父类，减少代码的重复定义，子类可以使用父类中非私有的成员。
>
>如果父类存在一个有参构造方法，子类必须在构造方法中调用：
>
>```java
>public class Person {
>    private String name;
>    private int age;
>    private String gender;
>
>    // 可以使用protected, 只能子类和同包用
>    protected Person(String name, int age, String gender) {
>        this.name = name;
>        this.age = age;
>        this.gender = gender;
>    }
>}
>public class Student extends Person {
>
>    public Student(String name, int age, String gender) {
>        // 父类构造调用必须在最前面
>        super(name, age, gender);
>        //...
>    }
>}
>```
>
>子类在构造时，不仅要初始化子类的属性，还需要初始化父类的属性，所以说在默认情况下，子类其实是调用了父类的构造方法的，在无参的情况下可以省略。
>
>我们在使用子类时，可以将其当做父类来使用：
>
>```java
>public static void main(String[] args) {
>    Person person = new Student("",0,"");//使用父类类型变量，去引用一个子类对象（向上转型）
>    person.hello();//父类对象的引用相当于当做父类来使用，只能访问父类对象内容
>}
>```
>
>
>
>
>
>Object类
>方法的重写
>抽象类
>接口
>
>

枚举类
基本类型包装类
特殊包装类
一维数组
多维数组
可变长参数
字符串
StringBuilder类
正则表达式

## 初级-内部类

### 成员内部类
成员内部类是在类里面定义了一个类，这个类是属于对象的
```java
public class Test {
    public class Inner {
        public void test() {
            System.out.println("我是成员内部类");
        }
    }
}
```

### 静态内部类和局部内部类

### 匿名内部类


### lambda 表达式

方法引用

异常机制

抛出异常

异常的处理

断言表达式

数学工具类

数组工具类



## 中级

泛型

泛型类

泛型与多态

泛型方法

泛型界限

类型擦除机制

四大函数式接口

判空包装类

数据结构基础 顺序表 链表 栈 队列 二叉树 平衡二叉树 红黑树 哈希表

集合类

集合根接口

List列表

迭代器

Queue和Deque

Set集合

Map映射

Stream流

Collections工具类

集合类对象相等判定





## 高级

Java I/O

相对路径和绝对路径

文件字节输入流

> 使用完成一个流之后，必须关闭这个流来完成对资源的释放，否则资源会一直占用
>
> ```java
> public static void main(String[] args) {
>     FileInputStream stream = null;
>     try {
>         stream = new FileInputStream("src/main/resources/test");
>         // xxx
>     } catch (FileNotFoundException e) {
>         e.printStackTrace();
>     } finally {
>         try {
>             if (stream != null) stream.close();
>         } catch (IOException e) {
>             e.printStackTrace();
>         }
>     }
> }
> ```
>
> 虽然这样的写法才是最保险的，但是显得过于繁琐了，尤其是finally中再次嵌套了一个try-catch块，因此jdk1.7新增了 try-with-resource 语法 用来简化这样的写法
>
> ```java
> public static void main(String[] args) {
>     try (FileInputStream stream = new FileInputStream("src/main/resources/test");) {
>         System.out.println(stream);
>     } catch (IOException e) {
>         e.printStackTrace();
>     }
> }
> ```
>
> 通过网络进行传输文件就是接收二进制字节数据，这个过程就像水流一样，对方流过一点这边接收一点
>
> ```java
> public static void main(String[] args) {
>     try (FileInputStream stream = new FileInputStream("src/main/resources/test");) {
>         int i = stream.read();
>         System.out.println((char) i); // 只打印第一个字符
> 
>     } catch (IOException e) {
>         e.printStackTrace();
>     }
> }
> ```
>
> 当所有字符打印完毕如果继续获取流的话返回-1
>
> 所以打印所有字符就只需要一个while循环即可
>
> ```java
> public static void main(String[] args) {
>     try (FileInputStream stream = new FileInputStream("src/main/resources/test");) {
>         int i;
>         while ((i = stream.read()) != -1) {
>             System.out.print((char) i);
>         }
>     } catch (IOException e) {
>         e.printStackTrace();
>     }
> }
> ```
>
> 我们可以通过一下方式一次获取文件中所有字符串（仅限纯文本）
>
> ```java
> public static void main(String[] args) {
>     try (FileInputStream stream = new FileInputStream("src/main/resources/test");) {
>         byte[] bytes = new byte[stream.available()]; //文件字节数
>         stream.read(bytes);
>         System.out.println(new String(bytes));
> 
>     } catch (IOException e) {
>         e.printStackTrace();
>     }
> }
> ```
>
> 通过stream.skip(n)可以跳过任意n个字符

文件字节输出流

>我们可以向文件中写入内容
>
>```java
>public static void main(String[] args) {
>    try (FileOutputStream stream = new FileOutputStream("src/main/resources/test", true)) { // 追加模式 默认false
>        stream.write("Hello World!".getBytes());
>        stream.flush();  // 强制刷新
>
>    } catch (IOException e) {
>        e.printStackTrace();
>    }
>}
>```
>
>复制文件
>
>```java
>public static void main(String[] args) {
>    try (FileInputStream stream = new FileInputStream("src/main/resources/抽瑶瑶.mp4");
>        FileOutputStream stream1 = new FileOutputStream("src/main/resources/xxx.mp4")) {
>        byte[] bytes = new byte[1024];
>        int len;
>        while ((len = stream.read(bytes)) != -1) {
>            stream1.write(bytes, 0, len);
>        }
>
>    } catch (IOException e) {
>        e.printStackTrace();
>    }
>}
>```

文件字符流

> ```java
> public static void main(String[] args) {
>     try (FileReader fileReader = new FileReader("src/main/resources/test")) {
>         System.out.println((char) fileReader.read());
>         System.out.println((char) fileReader.read());
>         System.out.println((char) fileReader.read());
>         System.out.println((char) fileReader.read());
> 
>     } catch (IOException e) {
>         e.printStackTrace();
>     }
> }
> ```
>
> ```java
> public static void main(String[] args) {
>     try (FileWriter writer = new FileWriter("src/main/resources/test")) {
>         writer.write("A"); // 可以直接写入字符串
> 
>     } catch (IOException e) {
>         e.printStackTrace();
>     }
> }
> ```
>
> 对于纯文本文件用FileReader 和 FileWriter 来操作就更加方便了
>
> 文本文件拷贝
>
> ```java
> public static void main(String[] args) {
>     try (FileReader reader = new FileReader("src/main/resources/test");
>          FileWriter writer = new FileWriter("src/main/resources/xxx")) {
>         char[] chars = new char[3];
>         int len;
>         while ((len = reader.read(chars)) != -1) {
>             writer.write(chars, 0, len);
>         }
> 
>     } catch (IOException e) {
>         e.printStackTrace();
>     }
> }
> ```
>
> 

文件对象

缓冲流

转换流

打印流

数据流和对象流

集合类与IO实战：图书管理系统

多线程

线程的创建和启动

线程的休眠和中断

线程的优先级

线程锁和线程同步

死锁

wait和notify方法

ThreadLocal的使用

定时器

守护线程

再谈集合类

多线程实战：生产者和消费者

认识反射

Class类详解

Class类与多态

反射创建类对象

反射调用类方法

反射修改类属性

类加载器

注解

