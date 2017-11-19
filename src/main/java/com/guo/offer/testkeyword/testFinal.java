package com.guo.offer.testkeyword;

/**
 * 
 * https://www.cnblogs.com/guoyansi19900907/archive/2015/11/15/4966832.html
 * 
 * @author Administrator
 *
 */
public class testFinal {

	public static void main(String[] args) {
		test1();
	}

	public static void test3() {
		MyClass2 myClass1 = new MyClass2();
		MyClass2 myClass2 = new MyClass2();
		System.out.println(myClass1.i);
		System.out.println(myClass1.i);
		System.out.println(myClass2.i);
		System.out.println(myClass2.i);
		System.out.println("**********************");
		System.out.println(myClass1.j);
		System.out.println(myClass1.j);
		System.out.println(myClass2.j);
		System.out.println(myClass2.j);
	}

	public static void test1() {
		MyClass myClass = new MyClass();
		StringBuffer buffer = new StringBuffer("hello");
		myClass.changeValue(buffer);
		System.out.println(buffer.toString());
		System.out.println();
		final StringBuffer buffer1 = new StringBuffer("hello");
		buffer1.append(" 2121");
		System.out.println(buffer1);
	}

	public static void test2() {
		MyClass1 myClass = new MyClass1();
		int i = 0;
		myClass.changeValue(i);
		System.out.println("main = "+i);
	}
}

class MyClass {

	void changeValue(StringBuffer buffer) { 
		buffer.append(" world");
	}
}

class MyClass1 {

	void changeValue(int i) {
		i++;
		System.out.println(i);
	}
}

class MyClass2 {
	public final double i = Math.random();
	public static double j = Math.random();
}