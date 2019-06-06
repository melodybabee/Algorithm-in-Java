
# Java涉及的知识点

# ToDo
1.https://blog.csdn.net/renfufei/article/details/16905777
array: length,因为array的长度是不可变的，length作为一个属性存在
String, 其他泛型，因为是对象，所以需要调用方法来获取长度
Q:为什么String需要调用length()而泛型是size()? String的特殊之处在哪里

2. ArrayList源码

3. LinkedList源码

4. HashTable源码

5. https://blog.csdn.net/erlian1992/article/details/51298276 有关接口看这个链接的例子


## General
#### 1. C++, Java和C#都是静态类型的编程语言，Python，JavaScript是动态类型的编程语言。动态类型的编程语言开发效率往往更高，静态类型的编程语言运行效率往往更高。Java是一门强类型、静态类型的语言。变量声明的时候要指明变量类型，不一定要在声明的时候制定变量的值，变量在声明的时候会有一个默认值。
#### 2. 基本数据类型有8个，分别为byte, short, int, long, float, double, boolean, char
#### 3. while()条件中放的是boolean类型的变量，那么如果判断是否存在要写成 != null的时候表示存在，不能只写出变量来判断是否存在
#### 4. String在java中是一类对象，因此都需要大写。但是比如double是字符类型，因此要小写。通常String划分字符串需要用到

```
//比如用.来划分
String[] str = line.split(".")
//读出划分后的值并且转换为double类型
double first = Double.parseDouble(str[0]);
double second = Double.parseDouble(str[1]);

```

#### 5.类型转换

```
//转为int
int cur = Integer.parseInt(content[2]);
//转为double
double second = Double.parseDouble(str[1]);

```

#### 6.基本数据类型，分为boolean、byte、int、char、long、short、double、float； 引用数据类型 ，分为数组、类、接口。

在Java中，所有值也都有类型，不同的值有不同的范围。

```		
int:   -2^31-2^31-1, 约为2147483648，是一个10位数字。是一个32位的值,32位表示32个0/1二进制编码，4 byte, 4 byte* 8bits = 32bits
long:  需要写成long num = 10000L; 没有后面的L是错的
float: 范围较小的浮点数, float num = 3.2f, 没有f是错的
double:范围较大的浮点数，double num = 3.2;
范围小的值可以默认转换为范围较大的值，而范围较大的值需要通过强制转换才能转换为范围较小的值
比如：3.0f/2 -> 3.0f/2.0f -> 1.5f
     3.2.0f -> 3.0f/2.0f -> 1.5f
char:  在计算机底层以整数的形式存储，所以每个字符都可以表示为一个数字。占2个字节，2 byte * 8 bits = 16 bits,表示需要用16个0，1位的二进制来表示
char类型小于int, int小于float
```
	
#### 7.ASCII码与unicode

ASCII码： 0-127；

Unicode: 16进制，65536个值，是ASCII码的超集，向下兼容。

因此可以通过unicode来对字符进行运算以及比较。
		
```
int delta = 'a' - 'A'; 
a is 97, 
A is 65;
delta = 32;
'a'<'b' ------> true;
	
char preChar = 'a';
char nextChar = (char)(prechar + 1);
nextChar = 'b';
```
	
#### 8.拆箱和装箱：
为了编程的方便还是引入了基本数据类型，但是为了能够将这些基本数据类型当成对象操作，Java为每一个基本数据类型都引入了对应的包装类型（wrapper class），int的包装类就是Integer，从Java 5开始引入了自动装箱/拆箱机制，使得二者可以相互转换。

基本数据类型: boolean，char，byte，short，int，long，float，double
封装类类型：Boolean，Character，Byte，Short，Integer，Long，Float，Double
    
#### 9.对于数组的输出不需要一个一个遍历，类似auto的操作

```		
for(String[] s : result){
	System.out.println(s[0] + "," + s[1] + "," + s[2]);
}
```
    			
#### 10.自定义排序方法，Collections大写，有s；Comparator大写

```
Collections.sort(result, new Comparator<String[]>(){
 	@Override
	public int compare(String[] r1, String[] r2){
		return r1[1].compareTo(r2[1]);
	}
});
```
    		
