package com.guo.offer.testdatatype;

/**
 * 
 * @author Administrator
 *
 */
public class b {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * jdk1.7 字符串常量池存在就返回对象，不存在就返回堆对象的引用。
		 */
		// String str2 = "SEUCalvin";//新加的一行代码，其余不变
		String str1 = new String("SEU") + new String("Calvin");
		System.out.println(str1.intern() == str1);
		System.out.println(str1 == "SEUCalvin");
		// System.out.println(str1.intern() == str1);
		System.out.println(str1.intern() == "SEUCalvin");
	}

}
