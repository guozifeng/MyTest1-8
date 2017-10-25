package com.guo.offer.testdatatype;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * String、StringBuffer、StringBuilder区别
 * StringBuffer、StringBuilder和String�?��，也用来代表字符串�? String类是不可变类，任何对String的改变都
 * 会引发新的String对象的生成； StringBuffer则是可变类，任何对它�?��代的字符串的改变都不会产生新的对象�?
 * 既然可变和不可变都有了，为何还有�?��StringBuilder呢？相信初期的你�? 在进行append时，�?��都会选择StringBuffer吧！
 * 先说�?��集合的故事，HashTable是线程安全的，很多方法都是synchronized方法�?
 * 而HashMap不是线程安全的，但其在单线程程序中的性能比HashTable要高�?
 * StringBuffer和StringBuilder类的区别也是如此，他们的原理和操作基本相同，
 * 区别在于StringBufferd支持并发操作，线性安全的，�? 合多线程中使用�?
 * StringBuilder不支持并发操作，线�?不安全的，不适合多线程中使用�? 新引入的StringBuilder类不是线程安全的�?
 * 但其在单线程中的性能比StringBuffer高�?
 * 
 * 1. 面试题：String，StringBuffer，StringBuilder的区�?�?
 * 
 * 答：String是字符串内容不可变的，�?StringBuffer和StringBuilder是字符串内容长度可变的；
 * 
 * StringBuffer是同步的，数据安全，效率低�?
 * 
 * StringBuilder是不同步的，数据不安全，效率高�?
 * 
 * �?�? 在执行�?度方面的比较：StringBuilder > StringBuffer �?�?
 * StringBuffer与StringBuilder，他们是字符串变量，是可改变的对象，每当我们用它们对字符串做操作时，实际上是在一个对象上操作的，
 * 不像String�?��创建�?��对象进行操作，所以�?度就快了�? �?�? StringBuilder：线程非安全�? �?
 * StringBuffer：线程安全的 当我们在字符串缓冲去被多个线程使用是，JVM不能保证StringBuilder的操作是安全的，虽然他的速度�?��，
 * 但是可以保证StringBuffer是可以正确操作的。当然大多数情况下就是我们是在单线程下进行的操作，
 * 所以大多数情况下是建议用StringBuilder而不用StringBuffer的，就是速度的原因�?
 * 
 * 对于三�?使用的�?结：�?如果要操作少量的数据�?= String �??�??�?? �?单线程操作字符串缓冲�?下操作大量数�?=
 * StringBuilder �??�??�?? �?多线程操作字符串缓冲�?下操作大量数�?= StringBuffer
 * 
 * 
 * 
 * 注意：为�?��StringBuffer具有数据安全的特�?
 * 
 * 
 * 2. 面试题：StringBuffer 和数组的区别�?
 * 
 * 答：二�?都可以看出是�?��容器，装其他的数据�?但是呢，StringBuffer的数据最终是�?��字符串数据，而数组可以放置任意类型的同一种数据�?
 * 
 * 
 * 
 * @author Administrator
 *
 */
public class TestString {

	public static String BASEINFO = "Mr.Y";
	public static final int COUNT = 2000000;

	/**
	 * 执行�?��String赋�?测试
	 */
	public static void doStringTest() {

		String str = new String(BASEINFO);
		long starttime = System.currentTimeMillis();
		for (int i = 0; i < COUNT / 100; i++) {
			str = str + "miss";
		}
		long endtime = System.currentTimeMillis();
		System.out.println((endtime - starttime) + " millis has costed when used String.");
	}

	/**
	 * 执行�?��StringBuffer赋�?测试
	 */
	public static void doStringBufferTest() {

		StringBuffer sb = new StringBuffer(BASEINFO);
		long starttime = System.currentTimeMillis();
		for (int i = 0; i < COUNT; i++) {
			sb = sb.append("miss");
		}
		long endtime = System.currentTimeMillis();
		System.out.println((endtime - starttime) + " millis has costed when used StringBuffer.");
	}

	/**
	 * 执行�?��StringBuilder赋�?测试
	 */
	public static void doStringBuilderTest() {

		StringBuilder sb = new StringBuilder(BASEINFO);
		long starttime = System.currentTimeMillis();
		for (int i = 0; i < COUNT; i++) {
			sb = sb.append("miss");
		}
		long endtime = System.currentTimeMillis();
		System.out.println((endtime - starttime) + " millis has costed when used StringBuilder.");
	}

	/**
	 * 测试StringBuffer遍历赋�?结果
	 * 
	 * @param mlist
	 */
	public static void doStringBufferListTest(List<String> mlist) {
		StringBuffer sb = new StringBuffer();
		long starttime = System.currentTimeMillis();
		for (String string : mlist) {
			sb.append(string);
		}
		long endtime = System.currentTimeMillis();
		System.out.println(sb.toString() + "buffer cost:" + (endtime - starttime) + " millis");
	}

	/**
	 * 测试StringBuilder迭代赋�?结果
	 * 
	 * @param mlist
	 */
	public static void doStringBuilderListTest(List<String> mlist) {
		StringBuilder sb = new StringBuilder();
		long starttime = System.currentTimeMillis();
		for (Iterator<String> iterator = mlist.iterator(); iterator.hasNext();) {
			sb.append(iterator.next());
		}

		long endtime = System.currentTimeMillis();
		System.out.println(sb.toString() + "builder cost:" + (endtime - starttime) + " millis");
	}

	public static void main(String[] args) {
		doStringTest();
		doStringBufferTest();
		doStringBuilderTest();

		List<String> list = new ArrayList<String>();
		list.add(" I ");
		list.add(" like ");
		list.add(" BeiJing ");
		list.add(" tian ");
		list.add(" an ");
		list.add(" men ");
		list.add(" . ");

		doStringBufferListTest(list);
		doStringBuilderListTest(list);
	}

}