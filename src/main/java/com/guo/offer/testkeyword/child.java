package com.guo.offer.testkeyword;

public class child extends people {

	people p;

	public child(String name) {
		// TODO Auto-generated constructor stub
		System.out.println(3);
		this.name = name;
		p = new people(name);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		child c = new child("33");
	}

}
