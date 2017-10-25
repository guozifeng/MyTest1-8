package com.guo.offer.commons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class testToArray {

	public static void main(String[] args) {

		List<String> list = new ArrayList<String>(2);
		list.add("guan");
		list.add("bao");
		String[] array = new String[list.size()];
		array = list.toArray(array);
		System.out.println(array[0]);
		System.out.println(array[1]);
		
		
		/**
		 * 直接使用 toArray 无参方法存在问题，此方法返回值只能是 Object[]类，若强转其它
		 * 类型数组将出现 ClassCastException 错误
		 */
		Object[] array1 = new String[list.size()];
		array1 = (Object[]) list.toArray();
		System.out.println(array1[0]);
		System.out.println(array1[1]);
		
	}

}
