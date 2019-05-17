# Java涉及的知识点
## General
	* C++, Java和C#都是静态类型的编程语言，Python，JavaScript是动态类型的编程语言。动态类型的编程语言开发效率往往更高，静态类型的编程语言运行效率往往更高。Java是一门强类型、静态类型的语言。变量声明的时候要指明变量类型，不一定要在声明的时候制定变量的值，变量在声明的时候会有一个默认值。
	* 基本数据类型有8个，分别为byte, short, int, long, float, double, boolean, char
	* while()条件中放的是boolean类型的变量，那么如果判断是否存在要写成 != null的时候表示存在，不能只写出变量来判断是否存在
	* String在java中是一类对象，因此都需要大写。但是比如double是字符类型，因此要小写。通常String划分字符串需要用到

			String[] str = line.split(".")//比如用.来划分
			//读出划分后的值并且转换为double类型
			double first = Double.parseDouble(str[0]);
			double second = Double.parseDouble(str[1]);
	* 类型转换

			//转为int
			int cur = Integer.parseInt(content[2]);
			//转为double
			double second = Double.parseDouble(str[1]);
    * 基本数据类型，分为boolean、byte、int、char、long、short、double、float； 引用数据类型 ，分为数组、类、接口。

		在Java中，所有值也都有类型，不同的值有不同的范围。
		
		```
		int:   -2^31-2^31-1, 约为2147483648，是一个10位数字。是一个32位的值,32位表示32个0/1二进制编码，4 byte, 4 byte* 8bits = 32bits,
		long:  需要写成long num = 10000L; 没有后面的L是错的
		float: 范围较小的浮点数, float num = 3.2f, 没有f是错的
		double:范围较大的浮点数，double num = 3.2;
		范围小的值可以默认转换为范围较大的值，而范围较大的值需要通过强制转换才能转换为范围较小的值
		比如：
		3.0f/2 -> 3.0f/2.0f -> 1.5f
		3.2.0f -> 3.0f/2.0f -> 1.5f
		char:  在计算机底层以整数的形式存储，所以每个字符都可以表示为一个数字。占2个字节，2 byte * 8 bits = 16 bits
		char类型小于int, int小于float
		
		```
	
	* ASCII码与unicode

		ASCII码： 0-127；Unicode: 16进制，65536个值，是ASCII码的超集，向下兼容。
		因此可以通过unicode来对字符进行运算以及比较。
		
		```
		int delta = 'a' - 'A'; 
		a is 97, A is 65;
		delta = 32;
		
		'a'<'b' ------> true;
		
		char preChar = 'a';
		char nextChar = (char)(prechar + 1);
		nextChar = 'b';
		
		```
	
    * 拆箱和装箱：为了编程的方便还是引入了基本数据类型，但是为了能够将这些基本数据类型当成对象操作，Java为每一个基本数据类型都引入了对应的包装类型（wrapper class），int的包装类就是Integer，从Java 5开始引入了自动装箱/拆箱机制，使得二者可以相互转换。

			基本数据类型: boolean，char，byte，short，int，long，float，double
			封装类类型：Boolean，Character，Byte，Short，Integer，Long，Float，Double
    
    * 对于数组的输出不需要一个一个遍历，类似auto的操作
    		
    		for(String[] s : result){
      			System.out.println(s[0] + "," + s[1] + "," + s[2]);
    			}
    			
    * 自定义排序方法，Collections大写，有s；Comparator大写
    
    		Collections.sort(result, new Comparator<String[]>(){
     		 	@Override
      			public int compare(String[] r1, String[] r2){
        		return r1[1].compareTo(r2[1]);
      			}
    		});
    		
    * 判断是否为空isEmpty()方法，if/while语句中默认为boolean类型的值
    * 判断值是否相等
  
    	```
    	int[] a = {1,2};  
    	int[] b = a;  
    	System.out.println(a.equals(b));  
    	
    	int[] a = {1,2};  
    	int[] b = {1,2};  
    	System.out.println(Arrays.equals(a,b));  
    	```
    	另外就是equals 与==
    	
    	```
    	基本数据类型（也称原始数据类型） ：byte,short,char,int,long,float,double,boolean。他们之间的比较，应用双等号（==）,比较的是他们的值。
    	
    	引用数据类型：当他们用（==）进行比较的时候，比较的是他们在内存中的存放地址（确切的说，是堆内存地址）。对于第二种类型，除非是同一个new出来的对象，他们的比较后的结果为true，否则比较后结果为false。因为每new一次，都会重新开辟堆内存空间。
    	
    	Java在声明变量的时候会区分栈内存和堆内存，所有能看到的变量名称是在栈内存上，而变量的地址在堆内存。比如：
    	1 public class StringDemo {
 		2     public static void main(String args[]) {
 		3         String str1 = "Hello";
 		4         String str2 = new String("Hello");
 		5         String str3 = str2; // 引用传递
 		6         System.out.println(str1 == str2); // false
 		7         System.out.println(str1 == str3); // false
 		8         System.out.println(str2 == str3); // true
 		9         System.out.println(str1.equals(str2)); // true
		10         System.out.println(str1.equals(str3)); // true
		11         System.out.println(str2.equals(str3)); // true
		12     }
		13 }
		在栈中有str1,str2,str3三个变量，而在堆上只有str1,str2两个内存地址，str2与str3都指向一个地址。
		
		因此：请解释字符串比较之中“==”和equals()的区别？

 		==：比较的是两个字符串内存地址（堆内存）的数值是否相等，属于数值比较；
 		
 		equals()：比较的是两个字符串的内容，属于内容比较。
 		
		有关对象类型相等判断的时候都使用equals()。
    	
    	```
    	
    * int范围内最大表示为Interger.MAX_VALUE; 初始值赋值需要依次遍历。用Arrays.fill()方法来快速填充.Java里面没有auto.
   
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

  	
## 在声明数组的时候需要确定大小
	* int[] array = new array[5];
	* String[] name = {"ONE HUNDRED", "FIFTY", "TWENTY","TEN","FIVE","TWO","ONE","HALF DOLLAR","QUARTER","DIME","NICKEL","PENNY"};如果直接声明初始值注意用{}
	* 如果声明空也要初始化

			String result = "";