#### 11.判断是否为空isEmpty()方法，if/while语句中默认为boolean类型的值
    	
    	
#### 12.int范围内最大表示为Interger.MAX_VALUE; 初始值赋值需要依次遍历。用Arrays.fill()方法来快速填充.Java里面没有auto.
   
```
for(int[] a: dp){
    Arrays.fill(a, Integer.MAX_VALUE);
}
```
但是如果是long类型就要用Long.MAX_VALUE;
  	 	
* 在调用结构体中的元素值的时候用.,比如树结构中要用root.val
* 数组的大小为length,String的大小为length(),其他泛型的大小为size()
* isEmpty()等同于size()==0,已经分配了空间但是里面没有元素。 == null 表示根本没有分配空间。
* public String substring(int beginIndex)起始索引（包括）, 索引从 0 开始。public String substring(int beginIndex, int endIndex)endIndex -- 结束索引（不包括）。

#### 13.Array数组
```
int[] score = new int[此处需要标记数组的大小];
int[] score = new int[]{1,2,3,4};
int[] score = {1,2,3,4};
```

## 函数

#### 1.为什么需要有函数（input + function + output)

* 增加代码复用 code reuse
* 增加程序的可读性 readability

#### 2.执行过程

函数中只要有return就直接结束当前的函数

##### 调用过程：
```
public class functionExample {
    public static void main(String[] args) {
        Student stu = new Student("Jack", 89);
        stu.setScore(70);
        System.out.println(stu.getScore());
        //在调用getScore()方法的时候当前的函数会stop,直到得到getScore()中的return值之后继续运行
        System.out.println("The end of function");
    }
}

class Student {
    public String name;
    public int score;
    
    public int getScore() {
        return score;
    }
}
```
#### 3.传参过程 copy value

```
public class Main {

    public static void main(String[] args) {

        // Function
        int score = 100;
        char grade = getGrade(score); // char grade = 'A';

        int number1 = 10;
        int number2 = 20;
        swap(number1, number2);

        System.out.println(number1);
        System.out.println(number2);
        //10，20
    }
    
    //调用函数的时候会复制properties,其中a,b复制了number1,number2的值，而number1,number2本身不变
    public static void swap(int a, int b) {
        int t = a;
        a = b;
        b = t;
    }
}
```

## 接口 interface

#### 1.List接口

ArrayList实现了List接口，可以实现和调用list方法。List是一个接口，而ArrayList是List接口的一个实现类。 
  	
## ArrayList

#### 1.在声明数组的时候需要确定大小

```
int[] array = new array[5];
//如果直接声明初始值注意用{}
String[] name = {"ONE HUNDRED", "FIFTY", "TWENTY","TEN","FIVE","TWO","ONE","HALF DOLLAR","QUARTER","DIME","NICKEL","PENNY"};
//如果声明空也要初始化
String result = "";

```

#### 2.数据结构： Data + 结构 + 操作

```
//ArrayList调用了List接口
//其中<>中可以放各种类型，称为泛型。不可以放int,不能放入基本数据类型
ArrayList<Integer> arrayList = new ArrayList<>();
```

通常数据结构需要进行增删改查的操作，CRUD (create,read,update,delete)

```
arrayList.add(10); [10]
arrayList.add(0,11); [11,10]

//read
arrayList.get(0); [11]
for (int i = 0; i < arrayList.size(); ++i) {
	arrayList.get(i);
}

//update
arrayList.set(1,12); [11,12]

//delete
arrayList.remove(0); [12]
arrayList.clear(); []
```
 
#### 3.其他操作
```
List<String> person=new ArrayList<>(); 
person.contains（Object o); 返回true或者false
person.isEmpty(); 空则返回true，非空则返回false
List中是数组类型，List<String[]> result = new ArrayList<>();
取list的长度要用person.size()

```

## String

#### 1.类型属性

String类型大于8种基本类型，其本身也是一个类，但是因为常用开辟了绿色通道

```
String str1 = new String("12345");
等同于
String str2 = "12345";
```
上面的str1与str2都是reference,因此String类型是不可变的。如果需要改变String中的内容，需要用到StringBuilder来进行操作，用StringBuilder.serCharAt()方法。

