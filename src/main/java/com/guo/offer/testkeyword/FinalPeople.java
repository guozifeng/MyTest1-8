package com.guo.offer.testkeyword;

public class FinalPeople {

	final String name = "guo";

	public FinalPeople() {
		// TODO Auto-generated constructor stub
		System.out.println(1);
	}

	@Override
    public String toString() {
        return "people [name=" + name + "]";
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
