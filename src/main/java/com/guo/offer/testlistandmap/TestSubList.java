package com.guo.offer.testlistandmap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestSubList {

	public static void main(String[] args) {
		test1();
	}

	public static void test1() {
		ArrayList<Integer> test = new ArrayList<Integer>();
		for (int i = 0; i < 5; i++) {
			test.add(i); // auto boxing
		}
		System.out.print("the orginal list: ");
		for (int i = 0; i < test.size(); i++) {
			System.out.print(test.get(i) + " ");
		}
		System.out.println();
		List<Integer> sub = test.subList(2, 4);
		System.out.println(sub);
		// sub.remove(1);
		test.add(23);
		System.out.println(test.size());
		System.out.println(test);

		System.out.println(sub.size());

		System.out.println("the orginal list after sublist modified: ");
		for (int i = 0; i < test.size(); i++) {
			test.remove(i);
			System.out.println(test.get(i) + " ");
		}
		System.out.println("2323" + test);
	}

	public static void test2() {
		List<String> list = new ArrayList<>();

		list.add("d");
		list.add("33");
		list.add("44");
		list.add("55");
		list.add("66");

		List<String> list2 = list.subList(0, 2);
		ArrayList<String> a = new ArrayList<String>();
		a = (ArrayList<String>) list2;
		System.out.println(a);
		list2.add("77");

		List<Object> tempList = new ArrayList<Object>(list.subList(0, list.size()));
		tempList.add("xxxxx");
		System.out.println(tempList.size());// 3

		System.out.println(list.size());// 6
		System.out.println(list2.size());// 3
	}

	public static void test3() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(2);
		Iterator<Integer> iterator = list.iterator();
		while (iterator.hasNext()) {
			Integer integer = iterator.next();
			System.out.println(integer);
			if (integer == 2) {
				// list.remove(integer);
				iterator.remove();
			}
		}
		System.out.println(list);
	}

	public static void test4() {
		List<String> a = new ArrayList<String>();
		a.add("1");
		a.add("2");
		for (String temp : a) {
			if ("2".equals(temp)) {
				a.remove(temp);
			}
		}
	}
}
