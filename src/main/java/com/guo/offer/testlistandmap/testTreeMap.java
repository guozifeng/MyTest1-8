package com.guo.offer.testlistandmap;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * 此为面试题
 * 
 * @author Administrator
 *
 */
public class testTreeMap {

	public static void main(String[] args) {
		TreeMap<String, String> map = new TreeMap<String, String>();
		map.put("one", "1");
		map.put("two", "2");
		map.put("three", "3");
		a(map);
	}

	private static void a(Map<String, String> map) {
		Collection<?> c = map.entrySet();
		Iterator<?> it = c.iterator();

		while (it.hasNext()) {
			Object o = it.next();
			System.out.println(o.toString());
		}

	}

}