#### 2.常用方法

* concat:连接，可以与任何类型作操作

	```
	String str = "a string";
	boolean b = true;
	str += b; // str: “a stringtrue”
	float f = 18.123f;
	str += f; // str: "a stringtrue18.123"
	```
* 获取长度
  
  str.length() 需要调用函数，因此是一个方法

  arr.length是数组的一个属性，因此不写作方法的形式

* 获取字符

	String.charAt(i)
	
#### 3.比较相等
  
* equals 与 ==
    	
	* 基本数据类型（也称原始数据类型） ：
	
	  byte,short,char,int,long,float,double,boolean。他们之间的比较，应用双等号（==）,比较的是他们的值。
    	
	* 引用数据类型：
	  
	  当他们用（==）进行比较的时候，比较的是他们在内存中的存放地址（确切的说，是堆内存地址）。对于第二种类型，除非是同一个new出来的对象，他们的比较后的结果为true，否则比较后结果为false。因为每new一次，都会重新开辟堆内存空间。
		
		```
		int[] a = {1,2};  
		int[] b = a;  
		System.out.println(a.equals(b));  
			
		int[] a = {1,2};  
		int[] b = {1,2};  
		System.out.println(Arrays.equals(a,b));  
		```

    	
* Java在声明变量的时候会区分栈内存和堆内存，所有能看到的变量名称是在栈（基本数据类型和引用型变量的地址）内存上，而引用变量的对象本身在堆内存。比如：

	```
	public class StringDemo {
		public static void main(String args[]) {
			String str1 = "Hello";
			String str2 = new String("Hello");
			String str3 = str2; // 引用传递
			System.out.println(str1 == str2); // false
			System.out.println(str1 == str3); // false
			System.out.println(str2 == str3); // true
			System.out.println(str1.equals(str2)); // true
			System.out.println(str1.equals(str3)); // true
			System.out.println(str2.equals(str3)); // true
		}
	}
	```
	
	在栈中有str1,str2,str3三个变量，而在堆上只有str1,str2两个内存地址，str2与str3都指向一个地址。
		
	E.g：请解释字符串比较之中“==”和equals()的区别？
	
	==：比较的是两个字符串内存地址（堆内存）是否相等
				
	equals()：比较的是两个字符串的内容，属于内容比较
	 		
	有关对象类型相等判断的时候都使用equals()。

## Integer
#### 1.由于Integer变量实际上是对一个Integer对象的引用，所以两个通过new生成的Integer变量永远是不相等的（因为new生成的是两个对象，其内存地址不同）。

(1) Integer是int的包装类；int是基本数据类型；

(2) Integer变量必须实例化后才能使用；int变量不需要； 

(3) Integer实际是对象的引用，指向此new的Integer对象；int是直接存储数据值 ； 

(4) Integer的默认值是null；int的默认值是0。

	
```
Integer i = new Integer(100);
Integer j = new Integer(100);
System.out.print(i == j); //false

```

Integer变量和int变量比较时，只要两个变量的值是向等的，则结果为true（因为包装类Integer和基本数据类型int比较时，java会自动拆包装为int，然后进行比较，实际上就变为两个int变量的比较）
	
```
Integer i = new Integer(100);
int j = 100；
System.out.print(i == j); //true
```
	
非new生成的Integer变量和new Integer()生成的变量比较时，结果为false。（因为非new生成的Integer变量指向的是java常量池中的对象，而new Integer()生成的变量指向堆中新建的对象，两者在内存中的地址不同）

```
Integer i = new Integer(100);
Integer j = 100;
System.out.print(i == j); //false
```
	
#### 2.int型变量和值的除法运算结果仍是整数，会舍去小数位，而不是下取整,比如-3/2的结果是-1，直接舍弃掉小数部分。

#### 3.取余操作过程中，正数的余数是正数，负数的余数就是负数。
比如14%3 = 3，-14%3 = -3.
	
	
#### 4.在声明一个对象的时候需要（）

```
Map<Integer, Interget> map = new HashMap<Integer, Integet>();
也可以写成:
HashMap<String,Integer> map = new HashMap<>();
Stack<int> st = new Stack<>();
```
判断一个对象是否为空要用isEmpty()方法

