package com.guo.offer.testkeyword;

public class testNull {

	static String abc;

	public testNull() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		String cde = null;

		if (abc == cde) {
			System.out.println("null == null is true in Java");
		}

		if (null != null) {
			System.out.println("null != null is false in Java");
		}

		// classical null check
		if (abc == null) {
			System.out.println("ffff");
		}

		System.out.println("");

	}

}
