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
    * 对于数组的输出不需要一个一个遍历，类似auto的操作
    		
    		for(String[] s : result){
      		System.out.println(s[0] + "," + s[1] + "," + 			s[2]);
    		}
    * 自定义排序方法，Collections大写，有s；Comparator大写
    
    		Collections.sort(result, new Comparator<String[]>(){
     		 @Override
      		public int compare(String[] r1, String[] r2){
        	return r1[1].compareTo(r2[1]);
      		}
    		});

* 在声明数组的时候需要确定大小
	* int[] array = new array[5];
	* String[] name = {"ONE HUNDRED", "FIFTY", "TWENTY","TEN","FIVE","TWO","ONE","HALF DOLLAR","QUARTER","DIME","NICKEL","PENNY"};如果直接声明初始值注意用{}
	* 如果声明空也要初始化

			String result = "";

* 在声明一个对象的时候需要（）
	* Map<Integer, Interget> map = new HashMap<Integer, Integet>();也可以写成HashMap<String,Integer> map = new HashMap<>();

*  Map
	* map.containsKey()来判断某个key是否存在
	* map.put(key,value)来插入新的键值对
	* map.get(key)用来获取key所对应的value

* Linked List
	* 获取结构题中的值直接用"."来获得相应的属性即可，不需要区分值还是地址

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
	