## Stack

#### 1.特性

LIFO：last in first out 后进先出

#### 2.常用方法

```
Stack<Integer> st = new Stack<>();//注意<>中需要放入泛型，不能放入基本数据类型
st.push(); 压进一个元素
st.pop(); 弹出一个元素，同时返回栈定元素
st.peak(); 获得栈顶元素但是不pop出来新的元素
st.isEmpty(); 判断是否为空
```
#### 3.栈的实现，用LinkedList实现

```
public class MyStack {

	//建立ListNode类型的变量，在ListNode类中建立属性和构造函数
    private ListNode head;
    
    //在头结点的前面插入新的元素
    public void push(int value) {
        ListNode newHead = new ListNode(value);
        newHead.next = head;
        head = newHead;
    }

	//返回并弹出第一个值
    public int pop() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        int ret = head.val;
        head = head.next;
        return ret;
    }
    
    //返回第一个值
    public int peek() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        return head.val;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void clear() {
        head = null;
    }  
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}

```
#### 4.函数调用栈 call stack

先执行的函数最后结束，后执行的函数先结束，操作系统用来保存函数的状态。

例如：

```
public class OsStackExample {

    public static void main(String[] args) {
        int num = 10;
        //在主函数中遇到foo(),停止，调用foo()
        foo();
    }

    public static void foo() {
        String name = "abc";
        //在foo()中遇到bar(),停止，调用bar()
        bar();
        //得到bar()返回结果，继续执行foo()
    }

    public static void bar() {
    	//在bar()中遇到baz(),停止，调用baz()
        baz();
		//得到baz()返回结果，继续执行bar()
        int[] arr = new int[] {1, 2, 3};
        for(int elem : arr) {
            System.out.println(elem);
        }
    }

    public static void baz() {
        ListNode listNode = new ListNode(0);
        //baz()执行完毕，返回
    }
}
```

其中临时变量存在栈中，对象入堆。

```
String name = "abc";中的name存入栈，"abc"对象入堆。
```
那么在Java的栈中，由顶部到底部包括了：

```
listNode addr in heap
bar pc
foo pc
name addr in heap(在堆中的name引用指向的地址信息）
main pc(program counter记录函数的地址）
10

```
执行完baz()函数之后再逐渐以此弹出。


## Queue

#### 1.特性

FIFO，先进先出

#### 2.基本操作

```
Queue<int[]> q = new LinkedList<>(); //Queue是一个interface,继承了LinkedList类

q.offer();插入并返回true，如果队列已满，则返回false
	  
q.poll();移除并返问队列头部的元素

q.peek();返回头部元素

q.isEmpty();

enqueue 进队列

dequeue 出队列
```
#### 3.Queue的实现，用LinkedList

```
public class MyQueue {
    private ListNode head;
    private ListNode tail;

	//要从后面插入新的结点，因此需要一个tail指针在链表的尾部便于插入
    public void offer(int val) {
        if (tail == null) {
            head = tail = new ListNode(val);
        } else {
            tail.next = new ListNode(val);
            tail = tail.next;
        }
    }

    public int poll() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        int ret = head.val;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return ret;
    }

    public int peek() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        return head.val;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void clear() {
        head = tail = null;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}

```
#### 4.消息队列 message queue

计算机所有的操作都可以认为是一种消息模式，操作系统需要处理每一个消息，所有的操作形成了消息队列，先到先进行处理。  


## Map (index, dictionary, key-value pair)

#### 1.特点

key值唯一的key-value对

#### 2.操作
```
map.containsKey();来判断某个key是否存在
map.put(key,value);来插入新的键值对,如果put的key已经存在，会覆盖
map.get(key);用来获取key所对应的value,时间复杂度O(1)
map.size();

//建立map,map中仍然套着一个对象的时候
Map<String,List<Integer>> map = new HashMap<>();

//当用到这个内部的对象的时候都需要new一个对象出来：
List<Integer> list = new ArrayList<Integer>();

//遍历map,注意遍历了key set
for (String key : map.keySet()) {
	System.print.out(key + map.get("key"));
}

```
#### 3.Map是java中的接口，Map.Entry是Map的一个内部接口。
	