## String
	* String在java中作为一个对象要保持对象的操作，比如求长度要用String.length()，而在一个字符串中找某个字符的位置需要String.charAt()

## Integer
	* (1) Integer是int的包装类；int是基本数据类型；
	* (2) Integer变量必须实例化后才能使用；int变量不需要； 
	* (3) Integer实际是对象的引用，指向此new的Integer对象；int是直接存储数据值 ； 
	* (4) Integer的默认值是null；int的默认值是0。
	* 由于Integer变量实际上是对一个Integer对象的引用，所以两个通过new生成的Integer变量永远是不相等的（因为new生成的是两个对象，其内存地址不同）。
	
	```
		Integer i = new Integer(100);
		Integer j = new Integer(100);
		System.out.print(i == j); //false

	```

	* Integer变量和int变量比较时，只要两个变量的值是向等的，则结果为true（因为包装类Integer和基本数据类型int比较时，java会自动拆包装为int，然后进行比较，实际上就变为两个int变量的比较）
	
	```
		Integer i = new Integer(100);
		int j = 100；
		System.out.print(i == j); //true
	```
	
	* 非new生成的Integer变量和new Integer()生成的变量比较时，结果为false。（因为非new生成的Integer变量指向的是java常量池中的对象，而new Integer()生成的变量指向堆中新建的对象，两者在内存中的地址不同）

	```
		Integer i = new Integer(100);
		Integer j = 100;
		System.out.print(i == j); //false
	```
	
	* int型变量和值的除法运算结果仍是整数，会舍去小数位，而不是下取整,比如-3/2的结果是-1，直接舍弃掉小数部分。
	* 取余操作过程中，正数的余数是正数，负数的余数就是负数。比如14%3 = 3，-14%3 = -3.
	
	
## 在声明一个对象的时候需要（）
	* Map<Integer, Interget> map = new HashMap<Integer, Integet>();也可以写成HashMap<String,Integer> map = new HashMap<>();
	* Stack<int> st = new Stack<>();
	* 判断一个对象是否为空要用isEmpty()方法
	* 

##  Map
	* map.containsKey()来判断某个key是否存在
	* map.put(key,value)来插入新的键值对
	* map.get(key)用来获取key所对应的value
	* 建立map,map中仍然套着一个对象的时候Map<String,List<Integer>> map = new HashMap<>();
每当用到这个内部的对象的时候都需要new一个对象出来：List<Integer> list = new ArrayList<Integer>()
	* Map是java中的接口，Map.Entry是Map的一个内部接口。
	
		keySet()方法返回值是Map中key值的集合；entrySet()的返回值也是返回一个Set集合，此集合的类型为Map.Entry。
		
		Map.Entry是Map声明的一个内部接口，此接口为泛型，定义为Entry<K,V>。它表示Map中的一个实体（一个key-value对）。接口中有getKey(),getValue（）方法。
	
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
	
