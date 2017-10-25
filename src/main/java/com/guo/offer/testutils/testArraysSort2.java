package com.guo.offer.testutils;

import java.util.Arrays;

public class testArraysSort2 implements Comparable {

	private String id;
	private int age;

	public testArraysSort2(String id, int age) {
		this.id = id;
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int compareTo(Object o) {
		return this.age - ((testArraysSort2) o).getAge();
	}

	/**
	 * ≤‚ ‘∑Ω∑®
	 */
	public static void main(String[] args) {
		testArraysSort2[] users = new testArraysSort2[] { new testArraysSort2("a", 30), new testArraysSort2("b", 20) };
		Arrays.sort(users);
		for (int i = 0; i < users.length; i++) {
			testArraysSort2 user = users[i];
			System.out.println(user.getId() + " " + user.getAge());
		}
	}

}