* keySet()方法返回值是Map中key值的集合；

* entrySet()的返回值也是返回一个Set集合，此集合的类型为Map.Entry。
		
* Map.Entry是Map声明的一个内部接口，此接口为泛型，定义为Entry<K,V>。它表示Map中的一个实体（一个key-value对）。接口中有getKey(),getValue（）方法。
	
```
Map<String, String> map = new HashMap<String, String>();    
map.put("key1", "value1");    
map.put("key2", "value2");    
map.put("key3", "value3");    
  
//第一种：普遍使用，二次取值    
System.out.println("通过Map.keySet遍历key和value：");    
for (String key : map.keySet()) {    
	System.out.println("key= "+ key + " and value= " + map.get(key));    
}    
  
//第二种    
System.out.println("通过Map.entrySet使用iterator遍历key和value：");    
Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();    
while (it.hasNext()) {    
	Map.Entry<String, String> entry = it.next();    
	System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());    
}    
  
//第三种：推荐，尤其是容量大时</span>    
System.out.println("通过Map.entrySet遍历key和value");    
	for (Map.Entry<String, String> entry : map.entrySet()) {    
	System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());    
}    
    
//第四种    
System.out.println("通过Map.values()遍历所有的value，但不能遍历key");    
for (String v : map.values()) {    
	System.out.println("value= " + v);    
}

```

#### 4.Hash Table原理

不同的key通过Hash function来形成hash code, 映射到对应的buckets数组上。如果不同的key映射到数组的同一个位置上了，那么会有不同的冲突解决方案collision solution。

##### (1) 哈希函数的特点

* 	确定性：x一定，y就是确定的值
*  不可逆：x可以通过哈希函数得到y，y不能得到x
*  输出的是整数

#####（2）好的哈希函数

* 尽可能的减少碰撞
* 复杂度不是很高，因为复杂度过高会增加时间复杂度
* 通常有module division取余法，mid-square平方取中法，radix function基数转换法，从10进制转换为13进制

#####（3）Java的Hash function

```
for (char c : str) {
	hashCode = 31 * hashCode + C;
}
与Unicode有关，比如Aa = A * 31 + a = 65 * 31 + 97 = 2112; 与BB的值相等；
```
#####（4）冲突解决方案

* 开散列 open hashing/ seperate chaining 拉链法

	数组中的每一个元素是链表的头结点的引用，如果当前位置已经被占用，那么连到后面，查找的时候遍历链表。
	
* 闭散列 close hashing

	一个位置只放一个键值对，有冲突之后则查找其他地方加入。最常见的是线性探查，遇到冲突之后有空的位置就插入。
	
#####（5）负载因子 load factor

哈希表中已有元素/哈希表的容量 = 负载因子指数。

负载因子小于0.5，大部分检索长度小于2； 大于0.5，查找效率急剧下降。 HashTable是以空间换时间的策略。

#####（6）重哈希 rehashing

当元素过多或者过少的时候，重新调整HashTable容量的大小，所有的键值对的位置需要重新摆放。
	
## List

#### 1.List列表类，顺序存储任何对象（顺序不变），可重复。
#### 2.List是继承于Collection的接口，不能实例化。实例化可以用:
* ArrayList(实现动态数组)，查询快（随意访问或顺序访问），增删慢。整体清空快，线程不同步(非线程安全)。数组长度是可变的百分之五十延长.顺序存储是将数据元素存放于一个连续的存储空间中，实现顺序存取或(按下标)直接存取。存储效率高，速度快。但空间大小一经定义，在程序整个运行期间不会发生改变，因此，不易扩充。同时，由于在插入或删除时，为保持原有次序(没有规定元素进栈顺序)，平均需要移动一半(或近一半)元素，修改效率不高。
* LinkedList（实现链表），查询慢，增删快。链接存储表示的存储空间一般在程序的运行过程中动态分配和释放，且只要存储器中还有空间，就不会产生存储溢出的问题。同时在插入和删除时不需要保持数据元素原来的物理顺序，只需要保持原来的逻辑顺序，因此不必移动数据，只需修改它们的链接指针，修改效率较高。但存取表中的数据元素时，只能循链顺序访问，因此存取效率不高。
* Vector（实现动态数组），都慢，被ArrayList替代。长度任意延长。线程安全（同步的类，函数都是synchronized）
* Stack（实现堆栈）继承于Vector，先进后出。

