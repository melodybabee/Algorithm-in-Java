# Java涉及的知识点
* General
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
    * 拆箱和装箱：为了编程的方便还是引入了基本数据类型，但是为了能够将这些基本数据类型当成对象操作，Java为每一个基本数据类型都引入了对应的包装类型（wrapper class），int的包装类就是Integer，从Java 5开始引入了自动装箱/拆箱机制，使得二者可以相互转换。

    ```
    	基本数据类型: boolean，char，byte，short，int，long，float，double
		封装类类型：Boolean，Character，Byte，Short，Integer，Long，Float，Double
    ```
    
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

* 在声明数组的时候需要确定大小
	* int[] array = new array[5];
	* String[] name = {"ONE HUNDRED", "FIFTY", "TWENTY","TEN","FIVE","TWO","ONE","HALF DOLLAR","QUARTER","DIME","NICKEL","PENNY"};如果直接声明初始值注意用{}
	* 如果声明空也要初始化

			String result = "";
* String
	* String在java中作为一个对象要保持对象的操作，比如求长度要用String.length()，而在一个字符串中找某个字符的位置需要String.charAt()

* Integer
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
	
	
* 在声明一个对象的时候需要（）
	* Map<Integer, Interget> map = new HashMap<Integer, Integet>();也可以写成HashMap<String,Integer> map = new HashMap<>();
	* Stack<int> st = new Stack<>();
	* 判断一个对象是否为空要用isEmpty()方法
	* 

*  Map
	* map.containsKey()来判断某个key是否存在
	* map.put(key,value)来插入新的键值对
	* map.get(key)用来获取key所对应的value
	* 建立map,map中仍然套着一个对象的时候Map<String,List<Integer>> map = new HashMap<>();
每当用到这个内部的对象的时候都需要new一个对象出来：List<Integer> list = new ArrayList<Integer>()
	

* Linked List
	* 获取结构题中的值直接用"."来获得相应的属性即可，不需要区分值还是地址
	* Queue是LinkedList的一种，Queue<int[]>q = new LinkedList<>();
	* q.offer()插入并返回true，如果队列已满，则返回false
	  
	  q.poll()移除并返问队列头部的元素，如果队列为空，则返回null

	  q.peek()返回头部元素，如果队列为空，则返回null
     
     java抛出异常和返回阻塞时还有不同的操作【待学习】

* ArrayList： List<String> person=new ArrayList<>(); 
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

* Collections
	* Collections.sort(list) 对list进行排序
	* Collections.shuffle(list) 对list进行随机排序
	* int max = Collections.max(list);int min = Collections.min(list);获取集合最大值、最小值
	*  int index1 = Collections.binarySearch(list2, "Thursday");查找集合指定元素，返回元素所在索引
	*   int index3 = Collections.indexOfSubList(list2, subList);查找子串在集合中首次出现的位置
	*   Collections.swap(list2, 0, 3);交换集合中指定元素的位置

* 常用类
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

* 读取输入流

		InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
		BufferedReader in = new BufferedReader(reader);
		String line;
		while((line = in.readLine()) != null){}
	