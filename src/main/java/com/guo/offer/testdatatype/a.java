package com.guo.offer.testdatatype;

/**
 * intern()方法在JDK1.6中的作用是： 比如String s = new String("SEU_Calvin")，
 * 再调用s.intern()，此时返回值还是字符串"SEU_Calvin"， 表面上看起来好像这个方法没什么用处。但实际上，在JDK1.6中它做了个小动作：
 * 检查字符串池里是否存在"SEU_Calvin"这么一个字符串，如果存在，就返回池里的字符串；
 * 如果不存在，该方法会把"SEU_Calvin"添加到字符串池中，然后再返回它的引用。 然而在JDK1.7中却不是这样的，后面会讨论。
 * 
 * 
 * 
 * 
 * 
 * @author Administrator
 *         http://blog.csdn.net/seu_calvin/article/details/52291082
 */

public class a {

	public static void main(String... args) {
		System.out.println("---------------1-----");
		String str2 = "SEUCalvin";// 新加的一行代码，其余不变
		String str1 = new String("SEU") + new String("Calvin");
		// String str1 = new String("SEUCalvin");
		// str1.intern();

		System.out.println(str1.intern() == str1); // false
		System.out.println(str1 == "SEUCalvin");// false
		System.out.println(str1.intern() == "SEUCalvin");// true

		System.out.println("---------------2-----");

		String s = new String("1");
		// s.intern();
		String s2 = "1";
		System.out.println("1" == s2);// true
		// 1.6：s 返回对象 s.intern()返回字符串
		// 1.7：s 返回对象 s.intern()返回字符串
		System.out.println(s == s2);// false
		System.out.println(s.intern() == s2);// true

		System.out.println("-------------3-------");

		// String s5 = "11";
		String s3 = new String("1") + new String("1");
		// s3.intern();
		String s4 = "11";
		// 1.6：s3 返回对象 s3.intern()返回字符串
		// 1.7：s3 返回字符串 s3.intern()返回字符串
		System.out.println("11" == s4);// true
		System.out.println(s3 == s4);// false
		System.out.println(s3.intern() == s4);// true
	}

}