#### 3. 快速访问ArrayList，快速增删LinkedList，单线程都可以用，多线程只能用同步类Vector

#### 4.list基本操作
* 插入：add()
* 查找：get()
* 删除：remove(int index)
* 修改：set()
* 清空表：clear()


## Linked List

#### 1.链表是什么

由结点构成的线性数据结构

```
class ListNode {
	public int val;
	public ListNode next;
	
	//构造函数
	public ListNode(int val){
		this.val = val;
	}
}
```

#### 2.链表的操作

在遍历链表的过程中，想要修改链表必须要通过next来修改。

#### 3.dummy结点

在整个链表的前面插入一个dummy哨兵结点，便于链表的操作与返回。


## Sort:

#### 1.选择排序

* 选择整个数组中最小的元素与第一个元素进行交换
* 每次选取数组中剩下元素的最小值与前面的元素交换

```
public class Main {
    public static void main(String[] args) {
        // selection sort
        int[] nums = {10, 2, 5, -2, 8, 1, 9};
        for (int i = 0; i < nums.length - 1; ++i) {    // n - 1
            int minIndex = i; //i是前面的元素位置，minIndex为了找到剩下的数组中的最小值
            for (int j = i + 1; j < nums.length; ++j) {  // n - 1 - i
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            int t = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = t;

            for (int k = 0; k < nums.length; ++k) {
                System.out.print(nums[k] + " ");
            }
            System.out.println();
        }
        // 时间复杂度：(n - 1) + (n - 2) + (n - 3) + .. + 1 = n * (n - 1) / 2;
    }
}
```
## Set

#### 1.特性

非重复的无序数据结构，可以想象成一个bag.

#### 2.操作

```
Set<Integer> set = new HashSet<>();
set.insert();
set.find();
set.delete();
set.contains();判断某个元素是否存在
set.size();

//遍历set
for (int num : set) {

}

```

#### 3.set的迭代器

Set<Integer> set = new HashSet<>();HashSet类中没有提供根据集合索引获取索引对应的值的方法。    
因此遍历HashSet时需要使用Iterator迭代器。Iterator的主要方法如下：

```
public static void main(String args[]) {
	Set set = new HashSet();
	set.add("apple");
	set.add("orange");
	set.add("pear");
	set.add("pear");//重复元素不能加入
	set.add("banana");
	Iterator iterator = set.iterator();
	//定义迭代器
	while(iterator.hasNext())//如果有下一位
	{
		System.out.println(iterator.next());//输出下一位上的值
	}      
 }

```

#### 4.TreeSet和HashSet
TreeSet是可以保持自然顺序或者定义的比较器比较的结果顺序的Set集合，有序，由平衡树组成，log(n)。

HashSet是O(1)的时间复杂度。


## PriorityQueue

#### 1.优先队列的作用:

能保证每次取出的元素都是队列中权值最小的（Java的优先队列每次取最小元素，C++的优先队列每次取最大元素),具体说是通过完全二叉树（complete binary tree）实现的小顶堆（任意一个非叶子节点的权值，都不大于其左右子节点的权值）

#### 2.操作

* add()和offer()都是向优先队列中插入元素，只是Queue接口规定二者对插入失败时的处理不同，前者在插入失败时抛出异常，后则则会返回false
* element()和peek()的语义完全相同，都是获取但不删除队首元素，也就是队列中权值最小的那个元素，二者唯一的区别是当方法失败时前者抛出异常，后者返回null
*  remove()和poll()方法的语义也完全相同，都是获取并删除队首元素，区别是当方法失败时前者抛出异常，后者返回null
*  PriorityQueue()使用默认的初始容量创建一个 PriorityQueue，并根据其自然顺序来排序其元素（使用 Comparable）。

