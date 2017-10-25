package com.guo.offer.testdatatype;

/**
 * 打印出来是AB B 请看这样两个语句： String x = "abc"; String y = new String("abcd");
 * 
 * 现在来分析一下内存的分配情况。如图：
 * 
 * 可以看出，x与y存在栈中，它们保存了相应对象的引用。第一条语句没有在堆中分配内存，
 * 而是将“abc”保存在常量池中。对于第二条语句，同样会在常量池中有一个“abcd”的字符串，当new时，
 * 会拷贝一份该字符串存放到堆中，于是y指向了堆中的那个“abcd”字符串。不知道polaris有没有讲明白。
 * 如果您明白了，那么做前面那六道题就没什么问题了。 因为：AB B
 * 变量a\b\x\y中存储的是StringBuffer变量的引用而不是一个StringBuffer对象。
 * 根据非基本类型参数传递为引用传递的规则，operate接收的参数只是StringBuffer对象的引用.
 * 因此可以理解为x、a都是指向同一个对象;b、y也是指向同一个StringBuffer对象，
 * 所以x.append(y)将导致x和a同指的StringBuffer对象改变（增加"B"）；
 * 而y=x只是让变量y改变指向为和x相同的StringBuffer对象， 而y原来所指的对象并不会发生任何改变。
 * 所以StringBuffer是引用传递传递的是地址
 * 
 * 而String 虽然也是对象，但其实final类型的所以相当于值传递
 * 
 * @author Administrator
 *
 */
public class TestStringBuffer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer a = new StringBuffer("A");
		StringBuffer b = new StringBuffer("B");
		append(a, b);
		System.out.println(a + " " + b);
	}

	public static void append(StringBuffer a, StringBuffer b) {
		a.append(b);
		b = a;
		System.out.println(a + " " + b);
	}
}