## List
	* List列表类，顺序存储任何对象（顺序不变），可重复。
	* List是继承于Collection的接口，不能实例化。实例化可以用:
		* ArrayList(实现动态数组)，查询快（随意访问或顺序访问），增删慢。整体清空快，线程不同步(非线程安全)。数组长度是可变的百分之五十延长.顺序存储是将数据元素存放于一个连续的存储空间中，实现顺序存取或(按下标)直接存取。存储效率高，速度快。但空间大小一经定义，在程序整个运行期间不会发生改变，因此，不易扩充。同时，由于在插入或删除时，为保持原有次序(没有规定元素进栈顺序)，平均需要移动一半(或近一半)元素，修改效率不高。
    	* LinkedList（实现链表），查询慢，增删快。链接存储表示的存储空间一般在程序的运行过程中动态分配和释放，且只要存储器中还有空间，就不会产生存储溢出的问题。同时在插入和删除时不需要保持数据元素原来的物理顺序，只需要保持原来的逻辑顺序，因此不必移动数据，只需修改它们的链接指针，修改效率较高。但存取表中的数据元素时，只能循链顺序访问，因此存取效率不高。
    	* Vector（实现动态数组），都慢，被ArrayList替代。长度任意延长。线程安全（同步的类，函数都是synchronized）
    	* Stack（实现堆栈）继承于Vector，先进后出。
    * 快速访问ArrayList，快速增删LinkedList，单线程都可以用，多线程只能用同步类Vector
    * list基本操作
    	* 插入：add()
    	* 查找：get()
    	* 删除：remove(int index)
    	* 修改：set()
    	* 清空表：clear()

## Linked List
	* 获取结构题中的值直接用"."来获得相应的属性即可，不需要区分值还是地址
	* Queue是LinkedList的一种，Queue<int[]>q = new LinkedList<>();
	* q.offer()插入并返回true，如果队列已满，则返回false
	  
	  q.poll()移除并返问队列头部的元素，如果队列为空，则返回null

	  q.peek()返回头部元素，如果队列为空，则返回null
     
     java抛出异常和返回阻塞时还有不同的操作【待学习】

## ArrayList： List<String> person=new ArrayList<>(); 
[举例的链接](https://www.cnblogs.com/epeter/p/5648026.html) 
	* 添加方法是：.add(e)；　　
	* 获取方法是：.get(index)；　
	* 按照索引删除；.remove(index） 
	* 按照元素内容删除: .remove(Object o)；
	* 方法：.contains（Object o）； 返回true或者false
	* list中根据索引将元素数值改变(替换)：注意 .set(index, element); 和 .add(index, element); 的不同；
	* 判断list是否为空；person.isEmpty(),空则返回true，非空则返回false
	* List中是数组类型，List<String[]> result = new ArrayList<>();
	* 取list的长度要用size()

## PriorityQueue
 	* 优先队列的作用是能保证每次取出的元素都是队列中权值最小的（Java的优先队列每次取最小元素，C++的优先队列每次取最大元素),具体说是通过完全二叉树（complete binary tree）实现的小顶堆（任意一个非叶子节点的权值，都不大于其左右子节点的权值）
 	*  add()和offer()都是向优先队列中插入元素，只是Queue接口规定二者对插入失败时的处理不同，前者在插入失败时抛出异常，后则则会返回false
 	*  element()和peek()的语义完全相同，都是获取但不删除队首元素，也就是队列中权值最小的那个元素，二者唯一的区别是当方法失败时前者抛出异常，后者返回null
 	*  remove()和poll()方法的语义也完全相同，都是获取并删除队首元素，区别是当方法失败时前者抛出异常，后者返回null
 	*  PriorityQueue()使用默认的初始容量创建一个 PriorityQueue，并根据其自然顺序来排序其元素（使用 Comparable）。

 		PriorityQueue(int initialCapacity)使用指定的初始容量创建一个 PriorityQueue，并根据其自然顺序来排序其元素（使用 Comparable）。
 		
 		PriorityQueue(int initialCapacity, Comparator<? super E> comparator)使用指定的初始容量创建一个 PriorityQueue，并根据指定的比较器comparator来排序其元素。

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
	* Set集合存储顺序无序，不可以保存重复元素。
	* Set set = new HashSet();HashSet类中没有提供根据集合索引获取索引对应的值的方法，     
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

TreeSet是可以保持自然顺序或者定义的比较器比较的结果顺序的Set集合。

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
## 读取输入流

	```	
	InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
	BufferedReader in = new BufferedReader(reader);
	String line;
	while((line = in.readLine()) != null){}
	
	
	方法1：通过 Scanner:
	Scanner input = new Scanner(System.in);
	String s  = input.nextLine();
	input.close();
	
	方法2：通过 BufferedReader:
	BufferedReader input = new BufferedReader(new InputStreamReader(System.in)); 
	String s = input.readLine(); 
	
	```

## API
	* java.util.Arrays；
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