* PriorityQueue(int initialCapacity)使用指定的初始容量创建一个 PriorityQueue，并根据其自然顺序来排序其元素（使用 Comparable）。
 		
* PriorityQueue(int initialCapacity, Comparator<? super E> comparator)使用指定的初始容量创建一个 PriorityQueue，并根据指定的比较器comparator来排序其元素。

## Collections
* Collections.sort(list) 对list进行排序
* Collections.shuffle(list) 对list进行随机排序
* int max = Collections.max(list);int min = Collections.min(list);获取集合最大值、最小值
*  int index1 = Collections.binarySearch(list2, "Thursday");查找集合指定元素，返回元素所在索引
*   int index3 = Collections.indexOfSubList(list2, subList);查找子串在集合中首次出现的位置
*   Collections.swap(list2, 0, 3);交换集合中指定元素的位置

## 常用类
* ArrayList用法类似于数组，且其容量可按需要动态调整，亦被称为动态数组
* LinkedList表示链表的操作类，它同时实现了List和Queue接口。它的优点在于向集合中插入、删除元素时效率比较高，
特别是可以直接对集合的首部和尾部元素进行插入和删除操作，LinkedList提供了专门针对首尾元素的方法

## Comparator
* Arrays.sort(T[],Comparator<? super T> c);
* Collections.sort(List<T> list,Comparator<? super T> c);

```
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortTest {

class Dog{
	public int age;
	public String name;
	
	public Dog(int age, String name) {
    	super();
    	this.age = age;
    	this.name = name;
	}
	
	@Override
 	public String toString() {
    return "Dog [age=" + age + ", name=" + name + "]";
	}
}

public static void main(String[] args) {
	List<Dog> list= new ArrayList<>();
	list.add(new SortTest().new Dog(5, "DogA"));
	list.add(new SortTest().new Dog(6, "DogB"));
	list.add(new SortTest().new Dog(7, "DogC"));
	
	Collections.sort(list, new Comparator<Dog>() {
	
	    @Override
	    //按照数字大小排序
	    //当返回1的时候排序方式是 t2,t1
	    //当返回0的时候排序方式是 t1,t2
	    //当返回-1的时候排序方式是t1,t2
	    //注意
	    //返回值大于1效果等同于1
	    //返回值小于1 效果等同于0，-1
	    public int compare(Dog o1, Dog o2) {
	    	return o2.age - o1.age;
	    }
	});
	
	System.out.println("给狗狗按照年龄倒序："+list);
	Collections.sort(list, new Comparator<Dog>() {
	
	    @Override
	    //按照字典序排序
	    public int compare(Dog o1, Dog o2) {
	    	return o1.name.compareTo(o2.name);
	    }
	});
	
	System.out.println("给狗狗按名字字母顺序排序："+list);
	
	}
}

```
* 读取输入流

```
InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
BufferedReader in = new BufferedReader(reader);
String line;
while((line = in.readLine()) != null){}

```

## 类与对象

#### 1.类与对象的联系和区别

类是对象的蓝图，class是对现实事物的抽象，用类来创建对象，比如 class car；

```
class Car {

	   //为成员变量，表示对象的属性
       public int ID;
       public String name;
       
      //成员函数，表示对象的行为
       public run(){
       
       }
}
```

对象是实例,比如宝马、奔驰、奥迪

```
Car car = new Car();
```
X.X是用来访问Object的属性。

#### 2.命名规则

* 类的命名：UpperCamelCase, eg.MyClass
* 变量的命名：lowerCamelCase
* 函数命名：第一个词是动词

#### 3.构造函数Constructor

如何用类来创建对象：

```
//其中new方法实际上是在调用Student类的构造函数
Student student = new Student();

//构造函数中函数名与类名一致，无返回值，无return,可以重载，常用于初始化对象的属性
public Student() {
}

//重载，可以传参，可以传多个
public Student(String name, int score) {
	//需要用this来指向对象本身的属性，防止名称与参数重复
    this.name = name;
    this.score = score;
}


```
#### 4.Java的修饰符

（1）目的是为了控制访问权限，是封装Encapsulation的一种体现

* public: 都可以用
* protected: 同类，包，子类都可以用
* private: 同类可以用
* default: 同类，包可以用

