package com.guo.offer.container;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableTest implements Comparable<ComparableTest> {
	private int age;
	private String name;

	public ComparableTest(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(ComparableTest o) {
		return this.name.compareTo(o.name);
	}

	@Override
	public String toString() {
		return name + ":" + age;
	}

	public static void main(String[] args) {
		ComparableTest person1 = new ComparableTest("one", 18);
		ComparableTest person2 = new ComparableTest("two", 17);
		ComparableTest person3 = new ComparableTest("three", 19);

		List<ComparableTest> list = new ArrayList<>();
		list.add(person1);
		list.add(person2);
		list.add(person3);

		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
	}
}
