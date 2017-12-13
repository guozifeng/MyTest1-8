package com.guo.offer.testlistandmap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Person implements Comparable<Person> {
	private int age;
	private String name;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(Person o) {
		return this.name.compareTo(o.name);
	}

	@Override
	public String toString() {
		return name + ":" + age;
	}

	public static void main(String[] args) {
		Person person1 = new Person("one", 18);
		Person person2 = new Person("two", 17);
		Person person3 = new Person("three", 19);

		List<Person> list = new ArrayList<>();
		list.add(person1);
		list.add(person2);
		list.add(person3);

		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
	}
}