（2）那么外部如何访问private的变量

* 利用set()和get()方法，设置为public的方法

#### 5.面向对象的3大特性

* 封装Encapsulation：隐藏内部，保留对外接口

	优点：改变程序组织方式，增加代码复用，增加可读性

* 继承Iheritance
* 多态Polymorphism

#### 6.Reference引用

(1) 内存模型

在计算机底层所有的值都要存在内存中，由内存地址来表示。比如按照1001，1002，1003，1004...以此类推进行递增。一个内存地址代表一个内存空间，内存空间大小是一个byte，也就是8 bits.

一个int类型的值占用32位，32bits, 也就是4个内存地址。32位的操作系统的意思是一个内存地址用32bits表示。

补充：32位的操作系统最多支持4GB的内存空间，也就是说CPU只能寻址2的32次方（4GB），注意这里的4GB是以Byte为单位的，不是bit。也就是说有:

```
4G
=4*1024M（Byte）
=4*1024*1024Kb(Byte)
=4*1024*1024*1024bit(Byte)，即2的32次方个8bit单位。

4G
=2^2 GB
=2^12 MB
=2^22 KB
=2^32 bites
表示2^32个数
```

小端存储：按照从低地址到高地址的顺序存放据的低位字节到高位字节

(2) 如何生成一个新的对象

如果是基本数据类型,那么就是原样复制，会在内存空间里再开辟同样的一段空间存入新的值。

```
int num1 = 2;
int num2 = num1;
```

如果是object,比如针对下面这一行代码，复制Student对象。不同于基本数据类型，student2不是原样复制的。

Object并不存储对象本身，存储的是对象所表示的首地址。同时再开辟一块内存来存放student1,这块内存称为heap堆。这样做的目的是因为object中通常会有许多属性，如果每次全部复制需要占用巨大的内存空间，所以不会每次都重新复制。

```
//student1中存放的是对象的地址，不是对象本身
Student student1 = new Student();

//分为两步，首先找到student1的首地址，找到object本身；再修改属性
student1.name = "Tom";

//student1存的是对象的地址，copy也copy了student1的地址。
Student student2 = student1;

```
（3）引用与对象的关系

引用相当于遥控器，对象是电视机。在函数调用过程赋值中，实际上也是引用型变量的使用。

（4）数组也是引用

数组变量会在堆中开辟一片空间存储数组内容。

数组中的空指针异常的问题：

```
Student[] students = new Student[2];
students[0].name = "Jack";//会报空指针异常,nullPointerException

```
因为数组声明出来之后会默认为null,需要在数组中再声明一次后才能调用属性

```
students[0] = new Student();
students[0].name = "Jack";
```

## 算法复杂度

#### 1.含义

表示程序执行时间与输入问题规模之间的关系，通常表示最坏的情况。O表示上界的含义。

* O(n)
* O(n^2)
* O(nlogn) 归并排序
* O（logn)
* O(1) 与n无关

#### 2.不同数据结构的时间复杂度对比

| | ArrayList | LinkedList |
| :------: | :------: | :------:| 
| add()头部添加 | O(n) | O(1)| 
| add()尾部添加 | O(1) | O(n)| 
| add() | O(n) | O(n)|
| get() | O(1) | O(n)|
| set() | O(1) | O(n)|

## API

#### 1.java.util.Arrays；
* Arrays.asList();使用该方法可以将一个变长参数或者数组转换成List(15)
* Arrays.sort();
	
```
String[] names = { "Liz", "John", "Eric", "Alan" };  
//只排序前两个  
//[John, Liz, Eric, Alan]  
Arrays.sort(names, 0, 2);  
//全部排序  
//[Alan, Eric, John, Liz]  
Arrays.sort(names);  
```
* Arrays.toString();Arrays的toString方法可以方便我们打印出数组内容。 
* Arrays.equals();使用Arrays.equals来比较1维数组是否相等。 
* Arrays.fill();给指定数组填充上指定的值
		
```
int[] array1 = new int[8];  
Arrays.fill(array1, 1);  
//[1, 1, 1, 1, 1, 1, 1, 1]  
System.out.println(Arrays.toString(array1));  
```

